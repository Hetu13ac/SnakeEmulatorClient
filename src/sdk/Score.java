package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class is exactly the same as the Score.class from the server
 * This class represent an object of Score from a game and contains the variables that Score object must have
 */

// Creates class Score
public class Score {

    // Declare highScore
    private int id;
    private Gamer user;
    private Gamer opponent;
    private Game game;
    private int score;

    //TODO: Kan slettes?! Bruges ikke i wrapper længere.
    // Creates constructor
    public Score(int id, Gamer user, Game game, Gamer opponent, int score)
    {
        this.id = id;
        this.user = user;
        this.game = game;
        this.opponent = opponent;
        this.score = score;
    }

    public Score(){}

    // Creates get method which returns the highScore

    /**
     * This method gets an object of Gamer and returning the object as opponent
     * @return opponent
     */
    public Gamer getOpponent()
    {
        return opponent;
    }

    /**
     * This method is setting the opponent of the score
     * @param opponent The opponent from the game
     */
    public void setOpponent(Gamer opponent)
    {
        this.opponent = opponent;
    }

    /**
     * This method gets the ID of the score
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * This method is setting the ID for the object of Score
     * @param id ID for score
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * This method gets an object of Gamer and returning the object as the host user
     * @return user
     */
    public Gamer getUser()
    {
        return user;
    }

    /**
     * This method is setting the host user of the score
     * @param user the host user of the score
     */
    public void setUser(Gamer user)
    {
        this.user = user;
    }

    /**
     * This method gets an object of Game and returning the object as game
     * @return game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * This method is setting the game of the score
     * @param game The game of the score
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * This method gets the score for the Score object
     * @return
     */
    public int getScore()
    {
        return score;
    }

    /**
     * This method is setting the score of the Score object
     * @param score The score of the Score object
     */
    public void setScore(int score)
    {
        this.score = score;
    }
}

