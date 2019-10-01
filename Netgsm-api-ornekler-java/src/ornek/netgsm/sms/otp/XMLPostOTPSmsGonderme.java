package ornek.netgsm.sms.otp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostOTPSmsGonderme {
    /**
     * NETGSM
     * XML Post ile OTP SMS gönderme
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
            String msg = "OTP SMS mesaj";

            // sms gönderilecek numara
            String no = "8XXXXXXXXX";

            // Post gönderilecek Netgsm servisi
            URL u = new URL("https://api.netgsm.com.tr/sms/send/otp");

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
                    "<msgheader>" + header + "</msgheader>  "+
                    "</header>  "+
                    "<body>  "+
                    "<msg>"+
                    "    <![CDATA["+ msg +"]]>"+
                    "</msg>"+
                    "<no>" + no + "</no>    "+
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

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }

         /*
        Servisten dönen yanıt (SMS başarıyla teslim alındığında)

        <?xml version="1.0"?>
        <xml>
        <main>
        <code>0</code>
        <jobID>363455686</jobID>
        </main>
        </xml>

        Servisten dönen yanıt (Hata alındığında)

        <?xml version="1.0"?>
        <xml>
        <main>
        <code>60</code>
        <error>Hesabinizda OTP SMS Paketi tanimli degil</error>
        </main>
        </xml>

        */
    }
}
