package Stockpile;

import Recipe.Recipe;

public class Beer implements java.io.Serializable{
    private String StyleName;
    private String type;
    private double abv;
    private double ibu;
    private double volume;
    private double price;
    private Recipe recipe;

    public Beer(String styleName, String type, double abv, double ibu, double volume, double price, Recipe recipe) {
        StyleName = styleName;
        this.type = type;
        this.abv = abv;
        this.ibu = ibu;
        this.volume = volume;
        this.price = price;
        this.recipe = recipe;
    }

    public String getStyleName() {
        return StyleName;
    }

    public String getType() {
        return type;
    }

    public double getAbv() {
        return abv;
    }

    public double getIbu() {
        return ibu;
    }

    public double getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
