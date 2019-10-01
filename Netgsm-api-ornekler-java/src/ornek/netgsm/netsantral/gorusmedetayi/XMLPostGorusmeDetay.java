package ornek.netgsm.netsantral.gorusmedetayi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostGorusmeDetay {
    /**
     * NETGSM
     * XML Post ile görüşme detay
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Görüşme detayı (CDR) sorgulamak için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // sorgulama başlanacağı tarih
            String startDate = "270820192350";
            //String startDate = "";

            // sorgulama bitiş tarihi
            String stopDate = "280820191350";
            //String stopDate = "";

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/netsantral/report");

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
            // 1566988546.358166|28.08.2019 13:35:46|Telefon_no_tuslayarak_siparis_sorgula-interactive-XXX|0312XXXXXXX|12|1|'görüşme ses kaydı linki'

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
