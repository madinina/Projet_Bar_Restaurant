package fmin362.it;

import junit.framework.TestCase;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.net.URL;
import java.net.HttpURLConnection;
import org.junit.Test;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import fmin362.*;

public class WebappIT extends TestCase
{
    private String baseUrl;

    @Test
    public void setUp() throws Exception
    {
        super.setUp();
        String port = System.getProperty("servlet.port");
        this.baseUrl = "http://localhost:" + port + "/serveurBar";
    }

    /*@Test
    public void testContext() throws Exception
    {
        //test la connection
        URL url = new URL(this.baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());
    }*/// commenté car pas d'index

    @Before
    @Test
    public void testMenu() throws Exception
    {
        //test la connection
        URL url = new URL(this.baseUrl + "/menu");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());

        //test du contenu du menu
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );
        Client client = Client.create( clientConfig );
        WebResource webResource = client.resource( url.toURI() );

        List<Map<String,?>> result = webResource.get( List.class );
        System.out.println( result );

        assertEquals( true, result.size()>1 );//on suppose qu'il y ait plus de 1 elt dans la table
        assertNotNull(result.get(0).get("nom"));//on suppose que le premier elt de la table est non null
        //assertNotNull(result.get(0).get("contenance"));//on suppose que le premier elt de la table est non null
        //assertNotNull(result.get(0).get("prix"));//on suppose que le premier elt de la table est non null
        assertNotNull(result.get(0).get("categorie"));//on suppose que le premier elt de la table est non null

    }

    @Test
    public void testProduits() throws Exception
    {

        //test la connection
        URL url = new URL(this.baseUrl + "/menu");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());

        //test du contenu du menu
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );
        Client client = Client.create( clientConfig );
        WebResource webResource = client.resource( url.toURI() );

        List<Map<String,?>> result = webResource.get( List.class );
        
        System.out.println(result);
        assertEquals("Boisson_alcoolisee", ((Map)result.get(0).get("categorie")).get("nom"));
        assertEquals("Boisson_non_alcoolisee", ((Map)result.get(1).get("categorie")).get("nom"));
        assertEquals("Plat_chaud", ((Map)result.get(2).get("categorie")).get("nom"));
                
        assertEquals("Bière", result.get(0).get("nom"));
        assertEquals("Coca", result.get(1).get("nom"));
        assertEquals("Lasagne", result.get(2).get("nom"));
    }


}
