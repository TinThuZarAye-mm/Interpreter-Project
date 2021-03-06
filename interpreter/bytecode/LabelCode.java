package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String label;
    private int labelAddress;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    public String getLabel(){
        return label;
    }

    public void setLabelAddress(int labelAddress){
        this.labelAddress = labelAddress;
    }

    public String toString(){
        return "LABEL" + " " + label;
    }
}
