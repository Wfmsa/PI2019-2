/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexao {

    public static Conexao Conexao;

    public static Conexao getInstance(){

        if (Conexao == null){
            Conexao = new Conexao();
        }
        return Conexao;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return (Connection) DriverManager.getConnection("jdbc:mysql://fermatil.com.br:3306/fermatil_trabalho", "fermatil_root", "wfmsa123$%^");
    }
}