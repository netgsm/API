package ornek.netgsm.sms.gonderme;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostSmsGonderme1N {
    /**
     * NETGSM
     * XML Post ile sms gönderme 1:N
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * SMS gönderimi için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // mesaj başlığı
            String header = "XXX";

            // gönderilecek mesaj
            String msg = "Yeni mesaj";

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/sms/send/xml");

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
                    "<company dil='TR'>Netgsm</company>   "+
                    "<usercode>" + username + "</usercode> "+
                    "<password>" + password + "</password>  "+
                    "<type>1:n</type>  "+
                    "<msgheader>" + header + "</msgheader>  "+
                    "</header>  "+
                    "<body>  "+
                    "<msg>  "+
                    "<![CDATA[" + msg + "]]>  "+
                    "</msg>  "+
                    "<no>5XXXXXXXXX</no>    "+
                    "<no>8XXXXXXXXX</no>    "+
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

            // sms gönderme sonrası oluşan raporu görüntüleme
            System.out.println("rapor durum = " + sonuc);

            // alınan örnek cevap
            // 00 361126686

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
