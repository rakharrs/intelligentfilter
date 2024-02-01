package com.etu1999.intelligentfilter.controller;

import com.etu1999.intelligentfilter.assets.Categorie;
import com.etu1999.intelligentfilter.assets.Produit;
import com.etu1999.intelligentfilter.views.ProduitDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        Produit produit = new Produit();
        try{
            con = produit.createConnection();

            List<Categorie> categories = new Categorie().findAll(con);

            req.setAttribute("categories", categories);
            List<ProduitDetails> produitDetails = new ProduitDetails().findAll(con);
            System.out.println(produitDetails);
            req.setAttribute("produitDetails", produitDetails);

            RequestDispatcher rd = req.getRequestDispatcher("crud/insertion-produit.jsp");
            rd.forward(req, resp);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        Produit produit = new Produit();
        String libelle = req.getParameter("libelle");
        String id_categorie = req.getParameter("id_categorie");
        String prix = req.getParameter("prix");
        String qualite = req.getParameter("qualite");
        try{
            con = produit.createConnection();

            produit.setIdProduit(produit.buildPrimaryKey(con));
            produit.setLibelle(libelle);
            produit.setCategorie(new Categorie(id_categorie));
            produit.setQualite(Integer.parseInt(qualite));
            produit.setPrix(Double.parseDouble(prix));

            produit.save(con);
            con.commit();

            resp.sendRedirect("produit");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
