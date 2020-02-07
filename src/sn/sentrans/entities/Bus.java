package sn.sentrans.entities;

public class Bus {

    private int id;
    private int nbplace;
    private String matricule;
    private Localite localite;

    public Bus(){

    }

    //les constructeurs servent à créer les objets de classe
    public Bus(int id, int nbplace, String matricule, Localite localite){
        this.id = id;
        this.nbplace = nbplace;
        this.matricule = matricule;
        this.localite = localite;
    }

    //les getters permettent de récuperer les attributs déclarer en local
    public int getId() {
        return id;
    }

    //les setters permettent de modifier les valeurs des attributs
    public void setId(int id) {
        this.id = id;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }
}
