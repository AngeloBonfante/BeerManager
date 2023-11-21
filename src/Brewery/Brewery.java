package Brewery;

import Recipe.Recipe;
import Stockpile.Beer;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Brewery implements Serializable {
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
}
