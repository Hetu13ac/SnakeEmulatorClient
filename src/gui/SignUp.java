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

public class SignUp extends JPanel
{
    private JLabel lblNewLabel;
    private JLabel lblPleaseFillIn;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    private JButton btnSignUp;
    private JButton btnBack;
    private JLabel lblMessage;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    /**
     * Create the panel.
     */

    public SignUp()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblNewLabel = new JLabel("Sign Up For Snake-Emulator");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblNewLabel.setBounds(27, 38, 524, 44);
        add(lblNewLabel);

        lblPleaseFillIn = new JLabel("Please fill in your details down below:");
        lblPleaseFillIn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblPleaseFillIn.setBounds(27, 86, 333, 22);
        add(lblPleaseFillIn);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblFirstName.setBounds(27, 120, 109, 22);
        add(lblFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblLastName.setBounds(27, 156, 98, 22);
        add(lblLastName);

        lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEmail.setBounds(27, 260, 87, 22);
        add(lblEmail);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUsername.setBounds(27, 190, 98, 22);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblPassword.setBounds(27, 224, 87, 22);
        add(lblPassword);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldFirstName.setBounds(129, 120, 212, 28);
        add(textFieldFirstName);
        textFieldFirstName.setColumns(10);

        textFieldLastName = new JTextField();
        textFieldLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldLastName.setColumns(10);
        textFieldLastName.setBounds(129, 154, 212, 28);
        add(textFieldLastName);

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(129, 187, 212, 28);
        add(textFieldUsername);

        textFieldPassword = new JTextField();
        textFieldPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(129, 221, 212, 28);
        add(textFieldPassword);

        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(129, 258, 212, 28);
        add(textFieldEmail);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnSignUp.setBounds(201, 288, 140, 36);
        add(btnSignUp);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(16, 367, 98, 36);
        add(btnBack);

        lblMessage = new JLabel("");
        lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(lblMessage);
    }

    /**
     * This method get btnSignUp
     * @return btnSignUp
     */
    public JButton getBtnSignUp()
    {
        return btnSignUp;
    }

    /**
     * This method get btnBack
     * @return btnBack
     */
    public JButton getBtnBack()
    {
        return btnBack;
    }

    /**
     * This method convert textFieldFirstName into a String
     * @return firstName
     */
    public String getFirstName()
    {
        firstName = textFieldFirstName.getText();
        return firstName;
    }

    /**
     * This method convert textFieldLastName into a String
     * @return
     */
    public String getLastName()
    {
        lastName = textFieldLastName.getText();
        return lastName;
    }

    /**
     * This method convert textFieldUsername into a String
     * @return username
     */
    public String getUsername()
    {
        username = textFieldUsername.getText();
        return username;
    }

    /**
     * This method convert textFieldPassword into a String
     * @return
     */
    public String getPassword()
    {
        password = textFieldPassword.getText();
        return password;
    }

    /**
     * This method convert textFieldEmail into a String
     * @return email
     */
    public String getEmail()
    {
        email = textFieldEmail.getText();
        return email;
    }

    /**
     * This method is clearing all the textFields in the panel
     * Setting visible for lblMessage to false.
     * The lblMessage will be setVisible true when something occurs like create game or errors.
     */
    public void clearTextFields()
    {
        textFieldFirstName.setText("");
        textFieldLastName.setText("");
        textFieldUsername.setText("");
        textFieldPassword.setText("");
        textFieldEmail.setText("");
        lblMessage.setVisible(false);
    }

    /**
     * This method will be used when a user has succesfully signed up
     */
    public void successfulSignUp()
    {
        lblMessage.setText("Sign up was Successful. Click \"Back\" to login");
        lblMessage.setForeground(Color.BLUE);
        lblMessage.setBounds(16, 333, 325, 22);
    }

    /**
     * This method will be used when a user already exist by username or email
     */
    public void alreadyExist()
    {
        lblMessage.setText("Username or E-mail already exist");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(92, 333, 249, 22);
        lblMessage.setVisible(true);
    }

    /**
     * This method will be used when error occurs.
     */
    public void somethingWentWrong()
    {
        lblMessage.setText("Something went wrong");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(175, 333, 166, 22);
        lblMessage.setVisible(true);
    }

    /**
     * This method will be used if there is empty textFields when btnSignUp is clicked and shows an error message
     */
    public void missingInformation()
    {
        lblMessage.setText("Please fill in your informations");
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(115, 333, 226, 22);
        lblMessage.setVisible(true);
    }

    /**
     * This method add ActionListeners to the panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnSignUp.addActionListener(l);
        btnBack.addActionListener(l);
    }

}

