package org.acme;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


@Path("/api")
public class GreetingResource {

    private final static Logger LOG = Logger.getLogger(GreetingResource.class);

    @ConfigProperty(name="greeting.mensaje")
    String mensaje;

    @Inject
    MyConfig myConfig;

    private Set<Documento> documentos = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public GreetingResource(){
        documentos.add(new Documento("Informe pelicano", "DOCX", false));
        documentos.add(new Documento("Cartas sociales", "XML", true));
        documentos.add(new Documento("Extensiones y aplicaciones de controladores PIC", "PDF", false));
    }

    // http://localhost:8080/api/hello
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/hello")
    public String hello() {
        LOG.info(mensaje);
        if(myConfig.isTrue()){
            LOG.info("Hola, "+myConfig.nombre());
        }
        return mensaje;
    }

    // http://localhost:8080/api/programador
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/programador")
    public Response getProgramador(){
        Map<String,Object> mapa = new HashMap<>();
        mapa.put("nombre", "Fernando");
        mapa.put("apellidos","Carraro Aguirre");
        mapa.put("edad","40");
        mapa.put("lenguajes", Arrays.asList("Java","Python","C","Rust","Golang","Perl") );
        LOG.info("Programador: "+mapa.toString());
        return Response.ok(mapa).build();
    }

    // http://localhost:8080/api/documentos
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response getDocumentos(){
        LOG.info("Recuperamos los documentos");
        return Response.ok(this.documentos).build();
    }

    // http://localhost:8080/api/documentos
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response addDocumento(Documento documento) {
        LOG.info("Agregamos: "+documento);
        this.documentos.add(documento);
        LOG.info("Agregamos: "+this.documentos);
        return Response.ok(this.documentos).build();
    }

    // http://localhost:8080/api/documentos
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response deleteDocumento(Documento documento) {
        LOG.info("Eliminamos: "+documento);
        this.documentos.removeIf(existingDoc -> existingDoc.nombre.contentEquals(documento.nombre));
        return Response.ok(this.documentos).build();
    }

    // 




}