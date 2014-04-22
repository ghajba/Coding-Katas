package biz.hahamo.dev.katas.tennisgame;

import java.util.HashMap;
import java.util.Map;

/**
 * http://agilekatas.co.uk/katas/tennis-kata.html
 * 
 * @author GHajba
 *
 */
public class TennisGame
{
    private static final Map<Integer, String> POINT_TO_SCORE = new HashMap<Integer, String>();
    
    static
    {
        POINT_TO_SCORE.put(0, "love");
        POINT_TO_SCORE.put(1, "fifteen");
        POINT_TO_SCORE.put(2, "thirty");
        POINT_TO_SCORE.put(3, "forty");
    }
    
    private int player1Score = 0;
    private int player2Score = 0;
    /**
     * This method returns the score of the game.
     * 
     * @return the Score of the game
     */
    public String getActualScore()
    {
        if(player1Score >= 4 && player1Score-player2Score >= 2)
        {
            return "player one wins";
        }
        if(player2Score >= 4 && player2Score-player1Score >= 2)
        {
            return "player two wins";
        }
        
        if(player1Score >= 3 && player2Score >= 3)
        {
            if(player1Score == player2Score)
            {
                return "deuce";
            }
            if(player1Score > player2Score)
            {
                return "advantage player one";
            }
            return "advantage player two";
        }
        
        if(player1Score == player2Score)
        {
            return POINT_TO_SCORE.get(player1Score)+"-all";
        }
        
        
        return POINT_TO_SCORE.get(player1Score) + "-" + POINT_TO_SCORE.get(player2Score);
    }

    /**
     * Sets score to the players
     * 
     * @param player1 the score of player 1
     * @param player2 the score of player 2
     */
    public void setScore(int player1, int player2)
    {
        this.player1Score = player1;
        this.player2Score = player2;
    }
}
