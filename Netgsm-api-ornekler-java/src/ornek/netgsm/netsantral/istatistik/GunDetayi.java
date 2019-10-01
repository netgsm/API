package ornek.netgsm.netsantral.istatistik;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GunDetayi {
    /**
     * NETGSM
     * Gün Detay
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Gün detayını
             * sorgulamak için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // sorgulama başlanacağı tarih
            String date = "29082019";

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/netsantral/statistics");

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
                    "<abandoned>1</abandoned>"+
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
            /* <?xml version="1.0"?>
            <xml>
            <main>
            <abandoned>
            <call>
            <uniqueid>1567065751.439801</uniqueid>
            <date>29.08.2019 11:02:47</date>
            <number>05XXXXXXXXX</number>
            <calltime>0</calltime>
            <waittime>34</waittime>
            </call>
            </abandoned>
            </main>
            </xml> */

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
