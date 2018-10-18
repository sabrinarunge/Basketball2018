package com.company;

import java.util.Scanner;

public class Basketball
{
    public static void main(String[] args)
    {
        playGame();
    }

    private static void playGame()
    {
        int numberOfTurns = 100;

        System.out.println("Welcome to the arena!");    //Start the basketball game

        Scanner in = new Scanner(System.in);

        System.out.println("Player One enter your name:");  //Get players' names
        //String name = in.nextLine();
        String name = "Sabrina";
        PlayerPeg playerOne = new PlayerPeg(name);

        System.out.println("Player Two enter your name:");
        //name = in.nextLine();
        name = "Hannah";
        PlayerPeg playerTwo = new PlayerPeg(name);

        boolean gameOver = false;

        PairOfDice dice = new PairOfDice();
        PlayerPeg currentPlayer = playerOne;

        do
        {
            dice.roll();    //Roll the dice and total each player's points     //Roll the dice
            int points = getPoints(dice.getDieTotalValue());    //Get the player's number of points from the roll

            System.out.println(currentPlayer.getName() + " rolled a " + dice.getDieTotalValue() + ".");
            currentPlayer.scorePoints(points);      //Get player's total points

            if (currentPlayer.getTurns() >= numberOfTurns / 2)     //If player reaches 50 turns, the game is over
            {
                System.out.println(currentPlayer.getName() + "'s final score is " + currentPlayer.getScore());
                gameOver = true;

                if (playerOne.getScore() > playerTwo.getScore())
                {
                    System.out.println("Game Over. Winner is " + playerOne.getName() + "!");
                }

                else if (playerTwo.getScore() > playerOne.getScore())
                {
                    System.out.println("Game Over. Winner is " + playerTwo.getName() + "!");
                }
            }
            else if (currentPlayer.getTurns() < numberOfTurns / 2)
            {
                System.out.println(currentPlayer.getName() + "'s score is " + currentPlayer.getScore());

                if (dice.getDieTotalValue() == 11)      //determine how many turns the player added by fouling
                {
                    System.out.print(currentPlayer.getName() + " has fouled " + currentPlayer.getFouls() + " time(s). ");
                    System.out.println(currentPlayer.getName() + " has added " + currentPlayer.getAdditionalTurns() + " turns to the game.");
                }

                currentPlayer = togglePlayer(currentPlayer, playerOne, playerTwo);      //toggle between players

            }

        } while (!gameOver);
    }

    private static PlayerPeg togglePlayer(PlayerPeg currentPlayer, PlayerPeg playerOne, PlayerPeg playerTwo)    //Toggle between players
    {
        PlayerPeg nextPlayer;

        if (currentPlayer == playerOne)
        {
            nextPlayer = playerTwo;
        } else
        {
            nextPlayer = playerOne;
        }

        return nextPlayer;
    }

    private static int getPoints(int diceTotal)     //Determine how many points each player gets based on their dice roll
    {
        int points = 0;

        if (diceTotal == 5)
        {
            points = 1;
        } else if (diceTotal == 4 || diceTotal == 6 || diceTotal == 8)
        {
            points = 2;
        } else if (diceTotal == 2 || diceTotal == 10 || diceTotal == 12)
        {
            points = 3;
        }

        return points;
    }
}
