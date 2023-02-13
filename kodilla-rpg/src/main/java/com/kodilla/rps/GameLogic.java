package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static com.kodilla.rps.MoveList.*;

public class GameLogic {
    int wins = 0;
    int losses = 0;
    int rounds = 0;
    int currentRound = 0;
    boolean end = false;
   // boolean cheatOn = false;
    boolean extendedRules = false;
    String playerName = "";
    Scanner scanner = new Scanner(System.in);
    void newGame(){
        wins = 0;
        losses = 0;
        currentRound = 1;
        rounds = 0;
        playerName = "";
        System.out.println("Starting new game.");
        while(playerName.equals(""))
        {
            System.out.println("Please enter your name: ");
            playerName = scanner.nextLine();
        }
        while(rounds == 0)
        {
            System.out.println("Please enter number of rounds in order to win: ");
            try {
                rounds = scanner.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("Please enter a number!");
            }
            scanner.nextLine();
        }
    }
    void nextMove() {
        System.out.println();
        System.out.println(playerName + ",enter your move");
        System.out.println("(1)rock (2)paper (3)scissors");
        if (extendedRules) System.out.println("(4)lizard (5)spock");
        System.out.println("(r)change rules (h)help on extended rules");
        System.out.print("(n)new game (x)exit: ");
        String input = scanner.nextLine();

        switch (input) {
            case "x" -> {
                System.out.println("Are you sure to exit? (y/n): ");
                if ("y".equals(scanner.nextLine())) end = true;
            }
            case "n" -> {
                System.out.println("Are you sure to start new game? (y/n): ");
                if ("y".equals(scanner.nextLine())) newGame();
            }

            case "r" -> toggleRules();
            case "h" -> System.out.println("""
                    rock > scissors, lizard
                    scissors > paper, lizard
                    paper > rock, spock
                    lizard > paper, spock
                    spock > rock, scissors""");
            case "1", "2", "3", "4", "5" -> {
                String playerMove = MoveList.values()[Integer.parseInt(input)-1].getValue();
                String aiMove = getAiMove(playerMove);
                if (!extendedRules && (input.equals("4") || input.equals("5")))
                {
                    System.out.println("Invalid input!");
                }
                else if (Objects.equals(playerMove, aiMove)) {
                    System.out.println("Tie!");
                } else if (checkPlayerWin(playerMove, aiMove)) {
                    System.out.println("You win round!");
                    wins++;
                } else {
                    System.out.println("You lose round!");
                    losses++;
                }
                nextRound();
            }
            default -> System.out.println("Invalid input!");
        }
    }
    String getAiMove(String playerMove) {
        int nextRandom;
        Random random = new Random();
        String aiMove ="";


            nextRandom = random.nextInt(4);
            switch (nextRandom){
                case 0 -> aiMove = playerMove;
                case 1 -> {
                    if (playerMove.equals(MoveList.ROCK.getValue())) aiMove= MoveList.PAPER.getValue();
                    if (playerMove.equals(MoveList.PAPER.getValue())) aiMove= MoveList.SCISSORS.getValue();
                    if (playerMove.equals(MoveList.SCISSORS.getValue())) aiMove= MoveList.ROCK.getValue();
                    if (playerMove.equals(MoveList.LIZARD.getValue())) aiMove= MoveList.ROCK.getValue();
                    if (playerMove.equals(MoveList.SPOCK.getValue())) aiMove= MoveList.LIZARD.getValue();
                }
                case 2,3 -> {
                    if (playerMove.equals(MoveList.ROCK.getValue())) aiMove= MoveList.SCISSORS.getValue();
                    if (playerMove.equals(MoveList.PAPER.getValue())) aiMove= MoveList.ROCK.getValue();
                    if (playerMove.equals(MoveList.SCISSORS.getValue())) aiMove= MoveList.PAPER.getValue();
                    if (playerMove.equals(MoveList.LIZARD.getValue())) aiMove= MoveList.SPOCK.getValue();
                    if (playerMove.equals(MoveList.SPOCK.getValue())) aiMove= MoveList.ROCK.getValue();
                }
            }

        System.out.println("Ai move: " + aiMove);
        return aiMove;
    }
    void nextRound(){
        currentRound++;
        System.out.println("Current round: " + currentRound);
        System.out.println("Your wins: " + wins +"/"+rounds);
        System.out.println("Your loses: " + losses+"/"+rounds);
    }
    void checkFinalWin(){
        if (wins >= rounds) {
            System.out.println("You won game vs Ai! Game took " + currentRound +" rounds");
            newGame();
        }
        if (losses >= rounds) {
            System.out.println("You lose game vs Ai! Game took " + currentRound +" rounds");
            newGame();
        }
    }

    boolean checkPlayerWin(String playerMove, String aiMove) {
        return (playerMove.equals(MoveList.ROCK.getValue()) && (aiMove.equals(MoveList.SCISSORS.getValue()) || aiMove.equals(MoveList.LIZARD.getValue())))
                || (playerMove.equals(MoveList.PAPER.getValue()) && (aiMove.equals(MoveList.ROCK.getValue()) || aiMove.equals(MoveList.SPOCK.getValue())))
                || (playerMove.equals(MoveList.SCISSORS.getValue()) && (aiMove.equals(MoveList.PAPER.getValue()) || aiMove.equals(MoveList.LIZARD.getValue())))
                || (playerMove.equals(MoveList.LIZARD.getValue()) && (aiMove.equals(MoveList.PAPER.getValue()) || aiMove.equals(MoveList.SPOCK.getValue())))
                || (playerMove.equals(MoveList.SPOCK.getValue()) && (aiMove.equals(MoveList.ROCK.getValue()) || aiMove.equals(MoveList.SCISSORS.getValue())));
    }

    void toggleRules()
    {
        extendedRules = !extendedRules;
    }
    public boolean isGameOver() {
        return end;
    }

}