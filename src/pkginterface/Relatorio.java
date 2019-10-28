package pkginterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }

    CriarCompra cc = new CriarCompra();
    ArrayList<String> listaProd = new ArrayList<String>();
    String descProd;
    String arquivoWeka = "";
    File arquivo = new File("teste.arff");
    private ArrayList<Integer> listaCodProdutos = new ArrayList<Integer>();
    String listaProdS;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        btnGerarRelatorio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtData2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnMes = new javax.swing.JCheckBox();
        btnSemana = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaixa = new javax.swing.JTextArea();

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGerarRelatorio.setText("Gerar Relatorio");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Selecione o Período de Vendas Desejado");

        txtData1.setText("2012/12/12");
        txtData1.setEnabled(false);
        txtData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtData1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("De:");
        jLabel2.setEnabled(false);

        txtData2.setText("2012/12/15");
        txtData2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Até:");
        jLabel3.setEnabled(false);

        btnMes.setSelected(true);
        btnMes.setText("Por dia do mês");
        btnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesActionPerformed(evt);
            }
        });

        btnSemana.setText("Por dia de Semana");
        btnSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemanaActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Segunda-Feira");
        jCheckBox1.setEnabled(false);

        jCheckBox2.setText("Quarta-Feira");
        jCheckBox2.setEnabled(false);

        jCheckBox3.setText("Sexta_Feira");
        jCheckBox3.setEnabled(false);

        jCheckBox4.setText("Terça-Feira");
        jCheckBox4.setEnabled(false);

        jCheckBox5.setText("Quinta-Feira");
        jCheckBox5.setEnabled(false);

        jCheckBox6.setText("Sábado");
        jCheckBox6.setEnabled(false);

        jCheckBox7.setText("Domingo");
        jCheckBox7.setEnabled(false);

        txtCaixa.setEditable(false);
        txtCaixa.setColumns(20);
        txtCaixa.setRows(5);
        jScrollPane2.setViewportView(txtCaixa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(393, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSemana)
                            .addComponent(jCheckBox3))
                        .addGap(377, 711, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMes)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGerarRelatorio)))))
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jCheckBox7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMes)
                .addGap(0, 0, 0)
                .addComponent(btnSemana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox5)
                    .addComponent(btnGerarRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed

        try (Connection connection = Conexao.getInstance().getConnection()) {
            String sqlPegardescProd = "SELECT * FROM `produto` order by idproduto";
            //String sqlPegaridCompra = "SELECT `idcompra` FROM `compra` WHERE `data` =";
            String sqlPegaridCompra = "SELECT `idcompra` FROM `compra` WHERE `data` between \"" + txtData1.getText() + "\"AND\"" + txtData2.getText() + "\"";
            //Este codigo comentado faz um select por data, o professor qr por dia da semana        

            PreparedStatement psmtPegarDescProd = connection.prepareStatement(sqlPegardescProd);
            PreparedStatement psmtPegaridCompra = connection.prepareStatement(sqlPegaridCompra);

            ResultSet rs, rs2, rs3;
            rs = psmtPegarDescProd.executeQuery();
            rs2 = psmtPegaridCompra.executeQuery();

            arquivoWeka += "@relation \"Teste\"\n\n";
            while (rs.next()) {
                this.descProd = rs.getString("descproduto");
                arquivoWeka += "@attribute " + this.descProd + "{y,n}\n";
                listaCodProdutos.add(rs.getInt("idproduto"));
            }

            arquivoWeka += "\n@data\n";

            while (rs2.next()) {
                String sqlPegarItens = "SELECT idproduto FROM itens where idcompra = " + rs2.getString("idcompra")
                        + " order by idproduto";
                PreparedStatement psmtPegaridProd = connection.prepareStatement(sqlPegarItens);
                rs3 = psmtPegaridProd.executeQuery();
                rs3.next();
                String saida = "";
                for (int i = 0; i < listaCodProdutos.size(); i++) {

                    int codigo = listaCodProdutos.get(i);
                    if (codigo == rs3.getInt("idproduto")) {
                        saida += "y,";
                    } else {
                        saida += "?,";
                    }

                    if (codigo >= rs3.getInt("idproduto")) {
                        if (!rs3.next()) {
                            for (int j = 1; j < (listaCodProdutos.size() - i); j++) {
                                saida += "?,";
                            }
                            break;
                        }
                    }
                }
                saida = (String) saida.subSequence(0, saida.length() - 1);
                saida += "\n";
                arquivoWeka += saida;
                rs3.close();
            }
            rs2.close();
            rs.close();

            try (FileWriter fw = new FileWriter(arquivo)) {
             fw.write(arquivoWeka);
             fw.flush();
             } catch (IOException ex) {
             ex.printStackTrace();
             }
            
            //System.out.println(arquivo.getAbsolutePath());
            //StringBuffer str = new StringBuffer();
            //str.append(arquivoWeka);
            /*try {

             FileWriter out = new FileWriter("Teste.arff");
             out.write(str.toString());
             out.close();
                
             } catch (IOException e) {
             e.printStackTrace();
             }*/

            Weka w = new Weka();
            txtCaixa.setText(w.retornoWeka);
        } catch (Exception ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    private void txtData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtData1ActionPerformed

    }//GEN-LAST:event_txtData1ActionPerformed

    private void btnSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaActionPerformed
        if (btnSemana.isSelected()) {
            btnMes.setSelected(false);
            jCheckBox1.setEnabled(true);
            jCheckBox2.setEnabled(true);
            jCheckBox3.setEnabled(true);
            jCheckBox4.setEnabled(true);
            jCheckBox5.setEnabled(true);
            jCheckBox6.setEnabled(true);
            jCheckBox7.setEnabled(true);
            jLabel2.setEnabled(false);
            txtData1.setEnabled(false);
            jLabel3.setEnabled(false);
            txtData2.setEnabled(false);
        }
    }//GEN-LAST:event_btnSemanaActionPerformed

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed
        if (btnMes.isSelected()) {
            btnSemana.setSelected(false);
            jLabel2.setEnabled(true);
            txtData1.setEnabled(true);
            jLabel3.setEnabled(true);
            txtData2.setEnabled(true);
            jCheckBox1.setEnabled(false);
            jCheckBox2.setEnabled(false);
            jCheckBox3.setEnabled(false);
            jCheckBox4.setEnabled(false);
            jCheckBox5.setEnabled(false);
            jCheckBox6.setEnabled(false);
            jCheckBox7.setEnabled(false);
        }
    }//GEN-LAST:event_btnMesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    public javax.swing.JCheckBox btnMes;
    public javax.swing.JCheckBox btnSemana;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea txtCaixa;
    private javax.swing.JTextField txtData1;
    private javax.swing.JTextField txtData2;
    // End of variables declaration//GEN-END:variables

    private FileWriter convertArrayToString(ArrayList<String> listaProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
