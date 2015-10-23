/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author azank
 */
public class UserDAO extends DAO<User, String> {

    private static UserDAO instanceCompteDAO;

    private UserDAO() {
        super();
    }

    @Override
    public boolean create(User obj) {
        try {
            PreparedStatement st = null;
            st = connect.prepareStatement("insert into  bddUser (firstname,birthname,login) values(?,?,?)");
            st.setString(1, obj.getFirstname());
            st.setString(2, obj.getBirthname());
            st.setString(3, obj.getLogin());

            st.executeUpdate();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findBySsn(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static UserDAO getInstance() {
        if (null == instanceCompteDAO) { // Premier appel 
            instanceCompteDAO = new UserDAO();
        }
        return instanceCompteDAO;
    }

}
