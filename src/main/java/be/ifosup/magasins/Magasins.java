package be.ifosup.magasins;

public class Magasins {

    // Attributs
    private Long id;
    private String type;
    private String categorie;

    // constructeur
    public Magasins(Long id, String type, String categorie) {
        this.id = id;
        this.type = type;
        this.categorie = categorie;
    }

    public Magasins(String type, String categorie) {
        this.type = type;
        this.categorie = categorie;
    }

    // Getter / setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
