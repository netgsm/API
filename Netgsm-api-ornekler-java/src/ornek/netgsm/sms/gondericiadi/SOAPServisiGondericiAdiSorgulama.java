package ornek.netgsm.sms.gondericiadi;


import library.soapsms.SMS;
import library.soapsms.Smsnn;

public class SOAPServisiGondericiAdiSorgulama {
    /**
     * NETGSM
     * SOAP ile Gönderici Adı Sorgulama
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Gönderici adı sorgulamak için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Servisten dönen yanıtı okumak için oluşturulan değişken
        String donen_deger = "";

        // Gönderici Adı fonksiyonunun çağırılması
        SMS service = new SMS();
        Smsnn port = service.getSmsnnPort();
        donen_deger = port.gondericiadlari(username, password);

        // gönderici adları görüntüleme
        System.out.println("gönderici adı = " + donen_deger);

        // alınan örnek cevap
        // 8XXXXXXXXX
    }
}
