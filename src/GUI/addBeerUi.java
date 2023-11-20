package GUI;

import Brewery.Brewery;
import Recipe.Recipe;
import Recipe.Ingredient;
import Stockpile.Beer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class addBeerUi extends JFrame implements ActionListener {

    Brewery brewery;

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
//    JTextField recipeSugarField;
    JTextField recipeExtraField;

    JTextField recipeMaltAmountField;
    JTextField recipeHopsAmountField;
    JTextField recipeYeastAmountField;
    JTextField recipeWaterAmountField;
    JTextField recipeSugarAmountField;
    JTextField recipeExtraAmountField;

    ArrayList<Ingredient> extraIngredients;

    JButton addIngredient;
    JButton submitRecipe;
    JButton submitBeer;


    public addBeerUi(Brewery brewery) {
        super("Add Beer");
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
//        JLabel recipeWaterLabel = new JLabel("Water");
//        JLabel recipeSugarLabel = new JLabel("Sugar");
        JLabel recipeExtraLabel = new JLabel("Extra");

        JLabel recipeMaltAmountLabel = new JLabel("Amount (Kg)");
        JLabel recipeHopsAmountLabel = new JLabel("Amount (Kg)");
        JLabel recipeYeastAmountLabel = new JLabel("Amount (Kg)");
        JLabel recipeWaterAmountLabel = new JLabel("Water Amount (L)");
        JLabel recipeSugarAmountLabel = new JLabel("Sugar Amount (g)");
        JLabel recipeExtraAmountLabel = new JLabel("Amount (Kg/L)");


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
//        recipeSugarField = new JTextField();
//        recipeSugarField.setPreferredSize(new Dimension(140, 15));
        recipeExtraField = new JTextField();
        recipeExtraField.setPreferredSize(new Dimension(140, 15));

        recipeMaltAmountField = new JTextField();
        recipeMaltAmountField.setPreferredSize(new Dimension(140, 15));
        recipeHopsAmountField = new JTextField();
        recipeHopsAmountField.setPreferredSize(new Dimension(140, 15));
        recipeYeastAmountField = new JTextField();
        recipeYeastAmountField.setPreferredSize(new Dimension(140, 15));
        recipeWaterAmountField = new JTextField();
        recipeWaterAmountField.setPreferredSize(new Dimension(140, 15));
        recipeSugarAmountField = new JTextField();
        recipeSugarAmountField.setPreferredSize(new Dimension(140, 15));
        recipeExtraAmountField = new JTextField();
        recipeExtraAmountField.setPreferredSize(new Dimension(140, 15));

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
        JPanel recipeMaltAmountPanel = new JPanel(new GridLayout());
        recipeMaltAmountPanel.add(recipeMaltAmountLabel);
        recipeMaltAmountPanel.add(recipeMaltAmountField);
        recipeMaltAmountPanel.setBackground(Color.GREEN);
        recipeMaltAmountPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeHopsPanel = new JPanel(new GridLayout());
        recipeHopsPanel.add(recipeHopsLabel);
        recipeHopsPanel.add(recipeHopsField);
        recipeHopsPanel.setBackground(Color.GREEN);
        recipeHopsPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeHopsAmountPanel = new JPanel(new GridLayout());
        recipeHopsAmountPanel.add(recipeHopsAmountLabel);
        recipeHopsAmountPanel.add(recipeHopsAmountField);
        recipeHopsAmountPanel.setBackground(Color.GREEN);
        recipeHopsAmountPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeYeastPanel = new JPanel(new GridLayout());
        recipeYeastPanel.add(recipeYeastLabel);
        recipeYeastPanel.add(recipeYeastField);
        recipeYeastPanel.setBackground(Color.GREEN);
        recipeYeastPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeYeastAmountPanel = new JPanel(new GridLayout());
        recipeYeastAmountPanel.add(recipeYeastAmountLabel);
        recipeYeastAmountPanel.add(recipeYeastAmountField);
        recipeYeastAmountPanel.setBackground(Color.GREEN);
        recipeYeastAmountPanel.setPreferredSize(new Dimension(230, 20));
//        JPanel recipeWaterPanel = new JPanel(new GridLayout());
//        recipeWaterPanel.add(recipeWaterLabel);
//        recipeWaterPanel.add(recipeWaterField);
//        recipeWaterPanel.setBackground(Color.GREEN);
//        recipeWaterPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeWaterAmountPanel = new JPanel(new GridLayout());
        recipeWaterAmountPanel.add(recipeWaterAmountLabel);
        recipeWaterAmountPanel.add(recipeWaterAmountField);
        recipeWaterAmountPanel.setBackground(Color.GREEN);
        recipeWaterAmountPanel.setPreferredSize(new Dimension(230, 20));
//        JPanel recipeSugarPanel = new JPanel(new GridLayout());
//        recipeSugarPanel.add(recipeSugarLabel);
//        recipeSugarPanel.add(recipeSugarField);
//        recipeSugarPanel.setBackground(Color.GREEN);
//        recipeSugarPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeSugarAmountPanel = new JPanel(new GridLayout());
        recipeSugarAmountPanel.add(recipeSugarAmountLabel);
        recipeSugarAmountPanel.add(recipeSugarAmountField);
        recipeSugarAmountPanel.setBackground(Color.GREEN);
        recipeSugarAmountPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeExtraPanel = new JPanel(new GridLayout());
        recipeExtraPanel.add(recipeExtraLabel);
        recipeExtraPanel.add(recipeExtraField);
        recipeExtraPanel.setBackground(Color.GREEN);
        recipeExtraPanel.setPreferredSize(new Dimension(230, 20));
        JPanel recipeExtraAmountPanel = new JPanel(new GridLayout());
        recipeExtraAmountPanel.add(recipeExtraAmountLabel);
        recipeExtraAmountPanel.add(recipeExtraAmountField);
        recipeExtraAmountPanel.setBackground(Color.GREEN);
        recipeExtraAmountPanel.setPreferredSize(new Dimension(230, 20));
        JPanel addExtraIngredientPanel = new JPanel(new GridLayout());
        addIngredient = new JButton("Add Ingredient");
        addIngredient.addActionListener(this);
        addExtraIngredientPanel.add(addIngredient);
        addExtraIngredientPanel.setBackground(Color.GREEN);
        addExtraIngredientPanel.setPreferredSize(new Dimension(230, 20));

        extraIngredients = new ArrayList<>();

        submitRecipe = new JButton("Add Recipe!");
        submitBeer = new JButton("Add Beer!");
        submitBeer.addActionListener(this);
        submitRecipe.addActionListener(this);

        JPanel submitRecipePanel = new JPanel(new GridLayout());
        submitRecipePanel.add(submitRecipe);
        submitRecipePanel.setBackground(Color.GREEN);
        submitRecipePanel.setPreferredSize(new Dimension(230, 50));

        JPanel submitBeerPanel = new JPanel(new GridLayout());
        submitBeerPanel.add(submitBeer);
        submitBeerPanel.setBackground(Color.GREEN);
        submitBeerPanel.setPreferredSize(new Dimension(230, 50));
        submitBeer.setEnabled(false);


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
        beerPanel.add(submitBeerPanel);
        recipePanel.add(recipeNamePanel);
        recipePanel.add(recipeDescriptionPanel);
        recipePanel.add(recipeMaltPanel);
        recipePanel.add(recipeMaltAmountPanel);
        recipePanel.add(recipeHopsPanel);
        recipePanel.add(recipeHopsAmountPanel);
        recipePanel.add(recipeYeastPanel);
        recipePanel.add(recipeYeastAmountPanel);
//        recipePanel.add(recipeWaterPanel);
        recipePanel.add(recipeWaterAmountPanel);
//        recipePanel.add(recipeSugarPanel);
        recipePanel.add(recipeSugarAmountPanel);
        recipePanel.add(recipeExtraPanel);
        recipePanel.add(recipeExtraAmountPanel);
        recipePanel.add(addExtraIngredientPanel);
        recipePanel.add(submitRecipePanel);


        add(beerPanel, BorderLayout.WEST);
        add(recipePanel, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {


            if (e.getSource() == addIngredient) {
                String name = recipeExtraField.getText();
                double amount = Double.parseDouble(recipeExtraAmountField.getText());
                Ingredient newIngredient = new Ingredient(name, amount, "KG/L");
                extraIngredients.add(newIngredient);
                recipeExtraField.setText("");
                recipeExtraAmountField.setText("");

                System.out.println(name + " " + amount + "KG/L");
                System.out.println("Ingredient added!");
            }

            if (e.getSource() == submitRecipe) {

                String name = recipeNameField.getText();
                String description = recipeDescriptionField.getText();
                String maltString = recipeMaltField.getText();
                String hopsString = recipeHopsField.getText();
                String yeastString = recipeYeastField.getText();
//                String waterString = recipeWaterField.getText();
//                String extraString = recipeExtraField.getText();

                double maltAmount = Double.parseDouble(recipeMaltAmountField.getText());
                double hopsAmount = Double.parseDouble(recipeHopsAmountField.getText());
                double yeastAmount = Double.parseDouble(recipeYeastAmountField.getText());
                double waterAmount = Double.parseDouble(recipeWaterAmountField.getText());
                double sugarAmount = Double.parseDouble(recipeSugarAmountField.getText());
//                double extraAmount = Double.parseDouble(recipeExtraAmountField.getText());

                Ingredient malt = new Ingredient(maltString, maltAmount, "KG/L");
                Ingredient hops = new Ingredient(hopsString, hopsAmount, "KG/L");
                Ingredient yeast = new Ingredient(yeastString, yeastAmount, "KG/L");
                Ingredient water = new Ingredient("Water", waterAmount, "KG/L");


                newRecipe = new Recipe(name, malt, hops, yeast, water);

                if(!extraIngredients.isEmpty()){
                    for (Ingredient ingredient : extraIngredients) {
                        newRecipe.addIngredient(ingredient);
                    }
                }

                recipeNameField.setText("");
                recipeDescriptionField.setText("");
                recipeMaltField.setText("");
                recipeHopsField.setText("");
                recipeYeastField.setText("");
                recipeWaterField.setText("");
//                recipeSugarField.setText("");
                recipeExtraField.setText("");

                recipeMaltAmountField.setText("");
                recipeHopsAmountField.setText("");
                recipeYeastAmountField.setText("");
                recipeWaterAmountField.setText("");
                recipeSugarAmountField.setText("");
                recipeExtraAmountField.setText("");

                submitRecipe.setEnabled(false);
                addIngredient.setEnabled(false);
                submitBeer.setEnabled(true);
                System.out.println("Recipe added!");
            }
            if (e.getSource() == submitBeer) {
                styleName = styleNameField.getText().trim();
                type = typeField.getText().trim();
                abv = Double.parseDouble(abvField.getText().trim());
                ibu = Double.parseDouble(ibuField.getText().trim());
                volume = Double.parseDouble(volumeField.getText().trim());
                price = Double.parseDouble(priceField.getText().trim());

                newBeer = new Beer(styleName, type, abv, ibu, volume, price, newRecipe);

                styleNameField.setText("");
                typeField.setText("");
                abvField.setText("");
                ibuField.setText("");
                volumeField.setText("");
                priceField.setText("");

                submitBeer.setEnabled(false);

                this.brewery.addBeer(newBeer);
                this.brewery.addRecipe(newRecipe);
                System.out.println("Beer Added");
                System.out.println(this.brewery.getStockpile().get(0).getStyleName());
                this.dispose();
                new StockpileUi(brewery);
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please fill all the fields with valid values!");
        }
    }
}