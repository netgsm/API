package ornek.netgsm.seslimesaj.olusturma;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class BasitSesliSMS {
    /**
     * NETGSM
     * Basit Sesli SMS Gönderimi
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Sesli SMS göndermek için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // mesajın gönderilmeye başlanacağı tarih
            String startDate = "29082019";

            // mesajın gönderilmeye başlanacağı saat ve dakika
            String startTime = "1508";

            // mesaj gönderimi bitiş tarihi
            String stopDate = "29082019";

            // mesaj gönderim bitiş saati ve dakikası
            String stopTime = "1509";

            // ses kaydı sonrası tuşlama isteği
            int key = 1;

            // gonderilmek istenen ses kaydı id
            int audioid  = 12694752;

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/voicesms/send");

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
                    "<starttime>" + startTime + "</starttime> "+
                    "<stopdate>" + stopDate + "</stopdate> "+
                    "<stoptime>" + stopTime + "</stoptime> "+
                    "<key>" + key + "</key> "+
                    "</header>  "+
                    "<body> "+
                    "<audioid>" + audioid + "</audioid> "+
                    "<no>5XXXXXXXXX</no> "+
                    "<no>3XXXXXXXXX</no> "+
                    "<no>8XXXXXXXXX</no> "+
                    "</body> "+
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
            // 00 6935658

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
