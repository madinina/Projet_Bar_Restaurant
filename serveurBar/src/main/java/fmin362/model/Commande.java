package fmin362.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commande
        
{



    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;


 
    @ManyToOne
    private Table table; 
   


	public Commande()
    {
        // Constructeur par défaut nécessaire pour JPA
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Table getTable() {
		return table;
	}



	public void setTable(Table table) {
		this.table = table;
	}



	public Commande(Long numCom, Table table) {
		super();
		this.id = numCom;
		this.table = table;
	}



    
}
