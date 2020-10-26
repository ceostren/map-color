import java.util.ArrayList;
import java.util.Random;

public class LineCreator {
    private int width;
    private int height;
    private Random rand = new Random();

    public LineCreator(int width, int height){
        this.width = width;
        this.height = height;
    }

    public ArrayList<int[][]> createLines(int l, int c){
        ArrayList<int[][]> lines = new ArrayList();
        for(int i = 0; i < l; i++){
            lines.add(createLine(l,c));
        }
        return lines;
    }

    public int[][] createLine(int l, int c){
        int[][] larr = new int[c+1][4];
        int x, y;
        int lp = 0;
        int cp = 0;
        if(rand.nextBoolean()){
            x = 0;
            y = rand.nextInt(height);
            larr[lp][0] = x;
            larr[lp][1] = y;
        }else {
            x = rand.nextInt(width);
            y = 0;
            larr[lp][0] = x;
            larr[lp][1] = y;
        }
        if(c == 0){
            if(rand.nextBoolean()){
                x = 0;
                y = rand.nextInt(height);
                larr[lp][2] = x;
                larr[lp][3] = y;
            }else {
                x = rand.nextInt(width);
                y = 0;
                larr[lp][2] = x;
                larr[lp][3] = y;
            }
        }
        else{
            larr[lp][2] = rand.nextInt(width);
            larr[lp][3] = rand.nextInt(height);
        }
        for(int i = 1; i < c; i++){
            larr[i][0] = larr[i-1][2];
            larr[i][1] = larr[i-1][3];
            larr[i][2] = rand.nextInt(width);
            larr[i][3] = rand.nextInt(height);
        }
        if(rand.nextBoolean()){
            x = 0;
            y = rand.nextInt(height);
            larr[c][0] = larr[c-1][2];
            larr[c][1] = larr[c-1][3];
            larr[c][2] = x;
            larr[c][3] = y;
        }else {
            x = rand.nextInt(width);
            y = 0;
            larr[c][0] = larr[c-1][2];
            larr[c][1] = larr[c-1][3];
            larr[c][2] = x;
            larr[c][3] = y;
        }
        return larr;
    }
}
