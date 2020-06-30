package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String label = "";
    private int labelAddress = 0;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int getProgramCounter = virtualMachine.getProgramCounter();
        virtualMachine.pushReturnAddress(getProgramCounter);
        virtualMachine.setProgramCounter(labelAddress);
    }


    public String getAddress(){
        return label;
    }

    public void setLabelAddress(int labelAddress){
        this.labelAddress = labelAddress;
    }


    public String toString(){
        return "CALL" + " " + label;
    }
}
