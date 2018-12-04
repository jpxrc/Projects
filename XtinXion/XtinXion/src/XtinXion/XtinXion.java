package XtinXion;

import java.util.Scanner;

/**
 * This is the main class that was used to run the text-based version of 
 * the game
 * @author Jon Patman
 */
public class XtinXion {

    public String SpeciesName;

    public static void main(String[] args) {
        
        String SpeciesName = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to XtinXion! "
                + "The game of survival of the fittest.\n");
        System.out.println("Please enter player name: ");
        String name = in.nextLine();
        System.out.println("Select a species type: \n"
                + "1. Species I\n" + "2. Species II\n"
                + "3. Species III\n" + "4. Species IV\n");
        System.out.print("Type number to select a species: ");
        int SpeciesNum = in.nextInt();
        if (SpeciesNum == 1) {
            SpeciesName = "Species I";
        }
        if (SpeciesNum == 2) {
            SpeciesName = "Species II";
        }
        if (SpeciesNum == 3) {
            SpeciesName = "Species III";
        }
        if (SpeciesNum == 4) {
            SpeciesName = "Species IV";
        }
        System.out.println("You have selected " + SpeciesName);

        GameBoard Board = new GameBoard();
        Game game = new Game(Board, name, SpeciesName);
    }
}
