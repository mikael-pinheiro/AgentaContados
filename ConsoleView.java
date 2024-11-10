// src/view/ConsoleView.java
package view;

import controller.ContatoController;
import model.Contato;
import java.util.Scanner;

public class ConsoleView {
    private ContatoController controller;
    private Scanner scanner;

    public ConsoleView(ContatoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Remover Contato");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> listarContatos();
                case 3 -> removerContato();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        controller.adicionarContato(new Contato(nome, telefone, email));
    }

    private void listarContatos() {
        for (Contato contato : controller.listarContatos()) {
            System.out.println(contato);
        }
    }

    private void removerContato() {
        System.out.print("Digite o nome do contato a remover: ");
        String nome = scanner.nextLine();
        controller.listarContatos().removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }
}
