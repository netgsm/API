package ornek.netgsm.seslimesaj.raporlamaservisi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RaporlamaServisi {
    /**
     * NETGSM
     * Sesli Mesaj Gönderimi
     * Raporlama Servisi
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         * Raporlama servisi için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Bulkid
        String bulkid = "XXXXXXX";

        // tip
        int type = 1;

        // durum
        int status = 0;

        // basılan tuşlar
        int tus = 10;

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/voicesms/report/?usercode="+username+"&password="+password+"&bulkid="+bulkid+"&type="+type+"&status="+status+"&tus="+tus+"";

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

        // rapor görüntüleme
        System.out.println("rapor durum = "+response.toString());

        // alınan örnek cevap
        // 6976410  8XXXXXXXXX   1       4
        // bulkid   tel no       durum   tuşlama
    }
}
