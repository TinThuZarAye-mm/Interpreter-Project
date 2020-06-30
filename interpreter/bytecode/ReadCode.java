package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }
    @Override
    public void execute(VirtualMachine virtualMachine) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter an Integer : ");
            String userInput = scanner.nextLine();
            int intUserInput = Integer.parseInt(userInput);
            virtualMachine.pushValue(intUserInput);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid Integer.");
        }
    }


        public String toString () {
            return "READ" ;

        }

}
