package biz.bbtec.shorturl.service;

import biz.bbtec.shorturl.util.HttpUtil;
import biz.bbtec.shorturl.util.MyUrlEncode;
import biz.bbtec.shorturl.util.NCWS_URL;
import com.bbtech.ncws.JSONFormatter;
import com.bbtech.ncws.JSONParser;
import com.bbtech.ncws.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dean on 2014/5/9.
 */
public class ShortUrlService {

    public static ShortUrlService getInstance() {
        return ShortUrlServiceSingletonHolder.instance;
    }

    private ShortUrlService() {
    }

    public String getLongUrl(String shortCode) {
        String result = null;
        try {
            String req = JSONFormatter.formatWeChatRawUrl(shortCode);
            String resp = HttpUtil.getHttpInstance().post(NCWS_URL.WECHAT_RAW_URL, req);
            JSONObject json = new JSONObject(resp);
            if ("OK".equals(json.getString("status"))) {
                String rawUrl = json.getString("rawUrl");
                result = MyUrlEncode.encodeUrl(rawUrl);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class ShortUrlServiceSingletonHolder {
        private static ShortUrlService instance = new ShortUrlService();
    }
}
