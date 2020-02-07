package sn.sentrans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    private Connection cnx;

    //pour les résultats des requetes de type SELECT
    private ResultSet rs;

    //pour les requetes preparees
    private PreparedStatement pstm;

    //pour les requetes de type MAJ(INSERT, UPDATE, DELETE)
    private int ok;

    private void getConnection(){
        String msqlurl = "jdbc:mysql://localhost:3306/gestionbus";
        String msqluser = "root";
        String msqlpassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(msqlurl, msqluser, msqlpassword);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void init(String sql){
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Exécution de la base
    public ResultSet executeSelect(){
        try {
            rs = pstm.executeQuery();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    //Pour les requetes de type MAJ
    public int executMaj(){
        try {
            ok = pstm.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public void closeConnection(){
        try {
            if(cnx != null)
                cnx.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm(){
        return pstm;
    }

}
