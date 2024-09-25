package clienteudpjava;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDPJava {
    public static void main(String[] args) {
        try {
            // Crear un socket UDP
            DatagramSocket socket = new DatagramSocket();  // Sin puerto fijo, el sistema asignará uno
            byte[] buffer = new byte[1024];

            InetAddress serverAddress = InetAddress.getByName("192.168.215.11");  // IP del servidor TCP/UDP
            int serverPort = 65433;  // Puerto del servidor UDP

            // Hilo para recibir mensajes del servidor TCP/UDP
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        socket.receive(packet);  // Recibir datos del servidor
                        String receivedData = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("Mensaje recibido del servidor: " + receivedData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Ciclo para enviar mensajes al servidor TCP/UDP
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Escribe un mensaje para enviar al servidor: ");
                String message = scanner.nextLine();
                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), serverAddress, serverPort);
                socket.send(packet);  // Enviar mensaje al servidor
                System.out.println("Mensaje enviado al servidor: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
