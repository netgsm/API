package ornek.netgsm.netsantral.cagritransfer;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketCagriTransfer {
    /**
     * NETGSM
     * TCP Soket ile Çağrı Transfer
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı transferi için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // crm_id; yapılan istek id'si
        String crm_id = "13574";

        // Socket host adresi
        String socketHost = "crmsntrl.netgsm.com.tr";

        // Socket port
        int socketPort = 9110;

        // Yapılan istek bilgisi
        String command = "xfer";

        // çağrı unique_id
        String unique_id = "1567687254.1191561";

        // çağrının aktarılacağı dahili
        String exten = "102";



        // yeni socket başlatma
        SocketHelper soket = new SocketHelper();
        soket.yeniSocket(socketHost, socketPort);


        // 1.adım login işlemi
        // bağlantı metni
        String baglantiMetni = "{ \"command\":\"login\",\"crm_id\":\"" + crm_id + "\",\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        System.out.println(baglantiMetni);

        // bağlantı parametresinin gönderilmesi
        soket.parametreGonder(baglantiMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"status":"Success","message":"login Successful"}


        // 2.adım çağrı aktarma
        // çağrı metni
        String cagriMetni = "{\"command\" : \"" + command + "\", \"unique_id\": \"" + unique_id + "\", \"crm_id\": \"" + crm_id + "\", \"exten\": \"" + exten + "\" }";
        System.out.println(cagriMetni);

        // çağrı aktarma parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"crm_id":"13574","response":"xfer","status":"Success","message":"Successful"}


        // açılan soketin kapatılması
        soket.socketClose();
    }
}
