package NewGui;

import Brewery.Brewery;
import GUI.RecipeUi;
import GUI.addBeerUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui extends JFrame implements MouseListener{

    Brewery brewery;
    JButton buttonBeers;
    JButton buttonRecipes;

    JButton addBeerButton;
    JButton removeBeerButton;

    JPanel mainContentPanel;
    JPanel sidePanelArea;

    JPanel temp = new JPanel();

    boolean beersOnScreen = false;
    boolean recipesOnScreen = false;


    public Gui(Brewery brewery) {
        super("Brewery");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.brewery = brewery;

        JPanel buttonMenu = new JPanel(new GridLayout(1,2,0,0));
        mainContentPanel= new JPanel(new GridLayout(0,4,0,0));
        sidePanelArea = new JPanel(new GridLayout(0,1,0,0));
        //Color each panel with a different color background
        mainContentPanel.setBackground(Color.BLUE);
        sidePanelArea.setBackground(Color.GREEN);

        buttonMenu.setPreferredSize(new Dimension(0, 100));
        sidePanelArea.setPreferredSize(new Dimension(100, 0));

        buttonBeers = new JButton("Beers");
        buttonRecipes = new JButton("Recipes");

        buttonBeers.addMouseListener(this);
        buttonRecipes.addMouseListener(this);

        buttonBeers.setFocusable(false);
        buttonRecipes.setFocusable(false);

        buttonBeers.setPreferredSize(new Dimension(100, 100));
        buttonRecipes.setPreferredSize(new Dimension(100, 100));

        /*STYLING*/
        buttonBeers.setBorderPainted(false);
        buttonRecipes.setBorderPainted(false);
        buttonBeers.setBackground(Color.YELLOW);
        buttonRecipes.setBackground(Color.YELLOW);
        /*END STYLING*/

        buttonMenu.add(buttonBeers);
        buttonMenu.add(buttonRecipes);


        addBeerButton = new JButton("Add Beer");
        removeBeerButton = new JButton("<html>Remove<br>Beer</html>");


        addBeerButton.addMouseListener(this);
        removeBeerButton.addMouseListener(this);

        addBeerButton.setFocusable(false);
        removeBeerButton.setFocusable(false);

        addBeerButton.setPreferredSize(new Dimension(100, 100));
        removeBeerButton.setPreferredSize(new Dimension(100, 100));

        /*STYLING*/
        addBeerButton.setBorderPainted(false);
        removeBeerButton.setBorderPainted(false);
        addBeerButton.setBackground(Color.YELLOW);
        removeBeerButton.setBackground(Color.YELLOW);
        /*END STYLING*/

        sidePanelArea.setLayout(new GridLayout(0,1,0,0));
//        sidePanelArea.add(addBeerButton);
//        sidePanelArea.add(removeBeerButton);





        this.add(buttonMenu, BorderLayout.SOUTH);
        this.add(mainContentPanel, BorderLayout.CENTER);
        this.add(sidePanelArea, BorderLayout.WEST);
        setVisible(true);
    }


    public void renderBeer(){
        recipesOnScreen = false;
        beersOnScreen = true;
        System.out.println("Beers");
        // Remove all components from the mainContentPanel
        mainContentPanel.removeAll();

        // Add the new content (BeersDisplayPanel) to the mainContentPanel
        BeersDisplayPanel beersDisplayPanel = new BeersDisplayPanel(brewery);
        beersDisplayPanel.dispose();
        mainContentPanel.setLayout(new GridLayout(0, 1, 0, 0));
        mainContentPanel.add(beersDisplayPanel.getReturnedPanel());
        mainContentPanel.setPreferredSize(new Dimension(1000, 600));
        // Refresh the GUI to reflect the changes
        mainContentPanel.revalidate();
        mainContentPanel.repaint();

        //add buttons to sidepanel
        sidePanelArea.removeAll();
        sidePanelArea.add(addBeerButton);
        sidePanelArea.add(removeBeerButton);
        sidePanelArea.revalidate();
        sidePanelArea.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttonBeers){
            //if beer is already on screen remove all
            if(beersOnScreen) {
                mainContentPanel.removeAll();
                mainContentPanel.revalidate();
                mainContentPanel.repaint();

                sidePanelArea.removeAll();
                sidePanelArea.revalidate();
                sidePanelArea.repaint();

                beersOnScreen = false;
                recipesOnScreen = false;
                return;
            }
            renderBeer();
        }
        if (e.getSource() == buttonRecipes){
            //if beer is already on screen remove all
            if(recipesOnScreen) {
                mainContentPanel.removeAll();
                mainContentPanel.revalidate();
                mainContentPanel.repaint();

                sidePanelArea.removeAll();
                sidePanelArea.revalidate();
                sidePanelArea.repaint();

                recipesOnScreen = false;
                beersOnScreen = false;
                return;
            }
            recipesOnScreen = true;
            beersOnScreen = false;
            System.out.println("Recipes");
            // Remove all components from the mainContentPanel
            mainContentPanel.removeAll();

            // Add the new content (BeersDisplayPanel) to the mainContentPanel
            RecipeUi recipePanel = new RecipeUi(brewery.getRecipes());
            mainContentPanel.setLayout(new GridLayout(0, 1, 0, 0));
            mainContentPanel.add(recipePanel.getRecipePane());
            mainContentPanel.setPreferredSize(new Dimension(1000, 600));
            recipePanel.dispose();

            // Refresh the GUI to reflect the changes
            mainContentPanel.revalidate();
            mainContentPanel.repaint();

            //add buttons to sidepanel
            sidePanelArea.removeAll();
            sidePanelArea.revalidate();
            sidePanelArea.repaint();
        }
        if (e.getSource() == addBeerButton){
            System.out.println("Add Beer");
            new addBeerUi(brewery, mainContentPanel, this);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
