package GUI;

import Brewery.Brewery;
import Recipe.Recipe;
import Stockpile.Beer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StockpileUi extends JFrame implements MouseListener {

    JButton buttonAddBeer;
    JButton buttonRemoveBeer;

    Brewery brewery;


    public StockpileUi(Brewery brewery) {
        super("Beer");
        this.brewery = brewery;
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
        JPanel contentList = new JPanel(new GridLayout(0,4,0,0));
        contentList.setPreferredSize(new Dimension(550, 500));
        JScrollPane beerListScroll = new JScrollPane(contentList);
        beerListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        beerListScroll.setPreferredSize(new Dimension(600, 500));
        contentList.setBackground(Color.BLUE);

        for(int i = 0; i < brewery.getStockpile().size(); i++){

            JPanel beerCell = new JPanel(new GridLayout(0,1,0,0));
            beerCell.setPreferredSize(new Dimension(250, 100));
            beerCell.setBackground(Color.WHITE);
            beerCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel beerName = new JLabel(brewery.getStockpile().get(i).getStyleName());
            beerName.setHorizontalAlignment(JLabel.CENTER);
            beerName.setPreferredSize(new Dimension(0, 20));
            beerName.setBackground(Color.RED);
            beerName.setOpaque(true);
            beerCell.add(beerName);

            JLabel beerStyle = new JLabel(brewery.getStockpile().get(i).getType());
            beerStyle.setHorizontalAlignment(JLabel.CENTER);
            beerCell.add(beerStyle);
            JLabel beerVolume = new JLabel(String.valueOf(brewery.getStockpile().get(i).getVolume()) + "L");
            beerVolume.setHorizontalAlignment(JLabel.CENTER);
            beerCell.add(beerVolume);
            JLabel beerPrice = new JLabel(String.valueOf(brewery.getStockpile().get(i).getPrice()) + "$");
            beerPrice.setHorizontalAlignment(JLabel.CENTER);
            beerCell.add(beerPrice);
            JLabel beerRecipeName = new JLabel(brewery.getStockpile().get(i).getRecipe().getStyleName());
            beerRecipeName.setHorizontalAlignment(JLabel.CENTER);


            int finalI = i;
            beerRecipeName.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Recipe");
                    new BeerRecipeUi(brewery.getStockpile().get(finalI).getRecipe());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    beerRecipeName.setForeground(Color.BLUE);
                    Font currentFont = beerRecipeName.getFont();
                    Font newFont = currentFont.deriveFont(currentFont.getSize() + 2F);
                    beerRecipeName.setFont(newFont);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    beerRecipeName.setForeground(Color.BLACK);
                    Font currentFont = beerRecipeName.getFont();
                    Font newFont = currentFont.deriveFont(currentFont.getSize() - 2F);
                    beerRecipeName.setFont(newFont);
                }
            });


            beerCell.add(beerRecipeName);
            contentList.add(beerCell);
        }



        add(buttonMenu, BorderLayout.SOUTH);
        add(beerListScroll, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttonAddBeer){
            System.out.println("Add Beer");
            new addBeerUi(brewery);
            StockpileUi.this.dispose();

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
