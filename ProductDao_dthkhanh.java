/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product_dthkhanh;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ProductDao_dthkhanh {

    public List<Product_dthkhanh> getAllUsers() throws SQLException {
        List<Product_dthkhanh> product = new ArrayList<Product_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM Product_DTHKHANH";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product_dthkhanh pro = new Product_dthkhanh();
                pro.setIdProduct(rs.getInt("IDPRODUCT"));
                pro.setNameProduct(rs.getString("NAMEPRODUCT"));
                pro.setPrice(rs.getString("PRICE"));
                pro.setQuantity(rs.getInt("QUANTITY"));
                
                pro.setDescription(rs.getString("CATEGORY"));
                pro.setDescription(rs.getString("DESCRIPTION"));
                product.add(pro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

    public void addPro(Product_dthkhanh pro) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO Product_DTHKHANH (NAMEPRODUCT, PRICE,QUANTITY, CATEGORY,DESCRIPTION ) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pro.getNameProduct());
            preparedStatement.setString(2, pro.getPrice());
            preparedStatement.setInt(3, pro.getQuantity());
            preparedStatement.setString(4, pro.getCategory());
            preparedStatement.setString(5, pro.getDescription());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePro(Product_dthkhanh pro) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "UPDATE Product_DTHKHANH SET NAMEPRODUCT = ?,PRICE = ?,QUANTITY = ?, CATEGORY = ?,DESCRIPTION = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pro.getNameProduct());
            preparedStatement.setString(2, pro.getPrice());
            preparedStatement.setInt(3, pro.getQuantity());
            preparedStatement.setString(4, pro.getCategory());
            preparedStatement.setString(5, pro.getDescription());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePro(int id) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "delete from Product_DTHKHANH where IDPRODUCT = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
    
}
