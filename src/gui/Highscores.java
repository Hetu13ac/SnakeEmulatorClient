package gui;

/**
 * Created by HenrikTuyen on 30/11/15.
 */


import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Highscores extends JPanel
{
    private JLabel lblHighscores;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnBack;

    /**
     * Create the panel for Highscores.
     */
    public Highscores()
    {
        setBackground(Color.YELLOW);
        setSize(648, 445);
        setLayout(null);

        JLabel snakeIcon = new JLabel("");
        snakeIcon.setBounds(400, 142, 242, 261);
        Image img1 = new ImageIcon(this.getClass().getResource("/img/snake-icon.png")).getImage();
        snakeIcon.setIcon(new ImageIcon(img1));
        add(snakeIcon);

        lblHighscores = new JLabel("Highscores");
        lblHighscores.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 35));
        lblHighscores.setBounds(113, 62, 202, 44);
        add(lblHighscores);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 118, 382, 226);
        add(scrollPane);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnBack.setBounds(18, 370, 98, 33);
        add(btnBack);
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
     * This method gets table
     * @return table
     */
    public JTable getTable()
    {
        return table;
    }

    /**
     * This method add ActionListeners to the panel
     * @param l Object of ActionListener
     */
    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
    }

}
