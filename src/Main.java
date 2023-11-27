import Brewery.Brewery;
import NewGui.Gui;
import Recipe.Ingredient;
import Recipe.Recipe;
import Stockpile.Beer;

public class Main {
    public static void main(String[] args) {
        Brewery brewery = new Brewery();
        brewery.createDummyFile();
        new Gui(brewery);
    }




}