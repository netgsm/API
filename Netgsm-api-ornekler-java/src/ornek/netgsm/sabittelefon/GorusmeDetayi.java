package ornek.netgsm.sabittelefon;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GorusmeDetayi {
    /**
     * NETGSM
     * Sabit Telefon
     * Görüşme detayı sorgulama
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Görüşme detayı sorgulamak için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // tarih
            //String date = "260820191010";
            // tüm gün için
            String date = "";

            // arama yönü
            int direction = 1;

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/voice/report");

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
                    "<date>" + date + "</date> "+
                    "<direction>" + direction + "</direction> "+
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
            // 3XXXXXXXXX | 26.08.2019 09:13:16 | 00:00:21 | 1

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
