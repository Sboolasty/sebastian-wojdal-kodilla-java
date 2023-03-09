package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpsTestSuite {
    @Test
    void testWinConditionRock() {
        //Given
        GameLogic; gameLogic = new GameLogic();
        gameLogic.toggleRules();
        String playerMove = MoveList.ROCK.getValue();
        String aiMove = MoveList.SCISSORS.getValue();
        String aiMove2 = MoveList.LIZARD.getValue();
        //When
        boolean returnedWin = gameLogic.checkPlayerWin(playerMove, aiMove);
        boolean returnedWin2 = gameLogic.checkPlayerWin(playerMove, aiMove2);
        //Then
        assertTrue(returnedWin);
        assertTrue(returnedWin2);
    }
}