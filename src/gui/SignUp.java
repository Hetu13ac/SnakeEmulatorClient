package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */


import java.awt.Font;
import java.awt.Image;
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
    }

    public JButton getBtnSignUp()
    {
        return btnSignUp;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public String getFirstName()
    {
        firstName = textFieldFirstName.getText();
        return firstName;
    }

    public String getLastName()
    {
        lastName = textFieldLastName.getText();
        return lastName;
    }

    public String getUsername()
    {
        username = textFieldUsername.getText();
        return username;
    }

    public String getPassword()
    {
        password = textFieldPassword.getText();
        return password;
    }

    public String getEmail()
    {
        email = textFieldEmail.getText();
        return email;
    }

    public void clearTextFields()
    {
        textFieldFirstName.setText("");
        textFieldLastName.setText("");
        textFieldUsername.setText("");
        textFieldPassword.setText("");
        textFieldEmail.setText("");
    }

    public void addActionListener(ActionListener l)
    {
        btnSignUp.addActionListener(l);
        btnBack.addActionListener(l);
    }

}

