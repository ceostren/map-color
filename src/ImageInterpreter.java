import java.util.LinkedList;
import java.util.Queue;

public class ImageInterpreter {
    int[][][] bufferimage;
    int[][] reducedimage;

    ImageInterpreter(int[][][] image){
        bufferimage = image;
        reduceImage();
    }

    ImageInterpreter(boolean test, int[][] reducedimage){
        this.reducedimage = reducedimage;
    }

    public void labelFill(){
        int l = reducedimage.length;
        int w = reducedimage[0].length;
        int lastLabel = 1;
        boolean[][] visited = new boolean[l][w];
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] == false) {
                    queue.add(i + "," + j);
                    boolean color = false;
                    while (queue.isEmpty() == false) {
                        String cur = queue.remove();
                        int r = Integer.parseInt(cur.split(",")[0]);
                        int c = Integer.parseInt(cur.split(",")[1]);
                        if (r < 0 || c < 0 || r >= l || c >= w || visited[r][c]) {
                            continue;
                        }
                        visited[r][c] = true;
                        if (reducedimage[r][c] != 0) {
                            continue;
                        }
                        reducedimage[r][c] = lastLabel;
                        color = true;
                        queue.add(r + "," + (c + 1));
                        queue.add((r + 1) + "," + c);
                        queue.add(r + "," + (c - 1));
                        queue.add((r - 1) + "," + c);
                    }
                    if (color) {
                        lastLabel++;
                    }
                }
            }
        }

    }

    private void printGrid(int[][] arr){
        for(int i = 0; i < arr.length; i++){

        }
    }

    private void reduceImage(){
        reducedimage = new int[bufferimage.length][bufferimage[0].length];
        int l = reducedimage.length;
        int h = reducedimage[0].length;
        for(int i = 0; i<l;i++){
            for(int j = 0; j < h; j++){
                if (checkPoint(bufferimage[i][j])){
                    reducedimage[i][j] = -1;
                }
                else {
                    reducedimage[i][j] = 0;
                }
            }
        }
    }

    private boolean checkPoint(int[] arr){
        if(arr[0] == 0 && arr[0] == arr[1] && arr[1] == arr[2]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0,-1,0,0,0},
                {0,0,-1,0,0,0,-1},
                {0,-1,0,0,0,-1,0},
                {0,-1,0,0,0,-1,0},
                {-1,-1,0,0,0,-1,0},
                {0,0,-1,0,0,-1,0}
        };
    }
}
