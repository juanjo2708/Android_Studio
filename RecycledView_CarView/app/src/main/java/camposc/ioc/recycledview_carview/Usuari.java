package camposc.ioc.recycledview_carview;

public class Usuari {

    private String nom;
    private int edat;
    private int foto;


    public Usuari(String nom, int edat, int foto) {
        this.nom = nom;
        this.edat = edat;
        this.foto = foto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
