/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package professor;

import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Kravetz
 */
public class ProfessorTableModel extends AbstractTableModel {

    private GerenciarProfessor gerProfessor;
    private String[] nomesColunas;
    private Object[][] dadosTabela;
    private Collection<Professor> professores;
    private SimpleDateFormat sdf;

    public ProfessorTableModel(GerenciarProfessor gerProfessor) {
        this.gerProfessor = gerProfessor;
        nomesColunas = new String[]{"Nome", "Data Nascimento", "CPF", "E-mail"};
        professores = gerProfessor.listar();
        popularMatriz();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void atualizarTabela() {
        professores = gerProfessor.listar();
        popularMatriz();
        fireTableDataChanged();
    }

    public void popularMatriz() {

        dadosTabela = new Object[professores.size()][nomesColunas.length + 1];
        int i = 0;
        for (Professor professor : professores) {
            String dt = sdf.format(professor.getDataNascimento());
            dadosTabela[i][0] = professor.getNome();
            dadosTabela[i][1] = dt;
            dadosTabela[i][2] = professor.getCpf();
            dadosTabela[i][3] = professor.getEmail();
            dadosTabela[i][4] = professor;
            i++;
        }
    }

    public void setProfessores(Collection<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public int getRowCount() {
        return professores.size();
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
