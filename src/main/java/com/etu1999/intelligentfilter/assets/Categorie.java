package com.etu1999.intelligentfilter.assets;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.Id;
import com.etu1999.ambovombe.mapping.annotation.data.Table;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;
import com.etu1999.ambovombe.mapping.annotation.misc.PrimaryKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@UnitSource("db")
@Table
public class Categorie extends DAO {
    @PrimaryKey(prefix = "CAT", sequence = "seq_categorie", length = 8)
    @Column("id_categorie") @Id
    private String idCategorir;
    @Column
    private String nom;
    
    public String getIdCategorir() {
        return idCategorir;
    }
    public void setIdCategorir(String idCategorir) {
        this.idCategorir = idCategorir;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie(String id){
        setIdCategorir(id);
    }

    public Categorie(){}
    
    public List<String> getListNom(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT nom FROM categorie");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1).toLowerCase());
        }
        return lst;
    }
}
