import java.io.IOException;
import java.net.*;
import java.io.*;

public class udpcontrol {
    public static InetSocketAddress addr = new InetSocketAddress("0.0.0.0",9999);
    public static DatagramSocket datagramSocket;
    public boolean enviando=false;
    public void escuchaservidor() {
        try {
            while(enviando)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            byte[] mensaje;
            datagramSocket = new DatagramSocket(addr);
            mensaje = new byte[64];
            DatagramPacket datagrama1 = new DatagramPacket(mensaje,64);
            datagramSocket.receive(datagrama1);
            System.out.println("Mensaje entrante de : "+datagrama1.getAddress().toString());
            System.out.println("-> "+new String(mensaje));
            datagramSocket.close();
        } catch (Exception e) {
        
        }
  }
  public void enviar() {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Completa la ip: 172.30.");
        String ip="172.30."+br.readLine();
        System.out.print("Mensaje: ");
        String mensaje2=br.readLine();
        enviando=true;
        datagramSocket.close();
        DatagramSocket datagramSocket2 = new DatagramSocket(addr);
        InetAddress addr2 = InetAddress.getByName(ip);
        DatagramPacket datagrama2 = new DatagramPacket(mensaje2.getBytes(),mensaje2.getBytes().length, addr2, 9999);
        datagramSocket2.send(datagrama2);
        System.out.println("Enviado a 172.30."+ip+": "+mensaje2);
        System.out.println("");
        datagramSocket2.close();
        enviando=false;
        notifyAll();
    } catch (Exception e) {
      
    }
  }
  


}
