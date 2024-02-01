package com.etu1999.intelligentfilter.views;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.Id;
import com.etu1999.ambovombe.mapping.annotation.data.Table;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;

@UnitSource("db")
@Table( "v_details_produit")
public class ProduitDetails extends DAO {
    @Column("id_produit") @Id
    String idProduit;
    @Column
    String libelle;
    @Column
    String categorie;
    @Column
    Double prix;    
    @Column
    Integer qualite;
    @Column
    Double rapport;

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
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
    public Double getRapport() {
        return rapport;
    }
    public void setRapport(Double rapport) {
        this.rapport = rapport;
    }   
}
