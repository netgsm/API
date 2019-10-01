package ornek.netgsm.sms.gonderme;

import library.soapsms.SMS;
import library.soapsms.Smsnn;

import java.util.ArrayList;
import java.util.List;

public class SOAPServisiSmsGonderme1N {
    /**
     * NETGSM
     * SOAP ile SMS gönderme 1:N
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * SMS gönderimi için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // mesaj başlığı
        String header = "XXX";

        // gönderilecek mesaj
        String msg = "Yeni mesaj";

        // mesajın gönderileceği telefon numaraları
        List<String> gsm = new ArrayList<String>();
        gsm.add("5XXXXXXXXX");
        gsm.add("8XXXXXXXXX");
        // gsm.add("XXXXXXXXXX");
        // ............

        // mesaj dili
        String encoding = "TR";

        // mesaj göndermeye başlama tarihi (ddMMyyyyHHmm)
        String startDate = "220820192058";

        // mesaj gönderimi bitiş tarihi (ddMMyyyyHHmm)
        String stopDate = "220820192059";

        // bayi kodu
        String bayiKodu = "";

        // izinli data filtresi
        int filter = 0;

        // mesaj gönderimi işlem sonucu dönen değerleri
        // okumak için oluşturulan değişken
        String donen_deger = "";

        // sms gönderme fonksiyonunun çağırılması
        SMS service = new SMS();
        Smsnn port = service.getSmsnnPort();
        donen_deger = port.smsGonder1NV2(username, password, header, msg, gsm, encoding, startDate, stopDate, bayiKodu, filter);

        // sms gönderme sonrası oluşan raporu görüntüleme
        System.out.println("rapor durum = " + donen_deger);

        // alınan örnek cevap
        // 361122318
    }
}
