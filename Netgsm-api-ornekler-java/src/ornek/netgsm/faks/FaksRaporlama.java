package ornek.netgsm.faks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FaksRaporlama {
    /**
     * NETGSM
     * Faks Gönderimi
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
        String bulkid = "6936219";

        // tip
        int type = 3;

        // başlangıç tarihi
        String bastar = "01082019";

        // bitiş tarihi
        String bittar = "30082019";

        // Get ile sorgulanacak Netgsm servisi
        String url = "https://api.netgsm.com.tr/fax/report/?usercode="+username+"&password="+password+"&bulkid="+bulkid+"&type="+type+"&bastar="+bastar+"&bittar="+bittar+"";

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
        // 53545 05xxxxxxxxx 0 1
    }
}
