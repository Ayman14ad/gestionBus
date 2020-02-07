package sn.sentrans.dao;

import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;
import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocaliteImpl implements ILocalite {

    private DB db = new DB();
    @Override
    public int add(Localite localite) {
        String sql = "INSERT INTO localite VALUES(NULL, ?, ?, ?,?)";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,localite.getNom());
            db.getPstm().setDouble(2,localite.getLatitude());
            db.getPstm().setDouble(3,localite.getLongitude());
            db.getPstm().setInt(4,localite.getId());


            ok = db.executMaj();
            db.closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Localite localite) {
        String sql = "UPDATE localite SET nom = ?, latitude = ?,longitude = ?,typelocalite = ?,user = ? WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,localite.getNom());
            db.getPstm().setDouble(2,localite.getLatitude());
            db.getPstm().setDouble(3,localite.getLongitude());
            db.getPstm().setInt(4,localite.getTypeLocalite().getIdT());
            db.getPstm().setInt(5,localite.getUser().getId());


            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idl) {
        String sql = "DELETE FROM localite  WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);

            db.getPstm().setInt(1,idl);

            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Localite> getAll() {
        String sql="SELECT * FROM localite";

        List<Localite> localiteList = new ArrayList<>();
        try {
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                Localite localite = new Localite();
                localite.setId(rs.getInt(1));
                localite.setNom(rs.getString(2));
                localite.setLatitude(rs.getDouble(3));
                localite.setLongitude(rs.getDouble(4));
                //Gestion de  typelocalite
                TypeLocalite typeLocalite=new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(5));
                localite.setTypeLocalite(typeLocalite);
                //Gestion de  USER
                User user=new User();
                user.setId(rs.getInt(6));
                localite.setUser(user);
                //ajout dans la liste des localite
                localiteList.add(localite);
            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return localiteList;
    }

    @Override
    public Localite get(int id) {
        String sql="SELECT * FROM localite WHERE id = ?";

        Localite localite = null;
        try {
            db.init(sql);
            db.getPstm().setInt(1,id);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                localite = new Localite();
                localite.setId(rs.getInt(1));
                localite.setNom(rs.getString(2));
                localite.setLatitude(rs.getDouble(3));
                localite.setLongitude(rs.getDouble(4));

                //Gestion de  typelocalite
                TypeLocalite typeLocalite=new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(5));
                localite.setTypeLocalite(typeLocalite);

                //Gestion de  USER
                User user=new User();
                user.setId(rs.getInt(6));
                localite.setUser(user);

            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return localite;
    }
}
