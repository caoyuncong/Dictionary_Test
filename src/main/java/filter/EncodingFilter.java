package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/27.
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private static final String ENCODING = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
