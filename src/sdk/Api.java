package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    //-------------------------------------------------------------------------------------------

    public ArrayList<Game> getGames(int userID)
    {
        String jsonData = sc.get("games/" + userID +"/");

        ArrayList<Game> Games = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());

        return Games;
    }

    public String deleteGame(Game game, int gameID)
    {
        String jsonData = sc.delete(new Gson().toJson(game), "/games/" + gameID + "/");

        return sc.stringMessageParser(jsonData);
    }

}
