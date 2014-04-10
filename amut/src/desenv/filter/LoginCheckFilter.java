package desenv.filter;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import desenv.modelo.entidade.Usuario;
 

 
/**
 * Servlet Filter implementation class UserCheckFilter
 */
public class LoginCheckFilter extends AbstractFilter implements Filter {
    private static List<String> allowedURIs;
 
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        if(allowedURIs == null){
            allowedURIs = new ArrayList<String>();
            allowedURIs.add(fConfig.getInitParameter("loginActionURI"));
            allowedURIs.add("/amut/javax.faces.resource/main.css.html");
            allowedURIs.add("/amut/javax.faces.resource/sistema.css.html");
            allowedURIs.add("/amut/javax.faces.resource/jquery/jquery-plugins.js.html");
            allowedURIs.add("/amut/javax.faces.resource/images/default.png.html");
            allowedURIs.add("/amut/javax.faces.resource/theme.css.html");
            allowedURIs.add("/amut/javax.faces.resource/primefaces.js.html");
            allowedURIs.add("/amut/javax.faces.resource/primefaces.css.html");
            allowedURIs.add("/amut/javax.faces.resource/jquery/jquery.js.html");
            allowedURIs.add("/amut/javax.faces.resource/messages/messages.png.html");
            allowedURIs.add("/amut/javax.faces.resource/images/ui-icons_2e83ff_256x240.png.html");
            allowedURIs.add("/amut/javax.faces.resource/images/ui-icons_38667f_256x240.png.html");
        }
    }
 
    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }
 
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
        if (session.isNew()) {
            doLogin(request, response, req);
            return;
        }
 
        Usuario user = (Usuario) session.getAttribute("user");
 
        if (user == null && !allowedURIs.contains(req.getRequestURI())) {
            System.out.println(req.getRequestURI());
            doLogin(request, response, req);
            return;
        }
 
        chain.doFilter(request, response);
    }
}