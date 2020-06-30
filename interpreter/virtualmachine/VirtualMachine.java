package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter = 0;
    private boolean        isRunning;
    private boolean dump;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;

        while (isRunning){
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if(dump &&  !(code instanceof DumpCode)){
                System.out.println(code.toString());
                runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public void stopRunning(){
        isRunning = false;
    }

    public int popValue(){
        return runTimeStack.pop();
    }

    public void setProgramCounter(int index){
        this.programCounter = index;
    }

    public int getProgramCounter(){
        return programCounter;
    }

    public void storeValue(int topValue){
        this.runTimeStack.store(topValue);
    }

    public int peekValue(){
        return this.runTimeStack.peek();
    }

    public int loadValue(int value){
        return runTimeStack.load(value);
    }

    public void pushValue(int value){
        this.runTimeStack.push(value);
    }

    public void newFrame(int value){
        this.runTimeStack.newFrameAt(value);
    }

    public void pushReturnAddress(int value){
        this.returnAddress.push(value);
    }

    public int popReturnAddress(){
        return returnAddress.pop();
    }

    public void popTheFrame() {
        this.runTimeStack.popFrame();
    }

    public void dumpOn(){
        dump = true;
    }

    public void dumpOff(){
        dump = false;
    }
}

