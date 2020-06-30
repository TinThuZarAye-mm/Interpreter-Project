
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName;
        String className;
        Class classBluePrint;
        Program program = new Program();
        ByteCode bc;

        try {
            while (this.byteSource.ready()) {

                line = this.byteSource.readLine(); // tokenize read line

                items = line.split("\\s+"); // split the line by spaces

                StringTokenizer st = new StringTokenizer(line);

                byteCodeName = items[0]; // grab first token of line

                className = CodeTable.getClassName(st.nextToken()); // grab class name

                classBluePrint = Class.forName("interpreter.bytecode." + className); // load class blueprint from calssname

                bc = (ByteCode) classBluePrint.getDeclaredConstructor().newInstance(); // get declared constructor (should be no-arg constructor) and create a new instance of bytecode using constructor

                // grab remaining arguments
                args.clear();
                while (st.hasMoreTokens()){
                    args.add(st.nextToken());
                }

                bc.init(args); // pass args to bytecode init function

                program.addBytecode(bc);// add bytecode to program
            }
        }catch (IOException ex){
            System.out.println(ex);
            System.exit(255);
        } catch (ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(255);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        program.resolveAddress();
        return program;
    }
}
