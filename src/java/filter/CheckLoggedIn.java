package filter;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managedbean.StaffLoginBean;
import managedbean.StudentLoginBean;

@WebFilter(filterName = "CheckLoggedIn", urlPatterns =
{
    "/protected/*"
})
public class CheckLoggedIn implements Filter
{


    private FilterConfig filterConfig = null;
    
    @Inject
    StaffLoginBean staff;
    
    @Inject
    StudentLoginBean student;

    public CheckLoggedIn()
    {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String homeURI = request.getContextPath() + "/faces/index.xhtml";
        boolean loggedIn = staff.isLoginOK();
        boolean stuLoggedIn = student.isLoginOK();


        if (loggedIn || stuLoggedIn)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(homeURI);
        }
    }

    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);
    }

}