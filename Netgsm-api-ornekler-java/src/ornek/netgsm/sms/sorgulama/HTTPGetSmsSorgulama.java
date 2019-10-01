package ornek.netgsm.sms.sorgulama;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetSmsSorgulama {
    /**
     * NETGSM
     * HTTP Get ile SMS rapor sorgulama
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * SMS raporlarını okumak için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // bulk ID
        String bulkID = "XXXXXXXXX";

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/sms/report/?usercode=" + username + "&password=" + password + "&bulkid=" + bulkID + "&type=1&status=100&version=2";

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

        // detaylı sms raporu görüntüleme
        System.out.println(response.toString());

        // alınan örnek cevaplar
        // type = 0 version = 2
        // 90XXXXXXXXXX 1 40 1 23.08.2019 17:23:28 0
        //
        // type = 0 version = 1 ya da version = 0
        // 90XXXXXXXXXX 1
        //
        // type = 1 version = 2
        // 361124870 90XXXXXXXXXX 1 40 1 23.08.2019 17:23:28 0
        //
        // type = 1 version = 1 ya da version = 0
        // 361124870 90XXXXXXXXXX 1
        //
    }
}
