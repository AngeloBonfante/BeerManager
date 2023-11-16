package Brewery;

import Recipe.Recipe;
import Stockpile.Beer;
import java.util.ArrayList;
import java.util.Map;

public class Brewery {
    /*Uma cervejaria tem Estoque e Receitas*/
    private ArrayList<Beer> Stockpile;
    private ArrayList<Recipe> Recipes;

    public Brewery() {
        this.Stockpile = new ArrayList<Beer>();
        this.Recipes = new ArrayList<Recipe>();
    }

    public void addBeer(Beer beer) {
        this.Stockpile.add(beer);
    }

    public void addRecipe(Recipe recipe) {
        this.Recipes.add(recipe);
    }

    public ArrayList<Beer> getStockpile() {
        return Stockpile;
    }
    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }
}
