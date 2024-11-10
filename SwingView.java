// src/view/SwingView.java
package view;

import controller.ContatoController;
import model.Contato;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingView extends JFrame {
    private ContatoController controller;
    private JTable table;
    private DefaultTableModel tableModel;

    public SwingView(ContatoController controller) {
        this.controller = controller;
        setupUI();
    }

    private void setupUI() {
        setTitle("Agenda de Contatos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Telefone", "Email"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(e -> adicionarContato());
        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(e -> removerContato());

        panel.add(addButton);
        panel.add(removeButton);

        add(panel, BorderLayout.SOUTH);
    }

    private void adicionarContato() {
        String nome = JOptionPane.showInputDialog("Nome:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String email = JOptionPane.showInputDialog("Email:");
        Contato contato = new Contato(nome, telefone, email);
        controller.adicionarContato(contato);
        atualizarTabela();
    }

    private void removerContato() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String nome = (String) tableModel.getValueAt(selectedRow, 0);
            controller.listarContatos().removeIf(c -> c.getNome().equals(nome));
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um contato para remover.");
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Contato contato : controller.listarContatos()) {
            tableModel.addRow(new Object[]{contato.getNome(), contato.getTelefone(), contato.getEmail()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingView(new ContatoController()).setVisible(true));
    }
}
