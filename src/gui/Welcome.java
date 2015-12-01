package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */


import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Welcome extends JPanel
{
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblWelcome;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel lblDontHaveA;
    private JButton btnSignUp;
    private JLabel lblYouHaveEntered;

    private String username;
    private String password;

    /**
     * Create the panel.
     */
    public Welcome()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblWelcome = new JLabel("Welcome to Snake-Emulator");
        lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblWelcome.setBounds(68, 70, 522, 44);
        add(lblWelcome);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUsername.setBounds(126, 163, 98, 24);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblPassword.setBounds(126, 210, 98, 24);
        add(lblPassword);

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        textFieldUsername.setBounds(226, 161, 174, 28);
        add(textFieldUsername);
        textFieldUsername.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        passwordField.setBounds(226, 208, 174, 28);
        add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnLogin.setBounds(255, 248, 138, 36);
        add(btnLogin);

        lblDontHaveA = new JLabel("Don't have a user?");
        lblDontHaveA.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblDontHaveA.setBounds(78, 332, 164, 36);
        add(lblDontHaveA);

        btnSignUp = new JButton("Sign Up Here!");
        btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnSignUp.setBounds(243, 332, 164, 36);
        add(btnSignUp);

        lblYouHaveEntered = new JLabel("");
        lblYouHaveEntered.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(lblYouHaveEntered);
    }

    public JButton getBtnLogin()
    {
        return btnLogin;
    }

    public JButton getBtnSignUp()
    {
        return btnSignUp;
    }

    public String getUsername()
    {
        username = textFieldUsername.getText();
        return username;
    }

    public String getPassword()
    {
        password = passwordField.getText();
        return password;
    }

    public void clearTextFields()
    {
        textFieldUsername.setText("");
        passwordField.setText("");
    }

    public JLabel getYouHaveEntered()
    {
        return lblYouHaveEntered;
    }

    public void enteredWrong()
    {
        lblYouHaveEntered.setText("You have entered wrong username or password");
        lblYouHaveEntered.setForeground(Color.RED);
        lblYouHaveEntered.setBounds(57, 296, 343, 24);
    }

    public void somethingWentWrong()
    {
        lblYouHaveEntered.setText("Please enter username and password");
        lblYouHaveEntered.setForeground(Color.RED);
        lblYouHaveEntered.setBounds(125, 296, 275, 24);
    }

    public void addActionListener(ActionListener l)
    {
        btnLogin.addActionListener(l);
        btnSignUp.addActionListener(l);
    }
}

