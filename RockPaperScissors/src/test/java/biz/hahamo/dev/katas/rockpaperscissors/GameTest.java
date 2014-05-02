package biz.hahamo.dev.katas.rockpaperscissors;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import biz.hahamo.dev.katas.rockpaperscissors.GameLogic.Hand;

public class GameTest
{
    @Test(dataProvider = "handsProvider")
    public void determineWinner(Hand h1, Hand h2, int exceptedResult)
    {
        GameLogic game = new GameLogic();
        assertEquals(game.determineWinner(h1,h2), exceptedResult);
    }
    
    @DataProvider(name = "handsProvider")
    public Object[][] provideHands()
    {
        return new Object[][] {
            {Hand.ROCK, Hand.PAPER, 2},
            {Hand.ROCK, Hand.SCISSORS, 1},
            {Hand.ROCK, Hand.LIZARD, 1},
            {Hand.ROCK, Hand.SPOCK, 2},
            {Hand.ROCK, Hand.ROCK, 0},
            {Hand.PAPER, Hand.PAPER, 0},
            {Hand.PAPER, Hand.SCISSORS, 2},
            {Hand.PAPER, Hand.LIZARD, 2},
            {Hand.PAPER, Hand.SPOCK, 1},
            {Hand.PAPER, Hand.ROCK, 1},
            {Hand.SCISSORS, Hand.PAPER, 1},
            {Hand.SCISSORS, Hand.SCISSORS, 0},
            {Hand.SCISSORS, Hand.LIZARD, 1},
            {Hand.SCISSORS, Hand.SPOCK, 2},
            {Hand.SCISSORS, Hand.ROCK, 2},
            {Hand.LIZARD, Hand.PAPER, 1},
            {Hand.LIZARD, Hand.SCISSORS, 2},
            {Hand.LIZARD, Hand.LIZARD, 0},
            {Hand.LIZARD, Hand.SPOCK, 1},
            {Hand.LIZARD, Hand.ROCK, 2},
            {Hand.SPOCK, Hand.PAPER, 2},
            {Hand.SPOCK, Hand.SCISSORS, 1},
            {Hand.SPOCK, Hand.LIZARD, 2},
            {Hand.SPOCK, Hand.SPOCK, 0},
            {Hand.SPOCK, Hand.ROCK, 1}
        };
    }
}
