package br.com.fiap.am.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.session.LoginSession;

public class LoginFiltro implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 
        LoginSession login = (LoginSession)((HttpServletRequest)request).getSession().getAttribute("loginSession");

        if (login == null || !login.isLogged()) {
          //String contextPath = ((HttpServletRequest) request).getContextPath();
          //((HttpServletResponse)response).sendRedirect(contextPath + "/index.xhtml");
        } else {
        	 String contextPath = ((HttpServletRequest) request).getContextPath();
        	((HttpServletResponse)response).sendRedirect(contextPath + "/index.xhtml");
             //chain.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
