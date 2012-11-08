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
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long id;
	
	@Column
    private String nom;
	
	
	public Categorie()
    {
        // Constructeur par défaut nécessaire pour JPA
    }
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long numCat) {
		this.id = numCat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	
	
}
