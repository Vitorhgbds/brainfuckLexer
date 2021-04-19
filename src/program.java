import java.util.Scanner;
import interpreter.Vm;

public class program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vm interpreter = new Vm();
        int opcao = 0;
        String logo = "______               _        ______               _     \n";
        logo += "| ___ \\             (_)       |  ___|             | |    \n";
        logo += "| |_/ / _ __   __ _  _  _ __  | |_    _   _   ___ | | __ \n";
        logo += "| ___ \\| '__| / _` || || '_ \\ |  _|  | | | | / __|| |/ / \n";
        logo += "| |_/ /| |   | (_| || || | | || |    | |_| || (__ |   <  \n";
        logo += "\\____/ |_|    \\__,_||_||_| |_|\\_|     \\__,_| \\___||_|\\_\\ \n";
        logo += "\n";

        System.out.println(logo);
        do {
            
            System.out.println("|=====================================|");
            System.out.println("|                MENU                 |");
            System.out.println("|=====================================|");
            System.out.println("|                                     |");
            System.out.println("|  [0] - Sair                         |");
            System.out.println("|  [1] - Inserir Input                |");
            System.out.println("|  [2] - Inserir programa             |");
            System.out.println("|  [3] - Executar Programa            |");
            System.out.println("|                                     |");
            System.out.println("|=====================================|");
            
            System.out.println("\nDigite a opcao que deseja acessar: ");
            opcao =in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Obrigado por usar nossa aplicacao, tenha um bom dia!");
                    break;
                case 1:

                    break;
                default:
                    break;
            }
            
        } while (opcao != 0);



        //[0] sair;
        //[1] inserir input
        //[2] inserir programa
        //[3] rodar programa
        interpreter.runProgram();
    }
}
