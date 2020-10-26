import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class LineDraw extends Canvas{

    ArrayList<int[][]> points;

    LineDraw(ArrayList<int[][]> lst){
        points = lst;
    }

    public void paint(Graphics g){
        for(int[][] arr: points){
            for(int i = 0; i < arr.length; i++){
                g.drawLine(arr[i][0],arr[i][1],arr[i][2],arr[i][3]);
            }
        }
    }
}
