"""
 Implements a simple socket server

"""

import socket
import csv


csv_reader = None
stack = []
reverse_stack = []
with open('Dados_Teste_Processo2.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')

    for row in csv_reader:
        row[0] = row[0][1:]
        row[16] = row[16][:-1]
        stack.append(row)


def send_client_tuples(svr_socket):
    # Wait for client connections
    client_connection, client_address = svr_socket.accept()
    print("CLIENT IS IN")
    while True:
        accept = client_connection.recv(1024).decode()
        print(accept)
        if len(stack) > 0:
            line = stack.pop(0)
            reverse_stack.append(line)
        else:
            line = reverse_stack.pop(0)
            stack.append(line)

        print(line)
        client_connection.sendall(",".join(line).encode())
        print("closed connection")
        client_connection.close()
        break


# Define socket host and port
SERVER_HOST = '0.0.0.0'
SERVER_PORT = 8000

# Create socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server_socket.bind((SERVER_HOST, SERVER_PORT))
server_socket.listen(1)
print('Listening on port %s ... and ip %s', SERVER_PORT, SERVER_HOST)

while True:
    # Reads
    send_client_tuples(server_socket)

# Close socket
server_socket.close()
