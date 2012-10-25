package fmin362.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fmin362.model.Produit;

@Path( "/menu" )
public class MenuResource {
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Produit> menu(){
		Produit p1=new Produit();
		p1.setNom("Bière");
		Produit p2=new Produit();
		p2.setNom("Coca");
		List<Produit> liste=new ArrayList<Produit>();
		liste.add(p1);
		liste.add(p2);
		return liste;
		
		
		//TODO		
		
		
	}

}
