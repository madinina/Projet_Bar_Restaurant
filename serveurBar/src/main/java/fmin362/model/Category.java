package fmin362.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category
    implements Serializable
{

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
    private String name;
    @OneToMany( cascade = CascadeType.PERSIST )
    private List<Product> products = new ArrayList<Product>();

    public Category()
    {
        // NOOP
    }

    public Category( String name )
    {
        this();
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Product> getProducts()
    {
        return products;
    }

}
