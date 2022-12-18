import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class MyPlayer {

    ArrayList <Board> allBoards = new ArrayList <Board>();

    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {

        columns = new int[10];

        //gameBoard = alive;
        //columns = toColumns(gameBoard);
        columns[0] = 6;
        columns[1] = 6;
        columns[2] = 6;
        columns[3] = 6;
        columns[4] = 6;
        columns[5] = 6;

        int nextMove1 = columns[0]; //a
        int nextMove2 = columns[1]; //b
        int nextMove3 = columns[2]; //c
        int nextMove4 = columns[3]; //d
        int nextMove5 = columns[4]; //e
        int nextMove6 = columns[5]; //f

        nextMove(nextMove1, nextMove2, nextMove3, nextMove4, nextMove5, nextMove6);

          /*for(int a = 1; a < 4; a++){
            for(int b = 0; b <= a; b++){
                for(int c = 0; c <= b; c++){
                    System.out.println(a +","+ b +","+ c);
                    //call make possible moves
                    //one function with three parameters
                }
            }
        }*/


        //updateBoard(randomRow,0);
        //updateBoard(0,randomCol);

        int updateMoveRow = 0;
        int updateMoveCol = 0;

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int [] arr = toColumns(gameBoard);

        System.out.println("current board: "+Arrays.toString(arr));

        int current1 = arr[0];
        int current2 = arr[1];
        int current3 = arr[2];
        int current4 = arr[3];
        int current5 = arr[4];
        int current6 = arr[5];

       // System.out.println(allBoards);

        int column = 0;
        int row = 0;

        for(int i=0; i<allBoards.size(); i++){
//            System.out.println(allBoards.get(i).counter1);
//            System.out.println(allBoards.get(i).counter2);
//            System.out.println(allBoards.get(i).counter3);

            if(current1 == allBoards.get(i).counter1 && current2 == allBoards.get(i).counter2 && current3 == allBoards.get(i).counter3 && current4 == allBoards.get(i).counter4 && current5 == allBoards.get(i).counter5 && current6 == allBoards.get(i).counter6){
                System.out.println(allBoards.get(i).xBest + "," + allBoards.get(i).yBest);
                column = allBoards.get(i).xBest;
                row = allBoards.get(i).yBest;
            }
        }

        //System.out.println("current board: " + Arrays.toString(toColumns(gameBoard)));

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void nextMove(int counter1, int counter2, int counter3, int counter4, int counter5, int counter6){
        int nextMove1 = 0;
        int nextMove2 = 0;
        int nextMove3 = 0;
        int nextMove4 = 0;
        int nextMove5 = 0;
        int nextMove6 = 0;

        ArrayList <String> loseBoards = new ArrayList <String> ();
        loseBoards.add("100000"); //why still able to identify lose boards without this? maybe add to prevent outOfBounds?
        System.out.println(loseBoards);

        ArrayList <String> winBoards = new ArrayList <String> ();
        winBoards.add("110000");
        System.out.println(winBoards);

        ArrayList <String> nextLoseBoards = new ArrayList <String>();
        ArrayList <String> nextWinBoards = new ArrayList <String>();
        ArrayList <String> nextBoards = new ArrayList <String>();

        for(int a = 1; a < 7; a++){
            for(int b = 0; b <= a; b++){
                for(int c = 0; c <= b; c++){
                    for(int d = 0; d <= c; d++){
                        for(int e = 0; e <= d; e++){
                            for(int f = 0; f <= e; f++){
                                System.out.println("\n" + a + "," + b + "," + c + "," + d + "," + e + "," + f);

                                ArrayList <String> nextMoves = new ArrayList<String>();
                                ArrayList <String> localLoseBoards = new ArrayList <String>();
                                ArrayList <String> localWinBoards = new ArrayList<String>();

                                Board currentBoard = new Board(a, b, c, d, e, f);

                                System.out.println("original board:" + currentBoard.counter1 + "," + currentBoard.counter2 + "," + currentBoard.counter3 + "," + currentBoard.counter4 + "," + currentBoard.counter5 + "," + currentBoard.counter6 + "next best move: " + currentBoard.best1 + "," +currentBoard.best2 + ","+currentBoard.best3 + "," + currentBoard.best4 + "," + currentBoard.best5 + "," + currentBoard.best6);

                                //allBoards.add(new Board(a, b, c));

                                counter1 = a;
                                counter2 = b;
                                counter3 = c;
                                counter4 = d;
                                counter5 = e;
                                counter6 = f;

                                String counter = String.valueOf(a) + b + c + d + e + f;

                                boolean tempState = false;
                                boolean state = false;

                                for(int i = counter6-1; i >= 0; i--){
                                    nextMove1 = counter1;
                                    nextMove2 = counter2;
                                    nextMove3 = counter3;
                                    nextMove4 = counter4;
                                    nextMove5 = counter5;
                                    nextMove6 = i;

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves6: " + next);

                                    nextMoves.add(next);
                                }

                                for(int i = counter5-1; i >= 0; i--){
                                    nextMove1 = counter1;
                                    nextMove2 = counter2;
                                    nextMove3 = counter3;
                                    nextMove4 = counter4;
                                    nextMove5 = i;
                                    nextMove6 = counter6;

                                    if(i < counter6){
                                        nextMove6 = i;
                                    }

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves5: " + next);

                                    nextMoves.add(next);
                                }

                                for(int i = counter4-1; i >= 0; i--){
                                    nextMove1 = counter1;
                                    nextMove2 = counter2;
                                    nextMove3 = counter3;
                                    nextMove4 = i;
                                    nextMove5 = counter5;
                                    nextMove6 = counter6;

                                    if(i < counter6){
                                        nextMove6 = i;
                                    }

                                    if(i < counter5){
                                        nextMove5 = i;
                                    }

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves4: " + next);

                                    nextMoves.add(next);
                                }

                                for(int i = counter3-1; i >= 0; i--) {
                                    nextMove1 = counter1;
                                    nextMove2 = counter2;
                                    nextMove3 = i;
                                    nextMove4 = counter4;
                                    nextMove5 = counter5;
                                    nextMove6 = counter6;

                                    if(i < counter6){
                                        nextMove6 = i;
                                    }

                                    if(i < counter5){
                                        nextMove5 = i;
                                    }

                                    if(i < counter4){
                                        nextMove4 = i;
                                    }

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves3: " + next);

                                    nextMoves.add(next);
                                }

                                for(int i = counter2-1; i >= 0; i--){
                                    nextMove1 = counter1;
                                    nextMove2 = i;
                                    nextMove3 = counter3;
                                    nextMove4 = counter4;
                                    nextMove5 = counter5;
                                    nextMove6 = counter6;

                                    if(i < counter6){
                                        nextMove6 = i;
                                    }

                                    if(i < counter5){
                                        nextMove5 = i;
                                    }

                                    if(i < counter4){
                                        nextMove4 = i;
                                    }

                                    if(i < counter3){
                                        nextMove3 = i;
                                    }

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves2: " + next);

                                    nextMoves.add(next);
                                }

                                for (int i = counter1-1; i > 0; i--) {
                                    nextMove1 = i;
                                    nextMove2 = counter2;
                                    nextMove3 = counter3;
                                    nextMove4 = counter4;
                                    nextMove5 = counter5;
                                    nextMove6 = counter6;

                                    if(i < counter6){
                                        nextMove6 = i;
                                    }

                                    if(i < counter5){
                                        nextMove5 = i;
                                    }

                                    if(i < counter4){
                                        nextMove4 = i;
                                    }

                                    if(i < counter3){
                                        nextMove3 = i;
                                    }

                                    if(i < counter2){
                                        nextMove2 = i;
                                    }

                                    String nM1 = String.valueOf(nextMove1);
                                    String nM2 = String.valueOf(nextMove2);
                                    String nM3 = String.valueOf(nextMove3);
                                    String nM4 = String.valueOf(nextMove4);
                                    String nM5 = String.valueOf(nextMove5);
                                    String nM6 = String.valueOf(nextMove6);
                                    String next = nM1 + nM2 + nM3 + nM4 + nM5 + nM6;

                                    String [] tempBoard = {nM1, nM2, nM3, nM4, nM5, nM6};

                                    for(int x = 0; x < loseBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(loseBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(loseBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(loseBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(loseBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(loseBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(loseBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            tempState = true;
                                            localLoseBoards.add(next);
                                            if (tempState == true){
                                                state = true;
                                            }
                                        }
                                    }

                                    for(int x = 0; x < winBoards.size(); x++){
                                        String lB1;
                                        String lB2;
                                        String lB3;
                                        String lB4;
                                        String lB5;
                                        String lB6;

                                        lB1 = String.valueOf(winBoards.get(x).charAt(0));
                                        lB2 = String.valueOf(winBoards.get(x).charAt(1));
                                        lB3 = String.valueOf(winBoards.get(x).charAt(2));
                                        lB4 = String.valueOf(winBoards.get(x).charAt(3));
                                        lB5 = String.valueOf(winBoards.get(x).charAt(4));
                                        lB6 = String.valueOf(winBoards.get(x).charAt(5));

                                        if(tempBoard[0].equals(lB1) && tempBoard[1].equals(lB2) && tempBoard[2].equals(lB3) && tempBoard[3].equals(lB4) && tempBoard[4].equals(lB5) && tempBoard[5].equals(lB6)){
                                            localWinBoards.add(next);
                                        }
                                    }

                                    //System.out.println(Arrays.toString(tempBoard));
                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                    //nextBoards.add(tempCounter);
                                    //System.out.println("next possible moves: " + tempCounter);

                                    System.out.println(tempState);
                                    System.out.println("Next possible moves1: " + next);

                                    nextMoves.add(next);
                                }

                                if(state == true){
                                    System.out.println("next moves: " + nextMoves);
                                    System.out.println("next best moves: " + localLoseBoards);

                                    nextLoseBoards.add(String.valueOf(counter));
                                    winBoards.add(counter);

                                    int nextBestMoveIndex = localLoseBoards.size()-1;
                                    String nextBestMove = localLoseBoards.get(nextBestMoveIndex);

                                    System.out.println("next best moves real: " + nextBestMove);

                                    currentBoard.counter1 = Integer.parseInt(String.valueOf(counter.charAt(0)));
                                    currentBoard.counter2  = Integer.parseInt(String.valueOf(counter.charAt(1)));
                                    currentBoard.counter3 = Integer.parseInt(String.valueOf(counter.charAt(2)));
                                    currentBoard.counter4 = Integer.parseInt(String.valueOf(counter.charAt(3)));
                                    currentBoard.counter5 = Integer.parseInt(String.valueOf(counter.charAt(4)));
                                    currentBoard.counter6 = Integer.parseInt(String.valueOf(counter.charAt(5)));

                                    currentBoard.best1 = Integer.parseInt(String.valueOf(nextBestMove.charAt(0)));
                                    currentBoard.best2 = Integer.parseInt(String.valueOf(nextBestMove.charAt(1)));
                                    currentBoard.best3 = Integer.parseInt(String.valueOf(nextBestMove.charAt(2)));
                                    currentBoard.best4 = Integer.parseInt(String.valueOf(nextBestMove.charAt(3)));
                                    currentBoard.best5 = Integer.parseInt(String.valueOf(nextBestMove.charAt(4)));
                                    currentBoard.best6 = Integer.parseInt(String.valueOf(nextBestMove.charAt(5)));
                                    currentBoard.coordinates();

                                    System.out.println("winning");
                                }
                                else{
                                    System.out.println("next moves: " + nextMoves);
                                    System.out.println("next best moves: " + localWinBoards);

                                    nextWinBoards.add(String.valueOf(counter));
                                    loseBoards.add(counter);

                                    if(counter1 != 1 && counter2 != 0) {
                                        int nextBestMoveIndex = localWinBoards.size() - 1;
                                        String nextBestMove = localWinBoards.get(nextBestMoveIndex);

                                        System.out.println("next best moves real: " + nextBestMove);

                                        currentBoard.counter1 = Integer.parseInt(String.valueOf(counter.charAt(0)));
                                        currentBoard.counter2  = Integer.parseInt(String.valueOf(counter.charAt(1)));
                                        currentBoard.counter3 = Integer.parseInt(String.valueOf(counter.charAt(2)));
                                        currentBoard.counter4 = Integer.parseInt(String.valueOf(counter.charAt(3)));
                                        currentBoard.counter5 = Integer.parseInt(String.valueOf(counter.charAt(4)));
                                        currentBoard.counter6 = Integer.parseInt(String.valueOf(counter.charAt(5)));

                                        currentBoard.best1 = Integer.parseInt(String.valueOf(nextBestMove.charAt(0)));
                                        currentBoard.best2 = Integer.parseInt(String.valueOf(nextBestMove.charAt(1)));
                                        currentBoard.best3 = Integer.parseInt(String.valueOf(nextBestMove.charAt(2)));
                                        currentBoard.best4 = Integer.parseInt(String.valueOf(nextBestMove.charAt(3)));
                                        currentBoard.best5 = Integer.parseInt(String.valueOf(nextBestMove.charAt(4)));
                                        currentBoard.best6 = Integer.parseInt(String.valueOf(nextBestMove.charAt(5)));
                                        currentBoard.coordinates();
                                    }
                                    System.out.println("loosing");
                                }
                                allBoards.add(currentBoard);
                            }
                        }
                    }
                }
            }
        }

        for(int a = 1; a < 4; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++){

                    System.out.println("\n" + a + "," + b + "," + c);



                }

            }

        }
        System.out.println("\n");

        for (Board allBoard : allBoards) {
            System.out.println(allBoard.counter1 + "," + allBoard.counter2 + "," + allBoard.counter3 + "," + allBoard.counter4 + "," + allBoard.counter5 + "," + allBoard.counter6 + " > " + allBoard.best1 + "," + allBoard.best2 + "," + allBoard.best3 + "," + allBoard.best4 + "," + allBoard.best5 + "." + allBoard.best6);
            System.out.println(allBoard.xBest + "," + allBoard.yBest);
        }

        System.out.println("\n");
        System.out.println("opponent winning boards: " + nextLoseBoards);
        System.out.println("opponent losing boards: " + nextWinBoards);
        System.out.println("win boards: " + winBoards);
        System.out.println("lose boards: " + loseBoards);
    }

    public int [] toColumns(Chip[][] gameBoard){

        int counter1 = 10;
        int counter2 = 10;
        int counter3 = 10;
        int counter4 = 10;
        int counter5 = 10;
        int counter6 = 10;
        /*int counter7 = 10;
        int counter8 = 10;
        int counter9 = 10;
        int counter10 = 10;*/

//        for (int i = 9; i > 0; i--){
//            for(int j = 0; j < 9; j++) {
//                System.out.print(alive[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int c = 0; c < gameBoard.length; c++){
            for(int r = 0; r < gameBoard[c].length; r++){
                if (!gameBoard[r][c].isAlive){

                    if (c == 0){
                        if (counter1 > 0){
                            counter1--;
                        }
                    }

                    if(c == 1){
                        if (counter2 > 0){
                            counter2--;
                        }
                    }

                    if (c == 2){
                        if (counter3 > 0){
                            counter3--;
                        }
                    }

                    if (c == 3){
                        if (counter4 > 0){
                            counter4--;
                        }
                    }

                    if (c == 4){
                        if (counter5 > 0){
                            counter5--;
                        }
                    }

                    if (c == 5){
                        if (counter6 > 0){
                            counter6--;
                        }
                    }

                    /*if (c == 6){
                        if (counter7 > 0){
                            counter7--;
                        }
                    }

                    if (c == 7){
                        if (counter8 > 0){
                            counter8--;
                        }
                    }

                    if (c == 8){
                        if (counter9 > 0){
                            counter9--;
                        }
                    }

                    if (c == 9){
                        if (counter10 > 0){
                            counter10--;
                        }
                    }*/

                    //System.out.println("Alive row: " + r + " Alive column: " + c);
                    //System.out.println("board length: " + board[0]);


                }
            }
        }
        int[] ans = {counter1, counter2, counter3, counter4, counter5, counter6/*, counter7, counter8, counter9, counter10*/};
        return ans;
    }
}
