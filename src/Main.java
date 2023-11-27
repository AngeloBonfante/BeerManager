import Brewery.Brewery;
import NewGui.Gui;

public class Main {
    public static void main(String[] args) {
        Brewery brewery = new Brewery();
        brewery.createDummyFile();
        new Gui(brewery);
    }




}