package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Menu extends JPanel
{
    private JLabel lblMenu;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnShowResult;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogOff;
    private JLabel lblUsername;
    private JLabel lblUserID;

    /**
     * Create the panel.
     */

    public Menu()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

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

        btnShowResult = new JButton("Show Result");
        btnShowResult.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnShowResult.setBounds(53, 178, 196, 37);
        add(btnShowResult);


    }

    public JButton getBtnCreateGame()
    {
        return btnCreateGame;
    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    public JButton getBtnShowResult()
    {
        return btnShowResult;
    }

    public JButton getBtnHighscores()
    {
        return btnHighscores;
    }

    public JButton getBtnDeleteGame()
    {
        return btnDeleteGame;
    }

    public JButton getBtnLogOff()
    {
        return btnLogOff;
    }

    public void information(String username, int userID)
    {
        lblUsername.setText("You are logged in as: " + username);
        lblUserID.setText("Your User ID: " + userID);
    }

    public void addActionListener(ActionListener l)
    {
        btnCreateGame.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnShowResult.addActionListener(l);
        btnHighscores.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnLogOff.addActionListener(l);
    }

}

