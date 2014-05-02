package biz.hahamo.dev.katas.rockpaperscissors;

import java.util.Random;

/**
 * http://agilekatas.co.uk/katas/rockpaperscissors-kata.html And I didn't want to set the name of the class
 * RockPaperScissors too...
 * 
 * @author GHajba
 */
public class GameLogic
{
    private Random random = new Random();
    public enum Hand
    {
        ROCK(0, "Rock"),
        SPOCK(1, "Spock"),
        PAPER(2, "Paper"),
        LIZARD(3, "Lizard"),
        SCISSORS(4, "Scissors");

        private final int ordinal;
        public final String name;

        Hand(int ordinal, String name)
        {
            this.ordinal = ordinal;
            this.name = name;
        }

        public static Hand fromValue(int value)
        {
            for (Hand h : Hand.values())
            {
                if (h.ordinal == value)
                {
                    return h;
                }
            }
            return null;
        }

        public static Hand fromName(String name)
        {
            for (Hand h : Hand.values())
            {
                if (h.name.equalsIgnoreCase(name))
                {
                    return h;
                }
            }
            return null;
        }
    }

    /**
     * determines the winner of two hands
     * 
     * @param hand1 the hand of the first player
     * @param hand2 the hand of the second player
     * @return 1 for player 1, 2 for player 2, 0 if draw
     */
    public int determineWinner(Hand hand1, Hand hand2)
    {
        if (hand1 == hand2)
            return 0;
        int modulus = modulus(hand1.ordinal - hand2.ordinal, Hand.values().length);
        if (modulus <= 2)
            return 1;
        return 2;
    }
    
    public Hand getRandomHand()
    {
        return Hand.values()[random.nextInt(Hand.values().length)];
    }
    
    private int modulus(int a, int mod)
    {
        return a < 0 ? mod + a : a % mod;
    }
}
