package ornek.netgsm.netsantral.kuyruktakidahililer.molayaalma;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketDahiliMolayaAlma {
    /**
     * NETGSM
     * TCP Soket ile Dahiliyi molaya alma
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Dahiliyi molaya almak için
         * gereken değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // crm_id; yapılan istek id'si
        String crm_id = "125698";

        // Socket host adresi
        String socketHost = "crmsntrl.netgsm.com.tr";

        // Socket port
        int socketPort = 9110;

        // molaya alınacak dahili
        int exten = 102;

        // mola nedeni
        String reason = "çay molası";

        // kuyruk adı
        String queue = "Departman1";



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


        // 2.adım dahiliyi molaya alma
        // çağrı metni
        String cagriMetni = "{ \"command\" : \"agentpause\", \"crm_id\" : \"" + crm_id + "\", \"exten\" : \"" + exten + "\", \"queue\" : \"" + queue + "\", \"paused\" : \"1\", \"reason\" : \"" + reason + "\" }";

        // dahiliyi molaya alma parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"crm_id":"125698","status":"Success","message":"Successful"}


        // açılan soketin kapatılması
        soket.socketClose();
    }
}
