import xmlrpc.client

server = xmlrpc.client.ServerProxy('http://localhost:8080')

print("Calculadora RPC (suma, resta, division y multiplicacion)")
print("Ingrese primer número: ")
primerNumero=input()
print("Ingrese segundo número: ")
segundoNumero=input()


print("\nCalculando la suma... ")
print ("El resultado es: "+str(server.suma(int(primerNumero), int(segundoNumero))))

print("\nCalculando la resta... ")
print ("El resultado es: "+str(server.resta(int(primerNumero), int(segundoNumero))))

print("\nCalculando la división... ")
print ("El resultado es: "+str(server.division(int(primerNumero), int(segundoNumero))))

print("\nCalculando la multiplicación...")
print ("El resultado es: "+str(server.multiplicacion(int(primerNumero), int(segundoNumero))))

print("Presione cualquier tecla para finalizar....")
intro=input() 


