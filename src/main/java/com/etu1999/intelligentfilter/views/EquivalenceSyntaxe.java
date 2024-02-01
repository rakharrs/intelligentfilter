package com.etu1999.intelligentfilter.views;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.Table;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;

@UnitSource("db")
@Table("v_equivalence_syntaxe")
public class EquivalenceSyntaxe extends DAO {
    @Column
    String nom;
    @Column
    String equivalence;
    @Column
    String libelle;
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(String equivalence) {
        this.equivalence = equivalence;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
