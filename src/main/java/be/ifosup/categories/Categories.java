package be.ifosup.categories;

public class Categories {

    // Attributs
    private Long catId;
    private String catNom;

    //Constructeurs
    public Categories(Long id, String catNom) {
        this.catId = id;
        this.catNom = catNom;
    }

    public Categories(String catNom) {
        this.catNom = catNom;
    }

    // Getter / setter
    public Long getId() {
        return catId;
    }

    public void setId(Long id) {
        this.catId = id;
    }

    public String getcatNom() {
        return catNom;
    }

    public void setcatNom(String catNom) {
        this.catNom = catNom;
    }
}
