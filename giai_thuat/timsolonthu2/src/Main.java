import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a[]={1,23,3,5,10};
        int firstMax, secondMax;
        if (a[0] > a[1]){
            firstMax = a[0];
            secondMax = a[1];
        }else{
            firstMax = a[1];
            secondMax = a[0];
        }
        for(int i = 2; i < nu.length; i++){
            if(a[i] >= firstMax){
                secondMax = firstMax;
                firstMax = a[i];
            }else if (a[i] > secondMax){
                secondMax = a[i];
            }
        }
        System.out.printf("d"+secondMax);
    }
}