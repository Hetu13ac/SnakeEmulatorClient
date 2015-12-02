package logic;

/**
 * Created by HenrikTuyen on 30/11/15.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import com.google.gson.Gson;
import gui.Screen;
import sdk.*;

import javax.swing.table.AbstractTableModel;

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
        screen.showResult.addActionListener(new ShowResultActionListener());
        screen.highscores.addActionListener(new HighscoresActionListener());
        screen.deleteGame.addActionListener(new DeleteGameActionListener());

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

    public void showInfo()
    {
        screen.getMenu().information(currentUser.getUsername(), currentUser.getId());
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
            if(e.getSource() == screen.getMenu().getBtnShowResult())
            {
                screen.show(Screen.SHOWRESULT);
            }
            if(e.getSource() == screen.getMenu().getBtnHighscores())
            {
                ArrayList<Score> scores = api.getHighscores();
                HighscoreTableModel tableModel = new HighscoreTableModel(scores);
                screen.show(Screen.HIGHSCORES);
                screen.getHighscores().getTable().setModel(tableModel);

                sc.get("scores");
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

            String messageFromCreateApi =api.createGame(game);

            for (Game g : api.getOpenGames() )
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
            if(e.getSource() == screen.getShowResult().getBtnGetResult())
            {
                showResultByGameID();
            }
            if(e.getSource() == screen.getShowResult().getBtnBack())
            {
                screen.show(Screen.MENU);
                screen.getShowResult().resetInfo();
                screen.getShowResult().getLblSomethingWentWrong().setVisible(false);
            }
        }
    }

    public String showResultByGameID()
    {
        if(!screen.getShowResult().getGameID().equals("")) {
            int gameID = Integer.parseInt(screen.getShowResult().getGameID());

            Game game = api.getGameByGameID(gameID);

            screen.getShowResult().seeResultFromGame(game.getName(), game.getHost().getId(), game.getOpponent().getId(), game.getWinner().getId());
            screen.getShowResult().getLblSomethingWentWrong().setVisible(false);
        }
        else
            screen.getShowResult().getLblSomethingWentWrong().setVisible(true);

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

    public class HighscoreTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1L;

        private ArrayList<Score> highscores;
        private String[] columns = {"Game ID", "Score", "Username"};
        private int numberOfRows;

        public HighscoreTableModel(ArrayList<Score> highscores)
        {
            this.highscores = highscores;
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            numberOfRows = highscores.size();
            return numberOfRows;
        }

        public String getColumnName(int columnIndex) {

            return columns[columnIndex];

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {

                case 0:
                    return highscores.get(rowIndex).getGame().getWinner().getUsername();
                case 1:
                    return highscores.get(rowIndex).getScore();
                case 2:
                    return highscores.get(rowIndex).getGame().getGameId();

            }

            return null;
        }

        public Score getSelectedScore(int row)
        {
            return highscores.get(row);
        }
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

