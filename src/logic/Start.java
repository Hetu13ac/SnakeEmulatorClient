package logic;

/**
 * Created by HenrikTuyen on 30/11/15.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.Gson;
import gui.Screen;
import sdk.Api;
import sdk.ServerConnection;
import sdk.User;

public class Start
{
    private Screen screen;
    private User currentUser;
    private ServerConnection sc;
    private Api api;


    public Start()
    {
        screen = new Screen();
        screen.setVisible(true);

        currentUser = new User();

        sc = new ServerConnection();
        api = new Api();
    }

    public void run(){
        screen.welcome.addActionListener(new WelcomeActionListener());
        screen.signUp.addActionListener(new SignUpActionListener());
        screen.menu.addActionListener(new MenuActionListener());
        screen.createGame.addActionListener(new CreateGameActionListener());
        screen.joinGame.addActionListener(new JoinGameActionListener());
        screen.highscores.addActionListener(new HighscoresActionListener());

        screen.show(screen.WELCOME);
    }

    private class WelcomeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getWelcome().getBtnLogin())
            {
                userAuth();
            }
            if(e.getSource() == screen.getWelcome().getBtnSignUp())
            {
                screen.show(Screen.SIGNUP);
                screen.getWelcome().getYouHaveEntered().setVisible(false);
                screen.getWelcome().clearTextFields();
            }
        }
    }

    public boolean userAuth()
    {
        String username = screen.getWelcome().getUsername();
        String password = screen.getWelcome().getPassword();

        if (!username.equals("") && !password.equals(""))
        {
            currentUser.setPassword(password);
            currentUser.setUsername(username);

            String json = new Gson().toJson(currentUser);

            String message = sc.stringMessageParser(sc.post(json, "login/"));
            System.out.println(message);

            if (message.equals("Login successful"))
            {
                for (User user : api.getUsers() )
                {
                    if (user.getUsername().equals(screen.getWelcome().getUsername()))
                    {
                        currentUser = user;
                    }
                }
                screen.show(Screen.MENU);
                screen.getWelcome().clearTextFields();
                screen.getWelcome().getYouHaveEntered().setVisible(false);

                return true;
            }
            else if (message.equals("Wrong username or password") || message.equals("Error in JSON"))
            {
                screen.getWelcome().enteredWrong();
                screen.getWelcome().getYouHaveEntered().setVisible(true);
            }
        }
        else
            screen.getWelcome().somethingWentWrong();
            screen.getWelcome().getYouHaveEntered().setVisible(true);

        return false;
    }

    private class SignUpActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getSignUp().getBtnSignUp())
            {
                createUser();
            }
            if(e.getSource() == screen.getSignUp().getBtnBack())
            {
                screen.show(Screen.WELCOME);
                screen.getSignUp().clearTextFields();
            }
        }
    }

    public boolean createUser()
    {
        String firstName = screen.getSignUp().getFirstName();
        String lastName = screen.getSignUp().getLastName();
        String username = screen.getSignUp().getUsername();
        String password = screen.getSignUp().getPassword();
        String email = screen.getSignUp().getEmail();
        int type = 1;

        if(!firstName.equals("") && !lastName.equals("") && !username.equals("") && !password.equals("") && !email.equals(""))
        {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setType(type);

            String json = new Gson().toJson(user);

            String message = sc.stringMessageParser(sc.post(json, "users/"));
            System.out.println(message);

            if (message.equals("User was created"))
            {
                screen.getSignUp().successfulSignUp();
                return true;
            }
            else if (message.equals("Username or email already exists"))
            {
                screen.getSignUp().alreadyExist();
            }
            else if (message.equals("Error in JSON"))
            {
                screen.getSignUp().somethingWentWrong();
            }
        }
        else
            screen.getSignUp().missingInformation();

        return false;
    }

    private class MenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getMenu().getBtnCreateGame())
            {
                screen.show(Screen.CREATEGAME);
            }
            if(e.getSource() == screen.getMenu().getBtnJoinGame())
            {
                screen.show(Screen.JOINGAME);
            }
            if(e.getSource() == screen.getMenu().getBtnHighscores())
            {
                screen.show(Screen.HIGHSCORES);
            }
            if(e.getSource() == screen.getMenu().getBtnDeleteGame())
            {
                screen.show(Screen.DELETEGAME);
            }
            if(e.getSource() == screen.getMenu().getBtnLogOff())
            {
                screen.show(Screen.WELCOME);
            }

        }
    }

    private class CreateGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getCreateGame().getBtnBack())
            {
                screen.show(Screen.MENU);
            }
        }
    }

    private class JoinGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getJoinGame().getBtnBack())
            {
                screen.show(Screen.MENU);
            }
        }
    }

    private class HighscoresActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getHighscores().getBtnBack())
            {
                screen.show(Screen.MENU);
            }
        }
    }

    private class DeleteGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}

