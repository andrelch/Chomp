import java.util.ArrayList;

public class Board {
    public int counter1;
    public int counter2;
    public int counter3;

    public int best1;
    public int best2;
    public int best3;

    public int xBest;
    public int yBest;

    //ArrayList<String> localLosingBoards = new ArrayList<String>();
    //String bestMove = localLosingBoards.get(0);

    public Board(int c1, int c2, int c3){
        counter1 = c1;
        counter2 = c2;
        counter3 = c3;
    }

    public void coordinates(){
        int difference1;
        int difference2;
        int difference3;

        difference1 = counter1 - best1;
        difference2 = counter2 - best2;
        difference3 = counter3 - best3;

        int [] difference = {difference1, difference2, difference3};

//        for(int i=0; i < difference.length; i++){
//            if
//        }

        if (difference1 > 0){
            xBest = 0;
            yBest = best1;
        }
        else {
            if (difference2 > 0){
                xBest = 1;
                yBest = best2;
            }
            else {
                if (difference3 > 0){
                    xBest = 2;
                    yBest = best3;
                }
            }
        }

        System.out.println(xBest + "," + yBest);
    }
}
