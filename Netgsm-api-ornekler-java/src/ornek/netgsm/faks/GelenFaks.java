package ornek.netgsm.faks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GelenFaks {
    /**
     * NETGSM
     * Gelen Faks
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Gelen Faks için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // mesajın gönderilmeye başlanacağı tarih
            String startDate = "0209201920190000";

            // mesaj gönderimi bitiş tarihi
            String stopDate = "020920190000";

            // tür
            int type = 1;

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/fax/receive");

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
                    "<startdate>" + startDate + "</startdate> "+
                    "<stopdate>" + stopDate + "</stopdate> "+
                    "<type>" + type + "</type> "+
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

            // istek sonrası oluşan raporu görüntüleme
            System.out.println("rapor durum = " + sonuc);

            // alınan örnek cevap
            // 8xxxxxxxxx | 03.09.2019 16:54 | | SUCCESS | faks indirme linki

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
