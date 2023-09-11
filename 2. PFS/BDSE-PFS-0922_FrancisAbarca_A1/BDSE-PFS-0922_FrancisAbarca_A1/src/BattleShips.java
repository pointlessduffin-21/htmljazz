import java.util.Scanner;


public class BattleShips {
    public static int rows = 10;
    public static int cols = 10;
    public static int playerShips;
    public static int aiShips;
    public static String[][] grid = new String[rows][cols];
    public static int[][] missedGuesses = new int[rows][cols];
    public static void main(String[] args){
        System.out.println("**** Welcome to the Battleship game (Java Edition) ****");
        System.out.println("The ocean is empty rn\n");
        makeOceanMap();
        deployUserShips();
        deployAIShips();
        do {
            Battle();
        }while(BattleShips.playerShips != 0 && BattleShips.aiShips != 0);
        gameOver();
        newGame();
    }

    public static void makeOceanMap(){
        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();
    }

    public static int readInt(Scanner scan,String wrongmessage) {
        while(true) {
            if(scan.hasNextInt()) {
                return scan.nextInt();
            }else {
                scan.next();
                System.out.println(wrongmessage+" Type Again");
            }
        }
    }

    public static void clr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void deployUserShips(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeploy your ships:");
        BattleShips.playerShips = 5;
        for (int i = 1; i <= BattleShips.playerShips; ) {
            System.out.print("Input an X coordinate for your " + i + " ship: ");
            int x = readInt(input,"You entered a string!");
            System.out.print("Input an Y coordinate for your " + i + " ship: ");
            int y = readInt(input,"You entered a string!");
            if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
                grid[x][y] = "@";
                i++;
            } else if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && grid[x][y] == "@")
                System.out.println("Oops! A ship has already occupied this area.");
            else if ((x < 0 || x >= rows) || (y < 0 || y >= cols))
                System.out.println("You can't place ships outside the " + rows + " by " + cols + " grid");
        }
        printOceanMap();
        clr();
    }



    public static void deployAIShips(){
        System.out.println("AI is now deploying its ships");
        BattleShips.aiShips = 5;
        for (int i = 1; i <= BattleShips.aiShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            if((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "x";
                System.out.println("Ship " + i +  " has been deployed");
                i++;
            }
        }
        clr();
    }

    public static void Battle(){
        playerTurn();
        computerTurn();
        printOceanMap();
        System.out.println();
        System.out.println("Your ships: " + BattleShips.playerShips + " | AI's ships: " + BattleShips.aiShips);
        System.out.println();
    }

    public static void playerTurn(){
        System.out.println("Your Turn");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Input an X coordinate: ");
            x = readInt(input,"You entered a string!");
            System.out.print("Input an Y coordinate: ");
            y = readInt(input,"You entered a string!");
            if ((x >= 0 && x < rows) && (y >= 0 && y < cols))
            {
                if (grid[x][y] == "x")
                {
                    System.out.println("Lucky shot! You sunk one of the AI's ships!");
                    grid[x][y] = "!";
                    --BattleShips.aiShips;
                }
                else if (grid[x][y] == "@") {
                    System.out.println("You sunk your own ship.");
                    grid[x][y] = "x";
                    --BattleShips.playerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("You missed!");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= rows) || (y < 0 || y >= cols))
                System.out.println("You can't place ships outside the " + rows + " by " + cols + " grid");
        }while((x < 0 || x >= rows) || (y < 0 || y >= cols));
    }

    public static void computerTurn(){
        System.out.println("\nAI'S TURN");
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if ((x >= 0 && x < rows) && (y >= 0 && y < cols))
            {
                if (grid[x][y] == "@")
                {
                    System.out.println("The AI has sunk one of your ships!");
                    grid[x][y] = "x";
                    --BattleShips.playerShips;
                }
                else if (grid[x][y] == "x") {
                    System.out.println("The AI has sunk one of its own ships");
                    grid[x][y] = "!";
                    --BattleShips.aiShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("The AI missed");
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= rows) || (y < 0 || y >= cols));
    }
    public static void gameOver(){
        System.out.println("Your ships: " + BattleShips.playerShips + " | Computer ships: " + BattleShips.aiShips);
        if(BattleShips.playerShips > 0 && BattleShips.aiShips <= 0)
            System.out.println("Congratulations! You are the winner!");
        else
            System.out.println("Better Luck Next Time!");
    }

    public static void newGame() {
        Scanner startover = new Scanner(System.in);
        System.out.println();
        System.out.println("Do you wanna start again?");
        System.out.println();
        System.out.println("Type yes to continue...");
        System.out.println("Type no to quit the game.");
        String start = startover.next().toUpperCase();
        if (start.endsWith("S")) {
            System.out.println("**** Welcome to the Battleship game (Java Edition) ****");
            System.out.println("The ocean is empty rn\n");
            makeOceanMap();
            deployUserShips();
            deployAIShips();
            do {
                Battle();
            }while(BattleShips.playerShips != 0 && BattleShips.aiShips != 0);
            gameOver();
            newGame();
        } else {
            System.exit(0);
        }
    }

    public static void printOceanMap(){
        System.out.println();
        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();
    }
}

