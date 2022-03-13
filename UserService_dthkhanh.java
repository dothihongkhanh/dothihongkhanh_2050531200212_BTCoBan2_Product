/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_DoThiHongKhanh;

import Model.User_dthkhanh;
import java.sql.SQLException;
import java.util.List;
import Dao.UserDao_dthkhanh;

/**
 *
 * @author DELL
 */
public class UserService_dthkhanh {
    private UserDao_dthkhanh userDao;

    public UserService_dthkhanh() {
        userDao = new UserDao_dthkhanh();
    }

    public List<User_dthkhanh> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public void addUser(User_dthkhanh user) throws SQLException {
        userDao.addUser(user);
    }
   
    
}
