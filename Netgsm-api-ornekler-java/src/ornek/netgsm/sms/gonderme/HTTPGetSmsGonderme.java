package ornek.netgsm.sms.gonderme;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HTTPGetSmsGonderme {
    /**
     * NETGSM
     * HTTP Get ile SMS gönderme
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
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
        String msg = URLEncoder.encode("Yeni mesaj", StandardCharsets.UTF_8.toString());

        // mesajın gönderileceği telefon numaraları
        String gsm = URLEncoder.encode("5XXXXXXXXX, 8XXXXXXXXX", StandardCharsets.UTF_8.toString());;

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/sms/send/get/?usercode="+username+"&password="+password+"&gsmno="+gsm+"&message="+msg+"&msgheader="+header+"";

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

        // sms gönderme sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // 00 361124870
    }
}
