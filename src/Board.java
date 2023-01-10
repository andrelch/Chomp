import java.util.ArrayList;

public class Board {
    public int counter1;
    public int counter2;
    public int counter3;
    public int counter4;
    public int counter5;
    public int counter6;
    public int counter7;
    public int counter8;
    public int counter9;
    public int counter10;

    public int best1;
    public int best2;
    public int best3;
    public int best4;
    public int best5;
    public int best6;
    public int best7;
    public int best8;
    public int best9;
    public int best10;

    public int xBest;
    public int yBest;

    //ArrayList<String> localLosingBoards = new ArrayList<String>();
    //String bestMove = localLosingBoards.get(0);

    public Board(int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int c10){
        counter1 = c1;
        counter2 = c2;
        counter3 = c3;
        counter4 = c4;
        counter5 = c5;
        counter6 = c6;
        counter7 = c7;
        counter8 = c8;
        counter9 = c9;
        counter10 = c10;
    }

    public void coordinates(){
        int difference1;
        int difference2;
        int difference3;
        int difference4;
        int difference5;
        int difference6;
        int difference7;
        int difference8;
        int difference9;
        int difference10;

        difference1 = counter1 - best1;
        difference2 = counter2 - best2;
        difference3 = counter3 - best3;
        difference4 = counter4 - best4;
        difference5 = counter5 - best5;
        difference6 = counter6 - best6;
        difference7 = counter7 - best7;
        difference8 = counter8 - best8;
        difference9 = counter9 - best9;
        difference10 = counter10 - best10;

        int [] difference = {difference1, difference2, difference3, difference4, difference5, difference6, difference7, difference8, difference9, difference10};

        if (difference1 > 0){
            xBest = 0;
            yBest = best1;
        }
        else if (difference2 > 0) {
            xBest = 1;
            yBest = best2;
        }
        else if (difference3 > 0){
            xBest = 2;
            yBest = best3;
        }
        else if (difference4 > 0){
            xBest = 3;
            yBest = best4;
        }
        else if (difference5 > 0){
            xBest = 4;
            yBest = best5;
        }
        else if (difference6 > 0){
            xBest = 5;
            yBest = best6;
        }
        else if (difference7 > 0){
            xBest = 6;
            yBest = best7;
        }
        else if (difference8 > 0){
            xBest = 7;
            yBest = best8;
        }
        else if (difference9 > 0){
            xBest = 8;
            yBest = best9;
        }
        else if (difference10 > 0){
            xBest = 9;
            yBest = best10;
        }

        //System.out.println(xBest + "," + yBest);
    }
}
