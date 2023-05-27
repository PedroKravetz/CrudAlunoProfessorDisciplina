/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disciplina;

import bancoDados.bancoDados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Pedro Kravetz
 */
public class GerenciarDisciplina {

    private int ultimoId;
    private HashMap<Integer, Disciplina> disciplinasBD;
    private bancoDados banco;

    public GerenciarDisciplina() {
        ultimoId = 0;
        disciplinasBD = new HashMap<>();
    }

    public void setBancoDados(bancoDados bd)
    {
        banco = bd;
    }

    public boolean insereDisciplinaBanco(Disciplina disciplina)
    {
        return banco.insereDisciplina(disciplina);
    }

    public boolean updateDisciplinaBanco(Disciplina disciplina)
    {
        return banco.updateDisciplina(disciplina);
    }

    public boolean removeDisciplinaBanco(Disciplina disciplina)
    {
        return banco.removeDisciplina(disciplina);
    }
    
    public void create(Disciplina disciplina) {
        disciplina.setId(++ultimoId);
        disciplinasBD.put(ultimoId, disciplina);
    }

    public Collection<Disciplina> listar() {
        return disciplinasBD.values();
    }

    public Collection<Disciplina> listar(String pesquisa) {
        Collection<Disciplina> disciplinas = new ArrayList<>();
        for (Disciplina disc : disciplinasBD.values()) {
            if (disc.getNome().contains(pesquisa)) {
                disciplinas.add(disc);
            }
        }
        return disciplinas;
    }

    public void remover(int id) {
        disciplinasBD.remove(id);
    }

    public void update(Disciplina disciplina) {
        this.remover(disciplina.getId());
        disciplinasBD.put(disciplina.getId(), disciplina);
    }
}
