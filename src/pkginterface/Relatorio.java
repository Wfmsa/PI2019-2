package pkginterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }
CriarCompra cc=new CriarCompra();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaTeste = new javax.swing.JTextArea();
        btnGerarRelatorio = new javax.swing.JButton();

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtaTeste.setEditable(false);
        txtaTeste.setColumns(20);
        txtaTeste.setRows(5);
        jScrollPane1.setViewportView(txtaTeste);

        btnGerarRelatorio.setText("Gerar Relatorio");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 168, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed

        String f1 ;
        String f2 = null;
        
        try {
                Connection connection = Conexao.getInstance().getConnection();
                String sqlPegarProd = "SELECT * FROM produto";
                //String sqlItens = "INSERT INTO itens(idcompra,idproduto)" + "VALUES (?, ?)";
                connection.setAutoCommit(true);
                PreparedStatement psmtCompra = connection.prepareStatement(sqlPegarProd);
               // PreparedStatement psmtItens = connection.prepareStatement(sqlItens);
                txtaTeste.setText(sqlPegarProd);
                
                /*while (lerArq.ready()) {
                    String linha = lerArq.readLine();
                    String colunas[] = linha.split(";");
                    String produtos[] = colunas[3].split(",");
                    psmtCompra.setString(1, colunas[0]);
                    psmtCompra.addBatch(sqlCompra);
                    psmtCompra.setString(2, colunas[1]);
                    psmtCompra.addBatch(sqlCompra);
                    psmtCompra.setString(3, colunas[2]);
                    psmtCompra.addBatch(sqlCompra);
                    psmtCompra.execute();
                    for (int i = 0; i < produtos.length; i++) {
                        psmtItens.setString(1, colunas[0]);
                        psmtItens.addBatch(sqlItens);
                        psmtItens.setString(2, produtos[i]);
                        psmtItens.addBatch(sqlItens);
                        psmtItens.execute();
                    }
                }*/
                psmtCompra.close();
                //psmtItens.close();
                connection.close();
                //this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
            }


        /*CSVLoader loader = new CSVLoader();
       
            loader.setSource(new File(f1));
        
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        
        String[] options = new String[1];
        options[0] = "-H";
        loader.setOptions(options);

        Instances data = loader.getDataSet();

        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(f2));
        saver.setDestination(new File(f2));
        saver.writeBatch();*/
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtaTeste;
    // End of variables declaration//GEN-END:variables
}
