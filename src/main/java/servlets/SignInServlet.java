package servlets;

import accounts.AccountService;

import javax.servlet.http.HttpServlet;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612172013
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet (AccountService accountService) {
        this.accountService = accountService;
    }



}
