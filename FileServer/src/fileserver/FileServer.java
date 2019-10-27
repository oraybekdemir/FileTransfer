package fileserver;
import java.net.*;
import java.io.*;
public class FileServer {
 
     public static void main (String [] args ) throws IOException {
          
            ServerSocket serverSocket = new ServerSocket(300);
              Socket socket = serverSocket.accept();
              System.out.println("Bağlanılan soket : " + socket);
              File transferFile = new File ("dosya.txt");
              byte [] bytearray  = new byte [(int)transferFile.length()];
              FileInputStream fin = new FileInputStream(transferFile);
              BufferedInputStream bin = new BufferedInputStream(fin);
              bin.read(bytearray,0,bytearray.length);
              OutputStream os = socket.getOutputStream();
              System.out.println("Dosya Gönderiliyor...");
              os.write(bytearray,0,bytearray.length);
              os.flush();
              socket.close();
              System.out.println("Dosya aktarımı tamamlandı.");
            }
}