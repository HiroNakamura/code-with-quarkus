package org.acme.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.acme.MyConfig;
import org.acme.model.Documento;
import org.acme.resource.GreetingResource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * Clase controller.
 */
public class GreetingController implements GreetingResource {
    private final static Logger LOG = Logger.getLogger(GreetingController.class);

    
    @ConfigProperty(name="greeting.mensaje")
    String mensaje;

    @Inject
    MyConfig myConfig;

    private Set<Documento> documentos = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public GreetingController(){
        documentos.add(new Documento(1,"Informe pelicano", "DOCX", false));
        documentos.add(new Documento(2,"Cartas sociales", "XML", true));
        documentos.add(new Documento(3,"Extensiones y aplicaciones de controladores PIC", "PDF", false));
    }



    // http://localhost:8080/api/hello
    @Override
    public String hello() {
        LOG.info(mensaje);
        if(myConfig.isTrue()){
            LOG.info("Hola, "+myConfig.nombre());
        }
        return mensaje;
    }

    // http://localhost:8080/api/programador
    @Override
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
    @Override
    public Response getDocumentos(){
        LOG.info("Recuperamos los documentos");
        return Response.ok(this.documentos).build();
    }

    // http://localhost:8080/api/documentos
    @Override
    public Response addDocumento(Documento documento) {
        LOG.info("Agregamos: "+documento);
        this.documentos.add(documento);
        LOG.info("Agregamos: "+this.documentos);
        return Response.ok(this.documentos).build();
    }

    // http://localhost:8080/api/documentos
    @Override
    public Response deleteDocumento(Documento documento) {
        LOG.info("Eliminamos: "+documento);
        this.documentos.removeIf(existingDoc -> existingDoc.nombre.contentEquals(documento.nombre));
        return Response.ok(this.documentos).build();
    }
}
