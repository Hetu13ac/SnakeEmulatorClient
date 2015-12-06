package logic;

import sdk.Score;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by HenrikTuyen on 02/12/15.
 * This class handles what is in the JTable we are showing in screen.Highscores
 * Extends AbstractTableModel
 */
public class HighscoreTableModel extends AbstractTableModel
{
    //Declaring variables that are used in this class
    private static final long serialVersionUID = 1L;
    private ArrayList<Score> highscores;
    private String[] columns = {"Username", "Score", "Game ID"};
    private int numberOfRows;

    public HighscoreTableModel(ArrayList<Score> highscores)
    {
        this.highscores = highscores;
        fireTableStructureChanged();
    }

    /**
     * This method gets the number of columns
     * @return columns.length
     */
    @Override
    public int getColumnCount()
    {
        return columns.length;
    }

    /**
     * @param columnIndex
     * @return super.getColumnClass(columnIndex)
     */
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return super.getColumnClass(columnIndex);
    }

    /**
     * This method gets the number of how many objects that are in highscores and by that it sets the number of rows
     * @return numberOfRows
     */
    @Override
    public int getRowCount()
    {
        numberOfRows = highscores.size();
        return numberOfRows;
    }

    /**
     * This method gets the column names that we were initializing for columns[] the beginning of the class
     * @param columnIndex Number of columns
     * @return columns[columnIndex]
     */
    public String getColumnName(int columnIndex)
    {
        return columns[columnIndex];
    }

    /**
     * This method gets values of username, score and game id which belongs to the rowIndex and columnIndex
     * @param rowIndex Number of rows
     * @param columnIndex Number of columns
     * @return null
     */
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
}
