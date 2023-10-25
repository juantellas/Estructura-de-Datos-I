import matplotlib.pyplot as plt
def separador():
    print("-" * 40)

def checkDecision(num):
    desc = int(num)
    if desc == 1 or desc == 2:
        return desc
    else:
        return "Error: Por favor, ingrese 1 o 2."

def checkPassword(password):
  contraseñaAdmin="12345"
  if password==contraseñaAdmin:
    return "Acceso Concedido"

def checkDecisionAdmin(descMenu):
  if descMenu!=1 and descMenu!=2 and descMenu!=3: 
    return 

def checkDecisionAE(descAE):
    if descAE == 1 or descAE == 2:
        return 

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


