package Brewery;

import Recipe.Recipe;
import Stockpile.Beer;
import Recipe.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Brewery implements Serializable {
    /*Uma cervejaria tem Estoque e Receitas*/
    private ArrayList<Beer> Stockpile;
    private ArrayList<Recipe> Recipes;

    private Color color;
    private Color fontColor;
    private Color buttonColor;


    public Brewery() {
        this.Stockpile = new ArrayList<Beer>();
        this.Recipes = new ArrayList<Recipe>();
        this.color = Color.BLUE;
        this.fontColor = Color.BLACK;
        this.buttonColor = Color.YELLOW;
    }

    public void addBeer(Beer beer) {
        this.Stockpile.add(beer);
    }

    public void addRecipe(Recipe recipe) {
        this.Recipes.add(recipe);
    }

    public void removeBeer(String beerName){
        for (int i = 0; i < Stockpile.size(); i++) {
            if(Stockpile.get(i).getStyleName().equalsIgnoreCase(beerName)){
                Stockpile.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Beer Not Found!");
    }

    public ArrayList<Beer> getStockpile() {
        return Stockpile;
    }
    public ArrayList<Recipe> getRecipes() {
        return Recipes;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getFontColor() {
        return fontColor;
    }
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
    public Color getButtonColor() {
        return buttonColor;
    }
    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
    }

    public void save(String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))){
            outputStream.writeObject(this);
            System.out.println("Brewery saved successfully.");
        }catch (IOException error){
            System.out.println(error.getMessage());
        }

    }
    public Brewery load(String filename){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))){
            Brewery brewery = (Brewery) inputStream.readObject();
            System.out.println("Brewery loaded successfully.");
            return brewery;
        } catch (IOException | ClassNotFoundException error){
            System.out.println(error.getMessage());
            return null;
        }

    }
    public void createDummyFile(){

        Ingredient malt = new Ingredient("malt", 1, "1");
        Ingredient hops = new Ingredient("hops", 1, "1");
        Ingredient yeast = new Ingredient("yeast", 1, "1");
        Ingredient water = new Ingredient("water", 1, "1");
        Ingredient sugar = new Ingredient("sugar", 2, "1");

        Recipe temprecipe1 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe2 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe3 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe4 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe5 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe6 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe7 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);
        Recipe temprecipe8 = new Recipe("IPA Special Recipe", malt, hops, yeast, water, sugar);

        temprecipe1.setDescription("idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        temprecipe2.setDescription("idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        temprecipe3.setDescription("idk lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        Beer temp1 = new Beer("test1", "IPA", 1,1,1,1,temprecipe1);
        Beer temp2 = new Beer("test2", "IPA", 1,1,1,1,temprecipe1);
        Beer temp3 = new Beer("test3", "IPA", 1,1,1,1,temprecipe1);
        Beer temp4 = new Beer("test4", "IPA", 1,1,1,1,temprecipe1);
        Beer temp5 = new Beer("test5", "IPA", 1,1,1,1,temprecipe1);
        Beer temp6 = new Beer("test6", "IPA", 1,1,1,1,temprecipe1);

        this.addRecipe(temprecipe1);
        this.addRecipe(temprecipe2);
        this.addRecipe(temprecipe3);
        this.addRecipe(temprecipe4);
        this.addRecipe(temprecipe5);
        this.addRecipe(temprecipe6);
        this.addRecipe(temprecipe7);
        this.addRecipe(temprecipe8);

        this.addBeer(temp1);
        this.addBeer(temp2);
        this.addBeer(temp3);
        this.addBeer(temp4);
        this.addBeer(temp5);
        this.addBeer(temp6);
    }
}
