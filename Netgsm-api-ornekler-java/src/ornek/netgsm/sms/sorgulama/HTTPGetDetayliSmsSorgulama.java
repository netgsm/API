package ornek.netgsm.sms.sorgulama;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetDetayliSmsSorgulama {
    /**
     * NETGSM
     * HTTP Get ile Detaylı SMS rapor sorgulama
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
        String url = "https://api.netgsm.com.tr/sms/report/detail/?usercode=" + username + "&password=" + password + "&bulkid=" + bulkID + "&type=1&version=1&page=1";

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
        // version = 1 type = 0
        /*
        *    GorevID	    Paketin Zaman Aralığı	           Gönderici Adi	Gönderilen gruplar	    Mesaj	        Durum	Gönderilen Sayısı-Ulaşan Sayısı
             358640671      23.08.2019 17:2324.08.2019 14:23   8XXXXXXXXX	        --	            Test mesaji 1058	2	                1-1
        * */
        //
        // version = 1 type = 1
        /*
        *   GorevID	      Paketin Zaman Aralığı	                Gönderici Adi	Gönderilen gruplar	    Mesaj	        Durum	Gönderilen Sayısı-Ulaşan Sayısı
            358640671     23.08.2019 17:2324.08.2019 14:23      8XXXXXXXXX	        --	            Test mesaji 1058	2	                1-1
            358640671     23.08.2019 17:2324.08.2019 14:23      8XXXXXXXXX	        --	            Test mesaji 1058	2	          Gönderim Basarisiz
        * */
        //
    }
}
