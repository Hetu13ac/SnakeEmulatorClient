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

public class ShowResult extends JPanel
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
    private JLabel lblSomethingWentWrong;

    private String gameID;

    /**
     * Create the panel.
     */
    public ShowResult()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblShowResult = new JLabel("Show Result");
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

        btnGetResult = new JButton("Get Result");
        btnGetResult.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnGetResult.setBounds(238, 154, 156, 37);
        add(btnGetResult);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(31, 366, 84, 37);
        add(btnBack);

        lblSomethingWentWrong = new JLabel("Something went wrong");
        lblSomethingWentWrong.setForeground(Color.RED);
        lblSomethingWentWrong.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblSomethingWentWrong.setBounds(157, 203, 237, 22);
        add(lblSomethingWentWrong);
        lblSomethingWentWrong.setVisible(false);
    }

    public JButton getBtnGetResult()
    {
        return btnGetResult;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public JLabel getLblSomethingWentWrong()
    {
        return lblSomethingWentWrong;
    }

    public String getGameID()
    {
        gameID = textFieldGameID.getText();
        return gameID;
    }

    public void seeResultFromGame(String gameName, int hostID, int opponentID, int winnerID)
    {
        lblGameName.setText("Game Name: " + gameName);
        lblHostId.setText("Host ID: " + hostID);
        lblOpponentId.setText("Opponent ID: " + opponentID);
        lblWinnerId.setText("Winner ID: " + winnerID);
    }

    public void resetInfo()
    {
        textFieldGameID.setText("");
        lblGameName.setText("Game Name: ");
        lblHostId.setText("Host ID: ");
        lblOpponentId.setText("Opponent ID: ");
        lblWinnerId.setText("Winner ID: ");
    }

    public void addActionListener(ActionListener l)
    {
        btnGetResult.addActionListener(l);
        btnBack.addActionListener(l);
    }
}

