package ornek.netgsm.hesapapi.paketkampanyasorgu;

import library.soapsms.SMS;
import library.soapsms.Smsnn;

public class SOAPServisiPaketKampanya {
    /**
     * NETGSM
     * SOAP ile Paket Kampanya Sorgulsma
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Kampanya ve paket
         * sorgulama için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // rapor sonucunu okumak için oluşturulan değişken
        String donen_deger="";

        // rapor oluşturma fonksiyonlarının çağırılması
        SMS service = new SMS();
        Smsnn port = service.getSmsnnPort();

        donen_deger = port.paketkampanya(username, password);

        // servisten gelen raporu görüntüleme
        System.out.println("Paket Kampanya Bilgisi = "+donen_deger);

        // alınan örnek cevap
        // 1000.0|Adet SMS|Sms Hizmeti - Giden|Paket<br>
    }
}
