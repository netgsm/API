package ornek.netgsm.netsantral.dynamicredirect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGetdynamicredirect {
    /**
     * NETGSM
     * HTTP Get ile Dinamik yönlendirme
     * Örneği
     * */
    public static void main(String[] args) throws Exception {
        /**
         *  Dinamik yönlendirme için gereken değişken tanımları
         * */

        // kullanıcı adı
        String username = "850XXXXXXX";
        // kullanıcı şifresi
        String password = "XXX";
        // santral adı
        String SantralAdi = "850XXXXXXX";
        // yonlendirilecek menu
        String redirect_menu = "testnetgsm";
        // yonlendirme tipi
        String redirect_type = "ivr";
        // aranacak numara
        String called = "905XXXXXXXXX";
        // çalma süresi
        int ring_timeout = 20;
        // crm_id
        int crm_id = 10245;
        // yanıt bekleme durumu
        int wait_response = 1;
        // çıkış yapılacak santral numaranız
        String trunk = "850XXXXXXX";

        // Get ile sorgulanacak Netgsm servisi
        String url = "http://crmsntrl.netgsm.com.tr:9111/"+SantralAdi+"/dynamic_redirect?username="+username+"&password="+password+"&called="+called+"&redirect_menu="+redirect_menu+"&ring_timeout="+ring_timeout+"&crm_id="+crm_id+"&wait_response="+wait_response+"&redirect_type="+redirect_type+"&trunk="+trunk+"";

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

        //  Dinamik yönlendirme sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = "+response.toString());


    }
}
