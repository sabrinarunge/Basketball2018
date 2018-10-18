package com.company;

public class PlayerPeg
{
    private int position;
    private String name;
    private int score;
    private int turns;
    private int additionalTurns;
    private int fouls;

    public PlayerPeg(String name)
    {
        this.name = name;
        score = 0;
        fouls = 1;
        turns = 0;
        additionalTurns = 1;
    }

    public String getName() // Returns the name of the player
    {
        return name;
    }
    public int getScore() // Returns the player's score
    {
        return score;
    }

    public void scorePoints(int points) //Returns the player's total score
    {
        score += points;
    }

    public int getFouls() //Returns the number of fouls
    {
        return fouls++;
    }

    public int getTurns() //Returns the number of turns a player adds to the game by fouling
    {
        return turns++;
    }

    public int getAdditionalTurns()
    {
        if (fouls >= 1 && fouls < 5)
        {
            return additionalTurns ++;
        }

        else if (fouls >= 5 && fouls <= 10)
        {
            return additionalTurns += 3;
        }
        return additionalTurns;
    }
}
