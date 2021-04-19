import java.io.FileWriter;
import java.io.IOException;

/**
 * lexer
 */
public class lexer {
    //memoria
    private int[] memory;
    //ponteiro de dados
    private int mp;
    //ponteiro de programas
    private int pp;
    private FileWriter OFFile;

    public lexer(){
        mp = 0;
        pp = 0;
        memory = new int[1000];
        try{
            OFFile = new FileWriter("src/OF.txt");
        }catch(Exception e){
            System.err.println(e);
        }
    }

    public void interpret(String word) throws IOException{
        boolean shouldExecute = true;
        while(pp < word.length() && shouldExecute){
            char token = word.charAt(pp);

            switch (token) {
                case '>':
                    changeMp(+1);
                    pp++;
                    break;
                case '<':
                    changeMp(-1);
                    pp++;
                    break;
                case '+':
                    setMemoryValue(+1);
                    pp++;
                    break;
                case '-':
                    setMemoryValue(-1);
                    pp++;
                    break;
                case '[':
                    openBracketRule(word);
                    break;
                case ']':
                    closeBracketRule(word);
                    break;
                case ',':
                    
                    break;
                case '.':
                    dotRule();
                    pp++;
                    break;
                case '$':
                    dolarRule();
                    shouldExecute = false;
                    break;
                default:
                    shouldExecute = false;
                    System.out.println("Palavra invalida, erro de sintaxe");
                    break;
            }
        }    
    }

    private void changeMp(int value){
        mp += value;
    }

    private void setMemoryValue(int value){
        memory[mp] += value;
    }

    private void openBracketRule(String word){
        if(memory[mp] == 0){
            for(; word.charAt(pp) != ']'; pp++);
            pp++;
        }else pp++;
    }

    private void closeBracketRule(String word){
        if(memory[mp] != 0){
            for(; word.charAt(pp) != '['; pp--);
        }else pp++;
    }

    private void dotRule() throws IOException{
        char c = (char)memory[mp];
        OFFile.write(c);  
    }

    private void dolarRule() throws IOException{
        OFFile.write("\n");
        for(int i = 0; i < memory.length;i++){
            OFFile.write("" + memory[i]);
        }
        OFFile.close();
    }
}