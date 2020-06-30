package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    private int offset = 0;
    private String id = "";

    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 1){
            offset = Integer.parseInt(args.get(0));
        }else{
            offset = Integer.parseInt(args.get(0));
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushValue(offset);
    }

    public String toString(){
        if(id == ""){
            return "LIT" + " " + offset;
        }
        return "LIT" + " " + offset + " " + id;
    }
}
