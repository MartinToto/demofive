import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Martin on 2019/3/25.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("11");
        arrayList.add("10");
        arrayList.add("15");
        arrayList.add("12");
        arrayList.add("16");
        arrayList.add("13");
        arrayList.add("17");
        arrayList.add("18");
        arrayList.add("14");
        for (String num:arrayList){
            System.out.print(num+"---");
        }
        System.out.println("---------------");
        Collections.sort(arrayList);

        for (String num:arrayList){
            System.out.print(num+"----");
        }
    }
}
