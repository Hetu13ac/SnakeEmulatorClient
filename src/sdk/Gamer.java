package sdk;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class is exactly the same as the Gamer.class from the server
 * This class represent an object of Gamer and contains the variables that Gamer object must have
 * Extends User
 */

public class Gamer extends User {

    //Declaring variable used in this class
    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean winner;

    /**
     * This method gets the winner
     * @return winner
     */
    public boolean isWinner()
    {
        return winner;
    }

    /**
     * This method is setting the winner
     * @param winner If Gamer object wins a game winner = true, else false
     */
    public void setWinner(boolean winner)
    {
        this.winner = winner;
    }

    /**
     * This method gets total score
     * @return totalScore
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    /**
     * This method is setting total score for a Gamer object
     * @param totalScore Total score for a Gamer object
     */
    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    /**
     * This method gets kills
     * @return kills
     */
    public int getKills()
    {
        return kills;
    }

    /**
     * This method is setting kills for a Gamer object
     * @param kills The number of kills for a Gamer object
     */
    public void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * This method gets the score from a Gamer object
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is setting the score for a Gamer object
     * @param score The score of a Gamer object
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * This method gets the controls from a Gamer object
     * @return controls
     */
    public String getControls()
    {
        return controls;
    }

    /**
     * This method is setting the controls for a Gamer object
     * @param controls The controls for a Gamer object
     */
    public void setControls(String controls)
    {
        this.controls = controls;
    }
}

