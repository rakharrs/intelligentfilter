package com.etu1999.intelligentfilter.controller;

import com.etu1999.ambovombe.core.process.DAO;
import com.etu1999.intelligentfilter.traitement.StringTreatment;
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

@WebServlet("/d")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        ProduitDetails produitDetail = new ProduitDetails();
        try{
            con = produitDetail.createConnection();

            List<ProduitDetails> produitDetails = produitDetail.findAll(con);
            System.out.println(produitDetails);
            req.setAttribute("produitDetails", produitDetails);
            RequestDispatcher rd = req.getRequestDispatcher("d.jsp");
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
        String search = req.getParameter("search");
        Connection con = null;
        ProduitDetails produitDetail = new ProduitDetails();
        try{
            con = produitDetail.createConnection();

            //List<ProduitDetails> produitDetails = produitDetail.findAll(con);
            //System.out.println(produitDetails);
            StringTreatment treat = new StringTreatment();
            String query = treat.getSearchQuery(search, con);
            List<ProduitDetails> produitDetails = DAO.sqltoArray(con, query, produitDetail);
            System.out.println(query);
            req.setAttribute("produitDetails", produitDetails);
            RequestDispatcher rd = req.getRequestDispatcher("d.jsp");
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
}
