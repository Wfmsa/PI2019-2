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
    private ArrayList<Integer> listaCodProdutos = new ArrayList<Integer>();
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
            String sqlPegardescProd = "SELECT * FROM `produto` order by idproduto";
            String sqlPegaridCompra = "SELECT `idcompra` FROM `compra`";
            String saidaArquivo = "";
            
            PreparedStatement psmtPegarDescProd = connection.prepareStatement(sqlPegardescProd);
            PreparedStatement psmtPegaridCompra = connection.prepareStatement(sqlPegaridCompra);

            ResultSet rs, rs2, rs3;
            rs = psmtPegarDescProd.executeQuery();
            rs2 = psmtPegaridCompra.executeQuery();
      
            saidaArquivo+="@relation \"Teste\"\n\n";
            while (rs.next()) {
                this.descProd = rs.getString("descproduto");
                saidaArquivo+="@attribute " + this.descProd + "{y,n}\n";
                listaCodProdutos.add(rs.getInt("idproduto"));
            }
            
            saidaArquivo+="\n@data\n";
            
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
                saidaArquivo+= saida;
                rs3.close();                
            }
            rs2.close();
            rs.close();
            System.out.println(saidaArquivo);
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
