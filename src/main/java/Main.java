import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DiceFactory DiceFactory = new DiceFactory();

        //die sides and weight
        try
        {
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
        }catch(Exception e)
        {
            System.out.println("Error with entering the die's sides and weights");
        }

        //Dice Factory
        try
        {
            System.out.println("Making a Dice, how many sides.?");
            int s = input.nextInt();
            System.out.println("A "+ DiceFactory.makeDice(s) + " sided was manufactured");
        }catch (Exception e)
        {
            System.out.println("Error manufacturing dice");
        }


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
            try
            {
                for(int z = 0; z < faces; z++)
                {
                    double r = Math.random();
                    weight = arrayWeight.get(z);
                    double ws = weight;
                    double f1 = faces+1;
                    double mid = ws/f1;
                    if (r < mid) roll = z + 1;
                }

            }catch (Exception e)
            {
                System.out.println("Error dealing with the die's sides and weights");
            }
            return roll;
        }
    }
}
