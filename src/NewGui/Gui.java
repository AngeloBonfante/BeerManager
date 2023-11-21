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

    JMenuBar menuBar;

    boolean beersOnScreen = false;
    boolean recipesOnScreen = false;


    public Gui(Brewery brewery) {
        super("Brewery");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.brewery = brewery;

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu options = new JMenu("Options");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem New = new JMenuItem("New");
        JMenuItem colorPickMenuItem = new JMenuItem("Color");

        saveMenuItem.addActionListener(e -> brewery.save("Brewery.beer"));

        loadMenuItem.addActionListener(e -> {
            this.brewery = brewery.load("Brewery.beer");
            this.dispose();
            new Gui(this.brewery);

        });

        exitMenuItem.addActionListener(e -> System.exit(0));

        New.addActionListener(e -> {
            this.dispose();
            new Gui(new Brewery());
        });

        colorPickMenuItem.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
            if (selectedColor != null) {
                mainContentPanel.setBackground(selectedColor);
            }
        });

        fileMenu.add(New);
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        options.add(colorPickMenuItem);

        JPanel buttonMenu = new JPanel(new GridLayout(1,2,0,0));
        mainContentPanel= new JPanel(new GridLayout(0,4,0,0));
        sidePanelArea = new JPanel(new GridLayout(0,1,0,0));

        mainContentPanel.setBackground(Color.BLUE);

        buttonMenu.setPreferredSize(new Dimension(0, 100));
        sidePanelArea.setPreferredSize(new Dimension(0, 0));

        buttonBeers = new JButton("Beers");
        buttonRecipes = new JButton("Recipes");

        buttonBeers.addMouseListener(this);
        buttonRecipes.addMouseListener(this);

        buttonBeers.setFocusable(false);
        buttonRecipes.setFocusable(false);

        buttonBeers.setPreferredSize(new Dimension(100, 100));
        buttonRecipes.setPreferredSize(new Dimension(100, 100));

        buttonBeers.setBorderPainted(false);
        buttonRecipes.setBorderPainted(false);
        buttonBeers.setBackground(Color.YELLOW);
        buttonRecipes.setBackground(Color.YELLOW);

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

        addBeerButton.setBorderPainted(false);
        removeBeerButton.setBorderPainted(false);
        addBeerButton.setBackground(Color.YELLOW);
        removeBeerButton.setBackground(Color.YELLOW);

        sidePanelArea.setLayout(new GridLayout(0,1,0,0));

        menuBar.add(fileMenu);
        menuBar.add(options);
        this.setJMenuBar(menuBar);

        this.add(buttonMenu, BorderLayout.SOUTH);
        this.add(mainContentPanel, BorderLayout.CENTER);
        this.add(sidePanelArea, BorderLayout.WEST);

        renderIngredients();
        setVisible(true);
    }


    public void renderBeer(){
        recipesOnScreen = false;
        beersOnScreen = true;
        System.out.println("Beers");
        mainContentPanel.removeAll();
        BeersDisplayPanel beersDisplayPanel = new BeersDisplayPanel(brewery);
        beersDisplayPanel.dispose();
        mainContentPanel.setLayout(new GridLayout(0, 1, 0, 0));
        mainContentPanel.add(beersDisplayPanel.getReturnedPanel());
        mainContentPanel.setPreferredSize(new Dimension(1000, 600));
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
        sidePanelArea.removeAll();
        sidePanelArea.add(addBeerButton);
        sidePanelArea.add(removeBeerButton);
        sidePanelArea.setPreferredSize(new Dimension(100, 0));
        sidePanelArea.revalidate();
        sidePanelArea.repaint();
    }

    public void renderRecipes(){
        recipesOnScreen = true;
        beersOnScreen = false;
        System.out.println("Recipes");
        mainContentPanel.removeAll();
        RecipeUi recipePanel = new RecipeUi(brewery.getRecipes());
        mainContentPanel.setLayout(new GridLayout(0, 1, 0, 0));
        mainContentPanel.add(recipePanel.getRecipePane());
        mainContentPanel.setPreferredSize(new Dimension(1000, 600));
        recipePanel.dispose();
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
        sidePanelArea.removeAll();
        sidePanelArea.setPreferredSize(new Dimension(0, 0));
        sidePanelArea.revalidate();
        sidePanelArea.repaint();
    }

    public void renderIngredients(){
        System.out.println("Ingredients");
        mainContentPanel.removeAll();
        JLabel label = new JLabel("Ingredients");
        mainContentPanel.setLayout(new BorderLayout());
        mainContentPanel.add(label, BorderLayout.NORTH);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
        sidePanelArea.removeAll();
        sidePanelArea.setPreferredSize(new Dimension(0, 0));
        sidePanelArea.revalidate();
        sidePanelArea.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttonBeers){
            if(beersOnScreen) {
                mainContentPanel.removeAll();
                mainContentPanel.revalidate();
                mainContentPanel.repaint();

                sidePanelArea.removeAll();
                sidePanelArea.setPreferredSize(new Dimension(0, 0));
                sidePanelArea.revalidate();
                sidePanelArea.repaint();

                beersOnScreen = false;
                recipesOnScreen = false;
                return;
            }
            renderBeer();
        }

        if (e.getSource() == buttonRecipes){
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
            renderRecipes();
        }

        if (e.getSource() == addBeerButton){
            System.out.println("Add Beer");
            new addBeerUi(brewery, mainContentPanel, this);
        }

        if (e.getSource() == removeBeerButton){
            System.out.println("Remove Beer");
            String beerName = JOptionPane.showInputDialog("Enter the name of the beer to remove:");
            brewery.removeBeer(beerName);
            mainContentPanel.removeAll();
            mainContentPanel.revalidate();
            mainContentPanel.repaint();
            renderBeer();
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
