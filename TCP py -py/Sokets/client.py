import tkinter as tk
import socket
import threading

# Crear la ventana principal
ventana = tk.Tk()
ventana.title("Interfaz de Chat")

# Variables globales
cliente = None
PORT = 3000  # Puerto predeterminado
NOMBRE = "Pepe"  # Nombre predefinido del usuario

# Función para recibir mensajes desde el servidor
def recibir_mensajes():
    while True:
        try:
            mensaje = cliente.recv(1024).decode("utf-8")
            textarea.insert(tk.END, f"Servidor: {mensaje}\n")
        except:
            textarea.insert(tk.END, "Conexión con el servidor cerrada.\n")
            cliente.close()
            break

# Función para conectar al servidor
def conectar():
    global cliente
    host_value = host.get()
    
    cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        cliente.connect((host_value, PORT))
        
        # Enviar el nombre predefinido al servidor
        cliente.sendall(NOMBRE.encode("utf-8"))

        # Iniciar el hilo para recibir mensajes
        hilo_recepcion = threading.Thread(target=recibir_mensajes)
        hilo_recepcion.daemon = True  # El hilo se cerrará al cerrar la ventana
        hilo_recepcion.start()
    except Exception as e:
        textarea.insert(tk.END, f"Error al conectar: {e}\n")

# Función para enviar mensajes
def enviar_mensaje(event=None):  # Añadir el argumento `event` para que funcione con el bind
    mensaje = mensaje_input.get()
    if mensaje and cliente:
        cliente.sendall(mensaje.encode("utf-8"))
        textarea.insert(tk.END, f"[TÚ]: {mensaje}\n")
        mensaje_input.delete(0, tk.END)

# Crear el frame para los widgets de host y conexión
conexion_frame = tk.Frame(ventana)
conexion_frame.pack(pady=5)

# Crear los labels y inputs para el host
host_label = tk.Label(conexion_frame, text="Host:")
host_label.pack(side=tk.LEFT, padx=5)
host = tk.Entry(conexion_frame)
host.pack(side=tk.LEFT, padx=5)

# Crear el botón de conexión
boton_conectar = tk.Button(conexion_frame, text="Conectar", command=conectar)
boton_conectar.pack(side=tk.LEFT, padx=5)

# Crear el textarea para mostrar los mensajes
textarea = tk.Text(ventana, height=10, width=50)
textarea.pack()

# Crear el input y el botón para enviar mensajes dentro de un frame
mensaje_frame = tk.Frame(ventana)
mensaje_frame.pack(pady=5)

mensaje_input = tk.Entry(mensaje_frame, width=40)
mensaje_input.pack(side=tk.LEFT, padx=5)

# Asociar el evento "Enter" al campo de entrada
mensaje_input.bind("<Return>", enviar_mensaje)

boton_enviar = tk.Button(mensaje_frame, text="Enviar", command=enviar_mensaje)
boton_enviar.pack(side=tk.RIGHT)

# Iniciar el bucle principal de la ventana
ventana.mainloop()
