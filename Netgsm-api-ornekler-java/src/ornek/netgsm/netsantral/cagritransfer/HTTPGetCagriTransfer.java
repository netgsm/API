package ornek.netgsm.netsantral.cagritransfer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriTransfer {
    /**
     * NETGSM
     * HTTP Get ile Çağrı Transfer
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrı transferi için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // crm_id
        int crm_id = 10245;

        // Yapılan istek bilgisi
        String command = "xfer";

        // çağrı unique_id
        String unique_id = "1567687479.1192533";

        // çağrının aktarılacağı dahili
        String exten = "102";

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/" + command + "?username="+username+"&password="+password+"&exten="+exten+"&unique_id="+unique_id+"&crm_id="+crm_id+"";

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

        // çağrı transferi sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"10245","response":"xfer","status":"Success","message":"Successful"}
    }
}
