package ornek.netgsm.netsantral.gorusmedetayi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetGorusmeDetay {
    /**
     * NETGSM
     * HTTP Get ile görüşme detay
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * HTTP Get ile görüşme detay için gerekli
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

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/netsantral/report?usercode=" + username + "&password=" + password + "&startdate=" + startDate + "&stopdate=" + stopDate + "";

        // URL obje tanımı
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // bağlantı türü tanımı
        con.setRequestMethod("GET");

        // bağlantı için header tanımı
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        // servise bağlanılıyor ve sonuç alınıyor
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // rapor görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // 1566988546.358166|28.08.2019 13:35:46|Telefon_no_tuslayarak_siparis_sorgula-interactive-XXX|0312XXXXXXX|12|1|'görüşme ses kaydı linki'
    }
}
