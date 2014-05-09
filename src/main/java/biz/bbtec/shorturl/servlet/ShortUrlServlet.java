package biz.bbtec.shorturl.servlet;

import biz.bbtec.shorturl.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dean on 2014/5/8.
 */
public class ShortUrlServlet extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(ShortUrlServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer url = req.getRequestURL();
        int index = url.lastIndexOf("/");
        String shortCode = url.substring(index + 1);
        logger.info("shortCode :{}", shortCode);
        if (shortCode == null || shortCode.isEmpty() || shortCode.equals("shorturl")) {
            return;
        }
        String longUrl = ShortUrlService.getInstance().getLongUrl(shortCode);
        logger.info("longUrl :{}", longUrl);
        if (longUrl == null || longUrl.isEmpty()) {
            return;
        }
        resp.sendRedirect(longUrl);
    }
}
