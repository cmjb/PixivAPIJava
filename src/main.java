import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by christopherbyrne on 02/08/2016.
 */
public class main {
    private static String appid = "bYGKuGVw91e0NMfPGp44euvGt59s";
    private static String appsec = "iHP3RmkgAmEGro0gn1x9ioawQE8WMfvLXDz3ZqxpK";
    private static String user = "";
    private static String pass = "";
    public static void main(String args[]){
        PixivHTTP obj= null;
        try {
            obj = new PixivHTTP("client_id=" +appid + "&client_secret=" + appsec
            + "&grant_type=password&username=" + user + "&password=" + pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        obj.start();
    }
}
