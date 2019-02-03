package thydungeonmangame;

public class DungeonManComplete {

    private int score;
    private String location;
    private boolean trinket;
    private boolean scrollDestroyed;
    private boolean gameOver;
    private int flaskCount;

    /**
     * Constructor. Initializes the game's fields.
     */
    public DungeonManComplete() {
        score = 0;
        location = "main";
        trinket = false;
        scrollDestroyed = false;
        flaskCount = 0;
    }

    /**
     * Prints the title screen to the standard output.
     */
    public void printOpeningScreen() {
        System.out.println("THY DUNGEONMAN\n"
                + "\n\nYOU ARE THY DUNGEONMAN!\n");
    }

    /**
     * Prints a prompt for the user asking if they want to play again. The user
     * should respond with a Y or N.
     */
    public void printPlayAgain() {
        System.out.println("\nPlay again? [Y/N] ");
    }

    private boolean hasTrinket() {
        return trinket;
    }

    private void pickUpTrinket() {
        this.trinket = true;
    }

    /**
     * Returns the player's score.
     *
     * @return The player's score
     */
    public int getScore() {
        return score;
    }

    private void scorePoints(int points) {
        System.out.print("\nYou " + (points >= 0 ? "got " : "lost ") + points + " points.");
        this.score += points;
    }

    /**
     * Returns the player's current location as a String. Valid locations are
     * "north", "south", "main", and "dennis".
     *
     * @return The player's current location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Processes a command issued by the player while in the "main" location.
     * Valid commands for this location are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#Main_Dungeon_Room" target="_blank">here</a>.
     * Valid general commands are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#General_Commands" target="_blank">here</a>.
     * If the player inputs an invalid command, the game should respond
     * appropriately.
     *
     * @param command A String containing the command entered by the player
     */
    public void atMain(String command) {
        switch (command.toLowerCase()) {
            case "help":
                describeLocation();
                break;
            case "die":
                die();
                break;
            case "go north":
                goNorth();
                break;
            case "go south":
                goSouth();
                break;
            case "go dennis":
                goDennis();
                break;
            case "look scroll":
                if (!scrollDestroyed) {
                    System.out.print("\nParchment, definitely parchment. I'd recognize it anywhere.");
                } else {
                    System.out.print("\nYe seeth nothing wheretofore it went ZAP.");
                }
                break;
            case "look flask":
                System.out.print("\nLooks like you could quaff some serious mead out of that thing.");
                break;
            case "get flask":
            case "get ye flask":
            case "flask":
                if (flaskCount < 3) {
                    System.out.print("\nYe cannot get the FLASK. It is firmly bolted "
                            + "to a wall which is bolted to the rest of the dungeon "
                            + "which is probably bolted to a castle. Never you mind.");
                    scorePoints(1);
                    flaskCount++;
                } else {
                    System.out.print("\nOkay, okay. You unbolt yon FLASK and hold it aloft. A great shaking begins. The dungeon ceiling collapses down on you, crushing you in twain. Apparently, this was a load-bearing FLASK.");
                    scorePoints(-1000);
                    gameOver();
                }
                break;
            case "get scroll":
                if (!scrollDestroyed) {
                    System.out.print("\nYe takes the scroll and reads of "
                            + "it. It doth say:\nBEWARE, READER OF THE "
                            + "SCROLL, DANGER AWAITS TO THE-\n\n The "
                            + "SCROLL disappears in thy hands with ye "
                            + "olde ZAP!");
                    scorePoints(2);
                    scrollDestroyed = true;
                } else {
                    System.out.print("Ye doth suffer from memory loss. YE SCROLL is no more. Honestly.");
                    scorePoints(-1);
                }
                break;
            default:
                badCommand();
        }
    }

    /**
     * Processes a command issued by the player while in the "north" location.
     * Valid commands for this location are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#North_of_the_Main_Dungeon_Room" target="_blank">here</a>.
     * Valid general commands are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#General_Commands" target="_blank">here</a>.
     * If the player inputs an invalid command, the game should respond
     * appropriately.
     *
     * @param command A String containing the command entered by the player
     */
    public void atNorth(String command) {
        switch (command.toLowerCase()) {
            case "help":
                describeLocation();
                break;
            case "die":
                die();
                break;
            case "go south":
                goSouth();
                break;
            case "get rope":
                System.out.print("\nYou attempt to take ye ROPE but "
                        + "alas it is enchanted! It glows a mustard "
                        + "red and smells like a public privy.\nThe "
                        + "ROPE wraps round your neck and hangs you "
                        + "from parapets.\nWith your last breath, "
                        + "you wonder what parapets are. GAME OVER.");
                scorePoints(-1);
                gameOver();
                break;
            default:
                badCommand();
        }
    }

    private void goNorth() {
        this.location = "north";
        describeLocation();
    }

    private void goSouth() {
        this.location = "south";
        describeLocation();
    }

    private void goDennis() {
        this.location = "dennis";
        describeLocation();
    }

    private void goMain() {
        this.location = "main";
        describeLocation();
    }

    /**
     * Processes a command issued by the player while in the "south" location.
     * Valid commands for this location are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#South_of_the_Main_Dungeon_Room" target="_blank">here</a>.
     * Valid general commands are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#General_Commands" target="_blank">here</a>.
     * If the player inputs an invalid command, the game should respond
     * appropriately.
     *
     * @param command A String containing the command entered by the player
     */
    public void atSouth(String command) {
        switch (command.toLowerCase()) {
            case "help":
                describeLocation();
                break;
            case "die":
                die();
                break;
            case "go north":
                goMain();
                break;
            case "get trinket":
                if (!hasTrinket()) {
                    System.out.print("\nYe getsts yon TRINKET and discover "
                            + "it to be a bauble. You rejoice at your "
                            + "good fortune. You shove the TRINKET in "
                            + "your pouchel. It kinda hurts.");
                    pickUpTrinket();
                    scorePoints(2);
                } else {
                    System.out.print("\nSigh. The trinket is in thou pouchel. Recallest thou?");
                }
                break;
            default:
                badCommand();
        }
    }

    /**
     * Processes a command issued by the player while in the "main" location.
     * Valid commands for this location are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#Dennis" target="_blank">here</a>.
     * Valid general commands are given
     * <a href="http://www.hrwiki.org/wiki/Thy_Dungeonman#General_Commands" target="_blank">here</a>.
     * If the player inputs an invalid command, the game should respond
     * appropriately.
     *
     * @param command A String containing the command entered by the player
     */
    public void atDennis(String command) {
        switch (command.toLowerCase()) {
            case "help":
                describeLocation();
                break;
            case "die":
                die();
                break;
            case "not dennis":
            case "go not dennis":
                goMain();
                break;
            case "talk to dennis":
                System.out.print("\nYou engage Dennis in leisurely "
                        + "discussion. Ye learns that his jimberjam "
                        + "was purchased on sale at a discount market "
                        + "and that he enjoys pacing about nervously. "
                        + "You become bored and begin thinking about parapets.");
                break;
            case "give trinket":
                if (hasTrinket()) {
                    System.out.print("\nA novel idea! You givst the "
                            + "TRINKET to Dennis and he happily agrees "
                            + "to tell you what parapets are. With this "
                            + "new knowledge, ye escapes from yon "
                            + "dungeon in order to search for new "
                            + "dungeons and to remain... \n\nTHY DUNGEONMAN!! "
                            + "\nYou hath won! Congraturation!!\n");
                    gameOver();
                } else {
                    System.out.print("Thou don'tst have a trinket to give. Go back to your tiny life.");
                }
                break;
            default:
                badCommand();
        }
    }

    /**
     * Prints a description of the player's current location to the standard
     * output.
     */
    public void describeLocation() {
        switch (this.location) {
            case "main":
                System.out.print("\nYe find yeself in yon dungeon. Ye see a SCROLL. "
                        + "Behind ye scroll is a FLASK. Obvious exits are NORTH, "
                        + "SOUTH and DENNIS.");
                if (scrollDestroyed) {
                    System.out.print(" There is definitely no YE SCROLL, so drop it.");
                }
                break;
            case "north":
                System.out.print("\nYou go NORTH through yon corridor. You arrive at "
                        + "parapets. Ye see a ROPE. Obvious exits are SOUTH.");
                break;
            case "south":
                System.out.print("\nYou head south to an enbankment. Or maybe a chasm. "
                        + "You can't decide which. Anyway, ye spies a TRINKET. "
                        + "Obvious exits are NORTH.");
                break;
            case "dennis":
                System.out.print("\nYe arrive at Dennis. He wears a sporty frock coat "
                        + "and a long jimberjam. He paces about nervously. "
                        + "Obvious exits are NOT DENNIS.");
        }
    }

    /**
     * Prints a prompt to the standard output asking the player for a command.
     */
    public void promptForCommand() {
        System.out.print("\n\nWhat wouldst thou deau?\n>");
    }

    /**
     * Prints a message to the standard out telling the player they have
     * requested an invalid location.
     */
    public void badLocation() {
        System.out.print("\nThou cannotst go there. Who do you think thou art? A magistrate?!");
    }

    private void badCommand() {
        System.out.print("\nThat does not computeth. Type HELP is thou needs of it.");
    }

    private void die() {
        System.out.print("That wasn't very smart.");
        gameOver();
    }

    private void gameOver() {
        System.out.print("\n\nYour score was: " + score + ".");
        gameOver = true;
        score = 0;
    }

    /**
     * Returns whether or not the game is over.
     *
     * @return True if the game is over, false
     */
    public boolean isGameOver() {
        return gameOver;
    }
}
