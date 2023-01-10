import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class MyPlayer {

    ArrayList <Board> allBoards = new ArrayList <Board>();
    ArrayList <String> loseBoards = new ArrayList <String> ();
    ArrayList <String> winBoards = new ArrayList <String> ();


    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {

        //loseBoards.add("1000000000"); //why still able to identify lose boards without this? maybe add to prevent outOfBounds?
        //System.out.println(loseBoards);

        //winBoards.add("1100000000");
        //System.out.println(winBoards);

        columns = new int[10];

        //gameBoard = alive;
        //columns = toColumns(gameBoard);
        columns[0] = 10;
        columns[1] = 10;
        columns[2] = 10;
        columns[3] = 10;
        columns[4] = 10;
        columns[5] = 10;
        columns[6] = 10;
        columns[7] = 10;
        columns[8] = 10;
        columns[9] = 10;

        int nextMove1 = columns[0]; //a
        int nextMove2 = columns[1]; //b
        int nextMove3 = columns[2]; //c
        int nextMove4 = columns[3]; //d
        int nextMove5 = columns[4]; //e
        int nextMove6 = columns[5]; //f
        int nextMove7 = columns[6]; //g
        int nextMove8 = columns[7]; //h
        int nextMove9 = columns[8]; //i
        int nextMove10 = columns[9]; //j

        nextMove(nextMove1, nextMove2, nextMove3, nextMove4, nextMove5, nextMove6, nextMove7, nextMove8, nextMove9, nextMove10);

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

        System.out.println("current board: "+ Arrays.toString(arr));

        int current1 = arr[0];
        int current2 = arr[1];
        int current3 = arr[2];
        int current4 = arr[3];
        int current5 = arr[4];
        int current6 = arr[5];
        int current7 = arr[6];
        int current8 = arr[7];
        int current9 = arr[8];
        int current10 = arr[9];

        // System.out.println(allBoards);

        int column = 0;
        int row = 0;

        for(int i = 0; i < allBoards.size(); i++){

            StringBuilder current = new StringBuilder(10);
            current.append(current1);
            current.append(current2);
            current.append(current3);
            current.append(current4);
            current.append(current5);
            current.append(current6);
            current.append(current7);
            current.append(current8);
            current.append(current9);
            current.append(current10);

            StringBuilder counter = new StringBuilder(10);
            counter.append(allBoards.get(i).counter1);
            counter.append(allBoards.get(i).counter2);
            counter.append(allBoards.get(i).counter3);
            counter.append(allBoards.get(i).counter4);
            counter.append(allBoards.get(i).counter5);
            counter.append(allBoards.get(i).counter6);
            counter.append(allBoards.get(i).counter7);
            counter.append(allBoards.get(i).counter8);
            counter.append(allBoards.get(i).counter9);
            counter.append(allBoards.get(i).counter10);

//            if(current1 == allBoards.get(i).counter1 && current2 == allBoards.get(i).counter2 && current3 == allBoards.get(i).counter3 && current4 == allBoards.get(i).counter4 && current5 == allBoards.get(i).counter5 && current6 == allBoards.get(i).counter6 && current7 == allBoards.get(i).counter7 && current8 == allBoards.get(i).counter8 && current9 == allBoards.get(i).counter9 && current10 == allBoards.get(i).counter10){
//                System.out.println(allBoards.get(i).xBest + "," + allBoards.get(i).yBest);
//                column = allBoards.get(i).xBest;
//                row = allBoards.get(i).yBest;
//            }

            if(current.toString().equals(counter.toString())) {
                //System.out.println(allBoards.get(i).xBest + "," + allBoards.get(i).yBest);
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

    public void nextMove(int counter1, int counter2, int counter3, int counter4, int counter5, int counter6, int counter7, int counter8, int counter9, int counter10){
        int nextMove1 = 0;
        int nextMove2 = 0;
        int nextMove3 = 0;
        int nextMove4 = 0;
        int nextMove5 = 0;
        int nextMove6 = 0;
        int nextMove7 = 0;
        int nextMove8 = 0;
        int nextMove9 = 0;
        int nextMove10 = 0;

        /*ArrayList <String> nextLoseBoards = new ArrayList <String>();
        ArrayList <String> nextWinBoards = new ArrayList <String>();*/

        for(int a = 1; a < 11; a++){
            for(int b = 0; b <= a; b++){
                for(int c = 0; c <= b; c++){
                    for(int d = 0; d <= c; d++){
                        for(int e = 0; e <= d; e++){
                            for(int f = 0; f <= e; f++){
                                for(int g = 0; g <= f; g++){
                                    for (int h = 0; h <= g; h++){
                                        for (int i = 0; i <= h; i++){
                                            for (int j = 0; j <= i; j++){

                                                /*StringBuilder board = new StringBuilder(10);
                                                board.append(a);
                                                board.append(b);
                                                board.append(c);
                                                board.append(d);
                                                board.append(e);
                                                board.append(e);
                                                board.append(f);
                                                board.append(g);
                                                board.append(h);
                                                board.append(i);
                                                board.append(j);
                                                System.out.println(board);*/

                                                //ArrayList<String> nextMoves = new ArrayList<String>();
                                                //ArrayList<String> localLoseBoards = new ArrayList<String>();
                                                //ArrayList<String> localWinBoards = new ArrayList<String>();

                                                String nextBestMoveLose = null;
                                                String nextBestMoveWin = null;

                                                String nextBestMoveLose1 = null;
                                                String nextBestMoveLose2 = null;
                                                String nextBestMoveLose3 = null;
                                                String nextBestMoveLose4 = null;
                                                String nextBestMoveLose5 = null;
                                                String nextBestMoveLose6 = null;
                                                String nextBestMoveLose7 = null;
                                                String nextBestMoveLose8 = null;
                                                String nextBestMoveLose9 = null;
                                                String nextBestMoveLose10 = null;

                                                Board currentBoard = new Board(a, b, c, d, e, f, g, h, i, j);

                                                //System.out.println("original board:" + currentBoard.counter1 + "," + currentBoard.counter2 + "," + currentBoard.counter3 + "," + currentBoard.counter4 + "," + currentBoard.counter5 + "," + currentBoard.counter6 + "next best move: " + currentBoard.best1 + "," +currentBoard.best2 + ","+currentBoard.best3 + "," + currentBoard.best4 + "," + currentBoard.best5 + "," + currentBoard.best6);

                                                //allBoards.add(new Board(a, b, c));

                                                counter1 = a;
                                                counter2 = b;
                                                counter3 = c;
                                                counter4 = d;
                                                counter5 = e;
                                                counter6 = f;
                                                counter7 = g;
                                                counter8 = h;
                                                counter9 = i;
                                                counter10 = j;

                                                //String counter = String.valueOf(a) + b + c + d + e + f + g + h + i + j;
                                                StringBuilder counter = new StringBuilder(10);
                                                counter.append(a);
                                                counter.append(b);
                                                counter.append(c);
                                                counter.append(d);
                                                counter.append(e);
                                                counter.append(f);
                                                counter.append(g);
                                                counter.append(h);
                                                counter.append(i);
                                                counter.append(j);

                                                boolean tempState = false;
                                                boolean state = false;

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                //String lB;
                                                //String wB;

                                                for (int z = counter10 - 1; z >= 0; z--) {
                                                    nextMove10 = z;

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                    /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves10: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter9 - 1; z >= 0; z--) {
                                                    nextMove9 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                    /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/



                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves9: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter8 - 1; z >= 0; z--) {
                                                    nextMove8 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                    /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves8: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter7 - 1; z >= 0; z--) {
                                                    nextMove7 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                    /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves7: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter6 - 1; z >= 0; z--) {
                                                    nextMove6 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                   /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves6: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter5 - 1; z >= 0; z--) {
                                                    nextMove5 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }
                                                    if (z < counter6) {
                                                        nextMove6 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                   /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves5: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter4 - 1; z >= 0; z--) {
                                                    nextMove4 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }
                                                    if (z < counter6) {
                                                        nextMove6 = z;
                                                    }
                                                    if (z < counter5) {
                                                        nextMove5 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                   /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves4: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter3 - 1; z >= 0; z--) {
                                                    nextMove3 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }
                                                    if (z < counter6) {
                                                        nextMove6 = z;
                                                    }
                                                    if (z < counter5) {
                                                        nextMove5 = z;
                                                    }
                                                    if (z < counter4) {
                                                        nextMove4 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                   /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves3: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter2 - 1; z >= 0; z--) {
                                                    nextMove2 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }
                                                    if (z < counter6) {
                                                        nextMove6 = z;
                                                    }
                                                    if (z < counter5) {
                                                        nextMove5 = z;
                                                    }
                                                    if (z < counter4) {
                                                        nextMove4 = z;
                                                    }
                                                    if (z < counter3) {
                                                        nextMove3 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                  /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    //System.out.println(tempState);
                                                    //System.out.println("Next possible moves2: " + next);

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                for (int z = counter1 - 1; z > 0; z--) {
                                                    nextMove1 = z;

                                                    if (z < counter10) {
                                                        nextMove10 = z;
                                                    }
                                                    if (z < counter9) {
                                                        nextMove9 = z;
                                                    }
                                                    if (z < counter8) {
                                                        nextMove8 = z;
                                                    }
                                                    if (z < counter7) {
                                                        nextMove7 = z;
                                                    }
                                                    if (z < counter6) {
                                                        nextMove6 = z;
                                                    }
                                                    if (z < counter5) {
                                                        nextMove5 = z;
                                                    }
                                                    if (z < counter4) {
                                                        nextMove4 = z;
                                                    }
                                                    if (z < counter3) {
                                                        nextMove3 = z;
                                                    }
                                                    if (z < counter2) {
                                                        nextMove2 = z;
                                                    }

                                                    StringBuilder next = new StringBuilder(10);
                                                    next.append(nextMove1);
                                                    next.append(nextMove2);
                                                    next.append(nextMove3);
                                                    next.append(nextMove4);
                                                    next.append(nextMove5);
                                                    next.append(nextMove6);
                                                    next.append(nextMove7);
                                                    next.append(nextMove8);
                                                    next.append(nextMove9);
                                                    next.append(nextMove10);

                                                    String tempBoard = String.valueOf(next);

                                                    for (int x = 0; x < loseBoards.size(); x++) {
                                                        String lB = String.valueOf(loseBoards.get(x));

                                                        if (tempBoard.equals(lB)){
                                                            /*tempState = true;
                                                            localLoseBoards.add(String.valueOf(next));
                                                            if (tempState == true) {
                                                                state = true;
                                                            }*/

                                                            //localLoseBoards.add(String.valueOf(next));
                                                            //nextBestMoveLose = String.valueOf(next);

                                                            nextBestMoveLose1 = String.valueOf(nextMove1);
                                                            nextBestMoveLose2 = String.valueOf(nextMove2);
                                                            nextBestMoveLose3 = String.valueOf(nextMove3);
                                                            nextBestMoveLose4 = String.valueOf(nextMove4);
                                                            nextBestMoveLose5 = String.valueOf(nextMove5);
                                                            nextBestMoveLose6 = String.valueOf(nextMove6);
                                                            nextBestMoveLose7 = String.valueOf(nextMove7);
                                                            nextBestMoveLose8 = String.valueOf(nextMove8);
                                                            nextBestMoveLose9 = String.valueOf(nextMove9);
                                                            nextBestMoveLose10 = String.valueOf(nextMove10);

                                                            state = true;
                                                            break;
                                                        }
                                                    }

                                                   /*for (int x = 0; x < winBoards.size(); x++) {
                                                        wB = String.valueOf(winBoards.get(x));

                                                        if (tempBoard.equals(wB)){
                                                            //localWinBoards.add(String.valueOf(next));
                                                            nextBestMoveWin = String.valueOf(next);
                                                        }
                                                    }*/

                                                    //System.out.println(Arrays.toString(tempBoard));
                                                    //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                                                    //nextBoards.add(tempCounter);
                                                    //System.out.println("next possible moves: " + tempCounter);

                                                    /*System.out.println(tempState);
                                                    System.out.println("Next possible moves1: " + next);*/

                                                    //nextMoves.add(String.valueOf(next));
                                                }

                                                nextMove1 = counter1;
                                                nextMove2 = counter2;
                                                nextMove3 = counter3;
                                                nextMove4 = counter4;
                                                nextMove5 = counter5;
                                                nextMove6 = counter6;
                                                nextMove7 = counter7;
                                                nextMove8 = counter8;
                                                nextMove9 = counter9;
                                                nextMove10 = counter10;

                                                if (state == true) {
                                                    //System.out.println("next moves: " + nextMoves);
                                                    //System.out.println("next best moves: " + localLoseBoards);

                                                    //nextLoseBoards.add(String.valueOf(counter));
                                                    winBoards.add(String.valueOf(counter));

                                                    //int nextBestMoveIndex = localLoseBoards.size() - 1;
                                                    //String nextBestMove = localLoseBoards.get(nextBestMoveIndex);

                                                    //System.out.println("next best moves real: " + nextBestMove);

                                                    currentBoard.counter1 = a;
                                                    currentBoard.counter2 = b;
                                                    currentBoard.counter3 = c;
                                                    currentBoard.counter4 = d;
                                                    currentBoard.counter5 = e;
                                                    currentBoard.counter6 = f;
                                                    currentBoard.counter7 = g;
                                                    currentBoard.counter8 = h;
                                                    currentBoard.counter9 = i;
                                                    currentBoard.counter10 = j;

                                                    currentBoard.best1 = Integer.parseInt(nextBestMoveLose1);
                                                    currentBoard.best2 = Integer.parseInt(nextBestMoveLose2);
                                                    currentBoard.best3 = Integer.parseInt(nextBestMoveLose3);
                                                    currentBoard.best4 = Integer.parseInt(nextBestMoveLose4);
                                                    currentBoard.best5 = Integer.parseInt(nextBestMoveLose5);
                                                    currentBoard.best6 = Integer.parseInt(nextBestMoveLose6);
                                                    currentBoard.best7 = Integer.parseInt(nextBestMoveLose7);
                                                    currentBoard.best8 = Integer.parseInt(nextBestMoveLose8);
                                                    currentBoard.best9 = Integer.parseInt(nextBestMoveLose9);
                                                    currentBoard.best10 = Integer.parseInt(nextBestMoveLose10);
                                                    currentBoard.coordinates();

                                                    //System.out.println("winning");
                                                } else {
                                                    //System.out.println("next moves: " + nextMoves);
                                                    //System.out.println("next best moves: " + localWinBoards);

                                                    //nextWinBoards.add(String.valueOf(counter));
                                                    loseBoards.add(String.valueOf(counter));

                                                    if (counter1 != 1 && counter2 != 0) {
                                                        //int nextBestMoveIndex = localWinBoards.size() - 1;
                                                        //String nextBestMove = localWinBoards.get(nextBestMoveIndex);

                                                        //System.out.println("next best moves real: " + nextBestMove);

                                                        currentBoard.counter1 = a;
                                                        currentBoard.counter2 = b;
                                                        currentBoard.counter3 = c;
                                                        currentBoard.counter4 = d;
                                                        currentBoard.counter5 = e;
                                                        currentBoard.counter6 = f;
                                                        currentBoard.counter7 = g;
                                                        currentBoard.counter8 = h;
                                                        currentBoard.counter9 = i;
                                                        currentBoard.counter10 = j;

                                                        int currentBoardCounter = 0;

                                                        if(a > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(b > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(c > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(d > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(e > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(f > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(g > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(h > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(i > 0){
                                                            currentBoardCounter++;
                                                        }
                                                        if(j > 0){
                                                            currentBoardCounter++;
                                                        }

                                                       int randomColumn = (int)(Math.random()*currentBoardCounter);

                                                        int randomRow = 0;

                                                        if(randomColumn == 0){
                                                            randomRow = (int)(Math.random()*(a-1))+1;
                                                        }
                                                        if(randomColumn == 1){
                                                            randomRow = (int)(Math.random()*b);
                                                        }
                                                        if(randomColumn == 2){
                                                            randomRow = (int)(Math.random()*c);
                                                        }
                                                        if(randomColumn == 3){
                                                            randomRow = (int)(Math.random()*d);
                                                        }
                                                        if(randomColumn == 4){
                                                            randomRow = (int)(Math.random()*e);
                                                        }
                                                        if(randomColumn == 5){
                                                            randomRow = (int)(Math.random()*f);
                                                        }
                                                        if(randomColumn == 6){
                                                            randomRow = (int)(Math.random()*g);
                                                        }
                                                        if(randomColumn == 7){
                                                            randomRow = (int)(Math.random()*h);
                                                        }
                                                        if(randomColumn == 8){
                                                            randomRow = (int)(Math.random()*i);
                                                        }
                                                        if(randomColumn == 9){
                                                            randomRow = (int)(Math.random()*j);
                                                        }

                                                        currentBoard.xBest = randomColumn;
                                                        currentBoard.yBest = randomRow;
                                                    }
                                                    //System.out.println("loosing");
                                                }
                                                allBoards.add(currentBoard);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Board allBoard : allBoards) {
            //System.out.println(allBoard.counter1 + "," + allBoard.counter2 + "," + allBoard.counter3 + "," + allBoard.counter4 + "," + allBoard.counter5 + "," + allBoard.counter6 + " > " + allBoard.best1 + "," + allBoard.best2 + "," + allBoard.best3 + "," + allBoard.best4 + "," + allBoard.best5 + "." + allBoard.best6);
            //System.out.println(allBoard.xBest + "," + allBoard.yBest);
        }

        /*System.out.println("\n");
        System.out.println("opponent winning boards: " + nextLoseBoards);
        System.out.println("opponent losing boards: " + nextWinBoards);
        System.out.println("win boards: " + winBoards);
        System.out.println("lose boards: " + loseBoards);*/
    }

    public int [] toColumns(Chip[][] gameBoard){

        int counter1 = 10;
        int counter2 = 10;
        int counter3 = 10;
        int counter4 = 10;
        int counter5 = 10;
        int counter6 = 10;
        int counter7 = 10;
        int counter8 = 10;
        int counter9 = 10;
        int counter10 = 10;

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

                    if (c == 6){
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
                    }

                    //System.out.println("Alive row: " + r + " Alive column: " + c);
                    //System.out.println("board length: " + board[0]);


                }
            }
        }
        int[] ans = {counter1, counter2, counter3, counter4, counter5, counter6, counter7, counter8, counter9, counter10};
        return ans;
    }
}
