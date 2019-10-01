package ornek.netgsm.netsantral.cagribaglama;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriBaglama {
    /**
     * NETGSM
     * HTTP Get ile Çağrı Bağlama
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrı bağlamak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "850XXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // arama yapılacak numara
        String caller = "90850XXXXXXX";

        // çağrının bağlanacağı numara
        String called = "905XXXXXXXXX";

        // çalma süresi
        int ring_timeout = 20;

        // crm_id
        int crm_id = 10245;

        // yanıt bekleme durumu
        int wait_response = 1;

        // originate_order
        String originate_order = "of";

        // santral numaranız
        String trunk = "850XXXXXXX";

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/linkup?username="+username+"&password="+password+"&caller="+caller+"&called="+called+"&ring_timeout="+ring_timeout+"&crm_id="+crm_id+"&wait_response="+wait_response+"&originate_order="+originate_order+"&trunk="+trunk+"";

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

        // çağrı bağlama sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"unique_id":"1567065360.438300","caller_num":"905XXXXXXXXX","called_num":"905XXXXXXXXX","crm_id":"10245","response":"linkup","status":"Success","message":"Successfully"}
    }
}
