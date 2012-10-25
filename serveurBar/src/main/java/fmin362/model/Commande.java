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
    private Long numCom;


 
    @ManyToOne
    private Table table; 
   
    

    

    public Commande()
    {
        // Constructeur par défaut nécessaire pour JPA
    }



    
}
