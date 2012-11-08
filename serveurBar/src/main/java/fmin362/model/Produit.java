package fmin362.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Produit
  
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
    
    @Column
    private String nom;
    
    @Column
    private Long prix;
    
    @Column
    private Long contenance  ;
    
    @ManyToOne
    private Categorie categorie;

    public Produit()
    {
        // Constructeur par défaut nécessaire pour JPA
    }



	public Produit(Long codeProd, String nom, Long prix, Long contenance,
			Categorie categorie) {
		super();
		this.id = codeProd;
		this.nom = nom;
		this.prix = prix;
		this.contenance = contenance;
		this.categorie = categorie;
	}

	

	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long codeProd) {
		this.id = codeProd;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Long getPrix() {
		return prix;
	}



	public void setPrix(Long prix) {
		this.prix = prix;
	}



	public Long getContenance() {
		return contenance;
	}



	public void setContenance(Long contenance) {
		this.contenance = contenance;
	}



    
}
