package fmin362.it;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import fmin362.values.Menu;
import java.net.URL;
import javax.ws.rs.core.MediaType;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WebappIT
    extends TestCase
{

    private WebResource rootResource;

    @Before
    @Override
    public void setUp()
        throws Exception
    {
        super.setUp();

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );
        Client client = Client.create( clientConfig );

        URL url = new URL( "http://127.0.0.1:" + System.getProperty( "servlet.port" ) + "/serveurBar" );
        rootResource = client.resource( url.toURI() );
    }

    @Test
    public void testMenu()
        throws Exception
    {
        WebResource menuResource = rootResource.path( "menu" );

        // Récupération du JSON brut
        String json = menuResource.accept( MediaType.APPLICATION_JSON ).get( String.class );
        System.out.println( "#########################" );
        System.out.println( json );
        System.out.println( "#########################" );

        // Récupération d'un objet java déserializé depuis le JSON
        Menu menu = menuResource.accept( MediaType.APPLICATION_JSON ).get( Menu.class );
        assertThat( menu.countCategories(), equalTo( 7 ) );
        assertThat( menu.countProducts(), equalTo( 35 ) );
    }

}
