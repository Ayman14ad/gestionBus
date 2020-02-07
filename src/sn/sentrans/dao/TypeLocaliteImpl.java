package sn.sentrans.dao;

import sn.sentrans.entities.TypeLocalite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeLocaliteImpl implements ITypeLocalite  {
    private DB db =new DB();
    @Override
    public int add(TypeLocalite typeLocalite) {
        String sql = "INSERT INTO typelocalite VALUES(NULL, ?, ?)";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,typeLocalite.getNom());
            db.getPstm().setInt(2,typeLocalite.getIdT());


            ok = db.executMaj();
            db.closeConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(TypeLocalite typeLocalite) {
        String sql = "UPDATE typelocalite SET nom = ? WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);
            db.getPstm().setString(1,typeLocalite.getNom());



            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idt) {
        String sql = "DELETE FROM typelocalite  WHERE id = ?";
        int ok = 0;
        try {
            db.init(sql);

            db.getPstm().setInt(1,idt);

            ok = db.executMaj();
            db.closeConnection();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;    }

    @Override
    public List<TypeLocalite> getAll() {
        String sql="SELECT * FROM typelocalite";

        List<TypeLocalite> typeLocaliteList = new ArrayList<>();
        try {
            db.init(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                TypeLocalite typeLocalite = new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(1));
                typeLocalite.setNom(rs.getString(2));

                //ajout dans la liste des typelocalite
                typeLocaliteList.add(typeLocalite);
            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return typeLocaliteList;    }

    @Override
    public TypeLocalite get(int id) {
        String sql="SELECT * FROM typelocalite WHERE nom = ?";

        TypeLocalite typeLocalite = null;
        try {
            db.init(sql);
            db.getPstm().setInt(1,id);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                typeLocalite = new TypeLocalite();
                typeLocalite.setIdT(rs.getInt(1));
                typeLocalite.setNom(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return typeLocalite;    }
}
