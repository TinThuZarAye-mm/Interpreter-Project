package interpreter.virtualmachine;

import interpreter.CodeTable;
import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Program {

    private ArrayList<ByteCode> program;
   // private HashMap<String, Integer> trackLabels;

    public Program() {
        program = new ArrayList<>();
       // trackLabels = new HashMap<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void addBytecode(ByteCode bc){
        program.add(bc);
    }


    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {

        for(int i = 0  ;  i < program.size()  ;  i++){
            ByteCode bc = program.get(i);
            if(bc instanceof LabelCode){
                for(int j = 0  ;  j < program.size()  ;  j++){
                    ByteCode innerBC = program.get(j);
                    if(innerBC instanceof GotoCode) {
                        if (((GotoCode) innerBC).getLabel().equalsIgnoreCase(((LabelCode) bc).getLabel())) {
                            ((GotoCode) innerBC).setLabelAddress(i);
                        }
                    }else if(innerBC instanceof CallCode) {
                        if (((CallCode) innerBC).getAddress().equalsIgnoreCase(((LabelCode) bc).getLabel())) {
                            ((CallCode) innerBC).setLabelAddress(i);
                        }
                    }else if(innerBC instanceof FalseBranchCode){
                        if(((FalseBranchCode) innerBC).getLabel().equalsIgnoreCase(((LabelCode) bc).getLabel())){
                            ((FalseBranchCode) innerBC).setLabelAddress(i);
                        }
                    }

                }
            }
        }
    }


}
