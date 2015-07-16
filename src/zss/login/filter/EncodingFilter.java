package zss.login.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zss on 2015/7/16.
 */
@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    private String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.setCharacterEncoding(this.charset);
        resp.setCharacterEncoding(this.charset);
        System.out.println(req.getAttribute("msg"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.charset=config.getInitParameter("charset");

    }

}
