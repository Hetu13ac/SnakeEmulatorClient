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

public class DeleteGame extends JPanel
{
    private JLabel lblDeleteGame;
    private JLabel lblEnterGameId;
    private JTextField textFieldGameID;
    private JButton btnDeleteGame;
    private JButton btnBack;
    private JLabel lblMessage;

    private int gameID;

    /**
     * Create the panel for DeleteGame.
     */
    public DeleteGame()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblDeleteGame = new JLabel("Delete Game");
        lblDeleteGame.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblDeleteGame.setBounds(94, 93, 242, 44);
        add(lblDeleteGame);

        lblEnterGameId = new JLabel("Enter Game ID:");
        lblEnterGameId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEnterGameId.setBounds(41, 150, 140, 30);
        add(lblEnterGameId);

        textFieldGameID = new JTextField();
        textFieldGameID.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldGameID.setBounds(176, 153, 184, 28);
        add(textFieldGameID);
        textFieldGameID.setColumns(10);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnDeleteGame.setBounds(124, 192, 155, 35);
        add(btnDeleteGame);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(33, 366, 84, 37);
        add(btnBack);

        lblMessage = new JLabel("");
        lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        add(lblMessage);

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
     * This method gets btnBack
     * @return btnDeleteGame
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }

    /**
     * This method convert textFieldGameID into a String and thereafter into an int
     * @return gameID
     */
    public int getGameID()
    {
        String g = textFieldGameID.getText();
        gameID = Integer.parseInt(g);
        return gameID;
    }

    /**
     * This method is setting the text in lblMessage into a success message and will be shown when game is deleted
     * @param gameID The game ID for the game that just has been deleted
     */
    public void gameWasDeleted(int gameID)
    {
        lblMessage.setText("Game was deleted. (Game ID: " + gameID + ")");
        lblMessage.setForeground(Color.BLUE);
        lblMessage.setBounds(41, 239, 327, 28);
        lblMessage.setVisible(true);
    }

    /**
     * This method is setting the text in lblMessage into an error message and will be shown when error occurs
     */
    public void failed()
    {
        lblMessage.setText("Failed. Game was not deleted");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(82, 239, 262, 28);
        lblMessage.setVisible(true);
    }

    /**
     * This method is setting the text in lblMessage into an error message and will be shown when something went wrong
     */
    public void somethingWentWrong()
    {
        lblMessage.setText("Something went wrong. Please try again.");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(41, 239, 367, 28);
        lblMessage.setVisible(true);
    }

    /**
     * This method is clearing the textFieldGameID
     * also setting visible for lblMessage to false.
     * lblMessage will be setVisible true when something occurs like deleted game or errors.
     */
    public void clearText()
    {
        textFieldGameID.setText("");
        lblMessage.setVisible(false);
    }

    /**
     * This method add ActionListeners for this panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnDeleteGame.addActionListener(l);
        btnBack.addActionListener(l);
    }
}

