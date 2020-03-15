/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
@WebServlet(urlPatterns = {"/UserModeTest"})
public class UserModeTest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        try(PrintWriter out = response.getWriter()){
            
            String mode = request.getParameter("mode");
            if(mode !=null){
                if (mode.equals("manager")){
                    showManagerModeContent(out);
                }
                else if(mode.equals("user")){
                showUserModeContent(out);
           
                }
                else {
                showUnknownUserModeContent(out);
          
                }
            }  else{
            showNomodeContent(out);
            }  
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
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

    private void showManagerModeContent(PrintWriter out) {
     out.println("<html>");
     out.println("<head>");
     out.println("<title>일반 사용자 모드 화면</title>");
     out.println("</head>");
     out.println("<body>");
     out.println("<h1>당신은 일반 사용자입니다.<h1>");
     out.println("</body>");
     out.println("</html>");
        
    }

    private void showUserModeContent(PrintWriter out) {
     out.println("<html>");
     out.println("<head>");
     out.println("<title>관리자 모드 화면</title>");
     out.println("</head>");
     out.println("<body>");
     out.println("<h1>당신은 관리자입니다.<h1>");
     out.println("</body>");
     out.println("</html>");
        
    }

    private void showUnknownUserModeContent(PrintWriter out) {
     out.println("<html>");
     out.println("<head>");
     out.println("<title> UnknownUserMode 모드 화면</title>");
     out.println("</head>");
     out.println("<body>");
     out.println("<h1>당신은 누굽니까? <h1>");
     out.println("</body>");
       out.println("</html>");
        
    }

    private void showNomodeContent(PrintWriter out) {
     out.println("<html>");
     out.println("<head>");
     out.println("<title>모드 없음 화면</title>");
     out.println("</head>");
     out.println("<body>");
     out.println("<h1>mode 파라미터가 없습니다.<h1>");
     out.println("<bold>사용법<bold>");
     out.println("http://localhost:8084/UserModeTest/?[mode|user]");
     out.println("</body>");
     out.println("<html>");
        
    }

    
}