package be.ifosup.produit;

public class Produit {
    // Attributs
    private Long id;
    private String proNom;

    // constructeur
    public Produit(Long id, String proNom) {
        this.id = id;
        this.proNom = proNom;
    }

    public Produit(String proNom) {
        this.proNom = proNom;
    }

    // Getter / setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getproNom() {
        return proNom;
    }

    public void setprNom(String proNom) {
        this.proNom = proNom;
    }
}

