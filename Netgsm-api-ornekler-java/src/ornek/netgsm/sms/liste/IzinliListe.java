package ornek.netgsm.sms.liste;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class IzinliListe {
    /**
     * NETGSM
     * İzinli Data Listesine Numara Ekleme
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Listeye ekleme yapabilmek için
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // liste tipi: 1 ekleme, 2 çıkarma
            int type = 1;

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/sms/whitelist");

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
                    "<tip>" + type + "</tip> "+
                    "</header>  "+
                    "<body>  "+
                    "<number>5XXXXXXXXXX</number> "+
                    "<number>8XXXXXXXXXX</number> "+
                    "<number>3XXXXXXXXXX</number> "+
                    "</body>  "+
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

            // listeye ekleme sonrası oluşan raporu görüntüleme
            System.out.println("rapor durum = " + sonuc);

            // alınan örnek cevap
            // OK

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
