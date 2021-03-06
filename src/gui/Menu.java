package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class represents the Menu GUI for this application. Inputs and outputs for Menu comes from this Panel.
 * Extends JPanel
 */

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Menu extends JPanel
{
    //Declaring variables used in this class
    private JLabel lblMenu;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnShowWinner;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogOff;
    private JLabel lblUsername;
    private JLabel lblUserID;

    /**
     * Create the panel for Menu.
     */

    public Menu()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        //Creating labels and buttons and adding attributes

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblMenu = new JLabel("Menu");
        lblMenu.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblMenu.setBounds(90, 38, 106, 44);
        add(lblMenu);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnCreateGame.setBounds(53, 99, 196, 37);
        add(btnCreateGame);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnJoinGame.setBounds(53, 138, 196, 37);
        add(btnJoinGame);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnHighscores.setBounds(53, 216, 196, 37);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnDeleteGame.setBounds(53, 256, 196, 37);
        add(btnDeleteGame);

        btnLogOff = new JButton("Log Off");
        btnLogOff.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnLogOff.setBounds(53, 305, 196, 37);
        add(btnLogOff);

        lblUsername = new JLabel("");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUsername.setBounds(284, 38, 328, 28);
        add(lblUsername);

        lblUserID = new JLabel("");
        lblUserID.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUserID.setBounds(354, 66, 196, 28);
        add(lblUserID);

        btnShowWinner = new JButton("Show Winner");
        btnShowWinner.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnShowWinner.setBounds(53, 178, 196, 37);
        add(btnShowWinner);


    }

    /**
     * This method gets btnCreateGame
     * @return btnCreateGame
     */
    public JButton getBtnCreateGame()
    {
        return btnCreateGame;
    }

    /**
     * This method gets btnJoinGame
     * @return btnJoinGame
     */
    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    /**
     * This method gets btnShowWinner
     * @return btnShowWinner
     */
    public JButton getBtnShowWinner()
    {
        return btnShowWinner;
    }

    /**
     * This method gets btnHighscores
     * @return btnHighscores
     */
    public JButton getBtnHighscores()
    {
        return btnHighscores;
    }

    /**
     * This method gets btnDeleteGame
     * @return btnDeleteGame
     */
    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    /**
     * This method gets btnLogOff
     * @return btnLogOff
     */
    public JButton getBtnLogOff()
    {
        return btnLogOff;
    }

    /**
     * This method show the user's username and userID in the Menu JPanel
     * @param username Username of the current user.
     * @param userID UserID of the current user.
     */
    public void information(String username, int userID)
    {
        lblUsername.setText("You are logged in as: " + username);
        lblUserID.setText("Your User ID: " + userID);
    }

    /**
     * This method add ActionListeners for this panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnCreateGame.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnShowWinner.addActionListener(l);
        btnHighscores.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnLogOff.addActionListener(l);
    }

}

