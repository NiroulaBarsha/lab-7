
package ca.sait.lab7.servlets;

import ca.sait.lab7.models.User;
import ca.sait.lab7.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Barsha
 */
public class UserServlet extends HttpServlet {

    

@Override
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
UserService service = new UserService();
try{
List<User> users=service.getAll();
request.setAttribute("users",users);


this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
}catch(Exception ex){
    
    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE,null,ex);
}
}
@Override
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
	
}

}
