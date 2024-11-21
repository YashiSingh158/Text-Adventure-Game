# Text-Adventure-Game
**Overview**
This is a text-based adventure game written in Java. Players explore rooms, collect items, interact with NPCs, and battle enemies to achieve the ultimate goal: finding the treasure in the Treasure Room.

**Features**
**Game Navigation:**
  Navigate between rooms using commands like go north, go south, etc.
  Each room has a description and possible exits.
**Inventory System:**
  Collect items found in rooms.
  Use the check inventory command to view collected items.
**NPC Interaction:**
  Interact with NPCs in certain rooms using the talk command.
  NPCs provide hints or items.
**Combat System:**
  Fight enemies in combat using the attack command.
  Players can also choose to run from battles.
  Health values for the player and enemies are displayed during combat.
**Win Condition:**
  Reach the Treasure Room and collect the treasure to win.
  If the player's health reaches zero, the game ends with "Game Over."
**Commands**
  Movement: go [direction] (e.g., go north, go south).
  Inventory: check inventory.
  NPC Interaction: talk.
  Combat:
    attack: Attack the enemy.
    run: Run from combat.
  Help: help (Displays a list of available commands).

# How to Play
Clone the repository:
git clone https://github.com/your-username/TextAdventureGame.git
Open the project in IntelliJ IDEA (or any Java IDE).
Compile and run the TextAdventureGame.java file.
Use the commands to explore, interact, and complete the game.

# Room Descriptions and Layout
**Entrance:**
  Starting point of the game.
  Exits: North (Forest), East (Dungeon).

**Forest:**
  A dense forest with faint noises.
  Contains a Potion.
  NPC provides a hint about the Treasure Room.
  Exit: South (Entrance).

**Dungeon:**
  A dark and damp dungeon.
  Ghost NPC gives a warning about the Treasure Room.
  Exits: North (Treasure Room), West (Entrance).

**Treasure Room:**
  Contains the treasure (goal of the game).
  A monster appears for the final combat.
  Exit: South (Dungeon).
  
# Requirements
  Java Development Kit (JDK): Version 8 or higher.
  Java IDE: IntelliJ IDEA, Eclipse, or similar.

**Example Gameplay :**

Welcome to the Adventure Game!
Type 'help' for a list of commands.

You are at the entrance of a mysterious dungeon.
Exits:
- north (Forest)
- east (Dungeon)

> go north
You are in a dense forest. You hear faint noises.
You found a Potion!

> check inventory
Inventory: Potion

> talk
You meet a wise old man. He gives you a hint: "The treasure lies to the north of the dungeon."

> go south
You are at the entrance of a mysterious dungeon.

> go east
A dark and damp dungeon. It smells of mold.
A ghost whispers: "Beware of the monster in the treasure room."
