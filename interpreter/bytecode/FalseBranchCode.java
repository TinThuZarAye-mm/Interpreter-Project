package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String label ;
    private int labelAddress ;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if(virtualMachine.popValue() == 0){
            virtualMachine.setProgramCounter(labelAddress);
        }
    }

    public void setLabel(String label){
        this.label = label;
    }

    public void setLabelAddress(int labelAddress){
        this.labelAddress = labelAddress;
    }

    public String getLabel(){
        return label;
    }

    public int getLabelAddress(){
        return labelAddress;
    }

    public String toString(){
        return "FALSEBRANCH" + " " + label;
    }
}
