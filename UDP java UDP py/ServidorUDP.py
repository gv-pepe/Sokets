import socket
import socketserver #para manejar la comunicación UDP.
import threading #permitir la ejecución concurrente
import tkinter as tk
from tkinter import scrolledtext

class ThreadedUDPServer(socketserver.ThreadingMixIn, socketserver.UDPServer): #permite que el servidor maneje múltiples clientes simultáneamente mediante la creación de un nuevo hilo para cada cliente.
    pass

class ThreadedUDPRequestHandler(socketserver.BaseRequestHandler):
    def handle(self):
        data = self.request[0].strip() #contiene los datos recibidos del cliente.
        socket = self.request[1] #es el socket a través del cual se envían y reciben los datos.
        response = "Mensaje recibido en el servidor".encode() #es el mensaje de respuesta que se envía de vuelta al cliente.
        socket.sendto(response, self.client_address)
        app.update_text(f"Recibido {data} desde {self.client_address}\nEnviado {response} de vuelta a {self.client_address}\n")

class UDPServerApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Servidor UDP")
        
        self.text_area = scrolledtext.ScrolledText(master, wrap=tk.WORD, width=50, height=20)
        self.text_area.pack()
        
        self.start_button = tk.Button(master, text="Iniciar Servidor", command=self.start_server)
        self.start_button.pack()
        
    def start_server(self):
        self.server_thread = threading.Thread(target=self.run_server)
        self.server_thread.daemon = True
        self.server_thread.start()
        
    def run_server(self): #configura y ejecuta el servidor UDP.
        server_address = ('192.168.1.70', 5000) #direccion IP y puerto
        self.server = ThreadedUDPServer(server_address, ThreadedUDPRequestHandler)
        self.server.serve_forever()
        
    def update_text(self, message):
        self.text_area.insert(tk.END, message)
        self.text_area.see(tk.END)

if __name__ == "__main__": #crea una instancia de UDPServerApp y ejecuta el bucle principal
    root = tk.Tk()
    app = UDPServerApp(root)
    root.mainloop()
