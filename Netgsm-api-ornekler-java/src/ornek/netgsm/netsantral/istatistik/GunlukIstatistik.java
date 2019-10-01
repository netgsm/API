package ornek.netgsm.netsantral.istatistik;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GunlukIstatistik {
    /**
     * NETGSM
     * Günlük (Gelen Çağrı) İstatistik
     * Örneği
     * */
    public static void main(String[] args)
    {
        try {
            /**
             * Günlük (Gelen Çağrı) İstatistik
             * sorgulamak için gerekli
             * değişken tanımları
             * */

            // kullanıcı adı
            String username = "8XXXXXXXXX";

            // kullanıcı şifresi
            String password = "XXX";

            // sorgulama başlanacağı tarih
            String startDate = "29082019";

            // sorgulama bitiş tarihi
            String stopDate = "29082019";

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
            /*
            <?xml version='1.0'?>
             <xml>
             <main>
             <info>
             <statistics>
                <date>29.08.2019</date>
                <incoming_call>2</incoming_call>
                <answered>1</answered>
                <noanswer>0</noanswer>
                <abandoned>1</abandoned>
                <t_calltime>11</t_calltime>
                <t_waittime>38</t_waittime>
                <max_waiting>34</max_waiting>
                <avr_waiting>19</avr_waiting>
                <avr_answered>11</avr_answered>
            </statistics>
            </info>
            </main>
            </xml>
            * */
        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
