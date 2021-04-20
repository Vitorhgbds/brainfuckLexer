import java.util.Scanner;

import interpreter.Vm;
import readers.FileModifier;

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

        
        do {
            System.out.print("\033[H\033[2J");
            System.out.print("\033[H\033[2J");

            System.out.println(logo);


            System.out.println("|=====================================|");
            System.out.println("|                MENU                 |");
            System.out.println("|=====================================|");
            System.out.println("|                                     |");
            System.out.println("|  [0] - Sair                         |");
            System.out.println("|  [1] - Inserir Input                |");
            System.out.println("|  [2] - Inserir programa             |");
            System.out.println("|  [3] - Executar Programa            |");
            System.out.println("|  [4] - Mostrar saida                |");
            System.out.println("|                                     |");
            System.out.println("|=====================================|");
            
            System.out.println("\nDigite a opcao que deseja acessar: ");
            opcao =in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Obrigado por usar nossa aplicacao, tenha um bom dia!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Input:");
                    String input = in.next();
                    FileModifier.clean("IF.txt");
                    FileModifier.write("IF.txt", input);
                    break;
                case 2: 
                    System.out.println("Escreva um programa: ");
                    input = in.next();
                    FileModifier.clean("SOURCE.txt");
                    FileModifier.write("SOURCE.txt", input);
                    break;
                case 3:
                    System.out.println("Executando...\n\n");
                    System.out.println("Programa: ");
                    System.out.println(FileModifier.read("SOURCE.txt"));
                    interpreter.runProgram();
                    break;
                case 4:
                    System.out.println("Output:");
                    System.out.println(FileModifier.read("OF.txt"));
                    break;
                default:
                    break;
            }
            System.out.println("pressione qualquer tecla em seguida [enter] para continuar...");
            in.next();
            
        } while (opcao != 0);
    }
}
