package ornek.netgsm.sms.gelensms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostGelenSmsSorgulama {
    /**
     * NETGSM
     * XML Post ile Gelen SMS Sorgulama
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Gelen SMS için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // sorgulanacak tarih başlangıç (ddMMyyyyHHmm)
            String startDate = "010820190000";

            // sorgulanacak tarih bitiş (ddMMyyyyHHmm)
            String stopDate = "270820190000";

            // rapor tipi
            int type = 1;

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/sms/receive");

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
                    "<type>" + type + "</type>  "+
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
            System.out.println("rapor durum = " + sonuc);

            // alınan örnek cevap
            // type 0
            // 8XXXXXXXXX | Merhaba test mesajý | 26.08.2019 10:00:02
            //
            // type 1
            // 8XXXXXXXXX | Merhaba test mesajý | 26.08.2019 10:00:02 | 69148260

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
