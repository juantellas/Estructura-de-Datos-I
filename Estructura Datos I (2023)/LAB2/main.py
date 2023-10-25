import matplotlib.pyplot as plt

from funciones import checkDecisionAE, checkPassword, separador
from carrito import agregar_al_carrito, eliminar_del_carrito, total_a_pagar, order_by_category, order_by_price, order_by_quantity

archivo_txt = "INVENTARIO.txt"
contraseñaAdmin="12345"

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

datos_inventario = cargar_datos()


nombres_productos = ["Licuadora", "Horno", "Batidora", "Sartén", "Microondas", "Olla", "Freidora", "Refractario", "Parrilla", "Rebanador", "Kit Cubiertos", "Cuchillo de Cocina"]
cantidades = [10, 5, 15, 20, 8, 12, 7, 25, 6, 3, 18, 30]
precios = [59.99, 249.99, 39.99, 19.99, 129.99, 29.99, 79.99, 14.99, 89.99, 49.99, 24.99, 9.99]


def grafico_barras_cantidad():
    nombres_productos = [row[0] for row in datos_inventario[2:]]
    cantidades = [int(row[1]) for row in datos_inventario[2:]]
    
    plt.figure(figsize=(10, 6))
    plt.barh(nombres_productos, cantidades)
    plt.xlabel("Cantidad")
    plt.ylabel("Producto")
    plt.title("Cantidad de Productos en Inventario")
    plt.show()

def grafico_lineas_precios():
    plt.figure(figsize=(10, 6))
    plt.plot(nombres_productos, precios, marker='o', linestyle='-')
    plt.xlabel("Producto")
    plt.ylabel("Precio ($)")
    plt.title("Variación de Precios de Productos")
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.show()

def grafico_pastel_categorias():
    plt.figure(figsize=(6, 6))
    plt.pie(cantidad_por_categoria, labels=categorias, autopct='%1.1f%%', startangle=140)
    plt.title("Distribución de Productos por Categoría")
    plt.show()

def agregar_producto(nombre, cantidad, categoria, precio):
    nuevo_producto = [nombre, cantidad, categoria, precio]
    datos_inventario.append(nuevo_producto)
    guardar_datos(archivo_txt,datos_inventario)

def eliminar_producto(nombre):
    global datos_inventario
    datos_inventario = [row for row in datos_inventario if row[0] != nombre]
    guardar_datos(archivo_txt,datos_inventario)

def mostrar_productos():
    for producto in datos_inventario:
        print(f"Nombre: {producto[0]}, Cantidad: {producto[1]}, Categoria: {producto[2]}, Precio: {producto[3]}")



while True:
    print("Iniciando carrito de compras...")
    separador()


    print("¡Bienvenido a la tienda de electrodomésticos ElectroHogar!")
    print("Por favor, ingrese su usuario:")
    user = str(input(""))
    separador()
    print("¿Desea ingresar como:")
    print("\n1. Administrador")
    print("\n2. Cliente")
    print("\n3. Salir")
    separador()

    desc = int(input(""))

    if desc == 1:
        print("Elegiste: Administrador")
        separador()
        print("Ingrese su contraseña:")
        password = str(input(""))
        checkPassword(password)

        while contraseñaAdmin != password:
            separador()
            print("ERROR: Contraseña incorrecta, por favor, ingresar de nuevo.")
            separador()
            password = str(input(""))
            checkPassword(password)

        if contraseñaAdmin == password:
            while True:
                separador()
                print("Acceso Concedido ,", user, ", por favor, ingrese la opción deseada:")
                print("\n1. Agregar/Eliminar Productos.")
                print("\n2. Visualizar Informacion del archivo de Inventario.")
                print("\n3. Volver al Menú Principal")
                separador()
                descMenu = int(input(""))

                if descMenu == 1:
                    while True:
                        separador()
                        print("Seleccionaste: Agregar/Eliminar Producto")
                        separador()
                        mostrar_productos()
                        separador()
                        print("¿Qué acción desea tomar?")
                        print("\n1. Agregar Producto")
                        print("\n2. Eliminar Producto")
                        print("\n3. Volver al Menú Administrador")
                        separador()
                        descAE = int(input(""))
                        checkDecisionAE(descAE)

                        if descAE == 1:
                            print("Ingrese los datos del producto que desee añadir:")
                            nom = str(input("\nNombre: "))
                            cant = int(input("\nCantidad: "))
                            cat = str(input("\nCategoria: "))
                            pre = float(input("\nPrecio: "))
                            agregar_producto(nom, cant, cat, pre)
                            nombres_productos.append(nom)
                            cantidades.append(cant)
                            precios.append(pre)
                            separador()
                            print("Se ha agregado ", nom,"al inventario.")
                            guardar_datos(archivo_txt,datos_inventario)
                            


                        elif descAE == 2:
                            print("Ingrese el nombre del producto que desee eliminar:")
                            eliminar = str(input(""))
                            eliminar_producto(eliminar)
                            separador()
                            print("Se ha eliminado el producto ",eliminar)

                        elif descAE == 3:
                            break

                elif descMenu == 2:
                    separador()
                    print("Seleccionaste: Visualizar Informacion")
                    separador()
                    print("Seleccione una de las siguientes opciones:")
                    print("\n1. Grafica de barras de la cantidad de productos.")
                    print("\n2. Diferencia de precios entre productos.")
                    separador()
                    descGraph=int(input(""))
                  
                    if descGraph==1:
                      grafico_barras_cantidad()
                      break

                    if descGraph==2:
                      grafico_lineas_precios()
                      break

                    else:
                      break

                elif descMenu == 3:
                    break

    elif desc == 2:
        print("Elegiste: Cliente")
        while True:
          separador()
          print("Estimado,",user,", Seleccione una de las siguientes opciones:")
          print("\n1. Ver todos los productos.")
          print("\n2. Ver productos detalladamente.")
          print("\n3. Añadir productos en el carrito.")
          print("\n4. Eliminar productos del carrito.")
          print("\n5. Ver total y pagar.")
          print("\n6. Salir.")
          separador()
          descCL = int(input(""))
          
          if descCL == 1:
              print("Elegiste: Ver productos.")
              separador()
              mostrar_productos()
              separador()
  
  
            
          if descCL == 2:
              print("Elegiste: Ver productos detalladamente.")
              separador()
              print("Escoja una de las siguientes opciones:")
              separador()
              print("\n1. Filtrar por categoria.")
              print("\n2. Filtrar por Precio (ascendente)")
              print("\n3. Filtrar por Precio (descendente)")
              print("\n4. Filtrar por Cantidad (ascendente)")
              print("\n5. Filtrar por Cantidad (descendente)")
              print("\n6. Salir al Menu de Clientes")
              separador()
              descVER= int(input(""))
              if descVER == 1:
                print("\n")
                order_by_category()
                print("\n")
                separador()
              
              if descVER == 2:
                print("\n")
                order_by_price()
                print("\n")
                separador()

              if descVER == 3:
                print("\n")
                order_by_price(False)
                print("\n")
                separador()
                
              if descVER == 4:
                print("\n")
                order_by_quantity()
                print("\n")
                separador()
                
              if descVER == 5:
                print("\n")
                order_by_quantity(False)
                print("\n")
                separador()
                
              if descVER == 6:
                break
                exit()
                
              if descVER!=1 and descVER!=2 and descVER!=3 and descVER!=4 and descVER!=5 and descVER!=6:
                print("ERROR: Opción no válida, por favor, ingresar de nuevo.")
              
          if descCL == 3:
              print("Elegiste: Añadir productos en el carrito.")
              separador()
              agregar_al_carrito() 
              separador()
              
            
          if descCL == 4:
              print("Elegiste: Eliminar productos del carrito.")
              separador()
              eliminar_del_carrito()
              separador()
              
          if descCL == 5:
              print("Elegiste: Ver total y pagar.")
              separador()
              print("Aqui te dejamos un resumen de tu pedido:")
              total_a_pagar()
              separador()
              
              
          if descCL == 6:
              separador()
              print("Hasta luego, ¡Gracias por comprar con nosotros!")
              break
    
    
    elif desc == 3:
      separador()
      print("Hasta luego, ¡Gracias por comprar con nosotros!")
      exit()

    else:
        print("ERROR: Opción no válida, por favor, ingresar de nuevo.")
