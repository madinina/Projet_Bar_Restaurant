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
		
		List<Produit> liste=new ArrayList<Produit>();
		Produit p1=new Produit();
		Produit p2=new Produit();
		Produit p3=new Produit();
		
		p1.setNom("Bière");
		p2.setNom("Coca");
		p3.setNom("Lasagne");
		
		p1.setCategorie(new Categorie("Boisson alcolisée"));
		p2.setCategorie(new Categorie("Boisson  non alcolisée"));
		p3.setCategorie(new Categorie("Plat chaud"));
		
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		return liste;
		
		
		//TODO		
		
		
	}

}
