import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {


        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(3);
        integerList.add(5);
        integerList.add(2);
        integerList.add(11);
        integerList.add(8);
        integerList.add(56);
        integerList.add(22);

        Collections.sort(integerList);

        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }
}
