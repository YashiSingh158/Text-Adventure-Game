package Text_Adventure_Game;
import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> rooms = new HashMap<>();
    static Map<String, String[]> exits = new HashMap<>();
    static Map<String, String> itemsInRoom = new HashMap<>();
    static List<String> inventory = new ArrayList<>();
    static int playerHealth = 100;
    static boolean gameRunning = true;
    static String currentRoom = "Entrance";

    public static void main(String[] args) {
        setupGame();
        while (gameRunning) {
            displayRoomDetails();
            String command = scanner.nextLine().toLowerCase();
            processCommand(command);
        }
    }

    static void setupGame() {
        // Setup rooms and descriptions
        rooms.put("Entrance", "You are at the entrance of a mysterious dungeon.");
        rooms.put("Forest", "You are in a dense forest. You hear faint noises.");
        rooms.put("Dungeon", "A dark and damp dungeon. It smells of mold.");
        rooms.put("Treasure Room", "You see a chest filled with gold and jewels!");

        // Setup room exits
        exits.put("Entrance", new String[]{"north:Forest", "east:Dungeon"});
        exits.put("Forest", new String[]{"south:Entrance"});
        exits.put("Dungeon", new String[]{"west:Entrance", "north:Treasure Room"});
        exits.put("Treasure Room", new String[]{"south:Dungeon"});

        // Items in rooms
        itemsInRoom.put("Forest", "Potion");
        itemsInRoom.put("Treasure Room", "Treasure");

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Type 'help' for a list of commands.");
    }

    static void displayRoomDetails() {
        System.out.println("\n" + rooms.get(currentRoom));
        System.out.println("Exits:");
        for (String exit : exits.get(currentRoom)) {
            String[] parts = exit.split(":");
            System.out.println("- " + parts[0] + " (" + parts[1] + ")");
        }
    }

    static void processCommand(String command) {
        switch (command) {
            case "help":
                showHelp();
                break;
            case "check inventory":
                checkInventory();
                break;
            case "talk":
                talk();
                break;
            case "attack":
                attack();
                break;
            case "run":
                run();
                break;
            default:
                if (command.startsWith("go ")) {
                    move(command.substring(3));
                } else {
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
                }
        }
    }

    static void showHelp() {
        System.out.println("Commands:");
        System.out.println("- go [direction]: Move to another room.");
        System.out.println("- check inventory: View your items.");
        System.out.println("- talk: Talk to an NPC.");
        System.out.println("- attack: Attack an enemy.");
        System.out.println("- run: Run from combat.");
    }

    static void checkInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + String.join(", ", inventory));
        }
    }

    static void move(String direction) {
        for (String exit : exits.get(currentRoom)) {
            String[] parts = exit.split(":");
            if (parts[0].equalsIgnoreCase(direction)) {
                currentRoom = parts[1];
                if (itemsInRoom.containsKey(currentRoom)) {
                    System.out.println("You found a " + itemsInRoom.get(currentRoom) + "!");
                    inventory.add(itemsInRoom.remove(currentRoom));
                }
                return;
            }
        }
        System.out.println("You can't go that way.");
    }

    static void talk() {
        if (currentRoom.equals("Forest")) {
            System.out.println("You meet a wise old man. He gives you a hint: 'The treasure lies to the north of the dungeon.'");
        } else if (currentRoom.equals("Dungeon")) {
            System.out.println("A ghost whispers: 'Beware of the monster in the treasure room.'");
        } else {
            System.out.println("There is no one to talk to here.");
        }
    }

    static void attack() {
        if (currentRoom.equals("Treasure Room")) {
            System.out.println("A monster appears!");
            int monsterHealth = 50;
            while (monsterHealth > 0 && playerHealth > 0) {
                System.out.println("Your Health: " + playerHealth + ", Monster's Health: " + monsterHealth);
                System.out.println("Choose: attack or run");
                String action = scanner.nextLine().toLowerCase();
                if (action.equals("attack")) {
                    int damage = new Random().nextInt(20) + 10;
                    monsterHealth -= damage;
                    System.out.println("You hit the monster for " + damage + " damage!");
                    if (monsterHealth > 0) {
                        int monsterDamage = new Random().nextInt(15) + 5;
                        playerHealth -= monsterDamage;
                        System.out.println("The monster hits you for " + monsterDamage + " damage!");
                    }
                } else if (action.equals("run")) {
                    System.out.println("You fled the battle!");
                    return;
                } else {
                    System.out.println("Invalid action!");
                }
            }

            if (playerHealth <= 0) {
                System.out.println("Game Over! You have been defeated.");
                gameRunning = false;
            } else {
                System.out.println("You defeated the monster!");
            }
        } else {
            System.out.println("There is nothing to attack here.");
        }
    }

    static void run() {
        System.out.println("You can't run right now.");
    }
}
