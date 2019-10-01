package ornek.netgsm.netsantral.gorusmedetayi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONPostGorusmeDetay {
    /**
     * NETGSM
     * JSON Post ile görüşme detay
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

            HttpURLConnection con = (HttpURLConnection)u.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            String jsonInputString = "{\"usercode\": " + username + ", \"password\" : " + password + ", \"startdate\": " + startDate + ", \"stopdate\": " + stopDate + "}";

            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder sonuc;
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                sonuc = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    sonuc.append(responseLine.trim());
                }
            }

            // istek sonrası oluşan raporu görüntüleme
            System.out.println("rapor durum = " + sonuc.toString());

            // alınan örnek cevap
            // [{"uniqueid":"1566988546.358166","values":[{"date":"28.08.2019 13:35:46","destination":"Telefon_no_tuslayarak_siparis_sorgula","source":"08XXXXXXXXX","duration":"12","direction":1,"recording":"kayıt linki","line":"8XXXXXXXXX"}]},]

        }
        catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
