/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aluno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Pedro Kravetz
 */
public class GerenciarAluno {

    private int ultimoId;
    private HashMap<Integer, Aluno> alunosBD;

    public GerenciarAluno() {
        ultimoId = 0;
        alunosBD = new HashMap<>();
    }

    public void create(Aluno aluno) {
        aluno.setId(++ultimoId);
        alunosBD.put(ultimoId, aluno);
    }

    public Collection<Aluno> listar() {
        return alunosBD.values();
    }

    public Collection<Aluno> listar(String pesquisa) {
        Collection<Aluno> alunos = new ArrayList<>();
        for (Aluno alu : alunosBD.values()) {
            if (alu.getNome().contains(pesquisa)) {
                alunos.add(alu);
            }
        }
        return alunos;
    }

    public void remover(int id) {
        alunosBD.remove(id);
    }

    public void update(Aluno aluno) {
        this.remover(aluno.getId());
        alunosBD.put(aluno.getId(), aluno);
    }
}
