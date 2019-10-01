package ornek.netgsm.seslimesaj.olusturma;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DinamikSesliSMS {
    /**
     * NETGSM
     * Dinamik Sesli SMS Gönderimi
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

            // mesajın gönderilmeye başlanacağı saat
            String startTime = "1509";

            // mesaj gönderimi bitiş tarihi
            String stopDate = "29082019";

            // mesaj gönderim bitiş saati
            String stopTime = "1510";

            // ses kaydı sonrası tuşlama isteği
            int key = 1;

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
                    "<voicemail>"+
                    "<scenario>"+
                    "         <series s='1'>"+
                    "         <text>sese çevrilmesi istenen metin 1</text>"+
                    "         </series>"+
                    "          <series s='2'><audioid>12694752</audioid></series>"+
                    "          <series s='3'><audioid>12694752</audioid></series>"+
                    "          <series s='4'><text>sese çevrilmesi istenen metin 2 </text></series>"+
                    "          <number>"+
                    "              <no>5XXXXXXXXX</no>"+
                    "              <no>3XXXXXXXXX</no>"+
                    "              <no>8XXXXXXXXX</no>"+
                    "          </number>"+
                    "     </scenario>"+
                    " </voicemail>"+
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
            // 00 6935718

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
