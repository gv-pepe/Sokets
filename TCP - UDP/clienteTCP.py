import socket

def tcp_client():
    # Configurar cliente TCP
    tcp_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    tcp_sock.connect(('192.168.215.11', 65432))  # Conectarse al servidor TCP

    try:
        while True:
            message = input("Escribe un mensaje para enviar al servidor: ")
            if message.lower() == 'exit':
                break
            
            # Enviar datos al servidor TCP
            tcp_sock.sendall(message.encode())
            print(f"Mensaje enviado: {message}")
    except Exception as e:
        print(f"Error: {e}")
    finally:
        tcp_sock.close()

if __name__ == "__main__":
    tcp_client()

