/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aluno;

import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Kravetz
 */
public class AlunoTableModel extends AbstractTableModel {

    private GerenciarAluno gerAluno;
    private String[] nomesColunas;
    private Object[][] dadosTabela;
    private Collection<Aluno> alunos;
    private SimpleDateFormat sdf;

    public AlunoTableModel(GerenciarAluno gerAluno) {
        this.gerAluno = gerAluno;
        nomesColunas = new String[]{"Nome", "Data Nascimento", "CPF", "E-mail"};
        alunos = gerAluno.listar();
        popularMatriz();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void atualizarTabela() {
        alunos = gerAluno.listar();
        popularMatriz();
        fireTableDataChanged();
    }

    public void popularMatriz() {

        dadosTabela = new Object[alunos.size()][nomesColunas.length + 1];
        int i = 0;
        for (Aluno aluno : alunos) {
            String dt = sdf.format(aluno.getDataNascimento());
            dadosTabela[i][0] = aluno.getNome();
            dadosTabela[i][1] = dt;
            dadosTabela[i][2] = aluno.getCpf();
            dadosTabela[i][3] = aluno.getEmail();
            dadosTabela[i][4] = aluno;
            i++;
        }
    }

    public void setClientes(Collection<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
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
