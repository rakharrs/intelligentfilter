package com.etu1999.intelligentfilter.assets;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.*;
import com.etu1999.ambovombe.mapping.annotation.misc.PrimaryKey;
import com.etu1999.ambovombe.mapping.fk.ForeignType;
@UnitSource("db")
public class Produit extends DAO {
    @PrimaryKey(prefix = "PRD", sequence = "seq_produit", length = 8)
    @Column("id_produit")
    @Id
    private String idProduit;
    @Column
    private String libelle;
    @ForeignKey(mappedBy = "id_categorie", foreignType = ForeignType.ManyToOne)
    private Categorie categorie;
    @Column
    private Double prix;    
    @Column
    private Integer qualite;

    public String getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public Integer getQualite() {
        return qualite;
    }
    public void setQualite(Integer qualite) {
        this.qualite = qualite;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}
