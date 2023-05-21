/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disciplina;

import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Kravetz
 */
public class DisciplinaTableModel extends AbstractTableModel {

    private GerenciarDisciplina gerDisciplina;
    private String[] nomesColunas;
    private Object[][] dadosTabela;
    private Collection<Disciplina> disciplinas;

    public DisciplinaTableModel(GerenciarDisciplina gerDisciplina) {
        this.gerDisciplina = gerDisciplina;
        nomesColunas = new String[]{"Nome", "Carga Horária", "Código", "Bloco"};
        disciplinas = gerDisciplina.listar();
        popularMatriz();
    }

    public void atualizarTabela() {
        disciplinas = gerDisciplina.listar();
        popularMatriz();
        fireTableDataChanged();
    }

    public void popularMatriz() {

        dadosTabela = new Object[disciplinas.size()][nomesColunas.length + 1];
        int i = 0;
        for (Disciplina disciplina : disciplinas) {
            dadosTabela[i][0] = disciplina.getNome();
            dadosTabela[i][1] = disciplina.getCargaHoraria();
            dadosTabela[i][2] = disciplina.getCodigo();
            dadosTabela[i][3] = disciplina.getBloco();
            dadosTabela[i][4] = disciplina;
            i++;
        }
    }

    public void setDisciplinas(Collection<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dadosTabela[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nomesColunas[column];
    }
}
