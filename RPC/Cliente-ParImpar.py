import xmlrpc.client

server = xmlrpc.client.ServerProxy('http://localhost:8080')

print("Consultar si el número es par o impar")
print("Ingrese  número: ")
num=input()

print (server.parimpar(int(num)))

print("\nPresione cualquier tecla para finalizar...")
intro=input()
