package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public int peek(){
        return this.runTimeStack.get(this.runTimeStack.size()-1);

    }

    public int push(int valueToPush){
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int pop() {
         return this.runTimeStack.remove(this.runTimeStack.size() - 1);
    }


    public void dump(){
        Iterator iterator = framePointer.iterator();
        int beginFramePointer = (Integer) iterator.next();
        int endFramePointer ;
        int i = 0;

        while(i < framePointer.size()) {
            System.out.print("[");
            boolean hasNext = iterator.hasNext();
            if (hasNext) {
                endFramePointer = (Integer) iterator.next();
            } else {
                endFramePointer = runTimeStack.size();
            }
            while(beginFramePointer < endFramePointer){
                System.out.print(runTimeStack.get(beginFramePointer));
                if(beginFramePointer != endFramePointer-1){
                    System.out.print(",");
                }
                beginFramePointer++;
            }
            System.out.print("] ");
            beginFramePointer = endFramePointer;
            i++;
        }
        System.out.println();
    }


    public int store(int offset){
        int topItem = runTimeStack.get(runTimeStack.size()-1);
        int currentFramePointer = framePointer.peek() + offset;
        runTimeStack.set(currentFramePointer, topItem);
        runTimeStack.remove(runTimeStack.size()-1);
        return topItem;
    }

    public int load(int offset){
        int value = runTimeStack.get(framePointer.peek() + offset); // load 0 i = currentframesize + 1 and take the value
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame(){
        int value = runTimeStack.get(runTimeStack.size()-1);

        while(runTimeStack.size() != framePointer.peek()){
             runTimeStack.remove(runTimeStack.size()-1);
         }
        framePointer.pop();
        runTimeStack.add(value);
    }

}
