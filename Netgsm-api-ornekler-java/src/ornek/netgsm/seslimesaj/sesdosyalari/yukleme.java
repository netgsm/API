package ornek.netgsm.seslimesaj.sesdosyalari;

import library.multipartutility.MultipartUtility;

import java.io.File;
import java.io.IOException;

public class yukleme {
    /**
     * NETGSM
     * Ses Dosyası Yükleme
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Ses Dosyası yüklemek için gerekli
         * değişken tanımları
         * */

        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXX";

        // Gönerim karakter kodlaması
        String charset = "UTF-8";

        // gönderlecek wav türünde ses kaydının konumu ve ses dosyası
        File uploadFile = new File("C:\\Users\\XXX\\ses-dosyasi.wav");

        // Post gönderilecek Netgsm servisi
        String requestURL = "https://api.netgsm.com.tr/voicesms/upload";



        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addFormField("username", username);
            multipart.addFormField("password", password);

            multipart.addFilePart("dosya", uploadFile);

            String response = multipart.finish();

            System.out.println("rapor durum = " + response);

            // alınan örnek cevap
            // 13193277

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
