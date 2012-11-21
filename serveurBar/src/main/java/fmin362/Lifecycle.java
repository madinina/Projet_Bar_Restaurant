package fmin362;

import fmin362.model.Category;
import fmin362.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.UserTransaction;

import static java.lang.System.out;

/**
 * ServletContextListener est appelé au démarrage et à l'arret de l'application.
 *
 * Si le jeu de données n'existe pas en base on l'y insère.
 */
public class Lifecycle
    implements ServletContextListener
{

    @Resource
    private UserTransaction utx;
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public void contextInitialized( ServletContextEvent sce )
    {
        out.println( "RestoFX Server STARTING" );

        if( emf == null )
        {
            throw new RuntimeException( "JPA Persistence Unit is not properly setup!" );
        }

        EntityManager em = emf.createEntityManager();

        try
        {
            utx.begin();
            em.joinTransaction();
            if( em.createQuery( "select c from Category c" ).getResultList().isEmpty() )
            {
                List<Category> categories = createCategories();
                for( Category category : categories )
                {
                    em.persist( category );
                }
                utx.commit();
            }
        }
        catch( Exception ex )
        {
            try
            {
                utx.setRollbackOnly();
            }
            catch( Exception rollbackEx )
            {
                // Impossible d'annuler les changements, vous devriez logguer une erreur,
                // voir envoyer un email à l'exploitant de l'application.
            }
            throw new RuntimeException( ex.getMessage(), ex );
        }
        finally
        {
            if( em != null )
            {
                em.close();
            }
        }

        out.println( "RestoFX Server STARTED" );
    }

    @Override
    public void contextDestroyed( ServletContextEvent sce )
    {
        out.println( "RestoFX Server STOPPED" );
    }

    private List<Category> createCategories()
    {
        // Catégories
        Category softs = new Category( "Softs" );
        Category bieres = new Category( "Bières" );
        Category cocktails = new Category( "Cocktails" );
        Category boissonsChaudes = new Category( "Boissons chaudes" );
        Category entrees = new Category( "Entrées" );
        Category plats = new Category( "Plats" );
        Category desserts = new Category( "Desserts" );

        // Produits
        softs.getProducts().add( new Product( softs, "Lait fraise", 2.40F, 25, "cl" ) );
        softs.getProducts().add( new Product( softs, "Jus de tomate", 2.80F, 25, "cl" ) );
        softs.getProducts().add( new Product( softs, "Diabolo menthe", 2.20F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Blonde", 2.35F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Brune", 2.40F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Ambrée", 2.40F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Rousse", 2.45F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Blanche", 2.40F, 25, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Blonde (Pinte)", 2.35F, 50, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Brune (Pinte)", 2.40F, 50, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Ambrée (Pinte)", 2.40F, 50, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Rousse (Pinte)", 2.45F, 50, "cl" ) );
        bieres.getProducts().add( new Product( bieres, "Blanche (Pinte)", 2.40F, 50, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "Mojito", 5F, 33, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "Cuba Libre", 5F, 33, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "Long Island", 5F, 33, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "White Russian", 5F, 33, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "Punch Coco", 5F, 33, "cl" ) );
        cocktails.getProducts().add( new Product( cocktails, "Tequila Sunrise", 5F, 33, "cl" ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Thé noir", 3F ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Thé vert", 3F ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Thé rouge", 3F ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Café", 1.35F ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Café double", 2.35F ) );
        boissonsChaudes.getProducts().add( new Product( boissonsChaudes, "Café crème", 2.55F ) );
        entrees.getProducts().add( new Product( entrees, "Oeuf mayo", 1.50F ) );
        entrees.getProducts().add( new Product( entrees, "Avocat crevette", 2F ) );
        entrees.getProducts().add( new Product( entrees, "Terrine de lapin", 3.80F ) );
        plats.getProducts().add( new Product( plats, "Couscous royal", 13F ) );
        plats.getProducts().add( new Product( plats, "Cassoulet", 12F ) );
        plats.getProducts().add( new Product( plats, "Raie au beurre noir", 14F ) );
        plats.getProducts().add( new Product( plats, "Bouillabaisse", 16F ) );
        desserts.getProducts().add( new Product( desserts, "Banana split", 4.8F ) );
        desserts.getProducts().add( new Product( desserts, "Profiterolles", 5.2F, 3 ) );
        desserts.getProducts().add( new Product( desserts, "Colonel", 4.9F ) );

        List<Category> categories = new ArrayList<Category>();
        categories.add( softs );
        categories.add( bieres );
        categories.add( cocktails );
        categories.add( boissonsChaudes );
        categories.add( entrees );
        categories.add( plats );
        categories.add( desserts );

        return categories;
    }

}
