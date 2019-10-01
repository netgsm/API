package ornek.netgsm.sms.iptali;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class XMLPostSmsIptaliDuzenlemesi {
    /**
     * NETGSM
     * XML Post ile SMS İptali / Düzenlemesi
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * SMS iptali / düzenlemesi için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // mesaj başlama tarihi (ddMMyyyyHHmm)
            String startDate = "280820190000";

            // mesaj bitiş tarihi (ddMMyyyyHHmm)
            String stopDate = "280820191740";

            // görev ID
            String gorevID = "XXXXXXXXX";

            URL u = new URL("https://api.netgsm.com.tr/sms/edit");

            URLConnection uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection) uc;
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            OutputStream out = connection.getOutputStream();
            OutputStreamWriter wout = new OutputStreamWriter(out, "UTF-8");
            wout.write("<?xml version='1.0'?> "+
                    "<mainbody> "+
                    "<header> "+
                    "<usercode>" + username + "</usercode> "+
                    "<password>" + password + "</password> "+
                    "<startdate>" + startDate + "</startdate> "+
                    "<stopdate>" + stopDate + "</stopdate> "+
                    "<gorevid>" + gorevID + "</gorevid> "+
                    "<type>0</type> "+
                    "</header> "+
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

            // sms iptali / düzenlemesi sonrası oluşan raporu görüntüleme
            System.out.println("rapor durum = " + sonuc);

            // alınan örnek cevap
            // 00
        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
