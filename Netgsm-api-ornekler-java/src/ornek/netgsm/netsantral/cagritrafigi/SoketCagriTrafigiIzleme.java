package ornek.netgsm.netsantral.cagritrafigi;

import library.socket.SocketHelper;

import java.io.IOException;

public class SoketCagriTrafigiIzleme {
    /**
     * NETGSM
     * TCP Soket ile Çağrı Trafiği İzleme
     * Örneği
     * */
    public static void main(String[] args) throws IOException {
        /**
         * Çağrı trafiği izlemek için gereken
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

       // santral dinleme
       while (true){
           System.out.println(soket.donenYanitiOku());
       }

        // alınan örnek cevap
        // {"pbx_num":"850XXXXXXX","unique_id":"1566981761.338458","incoming_number":"850XXXXXXX","scenario":"InboundtoPBX","customer_num":"0312XXXXXXX"}
        // {"pbx_num":"850XXXXXXX","unique_id":"1566981761.338458","talktime":"0","internal_num":"850XXXXXXX","scenario":"Hangup","customer_num":"0312XXXXXXX","holdtime":"0"}
        // {"pbx_num":"850XXXXXXX","unique_id":"1566981770.338474","incoming_number":"850XXXXXXX","scenario":"InboundtoPBX","customer_num":"0312XXXXXXX"}
        // {"pbx_num":"850XXXXXXX","unique_id":"1566981770.338474","talktime":"0","internal_num":"s","scenario":"Hangup","customer_num":"0312XXXXXXX","holdtime":"0"}

    }
}
