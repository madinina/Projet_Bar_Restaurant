package fmin362.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Produit
  
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long CodeProd;
    
    @Column
    private Long Nom;
    
    @Column
    private Long Prix;
    
    @Column
    private Long Composant  ;
    


    public Produit()
    {
        // Constructeur par défaut nécessaire pour JPA
    }



    
}
