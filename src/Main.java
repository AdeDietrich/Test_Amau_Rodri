import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        long start = System.currentTimeMillis();
        LinkedList <String> Dictionary = new LinkedList<>();
        Methods.BufferedReader(Dictionary);
        Methods.PrintLinkedList(Dictionary);
        Methods.Create_Filetxt(Dictionary);
        Methods.Test(Dictionary);
        long end = System.currentTimeMillis();
        System.out.println(end-start);


    }
}
