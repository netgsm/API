package ornek.netgsm.netsantral.cagrisonlandirma;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketleCagriSonlandirma {
    /**
     * NETGSM
     * Soket ile Çağrı Sonlandirma
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı sonlandirmak için gereken
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

        // unique_id
        String unique_id = "1567061535.428047";

        // Socket port
        int socketPort = 9110;



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


        // 2.adım çağrı sonlandirma
        // çağrı sonlandırma metni
        String cagriMetni = "{ \"command\" : \"hangup\", \"unique_id\" : \"" + unique_id + "\",  \"crm_id\" : \"" + crm_id + "\" }";

        // çağrı sonlandirma parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"crm_id":"125698","response":"hangup","status":"Success","message":"Successful"}


        // açılan soketin kapatılması
        soket.socketClose();
    }
}
