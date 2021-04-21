package interpreter;
import java.util.LinkedList;
import java.util.Queue;

import readers.FileModifier;

public class Vm {
    //memoria
    private int[] memory;
    //ponteiro de dados
    public int mp;
    //ponteiro de programas
    public int pp;
    //input entry
    private Queue<Character> input;

    private String sourceProgram;

    private RulesInterpreter rules;

    public Vm(){
        mp = 0;
        pp = 0;
        memory = new int[1000];
        rules = new RulesInterpreter(this);
        input = new LinkedList<>();

    }

    public boolean runProgram(){
        updateInput();
        updateSource();
        if(sourceProgram == ""){
            System.err.println("Erro: Programa vazio (SOURCE.txt)");
            return false;
        }
        if(!testSyntax()){
            return false;
        }
        FileModifier.clean("OF.txt");
        
        while(pp < sourceProgram.length()){
            char command = sourceProgram.charAt(pp);
            interpretCommand(command);
        }
        return true;
    }

    private boolean updateSource(){
        sourceProgram = FileModifier.read("SOURCE.txt");
        return true;
    }

    private boolean updateInput(){
        String in = FileModifier.read("IF.txt");
        for (int i = 0; i < in.length(); i++) {
            input.add(in.charAt(i));
        }
        return true;
    }

    private boolean testSyntax(){
        boolean haveComma = false;
        int openBracketCounter = 0;
        int closeBracketCounter = 0;
        for (int i = 0; i < sourceProgram.length(); i++) {
            char command = sourceProgram.charAt(i);
            if(command == '[') openBracketCounter++;
            if(command == ']') closeBracketCounter++;
            haveComma = command == ',';
        }

        if(openBracketCounter != closeBracketCounter){
            System.err.println("Erro: Brackets invalidos");
            return false;
        }

        if(haveComma && input.isEmpty()){
            System.err.println("Erro: have comma but input is empty");
            return false;
        }
        return true;
    }
    
    private void interpretCommand(char command){
        switch (command) {
            case '>':
            rules.changeMp(+1);
            break;
            case '<':
            rules.changeMp(-1);
            break;
            case '+':
            rules.setMemoryValue(+1);
            break;
            case '-':
            rules.setMemoryValue(-1);
            break;
            case '[':
            rules.openBracketRule(sourceProgram);
            break;
            case ']':
            rules.closeBracketRule(sourceProgram);
            break;
            case ',':
            rules.commaRule();
            break;
            case '.':
            rules.dotRule();
            break;
            case '$':
            rules.dolarRule();
            break;
            default :
            pp++;
            break;
        }    
    }

    public int[] getMemory(){
        return memory;
    }

    public int getMP(){
        return mp;
    }

    public int getPP(){
        return pp;
    }

    public Queue<Character> getInput(){
            return input;
        }
}