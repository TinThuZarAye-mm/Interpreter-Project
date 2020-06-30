package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private int offset;
    private String id;

    @Override
    public void init(ArrayList<String> args) {

        if(args.size() == 2){
            offset = Integer.parseInt(args.get(0));
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.peekValue();
        virtualMachine.storeValue(offset);
    }

    public String toString(){
        return "STORE" + " " + offset + " " + id;
    }
}
