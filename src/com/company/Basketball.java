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
        final int WINNING_SCORE = 21;

        System.out.println("Welcome to the arena!");

        Scanner in = new Scanner(System.in);

        System.out.println("Player One enter your name:");
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
            dice.roll();    //Roll the dice and total each player's points
            int points = getPoints(dice.getDieTotalValue());
            System.out.println(currentPlayer.getName() + " rolled a " + dice.getDieTotalValue() + ".");
            currentPlayer.scorePoints(points);

            if (playerOne.getScore() >= WINNING_SCORE || playerTwo.getScore() >= WINNING_SCORE)     //If player reaches 21, the game is over
            {
                System.out.println(currentPlayer.getName() + "'s final score is " + currentPlayer.getScore());
                gameOver = true;
            } else
            {
                System.out.println(currentPlayer.getName() + "'s score is " + currentPlayer.getScore());
                currentPlayer = togglePlayer(currentPlayer, playerOne, playerTwo);
            }

        } while (!gameOver);

        System.out.println("Game Over. Winner is " + currentPlayer.getName() + "!");


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
