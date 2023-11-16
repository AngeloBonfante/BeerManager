package GUI;

import Recipe.Recipe;
import Recipe.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeerRecipeUi extends JFrame {
    public BeerRecipeUi(Recipe recipe) {
        super("Beer Recipe");
        setSize(300, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1,0,0));

        JLabel labelStyleName = new JLabel("Style Name: " + recipe.getStyleName());
        JLabel labelDescription = new JLabel("Description: " + recipe.getDescription());

        JLabel labelMaltName = new JLabel("Malt: " + recipe.getMalt().getName() + recipe.getMalt().getQuantity() + " kg");
        JLabel labelHopsName = new JLabel("Hops: " + recipe.getHops().getName() + recipe.getHops().getQuantity() + " kg");
        JLabel labelYeastName = new JLabel("Yeast: " + recipe.getYeast().getName() + recipe.getYeast().getQuantity() + " kg");
        JLabel labelWaterName = new JLabel("Water: " + recipe.getWater().getQuantity() + "L");

        ArrayList<Ingredient> ingredients = recipe.getIngredients();

        for(Ingredient ingredient : ingredients) {
            JLabel labelIngredientName = new JLabel(ingredient.getName() + ": " + ingredient.getQuantity() + " kg");
            add(labelIngredientName);
        }




        add(labelStyleName);
        add(labelDescription);
        add(labelMaltName);
        add(labelHopsName);
        add(labelYeastName);
        add(labelWaterName);



        setVisible(true);
    }
}
