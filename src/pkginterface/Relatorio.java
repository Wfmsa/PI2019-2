package pkginterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.associations.Apriori;

public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }

    CriarCompra cc = new CriarCompra();
    ArrayList<String> listaProd = new ArrayList<String>();
    String descProd;
    int idProd;
    int idProdItem;
    weka w=new weka();
    

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
                .addGap(0, 172, Short.MAX_VALUE)
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

        try {
            try (Connection connection = Conexao.getInstance().getConnection()) {
                String sqlPegarProd = "SELECT * FROM produto";
                String sqlPegarItens = "SELECT `idcompra`, `idproduto` FROM `itens` WHERE idcompra=12";
                //String sqlTabCompra = "SELECET * FROM compra";
                PreparedStatement psmtPegarCompra = connection.prepareStatement(sqlPegarProd);
                PreparedStatement psmtPegarItens = connection.prepareStatement(sqlPegarItens);
                //PreparedStatement psmtTabCompra = connection.prepareStatement(sqlTabCompra);
                ResultSet rs = psmtPegarCompra.executeQuery();
                this.listaProd.add("@relation \"Teste\"\n\n");
                while (rs.next()) {
                    this.descProd = rs.getString("descproduto");
                    this.listaProd.add("@attribute " + this.descProd + "{y,n}\n");
                }
                this.listaProd.add("\n@data\n");
                FileWriter fw = new FileWriter("C:\\Users\\aluno\\Desktop\\Teste.arff");
                //fw= convertArrayToString(this.listaProd);
                for (String s : this.listaProd) {
                    fw.append(s);
                }
                fw.close();
                //System.out.println(w.weka());
                /*while(rs.next()){
                 Object o[] = {rs.getString("descrição")};
                 System.out.println(o);
                 }*/
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
                //psmtCompra.close();
                //psmtItens.close();
                //this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtaTeste;
    // End of variables declaration//GEN-END:variables

    private FileWriter convertArrayToString(ArrayList<String> listaProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
