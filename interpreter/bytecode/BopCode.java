package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String operator;
    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        int firstOperand = virtualMachine.popValue();
        int secondOperand = virtualMachine.popValue();
        int result = 0;

        if(operator.equals("+")){
            result = secondOperand + firstOperand;
            virtualMachine.pushValue(result);
        }else if(operator.equals("-")){
            result = secondOperand - firstOperand;
            virtualMachine.pushValue(result);
        }else if(operator.equals("/")){
            result = secondOperand / firstOperand;
            virtualMachine.pushValue(result);
        }else if(operator.equals("*")){
            result = secondOperand * firstOperand;
            virtualMachine.pushValue(result);
        }else if(operator.equals("==")){
            if(secondOperand == firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals("!=")){
            if(secondOperand != firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals("<=")){
            if(secondOperand <= firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals(">=")){
            if(secondOperand >= firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals("<")){
            if(secondOperand < firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals(">")){
            if(secondOperand > firstOperand){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals("|")){
            if(secondOperand ==1 || firstOperand == 1){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }else if(operator.equals("&")){
            if(secondOperand == 1  &&  firstOperand == 1){
                result = 1;
            }
            virtualMachine.pushValue(result);
        }
    }

    public String toString(){
        return "BOP" + " " + operator;
    }
}
