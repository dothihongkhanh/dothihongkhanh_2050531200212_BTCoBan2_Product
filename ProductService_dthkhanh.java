/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_DoThiHongKhanh;

import Dao.ProductDao_dthkhanh;
import Model.Product_dthkhanh;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ProductService_dthkhanh {
    private ProductDao_dthkhanh proDao;

    public ProductService_dthkhanh() {
        proDao = new ProductDao_dthkhanh();
    }

    public List<Product_dthkhanh> getAllUsers() throws SQLException {
        return proDao.getAllUsers();
    }

    public void addPro(Product_dthkhanh pro) throws SQLException {
        proDao.addPro(pro);
    }

    public void deletePro(int id) throws SQLException {
        proDao.deletePro(id);
    }
}
