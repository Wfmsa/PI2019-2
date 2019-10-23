package pkginterface;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Relatorio extends javax.swing.JInternalFrame {

    public Relatorio() {
        initComponents();
    }
    String arquivoWeka = "";
    CriarCompra cc = new CriarCompra();


    ArrayList<String> listaProd = new ArrayList<String>();
    String descProd;
    private ArrayList<Integer> listaCodProdutos = new ArrayList<Integer>();
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
        btnGerarRelatorio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaixa = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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

        jScrollPane2.setViewportView(txtCaixa);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Selecione o Período de Vendas Desejado");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("De:");

        jTextField2.setText("jTextField2");

        jLabel3.setText("Até");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 383, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
            String sqlPegaridCompra = "SELECT `idcompra` FROM `compra`";
            
            
            PreparedStatement psmtPegarDescProd = connection.prepareStatement(sqlPegardescProd);
            PreparedStatement psmtPegaridCompra = connection.prepareStatement(sqlPegaridCompra);

            ResultSet rs, rs2, rs3;
            rs = psmtPegarDescProd.executeQuery();
            rs2 = psmtPegaridCompra.executeQuery();
      
            arquivoWeka+="@relation \"Teste\"\n\n";
            while (rs.next()) {
                this.descProd = rs.getString("descproduto");
                arquivoWeka+="@attribute " + this.descProd + "{y,n}\n";
                listaCodProdutos.add(rs.getInt("idproduto"));
            }
            
            arquivoWeka+="\n@data\n";
            
            while(rs2.next()){
                String sqlPegarItens = "SELECT idproduto FROM itens where idcompra = "+rs2.getString("idcompra")+
                        " order by idproduto";                
                PreparedStatement psmtPegaridProd = connection.prepareStatement(sqlPegarItens);
                rs3 = psmtPegaridProd.executeQuery();
                rs3.next();
                String saida = "{";
                for(int i = 0; i < listaCodProdutos.size();i++){
                    
                    int codigo = listaCodProdutos.get(i);                    
                    if(codigo==rs3.getInt("idproduto")){
                        saida+="y,";
                    }else{
                        saida+="?,";
                    }
                    
                    if(codigo>=rs3.getInt("idproduto")){                        
                        if(!rs3.next()){
                            for(int j = 1; j < (listaCodProdutos.size()-i);j++){
                                saida+="?,";
                            }
                           break;
                        }
                    }
                }
                saida = (String) saida.subSequence(0, saida.length()-1);
                saida+="}\n";
                arquivoWeka+= saida;
                rs3.close();                
            }
            rs2.close();
            rs.close();
            
            //txtCaixa.setText(w.retornoWeka);
            //System.out.println(arquivoWeka);
        } catch (Exception ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane txtCaixa;
    // End of variables declaration//GEN-END:variables

    private FileWriter convertArrayToString(ArrayList<String> listaProd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setTxtCaixa(String retornoWeka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
