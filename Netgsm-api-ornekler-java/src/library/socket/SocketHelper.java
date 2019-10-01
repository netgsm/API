package library.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Soket işlemleri için kullanılacak
 * Yardımcı class
 * */
public class SocketHelper {

    Socket socket;
    DataOutputStream dOut;
    DataInputStream dIn;

    public SocketHelper() {
    }

    public void yeniSocket (String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.dOut = new DataOutputStream(this.socket.getOutputStream());
    }

    public void parametreGonder (String parametre) throws IOException {
        byte[] bytes = parametre.getBytes();
        this.dOut.write(bytes);
        this.dOut.flush();
    }

    public String donenYanitiOku() throws IOException {
        this.dIn = new DataInputStream(this.socket.getInputStream());
        List<Byte> byteList = new ArrayList<Byte>();
        String msg = "";
        boolean done = false;

        while(!done) {
            byte messageType = dIn.readByte();
            if (messageType == 125) // {
            {done = true;}

            byteList.add(messageType);
            msg += (char)messageType;
        }
        return msg;
    }

    public void socketClose() throws IOException {
        this.dIn.close();
        this.socket.close();
    }
}
