package fmin362.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fmin362.model.Commande;

@Path( "/commande" )
public class CommandeResource {
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Commande commande(){
		return null;
		//TODO	
		
	}
	

}
