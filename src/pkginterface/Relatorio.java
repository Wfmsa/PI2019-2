package pkginterface;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }

    CriarCompra cc = new CriarCompra();
    ArrayList<String> listaProd = new ArrayList<String>();
    String descProd;
    private ArrayList<Integer> idProdProduto = new ArrayList<Integer>();
    private ArrayList<Integer> idProdItens = new ArrayList<Integer>(); 
    private ArrayList<Integer> idcompraCompra = new ArrayList<Integer>();

    /*public class ArrayToString {
     Relatorio r=new Relatorio();
     {
     String [] strArray = new String [] {listaProd.toString()};
     String newString = Arrays.toString (strArray) ;
     newString = newString.substring (1, newString.length () - 1);     
     r.listaProdS=newString;
     }
     }
     */
    String listaProdS;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCaixa = new javax.swing.JTextArea();
        btnGerarRelatorio = new javax.swing.JButton();

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtCaixa.setEditable(false);
        txtCaixa.setColumns(20);
        txtCaixa.setRows(5);
        jScrollPane1.setViewportView(txtCaixa);

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
                .addGap(0, 176, Short.MAX_VALUE)
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

        try (Connection connection = Conexao.getInstance().getConnection()) {
            String sqlPegardescProd = "SELECT `descproduto` FROM `produto`";
            String sqlPegaridCompraItens = "SELECT `idcompra` FROM `itens`";
            String sqlPegaridProdItens = "SELECT `idproduto` FROM `itens` WHERE `idcompra`=";
            String sqlPegaridProd = "SELECT `idproduto` FROM `produto`";
            String sqlPegaridCompra = "SELECT `idcompra` FROM `compra`";

            PreparedStatement psmtPegarDescProd = connection.prepareStatement(sqlPegardescProd);
            PreparedStatement psmtPegaridCompraItens = connection.prepareStatement(sqlPegaridCompraItens);
            PreparedStatement psmtPegarProdItens = connection.prepareStatement(sqlPegaridProdItens);
            PreparedStatement psmtPegaridProd = connection.prepareStatement(sqlPegaridProd);
            PreparedStatement psmtPegaridCompra = connection.prepareStatement(sqlPegaridCompra);

            ResultSet rs, rs2, rs3, rs4, rs5;
            rs = psmtPegarDescProd.executeQuery();
            rs2 = psmtPegaridCompraItens.executeQuery();
            rs3 = psmtPegarProdItens.executeQuery();
            rs4 = psmtPegaridProd.executeQuery();
            rs5 = psmtPegaridCompra.executeQuery();

            this.listaProd.add("@relation \"Teste\"\n\n");
            while (rs.next()) {
                this.descProd = rs.getString("descproduto");
                this.listaProd.add("@attribute " + this.descProd + "{y,n}\n");
            }
            this.listaProd.add("\n@data\n");
            
            while (rs5.next()) {
                int auxFodase;
                auxFodase = rs5.getInt("idcompra");
                idcompraCompra.add(auxFodase);

            }
            
            while(rs4.next()){
                int aux;
                aux = rs4.getInt("idproduto");
                idProdProduto.add(aux);
                
            }
            
            while(rs3.next()){
                int aux;
                aux = rs3.getInt("idproduto");
                idProdItens.add(aux);
                
            }
            
            System.out.println(rs5);
            //System.out.println(idcompraCompra);

            /*for (int i = 0; i <= idcompraCompra.size(); i++) {
                System.out.println("\n");
                for(int j = 0;j <= this.idProdProduto.size();j++){
                    for(int k =0;k <=this.idProdItens.size();k++){
                    if(j==k){
                        this.listaProd.add("y");
                    }else{
                        this.listaProd.add("?");
                    }
                    }
                
                    
                    
                    
                }
               
                
            }*/

            /*if (idProdItens == idProd) {

             this.listaProd.add("y");

             } else {

             this.listaProd.add("?");

             }*/
            rs.close();
            rs2.close();
            rs3.close();
            rs4.close();
            System.out.println(this.listaProd);
            /*FileWriter fw = new FileWriter("C:\\Users\\user\\Desktop\\Weka_Teste.arff");
             fw= convertArrayToString(this.listaProd);
             for (String s : this.listaProd) {
             fw.append(s);
             }
             fw.close();*/

            //Weka aa = new Weka();
            //txtCaixa.setText(aa.a);
        } catch (Exception ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCaixa;
    // End of variables declaration//GEN-END:variables

    private FileWriter convertArrayToString(ArrayList<String> listaProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
