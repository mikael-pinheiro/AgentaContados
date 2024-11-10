// src/controller/ContatoController.java
package controller;

import model.Contato;
import java.util.ArrayList;
import java.util.List;

public class ContatoController {
    private List<Contato> contatos;

    public ContatoController() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    public void atualizarContato(Contato antigo, Contato atualizado) {
        int index = contatos.indexOf(antigo);
        if (index != -1) {
            contatos.set(index, atualizado);
        }
    }
}
