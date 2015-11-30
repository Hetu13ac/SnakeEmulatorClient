package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Screen extends JFrame
{
    public static final String WELCOME = "welcome1234";
    public static final String SIGNUP = "signup123";
    public static final String MENU = "menu123";
    public static final String CREATEGAME = "creategame123";
    public static final String JOINGAME = "joingame123";
    public static final String HIGHSCORES = "highscore123";
    public static final String DELETEGAME = "deletegame123";

    public Welcome welcome;
    public SignUp signUp;
    public Menu menu;
    public CreateGame createGame;
    public JoinGame joinGame;
    public Highscores highscores;
    public DeleteGame deleteGame;

    private JPanel contentPane;
    private CardLayout c;

    /**
     * Create the frame.
     */

    public Screen()
    {

        setResizable(false);
        setBounds(100, 100, 648, 445);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

        highscores = new Highscores();
        contentPane.add(highscores, HIGHSCORES);

        deleteGame = new DeleteGame();
        contentPane.add(deleteGame, DELETEGAME);

        c = (CardLayout) getContentPane().getLayout();
    }

    public void show(String card)
    {
        c.show(this.getContentPane(), card);
    }

    public Welcome getWelcome()
    {
        return welcome;
    }

    public SignUp getSignUp()
    {
        return signUp;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public CreateGame getCreateGame()
    {
        return createGame;
    }

    public JoinGame getJoinGame()
    {
        return joinGame;
    }

    public Highscores getHighscores()
    {
        return highscores;
    }

    public DeleteGame getDeleteGame()
    {
        return deleteGame;
    }
}
