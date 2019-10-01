package ornek.netgsm.faks;

import library.multipartutility.MultipartUtility;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FaksDosyaYukleme {
    /**
     * NETGSM
     * Faks Dosya Yükleme
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Faks Dosyası yüklemek için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Gönerim karakter kodlaması
        String charset = "UTF-8";

        // refid oluşturma
        Random rand = new Random();
        int refid = rand.nextInt(9999);

        // faks dosya yükleme parametresi
        int parametre = 1;

        // gönderlecek faks dosyası
        File uploadFile = new File("C:\\Users\\XXX\\faks.pdf");

        // Post gönderilecek Netgsm servisi
        String requestURL = "https://api.netgsm.com.tr/fax/send";



        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addFormField("username", username);
            multipart.addFormField("password", password);
            multipart.addFormField("refid", String.valueOf(refid));
            multipart.addFormField("parametre", String.valueOf(parametre));


            multipart.addFilePart("dosya", uploadFile);

            String response = multipart.finish();

            System.out.println("rapor durum = " + response);

            // alınan örnek cevap
            // 0

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
