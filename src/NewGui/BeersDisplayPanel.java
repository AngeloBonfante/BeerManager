package NewGui;

import Brewery.Brewery;
import GUI.BeerRecipeUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BeersDisplayPanel extends JFrame {

        Brewery brewery;
        JPanel contentList;
        JPanel returnedPanel;

        public BeersDisplayPanel(Brewery brewery) {
            super("Beer");
            this.brewery = brewery;
            setSize(1000, 650);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            setLayout(new BorderLayout());

            contentList = new JPanel(new GridLayout(0,4,0,0));
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

            add(beerListScroll, BorderLayout.CENTER);

            returnedPanel = new JPanel(new BorderLayout());
            returnedPanel.add(beerListScroll, BorderLayout.CENTER);
            setVisible(true);
        }



        public JPanel getReturnedPanel(){
            return returnedPanel;
        }


    }


