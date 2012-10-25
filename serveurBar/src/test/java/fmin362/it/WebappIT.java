package fmin362.it;

import junit.framework.TestCase;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.net.URL;
import java.net.HttpURLConnection;
import org.junit.Test;

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

    @Test
    public void testContext() throws Exception
    {
        //test la connection
        URL url = new URL(this.baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());
    }

    @Test
    public void testMenu() throws Exception
    {
        //test la connection
        URL url = new URL(this.baseUrl + "/menu");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());

        //test du contenu du menu

       
    }
}
