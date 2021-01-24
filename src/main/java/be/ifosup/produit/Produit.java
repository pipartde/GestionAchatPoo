package be.ifosup.produit;

public class Produit {
    // Attributs
    private Long id;
    private String proNom;
    private Long proCatId;
    private Long proMesId;
    private Double qtt;

    // constructeur
    public Produit(Long id, String proNom, Long proCatId, Long proMesId, Double qtt) {
        this.id = id;
        this.proNom = proNom;
        this.proCatId = proCatId;
        this.proMesId = proMesId;
        this.qtt = qtt;
    }

    public Produit(String proNom, Long proCatId, Long proMesId, Double qtt) {
        this.proNom = proNom;
        this.proCatId = proCatId;
        this.proMesId = proMesId;
        this.qtt = qtt;
    }

    // Getter / setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProCatId() {
        return proCatId;
    }

    public void setProCatId(Long proCatId) {
        this.proCatId = proCatId;
    }

    public Long getProMesId() {
        return proMesId;
    }

    public void setProMesId(Long proMesId) {
        this.proMesId = proMesId;
    }

    public String getproNom() {
        return proNom;
    }

    public void setprNom(String proNom) {
        this.proNom = proNom;
    }

    public Double getproQtt() {
        return qtt;
    }

    public void setQtt(Double qtt) {
        this.qtt = qtt;
    }
}

