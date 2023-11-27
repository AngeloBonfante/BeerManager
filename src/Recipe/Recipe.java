package Recipe;

import java.util.ArrayList;

public class Recipe implements java.io.Serializable{
    private final String recipeName;
    private String description;
    private final Ingredient malt;
    private final Ingredient hops;
    private final Ingredient yeast;
    private final Ingredient water;
    private final Ingredient sugar;
    private final ArrayList<Ingredient> ingredients;

    public Recipe(String styleName, Ingredient malt, Ingredient hops, Ingredient yeast, Ingredient water, Ingredient sugar) {
        this.recipeName = styleName;
        this.description = "Receita de " + styleName + ".";
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
        this.water = water;
        this.sugar = sugar;
        this.ingredients = new ArrayList<>();
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
    public Ingredient getSugar() {
        return sugar;
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
