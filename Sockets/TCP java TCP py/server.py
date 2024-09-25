import socket
import threading

HOST = "0.0.0.0"  # Dirección del servidor
PORT = 3001  # Puerto del servidor

clientes = []

# Inicializar servidor con manejo de excepciones
try:
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Crea un socket TCP
    server.bind((HOST, PORT))  # Asocia el socket a la dirección y puerto
    server.listen(5)  # Pone el socket en modo escucha
    print(f"[SERVIDOR] Servidor iniciado en {HOST}:{PORT}")
except socket.error as e:
    print(f"[ERROR] Error al iniciar el servidor: {e}")
    exit(1)

# Función para enviar un mensaje a todos los clientes excepto al que lo envió
def enviarMensaje(mensaje, cliente):
    for otro_cliente in clientes:
        if otro_cliente != cliente:
            try:
                otro_cliente.sendall(mensaje.encode("utf-8"))
            except socket.error as e:
                print(f"[ERROR] No se pudo enviar mensaje al cliente: {e}")
                otro_cliente.close()
                if otro_cliente in clientes:
                    clientes.remove(otro_cliente)

# Función para manejar la interacción con un cliente
def atender_cliente(cliente):
    try:
        nombre = cliente.recv(1024).decode("utf-8")
        if not nombre:
            raise ValueError("Nombre de cliente vacío")
        print(f"[{nombre} conectado]")
        respuesta = f"Tu nombre es {nombre}"
        cliente.sendall(respuesta.encode("utf-8"))
        enviarMensaje(f"[{nombre} se ha conectado]", cliente)
    except (socket.error, ValueError) as e:
        print(f"[ERROR] Error durante la conexión inicial: {e}")
        cliente.close()
        return

    while True:
        try:
            # Recibe el mensaje del cliente
            mensaje = cliente.recv(1024).decode("utf-8")
            if not mensaje:
                raise ConnectionResetError
            print(f"[{nombre}] {mensaje}")
            enviarMensaje(f"[{nombre}] {mensaje}", cliente)
        except (ConnectionResetError, socket.error):
            # Maneja desconexión o error en la comunicación
            cliente.close()
            if cliente in clientes:
                clientes.remove(cliente)
            enviarMensaje(f"[{nombre} se ha desconectado]", cliente)
            print(f"[{nombre} desconectado]")
            break

# Ciclo principal del servidor para aceptar nuevas conexiones
while True:
    try:
        # Acepta una conexión entrante del cliente
        cliente, direccion = server.accept()
        print(f"[CONEXIÓN] Cliente conectado desde {direccion}")
        
        clientes.append(cliente)

        # Crea un hilo para atender al cliente
        hilo_cliente = threading.Thread(target=atender_cliente, args=(cliente,))
        hilo_cliente.start()
    except socket.error as e:
        print(f"[ERROR] Error al aceptar cliente: {e}")
    except KeyboardInterrupt:
        print("[SERVIDOR] Apagando servidor...")
        for cliente in clientes:
            cliente.close()
        server.close()
        break
