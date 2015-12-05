package gui;

/**
 * Created by HenrikTuyen on 01/12/15.
 */

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ShowWinner extends JPanel
{
    private JLabel lblShowResult;
    private JLabel lblEnterGameId;
    private JTextField textFieldGameID;
    private JLabel lblGameName;
    private JLabel lblHostId;
    private JLabel lblOpponentId;
    private JLabel lblWinnerId;
    private JButton btnGetResult;
    private JButton btnBack;
    private JLabel errorMessage;

    private String gameID;

    /**
     * Create the panel ShowWinner.
     */
    public ShowWinner()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblShowResult = new JLabel("Show Winner");
        lblShowResult.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblShowResult.setBounds(89, 58, 242, 44);
        add(lblShowResult);

        lblEnterGameId = new JLabel("Enter Game ID:");
        lblEnterGameId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEnterGameId.setBounds(69, 117, 137, 22);
        add(lblEnterGameId);

        textFieldGameID = new JTextField();
        textFieldGameID.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldGameID.setColumns(10);
        textFieldGameID.setBounds(205, 114, 189, 28);
        add(textFieldGameID);

        lblGameName = new JLabel("Game Name:");
        lblGameName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblGameName.setBounds(92, 230, 325, 22);
        add(lblGameName);

        lblHostId = new JLabel("Host ID:");
        lblHostId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblHostId.setBounds(134, 264, 283, 22);
        add(lblHostId);

        lblOpponentId = new JLabel("Opponent ID: ");
        lblOpponentId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblOpponentId.setBounds(89, 298, 325, 22);
        add(lblOpponentId);

        lblWinnerId = new JLabel("Winner ID: ");
        lblWinnerId.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblWinnerId.setBounds(119, 332, 295, 22);
        add(lblWinnerId);

        btnGetResult = new JButton("Get Winner ID");
        btnGetResult.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnGetResult.setBounds(238, 154, 156, 37);
        add(btnGetResult);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(31, 366, 84, 37);
        add(btnBack);

        errorMessage = new JLabel("Something went wrong");
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        errorMessage.setBounds(157, 203, 237, 22);
        add(errorMessage);
        errorMessage.setVisible(false);
    }

    /**
     * This method gets btnGetResult
     * @return btnGetResult
     */
    public JButton getBtnGetResult()
    {
        return btnGetResult;
    }

    /**
     * This method gets btnBack
     * @return btnBack
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }


    /**
     * This method converts textFieldGameID into a String
     * @return gameID
     */
    public String getGameID()
    {
        gameID = textFieldGameID.getText();
        return gameID;
    }

    /**
     * This method shows information of a certain game
     * if opponentID is 0, means that the game is still open and has no winner
     * @param gameName Game name of a certain game
     * @param hostID HostID of a certain game
     * @param opponentID OpponentID of a certain game
     * @param winnerID WinnerID of a certain game
     */
    public void seeResultFromGame(String gameName, int hostID, int opponentID, int winnerID)
    {
        lblGameName.setText("Game Name: " + gameName);
        lblHostId.setText("Host ID: " + hostID);
        lblOpponentId.setText("Opponent ID: " + opponentID);
        lblWinnerId.setText("Winner ID: " + winnerID);
        if(opponentID == 0)
        {
            lblOpponentId.setText("Opponent ID: Game is still open");
            lblWinnerId.setText("Winner ID: NULL");
        }
    }

    /**
     * This method gets errorMessage. Will be shown if game could not be found
     * @return errorMessage
     */
    public JLabel getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * This method is setting the text in lblMessage into a error message and will be shown when something went wrong
     */
    public void somethingWentWrong()
    {
        errorMessage.setText("Something went wrong");
        errorMessage.setBounds(157, 203, 237, 22);
        errorMessage.setVisible(true);
    }

    /**
     * This method will be used when a game could not be found, and errorMessage will be shown
     */
    public void wrongGameID()
    {
        errorMessage.setText("Game could not be found");
        errorMessage.setBounds(165, 203, 229, 22);
        errorMessage.setVisible(true);
    }

    /**
     * Clearing the game info labels for previous searched game info
     */
    public void resetInfo()
    {
        textFieldGameID.setText("");
        lblGameName.setText("Game Name: ");
        lblHostId.setText("Host ID: ");
        lblOpponentId.setText("Opponent ID: ");
        lblWinnerId.setText("Winner ID: ");
    }

    /**
     * This method add ActionListeners to the panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnGetResult.addActionListener(l);
        btnBack.addActionListener(l);
    }
}

