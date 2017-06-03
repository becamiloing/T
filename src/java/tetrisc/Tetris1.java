package tetrisc;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Christian Plazas  y Cristian Martínez
 * @version 0.0.1.1
 */
@Path("tetriminoT")
public class Tetris1 {

    @Context
    private UriInfo context;
    private Tetrimino1 o = new Tetrimino1();
    
      /**
 * Arrancar Modulo
 *
 * @author Christian Plazas  y Cristian Martínez
 * forma de pedir Giro a la izquierda con comando sin comillas "izquierdaG"
 */
    
    
    public Tetris1() {
    o.iniciarFicha();
      /**
 * Arrancar Modulo
 *
 * @author Christian Plazas  y Cristian Martínez
 * forma de pedir Giro a la izquierda con comando sin comillas "izquierdaG"
 */
    
    }

    /**
     *
     * @param accion
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getCity(@QueryParam("accion")String accion){
	
	Response rpt	= null;
	String txt[][]	= o.getT();
	
	if(accion != null && accion.length() > 0){
	    switch (accion) {
		case "izquierdaG":
                    
                    /**
 * Metodo de Girar a la izquierda
 *
 * @author Christian Plazas  y Cristian Martínez
 * forma de pedir Giro a la izquierda con comando sin comillas "izquierdaG"
 */

		    o.girarIzquierda();
		    break;

		case "derechaG":
 /**
 * Metodo de Girar a la derecha
 *
 * @author Christian Plazas  y Cristian Martínez
 * forma de pedir Giro a la izquierda con comando sin comillas "derechaG"
 */                   

		    o.girarDerecha();
		    break;

		case "bajar":
                    
                    /**
 * Metodo para bajar
 * @author Christian Plazas  y Cristian Martínez
 * bajar figura una posición ""bajar" si comillas
 */

                   
  
		    o.bajar();
		    break;
		default:

		    break;

	    }
	}
	JsonObjectBuilder json	= Json.createObjectBuilder();
	   
	for(int i = 0; i < txt.length; i++){
	    JsonObjectBuilder json1	= Json.createObjectBuilder();
	    
	    for(int j = 0; j < txt[0].length; j++){
		json1.add(Integer.toString(j), txt[i][j]);
	    }
	    json.add(Integer.toString(i),json1);
	}
	
	JsonObject jsonobj = json.build();
	
	rpt =  Response.ok(jsonobj.toString())
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")//metodos de como se pueden enviar y traer datos
		.header("Access-Control-Allow-Headers", "Content-type, Accept, X-Requested-With").build();
	
	return rpt;
	
    }
    /**
     * PUT method for updating or creating an instance of Tetris1
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
