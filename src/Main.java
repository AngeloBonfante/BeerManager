import Brewery.Brewery;
import GUI.StockpileUi;
import GUI.Ui;
import Recipe.Ingredient;
import GUI.addBeerUi;
import Recipe.Recipe;
import Stockpile.Beer;

public class Main {
    public static void main(String[] args) {
        Brewery brewery = new Brewery();

        //create malt, hops,yeast and water ingredient
        Ingredient malt = new Ingredient("malt", 1, "1");
        Ingredient hops = new Ingredient("hops", 1, "1");
        Ingredient yeast = new Ingredient("yeast", 1, "1");
        Ingredient water = new Ingredient("water", 1, "1");

        //create recipe
        Recipe temprecipe1 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe2 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe3 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe4 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe5 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe6 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe7 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);
        Recipe temprecipe8 = new Recipe("IPA Special Recipe", malt, hops, yeast, water);

        temprecipe1.setDescription("Bro add it to the pan, heat it up or smth, idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        temprecipe2.setDescription("Bro add it to the pan, heat it up or smth, idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        temprecipe3.setDescription("Bro add it to the pan, heat it up or smth, idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        Beer temp1 = new Beer("test1", "IPA", 1,1,1,1,temprecipe1);
        Beer temp2 = new Beer("test2", "IPA", 1,1,1,1,temprecipe1);
        Beer temp3 = new Beer("test3", "IPA", 1,1,1,1,temprecipe1);
        Beer temp4 = new Beer("test4", "IPA", 1,1,1,1,temprecipe1);
        Beer temp5 = new Beer("test5", "IPA", 1,1,1,1,temprecipe1);
        Beer temp6 = new Beer("test6", "IPA", 1,1,1,1,temprecipe1);

        brewery.addRecipe(temprecipe1);
        brewery.addRecipe(temprecipe2);
        brewery.addRecipe(temprecipe3);
        brewery.addRecipe(temprecipe4);
        brewery.addRecipe(temprecipe5);
        brewery.addRecipe(temprecipe6);
        brewery.addRecipe(temprecipe7);
        brewery.addRecipe(temprecipe8);


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