package fmin362.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fmin362.model.Categorie;
import fmin362.model.Commande;
import fmin362.model.Produit;

@Path("/getMenu")
public class Demo {
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public String demo(){
		String tmp="";
		List<Produit> liste=new ArrayList<Produit>();
		Produit p1=new Produit();
		Produit p2=new Produit();
		Produit p3=new Produit();
		
		p1.setNom("Biere");
		p2.setNom("Coca");
		p3.setNom("Lasagne");
		
		p1.setCategorie(new Categorie("Boisson alcoolisee"));
		p2.setCategorie(new Categorie("Boisson non alcoolisee"));
		p3.setCategorie(new Categorie("Plat chaud"));
		
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		
		for(int i=0;i<liste.size();i++){
			tmp+=liste.get(i).getNom()+"    "+liste.get(i).getCategorie().getNom()+"  \n";
		}
		
		return tmp;
		

}

}
