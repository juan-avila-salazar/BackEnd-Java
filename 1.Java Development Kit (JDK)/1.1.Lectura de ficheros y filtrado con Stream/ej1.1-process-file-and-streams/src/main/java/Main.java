import controller.PersonController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonController obj = new PersonController();
        int opt=0;
        boolean continu=true;

        obj.showContent();

        //Menu
        do {
            System.out.println("\nExercise 1.1." +
                    "\nChoose an option");
            System.out.println("1. Under 25 years old" +
                    "\n2. Remove people whose name starts with A" +
                    "\n3. First result of People in Madrid and Under 25 years old" +
                    "\n4. First result of People in Barcelona and Under 25 years old");
            opt=sc.nextInt();
            switch (opt){
                case  1:
                    obj.FilterA();
                    break;
                case  2:
                    obj.FilterB();
                    break;
                case  3:
                    obj.FilterC();
                    break;
                case  4:
                    obj.FilterD();
                    break;
                default:
                    continu=false;
            }
        }while (continu);
    }
}
