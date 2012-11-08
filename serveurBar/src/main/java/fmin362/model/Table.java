package fmin362.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Table
        implements Serializable
{

    private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
	
	@OneToMany
	private Commande commande;
	
    public Table()
    {
        // Constructeur par défaut nécessaire pour JPA
    }


	public Table(Long numTab) {
		super();
		this.id = numTab;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}



    
}

