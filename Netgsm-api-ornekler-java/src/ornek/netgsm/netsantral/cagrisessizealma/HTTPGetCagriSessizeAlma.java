package ornek.netgsm.netsantral.cagrisessizealma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriSessizeAlma {
    /**
     * NETGSM
     * HTTP Get ile Çağrıyı Sessize Alma
     * Örneği
     */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrıyı sessize almak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // santral adı
        String SantralAdi = "8XXXXXXXXX";

        // çağrı id
        String unique_id="1567664083.1114426";

        // crm_id
        int crm_id = 10245;



        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/" + SantralAdi + "/muteaudio?username=" + username + "&password=" + password + "&unique_id=" + unique_id + "&crm_id=" + crm_id + "&direction=all&state=mute";

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

        // çağrı sessize alma rapor durumu
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"10245","response":"muteaudio","status":"Success","message":"Successful"}
    }
}
