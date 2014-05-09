import biz.bbtec.shorturl.util.MyUrlEncode;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dean on 2014/5/9.
 */
public class MyUrlEncodeTest {
    private final static Logger logger = LoggerFactory.getLogger(MyUrlEncodeTest.class);

    @Test
    public void testEncode() {
        String url = "http://wx.bbtec.biz/resources/map.html?deviceid=460027684718728&name=Sunny&time=2014-01-12 13:04:14&coordinate=30.30542,120.100815,71.0,1162.0&offset=30.303160000000002,120.105622&address=中国浙江省杭州市拱墅区古墩路丰潭路458号-476号 邮政编码: 310000";

        String real = "http://wx.bbtec.biz/resources/map.html?deviceid=460027684718728&name=Sunny&time=2014-01-12%2013:04:14&coordinate=30.30542,120.100815,71.0,1162.0&offset=30.303160000000002,120.105622&address=%E4%B8%AD%E5%9B%BD%E6%B5%99%E6%B1%9F%E7%9C%81%E6%9D%AD%E5%B7%9E%E5%B8%82%E6%8B%B1%E5%A2%85%E5%8C%BA%E5%8F%A4%E5%A2%A9%E8%B7%AF%E4%B8%B0%E6%BD%AD%E8%B7%AF458%E5%8F%B7-476%E5%8F%B7%20%E9%82%AE%E6%94%BF%E7%BC%96%E7%A0%81:%20310000";
        String urlParse = MyUrlEncode.encodeUrl(url);
        Assert.assertEquals(urlParse, real);

    }
}
