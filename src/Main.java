import Brewery.Brewery;
import GUI.StockpileUi;
import GUI.Ui;
import GUI.addBeerUi;
import Recipe.Recipe;
import Stockpile.Beer;

public class Main {
    public static void main(String[] args) {
        Brewery brewery = new Brewery();
        Recipe temprecipe1 = new Recipe("testRecipe",null,null,null,null);
        Beer temp1 = new Beer("test1", "IPA", 1,1,1,1,temprecipe1);
        Beer temp2 = new Beer("test2", "IPA", 1,1,1,1,temprecipe1);
        Beer temp3 = new Beer("test3", "IPA", 1,1,1,1,temprecipe1);
        Beer temp4 = new Beer("test4", "IPA", 1,1,1,1,temprecipe1);
        Beer temp5 = new Beer("test5", "IPA", 1,1,1,1,temprecipe1);
        Beer temp6 = new Beer("test6", "IPA", 1,1,1,1,temprecipe1);

        brewery.addBeer(temp1);
        brewery.addBeer(temp2);
        brewery.addBeer(temp3);
        brewery.addBeer(temp4);
        brewery.addBeer(temp5);
        brewery.addBeer(temp6);
        Ui ui = new Ui(brewery);
        //new StockpileUi(brewery);

    }
}