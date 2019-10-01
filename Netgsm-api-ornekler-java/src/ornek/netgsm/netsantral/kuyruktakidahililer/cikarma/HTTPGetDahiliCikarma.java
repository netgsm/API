package ornek.netgsm.netsantral.kuyruktakidahililer.cikarma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetDahiliCikarma {
    /**
     * NETGSM
     * HTTP Get ile Kuyruktaki dahilileri çıkarma
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Kuyruktaki dahiliyi çıkarmak için
         * gereken değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // çıkarılacak dahili
        int exten = 102;

        // kuyruk adı
        String queue = "Departman1";

        // crm_id; yapılan istek id'si
        String crm_id = "125698";


        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/agentlogoff?username="+username+"&password="+password+"&crm_id="+crm_id+"&exten="+exten+"&queue="+queue+"&paused=1&penalty=1";

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

        // kuyruğa dahili ekleme sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"125698","status":"Success","message":"Successful"}
    }
}
