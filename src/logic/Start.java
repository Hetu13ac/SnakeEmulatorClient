package logic;

/**
 * Created by HenrikTuyen on 30/11/15.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import gui.Screen;
import sdk.*;

public class Start
{
    //Declaring the variables used in this class
    private Screen screen;
    private User currentUser;
    private ServerConnection sc;
    private Api api;

    //Constructor of the class
    public Start()
    {
        //Initializing the variables that are used in this class
        screen = new Screen();
        screen.setVisible(true);

        currentUser = new User();

        sc = new ServerConnection();
        api = new Api();
    }

    /**
     * This method is used to start the application. It is injecting ActionListeners from the GUI.
     * The application starts with opening the JPanel Welcome
     */
    public void run()
    {
        screen.welcome.addActionListener(new WelcomeActionListener());
        screen.signUp.addActionListener(new SignUpActionListener());
        screen.menu.addActionListener(new MenuActionListener());
        screen.createGame.addActionListener(new CreateGameActionListener());
        screen.joinGame.addActionListener(new JoinGameActionListener());
        screen.showWinner.addActionListener(new ShowResultActionListener());
        screen.highscores.addActionListener(new HighscoresActionListener());
        screen.deleteGame.addActionListener(new DeleteGameActionListener());

        screen.show(screen.WELCOME);
    }


    /**
     * Inner class that are used to handle the ActionListeners from screen.Welcome
     */
    private class WelcomeActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when login button are pressed it runs the userAuth() method which verify the user
         * when sign up button are pressed it goes to the SignUp JPanel
         * @param e An object of ActionEvent
         */
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


    /**
     * The method is verifying user to login to the system.
     * To verify an user we are calling the method login() from the Api.class and post an object of User
     * If User can be verified the user are being set to be currentUser
     * @return true if login successful and false if something incorrect was entered
     */
    public boolean userAuth()
    {
        String username = screen.getWelcome().getUsername();
        String password = screen.getWelcome().getPassword();

        if (!username.equals("") && !password.equals(""))
        {
            currentUser.setUsername(username);
            currentUser.setPassword(password);


            String message = api.login(currentUser);
            //System.out.println(message);

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
                showInfo();
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


    /**
     * This method is used to show username and userID when user has logged into the system, and
     * The method are getting its variables from currentUser
     */
    public void showInfo()
    {
        screen.getMenu().information(currentUser.getUsername(), currentUser.getId());
    }


    /**
     * Inner class that are used to handle the ActionListeners from screen.SignUp
     */
    private class SignUpActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when SignUp button are pressed it runs the createUser()
         * when back button are pressed it goes to the Welcome JPanel
         * @param e An object of ActionEvent
         */
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

    /**
     * The method is used to create a user to the system.
     * To create a user we are calling the method createUser() from the Api.class and post an object of User
     * The is setting variables for a User object and post it to the server to create.
     * @return true if creation was successful and false if something incorrect was entered
     */
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

            String message = api.createUser(user);

            if(message.equals("User was created"))
            {
                screen.getSignUp().successfulSignUp();
                return true;
            }
            else if(message.equals("Username or email already exists"))
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


    /**
     * Inner class that are used to handle the ActionListeners from screen.Menu
     */
    private class MenuActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when create game button are pressed it shows the screen.CreateGame
         * when join game button are pressed it shows the screen.JoinGame
         * when show winner button are pressed it shows the screen.ShowWinner
         * when Highscores button are pressed it shows the screen.Highscores and also calls the inTable() method
         * when delete game button are pressed it shows the screen.DeleteGame
         * when log out button are pressed it shows the screen.Welcome and you have to login to the system again
         * @param e An object of ActionEvent
         */
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
            if(e.getSource() == screen.getMenu().getBtnShowWinner())
            {
                screen.show(Screen.SHOWWINNER);
            }
            if(e.getSource() == screen.getMenu().getBtnHighscores())
            {
                inTable();
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
            if(e.getSource() == screen.getCreateGame().getBtnCreateGame())
            {
                createGame();
            }
            if(e.getSource() == screen.getCreateGame().getBtnBack())
            {
                screen.show(Screen.MENU);
                screen.getCreateGame().clearTextFields();
            }
        }
    }


    public String createGame()
    {
        if(!screen.getCreateGame().getGameName().equals("") && !screen.getCreateGame().getGameControls().equals(""))
        {
            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getCreateGame().getGameControls());

            Game game = new Game();
            game.setName(screen.getCreateGame().getGameName());
            game.setHost(host);
            game.setMapSize(15);

            String messageFromCreateApi = api.createGame(game);

            for (Game g : api.getOpenGames())
            {
                if(g.getName().equals(screen.getCreateGame().getGameName()))
                {
                    game.setGameId(g.getGameId());
                }
            }
            screen.getCreateGame().successMessage(game.getGameId());

            return messageFromCreateApi;
        }
        else
            screen.getCreateGame().somethingWentWrong();

        return "";
    }


    private class JoinGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getJoinGame().getBtnJoinGame())
            {
                joinGame();
            }
            if(e.getSource() == screen.getJoinGame().getBtnBack())
            {
                screen.show(Screen.MENU);
                screen.getJoinGame().clearTextFields();
            }
        }
    }



    public String joinGame()
    {
        if(!screen.getJoinGame().getGameName().equals("") && !screen.getJoinGame().getGameControls().equals(""))
        {
            Gamer opponent = new Gamer();
            Game game = new Game();
            game.setOpponent(opponent);

            opponent.setControls(screen.getJoinGame().getGameControls());
            opponent.setId(currentUser.getId());

            for (Game g : api.getOpenGames())
            {
                if (g.getName().equals(screen.getJoinGame().getGameName()))
                    game.setGameId(g.getGameId());

            }

            String messageFromJoin = api.joinGame(game);
            api.startGame(game);

            screen.getJoinGame().gameJoined(game.getGameId());

            return messageFromJoin;
        }

        screen.getJoinGame().somethingWentWrong();

        return "";
    }


    private class ShowResultActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getShowWinner().getBtnGetResult())
            {
                showResultByGameID();
            }
            if(e.getSource() == screen.getShowWinner().getBtnBack())
            {
                screen.show(Screen.MENU);
                screen.getShowWinner().resetInfo();
                screen.getShowWinner().getErrorMessage().setVisible(false);
            }
        }
    }


    public String showResultByGameID()
    {
        try
        {
        if(!screen.getShowWinner().getGameID().equals("")) {
            int gameID = Integer.parseInt(screen.getShowWinner().getGameID());

            Game game = api.getGameByGameID(gameID);

            screen.getShowWinner().seeResultFromGame(game.getName(), game.getHost().getId(), game.getOpponent().getId(), game.getWinner().getId());
            screen.getShowWinner().getErrorMessage().setVisible(false);

        }
        else
            screen.getShowWinner().somethingWentWrong();


        }
        catch (Exception e1)
        {
            screen.getShowWinner().wrongGameID();
        }
        return "";
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

    public void inTable()
    {
        ArrayList<Score> scores = api.getHighscores();
        HighscoreTableModel tableModel = new HighscoreTableModel(scores);
        screen.getHighscores().getTable().setModel(tableModel);
    }

    private class DeleteGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if(e.getSource() == screen.getDeleteGame().getBtnDeleteGame())
                {
                    deleteGame();
                }
                if(e.getSource() == screen.getDeleteGame().getBtnBack())
                {
                    screen.show(Screen.MENU);
                    screen.getDeleteGame().clearText();
                }
            } catch(Exception e1)
            {
                screen.getDeleteGame().somethingWentWrong();
            }
        }
    }

    public String deleteGame()
    {
        int gameID = screen.getDeleteGame().getGameID();

        String message = api.deleteGame(gameID);

        System.out.println(message);
        if (message.equals("Game was deleted"))
        {
            screen.getDeleteGame().gameWasDeleted(gameID);
        }
        if (message.equals("Failed. Game was not deleted")) {
            screen.getDeleteGame().failed();
        }

        return message;
    }

}