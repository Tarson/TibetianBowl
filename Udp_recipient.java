
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class Udp_recipient extends Thread {

    int udp_port;
    InetAddress addr;
    String ip_address;

    DatagramSocket ds;
    DatagramPacket packet;
    Udp_recipient() {


        start();




        try {ds = new DatagramSocket(50000);
            packet = new DatagramPacket(new byte[1], 1);


        }
        catch (Exception e) {


            GUI.jTextArea2.append("Cannot create incoming\r\n");
            GUI.jTextArea2.append("UDP connection\r\n");


        }

    }
    public void run() {
        while (true) {
            try {


                ds.receive(packet);
                int t = packet.getData()[0];

                if(t==100){

                    GUI.jTextArea2.append("запущен режим часы"+ " \r\n");
                }
                if(t==101){
                    GUI.jTextArea2.append("запущен случайный режим "+ " \r\n");
                }

                if(t==102){
                    GUI.jTextArea2.append("запущен ручной режим "+ " \r\n");
                }
                if((t!=102)&(t!=101)&(t!=100)&(t>90)) {
                    GUI.jTextArea2.append("режим не запустился, жмакните еще раз       \r\n");

                }

                if(t<90){
                    GUI.jTextArea2.append("пауза  "+ t+" \r\n");
                }




            } catch (Exception e) {

              //  GUI.jTextArea2.append("no incoming packs"+ " \r\n");



            }

        }
    }


}

