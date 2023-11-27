package GUI;

import Brewery.Brewery;
import NewGui.Gui;
import Recipe.Ingredient;
import Recipe.Recipe;
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

    JPanel mainCont;
    Gui guiInst;

    public addBeerUi(Brewery brewery, JPanel mainCont, Gui guiInst) {
        super("Add Beer");
        this.brewery = brewery;
        this.mainCont = mainCont;
        this.guiInst = guiInst;
        setSize(590, 600);
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
        styleNamePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        styleNamePanel.setForeground(Color.WHITE);
        styleNamePanel.setPreferredSize(new Dimension(230, 20));

        JPanel typePanel = new JPanel(new GridLayout());
        typePanel.add(typeLabel);
        typePanel.add(typeField);
        typePanel.setPreferredSize(new Dimension(230, 20));
        typePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));


        JPanel abvPanel = new JPanel(new GridLayout());
        abvPanel.add(abvLabel);
        abvPanel.add(abvField);
        abvPanel.setPreferredSize(new Dimension(230, 20));
        abvPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JPanel ibuPanel = new JPanel(new GridLayout());
        ibuPanel.add(ibuLabel);
        ibuPanel.add(ibuField);
        ibuPanel.setPreferredSize(new Dimension(230, 20));
        ibuPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JPanel volumePanel = new JPanel(new GridLayout());
        volumePanel.add(volumeLabel);
        volumePanel.add(volumeField);
        volumePanel.setPreferredSize(new Dimension(230, 20));
        volumePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JPanel pricePanel = new JPanel(new GridLayout());
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);
        pricePanel.setPreferredSize(new Dimension(230, 20));
        pricePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JLabel recipeNameLabel = new JLabel("Recipe Name");
        JLabel recipeDescriptionLabel = new JLabel("Description");
        JLabel recipeMaltLabel = new JLabel("Malt");
        JLabel recipeHopsLabel = new JLabel("Hops");
        JLabel recipeYeastLabel = new JLabel("Yeast");
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
        recipeDescriptionField.setPreferredSize(new Dimension(140, 510));
        recipeDescriptionField.setLineWrap(true);
        recipeDescriptionField.setWrapStyleWord(true);
        recipeDescriptionField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        recipeMaltField = new JTextField();
        recipeMaltField.setPreferredSize(new Dimension(140, 15));
        recipeHopsField = new JTextField();
        recipeHopsField.setPreferredSize(new Dimension(140, 15));
        recipeYeastField = new JTextField();
        recipeYeastField.setPreferredSize(new Dimension(140, 15));
        recipeWaterField = new JTextField();
        recipeWaterField.setPreferredSize(new Dimension(140, 15));
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
        recipeNamePanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeDescriptionPanel = new JPanel(new GridLayout(1,0,0,0));
        JScrollPane scrollPane = new JScrollPane(recipeDescriptionField);
        recipeDescriptionPanel.add(scrollPane);
        recipeDescriptionPanel.setPreferredSize(new Dimension(230, 110));
        recipeDescriptionPanel.setBackground(Color.BLUE);

        JPanel recipeMaltPanel = new JPanel(new GridLayout());
        recipeMaltPanel.add(recipeMaltLabel);
        recipeMaltPanel.add(recipeMaltField);
        recipeMaltPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeMaltAmountPanel = new JPanel(new GridLayout());
        recipeMaltAmountPanel.add(recipeMaltAmountLabel);
        recipeMaltAmountPanel.add(recipeMaltAmountField);
        recipeMaltAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeHopsPanel = new JPanel(new GridLayout());
        recipeHopsPanel.add(recipeHopsLabel);
        recipeHopsPanel.add(recipeHopsField);
        recipeHopsPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeHopsAmountPanel = new JPanel(new GridLayout());
        recipeHopsAmountPanel.add(recipeHopsAmountLabel);
        recipeHopsAmountPanel.add(recipeHopsAmountField);
        recipeHopsAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeYeastPanel = new JPanel(new GridLayout());
        recipeYeastPanel.add(recipeYeastLabel);
        recipeYeastPanel.add(recipeYeastField);
        recipeYeastPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeYeastAmountPanel = new JPanel(new GridLayout());
        recipeYeastAmountPanel.add(recipeYeastAmountLabel);
        recipeYeastAmountPanel.add(recipeYeastAmountField);
        recipeYeastAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeWaterAmountPanel = new JPanel(new GridLayout());
        recipeWaterAmountPanel.add(recipeWaterAmountLabel);
        recipeWaterAmountPanel.add(recipeWaterAmountField);
        recipeWaterAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeSugarAmountPanel = new JPanel(new GridLayout());
        recipeSugarAmountPanel.add(recipeSugarAmountLabel);
        recipeSugarAmountPanel.add(recipeSugarAmountField);
        recipeSugarAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeExtraPanel = new JPanel(new GridLayout());
        recipeExtraPanel.add(recipeExtraLabel);
        recipeExtraPanel.add(recipeExtraField);
        recipeExtraPanel.setPreferredSize(new Dimension(230, 20));

        JPanel recipeExtraAmountPanel = new JPanel(new GridLayout());
        recipeExtraAmountPanel.add(recipeExtraAmountLabel);
        recipeExtraAmountPanel.add(recipeExtraAmountField);
        recipeExtraAmountPanel.setPreferredSize(new Dimension(230, 20));

        JPanel addExtraIngredientPanel = new JPanel(new GridLayout());
        addIngredient = new JButton("Add Ingredient");
        addIngredient.addActionListener(this);
        addExtraIngredientPanel.add(addIngredient);
        addExtraIngredientPanel.setPreferredSize(new Dimension(230, 20));

        extraIngredients = new ArrayList<>();

        submitRecipe = new JButton("Add Recipe!");
        submitBeer = new JButton("Add Beer!");
        submitBeer.addActionListener(this);
        submitRecipe.addActionListener(this);

        JPanel submitRecipePanel = new JPanel(new GridLayout());
        submitRecipePanel.add(submitRecipe);
        submitRecipePanel.setPreferredSize(new Dimension(230, 50));

        JPanel submitBeerPanel = new JPanel(new GridLayout());
        submitBeerPanel.add(submitBeer);
        submitBeerPanel.setPreferredSize(new Dimension(230, 50));
        submitBeer.setEnabled(false);


        JPanel beerPanel = new JPanel(new FlowLayout());
        JPanel recipePanel = new JPanel(new FlowLayout());
        getContentPane().setBackground(Color.ORANGE);
        beerPanel.setPreferredSize(new Dimension(290, 600));
        recipePanel.setPreferredSize(new Dimension(290, 600));

        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setPreferredSize(new Dimension(220, 5));
        JSeparator separator2 = new JSeparator(JSeparator.HORIZONTAL);
        separator2.setPreferredSize(new Dimension(220, 5));
        JSeparator separator3 = new JSeparator(JSeparator.HORIZONTAL);
        separator3.setPreferredSize(new Dimension(220, 5));
        JSeparator separator4 = new JSeparator(JSeparator.HORIZONTAL);
        separator4.setPreferredSize(new Dimension(220, 5));
        JSeparator separator5 = new JSeparator(JSeparator.HORIZONTAL);
        separator5.setPreferredSize(new Dimension(220, 5));
        JSeparator separator6 = new JSeparator(JSeparator.HORIZONTAL);
        separator6.setPreferredSize(new Dimension(220, 5));

        beerPanel.add(styleNamePanel);
        beerPanel.add(typePanel);
        beerPanel.add(abvPanel);
        beerPanel.add(ibuPanel);
        beerPanel.add(volumePanel);
        beerPanel.add(pricePanel);
        beerPanel.add(submitBeerPanel);

        recipePanel.add(recipeNamePanel);
        recipePanel.add(separator6);
        recipePanel.add(recipeMaltPanel);
        recipePanel.add(recipeMaltAmountPanel);
        recipePanel.add(separator3);
        recipePanel.add(recipeHopsPanel);
        recipePanel.add(recipeHopsAmountPanel);
        recipePanel.add(separator4);
        recipePanel.add(recipeYeastPanel);
        recipePanel.add(recipeYeastAmountPanel);
        recipePanel.add(separator5);
        recipePanel.add(recipeWaterAmountPanel);
        recipePanel.add(recipeSugarAmountPanel);
        recipePanel.add(separator);
        recipePanel.add(recipeExtraPanel);
        recipePanel.add(recipeExtraAmountPanel);
        recipePanel.add(addExtraIngredientPanel);
        recipePanel.add(separator2);
        recipePanel.add(recipeDescriptionLabel);
        recipePanel.add(recipeDescriptionPanel);
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

                double maltAmount = Double.parseDouble(recipeMaltAmountField.getText());
                double hopsAmount = Double.parseDouble(recipeHopsAmountField.getText());
                double yeastAmount = Double.parseDouble(recipeYeastAmountField.getText());
                double waterAmount = Double.parseDouble(recipeWaterAmountField.getText());
                double sugarAmount = Double.parseDouble(recipeSugarAmountField.getText());

                Ingredient malt = new Ingredient(maltString, maltAmount, "KG/L");
                Ingredient hops = new Ingredient(hopsString, hopsAmount, "KG/L");
                Ingredient yeast = new Ingredient(yeastString, yeastAmount, "KG/L");
                Ingredient water = new Ingredient("Water", waterAmount, "KG/L");
                Ingredient sugar = new Ingredient("Sugar", sugarAmount, "g");


                newRecipe = new Recipe(name, malt, hops, yeast, water, sugar);
                newRecipe.setDescription(description);

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
                mainCont.removeAll();
                mainCont.revalidate();
                mainCont.repaint();
                guiInst.renderBeer();
                this.dispose();
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please fill all the fields with valid values!");
        }
    }
}