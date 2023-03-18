package org.acme.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.acme.model.Documento;


/**
 * Clase interface.
 */
@Path("/api")
public interface GreetingResource {

    // http://localhost:8080/api/hello
    /**
     * Método para imprimir un mensaje de saludo.
     * @return hello()
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/hello")
    public String hello();

    // http://localhost:8080/api/programador
    /**
     * Método para recuperar información de un Programador.
     * 
     * @return getProgramador().
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/programador")
    public Response getProgramador();

    // http://localhost:8080/api/documentos
    /**
     * Método para recuperar una lista de Documentos.
     * 
     * @return getDocumentos().
     */
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response getDocumentos();

    // http://localhost:8080/api/documentos
    /**
     * Método para agregar un nuevo Documento.
     * 
     * @param documento
     *        Documento a crear.
     * @return addDocumento(Documento documento).
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response addDocumento(Documento documento);

    // http://localhost:8080/api/documentos
    /**
     * Método para eliminar un Documento.
     * 
     * @param documento
     *        Documento a eliminar.
     * @return deleteDocumento(Documento documento).
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/documentos")
    public Response deleteDocumento(Documento documento);

}