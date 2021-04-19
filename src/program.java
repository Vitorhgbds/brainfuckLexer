import interpreter.Vm;

public class program {
    public static void main(String[] args) {
        Vm interpreter = new Vm();
        //[0] sair;
        //[1] inserir input
        //[2] inserir programa
        //[3] rodar programa
        interpreter.runProgram();
    }
}
