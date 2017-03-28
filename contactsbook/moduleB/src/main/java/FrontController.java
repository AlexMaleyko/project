import model.ContactDTO;
import service.ContactController;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Alexey on 24.03.2017.
 */
public class FrontController extends HttpServlet {

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userId, password;
        System.out.println(request.getParameter("deleteContact"));
        String[] selectedItems = request.getParameterValues("checkBoxGroup");
        for(String selectedItem : selectedItems){
            System.out.println(selectedItem);
        }

        userId=request.getParameter("userId");
        password=request.getParameter("password");
        boolean b=false;
        if(userId.equals(password)){
            b=true;
        }
        if(b){
            response.sendRedirect("success.jsp");
            return;
        }
        else{
            response.sendRedirect("login.jsp");
            return;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactController controller= new ContactController();
        List<ContactDTO> contacts =controller.getAllContactDTO();
        request.setAttribute("contacts",contacts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello,everybody!</h1>");*/
    }
}
