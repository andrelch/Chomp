import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

//        gameBoard = alive;
        //columns = toColumns(gameBoard);
        columns[0] = 3;
        columns[1] = 3;
        columns[2] = 3;

        int nextMove1 = columns[0]; //a
        int nextMove2 = columns[1]; //b
        int nextMove3 = columns[2]; //c

          /*for(int a = 1; a < 4; a++){
            for(int b = 0; b <= a; b++){
                for(int c = 0; c <= b; c++){
                    System.out.println(a +","+ b +","+ c);
                    //call make possible moves
                    //one function with three parameters
                }
            }
        }*/

        nextMove(nextMove1, nextMove2, nextMove3);

        //updateBoard(randomRow,0);
        //updateBoard(0,randomCol);

        int updateMoveRow = 0;
        int updateMoveCol = 0;

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

        gameBoard = pBoard;
        toColumns(gameBoard);
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

        /*int counter1;
        int counter2;
        int counter3;*/

        int nextMove1 = 0;
        int nextMove2 = 0;
        int nextMove3 = 0;

        for(int a1 = 1; a1 <= 3; a1++){
            for(int b1 = 0; b1 <= a1; b1++){
                for(int c1 = 0; c1 <= b1; c1++){
                    System.out.println(a1 +","+ b1 +","+ c1);
                }
            }
        }

        for(int a = 3; a > 0; a--) {
            for (int b = a; b >= 0; b--) {
                for (int c = b; c >= 0; c--) {
                    System.out.println("\n" + a + "," + b + "," + c);

                    counter1 = a;
                    counter2 = b;
                    counter3 = c;

                    for(int i = counter3-1; i >= 0; i--) {
                        nextMove1 = counter1;
                        nextMove2 = counter2;
                        nextMove3 = i;

                        System.out.println("Next possible moves3: " + a + "," + b + "," + c + "    " + nextMove1 + "," + nextMove2 + "," + nextMove3);
                    }

                    for(int i = counter2-1; i >= 0; i--){
                        //counter2 = i;

                        //System.out.println("Next possible moves2: " + a + "," + b + "," + c + "    " + counter1 + "," + i + "," + i);


                        if(counter3 <= counter2 && counter2 <= counter1 && counter3 != 0) {
                            nextMove1 = counter1;
                            nextMove2 = i;
                            nextMove3 = i;

                            System.out.println("Next possible moves2: " + a + "," + b + "," + c + "    " + nextMove1 + "," + nextMove2 + "," + nextMove3);


                            /**if (i >= counter3){
                                System.out.println("Next possible moves2: " + a + "," + b + "," + c + "    " + counter1 + "," + i + "," + i);
                            }
                            else if(i < counter3){
                                System.out.println("Next possible moves2: " + a + "," + b + "," + c + "    " + counter1 + "," + i + "," + counter3);
                            }*/
                        }

                        if (counter3 <= counter2 && counter2 <= counter1 && counter3 == 0){
                            nextMove1 = counter1;
                            nextMove2 = i;
                            nextMove3 = counter3;

                            System.out.println("Next possible moves2: " + a + "," + b + "," + c + "    " + nextMove1 + "," + nextMove2 + "," + nextMove3);
                        }

                    }

                    for (int i = counter1-1; i > 0; i--){
                        //counter1 = i;

                        //System.out.println("Next possible moves1.5: " + a + "," + b + "," + c + "    " + i + "," + i + "," + i);
                        //System.out.println("Next possible moves0.5: " + a + "," + b + "," + c + "    " + i + "," + i + "," + counter3);

                        if(counter3 <= counter2 && counter2 <= counter1 && counter3 != 0 && counter3 != 1){
                            nextMove1 = i;
                            nextMove2 = i;
                            nextMove3 = i;

                            System.out.println("Next possible moves1: " + a + "," + b + "," + c + "    " + nextMove1 + "," + nextMove2 + "," + nextMove3);
                        }

                        if (counter3 <= counter2 && counter2 <= counter1 && counter3 == 1 || counter3 == 0){
                            nextMove1 = i;
                            nextMove2 = i;
                            nextMove3 = counter3;

                            System.out.println("Next possible moves0: " + a + "," + b + "," + c + "    " + nextMove1 + "," + nextMove2 + "," + nextMove3);
                        }
                    }
                }
            }
        }
            if(nextMove2 != 2 && nextMove2 != 1 && nextMove3 != 0 || nextMove1 != 1 && nextMove2 == 0 && nextMove3 == 0){
                System.out.println("Winning");
        }
    }

  public int [] toColumns(Chip[][] gb){

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

        for(int i = 9; i > 0; i++){
            for (int j = 0; j < 9; j++){
                int nextmove1 = counter1;

            }
        }

        for(int c = 0; c < gb.length; c++){
            for(int r = 0; r < gb[c].length; r++){
                if (!gb[r][c].isAlive){

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
