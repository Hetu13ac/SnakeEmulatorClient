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

                return true;
            }
            else if (message.equals("Wrong username or password") || message.equals("Error in JSON"))
            {

            }
        }
        return false;
    }

    private class SignUpActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getSignUp().getBtnBack())
            {
                screen.show(Screen.WELCOME);
            }
        }
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

