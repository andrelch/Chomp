import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];

        for(int a = 1; a < 4; a++){
            for(int b = 0; b <= a; b++){
                for(int c = 0; c <= b; c++){
                    System.out.println(a +","+ b +","+ c);
                }
            }
        }

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        //int a = 0;
        //int b = 0;
        //int c = 0;

         for(int a = 0; a < 2; a++){
             for(int b = 0; b < 2; b++){
                 if(a>=b){
                     for(int c = 0; c <2; c++){
                         if(b>=c) {
                             System.out.println(a + b + c);
                         }
                     }
                 }
             }
         }

        /*System.out.println(
                "333\n" +
                "332\n" +
                "331\n" +
                "330\n" +
                "322\n" +
                "321\n" +
                "320\n" +
                "311\n" +
                "310\n" +
                "300\n" +
                "222\n" +
                "221\n" +
                "220\n" +
                "211\n" +
                "210\n" +
                "200\n" +
                "111\n" +
                "110\n" +
                "100\n"
        );*/

        gameBoard = pBoard;
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

}
