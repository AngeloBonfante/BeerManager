package GUI;

import Recipe.Recipe;
import Recipe.Ingredient;
import Stockpile.Beer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class addBeerUi extends JFrame implements ActionListener {

    Beer newBeer;
    String styleName;
    String type;
    double abv;
    double ibu;
    double volume;
    double price;
    Recipe newRecipe;

    JTextField styleNameField;
    JTextField typeField;
    JTextField abvField;
    JTextField ibuField;
    JTextField volumeField;
    JTextField priceField;

    JTextField recipeNameField;
    JTextArea recipeDescriptionField;
    JTextField recipeMaltField;
    JTextField recipeHopsField;
    JTextField recipeYeastField;
    JTextField recipeWaterField;
    JTextField recipeSugarField;
    JTextField recipeExtraField;

    ArrayList<Ingredient> extraIngredients;

    JButton addIngredient;
    JButton submit;




    public addBeerUi(){
        super("Add Beer");
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

        JLabel styleNameLabel = new JLabel("Style Name");
        JLabel typeLabel = new JLabel("Type");
        JLabel abvLabel = new JLabel("ABV");
        JLabel ibuLabel = new JLabel("IBU");
        JLabel volumeLabel = new JLabel("Volume");
        JLabel priceLabel = new JLabel("Price");

        styleNameField = new JTextField();
        styleNameField.setPreferredSize(new Dimension(140, 15));
        typeField = new JTextField();
        typeField.setPreferredSize(new Dimension(140, 15));
        abvField = new JTextField();
        abvField.setPreferredSize(new Dimension(140, 15));
        ibuField = new JTextField();
        ibuField.setPreferredSize(new Dimension(140, 15));
        volumeField = new JTextField();
        volumeField.setPreferredSize(new Dimension(140, 15));
        priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(140, 15));

        JPanel styleNamePanel = new JPanel(new GridLayout());
        styleNamePanel.add(styleNameLabel);
        styleNamePanel.add(styleNameField);
        styleNamePanel.setBackground(Color.GREEN);
        styleNamePanel.setPreferredSize(new Dimension(230, 20));
        JPanel typePanel = new JPanel(new GridLayout());
        typePanel.add(typeLabel);
        typePanel.add(typeField);
        typePanel.setBackground(Color.GREEN);
        typePanel.setPreferredSize(new Dimension(230, 20));
        JPanel abvPanel = new JPanel(new GridLayout());
        abvPanel.add(abvLabel);
        abvPanel.add(abvField);
        abvPanel.setBackground(Color.GREEN);
        abvPanel.setPreferredSize(new Dimension(230, 20));
        JPanel ibuPanel = new JPanel(new GridLayout());
        ibuPanel.add(ibuLabel);
        ibuPanel.add(ibuField);
        ibuPanel.setBackground(Color.GREEN);
        ibuPanel.setPreferredSize(new Dimension(230, 20));
        JPanel volumePanel = new JPanel(new GridLayout());
        volumePanel.add(volumeLabel);
        volumePanel.add(volumeField);
        volumePanel.setBackground(Color.GREEN);
        volumePanel.setPreferredSize(new Dimension(230, 20));
        JPanel pricePanel = new JPanel(new GridLayout());
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        pricePanel.setBackground(Color.GREEN);
        pricePanel.setPreferredSize(new Dimension(230, 20));


        JLabel recipeNameLabel = new JLabel("Recipe Name");
        JLabel recipeDescriptionLabel = new JLabel("Description");
        JLabel recipeMaltLabel = new JLabel("Malt");
        JLabel recipeHopsLabel = new JLabel("Hops");
        JLabel recipeYeastLabel = new JLabel("Yeast");
        JLabel recipeWaterLabel = new JLabel("Water");
        JLabel recipeSugarLabel = new JLabel("Sugar");
        JLabel recipeExtraLabel = new JLabel("Extra");


        recipeNameField = new JTextField();
        recipeNameField.setPreferredSize(new Dimension(140, 15));
        recipeDescriptionField = new JTextArea();
        recipeDescriptionField.setPreferredSize(new Dimension(140, 80));
        recipeDescriptionField.setLineWrap(true);
        recipeDescriptionField.setWrapStyleWord(true);
        recipeMaltField = new JTextField();
        recipeMaltField.setPreferredSize(new Dimension(140, 15));
        recipeHopsField = new JTextField();
        recipeHopsField.setPreferredSize(new Dimension(140, 15));
        recipeYeastField = new JTextField();
        recipeYeastField.setPreferredSize(new Dimension(140, 15));
        recipeWaterField = new JTextField();
        recipeWaterField.setPreferredSize(new Dimension(140, 15));
        recipeSugarField = new JTextField();
        recipeSugarField.setPreferredSize(new Dimension(140, 15));
        recipeExtraField = new JTextField();
        recipeExtraField.setPreferredSize(new Dimension(140, 15));

        JPanel recipeNamePanel = new JPanel(new GridLayout());
        recipeNamePanel.add(recipeNameLabel);
        recipeNamePanel.add(recipeNameField);
        recipeNamePanel.setBackground(Color.GREEN);
        recipeNamePanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeDescriptionPanel = new JPanel(new GridLayout());
        recipeDescriptionPanel.add(recipeDescriptionLabel);
        recipeDescriptionPanel.add(recipeDescriptionField);
        recipeDescriptionPanel.setBackground(Color.GREEN);
        recipeDescriptionPanel.setPreferredSize(new Dimension(230, 80));
        JPanel recipeMaltPanel = new JPanel(new GridLayout());
        recipeMaltPanel.add(recipeMaltLabel);
        recipeMaltPanel.add(recipeMaltField);
        recipeMaltPanel.setBackground(Color.GREEN);
        recipeMaltPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeHopsPanel = new JPanel(new GridLayout());
        recipeHopsPanel.add(recipeHopsLabel);
        recipeHopsPanel.add(recipeHopsField);
        recipeHopsPanel.setBackground(Color.GREEN);
        recipeHopsPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeYeastPanel = new JPanel(new GridLayout());
        recipeYeastPanel.add(recipeYeastLabel);
        recipeYeastPanel.add(recipeYeastField);
        recipeYeastPanel.setBackground(Color.GREEN);
        recipeYeastPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeWaterPanel = new JPanel(new GridLayout());
        recipeWaterPanel.add(recipeWaterLabel);
        recipeWaterPanel.add(recipeWaterField);
        recipeWaterPanel.setBackground(Color.GREEN);
        recipeWaterPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeSugarPanel = new JPanel(new GridLayout());
        recipeSugarPanel.add(recipeSugarLabel);
        recipeSugarPanel.add(recipeSugarField);
        recipeSugarPanel.setBackground(Color.GREEN);
        recipeSugarPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeExtraPanel = new JPanel(new GridLayout());
        recipeExtraPanel.add(recipeExtraLabel);
        recipeExtraPanel.add(recipeExtraField);
        recipeExtraPanel.setBackground(Color.GREEN);
        recipeExtraPanel.setPreferredSize(new Dimension(230, 20));
        JPanel addExtraIngredientPanel = new JPanel(new GridLayout());
        addIngredient = new JButton("Add Ingredient");
        addExtraIngredientPanel.add(addIngredient);
        addExtraIngredientPanel.setBackground(Color.GREEN);
        addExtraIngredientPanel.setPreferredSize(new Dimension(230, 20));
        extraIngredients = new ArrayList<>();

        JPanel submitPanel = new JPanel(new GridLayout());
        submit = new JButton("Add Beer!");
        submitPanel.add(submit);
        submitPanel.setBackground(Color.GREEN);
        submitPanel.setPreferredSize(new Dimension(230, 50));




        JPanel beerPanel = new JPanel(new FlowLayout());
        JPanel recipePanel = new JPanel(new FlowLayout());
        getContentPane().setBackground(Color.ORANGE);
        beerPanel.setBackground(Color.BLUE);
        recipePanel.setBackground(Color.RED);
        beerPanel.setPreferredSize(new Dimension(290, 600));
        recipePanel.setPreferredSize(new Dimension(290, 600));


        beerPanel.add(styleNamePanel);
        beerPanel.add(typePanel);
        beerPanel.add(abvPanel);
        beerPanel.add(ibuPanel);
        beerPanel.add(volumePanel);
        beerPanel.add(pricePanel);
        recipePanel.add(recipeNamePanel);
        recipePanel.add(recipeDescriptionPanel);
        recipePanel.add(recipeMaltPanel);
        recipePanel.add(recipeHopsPanel);
        recipePanel.add(recipeYeastPanel);
        recipePanel.add(recipeWaterPanel);
        recipePanel.add(recipeSugarPanel);
        recipePanel.add(recipeExtraPanel);
        recipePanel.add(addExtraIngredientPanel);
        recipePanel.add(submitPanel);


        add(beerPanel, BorderLayout.WEST);
        add(recipePanel, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
