package ornek.netgsm.hesapapi.kredisorgulama;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostKredi {
    /**
     * NETGSM
     * HTTP Post ile Hesap Kredisi Sorgulama
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Hesap Kredisi Sorgulama
             * için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/balance/list/xml");

            URLConnection uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection) uc;
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            OutputStream out = connection.getOutputStream();
            OutputStreamWriter wout = new OutputStreamWriter(out, "UTF-8");
            wout.write("<?xml version='1.0' encoding='iso-8859-9'?> "+
                    "<mainbody> "+
                    "<header>  "+
                    "<usercode>" + username + "</usercode> "+
                    "<password>" + password + "</password>  "+
                    " <stip>2</stip>"+
                    "</header>  "+
                    "</mainbody>");
            wout.flush();
            out.close();
            InputStream in = connection.getInputStream();
            int c;
            String sonuc = "";
            while ((c = in.read()) != -1){
                sonuc += (char)c;
            }
            in.close();
            out.close();
            connection.disconnect();

            // servisten gelen raporu görüntüleme
            System.out.println("Kredi Bilgisi = " + sonuc);

            // alınan örnek cevap
            // 00 39,000

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
