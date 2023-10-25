from funciones import separador

productos = [
    ["Licuadora", 10, "Electrodomésticos", 59.99],
    ["Horno", 5, "Electrodomésticos", 249.99],
    ["Batidora", 15, "Electrodomésticos", 39.99],
    ["Sartén", 20, "Artículos de Cocina", 19.99],
    ["Microondas", 8, "Electrodomésticos", 129.99],
    ["Olla", 12, "Artículos de Cocina", 29.99],
    ["Freidora", 7, "Electrodomésticos", 79.99],
    ["Refractario", 25, "Artículos de Cocina", 14.99],
    ["Parrilla", 6, "Electrodomésticos", 89.99],
    ["Rebanador", 3, "Electrodomésticos", 49.99],
    ["Kit Cubiertos", 18, "Artículos de Cocina", 24.99],
    ["Cuchillo de Cocina", 30, "Artículos de Cocina", 9.99]
]


Carrito = []
'''
class Carrito:
    def __init__(self):
        self.head = None
'''

archivo_txt = "INVENTARIO.txt"

def cargar_datos():
    try:
        with open(archivo_txt, "r") as file:
            data = [line.strip().split(",") for line in file.readlines()]
            return data
    except FileNotFoundError:
        return []

def guardar_datos(archivo_txt, datos):
    with open(archivo_txt, "w") as file:
        for producto in datos:
            file.write(",".join(map(str, producto)) + "\n")

archivo_txt = "INVENTARIO.txt"
datos_inventario = cargar_datos()
      

def agregar_producto(nombre, cantidad, categoria, precio):
    nuevo_producto = [nombre, cantidad, categoria, precio]
    productos.append(nuevo_producto)

def eliminar_producto(nombre):
    for producto in productos:
        if producto[0] == nombre:
            productos.remove(producto)

def mostrar_productos():
    for producto in productos:
        print(f"Nombre: {producto[0]}, Cantidad: {producto[1]}, Categoria: {producto[2]}, Precio: {producto[3]}")

def cargar_datos():
    try:
        with open(archivo_txt, "r") as file:
            data = [line.strip().split(",") for line in file.readlines()]
            return data
    except FileNotFoundError:
        return []

def guardar_datos(datos):
    with open(archivo_txt, "w") as file:
        for producto in datos:
            file.write(",".join(map(str, producto)) + "\n")

'''
2 funciones
'''

def agregar_al_carrito():
    producto_comprar = input("Ingrese el producto que desea comprar: ")
    cantidad = int(input("Ingrese la cantidad que desea comprar: "))
    found = False

    for lista in productos:
        if producto_comprar == lista[0]:  # Si el producto está en la lista de productos
            found = True
            if cantidad <= lista[1]:  # Si hay suficiente cantidad disponible
                lista[1] -= cantidad  # Reducir la cantidad disponible en la lista de productos
                for producto in Carrito:
                    if producto_comprar == producto[0]:  # Si el producto ya está en el carrito
                        producto[1] += cantidad  # Aumentar la cantidad en el carrito
                        return
                else:  # Si el producto no estaba en el carrito
                    Carrito.append([producto_comprar, cantidad, lista[2], lista[3]])
                return
            else:  # Si no hay suficiente cantidad disponible
                print("")
                print(f"Sólo hay {lista[1]} unidades de {producto_comprar} disponibles.")
                return

    if not found:
        print("")
        print("Este producto no se encuentra disponible.")



def eliminar_del_carrito():
    producto_eliminar = input("Ingrese el producto que desea eliminar: ")
    cantidad = int(input("Ingrese la cantidad que desea eliminar: "))
    found = False
    for lista in Carrito:
        if producto_eliminar in lista[0]:
            if cantidad >= lista[1]:
                Carrito.remove(lista)
                print(Carrito)
                found = True
                return lista
            else:
                lista[1] -= cantidad
                print(Carrito)
                found = True
                return lista
    if found is False:
      print("")
      print("Este producto no se encuentra en el carrito.")


def total_a_pagar():
  print("")
  pagar = 0.0
  resultado = 0.0
  for producto in Carrito:
    resultado = producto[3] * float(producto[1])
    pagar += producto[3]*float(producto[1])
    print(f"{producto[3]} * {producto[1]} = {resultado}")
  pagar = round(pagar,2)
  while True:
    separador()
    print("Desearia pagar?")
    separador()
    print("\n1. Si")
    print("\n2. No")
    separador()
    compra = int(input(""))
    if compra == 1:
      separador()
      print("Que metodo desea utilizar?")
      separador()
      print("\n1. Tarjeta de Credito")
      print("\n2. Efectivo")
      separador()
      metodo = int(input(""))
      separador()
      print("Por favor, ingrese los siguientes datos:")
      separador()
      print("\n Nombre completo:")
      name = str(input(""))
      print("\n Numero de Identificacion:")
      id = int(input(""))
      print("\n Departamento:")
      dept = str(input(""))
      print("\n Ciudad:")
      cit = str(input(""))
      print("\n Direccion:")
      dir = str(input(""))
      print("\n Barrio:")
      bar = str(input(""))
      print("\n Numero de Telefono")
      cel = int(input(""))
      separador()
      print(f"El total a pagar es: {pagar} y fue pagado!")
      print("Esta es su factura")
      separador()
      print(name)
      print(id)
      print(dept)
      print(cit)
      print(dir)
      print(bar)
      print(cel)
      print("Total a pagar:", {pagar})
      separador()
      return pagar
    if compra == 2:
      print("Listo!")
      return 
    else:
      break
    
  

def order_by_category():
    filtro = input("Ingrese la categoria que desea filtrar: ")
    found = False
    for lista in datos_inventario:
        if filtro in lista[2]:
            print(f"Nombre: {lista[0]}, Cantidad: {lista[1]}, Categoria: {lista[2]}, Precio: {lista[3]}")
            found = True
    if found is False:
        print("Esta categoria no se encuentra disponible.")
      
      
def order_by_price(sentido=True):
    lista_precio = sorted(productos, key=lambda x: x[3], reverse= not sentido)
    for producto in lista_precio:
        print(f"Nombre: {producto[0]}, Cantidad: {producto[1]}, Categoria: {producto[2]}, Precio: {producto [3]}")


def order_by_quantity(sentido=True):
    lista_cantidad = sorted(productos, key=lambda x: x[1], reverse=not sentido)
    for producto in lista_cantidad:
        print(f"Nombre: {producto[0]}, Cantidad: {producto[1]}, Categoria: {producto[2]}, Precio: {producto [3]}")