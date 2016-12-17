package servlets;

import accounts.AccountService;

import javax.servlet.http.HttpServlet;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612172013
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet (AccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
                               
    }

    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameters("login");
        String password = request.getParametr("password");
        
        
    }   
    
}
