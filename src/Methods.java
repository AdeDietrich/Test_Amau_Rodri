import java.io.*;
import java.sql.SQLOutput;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.ListIterator;

public class Methods {

    public static void BufferedReader (LinkedList<String> Diccionario) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Fixed/unsorteddict2.txt"));
        String line = reader.readLine();
        SaveLastPosition(line, Diccionario);
        line = reader.readLine();
        long start = System.currentTimeMillis();
        while(line != null){
            System.out.println("done");
            if(line.compareToIgnoreCase((Diccionario.get(Diccionario.size()-1))) > 0){  //para guardar en la ultima posicion direct.
                SaveLastPosition(line, Diccionario);
            }else{
                int position = CheckOrder(line, Diccionario);
                FillingMethod(line, position, Diccionario);
            }
            line = reader.readLine();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    public static int CheckOrder (String line, LinkedList<String> Diccionario){
        int i = 0;
        ListIterator<String> itr = Diccionario.listIterator();

        while(itr.hasNext()){
            String value = itr.next();
            if(line.compareToIgnoreCase(value) < 0){
                i = Diccionario.indexOf(value);
                break;
            }
        }

        return i;

    }

    public static void FillingMethod (String line, int position, LinkedList<String>Diccionario){
        String palabra = Diccionario.get(position);
        Diccionario.set(position, line);
        ListIterator<String> itr = Diccionario.listIterator(position+1);
        if(position +1 == Diccionario.size()){
            SaveLastPosition(palabra, Diccionario);
        }else{
            while(itr.hasNext()){
                position++;
                line = itr.next();
                Diccionario.set(position, palabra);
                palabra = line;

                if((position + 1) == Diccionario.size()){
                    SaveLastPosition(palabra, Diccionario);
                    break;
                }
            }
        }
    }
    public static void SaveLastPosition (String line, LinkedList<String>Diccionario){
        Diccionario.add(line);
    }
    public static void PrintLinkedList (LinkedList<String>Diccionario){
        ListIterator<String> itr = Diccionario.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void Create_Filetxt(LinkedList<String> Diccionario) throws IOException {
        FileWriter writer = new FileWriter("Fixed/sorteddict.txt");
        ListIterator<String> itr = Diccionario.listIterator();
        while(itr.hasNext()){
            String line = itr.next();
            writer.write(line);
            writer.write("\n");
            writer.flush();
        }
    }
    public static boolean Test (LinkedList<String> Diccionario)
    {
        boolean test = false;

        for (int i = 100; i<1000; i+=100)

            for (int j=1; i<Diccionario.get(i).length(); j++)

                if(Diccionario.get(i).charAt(j)>Diccionario.get(i+1).charAt(j))
                {
                   test = true;

                }

                else
                {
                    test =false;
                }


        return test;

    }

}