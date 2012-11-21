package fmin362.values;

import fmin362.model.Category;
import java.util.ArrayList;
import java.util.List;

public class Menu
{

    private final List<Category> categories;

    public Menu()
    {
        this.categories = new ArrayList<Category>();
    }

    public Menu( List<Category> categories )
    {
        this.categories = categories;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public int countCategories()
    {
        return categories.size();
    }

    public int countProducts()
    {
        int count = 0;
        for( Category category : categories )
        {
            count += category.getProducts().size();
        }
        return count;
    }

}
