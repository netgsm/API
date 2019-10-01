package ornek.netgsm.sms.sorgulama;

import library.soapsms.SMS;
import library.soapsms.Smsnn;

public class SOAPServisiSmsSorgulama {
    /**
     * NETGSM
     * SOAP ile SMS rapor sorgulama
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * SMS raporlarını okumak için gerekli
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

        // bulk ID
        String bulkID = "XXXXXXXXX";

        // rapor tipi
        int type = 0;

        // rapor sonucunu okumak için oluşturulan değişken
        String donen_deger="";

        // rapor oluşturma fonksiyonlarının çağırılması
        SMS service = new SMS();
        Smsnn port = service.getSmsnnPort();

        donen_deger = port.raporV3(username, password, bulkID, null, null, startDate, stopDate,1,100,1);

        // servisten gelen raporu görüntüleme
        System.out.println("SMS Rapor Bilgisi = "+donen_deger);
    }

    /*

    Servisten Dönen Yanıt (type = 0 detail = 1)

    <?xml version='1.0' encoding='iso-8859-9'?>
    <mainbody>
    <telno jobid='XXXXXXXXX' durum='1' operator='40' msg_boyu='1' iletim_tarihi='2019-08-23 17:23:28.09' failreason='0'>8XXXXXXXXX</telno>
    </mainbody>

    Servisten Dönen Yanıt (type = 1 detail = 1)

    <?xml version='1.0' encoding='iso-8859-9'?>
    <mainbody>
    <telno jobid='XXXXXXXXX' durum='1' operator='40' msg_boyu='1' iletim_tarihi='2019-08-23 17:23:28.09' failreason='0'>8XXXXXXXXX</telno>
    <telno jobid='XXXXXXXXX' durum='1' operator='40' msg_boyu='1' iletim_tarihi='2019-08-23 17:23:28.09' failreason='0'>8XXXXXXXXX</telno>
    </mainbody>

    */
}
