package be.ifosup.mesure;

public class Mesure {

    // Attributs

    private Long mesId;
    private String mesNom;

    // Constructeurs

    public Mesure (Long mesId, String mesNom) {
        this.mesId = mesId;
        this.mesNom = mesNom;
    }

    public Mesure (Long mesId) {
        this.mesId = mesId;
    }

    // Getter

    public Long getMesId() {
        return mesId;
    }

    public String getMesNom() {
        return mesNom;
    }

    // Setter

    public void setMesId(Long mesId) {
        this.mesId = mesId;
    }

    public void setMesNom(String mesNom) {
        this.mesNom = mesNom;
    }
}
