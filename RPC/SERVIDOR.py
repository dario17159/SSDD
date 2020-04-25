from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

with SimpleXMLRPCServer(('localhost', 8080),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    print("Servidor corriendo en el puerto 8080")
   
    class MyFuncs:
        def suma(self,x,y): return x+y
        def resta(self, x,y): return x-y
        def division(self, x,y): return x/y
        def multiplicacion(self, x, y):   return x * y
        def parimpar(self,x): 
            if x % 2 == 0:
                return 'El número es par'
            else:
                return 'El número es impar'

    server.register_instance(MyFuncs())
    server.serve_forever()
