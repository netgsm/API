package ornek.netgsm.sms.gondericiadi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetGondericiAdiSorgulama {
    /**
     * NETGSM
     * HTTP Get ile Gönderici Adı Sorgulama
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Gönderici adı sorgulamak için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/sms/header/?usercode="+username+"&password="+password+"";

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

        // gönderici adları görüntüleme
        System.out.println("gönderici adı = " + response.toString());

        // alınan örnek cevap
        // 8XXXXXXXXX
    }
}
