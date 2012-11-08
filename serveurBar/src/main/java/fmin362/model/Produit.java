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
    private Long codeProd;
    
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
		this.codeProd = codeProd;
		this.nom = nom;
		this.prix = prix;
		this.contenance = contenance;
		this.categorie = categorie;
	}



	public Long getCodeProd() {
		return codeProd;
	}



	public void setCodeProd(Long codeProd) {
		this.codeProd = codeProd;
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
