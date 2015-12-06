package logic;

/**
 * Created by HenrikTuyen on 30/11/15.
 * This class handles the logic of this application. It is the connection between GUI and SDK (Frontend to backend)
 * Inputs will be handled by logic and then send to SDK, and then the SDK will return events back to logic and
 * then back as output to the user (GUI)
 * To every JPanel class from the gui belongs a inner class
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

        if(!firstName.equals("") && !lastName.equals("")
                && !username.equals("") && !password.equals("") && !email.equals(""))
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


    /**
     * Inner class that are used to handle the ActionListeners from screen.CreateGame
     */
    private class CreateGameActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when Create game button are pressed it runs the createGame()
         * when back button are pressed it goes to the Menu JPanel and clearing the textFields at the same time
         * @param e An object of ActionEvent
         */
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



    /**
     * The method is used to create a game to the system
     * Runs when button Create Game are pressed on the screen.CreateGame
     * To create a game we are calling the method createGame() from the Api.class and post an object of Game
     * The method is setting variables by entering game name and controls for a Game object
     * and post it to the server to create.
     * When an object of Game has been created, the status of the game will be open.
     * @return ""
     */
    public String createGame()
    {
        if(!screen.getCreateGame().getGameName().equals("") && !screen.getCreateGame().getGameControls().equals(""))
        {
            //Creating an object of Gamer as host and setting hostID og host Controls
            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getCreateGame().getGameControls());

            //Creating an object of Game and setting game name, host. The mapsize is set to 15.
            Game game = new Game();
            game.setName(screen.getCreateGame().getGameName());
            game.setHost(host);
            game.setMapSize(15);

            String messageFromCreateApi = api.createGame(game);

            //A for loop of openGames is thereafter made and we set the game that the user just have created
            for (Game g : api.getOpenGames())
            {
                if(g.getName().equals(screen.getCreateGame().getGameName()))
                {
                    game.setGameId(g.getGameId());
                }
            }
            //When a game has been created it shows a message with the game ID to the user
            screen.getCreateGame().successMessage(game.getGameId());

            return messageFromCreateApi;
        }
        else
            screen.getCreateGame().somethingWentWrong();

        return "";
    }

    /**
     * Inner class that are used to handle the ActionListeners from screen.JoinGame
     */
    private class JoinGameActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when join game button are pressed it runs the joinGame()
         * when back button are pressed it goes to the Menu JPanel and clearing the textFields at the same time
         * @param e An object of ActionEvent
         */
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

    /**
     * The method is used to join an open game in the system
     * Runs when button join game are pressed on the screen.JoinGame
     * To join a game we are calling the methods joinGame() & startGame() from the Api.class
     * and put variables on object of Game
     * The method is setting variables by entering game name and controls for a Game object
     * and post it to the server to join.
     * First the method runs the joinGame() from Api.class and by that it is setting the opponent ID
     * and changing the game status from open to pending.
     * Thereafter it runs the startGame() method from Api.Class and put setting the opponent controls
     * and changing the game status from pending to finished.
     * The winner of the game can be identified by go to screen.ShowWinner
     * @return ""
     */
    public String joinGame()
    {
        if(!screen.getJoinGame().getGameName().equals("") && !screen.getJoinGame().getGameControls().equals(""))
        {
            //Creating an object of Gamer as opponent and setting opponent ID og Controls
            Gamer opponent = new Gamer();
            Game game = new Game();
            game.setOpponent(opponent);

            opponent.setControls(screen.getJoinGame().getGameControls());
            opponent.setId(currentUser.getId());

            //By making a for-loop we are looking for open games that equals to what opponent have entered
            for (Game g : api.getOpenGames())
            {
                if (g.getName().equals(screen.getJoinGame().getGameName()))
                    game.setGameId(g.getGameId());

            }

            //When the open game is set, we put the variables on an existing object of game
            //and thereafter the game has been joined and started
            String messageFromJoin = api.joinGame(game);
            api.startGame(game);

            screen.getJoinGame().gameJoined(game.getGameId());

            return messageFromJoin;
        }

        screen.getJoinGame().somethingWentWrong();

        return "";
    }

    /**
     * Inner class that are used to handle the ActionListeners from screen.ShowWinner
     */
    private class ShowResultActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when get winner button are pressed it runs the showResultByGameID()
         * when back button are pressed it goes to the Menu JPanel and clearing the textFields
         * and labels at the same time
         * @param e An object of ActionEvent
         */
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

    /**
     * The method is used to show a game by gameID from the system
     * Runs when button get winner are pressed on the screen.ShowWinner
     * To show winner of the game we are calling the method getGameByID() from the Api.class
     * and get variables from a specific object of Game
     * If game ID is identified the variables of the object will be shown on the screen.
     * @return ""
     */
    public String showResultByGameID()
    {
        try
        {
            if(!screen.getShowWinner().getGameID().equals(""))
            {
                //We are parsing the input from user into an int for game ID
                int gameID = Integer.parseInt(screen.getShowWinner().getGameID());

                //Declaring and initializing object of Game
                Game game = api.getGameByGameID(gameID);

                //Method from screen.ShowWinner are called and variables from game object are set into the method
                screen.getShowWinner().seeResultFromGame(game.getName(),
                        game.getHost().getId(), game.getOpponent().getId(), game.getWinner().getId());
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


    /**
     * Inner class that are used to handle the ActionListeners from screen.Highscores
     */
    private class HighscoresActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when back button are pressed it goes to the Menu JPanel
         * @param e An object of ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getHighscores().getBtnBack())
            {
                screen.show(Screen.MENU);
            }
        }
    }

    /**
     * The method is used to get what we need in our JTable
     */
    public void inTable()
    {
        //Declaring & initializing the scores to the ArrayList we made in Api.class getHighscores
        ArrayList<Score> scores = api.getHighscores();

        //Declaring & initializing an object of HighscoreTableModel
        HighscoreTableModel tableModel = new HighscoreTableModel(scores);

        //Putting the scores into the table model
        screen.getHighscores().getTable().setModel(tableModel);
    }

    /**
     * Inner class that are used to handle the ActionListeners from screen.DeleteGame
     */
    private class DeleteGameActionListener implements ActionListener
    {
        /**
         * This method handles when buttons are pressed
         * when delete game button are pressed it runs the deleteGame()
         * when back button are pressed it goes to the Menu JPanel and clearing the textFields at the same time
         * @param e An object of ActionEvent
         */
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

    /**
     * The method is used to "soft" delete a game from the system
     * Runs when button Delete Game are pressed on the screen.DeleteGame
     * To delete a game we are calling the method deleteGame() from the Api.class and delete an object of Game
     * The method is setting variables by entering game name and controls for a Game object
     * On the server it will change status to "deleted"
     * When an object of Game has been deleted, the status of the game will be deleted.
     * @return ""
     */
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

        return "";
    }

}