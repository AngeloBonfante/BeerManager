package GUI;

import Recipe.Ingredient;
import Recipe.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class RecipeUi extends JFrame {


    JPanel returnedPanel;

    public RecipeUi(List<Recipe> recipes) {
        super("Recipes");
        setSize(700, 700);
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
        returnedPanel = new JPanel(new GridLayout(0,1,0,0));

        contentList.setBackground(Color.BLUE);

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        for(Recipe recipe : recipes) {

            JPanel recipeCell = new JPanel(new GridLayout(0,1,0,0));
            recipeCell.setPreferredSize(new Dimension(250, 450));
            recipeCell.setBackground(Color.WHITE);
            recipeCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel labelStyleName = new JLabel("Style Name: " + recipe.getStyleName());
            labelStyleName.setFont(new Font("Arial", Font.BOLD, 20));
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
            textAreaDescription.setFont(new Font("Arial", Font.PLAIN, 20));

            JScrollPane descPane = new JScrollPane(textAreaDescription);
            descPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            descPane.setPreferredSize(new Dimension(250, 100));
            recipeCell.add(descPane);

            JPanel ingredientsPanel = new JPanel(new GridLayout(0,2,0,0));

            JLabel labelMaltName = new JLabel("Malt: " + recipe.getMalt().getName() + recipe.getMalt().getQuantity() + " kg");
            labelMaltName.setFont(labelFont);
            labelMaltName.setForeground(Color.BLUE);
            labelMaltName.setHorizontalAlignment(JLabel.CENTER);
            ingredientsPanel.add(labelMaltName);

            JLabel labelHopsName = new JLabel("Hops: " + recipe.getHops().getName() + recipe.getHops().getQuantity() + " kg");
            labelHopsName.setFont(labelFont);
            labelHopsName.setForeground(Color.BLUE);
            labelHopsName.setHorizontalAlignment(JLabel.CENTER);
            ingredientsPanel.add(labelHopsName);

            JLabel labelYeastName = new JLabel("Yeast: " + recipe.getYeast().getName() + recipe.getYeast().getQuantity() + " kg");
            labelYeastName.setFont(labelFont);
            labelYeastName.setForeground(Color.BLUE);
            labelYeastName.setHorizontalAlignment(JLabel.CENTER);
            ingredientsPanel.add(labelYeastName);

            JLabel labelWaterName = new JLabel("Water: " + recipe.getWater().getQuantity() + "L");
            labelWaterName.setFont(labelFont);
            labelWaterName.setForeground(Color.BLUE);
            labelWaterName.setHorizontalAlignment(JLabel.CENTER);
            ingredientsPanel.add(labelWaterName);

            JLabel labelSugarName = new JLabel("Sugar: " + recipe.getSugar().getQuantity() + "kg");
            labelSugarName.setFont(labelFont);
            labelSugarName.setForeground(Color.BLUE);
            labelSugarName.setHorizontalAlignment(JLabel.CENTER);
            ingredientsPanel.add(labelSugarName);





            ArrayList<Ingredient> ingredients = recipe.getIngredients();

            if(ingredients.isEmpty()){
                JLabel labelIngredientName = new JLabel("No extra Ingredient");
                labelIngredientName.setFont(labelFont);
                labelIngredientName.setForeground(Color.BLUE);
                labelIngredientName.setHorizontalAlignment(JLabel.CENTER);
                ingredientsPanel.add(labelIngredientName);
            }

            for(Ingredient ingredient : ingredients) {
                JLabel labelIngredientName = new JLabel(ingredient.getName() + ": " + ingredient.getQuantity() + " kg");
                labelIngredientName.setFont(labelFont);
                labelIngredientName.setForeground(Color.BLUE);
                labelIngredientName.setHorizontalAlignment(JLabel.CENTER);
                ingredientsPanel.add(labelIngredientName);
            }

            recipeCell.add(ingredientsPanel);
            contentList.add(recipeCell);
        }
        JScrollPane recipeListScroll = new JScrollPane(contentList);
        recipeListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        recipeListScroll.setPreferredSize(new Dimension(600, 600));
        add(recipeListScroll, BorderLayout.CENTER);
        returnedPanel.add(recipeListScroll);
        setVisible(true);
    }

    public JPanel getRecipePane(){
        return returnedPanel;
    }
}