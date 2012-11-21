package fmin362.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product
    implements Serializable
{

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
    private String name;
    private Float price;
    private Integer quantity;
    private String quantityUnit;
    @ManyToOne
    private Category category;

    public Product()
    {
        // NOOP
    }

    public Product( Category category, String name, Float price )
    {
        this( category, name, price, null, null );
    }

    public Product( Category category, String name, Float price, Integer quantity )
    {
        this( category, name, price, quantity, null );
    }

    public Product( Category category, String name, Float price, Integer quantity, String quantityUnit )
    {
        this();
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public String getName()
    {
        return name;
    }

    public Float getPrice()
    {
        return price;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public String getQuantityUnit()
    {
        return quantityUnit;
    }

}
