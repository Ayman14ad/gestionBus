package sn.sentrans.dao;

import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser {
    private DB db = new DB();
    @Override
    public int add(User user) {
        String sql = "INSERT INTO user VALUES(NULL, ?, ?, ?, ?)";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,user.getNom());
            db.getPstm().setString(2,user.getPrenom());
            db.getPstm().setString(3,user.getEmail());
            db.getPstm().setString(4,user.getPassword());


            ok = db.executMaj();
            db.closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE user SET prenom = ?, nom = ?, email = ?, password = ? WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,user.getNom());
            db.getPstm().setString(2,user.getPrenom());
            db.getPstm().setString(3,user.getEmail());
            db.getPstm().setString(4,user.getPassword());
            db.getPstm().setInt(5,user.getId());
            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idu) {
        String sql = "DELETE FROM user  WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);

            db.getPstm().setInt(1,idu);

            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;     }

    @Override
    public List<User> getAll() {
        String sql="SELECT * FROM user";

        List<User> userList = new ArrayList<>();
        try {
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));


                //ajout dans la liste des typelocalite
                userList.add(user);
            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return userList;    }

    @Override
    public User get(String id) {
        String sql="SELECT * FROM user WHERE id = ?";

        User user = null;
        try {
            db.init(sql);
            db.getPstm().setString(1,id);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                 user= new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));


            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;    }

    @Override
    public User getLogin(String email, String password) {
        User user = null;
        String sql ="SELECT * FROM user WHERE email= ? AND password = ?";
        try {
            db.init(sql);
            db.getPstm().setString(1,email);
            db.getPstm().setString(2,password);
            ResultSet rs =db.executeSelect();
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));


            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return user;
    }
}
