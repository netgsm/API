package ornek.netgsm.netsantral.cagrisessizealma;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketleCagriSessizeAlma {
    /**
     * NETGSM
     * TCP Soket ile Çağrıyı Sessize Alma
     * Örneği
     */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrıyı sessize almak için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // crm_id; yapılan istek id'si
        String crm_id = "1001256";

        // çağrı id
        String unique_id="1567663620.1113565";

        // Socket host adresi
        String socketHost = "crmsntrl.netgsm.com.tr";

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


        // 2.adım devam eden çağrıyı sessize alma
        // çağrı metni
        String cagriMetni = "{ \"command\" : \"muteaudio\", \"unique_id\" : \"" + unique_id + "\", \"crm_id\" : \"" + crm_id + "\", \"direction\" : \"all\", \"state\" : \"mute\" }";

        // çağrı sessize alma metninin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"crm_id":"1001256","response":"muteaudio","status":"Success","message":"Successful"}


        // açılan soketin kapatılması
        soket.socketClose();

    }
}
