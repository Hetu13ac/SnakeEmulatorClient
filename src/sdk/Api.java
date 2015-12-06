package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This Api.class handles the different requests and path that we are calling from the server.
 * We use this class to get connected to the Api.class on the server
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Api
{
    //Declaring a variable
    private ServerConnection sc;

    /**
     * Constructor of the class
     */
    public Api()
    {
        sc = new ServerConnection();
    }

    /**
     * This method is used to login on the server and are posting an object of User in Gson format to Json format
     * @param user Posting an object of user
     * @return sc.stringMessageParser(jsonData)
     */
    public String login(User user)
    {
        String jsonData = sc.post(new Gson().toJson(user), "login/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method is used to create a new user on the server
     * and posting an object of User in Gson format to Json format
     * @param user Posting an object of user
     * @return sc.stringMessageParser(jsonData)
     */
    public String createUser(User user)
    {
        String jsonData = sc.post(new Gson().toJson(user), "users/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method use a get-request on the path "users/" and get all the users from the server and make an ArrayList of User
     * @return users
     */
    public ArrayList<User> getUsers()
    {
        String jsonData = sc.get("users/");

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {}.getType());

        return users;
    }

    /**
     * This method is used for create a game
     * and sending a post-request, it sends an object of Game in Gson format to Json format
     * @param game Object of game that are being posted
     * @return sc.stringMessageParser(jsonData)
     */
    public String createGame(Game game)
    {
        String jsonData = sc.post(new Gson().toJson(game), "games/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method is used for join a game
     * and sending a put-request, it sends an object of Game in Gson format to Json format, and add it to an existing object.
     * @param game Object of game that are being putted
     * @return sc.stringMessageParser(jsonData)
     */
    public String joinGame(Game game)
    {
        String jsonData = sc.put(new Gson().toJson(game), "games/join/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method is used for start a game
     * and sending a put-request, it sends an object of Game in Gson format to Json format, and add it to an existing object.
     * @param game Object of game that are being putted
     * @return sc.stringMessageParser(jsonData)
     */
    public String startGame(Game game)
    {
        String jsonData = sc.put(new Gson().toJson(game), "games/start/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method use a get-request on the path "games/open/" and get all the open games from the server and make an ArrayList of Games
     * @return openGames
     */
    public ArrayList<Game> getOpenGames()
    {
        String jsonData = sc.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return openGames;
    }

    /**
     * This method is used to get a specific object of Game by gameID.
     * The object from the server comes in json format and the method is parsing it to Gson
     * @param gameID The game ID of the object that we want from the server
     * @return game
     */
    public Game getGameByGameID(int gameID)
    {
        String jsonData = sc.get("game/" + gameID + "/");
        Game game = new Gson().fromJson(jsonData, new TypeToken<Game>() {
        }.getType());

        return game;
    }

    /**
     * This method is used to delete a game from the server
     * The method is sending a delete-request.
     * @param gameID The ID of the game that user want to delete
     * @return sc.stringMessageParser(jsonData)
     */
    public String deleteGame(int gameID)
    {
        String jsonData = sc.delete("games/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }

    /**
     * This method use a get-request on the path "highscores/" and get top 10 high scores from the server
     * The server sends a list of top 10 highscores in json to Gson and this method are making an ArrayList out of it
     * @return scores
     */
    public ArrayList<Score> getHighscores()
    {
        String jsonData = sc.get("highscores/");

        ArrayList<Score> scores = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>() {
        }.getType());

        return scores;
    }


}
