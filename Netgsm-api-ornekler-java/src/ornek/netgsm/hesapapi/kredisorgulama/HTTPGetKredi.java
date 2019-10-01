package ornek.netgsm.hesapapi.kredisorgulama;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetKredi {
    /**
     * NETGSM
     * HTTP Get ile Hesap Kredisi Sorgulama
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Hesap Kredisi Sorgulama için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/balance/list/get/?usercode="+username+"&password="+password+"";

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

        // servisten gelen raporu görüntüleme
        System.out.println("Kredi Bilgisi = "+response.toString());

        // alınan örnek cevap
        // 00 39,000
    }
}
