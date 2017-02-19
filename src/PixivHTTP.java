import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by christopherbyrne on 04/08/2016.
 */
public class PixivHTTP extends Thread {

    protected String publicurl = "https://oauth.secure.pixiv.net/auth/token";
    protected HttpsURLConnection connection = null;
    protected String urlParameters;

    public PixivHTTP(String params) {
        urlParameters = params;
    }
    public void run(){
        try {
        System.out.println("Running thread number: " + Thread.currentThread().getId());
            System.out.println("params: " + urlParameters);
        URL url = new URL(publicurl);
        connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent", "PixivIOSApp/5.1.1");
            connection.setRequestProperty("Referer", "http://spapi.pixiv.net/");

        connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
        //connection.setRequestProperty("Content-Language", "en-US");
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        OutputStream dos = connection.getOutputStream();
        dos.write(urlParameters.getBytes("UTF-8"));
        dos.close();
            InputStream is;
        if(connection.getResponseCode() == 200) {
            is = connection.getInputStream();
        }
            else{
            is = connection.getErrorStream();
        }
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;


            while((line = buf.readLine()) != null )
            {
                response.append(line);
                response.append('\r');
            }

        buf.close();
        System.out.println("Response: " + response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
