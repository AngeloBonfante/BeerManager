package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class stockpileUi extends JFrame implements MouseListener {

    JButton buttonAddBeer;
    JButton buttonRemoveBeer;


    public stockpileUi() {
        super("Beer");
        setSize(600, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

            WindowListener windowListener = new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            };
            addWindowListener(windowListener);

        JPanel buttonMenu = new JPanel(new GridLayout(1,2,0,0));

        buttonAddBeer = new JButton("Add Beer");
        buttonRemoveBeer = new JButton("Remove Beer");
        buttonAddBeer.setFocusable(false);
        buttonRemoveBeer.setFocusable(false);
        buttonAddBeer.setPreferredSize(new Dimension(100, 100));
        buttonRemoveBeer.setPreferredSize(new Dimension(100, 100));
        buttonAddBeer.addMouseListener(this);
        buttonRemoveBeer.addMouseListener(this);

            /*STYLING*/
            buttonAddBeer.setBorderPainted(false);
            buttonRemoveBeer.setBorderPainted(false);
            buttonAddBeer.setBackground(Color.YELLOW);
            buttonRemoveBeer.setBackground(Color.YELLOW);
            /*END STYLING*/

        buttonMenu.add(buttonAddBeer);
        buttonMenu.add(buttonRemoveBeer);

        //TODO: Create a list of beers
        JPanel contentList = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        contentList.setBackground(Color.BLUE);

        add(buttonMenu, BorderLayout.SOUTH);
        add(contentList, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttonAddBeer){
            System.out.println("Add Beer");
            new addBeerUi();

        }if (e.getSource() == buttonRemoveBeer){
            System.out.println("Remove Beer");
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
        if (e.getSource() == buttonAddBeer){
            buttonAddBeer.setBackground(Color.ORANGE);
        }if (e.getSource() == buttonRemoveBeer){
            buttonRemoveBeer.setBackground(Color.ORANGE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == buttonAddBeer){
            buttonAddBeer.setBackground(Color.YELLOW);
        }if (e.getSource() == buttonRemoveBeer){
            buttonRemoveBeer.setBackground(Color.YELLOW);
        }

    }
}
