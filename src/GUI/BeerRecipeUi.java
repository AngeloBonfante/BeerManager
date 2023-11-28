package GUI;

import Recipe.Ingredient;
import Recipe.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class BeerRecipeUi extends JFrame {
    public BeerRecipeUi(Recipe recipe) {
        super(recipe.getStyleName());
        setSize(400, 700);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        };
        addWindowListener(windowListener);
        setLayout(new GridLayout(0,1,0,0));

        Font uniformFont = new Font("Arial", Font.PLAIN, 18);

        JLabel labelStyleName = new JLabel("Style Name: " + recipe.getStyleName());
        labelStyleName.setFont(uniformFont);
        JTextArea textAreaDescription = new JTextArea("Description: " + recipe.getDescription());
        textAreaDescription.setFont(uniformFont);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setEditable(false);
        textAreaDescription.setOpaque(false);
        textAreaDescription.setBorder(null);

        JScrollPane descriptionScrollPane = new JScrollPane(textAreaDescription);
        descriptionScrollPane.setPreferredSize(new Dimension(380, 270));

        JPanel MainIngredientsPanel = new JPanel(new GridLayout(0,2,0,0));
        JPanel TopPanel = new JPanel(new FlowLayout());
        TopPanel.setPreferredSize(new Dimension(380, 100));

        JLabel labelMaltName = new JLabel("Malt: " + recipe.getMalt().getName() + " | " + recipe.getMalt().getQuantity() + " kg");
        labelMaltName.setFont(uniformFont);
        labelMaltName.setPreferredSize(new Dimension(100, 100));
        labelMaltName.setBackground(Color.YELLOW);
        labelMaltName.setOpaque(true);
        JLabel labelHopsName = new JLabel("Hops: " + recipe.getHops().getName() + " | " + recipe.getHops().getQuantity() + " kg");
        labelHopsName.setFont(uniformFont);
        JLabel labelYeastName = new JLabel("Yeast: " + recipe.getYeast().getName() + " | " + recipe.getYeast().getQuantity() + " kg");
        labelYeastName.setFont(uniformFont);
        JLabel labelWaterName = new JLabel("Water: " + recipe.getWater().getQuantity() + " L");
        labelWaterName.setFont(uniformFont);
        JLabel labelSugarName = new JLabel("Sugar: " + recipe.getSugar().getQuantity() + " kg");
        labelSugarName.setFont(uniformFont);

        ArrayList<Ingredient> ingredients = recipe.getIngredients();

        JPanel ingredientPanel = new JPanel(new GridLayout(0,1,0,0));

        MainIngredientsPanel.add(labelMaltName);
        MainIngredientsPanel.add(labelHopsName);
        MainIngredientsPanel.add(labelYeastName);
        MainIngredientsPanel.add(labelWaterName);
        MainIngredientsPanel.add(labelSugarName);

        for(Ingredient ingredient : ingredients) {
            JLabel labelIngredientName = new JLabel(ingredient.getName() + ": " + ingredient.getQuantity() + " " + "kg");
            labelIngredientName.setFont(uniformFont);
            ingredientPanel.add(labelIngredientName);
            MainIngredientsPanel.add(labelIngredientName);
        }

        JScrollPane MainIngredientsScrollPane = new JScrollPane(MainIngredientsPanel);

        JScrollPane ingredientScrollPane = new JScrollPane(ingredientPanel);
        ingredientScrollPane.setPreferredSize(new Dimension(550, 350));

        TopPanel.add(labelStyleName);
        TopPanel.add(descriptionScrollPane);

        add(TopPanel);
        add(MainIngredientsScrollPane);

        setVisible(true);
    }
}