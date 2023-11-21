package Recipe;

import java.util.ArrayList;

public class Recipe implements java.io.Serializable{
    private String recipeName;
    private String description;
    private Ingredient malt;
    private Ingredient hops;
    private Ingredient yeast;
    private Ingredient water;
    private Ingredient sugar;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String styleName, Ingredient malt, Ingredient hops, Ingredient yeast, Ingredient water, Ingredient sugar) {
        this.recipeName = styleName;
        this.description = "Receita de " + styleName + ".";
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
        this.water = water;
        this.sugar = sugar;
        this.ingredients = new ArrayList<Ingredient>();
    }

    public String getStyleName() {
        return recipeName;
    }
    public String getDescription() {
        return description;
    }
    public Ingredient getMalt() {
        return malt;
    }
    public Ingredient getHops() {
        return hops;
    }
    public Ingredient getYeast() {
        return yeast;
    }
    public Ingredient getWater() {
        return water;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
