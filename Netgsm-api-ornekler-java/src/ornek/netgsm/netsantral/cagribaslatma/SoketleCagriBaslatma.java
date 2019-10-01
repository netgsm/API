package ornek.netgsm.netsantral.cagribaslatma;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketleCagriBaslatma {
    /**
     * NETGSM
     * Soket ile Çağrı Başlatma
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı başlatmak için gereken
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
        String customer_num = "90XXXXXXXXXX";

        // pbxnum
        String pbxnum = "0850XXXXXXX";

        // dahili numarası
        int internal_num = 101;

        // çalma süresi
        int ring_timeout = 20;

        // yanıt bekleme durumu
        int wait_response = 1;

        // originate_order
        String originate_order = "of";

        // santral numaranız
        String trunk = "850XXXXXXX";

        // manual_answer numaranız
        int manual_answer = 1;



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


        // 2.adım çağrı başlatma
        // çağrı metni
        String cagriMetni = "{ \"command\" : \"originate\", \"customer_num\" : \"" + customer_num + "\", \"pbx_num\" : \"" + pbxnum + "\", \"internal_num\" : \"" + internal_num + "\", \"ring_timeout\" : \"" + ring_timeout + "\", \"crm_id\" : \"" + crm_id + "\", \"wait_response\" : \"" + wait_response + "\", \"originate_order\" : \"" + originate_order + "\", \"manual_answer\": \"" + manual_answer + "\", \"trunk\": \"" + trunk + "\" }";

        // çağrı başlatma parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"unique_id":"1567608664.1094905","caller_num":"905XXXXXXXXX","called_num":"101","crm_id":"125698","response":"originate","status":"Success","message":"Successfully"}


        // açılan soketin kapatılması
        soket.socketClose();
    }

}
