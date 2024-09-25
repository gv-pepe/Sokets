import socket
import threading
from datetime import datetime

# Función para manejar clientes TCP
def handle_tcp_client(conn, addr, udp_sock):
    global udp_address  # Utilizamos la dirección UDP globalmente
    try:
        while True:
            try:
                data = conn.recv(1024)
                if not data:
                    break  # Salir del bucle si no se reciben datos (cliente desconectado)
                message = f"Datos recibidos del cliente TCP {addr}: {data.decode()}"
                print(message)
                
                # Guardar solo los datos recibidos en el archivo de log
                with open("logs.txt", "a") as log_file:
                    log_file.write(message + "\n")
                
                # Enviar el mensaje al cliente UDP, si la dirección UDP está asignada
                if udp_address:
                    udp_sock.sendto(data, udp_address)
            except ConnectionResetError:
                break  # Salir si hay un error de conexión (cliente cerrado abruptamente)
    finally:
        conn.close()  # Asegurar que la conexión TCP se cierre correctamente

# Función para manejar los mensajes UDP
def handle_udp_client(udp_sock):
    global udp_address  # Variable global para almacenar la dirección del cliente UDP
    udp_address = None
    while True:
        try:
            # Recibir datos del cliente UDP
            data, addr = udp_sock.recvfrom(1024)
            message = f"Datos recibidos del cliente UDP {addr}: {data.decode()}"
            print(message)

            # Guardar solo los datos recibidos en el archivo de log
            with open("logs.txt", "a") as log_file:
                log_file.write(message + "\n")

            # Asignar la dirección del cliente UDP la primera vez que se reciba un mensaje
            if udp_address is None:
                udp_address = addr

        except ConnectionResetError:
            continue

def tcp_udp_server():
    try:
        # Agregar la fecha al principio del archivo de log solo si es la primera vez
        with open("logs.txt", "a") as log_file:  # Cambié de "w" a "a" para evitar sobreescribir el archivo
            log_file.write(f"\nFecha de inicio del servidor: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n\n")

        # Configurar el socket TCP para escuchar conexiones
        tcp_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        tcp_sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)  # Permitir reutilización de la dirección
        tcp_sock.bind(('192.168.215.11', 65432))  # IP y puerto del servidor TCP
        tcp_sock.listen(5)  # El servidor puede aceptar hasta 5 conexiones TCP simultáneas

        # Configurar el socket UDP para escuchar mensajes
        udp_sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        udp_sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)  # Permitir reutilización de la dirección
        udp_sock.bind(('0.0.0.0', 65433))  # IP y puerto del servidor UDP

        print("Servidor TCP/UDP esperando conexiones...")

        # Hilo para manejar clientes UDP
        udp_thread = threading.Thread(target=handle_udp_client, args=(udp_sock,))
        udp_thread.daemon = True  # Esto permite que el hilo termine cuando el programa principal termine
        udp_thread.start()

        # Manejar conexiones TCP en el hilo principal
        while True:
            conn, addr = tcp_sock.accept()  # Aceptar nuevas conexiones TCP
            client_thread = threading.Thread(target=handle_tcp_client, args=(conn, addr, udp_sock))
            client_thread.daemon = True  # Permite que el hilo termine cuando el programa principal lo haga
            client_thread.start()
    except Exception as e:
        print(f"Error en el servidor: {e}")
    finally:
        tcp_sock.close()  # Asegurar que el socket TCP se cierra correctamente
        udp_sock.close()  # Asegurar que el socket UDP se cierra correctamente

if __name__ == "__main__":
    tcp_udp_server()
