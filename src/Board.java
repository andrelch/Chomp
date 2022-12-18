import java.util.ArrayList;

public class Board {
    public int counter1;
    public int counter2;
    public int counter3;
    public int counter4;
    public int counter5;
    public int counter6;

    public int best1;
    public int best2;
    public int best3;
    public int best4;
    public int best5;
    public int best6;

    public int xBest;
    public int yBest;

    //ArrayList<String> localLosingBoards = new ArrayList<String>();
    //String bestMove = localLosingBoards.get(0);

    public Board(int c1, int c2, int c3, int c4, int c5, int c6){
        counter1 = c1;
        counter2 = c2;
        counter3 = c3;
        counter4 = c4;
        counter5 = c5;
        counter6 = c6;
    }

    public void coordinates(){
        int difference1;
        int difference2;
        int difference3;
        int difference4;
        int difference5;
        int difference6;

        difference1 = counter1 - best1;
        difference2 = counter2 - best2;
        difference3 = counter3 - best3;
        difference4 = counter4 - best4;
        difference5 = counter5 - best5;
        difference6 = counter6 - best6;

        int [] difference = {difference1, difference2, difference3, difference4, difference5, difference6};

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

        System.out.println(xBest + "," + yBest);
    }
}
