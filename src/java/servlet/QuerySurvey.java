/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kukuh
 */
@PersistenceContext(name = "persistence/LogicalName", unitName = "TugasJPAPU")
@WebServlet(name = "QuerySurvey", urlPatterns = {"/QuerySurvey"})
public class QuerySurvey extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Resource
 private javax.transaction.UserTransaction utx;
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 PrintWriter out = response.getWriter();
 try {
 String nama = "";
 if (request.getParameter("nama") != null) {
 nama = request.getParameter("nama");
 }
 
  String email = "";
 if (request.getParameter("email") != null) {
 nama = request.getParameter("email");
 }
  String alamat = "";
 if (request.getParameter("alamat") != null) {
 alamat = request.getParameter("alamat");
 }
  String kota = "";
 if (request.getParameter("kota") != null) {
 kota = request.getParameter("kota");
 }
  String negBag = "";
 if (request.getParameter("negBag") != null) {
 negBag = request.getParameter("negBag");
 }
  String pos = "";
 if (request.getParameter("pos") != null) {
 pos = request.getParameter("pos");
 }
  String tgl = "";
 if (request.getParameter("tgl") != null) {
 tgl = request.getParameter("tgl");
 }
  String radio = "";
 if (request.getParameter("radio") != null) {
 radio = request.getParameter("radio");
 }
   String rekomendasi = "";
 if (request.getParameter("rekomendasi") != null) {
 rekomendasi = request.getParameter("rekomendasi");
 }
  String how = "";
 if (request.getParameter("how") != null) {
 how = request.getParameter("how");
 }
  String komentar = "";
 if (request.getParameter("komentar") != null) {
 komentar = request.getParameter("komentar");
 }
 
 

 Context ctx = (Context) new InitialContext().lookup("java:comp/env");
 utx.begin();
 EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
 Query q = em.createNativeQuery("INSERT s INTO Survey s VALUES(?1,?2,?3,?3,?4,?5,?6,?7,?8,?9,?10,?11");
//Query q = em.createNativeQuery("SELECT ROUND(AVG(Emp.SALARY),0) FROM Dept, Emp WHERE Emp.DEPT_DID = Dept.DID and Dept.Dname =?1");
 q.setParameter(1, nama);
 q.setParameter(2, email);
 q.setParameter(3, alamat);
 q.setParameter(4, kota);
 q.setParameter(5, negBag);
 q.setParameter(6, pos);
 q.setParameter(7, tgl);
 q.setParameter(8, radio);
 q.setParameter(9, how);
 q.setParameter(10, rekomendasi);
 q.setParameter(11, komentar);
 q.executeUpdate();
// List r = q.getResultList();
 utx.commit();
 out.println("Berhasil Input");
 } catch (Exception e) {
 e.printStackTrace();
 }
 }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
