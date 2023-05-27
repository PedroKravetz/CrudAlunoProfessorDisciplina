/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package crudProfessor;

import endereco.Endereco;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import pessoa.Sexo;
import professor.GerenciarProfessor;
import professor.Professor;

/**
 *
 * @author Pedro Kravetz
 */
public class ProfessorDialog extends javax.swing.JDialog {

    /**
     * Creates new form ProfessorDialog
     */
    public ProfessorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        errorLB.setVisible(false);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        dadosProfessorLB = new javax.swing.JLabel();
        nomeLB = new javax.swing.JLabel();
        emailLB = new javax.swing.JLabel();
        dataNascimentoLB = new javax.swing.JLabel();
        sexoLB = new javax.swing.JLabel();
        cpfLB = new javax.swing.JLabel();
        rgLB = new javax.swing.JLabel();
        rpLB = new javax.swing.JLabel();
        formacaoLB = new javax.swing.JLabel();
        salarioLB = new javax.swing.JLabel();
        departamentoLB = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        nomeTF = new javax.swing.JTextField();
        rpTF = new javax.swing.JTextField();
        salarioTF = new javax.swing.JTextField();
        departamentoTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        formacaoTP = new javax.swing.JTextPane();
        masculinoRBT = new javax.swing.JRadioButton();
        femininoRBT = new javax.swing.JRadioButton();
        salvarBT = new javax.swing.JButton();
        cancelarBT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        complementoTF = new javax.swing.JTextArea();
        errorLB = new javax.swing.JLabel();
        complementoLB = new javax.swing.JLabel();
        numeroTF = new javax.swing.JTextField();
        numeroLB = new javax.swing.JLabel();
        bairroLB = new javax.swing.JLabel();
        bairroTF = new javax.swing.JTextField();
        ruaTF = new javax.swing.JTextField();
        ruaLB = new javax.swing.JLabel();
        cepTF = new javax.swing.JFormattedTextField();
        cepLB = new javax.swing.JLabel();
        cpfTF = new javax.swing.JFormattedTextField();
        rgTF = new javax.swing.JFormattedTextField();
        dataNascimentoTF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        dadosProfessorLB.setText("Dados do Professor");

        nomeLB.setText("Nome: ");

        emailLB.setText("Email: ");

        dataNascimentoLB.setText("Data de Nascimento: ");

        sexoLB.setText("Sexo: ");

        cpfLB.setText("CPF: ");

        rgLB.setText("RG: ");

        rpLB.setText("RP: ");

        formacaoLB.setText("Formação: ");

        salarioLB.setText("Salário: ");

        departamentoLB.setText("Departamento: ");

        jScrollPane1.setViewportView(formacaoTP);

        buttonGroup1.add(masculinoRBT);
        masculinoRBT.setText("Masculino");

        buttonGroup1.add(femininoRBT);
        femininoRBT.setText("Feminino");

        salvarBT.setText("Salvar");
        salvarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBTActionPerformed(evt);
            }
        });

        cancelarBT.setText("Cancelar");
        cancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTActionPerformed(evt);
            }
        });

        complementoTF.setColumns(20);
        complementoTF.setRows(5);
        jScrollPane2.setViewportView(complementoTF);

        errorLB.setForeground(java.awt.Color.red);
        errorLB.setText("Dados incorretos");

        complementoLB.setText("Complemento: ");

        numeroLB.setText("Número: ");

        bairroLB.setText("Bairro: ");

        ruaLB.setText("Rua: ");

        try {
            cepTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cepLB.setText("CEP:");

        try {
            cpfTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            rgTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataNascimentoTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departamentoLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salarioLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(formacaoLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rpLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rgLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpfLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sexoLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dataNascimentoLB)
                                    .addComponent(emailLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailTF)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(masculinoRBT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(femininoRBT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nomeTF)
                                    .addComponent(dataNascimentoTF)
                                    .addComponent(cpfTF)
                                    .addComponent(rgTF)
                                    .addComponent(rpTF)
                                    .addComponent(jScrollPane1)
                                    .addComponent(salarioTF)
                                    .addComponent(departamentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cepLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ruaLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bairroLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numeroLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(complementoLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cepTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ruaTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bairroTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numeroTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(salvarBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelarBT))
                            .addComponent(errorLB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addComponent(dadosProfessorLB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelarBT, salvarBT});

        panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bairroLB, cepLB, complementoLB, cpfLB, dataNascimentoLB, departamentoLB, emailLB, formacaoLB, nomeLB, numeroLB, rgLB, rpLB, ruaLB, salarioLB, sexoLB});

        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dadosProfessorLB, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLB)
                    .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLB)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexoLB)
                            .addComponent(masculinoRBT)
                            .addComponent(femininoRBT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfLB)
                            .addComponent(cpfTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rgLB)
                            .addComponent(rgTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rpLB)
                            .addComponent(rpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataNascimentoLB)
                        .addComponent(dataNascimentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(formacaoLB))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioLB)
                    .addComponent(salarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departamentoLB)
                    .addComponent(departamentoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cepLB)
                    .addComponent(cepTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLB)
                    .addComponent(ruaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroLB)
                    .addComponent(bairroTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLB)
                    .addComponent(numeroTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(complementoLB)
                        .addGap(70, 70, 70))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarBT)
                    .addComponent(cancelarBT))
                .addGap(115, 115, 115))
        );

        panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {formacaoLB, jScrollPane1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        limparTextos();
    }//GEN-LAST:event_formWindowClosed

    private void salvarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBTActionPerformed
        if (validarForm()) {
            errorLB.setVisible(false);

            professor.setNome(nomeTF.getText().trim());

            try {
                Date dataNasc = sdf.parse(dataNascimentoTF.getText().trim());
                professor.setDataNascimento(dataNasc);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Data inválida");
                return;
            }

            if(professor.getId() == 0)
                professor.setCpf(cpfTF.getText().trim());
            professor.setRg(rgTF.getText().trim());
            professor.setEmail(emailTF.getText().trim());
            if(professor.getId() == 0)
                professor.setRp(Integer.parseInt(rpTF.getText().trim()));
            professor.setFormacao(formacaoTP.getText().trim());
            professor.setDepartamento(departamentoTF.getText().trim());
            professor.setSalario(Integer.parseInt(salarioTF.getText().trim()));

            if (masculinoRBT.isSelected()) {
                professor.setSexo(Sexo.MASCULINO);
            } else {
                professor.setSexo(Sexo.FEMININO);
            }
            endereco.setBairro(bairroTF.getText().trim());
            endereco.setCep(cepTF.getText().trim());
            endereco.setComplemento(complementoTF.getText().trim());
            endereco.setNumero(Integer.parseInt(numeroTF.getText().trim()));
            endereco.setRua(ruaTF.getText().trim());
            endereco.setId(professor.getId());
            professor.setEndereco(endereco);
            
            if (professor.getId() == 0) {
                if(gerProfessor.insereProfessorBanco(professor))
                {
                    gerProfessor.create(professor);
                    dispose();
                }
                else
                { 
                    errorLB.setVisible(true);
                }
            } else {
                if(gerProfessor.updateProfessorBanco(professor) && Integer.parseInt(rpTF.getText().trim())==professor.getRp() && cpfTF.getText().trim().equals(professor.getCpf()))
                {
                    gerProfessor.update(professor);
                    dispose();
                }
                else
                {
                    errorLB.setVisible(true);
                }
            }
        } else {
            errorLB.setVisible(true);
        }
    }//GEN-LAST:event_salvarBTActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        resize(new Dimension());
    }//GEN-LAST:event_formWindowActivated

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        if (professor.getId() == 0) {
            endereco = new Endereco();
        } else {
            endereco = professor.getEndereco();
        }
    }

    private void limparTextos() {
        buttonGroup1.clearSelection();
        nomeTF.setText("");
        cpfTF.setText("");
        rgTF.setText("");
        rpTF.setText("");
        departamentoTF.setText("");
        salarioTF.setText("");
        formacaoTP.setText("");
        dataNascimentoTF.setText("");
        emailTF.setText("");
        cepTF.setText("");
        bairroTF.setText("");
        ruaTF.setText("");
        numeroTF.setText("");
        complementoTF.setText("");
    }

    private boolean validarForm() {
        boolean isValido = true;
        if (rpTF.getText().trim().equals("")) {
            isValido = false;
            rpLB.setForeground(Color.red);
        } else {
            try {
                Integer.parseInt(rpTF.getText().trim());
                rpLB.setForeground(Color.black);
            } catch (Exception e) {
                isValido = false;
                rpLB.setForeground(Color.red);
            }
        }

        if (formacaoTP.getText().trim().equals("")) {
            isValido = false;
            formacaoLB.setForeground(Color.red);
        } else {
            formacaoLB.setForeground(Color.black);
        }

        if (departamentoTF.getText().trim().equals("")) {
            isValido = false;
            departamentoLB.setForeground(Color.red);
        } else {
            departamentoLB.setForeground(Color.black);
        }

        if (salarioTF.getText().trim().equals("")) {
            isValido = false;
            salarioLB.setForeground(Color.red);
        } else {
            try {
                Integer.parseInt(salarioTF.getText().trim());
                salarioLB.setForeground(Color.black);
            } catch (Exception e) {
                isValido = false;
                salarioLB.setForeground(Color.red);
            }
        }

        if (cepTF.getText().trim().length() != 9) {
            isValido = false;
            cepLB.setForeground(Color.red);
        } else {
            cepLB.setForeground(Color.black);
        }

        if (bairroTF.getText().trim().equals("")) {
            isValido = false;
            bairroLB.setForeground(Color.red);
        } else {
            bairroLB.setForeground(Color.black);
        }

        if (ruaTF.getText().trim().equals("")) {
            isValido = false;
            ruaLB.setForeground(Color.red);
        } else {
            ruaLB.setForeground(Color.black);
        }

        if (numeroTF.getText().trim().equals("")) {
            isValido = false;
            numeroLB.setForeground(Color.red);
        } else {
            try {
                Integer.parseInt(numeroTF.getText().trim());
                numeroLB.setForeground(Color.black);
            } catch (Exception e) {
                isValido = false;
                numeroLB.setForeground(Color.red);
            }
        }

        if (nomeTF.getText().trim().equals("")) {
            isValido = false;
            nomeLB.setForeground(Color.red);
        } else {
            nomeLB.setForeground(Color.black);
        }

        if (dataNascimentoTF.getText().trim().length() != 10) {
            isValido = false;
            dataNascimentoLB.setForeground(Color.red);
        } else {
            dataNascimentoLB.setForeground(Color.black);
        }

        if (cpfTF.getText().trim().length() != 14) {
            isValido = false;
            cpfLB.setForeground(Color.red);
        } else {
            cpfLB.setForeground(Color.black);
        }

        if (rgTF.getText().trim().length() != 12) {
            isValido = false;
            rgLB.setForeground(Color.red);
        } else {
            rgLB.setForeground(Color.black);
        }

        if (emailTF.getText().trim().equals("")) {
            isValido = false;
            emailLB.setForeground(Color.red);
        } else {
            emailLB.setForeground(Color.black);
        }

        if (!(masculinoRBT.isSelected() || femininoRBT.isSelected())) {
            isValido = false;
            sexoLB.setForeground(Color.red);
        } else {
            sexoLB.setForeground(Color.black);
        }
        return isValido;
    }

    public void setGerenciarProfessor(GerenciarProfessor gerProfessor) {
        this.gerProfessor = gerProfessor;
    }

    public void objectToForm() {
        nomeTF.setText(professor.getNome());
        cpfTF.setText(professor.getCpf());
        rgTF.setText(professor.getRg());
        emailTF.setText(professor.getEmail());
        dataNascimentoTF.setText(sdf.format(professor.getDataNascimento()));
        rpTF.setText(String.valueOf(professor.getRp()));
        departamentoTF.setText(professor.getDepartamento());
        salarioTF.setText(String.valueOf(professor.getSalario()));
        formacaoTP.setText(professor.getFormacao());
        cepTF.setText(endereco.getCep());
        ruaTF.setText(endereco.getRua());
        numeroTF.setText(String.valueOf(endereco.getNumero()));
        bairroTF.setText(endereco.getBairro());
        complementoTF.setText(endereco.getComplemento());
        if (professor.getSexo() == Sexo.MASCULINO) {
            masculinoRBT.setSelected(true);
        } else {
            femininoRBT.setSelected(true);
        }
    }

    private SimpleDateFormat sdf;
    private Professor professor;
    private Calendar cal;
    private GerenciarProfessor gerProfessor;
    private Endereco endereco;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairroLB;
    private javax.swing.JTextField bairroTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelarBT;
    private javax.swing.JLabel cepLB;
    private javax.swing.JFormattedTextField cepTF;
    private javax.swing.JLabel complementoLB;
    private javax.swing.JTextArea complementoTF;
    private javax.swing.JLabel cpfLB;
    private javax.swing.JFormattedTextField cpfTF;
    private javax.swing.JLabel dadosProfessorLB;
    private javax.swing.JLabel dataNascimentoLB;
    private javax.swing.JFormattedTextField dataNascimentoTF;
    private javax.swing.JLabel departamentoLB;
    private javax.swing.JTextField departamentoTF;
    private javax.swing.JLabel emailLB;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel errorLB;
    private javax.swing.JRadioButton femininoRBT;
    private javax.swing.JLabel formacaoLB;
    private javax.swing.JTextPane formacaoTP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton masculinoRBT;
    private javax.swing.JLabel nomeLB;
    private javax.swing.JTextField nomeTF;
    private javax.swing.JLabel numeroLB;
    private javax.swing.JTextField numeroTF;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel rgLB;
    private javax.swing.JFormattedTextField rgTF;
    private javax.swing.JLabel rpLB;
    private javax.swing.JTextField rpTF;
    private javax.swing.JLabel ruaLB;
    private javax.swing.JTextField ruaTF;
    private javax.swing.JLabel salarioLB;
    private javax.swing.JTextField salarioTF;
    private javax.swing.JButton salvarBT;
    private javax.swing.JLabel sexoLB;
    // End of variables declaration//GEN-END:variables
}
