package ornek.netgsm.netsantral.kuyruktakidahililer.molayaalma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetMolayaAlma {
    /**
     * NETGSM
     * HTTP Get ile Molaya alma
     * dahili ekleme
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Dahiliyi molaya almak için
         * gereken değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // molaya alınacak dahili
        int exten = 102;

        // mola nedeni
        String reason = "çay molası";

        // kuyruk adı
        String queue = "Departman1";

        // crm_id; yapılan istek id'si
        String crm_id = "125698";

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/agentpause?username="+username+"&password="+password+"&crm_id="+crm_id+"&exten="+exten+"&queue="+queue+"&paused=1&reason="+reason+"";

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

        // dahiliyi molaya alma sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"125698","status":"Success","message":"Successful"}
    }
}
