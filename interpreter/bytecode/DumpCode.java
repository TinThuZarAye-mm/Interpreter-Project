package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private String dumpLabel;
    @Override
    public void init(ArrayList<String> args) {
        dumpLabel = args.get(0);

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if("ON".equals(dumpLabel)){
            virtualMachine.dumpOn();
        }else{
            virtualMachine.dumpOff();
        }
    }

    public String toString(){
        return "DUMP" + " " + dumpLabel;
    }
}
