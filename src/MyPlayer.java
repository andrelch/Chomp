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
        columns[0] = 3;
        columns[1] = 3;
        columns[2] = 3;

        int nextMove1 = columns[0]; //a
        int nextMove2 = columns[1]; //b
        int nextMove3 = columns[2]; //c

        nextMove(nextMove1, nextMove2, nextMove3);

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

        System.out.println("\n");
        for(int r = 3; r > 0; r--) {
            for (int c = 3; c > 0; c--) {
                System.out.println("Move coordinates: " + r + "," + c);
            }
        }

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        //gameBoard = pBoard;
        //toColumns(gameBoard);
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void nextMove(int counter1, int counter2, int counter3){
        int nextMove1 = 0;
        int nextMove2 = 0;
        int nextMove3 = 0;

        ArrayList <String> loseBoards = new ArrayList <String> ();
        loseBoards.add("100"); //why still able to identify lose boards without this?
        System.out.println(loseBoards);


        ArrayList <String> nextLoseBoards = new ArrayList <String>();
        ArrayList <String> nextWinBoards = new ArrayList <String>();
        ArrayList <String> nextBoards = new ArrayList <String>();

        for(int a = 1; a < 4; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++){

                    System.out.println("\n" + a + "," + b + "," + c);

                    ArrayList <String> nextMoves = new ArrayList<String>();
                    ArrayList <String> localLoseBoards = new ArrayList <String>();

                    Board currentBoard = new Board(a, b, c);

                    //allBoards.add(new Board(a, b, c));

                    counter1 = a;
                    counter2 = b;
                    counter3 = c;

                    String counter = String.valueOf(a) + b + c;

                    String tempCounter = "";
                    boolean tempState = false;
                    boolean state = false;

                    for(int i = counter3-1; i >= 0; i--) {
                        nextMove1 = counter1;
                        nextMove2 = counter2;
                        nextMove3 = i;

                        String nM1 = String.valueOf(nextMove1);
                        String nM2 = String.valueOf(nextMove2);
                        String nM3 = String.valueOf(nextMove3);
                        String next = nM1 + nM2 + nM3;

                        /*if(i < counter3){
                            nextMove3 = i;
                        }*/

                        String [] tempBoard = {String.valueOf(nextMove1), String.valueOf(nextMove2), String.valueOf(nextMove3)};

                        for(int x = 0; x < loseBoards.size(); x++){
                            String temp1;
                            String temp2;
                            String temp3;

                            temp1 = String.valueOf(loseBoards.get(x).charAt(0));
                            temp2 = String.valueOf(loseBoards.get(x).charAt(1));
                            temp3 = String.valueOf(loseBoards.get(x).charAt(2));

                            if(tempBoard[0].equals(temp1) && tempBoard[1].equals(temp2) && tempBoard[2].equals(temp3)){
                                tempState = true;
                                localLoseBoards.add(next);
                                if (tempState == true){
                                    state = true;
                                }
                            }
                        }

                        //System.out.println(Arrays.toString(tempBoard));
                        //tempCounter = String.valueOf(nextMove1, nextMove2, nextMove3);
                        //nextBoards.add(tempCounter);
                        //System.out.println("next possible moves: " + tempCounter);

                        System.out.println(tempState);
                        System.out.println("Next possible moves3: " + nextMove1 + "," + nextMove2 + "," + nextMove3);

                        nextMoves.add(next);
                    }

                    for(int i = counter2-1; i >= 0; i--){
                        nextMove1 = counter1;
                        nextMove2 = i;
                        nextMove3 = counter3;

                        /*if(i < counter2) {
                            nextMove2 = i;
                        }*/

                        if(i < counter3){
                            nextMove3 = i;
                        }

                        String nM1 = String.valueOf(nextMove1);
                        String nM2 = String.valueOf(nextMove2);
                        String nM3 = String.valueOf(nextMove3);
                        String next = nM1 + nM2 + nM3;

                        String [] tempBoard = {String.valueOf(nextMove1), String.valueOf(nextMove2), String.valueOf(nextMove3)};

                        for(int x = 0; x < loseBoards.size(); x++){
                            String temp1;
                            String temp2;
                            String temp3;

                            temp1 = String.valueOf(loseBoards.get(x).charAt(0));
                            temp2 = String.valueOf(loseBoards.get(x).charAt(1));
                            temp3 = String.valueOf(loseBoards.get(x).charAt(2));

                            if(tempBoard[0].equals(temp1) && tempBoard[1].equals(temp2) && tempBoard[2].equals(temp3)){
                                tempState = true;
                                localLoseBoards.add(next);
                                if (tempState == true){
                                    state = true;
                                }
                            }
                        }

                        //System.out.println(Arrays.toString(tempBoard));

                        System.out.println(tempState);
                        System.out.println("Next possible moves2: " + nextMove1 + "," + nextMove2 + "," + nextMove3);

                        nextMoves.add(next);
                    }

                    for (int i = counter1-1; i > 0; i--){
                        nextMove1 = i;
                        nextMove2 = counter2;
                        nextMove3 = counter3;

                        if(i < counter2) {
                            nextMove2 = i;
                        }

                        if(i < counter3){
                            nextMove3 = i;
                        }

                        String nM1 = String.valueOf(nextMove1);
                        String nM2 = String.valueOf(nextMove2);
                        String nM3 = String.valueOf(nextMove3);
                        String next = nM1 + nM2 + nM3;

                        String [] tempBoard = {String.valueOf(nextMove1), String.valueOf(nextMove2), String.valueOf(nextMove3)};

                        for(int x = 0; x < loseBoards.size(); x++){
                            tempState = false;

                            String temp1;
                            String temp2;
                            String temp3;

                            temp1 = String.valueOf(loseBoards.get(x).charAt(0));
                            temp2 = String.valueOf(loseBoards.get(x).charAt(1));
                            temp3 = String.valueOf(loseBoards.get(x).charAt(2));

                            if(tempBoard[0].equals(temp1) && tempBoard[1].equals(temp2) && tempBoard[2].equals(temp3)){
                                tempState = true;
                                localLoseBoards.add(next);
                                if (tempState == true){
                                    state = true;
                                }
                            }
                        }

                        //System.out.println(Arrays.toString(tempBoard));
                        System.out.println(tempState);
                        System.out.println("Next possible moves1: " + nextMove1 + "," + nextMove2 + "," + nextMove3);

                        nextMoves.add(next);
                    }

                    if(state == true){
                        System.out.println("winning");
                        nextLoseBoards.add(String.valueOf(counter));

                        //localNextWinBoards.retainAll(nextMoves);

                        //nextBoards.add(counter);

                        System.out.println("next moves: " + nextMoves);
                        System.out.println("next best moves: " + localLoseBoards);

                        int nextBestMoveIndex = localLoseBoards.size()-1;
                        String nextBestMove = localLoseBoards.get(nextBestMoveIndex);

                        System.out.println("next best moves real: " + nextBestMove);

                        currentBoard.counter1 = Integer.parseInt(String.valueOf(counter.charAt(0)));
                        currentBoard.counter2  = Integer.parseInt(String.valueOf(counter.charAt(1)));
                        currentBoard.counter3 = Integer.parseInt(String.valueOf(counter.charAt(2)));

                        currentBoard.best1 = Integer.parseInt(String.valueOf(nextBestMove.charAt(0)));
                        currentBoard.best2 = Integer.parseInt(String.valueOf(nextBestMove.charAt(1)));
                        currentBoard.best3 = Integer.parseInt(String.valueOf(nextBestMove.charAt(2)));
                        /*if (nextBoards.size() < 2 ){
                            String bestMove = nextBoards.get(0);
                            System.out.println("best move: " + bestMove);
                        }
                        else{
                            String bestMove = nextBoards.get(1);
                            System.out.println("best move: " + bestMove);
                        }*/
                    }
                    else{
                        System.out.println("next moves: " + nextMoves);

                        System.out.println("loosing");
                        nextWinBoards.add(String.valueOf(counter));
                        loseBoards.add(counter);
                    }

                }
            }
        }

        System.out.println("\n");
        System.out.println("opponent winning boards: " + nextLoseBoards);
        System.out.println("opponent losing boards: " + nextWinBoards);
        System.out.println("lose boards: " + loseBoards);

    }
}
