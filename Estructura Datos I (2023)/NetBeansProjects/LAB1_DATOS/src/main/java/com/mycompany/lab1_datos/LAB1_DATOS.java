/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab1_datos;

import static com.mycompany.lab1_datos.Codigo.generarCodigo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;
import java.util.*;
import java.text.DecimalFormat;
import java.io.File;

/**
 *
 * @author Felipe Barrios y Juan Aguirre
 */
public class LAB1_DATOS {

    public static void main(String[] args) {
        try {
            // Rutas de los archivos de entrada y salida de Empleados y Vendedores
            String rutaEmpleados = "C:/Users/LENOVO V14-G2/Documents/labo1/Empleados.csv";

            String rutaVentas = "C:/Users/LENOVO V14-G2/Documents/labo1/Ventas.csv";
            String rutaEmpleadosNoEliminados = "C:/Users/LENOVO V14-G2/Documents/labo1/EmpleadosNoEliminados.csv";

            /* Leer los datos de los Empleados y las Ventas, para esto utilizamos la libreria BufferReades y FileReader, las cuales tiene 
                una excepción que manoejamos con un try-catch
             */
            BufferedReader brEmpleados = new BufferedReader(new FileReader(rutaEmpleados));
            String lineEmpleados;

            File archivoVentas = new File(rutaVentas);
            archivoVentas.createNewFile(); // Crea el archivo si no existe

            BufferedWriter bwVentas = new BufferedWriter(new FileWriter(rutaVentas));

            BufferedReader brVentas = new BufferedReader(new FileReader(rutaVentas));
            String lineVentas;
            /* Crear una lista dinámica para almacenar la información de los Empleados, para esto usamos un arreglo dinámico
                puesto que no sabemos la longitud del arreglo y ademas este permite que si se ingresen mas datos el programa
                no se modifique
             */

            List<VentasInfo> VentasList = new ArrayList<>();
            List<EmpleadosInfo> EmpleadosList = new ArrayList<>();

            while ((lineEmpleados = brEmpleados.readLine()) != null) {
                String[] campos = lineEmpleados.split(",");
                // Verificar si el arreglo campos tiene elementos antes de acceder a ellos
                if (campos.length >= 7) { // Asumiendo que necesitas al menos 7 campos
                    String Nombre = campos[0];
                    String Cedula = campos[1];
                    String Cargo = campos[2];
                    String Telefono_de_contacto = campos[3];
                    String Fecha_de_ingreso = campos[4];
                    int Salario_Fijo = Integer.parseInt(campos[5]);
                    int Comisiones = Integer.parseInt(campos[6]);
                    EmpleadosList.add(new EmpleadosInfo(Nombre, Cedula, Cargo, Telefono_de_contacto, Fecha_de_ingreso, Salario_Fijo, Comisiones));
                } else {
                    // Manejar el caso en el que no haya suficientes campos en la línea
                    System.err.println("Error: No hay suficientes campos en la línea: " + lineEmpleados);
                }
            }
            //cerramos la variable brEmpleados
            brEmpleados.close();

            //-------------------------------------------------------------------------------------------------------------------
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

            // Agregar un menú para que el usuario pueda elegir opciones
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenú:");
                System.out.println(" (para el archivo de Empleados)");
                System.out.println("0. Mostrar el archivo de Empleados");
                System.out.println("1. Agregar un nuevo registro en el archivo Empleados");
                System.out.println("2. Eliminar un registro en el archivo Empleados");
                System.out.println("3. Organizar el archivo empleados por nombre o por salario");
                System.out.println(" --------------------------------------------------------- ");
                System.out.println("4. Añadir un nuevo registro en el archivo Ventas ");
                System.out.println("5. Eliminar un registro en el archivo Ventas ");
                System.out.println("6. Organizar el archivo segun Tipos de autos, cantidad vendida o valor total");
                System.out.println("7. Actualizar el archivo Empleados con sus respectivas comisiones");
                System.out.println("8. Mostrar el archivo de Ventas");
                System.out.println("9. Salir");
                System.out.println("");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();  // Leer la opción ingresada por el usuario

                // Realizar acciones según la opción seleccionada
                switch (opcion) {

                    case 0: //mostrar la lista del registro
                        System.out.println("");
                        System.out.println("Lista de Empleados:");
                        for (EmpleadosInfo Empleado : EmpleadosList) {
                            System.out.println("Nombre: " + Empleado.getNombre() + ", Cédula: " + Empleado.getCedula() + ", Cargo: " + Empleado.getCargo() + ", Telefono_de_contacto: " + Empleado.getTelefono_de_contacto() + ", Fecha_de_Ingreso: " + Empleado.getFecha_de_ingreso() + ", Salario_Fijo: $" + Empleado.getSalario_Fijo() + ", Comisiones: $" + Empleado.getSalario_Fijo());
                        }
                        break;

                    case 1: // Agregar un nuevo registro
                        System.out.println("Nombre del vendedor: ");
                        String nombreV;
                        do {
                            nombreV = scanner.next();
                            if (!nombreV.matches("[a-zA-Z]+")) {
                                System.out.println("Ingrese un nombre válido (solo letras).");
                            }
                        } while (!nombreV.matches("[a-zA-Z]+"));

                        System.out.println("Ingrese la cédula (solo números): ");
                        String cedulaV;
                        do {
                            cedulaV = scanner.next();
                            if (!cedulaV.matches("\\d+")) {
                                System.out.println("Ingrese una cédula válida (solo números).");
                            }
                        } while (!cedulaV.matches("\\d+"));

                        System.out.println("Ingrese el cargo (solo letras): ");
                        String cargoV;
                        do {
                            cargoV = scanner.next();
                            if (!cargoV.matches("[a-zA-Z]+")) {
                                System.out.println("Ingrese un cargo válido (solo letras).");
                            }
                        } while (!cargoV.matches("[a-zA-Z]+"));

                        System.out.println("Ingrese el teléfono (solo números): ");
                        String telefonoV;
                        do {
                            telefonoV = scanner.next();
                            if (!telefonoV.matches("\\d+")) {
                                System.out.println("Ingrese un teléfono válido (solo números).");
                            }
                        } while (!telefonoV.matches("\\d+"));

                        System.out.println("Ingrese la fecha de ingreso (solo números, y en formato dd/mm/aaaa ): ");
                        String fechaIngresoV;
                        do {
                            fechaIngresoV = scanner.next();
                            if (!fechaIngresoV.matches("\\d+")) {
                                System.out.println("Ingrese una fecha de ingreso válida (solo números).");
                            }
                        } while (!fechaIngresoV.matches("\\d+"));

                        System.out.println("Ingrese el salario (solo números): ");
                        int salarioFijoV;
                        do {
                            while (!scanner.hasNextInt()) {
                                System.out.println("Ingrese un salario válido (solo números).");
                                scanner.next(); // Limpiar la entrada no válida
                            }
                            salarioFijoV = scanner.nextInt();
                        } while (salarioFijoV <= 0);

                        EmpleadosInfo NuevoEmpleado = new EmpleadosInfo(nombreV, cedulaV, cargoV, telefonoV, fechaIngresoV, salarioFijoV, salarioFijoV);
                        EmpleadosList.add(NuevoEmpleado);
                        System.out.println("Registro Agregado con éxito");

                        try {
                            // Escribir la información del empleado en el archivo
                            BufferedWriter bwEmpleados = new BufferedWriter(new FileWriter(rutaEmpleados, true)); // Utilizamos "true" para agregar al final del archivo
                            bwEmpleados.write(NuevoEmpleado.getNombre() + "," + NuevoEmpleado.getCedula() + "," + NuevoEmpleado.getCargo() + "," + NuevoEmpleado.getTelefono_de_contacto() + "," + NuevoEmpleado.getFecha_de_ingreso() + "," + NuevoEmpleado.getSalario_Fijo() + "," + NuevoEmpleado.getComisiones() + "\n");
                            bwEmpleados.close();
                            System.out.println("Base de datos de empleados actualizada y guardada en " + rutaEmpleados);
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo.");
                        }
                        break;

                    case 2: // Eliminar un registro

                        brEmpleados.close();
                        brEmpleados = new BufferedReader(new FileReader(rutaEmpleados));

                        System.out.println("");
                        System.out.println("Ingrese la cédula (solo números): ");
                        do {
                            cedulaV = scanner.next();
                            if (!cedulaV.matches("\\d+")) {
                                System.out.println("Ingrese una cédula válida (solo números).");
                            }
                        } while (!cedulaV.matches("\\d+"));
                        String cedulaVE = scanner.next();
                        EmpleadosInfo EmpleadoEliminar = null;
                        for (EmpleadosInfo empleado : EmpleadosList) {
                            if (empleado.getCedula().equals(cedulaVE)) {
                                EmpleadoEliminar = empleado;
                                break;
                            }
                        }
                        if (EmpleadoEliminar != null) {
                            EmpleadosList.remove(EmpleadoEliminar);
                            System.out.println("Empleado Eliminado con éxito");
                        } else {
                            System.out.println("No se encontró empleado con la cédula especificada");
                        }

                        try {

                            BufferedWriter bwEmpleados = new BufferedWriter(new FileWriter(rutaEmpleados));
                            for (EmpleadosInfo empleado : EmpleadosList) {
                                bwEmpleados.write(empleado.getNombre() + "," + empleado.getCedula() + "," + empleado.getCargo() + "," + empleado.getTelefono_de_contacto() + "," + empleado.getFecha_de_ingreso() + "," + empleado.getSalario_Fijo() + "," + empleado.getComisiones() + "\n");
                            }
                            bwEmpleados.close();
                            System.out.println("Base de datos de empleados actualizada y guardada en " + rutaEmpleados);
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo.");
                        }
                        break;

                    case 3: // Organizar registros

                        brEmpleados.close();
                        brEmpleados = new BufferedReader(new FileReader(rutaEmpleados));

                        System.out.println("");
                        System.out.println("Seleccione 1 para organizar por Nombre y 2 para organizar por Salario");
                        int opcionOrganizar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionOrganizar) {
                            case 1:
                                ordenarPorNombre(EmpleadosList);
                                System.out.println("Base de datos de empleados ordenada por nombre.");
                                break;
                            case 2:
                                ordenarPorSalario(EmpleadosList);
                                System.out.println("Base de datos de empleados ordenada por salario.");
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                try {

                                    BufferedWriter bwEmpleados = new BufferedWriter(new FileWriter(rutaEmpleados));
                                    for (EmpleadosInfo empleado : EmpleadosList) {
                                        bwEmpleados.write(empleado.getNombre() + "," + empleado.getCedula() + "," + empleado.getCargo() + "," + empleado.getTelefono_de_contacto() + "," + empleado.getFecha_de_ingreso() + "," + empleado.getSalario_Fijo() + "," + empleado.getComisiones() + "\n");
                                    }
                                    bwEmpleados.close();
                                    System.out.println("Base de datos de empleados actualizada y guardada en " + rutaEmpleados);
                                } catch (IOException e) {
                                    System.out.println("Error al escribir en el archivo.");
                                }
                        }
                        break;

                    case 4:
                        System.out.println("");
                        System.out.println("Nombre del vendedor: ");
                        String nombreVE = scanner.next();

                        // Validar que el nombre solo contenga letras
                        if (!nombreVE.matches("^[a-zA-Z]+$")) {
                            System.err.println("Error: El nombre debe contener solo letras.");
                            break; // Sale del caso 4 si el nombre no es válido
                        }

                        System.out.println("Ingrese la cédula: ");
                        String cedulaVN = scanner.next();

                        // Validar que la cédula solo contenga números
                        if (!cedulaVN.matches("\\d+")) {
                            System.err.println("Error: La cédula debe contener solo números.");
                            break; // Sale del caso 4 si la cédula no es válida
                        }

                        System.out.println("Ingrese el carro vendido: ");
                        String carroV = scanner.next();

                        System.out.println("Ingrese el monto vendido: ");
                        int montoV;

                        // Validar que el monto sea un número entero positivo
                        try {
                            montoV = scanner.nextInt();
                            if (montoV <= 0) {
                                System.err.println("Error: El monto vendido debe ser un número entero positivo.");
                                break; // Sale del caso 4 si el monto no es válido
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Ingrese un número entero válido para el monto vendido.");
                            break; // Sale del caso 4 si el monto no es válido
                        }

                        // Crear una instancia de VentasInfo con los datos ingresados
                        VentasInfo nuevaVenta = new VentasInfo(nombreVE, cedulaVN, carroV, generarCodigo(), montoV);

                        // Agregar la nueva venta a la lista de ventas
                        VentasList.add(nuevaVenta);

                        System.out.println("Registro Agregado con éxito");

                        try {
                            // Escribir la información de ventas en el archivo
                            bwVentas.write(nuevaVenta.getNombre() + "," + nuevaVenta.getCedula() + "," + nuevaVenta.getCarro_vendido() + ","
                                    + nuevaVenta.Codigo_carro() + "," + nuevaVenta.getMonto_venta() + "\n");

                            System.out.println("Registro guardado en ventas.csv");
                        } catch (IOException e) {
                            System.out.println("Error al crear o escribir en el archivo ventas.csv.");
                        }
                        break;

                    case 5:
                        System.out.println("");
                        System.out.println("Ingrese la cédula del vendedor que desea eliminar: ");
                        String cedulaVentas = scanner.next();

// Validar que la cédula solo contenga números
                        if (!cedulaVentas.matches("\\d+")) {
                            System.err.println("Error: La cédula debe contener solo números.");
                            // Puedes decidir cómo manejar el error aquí, como mostrar un mensaje y solicitar nuevamente la entrada.
                        } else {
                            // Aquí puedes continuar con el procesamiento si la cédula es válida.
                        }
                        boolean elim = false;

                        for (int i = VentasList.size() - 1; i >= 0; i--) {
                            VentasInfo ventas = VentasList.get(i);
                            if (ventas.getCedula().equals(cedulaVentas)) {
                                VentasList.remove(i);
                                elim = true;
                            }
                        }

                        if (elim) {
                            try {
                                // Abrir el archivo de ventas en modo de escritura (sobrescribir todo el contenido)
                                bwVentas = new BufferedWriter(new FileWriter(rutaVentas));

                                // Escribir la información de ventas actualizada en el archivo
                                for (VentasInfo venta : VentasList) {
                                    bwVentas.write(venta.getNombre() + "," + venta.getCedula() + "," + venta.getCarro_vendido() + ","
                                            + venta.Codigo_carro() + "," + venta.getMonto_venta() + "\n");
                                }

                                bwVentas.close();
                                System.out.println("Registros eliminados y archivo de ventas actualizado.");
                            } catch (IOException e) {
                                System.out.println("Error al escribir en el archivo de ventas.");
                            }
                        } else {
                            System.out.println("No se encontró ningún registro con la cédula especificada.");
                        }

                        // Crear una lista para almacenar los empleados no eliminados
                        List<EmpleadosInfo> empleadosNoEliminados = new ArrayList<>();

                        // Iterar a través de la lista de empleados y agregar los no eliminados
                        for (EmpleadosInfo empleado : EmpleadosList) {
                            if (!empleado.getCedula().equals(cedulaVentas)) {
                                empleadosNoEliminados.add(empleado);
                            }
                        }

                        // Escribir los empleados no eliminados en el nuevo archivo
                        try {
                            BufferedWriter bwEmpleadosNoEliminados = new BufferedWriter(new FileWriter(rutaEmpleadosNoEliminados));
                            for (EmpleadosInfo empleado : empleadosNoEliminados) {
                                bwEmpleadosNoEliminados.write(empleado.getNombre() + "," + empleado.getCedula() + "," + empleado.getCargo() + "," + empleado.getTelefono_de_contacto() + "," + empleado.getFecha_de_ingreso() + "," + empleado.getSalario_Fijo() + "," + empleado.getComisiones() + "\n");
                            }
                            bwEmpleadosNoEliminados.close();
                            System.out.println("Registros no eliminados guardados en EmpleadosNoEliminados.csv.");
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo de empleados no eliminados.");
                        }
                        break;

                    case 6:
                        // Crear un mapa para realizar un seguimiento de las ventas por tipo de carro
                        Map<String, Integer> cantidadPorTipoDeCarro = new HashMap<>();
                        Map<String, Double> montoPorTipoDeCarro = new HashMap<>();

                        // Recorrer la lista de ventas y calcular las cantidades y montos por tipo de carro
                        for (VentasInfo venta : VentasList) {
                            String tipoDeCarro = venta.getCarro_vendido();
                            double montoVenta = venta.getMonto_venta();

                            // Verificar si el tipo de carro ya está en los mapas
                            if (cantidadPorTipoDeCarro.containsKey(tipoDeCarro)) {
                                // Si ya existe, aumentar la cantidad y sumar el monto de la venta
                                int cantidadExistente = cantidadPorTipoDeCarro.get(tipoDeCarro);
                                cantidadPorTipoDeCarro.put(tipoDeCarro, cantidadExistente + 1);

                                double montoExistente = montoPorTipoDeCarro.get(tipoDeCarro);
                                montoPorTipoDeCarro.put(tipoDeCarro, montoExistente + montoVenta);
                            } else {
                                // Si no existe, agregar el tipo de carro al mapa con cantidad 1 y el monto de la venta
                                cantidadPorTipoDeCarro.put(tipoDeCarro, 1);
                                montoPorTipoDeCarro.put(tipoDeCarro, montoVenta);
                            }
                        }

                        // Mostrar los tipos de carros, cantidades y montos
                        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

                        System.out.println("Tipos de Carro - Cantidad - Monto Total:");
                        for (Map.Entry<String, Integer> entry : cantidadPorTipoDeCarro.entrySet()) {
                            String tipoDeCarro = entry.getKey();
                            int cantidad = entry.getValue();
                            double montoTotal = montoPorTipoDeCarro.get(tipoDeCarro);

                            // Formatear el monto total antes de imprimirlo
                            String montoTotalFormateado = decimalFormat.format(montoTotal);

                            System.out.println(tipoDeCarro + " - " + cantidad + " - $" + montoTotalFormateado);
                        }
                        break;

                    case 7:
                        double limiteVentas = 30_000_000.0; // Límite de ventas para aplicar comisiones

                        // Crear un mapa para rastrear las ventas totales de cada empleado
                        Map<String, Double> ventasTotalesPorEmpleado = new HashMap<>();

                        // Calcular las ventas totales por empleado
                        for (VentasInfo venta : VentasList) {
                            String cedulaEmpleado = venta.getCedula();
                            double montoVenta = venta.getMonto_venta();
                            ventasTotalesPorEmpleado.put(cedulaEmpleado, ventasTotalesPorEmpleado.getOrDefault(cedulaEmpleado, 0.0) + montoVenta);
                        }

                        // Actualizar comisiones en el archivo de empleados
                        for (EmpleadosInfo empleado : EmpleadosList) {
                            String cedulaEmpleado = empleado.getCedula();
                            double ventasTotales = ventasTotalesPorEmpleado.getOrDefault(cedulaEmpleado, 0.0);

                            // Verificar si las ventas totales superan el límite
                            if (ventasTotales > limiteVentas) {
                                // Calcular comisiones como el 2% de las ventas totales que superen el límite
                                double comisiones = (ventasTotales - limiteVentas) * 0.02;

                                // Obtener las comisiones existentes
                                double comisionesActuales = empleado.getComisiones();

                                // Sumar el 2% de las ventas totales adicionales a las comisiones existentes
                                comisionesActuales += comisiones;

                                // Actualizar las comisiones en la instancia de empleado
                                empleado.setComisiones(comisionesActuales);
                            }
                        }

                        // Guardar las comisiones actualizadas en el archivo de empleados
                        try {
                            BufferedWriter bwEmpleados = new BufferedWriter(new FileWriter(rutaEmpleados));
                            for (EmpleadosInfo empleado : EmpleadosList) {
                                bwEmpleados.write(empleado.getNombre() + "," + empleado.getCedula() + "," + empleado.getCargo() + "," + empleado.getTelefono_de_contacto() + "," + empleado.getFecha_de_ingreso() + "," + empleado.getSalario_Fijo() + "," + empleado.getComisiones() + "\n");
                            }
                            bwEmpleados.close();
                            System.out.println("Comisiones actualizadas y archivo de empleados actualizado.");
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo de empleados.");
                        }
                        break;

                    case 8: {
                        System.out.println("");
                        System.out.println("Lista de Ventas:");
                        for (VentasInfo Venta : VentasList) {
                            System.out.println("Nombre: " + Venta.getNombre() + ", Cédula: " + Venta.getCedula() + ",Carro vendido: " + Venta.getCarro_vendido() + ",Codigo del carro: " + Venta.Codigo_carro() + " ,Monto de venta: " + Venta.getMonto_venta());
                        }
                        break;

                    }
                    case 9:
                        System.out.println("Saliendo del programa.");
                        bwVentas.close();
                        scanner.close();
                        return;  // Salir del programa
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");

                }

                try {
                    BufferedWriter bwEmpleado = new BufferedWriter(new FileWriter(rutaEmpleados));
                    for (EmpleadosInfo empleado : EmpleadosList) {
                        bwEmpleado.write(empleado.getNombre() + "," + empleado.getCedula() + "," + empleado.getCargo() + "," + empleado.getTelefono_de_contacto() + "," + empleado.getFecha_de_ingreso() + "," + empleado.getSalario_Fijo() + "," + empleado.getComisiones() + "\n");
                    }
                    bwEmpleado.close();
                    //System.out.println("Base de datos de empleados actualizada y guardada en empleados.csv.");
                } catch (IOException e) {
                    // System.out.println("Error al escribir en el archivo.");
                }
            }
        } catch (IOException e) {
            System.out.println("Problemas con el Archivo");
        }

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------//
    //ORGANIZAR POR ARCHIVOS//
    // Método para ordenar la lista de empleados por nombre utilizando el método de burbuja
    public static void ordenarPorNombre(List<EmpleadosInfo> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getNombre().compareTo(lista.get(j + 1).getNombre()) > 0) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }

    // Método para ordenar la lista de empleados por salario utilizando el método de burbuja
    public static void ordenarPorSalario(List<EmpleadosInfo> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getSalario_Fijo() > lista.get(j + 1).getSalario_Fijo()) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }
}

//----------------------------------------------------------------------------------------------------
//Zona de las clases//
//----------------------------------------------------------------------------------------------------
//Clase que almacena la informacion de los registros pertenecientes al archivo Empleados
class EmpleadosInfo {

    private String Nombre;
    private String Cedula;
    private String Cargo;
    private String Telefono_de_contacto;
    private String Fecha_de_ingreso;
    private int Salario_Fijo;
    private double comisiones;

    public EmpleadosInfo(String Nombre, String Cedula, String Cargo, String Telefono_de_contacto, String Fecha_de_ingreso, int Salario_Fijo, int Comisiones) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Cargo = Cargo;
        this.Telefono_de_contacto = Telefono_de_contacto;
        this.Fecha_de_ingreso = Fecha_de_ingreso;
        this.Salario_Fijo = Salario_Fijo;
        this.comisiones = Comisiones;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getTelefono_de_contacto() {
        return Telefono_de_contacto;
    }

    public String getFecha_de_ingreso() {
        return Fecha_de_ingreso;
    }

    public int getSalario_Fijo() {
        return Salario_Fijo;
    }

    public double getComisiones() { // Cambiar a minúscula
        return comisiones; // Cambiar a minúscula
    }

    public void setComisiones(double comisiones) { // Cambiar a minúscula
        this.comisiones = comisiones; // Cambiar a minúscula
    }
}

//----------------------------------------------------------------------------------------------------
//Clase que almacena la informacion de los registros pertenecientes al archivo Ventas
class VentasInfo {

    private String Nombre;
    private String Cedula;
    private String Carro_vendido;
    private String Codigo_carro;
    private int Monto_venta;

    public VentasInfo(String Nombre, String Cedula, String Carro_vendido, String Codigo_carro, int Monto_venta) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Carro_vendido = Carro_vendido;
        this.Codigo_carro = Codigo_carro;
        this.Monto_venta = Monto_venta;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getCarro_vendido() {
        return Carro_vendido;
    }

    public String Codigo_carro() {
        return Codigo_carro;
    }

    public int getMonto_venta() {
        return Monto_venta;
    }

}

class Codigo {

    String codigo = generarCodigo();

    public static String generarCodigo() {
        // Definir caracteres válidos para letras mayúsculas y números
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        // Inicializar un generador de números aleatorios
        Random rand = new Random();

        // Generar dos letras aleatorias
        char letra1 = letras.charAt(rand.nextInt(letras.length()));
        char letra2 = letras.charAt(rand.nextInt(letras.length()));

        // Generar dos números aleatorios
        int num1 = rand.nextInt(10); // Números del 0 al 9
        int num2 = rand.nextInt(10); // Números del 0 al 9

        // Construir el código aleatorio
        String codigo = String.valueOf(letra1) + String.valueOf(letra2) + num1 + num2;

        return codigo;
    }

}
