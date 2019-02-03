package thydungeonmangame;

public class DungeonMan {

    /**
     * I have a comment
     */
    public void printOpeningScreen() {

    }

    public void describeLocation() {

    }

    public void promptForCommand() {

    }

    public String getLocation() {
        return "";
    }

    public void atMain(String command) {
    }

    public void atNorth(String command) {
        switch (command) {
            case "GO SOUTH":
                System.out.println("You head back to the main room.");
                break;
            case "LOOK":
                System.out.println("There is a scroll here.");
                break;
            case "GET SCROLL":
                System.out.println("You try to pick up the scroll, but it's too slippery.");
                break;
        }
    }

    public void atSouth(String command) {
    }

    public void atDennis(String command) {
        switch (command) {
            case "TALK DENNIS":
                System.out.println("Dennis tells you all about parapets. Amazing!");
                break;
            case "DIE":
                System.out.println("That was foolish.");
                break;
            case "GO NOT DENNIS":
                System.out.println("You head back to the main room.");
                break;
        }
    }

    public void badLocation() {
    }

    public boolean isGameOver() {
        return false;
    }

    public void printPlayAgain() {
    }

}
