package at.ac.fhcampuswien.modal;

import at.ac.fhcampuswien.DB.DBConnection;
import at.ac.fhcampuswien.bean.LoginBean;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ErmKarte {
    public String showErmKarte(LoginBean loginBean) {
        String sqlResult = "Keine Karten vorhanden!";

        DBConnection dbConnection = DBConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        String sqlQuery;

        try {
            sqlQuery = "select * from ermäßigungskarten left join ladepersonal on ladepersonal.Kartennummer = ermäßigungskarten.Kartennummer where svnr=? and GebDat=?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, Integer.parseInt(loginBean.getSvnr()));
            preparedStatement.setString(2, loginBean.getBirthDate());
            System.out.println(preparedStatement);
            sqlResult = preparedStatement.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sqlResult;
    }

    public boolean reqErmKarte(LoginBean loginBean) {
        Boolean sqlResult = false;

        DBConnection dbConnection = DBConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        String sqlQuery;

        try {

            sqlQuery = "select * from ermäßigungskarten left join ladepersonal on ladepersonal.Kartennummer = ermäßigungskarten.Kartennummer where svnr=? and GebDat=?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, Integer.parseInt(loginBean.getSvnr()));
            preparedStatement.setString(2, loginBean.getBirthDate());
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return sqlResult;
    }
}
