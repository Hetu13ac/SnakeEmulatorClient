package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class is exactly the same as the Game.class from the server
 * This class represent an object of Game and contains the variables that Game object must have
 */

import java.sql.Date;

import java.sql.Date;


public class Game
{
    //Creating the variables needed for the game
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;

    public Game()
    {

    }

    /**
     * This method gets the date of creation from game
     * @return created
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * This method is setting the creation date for a game
     * @param created The creation date of a game
     */
    public void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * This method gets the map size from a game
     * @return mapSize
     */
    public int getMapSize()
    {
        return mapSize;
    }

    /**
     * This method is setting the map size of a game
     * @param mapSize Sets map size of a game
     */
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    /**
     * This method gets the name from a game
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method is setting the name of a game
     * @param name The game name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets Game ID from a game
     * @return gameId
     */
    public int getGameId(){
        return gameId;
    }

    /**
     * This method is setting Game ID of a game
     * @param gameId Sets game id
     */
    public void setGameId(int gameId){
        this.gameId = gameId;
    }

    /**
     * This method gets an object of Gamer as host
     * @return host
     */
    public Gamer getHost(){
        return host;
    }

    /**
     * This method is setting host of a game
     * @param host Sets the host of game
     */
    public void setHost(Gamer host)
    {
        this.host = host;
    }

    /**
     * This method gets an object of Gamer as opponent
     * @return opponent
     */
    public Gamer getOpponent()
    {
        return opponent;
    }

    /**
     * This method is setting the opponent of a game from an object of Gamer
     * @param opponent
     */
    public void setOpponent(Gamer opponent)
    {
        this.opponent = opponent;
    }

    /**
     * This method gets game status: open, pending, finished or deleted.
     * @return status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * This method is setting status for a game
     * @param status Sets the status of a game: open, pending, finished or deleted
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * This method gets an object of Gamer as Winner
     * @return winner
     */
    public Gamer getWinner() {
        return winner;
    }

    /**
     * This method is setting the winner of a game
     * @param winner Setting the winner with an object of Gamer
     */
    public void setWinner(Gamer winner) {
        this.winner = winner;
    }
} //end of class
