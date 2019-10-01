package ornek.netgsm.hesapapi.kredisorgulama;


import library.soapsms.SMS;
import library.soapsms.Smsnn;

public class SOAPServisiKrediSorgulama {
    /**
     * NETGSM
     * SOAP ile Hesap Kredisi Sorgulama
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Hesap kredisi sorgulama için gerekli
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

        donen_deger = port.kredi(username, password);

        // servisten gelen raporu görüntüleme
        System.out.println("Kredi Bilgisi = "+donen_deger);

        // alınan örnek cevap
        // 39.0
    }
}
