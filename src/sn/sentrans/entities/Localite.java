package sn.sentrans.entities;

public class Localite {

    private int id;
    private String nom;
    private double latitude;
    private double longitude;
    private TypeLocalite typeLocalite;
    private User user;

    public Localite() {
    }

    public Localite(int id, String nom, double latitude, double longitude, TypeLocalite typeLocalite, User user) {
        this.id = id;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.typeLocalite = typeLocalite;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public TypeLocalite getTypeLocalite() {
        return typeLocalite;
    }

    public void setTypeLocalite(TypeLocalite typeLocalite) {
        this.typeLocalite = typeLocalite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
