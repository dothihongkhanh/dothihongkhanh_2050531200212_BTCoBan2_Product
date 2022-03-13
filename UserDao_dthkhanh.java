/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.User_dthkhanh;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class UserDao_dthkhanh {

    public List<User_dthkhanh> getAllUsers() throws SQLException {
        List<User_dthkhanh> users = new ArrayList<User_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM USER_DTHKHANH";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User_dthkhanh user = new User_dthkhanh();
                user.setUserName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setPhone(rs.getString("GENDER"));
                user.setPhone(rs.getString("PHONE"));
                user.setEmail(rs.getString("EMAIL"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public void addUser(User_dthkhanh user) throws SQLException {
        Connection con = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO USER_DTHKHANH (USERNAME, PASSWORD, GENDER, PHONE, EMAIL) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());

            int rs = pstmt.executeUpdate();
            System.out.println(rs);
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   

}
