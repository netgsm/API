package ornek.netgsm.sms.gelensms;


import library.soapsms.SMS;
import library.soapsms.Smsnn;

public class SOAPServisiGelenSmsSorgulama {
    /**
     * NETGSM
     * SOAP ile Gelen SMS sorgulama
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Gelen SMS için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // sorgulanacak tarih başlangıç (ddMMyyyyHHmm)
        String startDate = "010820190000";

        // sorgulanacak tarih bitiş (ddMMyyyyHHmm)
        String stopDate = "280820190000";

        // rapor tipi
        int type = 1;

        // rapor sonucunu okumak için oluşturulan değişken
        String donen_deger="";

        // rapor oluşturma fonksiyonlarının çağırılması
        SMS service = new SMS();
        Smsnn port = service.getSmsnnPort();

        donen_deger = port.gelensmsV2(username, password, startDate, stopDate,type);

        // servisten gelen raporu görüntüleme
        System.out.println("SMS Rapor Bilgisi = "+donen_deger);
    }

     /*

    Servisten Dönen Yanıt (type = 0)

    <?xml version='1.0' encoding='iso-8859-9'?>
    <mainbody>
    <msg>
    <gonderen>8XXXXXXXXX</gonderen>
    <mesaj>Merhaba test mesajı </mesaj>
    <tarih>2019-08-26 09:57:00.23</tarih>
    <operator>NETGSM</operator>
    </msg>
    </mainbody>


    Servisten Dönen Yanıt (type = 1)

    <?xml version='1.0' encoding='iso-8859-9'?>
    <mainbody>
    <msg>
    <gonderen>8XXXXXXXXX</gonderen>
    <mesaj>Merhaba test mesajı </mesaj>
    <tarih>2019-08-26 10:00:04.49</tarih>
    <operator>NETGSM</operator>
    <gorevid>69148260</gorevid>
    </msg>
    </mainbody>


    */

}
