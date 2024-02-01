package com.etu1999.intelligentfilter.assets;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.Id;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;
import com.etu1999.ambovombe.mapping.annotation.misc.PrimaryKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@UnitSource("db")
public class Columns extends DAO {
    @PrimaryKey(sequence = "seq_column", prefix = "COL", length = 7)
    @Id
    @Column("id_column")
    String idColumn;
    @Column
    String nom;
    public String getIdColumn() {
        return idColumn;
    }
    public void setIdColumn(String idColumn) {
        this.idColumn = idColumn;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<String> getListNom(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT nom FROM columns");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1));
        }
        return lst;
    }
}
