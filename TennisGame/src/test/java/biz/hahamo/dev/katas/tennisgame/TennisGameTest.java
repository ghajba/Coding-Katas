package biz.hahamo.dev.katas.tennisgame;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TennisGameTest {
    
  @Test(dataProvider="testDataProvider")
  public void getActualScore(int player1Score, int player2Score, String expectedScore) {
      
      TennisGame tennisGame = new TennisGame();
      
      tennisGame.setScore(player1Score, player2Score);
      
      assertEquals(tennisGame.getActualScore(), expectedScore);
  }
  
  
  @DataProvider(name="testDataProvider")
  public Object[][] createTestData()
  {
      
      return new Object[][] {
          {1, 0,"fifteen-love"},
          {1, 1, "fifteen-all"},
          {2, 3, "thirty-forty"},
          {0, 3, "love-forty"},
          {3, 3, "deuce"},
          {5, 5, "deuce"},
          {4, 3, "advantage player one"},
          {4, 5, "advantage player two"},
          {4, 0, "player one wins"},
          {5, 3, "player one wins"},
          {6, 8, "player two wins"}
      };
  }
}
