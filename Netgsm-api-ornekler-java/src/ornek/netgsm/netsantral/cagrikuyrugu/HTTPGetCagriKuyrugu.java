package ornek.netgsm.netsantral.cagrikuyrugu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetCagriKuyrugu {
    /**
     * NETGSM
     * HTTP Get ile Çağrı Kuyruğu İzleme
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Çağrı Kuyruğu İzleme için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // santral adı
        String SantralAdi = "850XXXXXXX";

        // kuyruk adı
        String queue = "kuyruk";

        // crm_id
        int crm_id = 10245;



        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/" + SantralAdi + "/queuestats?username=" + username + "&password=" + password + "&queue=" + queue + "&crm_id=" + crm_id + "'";

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

        // çağrı kuyrusu raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // {"crm_id":"10245'","pbx_num":"850XXXXXXX","queues":[{"queuename":"850XXXXXXX-queue-kuyruk","callers":{"05XXXXXXXXX":3},"agents":[{"agent":"101","status":"ringing","membership":"static","paused":"false","reason":""}],"calls":1,"holdtime":4,"talktime":11,"completed":1,"abondaned":0,"max":0}]}
    }
}
