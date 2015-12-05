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

public class Api
{
    private ServerConnection sc;

    public Api()
    {
        sc = new ServerConnection();
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

    public Game getGameByGameID(int gameID)
    {
        String jsonData = sc.get("game/" + gameID + "/");
        Game game = new Gson().fromJson(jsonData, new TypeToken<Game>() {
        }.getType());

        return game;
    }

    public String deleteGame(int gameID)
    {
        String jsonData = sc.delete("games/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }

    public ArrayList<Score> getHighscores()
    {
        String jsonData = sc.get("highscores/");

        ArrayList<Score> scores = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>() {
        }.getType());

        return scores;
    }


}
