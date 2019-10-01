package ornek.netgsm.netsantral.cagrikuyrugu;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketleCagriKuyruguIzleme {
    /**
     * NETGSM
     * TCP Soket ile Çağrı Kuyruğu İzleme
     * Örneği
     */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı kuyruğu izlemek için gereken
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // crm_id; yapılan istek id'si
        String crm_id = "1001256";

        // Socket host adresi
        String socketHost = "crmsntrl.netgsm.com.tr";

        // Socket port
        int socketPort = 9110;

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


        // 2.adım çağrı kuyruğu izleme
        // çağrı metni
        String cagriMetni = "{ \"command\" : \"queuestats\" ,\"queue\" : \""+ queue +"\" , \"crm_id\" : \"" + crm_id + "\" }";

        // çağrı kuyruğu izleme parametresinin gönderilmesi
        soket.parametreGonder(cagriMetni);

        // dönen yanıt kontrolü
        System.out.println(soket.donenYanitiOku());

        // alınan örnek cevap
        // {"crm_id":"1001256","pbx_num":"8XXXXXXXXX","queues":[{"queuename":"8XXXXXXXXX-queue-Departman1","callers":{"05XXXXXXXXX":12}


        // açılan soketin kapatılması
        soket.socketClose();

    }
}
