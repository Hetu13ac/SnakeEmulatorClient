package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class represents the Screen GUI for this application and work as a frame for all the JPanels
 * Extends JFrame
 */

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame
{
    public static final String WELCOME = "welcome1234";
    public static final String SIGNUP = "signup123";
    public static final String MENU = "menu123";
    public static final String CREATEGAME = "creategame123";
    public static final String JOINGAME = "joingame123";
    public static final String SHOWWINNER = "showwinner123";
    public static final String HIGHSCORES = "highscore123";
    public static final String DELETEGAME = "deletegame123";

    public Welcome welcome;
    public SignUp signUp;
    public Menu menu;
    public CreateGame createGame;
    public JoinGame joinGame;
    public ShowWinner showWinner;
    public Highscores highscores;
    public DeleteGame deleteGame;

    private JPanel contentPane;
    private CardLayout c;

    /**
     * Create the frame.
     * CardLayout is used for this JFrame. contentPane work as a card deck and every JPanel represent a "card".
     */
    public Screen()
    {
        setResizable(false);
        setBounds(100, 100, 648, 445);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        welcome = new Welcome();
        contentPane.add(welcome, WELCOME);

        signUp = new SignUp();
        contentPane.add(signUp, SIGNUP);

        menu = new Menu();
        contentPane.add(menu, MENU);

        createGame = new CreateGame();
        contentPane.add(createGame, CREATEGAME);

        joinGame = new JoinGame();
        contentPane.add(joinGame, JOINGAME);

        showWinner = new ShowWinner();
        contentPane.add(showWinner, SHOWWINNER);

        highscores = new Highscores();
        contentPane.add(highscores, HIGHSCORES);

        deleteGame = new DeleteGame();
        contentPane.add(deleteGame, DELETEGAME);

        c = (CardLayout) getContentPane().getLayout();
    }

    /**
     * This method is used for showing a specific card/JPanel from the card deck/contentPane.
     * @param card The specific card/JPanel that will shown
     */
    public void show(String card)
    {
        c.show(this.getContentPane(), card);
    }

    /**
     * This method gets Welcome (JPanel)
     * @return welcome
     */
    public Welcome getWelcome()
    {
        return welcome;
    }

    /**
     * This method gets SignUp (JPanel)
     * @return signUp
     */
    public SignUp getSignUp()
    {
        return signUp;
    }

    /**
     * This method gets Menu (JPanel)
     * @return menu
     */
    public Menu getMenu()
    {
        return menu;
    }

    /**
     * This method gets CreateGame (JPanel)
     * @return createGame
     */
    public CreateGame getCreateGame()
    {
        return createGame;
    }

    /**
     * This method gets JoinGame (JPanel)
     * @return joinGame
     */
    public JoinGame getJoinGame()
    {
        return joinGame;
    }

    /**
     * This method gets ShowWinner (JPanel)
     * @return showWinner
     */
    public ShowWinner getShowWinner()
    {
        return showWinner;
    }

    /**
     * This method gets Highscores (JPanel)
     * @return highscores
     */
    public Highscores getHighscores()
    {
        return highscores;
    }

    /**
     * This method gets DeleteGame (JPanel)
     * @return deleteGame
     */
    public DeleteGame getDeleteGame()
    {
        return deleteGame;
    }

}
