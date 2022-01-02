/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbotopik14;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Cahya Robbi
 */
public class db {
    private final MysqlDataSource data = new MysqlDataSource();
     private final String DB_URL = "jdbc:mysql://localhost:3306/TugasTopik14?serverTimezone=Asia/Jakarta";
     private final String DB_USERNAME = "root";
     private final String DB_PASSWORD = "";  
   
    public Connection getConnect() throws SQLException{
        
        data.setUrl(DB_URL);
        data.setUser(DB_USERNAME);
        data.setPassword(DB_PASSWORD);
        Connection cn = data.getConnection();
        return cn;
    
    } 
}
