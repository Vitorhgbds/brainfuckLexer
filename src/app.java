import java.io.IOException;

public class app {
    public static void main(String[] args) {
        lexer lex = new lexer();

        try {
            lex.interpret("+[------->++<]>+.------.$");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
