package com.company;

public class PairOfDice
{
    private Die dieOne;
    private Die dieTwo;

    public PairOfDice()
    {
        this.dieOne = new Die();
        this.dieTwo = new Die();
    }

    public void roll()
    {
        this.dieOne.roll();
        this.dieTwo.roll();
    }

    public int getDieTotalValue()
    {
        return dieOne.getValue() + dieTwo.getValue();
    }

}
