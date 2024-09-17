import socket
import threading

# Función para manejar clientes TCP
def handle_tcp_client(conn, addr, udp_sock, udp_address):
    print(f"Conexión TCP establecida con {addr}")
    while True:
        try:
            data = conn.recv(1024)
            if not data:
                print(f"Conexión TCP cerrada con {addr}")
                break
            print(f"Datos recibidos del cliente TCP {addr}: {data.decode()}")
            
            # Enviar el mensaje al cliente UDP
            try:
                udp_sock.sendto(data, udp_address)
               
            except socket.error as e:
                print()
        except ConnectionResetError:
            print(f"Error de conexión con el cliente TCP {addr}")
            break
    conn.close()

# Función para manejar los mensajes UDP
def handle_udp_client(udp_sock):
    while True:
        try:
            # Recibir datos del cliente UDP
            data, addr = udp_sock.recvfrom(1024)
            print(f"Datos recibidos del cliente UDP {addr}: {data.decode()}")
        except ConnectionResetError as e:
            
            continue

def tcp_udp_server():
    # Configurar el socket TCP para escuchar conexiones
    tcp_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    tcp_sock.bind(('192.168.215.11', 65432))  # IP y puerto del servidor TCP
    tcp_sock.listen(5)  # El servidor puede aceptar hasta 5 conexiones TCP simultáneas

    # Configurar el socket UDP para escuchar mensajes
    udp_sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_sock.bind(('0.0.0.0', 65433))  # IP y puerto del servidor UDP

    print("Servidor TCP/UDP esperando conexiones...")

    # Hilo para manejar clientes UDP
    udp_thread = threading.Thread(target=handle_udp_client, args=(udp_sock,))
    udp_thread.start()

    # Manejar conexiones TCP en el hilo principal
    while True:
        conn, addr = tcp_sock.accept()  # Aceptar nuevas conexiones TCP
        # Puedes reenviar mensajes TCP a una dirección UDP
        udp_address = ('0.0.0.0', 65433)  # IP del cliente UDP (asegúrate que este sea correcto)
        client_thread = threading.Thread(target=handle_tcp_client, args=(conn, addr, udp_sock, udp_address))
        client_thread.start()

if __name__ == "__main__":
    tcp_udp_server()
