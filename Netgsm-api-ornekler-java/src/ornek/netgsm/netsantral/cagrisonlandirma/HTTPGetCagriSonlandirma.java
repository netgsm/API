package ornek.netgsm.netsantral.cagrisonlandirma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriSonlandirma {
    /**
     * NETGSM
     * HTTP Get ile Çağrı Sonlandırma
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrı sonlandırmak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // crm_id
        int crm_id = 10245;

        // unique_id
        String unique_id = "1567061646.428208";

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/hangup?username="+username+"&password="+password+"&crm_id="+crm_id+"&unique_id="+unique_id+"";

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

        // çağrı sonlandırma sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"10245","response":"hangup","status":"Success","message":"Successful"}
    }
}
