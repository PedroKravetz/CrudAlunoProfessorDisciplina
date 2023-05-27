/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package crudProfessor;

import bancoDados.bancoDados;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import professor.GerenciarProfessor;
import professor.Professor;
import professor.ProfessorTableModel;

/**
 *
 * @author Pedro Kravetz
 */
public class ProfessorInternalFrame extends javax.swing.JInternalFrame implements WindowListener {

    /**
     * Creates new form ProfessorInternalFrame
     *
     * @param parent
     */
    public ProfessorInternalFrame(JFrame parent, bancoDados db) {
        professorDialog = new ProfessorDialog(parent, true);
        gerProfessor = new GerenciarProfessor();
        db.setGerProfessor(gerProfessor);
        professorDialog.setGerenciarProfessor(gerProfessor);
        professorTableModel = new ProfessorTableModel(gerProfessor);
        professorDialog.addWindowListener(this);
        initComponents();
        desabilitarEditarRemover();
        professorTable.getTableHeader().setReorderingAllowed(false);
    }

    private void desabilitarEditarRemover() {
        editarBT.setEnabled(false);
        removerBT.setEnabled(false);
    }

    private void habilitarEditarRemover() {
        editarBT.setEnabled(true);
        removerBT.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pesquisaLB = new javax.swing.JLabel();
        nomeLB = new javax.swing.JLabel();
        pesquisaTF = new javax.swing.JTextField();
        pesquisaBT = new javax.swing.JButton();
        limparBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        novoBT = new javax.swing.JButton();
        editarBT = new javax.swing.JButton();
        removerBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        professorTable = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciamento de Professores");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pesquisaLB.setText("Pesquisar");

        nomeLB.setText("Nome: ");

        pesquisaBT.setText("Pesquisar");
        pesquisaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaBTActionPerformed(evt);
            }
        });

        limparBT.setText("Limpar");
        limparBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pesquisaLB)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nomeLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisaTF)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pesquisaBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparBT)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {limparBT, pesquisaBT});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisaLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLB)
                    .addComponent(pesquisaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaBT)
                    .addComponent(limparBT))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        novoBT.setText("Novo");
        novoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoBTActionPerformed(evt);
            }
        });

        editarBT.setText("Editar");
        editarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBTActionPerformed(evt);
            }
        });

        removerBT.setText("Remover");
        removerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novoBT)
                .addGap(66, 66, 66)
                .addComponent(editarBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(removerBT)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editarBT, novoBT, removerBT});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoBT)
                    .addComponent(editarBT)
                    .addComponent(removerBT))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        professorTable.setModel(professorTableModel);
        professorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(professorTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoBTActionPerformed
        professorDialog.setProfessor(new Professor());
        professorDialog.setVisible(true);
    }//GEN-LAST:event_novoBTActionPerformed

    public void limpar() {                                         
        professorTableModel.atualizarTabela();
        desabilitarEditarRemover();
        pesquisaTF.setText("");
    } 
    
    private void limparBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparBTActionPerformed
        professorTableModel.atualizarTabela();
        desabilitarEditarRemover();
        pesquisaTF.setText("");
    }//GEN-LAST:event_limparBTActionPerformed

    private void pesquisaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaBTActionPerformed
        String nomePesquisa = pesquisaTF.getText().trim();
        if (!nomePesquisa.isEmpty()) {
            Collection<Professor> professores = gerProfessor.listar(nomePesquisa);

            professorTableModel.setProfessores(professores);
            professorTableModel.popularMatriz();
            professorTableModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_pesquisaBTActionPerformed

    private void editarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBTActionPerformed
        int linha = professorTable.getSelectedRow();
        Professor professor = (Professor) professorTableModel.getValueAt(linha, 4);
        professorDialog.setProfessor(professor);
        professorDialog.objectToForm();
        professorDialog.setVisible(true);
    }//GEN-LAST:event_editarBTActionPerformed

    private void removerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerBTActionPerformed
        int linha = professorTable.getSelectedRow();
        Professor professor = (Professor) professorTableModel.getValueAt(linha, 4);
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o cliente " + professor.getNome() + "?",
                "Confirma a exclusão?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            if(gerProfessor.removeProfessorBanco(professor))
                gerProfessor.remover(professor.getId());
            professorTableModel.atualizarTabela();
            desabilitarEditarRemover();
        }
    }//GEN-LAST:event_removerBTActionPerformed

    private void professorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professorTableMouseClicked
        int linha = professorTable.getSelectedRow();
        if (linha >= 0)
            habilitarEditarRemover();
    }//GEN-LAST:event_professorTableMouseClicked

    public GerenciarProfessor getGerProfessor() {
        return gerProfessor;
    }

    public void setGerProfessor(GerenciarProfessor gerProfessor) {
        this.gerProfessor = gerProfessor;
    }

    private ProfessorDialog professorDialog;
    private GerenciarProfessor gerProfessor;
    private ProfessorTableModel professorTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editarBT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparBT;
    private javax.swing.JLabel nomeLB;
    private javax.swing.JButton novoBT;
    private javax.swing.JButton pesquisaBT;
    private javax.swing.JLabel pesquisaLB;
    private javax.swing.JTextField pesquisaTF;
    private javax.swing.JTable professorTable;
    private javax.swing.JButton removerBT;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        professorTableModel.atualizarTabela();
        desabilitarEditarRemover();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
