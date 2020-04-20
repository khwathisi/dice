import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public  static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Dice Roller\n");
        System.out.println("How many faces does the dice have?");
        int f = input.nextInt();

        ArrayList<Integer> w = new ArrayList();
        for(int x = 0; x < f; x++)
        {
            int seq = 1 +x;
            System.out.println("Enter weight for side " + seq);
            w.add(input.nextInt());
        }

        Dice dice = new Dice(f,w);
        System.out.println("\nYou got a " + dice.roll() + ".");
    }

    public static class Dice {
        private int faces = 0;
        int weight;
        ArrayList<Integer> arrayWeight;

        public Dice(int faces, ArrayList<Integer> arrayWeight) {
            this.faces = faces;
            this.arrayWeight = arrayWeight;
        }

        public int roll() {
            int roll=0;

            for(int z = 0; z < faces; z++)
            {
                double r = Math.random();
                weight = arrayWeight.get(z);
                double ws = weight;
                double f1 = faces+1;
                double mid = ws/f1;
                if (r < mid) roll = z + 1;
            }
            return roll;
        }
    }
}
