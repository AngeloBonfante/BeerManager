package GUI;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ui extends JFrame implements MouseListener {

    JButton buttonStockpile;
    JButton buttonRecipe;

    public Ui() {
        super("Brewery");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0,0,108));

        JPanel buttonMenu = new JPanel(new GridLayout(1,2,0,0));

        buttonStockpile = new JButton("Stockpile");
        buttonRecipe = new JButton("Recipe");
        buttonStockpile.addMouseListener(this);
        buttonRecipe.addMouseListener(this);
        buttonStockpile.setFocusable(false);
        buttonRecipe.setFocusable(false);
        buttonStockpile.setPreferredSize(new Dimension(100, 100));
        buttonRecipe.setPreferredSize(new Dimension(100, 100));

        /*STYLING*/
            buttonStockpile.setBorderPainted(false);
            buttonRecipe.setBorderPainted(false);
            buttonStockpile.setBackground(Color.YELLOW);
            buttonRecipe.setBackground(Color.YELLOW);
        /*END STYLING*/

        buttonMenu.add(buttonStockpile);
        buttonMenu.add(buttonRecipe);


        add(buttonMenu, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttonStockpile){
            System.out.println("Stockpile");
            new stockpileUi();
        }if (e.getSource() == buttonRecipe){
            System.out.println("Recipe");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == buttonStockpile){
           buttonStockpile.setBackground(Color.ORANGE);
        }if (e.getSource() == buttonRecipe){
            buttonRecipe.setBackground(Color.ORANGE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == buttonStockpile){
           buttonStockpile.setBackground(Color.YELLOW);
        }if (e.getSource() == buttonRecipe){
            buttonRecipe.setBackground(Color.YELLOW);
        }

    }
}
