package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int value = 0;
    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for(int i = 0  ;  i > value  ;  i++){
            virtualMachine.popValue();
        }
    }

    public String toString(){
        return "POP" + " " + value;
    }
}
