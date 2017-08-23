import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

public class BubbleSort {

    public static void main(String... args) {
        int number;
        Integer tempNr;
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean isSwapped = false;

        if (args.length == 1) {
            try {

                Scanner fileInput = new Scanner(new File(args[0]));
                while(fileInput.hasNextInt()) {
                    number = fileInput.nextInt();
                    numbers.add(number);

                }
                while (!isSwapped) {
                    isSwapped = true;
                    for(int i=0;i<numbers.size()-1;i++) {

                        if (numbers.get(i) > numbers.get(i+1)) {
                            Collections.swap(numbers, i, i+1);
                            isSwapped =false;
                        }
                    }
                }
                fileInput.close();
                System.out.println(numbers);

                PrintWriter fileOutput = new PrintWriter("numbers_sorted.txt");
                for(int i : numbers) {
                    fileOutput.println(i);
                }

            } catch (FileNotFoundException e) {
                System.out.format("File %s not found\n", args[0]);
            }
    }   }
}
