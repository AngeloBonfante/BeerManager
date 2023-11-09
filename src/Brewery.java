import Recipe.Recipe;
import Stockpile.Beer;
import java.util.ArrayList;

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

}
