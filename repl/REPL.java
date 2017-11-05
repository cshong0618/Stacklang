package repl;

import model.Variable;

import java.util.Scanner;

/**
 * Created by shaong on 11/5/17.
 */

public class REPL {
    Scanner scanner = new Scanner(System.in);

    public REPL() {
    }

    public void run() {
        String input = "";

        while(!input.equals("q")) {
            System.out.printf(">> ");

            input = scanner.nextLine();
            if(input.equals("q")) break;
            try {
                Read.getInstance().readLine(input);
                Evaluate.getInstance().evaluateLine();
                Variable var = Process.getInstance().processLine();

                if(var != null) System.out.println(var);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
