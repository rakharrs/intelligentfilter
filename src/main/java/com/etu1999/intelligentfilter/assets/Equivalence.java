package com.etu1999.intelligentfilter.assets;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.ambovombe.mapping.annotation.data.Column;
import com.etu1999.ambovombe.mapping.annotation.data.ForeignKey;
import com.etu1999.ambovombe.mapping.annotation.data.Id;
import com.etu1999.ambovombe.mapping.annotation.data.UnitSource;
import com.etu1999.ambovombe.mapping.fk.ForeignType;
@UnitSource("db")
public class Equivalence extends DAO {
    @Id
    @Column("id_equivalence")
    String idEquivalence;
    @ForeignKey(mappedBy = "id_syntaxe", foreignType = ForeignType.ManyToOne)
    Syntaxe syntaxe;
    @ForeignKey(mappedBy = "id_column", foreignType = ForeignType.ManyToOne)
    Columns column;
    @Column
    String equivalence;

    public String getIdEquivalence() {
        return idEquivalence;
    }
    public void setIdEquivalence(String idEquivalence) {
        this.idEquivalence = idEquivalence;
    }
    public Syntaxe getSyntaxe() {
        return syntaxe;
    }
    public void setSyntaxe(Syntaxe syntaxe) {
        this.syntaxe = syntaxe;
    }
    public Columns getColumn() {
        return column;
    }
    public void setColumn(Columns column) {
        this.column = column;
    }
    public String getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(String equivalence) {
        this.equivalence = equivalence;
    }
    
    
}
