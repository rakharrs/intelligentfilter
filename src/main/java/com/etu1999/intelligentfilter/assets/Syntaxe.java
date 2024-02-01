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
public class Syntaxe extends DAO {
    @PrimaryKey(sequence = "seq_syntaxe", prefix = "OP", length = 7)
    @Id
    @Column("id_syntaxe")
    String idSyntaxe;
    @Column
    String libelle;
    public String getIdSyntaxe() {
        return idSyntaxe;
    }
    public void setIdSyntaxe(String idSyntaxe) {
        this.idSyntaxe = idSyntaxe;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public List<String> getListLibelle(Connection con) throws Exception{
        ArrayList<String> lst = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement("SELECT libelle FROM syntaxe");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            lst.add(rs.getString(1));
        }
        return lst;
    }
    
}
