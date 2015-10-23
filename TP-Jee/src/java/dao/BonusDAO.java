/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.BeanBonusDAO;
import beans.Bonus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azank
 */
public class BonusDAO extends DAO<BeanBonusDAO, String> {

    private static BonusDAO instanceCompteDAO;

    private BonusDAO() {
        super();
    }

    @Override
    public boolean create(BeanBonusDAO obj) {
        try {
            PreparedStatement st = null;
            st = connect.prepareStatement("insert into  bonus (ssn,bonus) values(?,?)");
            st.setString(1, obj.getSsn());
            //recuperer l'expetion quand obj.bonus = vide
            try {
                st.setDouble(2, Integer.parseInt(obj.getBonus()));
            } catch (Exception e) {
                st.setString(2, obj.getBonus());
            }

            st.executeUpdate();
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public BeanBonusDAO findById(String id) {
        BeanBonusDAO compte = null;
        try {
            PreparedStatement st = null;
            st = connect.prepareStatement("select * from bonus where id=?");
            st.setInt(1, Integer.parseInt(id));
            ResultSet resultSet =  st.executeQuery();
            while (resultSet.next()) {
                compte = new BeanBonusDAO();
                compte.setSsn(resultSet.getString("ssn"));
                compte.setBonus(resultSet.getString("bonus"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compte;
    }
    
    public List<BeanBonusDAO> findBySsn(String id) {
        List<BeanBonusDAO> lbonus = new ArrayList();
        try {
            PreparedStatement st = null;
            st = connect.prepareStatement("select * from bonus where ssn=?");
            st.setString(1, id);
            ResultSet resultSet =  st.executeQuery();
            while (resultSet.next()) {
                BeanBonusDAO compte = new BeanBonusDAO();
                compte.setSsn(resultSet.getString("ssn"));
                compte.setBonus(resultSet.getString("bonus"));
                lbonus.add(compte);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lbonus;
    }
    

    public static BonusDAO getInstance() {
        if (null == instanceCompteDAO) { // Premier appel 
            instanceCompteDAO = new BonusDAO();
        }
        return instanceCompteDAO;
    }

    @Override
    public boolean delete(BeanBonusDAO obj) {
        return false;
    }

    @Override
    public boolean update(BeanBonusDAO obj) {
        return false;
    }
}
