// src/Main.java
import controller.ContatoController;
import view.ConsoleView;
import view.SwingView;
import javax.swing.SwingUtilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController controller = new ContatoController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a interface:");
        System.out.println("1. Console");
        System.out.println("2. Gráfica (Swing)");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                ConsoleView consoleView = new ConsoleView(controller);
                consoleView.iniciar();
            }
            case 2 -> {
                SwingUtilities.invokeLater(() -> new SwingView(controller).setVisible(true));
            }
            default -> System.out.println("Opção inválida!");
        }
    }
}
