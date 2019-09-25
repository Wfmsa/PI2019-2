package pkginterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

public class CriarCompra extends javax.swing.JInternalFrame {
    
    

    public CriarCompra() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arquivodiretorio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        arquivodiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivodiretorioActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Selecione o Arquivo de Vendas");

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Concluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arquivodiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arquivodiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
File f;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);


        File f = fc.getSelectedFile();
        fc.getSelectedFile();
        f = fc.getSelectedFile();

        /*String sql = "INSERT INTO compra";
      
         String linha = lerArq.readLine(); // lê a primeira linha
         // a variável "linha" recebe o valor "null" quando o processo
         // de repetição atingir o final do arquivo texto
         while (linha != null) {
         System.out.printf("%s\n", linha);
 
         linha = lerArq.readLine(); // lê da segunda até a última linha
        
         }
          
 
         ler.close();
         } catch (IOException e) {
         System.err.printf("Erro na abertura do arquivo: %s.\n",
         e.getMessage());
         }   catch (SQLException ex) {
         Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
         Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        arquivodiretorio.setText(f.getPath());
        try {
            Connection connection = Conexao.getInstance().getConnection();
            String sql = "INSERT INTO COMPRA VALUES ()";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String linha = br.readLine();

            }
            /*for (int i = 0; i < lista.size(); i++){
                System.out.println(lista.get(i));
            }*/

        } catch (IOException ex) {
            System.out.println("Erro ao acessar arquivo!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            FileReader ler = new FileReader(f);
            BufferedReader lerArq = new BufferedReader(ler);
            Connection connection = Conexao.getInstance().getConnection();
            String sql = "insert into compra(idcompra, data, dia_da_semana, Produtos) values (?,?,?,?)";
            connection.setAutoCommit(false);
            PreparedStatement psmt = connection.prepareStatement(sql);
        //Caso o arquivo seja muito grande, voce pode usar um contador para persistir aos poucos.
            //int contador = 0;
            Iterable<String> linhas = null;
            for (String linha : linhas) {
                String[] colunas = linha.split(";");
                psmt.setString(1, colunas[0]);
                psmt.setString(2, colunas[1]);
                psmt.setString(3, colunas[2]);
                psmt.setString(4, colunas[3]);
                psmt.addBatch();
            //contador++;
                //caso resolva usar o contador, coloque o if abaixo.
           /* if(contador == 1000) {
                 psmt.executeBatch();
                 connection.commit();                
                 contador = 0;
                 }*/
            }
            psmt.executeBatch();
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CriarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void arquivodiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivodiretorioActionPerformed

    }//GEN-LAST:event_arquivodiretorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arquivodiretorio;
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
