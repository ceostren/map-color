public class ImageInterpreter {
    int[][][] bufferimage;
    int[][] reducedimage;

    ImageInterpreter(int[][][] image){
        bufferimage = image;
    }

    private void reduceImage(){
        reducedimage = new int[bufferimage.length][bufferimage[0].length];
        int l = reducedimage.length;
        int h = reducedimage[0].length;
        for(int i = 0; i<l;i++){
            for(int j = 0; j < h; j++){
                if (checkPoint(bufferimage[i][j])){
                    reducedimage[i][j] = 1;
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

}
