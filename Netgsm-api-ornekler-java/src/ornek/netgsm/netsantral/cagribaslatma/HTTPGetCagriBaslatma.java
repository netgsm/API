package ornek.netgsm.netsantral.cagribaslatma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriBaslatma {
    /**
     * NETGSM
     * HTTP Get ile Çağrı Başlatma
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrı başlatmak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // arama yapılacak numara
        String customer_num = "90XXXXXXXXXX";

        // pbxnum
        String pbxnum = "0850XXXXXXX";

        // dahili numarası
        int internal_num = 101;

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

        // manual_answer numaranız
        int manual_answer = 1;

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/originate?username="+username+"&password="+password+"&customer_num="+customer_num+"&pbxnum="+pbxnum+"&internal_num="+internal_num+"&ring_timeout="+ring_timeout+"&crm_id="+crm_id+"&wait_response="+wait_response+"&originate_order="+originate_order+"&trunk="+trunk+"&manual_answer="+manual_answer+"";

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

        // çağrı başlatma sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"unique_id":"1566828783.189480","caller_num":"905XXXXXXXXX,"called_num":"101","crm_id":"10245","response":"originate","status":"Success","message":"Successfully"}
    }
}
