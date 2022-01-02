/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbotopik14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Cahya Robbi
 */
public class DbQuery {
        db k = new db();
        Connection c;
        
public Boolean insert(Data d,JTable table) throws SQLException{
        c = k.getConnect();
        String kueriInsert = "INSERT INTO member(id_member,nama,jenis,tahun) VALUES (?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(kueriInsert);
        ps.setString(1, d.getId());
        ps.setString(2, d.getNama());
        ps.setString(3, d.getJenis());
        ps.setString(4, d.getTahun());
        int rowAffected = ps.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(new Object[]{d.getId(),d.getNama(),d.getTahun(),d.getJenis()});
         ps.close();c.close();
        return rowAffected == 1;
    }

public Boolean delete(String id) throws SQLException{
        c = k.getConnect();
        String kueriInsert = "DELETE FROM member WHERE id_member = ?;";
        PreparedStatement ps = c.prepareStatement(kueriInsert);
        ps.setString(1, id);
        boolean rowAffected = ps.execute();
    
         ps.close();c.close();
        return rowAffected == true;
    }
public void selectMember(JTable table)throws SQLException {

        c = k.getConnect();
        String kueriSelectUser ="SELECT * FROM member";
        PreparedStatement ps = c.prepareStatement(kueriSelectUser);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String id = rs.getString("id_member");
            String nama = rs.getString("nama");
            String tahun = rs.getString("tahun");
            String jenis = rs.getString("jenis");
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(new Object[]{id,nama,tahun,jenis});
        }
    } 
}
