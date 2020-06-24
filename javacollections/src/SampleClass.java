import java.util.ArrayList;
import java.util.List;

public class SampleClass {
    public static void main(String[] args) {
        List<String> strList1 = new ArrayList<>();
        strList1.add("Chetan");
        strList1.add("Nithesh");
        List<String> strList2 = new ArrayList<>();
        strList2.add("Nithesh");
        strList2.add("Chetan");

        strList1.sort((s1,s2) -> s1.compareTo(s2));
        strList2.sort((s1,s2) -> s1.compareTo(s2));

        System.out.println("strList1 hascode = "+strList1.hashCode());
        System.out.println("strList2 hascode = "+strList2.hashCode());
        System.out.println(strList1.equals(strList2));
    }
}
