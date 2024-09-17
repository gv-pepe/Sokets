import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatCliente {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private Socket socket;
    private PrintWriter outputStream;
    private BufferedReader inputStream;

    private static final String NOMBRE = "PEPE";  // Nombre del cliente

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ChatCliente window = new ChatCliente();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChatCliente() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        // Panel para el campo de texto y el botón de enviar
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        textField = new JTextField();
        textField.setColumns(30);
        panel.add(textField);

        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        panel.add(sendButton);

        // Conectar al servidor
        connectToServer("localhost", 3000);
    }

    private void connectToServer(String host, int port) {
        try {
            socket = new Socket(host, port);
            outputStream = new PrintWriter(socket.getOutputStream(), true);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enviar el nombre del cliente al servidor
            outputStream.println(NOMBRE);

            // Iniciar un hilo para escuchar mensajes entrantes
            new Thread(new IncomingMessageListener()).start();

        } catch (IOException e) {
            e.printStackTrace();
            textArea.append("Error al conectar al servidor.\n");
        }
    }

    private void sendMessage() {
        String message = textField.getText().trim(); // Trim leading/trailing spaces
        if (message.length() > 0) {
            try {
                outputStream.println(message); // Send message without extra newlines
                textArea.append(NOMBRE + ": " + message + "\n");
                textField.setText(""); // Limpiar el campo de texto después de enviar el mensaje
            } catch (Exception e) {
                e.printStackTrace();
                textArea.append("Error al enviar el mensaje.\n");
            }
        }
    }

    private class IncomingMessageListener implements Runnable {
        @Override
        public void run() {
            try {
                String message;
                while ((message = inputStream.readLine()) != null) {
                    textArea.append("Servidor: " + message.trim() + "\n"); // Trim any extra newlines
                }
            } catch (IOException e) {
                e.printStackTrace();
                textArea.append("Conexión con el servidor cerrada.\n");
            }
        }
    }
}
