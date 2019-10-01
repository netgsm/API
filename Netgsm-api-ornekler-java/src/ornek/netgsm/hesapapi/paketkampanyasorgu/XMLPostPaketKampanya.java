package ornek.netgsm.hesapapi.paketkampanyasorgu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostPaketKampanya {
    /**
     * NETGSM
     * HTTP Post ile Paket Kampanya Sorgulsma
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Kampanya ve paket
             * sorgulama için gerekli
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
                    " <stip>1</stip>"+
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
            System.out.println("Paket Kampanya Bilgisi = " + sonuc);

            // alınan örnek cevap
            // 1000 | Adet OTP Sms | <BR>1000 | Adet | SMS<BR>75000 | Sesli Mesaj | <BR>

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
