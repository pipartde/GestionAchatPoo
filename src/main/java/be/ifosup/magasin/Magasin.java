package be.ifosup.magasin;

public class Magasin {

    // Attributs
    private Long id;
    private String nomMag;

    // constructeur
    public Magasin(Long id, String nomMag) {
        this.id = id;
        this.nomMag = nomMag;
    }

    public Magasin(String nomMag) {
        this.nomMag = nomMag;
    }

    // Getter / setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMag() {
        return nomMag;
    }

    public void setNomMag(String nomMag) {
        this.nomMag = nomMag;
    }
}
