package be.ifosup.magasin;

public class Magasin {

    // Attributs
    private Long magId;
    private String magNom;

    // constructeur
    public Magasin(Long magId, String magNom) {
        this.magId = magId;
        this.magNom = magNom;
    }

    public Magasin(String magNom) {
        this.magNom = magNom;
    }

    // Getter / setter
    public Long getMagId() {
        return magId;
    }

    public void setMagId(Long magId) {
        this.magId = magId;
    }

    public String getMagNom() {
        return magNom;
    }

    public void setMagNom(String magNom) {
        this.magNom = magNom;
    }
}
