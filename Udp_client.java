
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;




public class Udp_client
{


    String ip_address;
    static byte [] data;
    static int udp_port;
    static InetAddress addr;
    static DatagramSocket ds;


    public Udp_client()

    {
        ip_address=GUI.jTextField6.getText().trim();
        udp_port=Integer.parseInt(GUI.jTextField8.getText());

        try
        {
            ds = new DatagramSocket();
            addr = InetAddress.getByName(ip_address);

        }
        catch (Exception e)
        {
            System.out.println(e);

            GUI.jTextArea2.append("Cannot create UDP client\r\n");
        }


    }

    public static  void sendUdpData(int numb)  {







            //100 режим часы
            //101 режим случайный
            //102 режимм ручной


            String s = "" + numb;
         //  System.out.println(s);
            data = s.getBytes();






                DatagramPacket pack = new DatagramPacket(data, data.length, addr, udp_port);
                try {
                    ds.send(pack);




                    Thread.sleep(100);

                } catch (Exception e) {
                    System.out.println(e);

                    GUI.jTextArea2.append("Cannot send UDP psck\r\n");
                }




    }



}
