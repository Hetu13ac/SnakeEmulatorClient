package sdk;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class handles the connection to the server.
 * We use JSon to communicate with the server with various requests as get, post, put & delete
 */
public class ServerConnection
{
    //Declaring variables used in this class
    private String hostAddress;
    private int port;

    /**
     * Constructor of the class
     */
    public ServerConnection()
    {
        //Initializing the variables
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    /**
     * This method gets the host adress
     * @return hostAdress
     */
    public String getHostAddress()
    {
        return hostAddress;
    }

    /**
     * This method gets the port number
     * @return port
     */
    public int getPort()
    {
        return port;
    }

    /**
     * This method is used when we need to get objects from the server.
     * @param path The path to get access to what we want to get from the server
     * @return ""
     */
    public String get(String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        if (response != null)
        {
            return response.getEntity(String.class);
        }
        return "";
    }

    /**
     * This method is for posting something on the server
     * @param json Object that we are posting on the server in json format
     * @param path The path to get access to what we want to post on the server
     * @return ""
     */
    public String post(String json, String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        if (response != null)
        {
            return response.getEntity(String.class);
        }
        return "";
    }

    /**
     * This method is for putting (or adding) something on an existing object i json format
     * @param json Object that we are putting on the server in json format
     * @param path The path to get access to what we want to put on the server
     * @return ""
     */
    public String put(String json, String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        if (response != null)
        {
            return response.getEntity(String.class);
        }
        return "";
    }

    /**
     * This method is for deleting on the server
     * @param path The path to get access to what we want to delete on the server
     * @return
     */
    public String delete(String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        if (response != null)
        {
            return response.getEntity(String.class);
        }

        return "";
    }

    /**
     * This method is used for converting the message received from the server into a String
     * @param json The object in json format contains a message that we need to parse into a String
     * @return "";
     */
    public String stringMessageParser(String json)
    {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try
        {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return message;

    }
}