package fmin362.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fmin362.model.Categorie;
import fmin362.model.Commande;

@Path( "/menu/{categorie}" )
public class MenuCategorieResource {
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Categorie categorie(){
		return null;
		//TODO	
		
	}

}
