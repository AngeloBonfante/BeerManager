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

            contentList.setBackground(brewery.getColor());

            returnedPanel = new JPanel(new GridLayout(0,1,0,0));

            for(int i = 0; i < brewery.getStockpile().size(); i++){

                JPanel beerCell = new JPanel(new GridLayout(0,1,0,0));
                beerCell.setPreferredSize(new Dimension(250, 300));
                beerCell.setBackground(Color.WHITE);
                beerCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JLabel beerName = new JLabel(brewery.getStockpile().get(i).getStyleName());
                beerName.setHorizontalAlignment(JLabel.CENTER);
                beerName.setFont(new Font(beerName.getFont().getName(), beerName.getFont().getStyle(), 20));
                beerName.setOpaque(true);
                beerCell.add(beerName);

                JLabel beerStyle = new JLabel(brewery.getStockpile().get(i).getType());
                beerStyle.setHorizontalAlignment(JLabel.CENTER);
                beerStyle.setFont(new Font(beerStyle.getFont().getName(), beerStyle.getFont().getStyle(), 20));
                beerCell.add(beerStyle);
                JLabel beerVolume = new JLabel(brewery.getStockpile().get(i).getVolume() + "L");
                beerVolume.setHorizontalAlignment(JLabel.CENTER);
                beerVolume.setFont(new Font(beerVolume.getFont().getName(), beerVolume.getFont().getStyle(), 20));
                beerCell.add(beerVolume);
                JLabel beerPrice = new JLabel(brewery.getStockpile().get(i).getPrice() + "$");
                beerPrice.setFont(new Font(beerPrice.getFont().getName(), beerPrice.getFont().getStyle(), 20));
                beerPrice.setHorizontalAlignment(JLabel.CENTER);
                beerCell.add(beerPrice);
                JLabel beerRecipeName = new JLabel(brewery.getStockpile().get(i).getRecipe().getStyleName());
                beerRecipeName.setFont(new Font(beerRecipeName.getFont().getName(), beerRecipeName.getFont().getStyle(), 20));
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

            JScrollPane beerListScroll = new JScrollPane(contentList);
            beerListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            beerListScroll.setPreferredSize(new Dimension(600, 600));
            add(beerListScroll, BorderLayout.CENTER);

            returnedPanel.add(beerListScroll);
            setVisible(true);
        }



        public JPanel getReturnedPanel(){
            return returnedPanel;
        }


    }


