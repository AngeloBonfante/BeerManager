package GUI;

import Recipe.Recipe;
import Recipe.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class RecipeUi extends JFrame {
    public RecipeUi(List<Recipe> recipes) {
        super("Recipes");
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

        JPanel contentList = new JPanel(new GridLayout(0,2,0,0));
        contentList.setPreferredSize(new Dimension(550, 500));
        JScrollPane recipeListScroll = new JScrollPane(contentList);
        recipeListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        recipeListScroll.setPreferredSize(new Dimension(600, 500));
        contentList.setBackground(Color.BLUE);

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        for(Recipe recipe : recipes) {

//            JPanel upperPanel = new JPanel(new GridLayout(0,1,0,0));
//            JPanel lowerPanel = new JPanel(new GridLayout(0,1,0,0));

            JPanel recipeCell = new JPanel(new GridLayout(0,1,0,0));
            recipeCell.setPreferredSize(new Dimension(250, 400));
            recipeCell.setBackground(Color.WHITE);
            recipeCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel labelStyleName = new JLabel("Style Name: " + recipe.getStyleName());
            labelStyleName.setFont(labelFont);
            labelStyleName.setForeground(Color.BLUE);
            labelStyleName.setHorizontalAlignment(JLabel.CENTER);
            recipeCell.add(labelStyleName);

            JTextArea textAreaDescription = new JTextArea("Description: " + recipe.getDescription());
            textAreaDescription.setFont(labelFont);
            textAreaDescription.setForeground(Color.BLUE);
            textAreaDescription.setLineWrap(true);
            textAreaDescription.setWrapStyleWord(true);
            textAreaDescription.setEditable(false);
            textAreaDescription.setOpaque(false);
            textAreaDescription.setBorder(null);
            recipeCell.add(textAreaDescription);

            JLabel labelMaltName = new JLabel("Malt: " + recipe.getMalt().getName() + recipe.getMalt().getQuantity() + " kg");
            labelMaltName.setFont(labelFont);
            labelMaltName.setForeground(Color.BLUE);
            labelMaltName.setHorizontalAlignment(JLabel.CENTER);
            recipeCell.add(labelMaltName);


            JLabel labelHopsName = new JLabel("Hops: " + recipe.getHops().getName() + recipe.getHops().getQuantity() + " kg");
            labelHopsName.setFont(labelFont);
            labelHopsName.setForeground(Color.BLUE);
            labelHopsName.setHorizontalAlignment(JLabel.CENTER);
            recipeCell.add(labelHopsName);

            JLabel labelYeastName = new JLabel("Yeast: " + recipe.getYeast().getName() + recipe.getYeast().getQuantity() + " kg");
            labelYeastName.setFont(labelFont);
            labelYeastName.setForeground(Color.BLUE);
            labelYeastName.setHorizontalAlignment(JLabel.CENTER);
            recipeCell.add(labelYeastName);

            JLabel labelWaterName = new JLabel("Water: " + recipe.getWater().getQuantity() + "L");
            labelWaterName.setFont(labelFont);
            labelWaterName.setForeground(Color.BLUE);
            labelWaterName.setHorizontalAlignment(JLabel.CENTER);
            recipeCell.add(labelWaterName);



            ArrayList<Ingredient> ingredients = recipe.getIngredients();

            for(Ingredient ingredient : ingredients) {
                JLabel labelIngredientName = new JLabel(ingredient.getName() + ": " + ingredient.getQuantity() + " kg");
                labelIngredientName.setFont(labelFont);
                labelIngredientName.setForeground(Color.BLUE);
                labelIngredientName.setHorizontalAlignment(JLabel.CENTER);
                recipeCell.add(labelIngredientName);
            }


            contentList.add(recipeCell);
//            contentList.add(upperPanel);
//            contentList.add(lowerPanel);
        }

        add(recipeListScroll, BorderLayout.CENTER);
        setVisible(true);
    }
}