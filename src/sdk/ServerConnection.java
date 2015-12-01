package sdk;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by HenrikTuyen on 30/11/15.
 */
public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

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

    public String delete(String json, String path)
    {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class, json);

        if (response != null)
        {
            return response.getEntity(String.class);
        }
        return "";
    }

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