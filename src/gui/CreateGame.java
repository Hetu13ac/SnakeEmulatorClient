package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class represents the Create Game GUI for this application. Inputs and outputs for create game comes from this Panel.
 * Extends JPanel.
 */

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class CreateGame extends JPanel
{

    //Declaring variables used in this class
    private JLabel lblCreateGame;
    private JLabel lblGameName;
    private JTextField textFieldGameName;
    private JLabel lblEnterGameControls;
    private JTextField textFieldGameControls;
    private JButton btnCreateGame;
    private JButton btnBack;
    private JLabel lblMessage;

    private String gameName;
    private String gameControls;

    /**
     * Create the panel for createGame.
     */
    public CreateGame()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        //Creating labels, textFields, buttons and adding attributes

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

        lblCreateGame = new JLabel("Create Game");
        lblCreateGame.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblCreateGame.setBounds(107, 38, 242, 44);
        add(lblCreateGame);

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

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnCreateGame.setBounds(162, 307, 156, 37);
        add(btnCreateGame);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(16, 366, 84, 37);
        add(btnBack);

        lblMessage = new JLabel("");
        lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(lblMessage);
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
     * This method gets btnBack
     * @return btnBack
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }

    /**
     * This method is converting textFieldGameName into a String and gets Game name
     * @return gameName
     */
    public String getGameName()
    {
        gameName = textFieldGameName.getText();
        return gameName;
    }

    /**
     * This method is converting textFieldGameControls into a String and gets Game Controls
     * @return gameControls
     */
    public String getGameControls()
    {
        gameControls = textFieldGameControls.getText();
        return gameControls;
    }


    /**
     * This method is clearing all the textFields in CreateGame
     * Setting visible for lblMessage to false.
     * The lblMessage will be setVisible true when something occurs like create game or errors.
     */
    public void clearTextFields()
    {
        textFieldGameName.setText("");
        textFieldGameControls.setText("");
        lblMessage.setVisible(false);
    }

    /**
     * This method is setting the text in lblMessage into a success message and will be shown when game is created
     * @param gameID The game ID for the game that just has been created
     */
    public void successMessage(int gameID)
    {
        lblMessage.setText("Game was created. Game ID: "+ gameID);
        lblMessage.setForeground(Color.BLUE);
        lblMessage.setBounds(107, 346, 281, 22);
        lblMessage.setVisible(true);
    }

    /**
     * This method is setting the text in lblMessage into a error message and will be shown when something went wrong
     */
    public void somethingWentWrong()
    {
        lblMessage.setText("Something went wrong");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(154, 346, 176, 22);
        lblMessage.setVisible(true);
    }

    /**
     * This method add ActionListeners for this Panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnCreateGame.addActionListener(l);
        btnBack.addActionListener(l);
    }
}

