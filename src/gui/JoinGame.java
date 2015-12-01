package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JoinGame extends JPanel
{
    private JLabel lblJoinGame;
    private JLabel lblGameName;
    private JTextField textFieldGameName;
    private JLabel lblEnterGameControls;
    private JTextField textFieldGameControls;
    private JButton btnJoinGame;
    private JLabel lblMessage;
    private JButton btnBack;

    private String gameName;
    private String gameControls;


    /**
     * Create the panel.
     */
    public JoinGame()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        JLabel instructions = new JLabel("");
        instructions.setBounds(198, 128, 212, 133);
        Image img = new ImageIcon(this.getClass().getResource("/img/controlHENRIK.png")).getImage();
        instructions.setIcon(new ImageIcon(img));
        add(instructions);

        lblJoinGame = new JLabel("Join Game");
        lblJoinGame.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblJoinGame.setBounds(124, 38, 194, 44);
        add(lblJoinGame);

        lblGameName = new JLabel("Enter Game Name:");
        lblGameName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblGameName.setBounds(56, 94, 166, 22);
        add(lblGameName);

        textFieldGameName = new JTextField();
        textFieldGameName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldGameName.setBounds(221, 91, 189, 28);
        add(textFieldGameName);
        textFieldGameName.setColumns(10);

        lblEnterGameControls = new JLabel("Enter Game Controls:");
        lblEnterGameControls.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEnterGameControls.setBounds(35, 273, 186, 22);
        add(lblEnterGameControls);

        textFieldGameControls = new JTextField();
        textFieldGameControls.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldGameControls.setColumns(10);
        textFieldGameControls.setBounds(221, 270, 189, 28);
        add(textFieldGameControls);

        btnJoinGame = new JButton("Join Game");
        btnJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnJoinGame.setBounds(162, 307, 156, 37);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(16, 366, 84, 37);
        add(btnBack);

        lblMessage = new JLabel("");
        lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(lblMessage);
    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public String getGameName()
    {
        gameName = textFieldGameName.getText();
        return gameName;
    }

    public String getGameControls()
    {
        gameControls = textFieldGameControls.getText();
        return gameControls;
    }

    public void clearTextFields()
    {
        textFieldGameName.setText("");
        textFieldGameControls.setText("");
        lblMessage.setVisible(false);
    }

    public void gameJoined(int gameID)
    {
        lblMessage.setText("Game was joined. Game ID: " + gameID);
        lblMessage.setForeground(Color.BLUE);
        lblMessage.setBounds(123, 345, 242, 22);
        lblMessage.setVisible(true);
    }

    public void somethingWentWrong()
    {
        lblMessage.setText("Something went wrong");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(157, 345, 176, 22);
        lblMessage.setVisible(true);
    }

    public void addActionListener(ActionListener l)
    {
        btnJoinGame.addActionListener(l);
        btnBack.addActionListener(l);
    }
}