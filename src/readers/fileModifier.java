package readers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileModifier {
    
    public static String read(String fileName){
        String content = "";
        try {
            FileReader file = new FileReader("src/readers/" + fileName);
            BufferedReader bf = new BufferedReader(file);
            
            while(bf.ready()){
                content += bf.readLine() + "\n";
            }
            bf.close();
        } catch (Exception e) {
            System.err.println("Erro na leitura do arquivo: " + fileName + "\n erro:" + e);
        }
        return content;
    }

    public static boolean write(String fileName, String content){
        try {
            FileWriter file = new FileWriter("src/readers/" + fileName, true);
            file.append(content);
            file.close();
        } catch (Exception e) {
            System.err.println("Erro na escrita do arquivo: " + fileName + "\nErro: " + e);
            return false;
        }
        return true;
    }

    public static void clean(String fileName){
        try {
            FileWriter file = new FileWriter("src/readers/" + fileName);
            file.flush();
            file.close();
        } catch (Exception e) {
            System.err.println("Erro na limpeza do arquivo: " + fileName + "\nErro: " + e);
        }
    }
}
