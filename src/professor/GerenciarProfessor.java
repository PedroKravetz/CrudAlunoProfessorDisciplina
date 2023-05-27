/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package professor;

import bancoDados.bancoDados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Pedro Kravetz
 */
public class GerenciarProfessor {

    private int ultimoId;
    private HashMap<Integer, Professor> professoresBD;
    private bancoDados banco;

    public GerenciarProfessor() {
        ultimoId = 0;
        professoresBD = new HashMap<>();
    }
    
    public void setBancoDados(bancoDados bd)
    {
        banco = bd;
    }

    public boolean insereProfessorBanco(Professor professor)
    {
        return banco.insereProfessor(professor);
    }

    public boolean updateProfessorBanco(Professor professor)
    {
        return banco.updateProfessor(professor);
    }

    public boolean removeProfessorBanco(Professor professor)
    {
        return banco.removeProfessor(professor);
    }
    
    public void create(Professor professor) {
        professor.setId(++ultimoId);
        professoresBD.put(ultimoId, professor);
    }

    public Collection<Professor> listar() {
        return professoresBD.values();
    }

    public Collection<Professor> listar(String pesquisa) {
        Collection<Professor> professores = new ArrayList<>();
        for (Professor prof : professoresBD.values()) {
            if (prof.getNome().contains(pesquisa)) {
                professores.add(prof);
            }
        }
        return professores;
    }

    public void remover(int id) {
        professoresBD.remove(id);
    }

    public void update(Professor professor) {
        this.remover(professor.getId());
        professoresBD.put(professor.getId(), professor);
    }
}
