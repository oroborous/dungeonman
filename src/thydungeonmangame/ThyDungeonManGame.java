package thydungeonmangame;

import java.util.Scanner;

/**
 *
 * @author bschultz43
 */
public class ThyDungeonManGame {

    public static void main(String[] args) {
        DungeonMan dude = new DungeonMan();
        playGame(dude);
    }

    public static void playGame(DungeonMan dude) {
        Scanner keyboard = new Scanner(System.in);
        String command;

        String playAgain = "y";

        do {
            dude.printOpeningScreen();
            dude.describeLocation();

            do {
                dude.promptForCommand();
                command = keyboard.nextLine();
                switch (dude.getLocation()) {
                    case "main":
                        dude.atMain(command);
                        break;
                    case "north":
                        dude.atNorth(command);
                        break;
                    case "south":
                        dude.atSouth(command);
                        break;
                    case "dennis":
                        dude.atDennis(command);
                        break;
                    default:
                        dude.badLocation();
                }
            } while (!dude.isGameOver());

            dude.printPlayAgain();
            playAgain = keyboard.nextLine();

        } while (playAgain.toLowerCase().equals("y"));
    }
}
