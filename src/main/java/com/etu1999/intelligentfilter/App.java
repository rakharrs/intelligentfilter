package com.etu1999.intelligentfilter;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.intelligentfilter.traitement.StringTreatment;
import com.google.gson.Gson;
import com.etu1999.intelligentfilter.assets.Dico;
import com.etu1999.intelligentfilter.views.ProduitDetails;

import java.sql.Connection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Dico dico = new Dico();

       // DbConnection dbConnection = new DbConnection();
        Connection dbConnection = null;
        Gson gson = new Gson();
        try{
            dbConnection = dico.createConnection();
            List<ProduitDetails> pds = new ProduitDetails().findAll(dbConnection);
            System.out.println(pds);
            String recherche = "cher  automobile moins";
            StringTreatment treat = new StringTreatment();
            String query = treat.getSearchQuery(recherche, dbConnection);
            System.out.println(query);
            ProduitDetails produitDetails = new ProduitDetails();
            List<ProduitDetails> lst = DAO.sqltoArray(dbConnection, query, produitDetails);
            for (ProduitDetails produitDetails2 : lst) {
                System.out.println(gson.toJson(produitDetails2));
                System.out.println("ok");
                //System.out.println(JsonUtility.encodeJson(produitDetails2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                dbConnection.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
