package ornek.netgsm.netsantral.cagribaglama;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketCagriBaglama {
    /**
     * NETGSM
     * TCP Soket ile Çağrı Bağlama
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı bağlamak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // crm_id; yapılan istek id'si
        String crm_id = "125698";

        // Socket host adresi
        String socketHost = "crmsntrl.netgsm.com.tr";

        // Socket port
        int socketPort = 9110;

        // arama yapılacak numara
        String caller = "90850XXXXXXX";

        // çağrının bağlanacağı numara
        String called = "905XXXXXXXXX";

        // çalma süresi
        int ring_timeout = 20;

        // yanıt bekleme durumu
        int wait_response = 1;

        // originate_order
        String originate_order = "if";

        // santral numaranız
        String trunk = "850XXXXXXX";



        // yeni socket başlatma
        SocketHelper soket = new SocketHelper();
        soket.yeniSocket(socketHost, socketPort);


        // 1.adım login işlemi
        // bağlantı metni
        String baglantiMetni = "{ \"command\" : \"login\", \"crm_id\" : \"" + crm_id + "\", \"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}";

        // bağlantı parametresinin gönderilmesi
        soket.parametreGonder(baglantiMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"status":"Success","message":"login Successful"}


        // 2.adım çağrı bağlama
        // çağrı metni
        String cagriMetni = "{ \"command\" : \"linkup\", \"caller\": \"" + caller + "\",   \"called\": \"" + called + "\",   \"ring_timeout\": \"" + ring_timeout + "\",    \"crm_id\": \"" + crm_id + "\",    \"wait_response\": \"" + wait_response + "\",   \"originate_order\": \"" + originate_order + "\",    \"trunk\": \"" + trunk + "\" }";

        // çağrı bağlama parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"unique_id":"1567065360.438300","caller_num":"905XXXXXXXXX","called_num":"905XXXXXXXXX","crm_id":"10245","response":"linkup","status":"Success","message":"Successfully"}


        // açılan soketin kapatılması
        soket.socketClose();
    }
}
