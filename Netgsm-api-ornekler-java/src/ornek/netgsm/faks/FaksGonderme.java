package ornek.netgsm.faks;

import library.multipartutility.MultipartUtility;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FaksGonderme {
    /**
     * NETGSM
     * Faks Gönderme
     * Örneği
     * */
    public static void main(String[] args) {
        /**
         * Faks Dosyası göndermek için gerekli
         * değişken tanımları
         * */
        // kullanıcı adı
        String username = "8XXXXXXXXX";

        // kullanıcı şifresi
        String password = "XXXXXX";

        // Gönerim karakter kodlaması
        String charset = "UTF-8";

        // refid oluşturma
        Random rand = new Random();
        int refid = rand.nextInt(9999999);

        // gönderlecek faks dosyası
        File uploadFile = new File("C:\\Users\\XXX\\faks.pdf");

        // faks gönderilecek telefon
        String telefon = "8XXXXXXXXX";

        // Faks göndermeye başlama tarihi
        String startDate = "";

        // Faks gönderim bitiş tarihi
        String stopDate = "";

        // Post gönderilecek Netgsm servisi
        String requestURL = "https://api.netgsm.com.tr/fax/send";


        // önce dosyayı yükle
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addFormField("username", username);
            multipart.addFormField("password", password);
            multipart.addFormField("refid", String.valueOf(refid));
            multipart.addFormField("parametre", "1");


            multipart.addFilePart("dosya", uploadFile);

            String response = multipart.finish();

            System.out.println("rapor durum = " + response);

            // alınan örnek cevap
            // 0

        } catch (IOException ex) {
            System.err.println(ex);
        }

        // sonra faksı gönder

        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

            multipart.addFormField("username", username);
            multipart.addFormField("password", password);
            multipart.addFormField("refid", String.valueOf(refid));
            multipart.addFormField("parametre", "2");
            multipart.addFormField("telefon", telefon);
            multipart.addFormField("startdate", startDate);
            multipart.addFormField("stopdate", stopDate);




            String response = multipart.finish();

            System.out.println("rapor durum = " + response);

            // alınan örnek cevap
            // 934779

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
