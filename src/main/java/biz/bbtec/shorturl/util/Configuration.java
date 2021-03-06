package biz.bbtec.shorturl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2014/4/29.
 */
public class Configuration {

    public static String URL_NCWS;

    static {
        InputStream in = null;
        Properties properties = new Properties();
        try {
            in = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(in);
            URL_NCWS = properties.getProperty("URL_NCWS");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
