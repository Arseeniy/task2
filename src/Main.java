import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length == 2) {

            List<Integer> resultList = new ArrayList<>();
            Scanner firstScanner = null;
            Scanner secondScanner = null;
            float xCircle = 0;
            float yCircle = 0;
            int radius = 0;

            try {
                firstScanner = new Scanner(new File(args[0]));
                secondScanner = new Scanner(new File(args[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (firstScanner.hasNext()) {
                xCircle = firstScanner.nextFloat();
                yCircle = firstScanner.nextFloat();
                radius = firstScanner.nextInt();
            }

            while (secondScanner.hasNext()) {
                float xPoint = secondScanner.nextFloat();
                float yPoint = secondScanner.nextFloat();
                double vectorLength = Math.sqrt(Math.pow((xCircle - xPoint), 2) + Math.pow((yCircle - yPoint), 2));

                resultList.add(radius > vectorLength ? 1 : radius < vectorLength ? 2 : 0);

            }

            firstScanner.close();
            secondScanner.close();

            resultList.forEach(x -> System.out.print(x + "\n"));

        }

    }
}