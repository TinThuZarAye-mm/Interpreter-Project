package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    private String address = "";
    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 0){
            address = null;
        }else{
            address = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.popTheFrame();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
        virtualMachine.peekValue();
    }

    public String toString(){
        if(address != null){
            return "RETURN" + " " + address;
        }
        return "RETURN";
    }
}
