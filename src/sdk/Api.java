package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
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

/**
 * Created by HenrikTuyen on 19/11/15.
 */

public class Api {

    private ServerConnection sc;

    public Api() {
        sc = new ServerConnection();
    }

    public ArrayList<Score> getHighscores() {
        String jsonData = sc.get("scores/");

        ArrayList<Score> scores = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>() {
        }.getType());

        return scores;
    }

    public ArrayList<User> getUsers() {
        String jsonData = sc.get("users/");

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>() {

        }.getType());

        return users;
    }

    public String createGame(Game game)
    {
        String jsonData = sc.post(new Gson().toJson(game), "games/");

        return sc.stringMessageParser(jsonData);
    }


    //--------------------------------------------------------------------------------------------------------------

    public String joinGame(Game game)
    {
        String jsonData = sc.put(new Gson().toJson(game), "games/join/");

        return sc.stringMessageParser(jsonData);
    }


    public String startGame(Game game)
    {
        String jsonData = sc.put(new Gson().toJson(game), "games/start/");

        return sc.stringMessageParser(jsonData);
    }

    public ArrayList<Game> getOpenGames()
    {
        String jsonData = sc.get("games/open/");

        ArrayList<Game> openGames = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return openGames;
    }

    //--------------------------------------------------------------------------------------------------------------

    public String deleteGame(int gameID)
    {
        String jsonData = sc.delete("games/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }

    /*
    @GET //"GET-request"
    @Path("/game/{gameid}")
    @Produces("application/json")
    public String getGame(@PathParam("gameid") int gameid) {

        Game game = Logic.getGame(gameid);
        return new Gson().toJson(game);
    }*/

    /*public  String getGameByID(int gameID)
    {
        String jsonData = sc.get("game/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }*/

    public Game getGameByGameID(int gameID)
    {
        String jsonData = sc.get("game/" + gameID + "/");
        Game game = new Gson().fromJson(jsonData, new TypeToken<Game>() {
        }.getType());

        return game;
    }





















    //Se bort fra det her-------------------------------------------------------------------------------------------

    /*public ArrayList<Game> getGamesByUserID(int userID)
    {
        String jsonData = sc.get("games/" + userID +"/");

        ArrayList<Game> Games = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return Games;
    }

    public String deleteGame(Game game, int gameID)
    {
        String jsonData = sc.delete(new Gson().toJson(game), "game/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }

    //-------------------------------------------------------------------------------------------

    public ArrayList<Game> getGamesByGameID(int gameID)
    {
        String jsonData = sc.get("games/" + gameID +"/");

        ArrayList<Game> Games = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return Games;
    }

    /*public String getGameByGameID(int gameID)
    {
        String jsonData = sc.get("game/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }*/




}
