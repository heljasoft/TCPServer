
package tcpserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {

 
    public static void main(String[] args) {
        
        try(ServerSocket sServer = new ServerSocket(1500);
                Socket cn = sServer.accept();
                BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
                BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream());)
        {
            //logika za citanje
            String line = bis.readLine();
            while (line != null && !line.equals("")) {                
                System.out.println(line);
                line=bis.readLine();
            }
            
            //logika za slanje
            bos.write("Hello from java TCP Server!".getBytes());
            
            System.out.println("Client connected!");
        } catch (IOException ex) {
            System.out.println("Error in connection: "+ ex.getMessage());
        }
        
    }
    
}
