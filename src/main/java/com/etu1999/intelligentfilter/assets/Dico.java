package com.etu1999.intelligentfilter.assets;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.ForeignKey;
import com.etu1999.ambovombe.mapping.annotation.data.Id;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;
import com.etu1999.ambovombe.mapping.fk.ForeignType;

import java.sql.Connection;
import java.util.List;
@UnitSource("db")
public class Dico extends DAO {
    @Column("id_dico") @Id
    Integer idDico;
    @ForeignKey(mappedBy = "id_column", foreignType = ForeignType.ManyToOne, initialize = true)
    Columns column;
    @Column
    String annexe;
    public Integer getIdDico() {
        return idDico;
    }
    public void setIdDico(Integer idDico) {
        this.idDico = idDico;
    }
    public Columns getColumn() {
        return column;
    }
    public void setColumn(Columns column) {
        this.column = column;
    }
    public String getAnnexe() {
        return annexe;
    }
    public void setAnnexe(String annexe) {
        this.annexe = annexe;
    }
    
    public String getRoot(String str, Connection con) throws Exception{
        List<Dico> lst = new Dico().findWhere(con, "annexe LIKE '"+str+"'");
        if(lst.size() == 0)
            return str;
        else{
            return lst.get(0).getColumn().getNom();
        }
    }
}
