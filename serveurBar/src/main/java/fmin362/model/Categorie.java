package fmin362.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	
	@Id
	private Long numCat;
	
	@Column
    private String nom;
	
	

	@OneToMany(mappedBy="categorie")
    private List<Produit> produit; 
	
	@Override
	public String toString() {
		return "Categorie [numCat=" + numCat + ", nom=" + nom + ", produit="
				+ produit + "]";
	}

	public Categorie()
    {
        // Constructeur par défaut nécessaire pour JPA
    }
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Long getNumCat() {
		return numCat;
	}

	public void setNumCat(Long numCat) {
		this.numCat = numCat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	
}
