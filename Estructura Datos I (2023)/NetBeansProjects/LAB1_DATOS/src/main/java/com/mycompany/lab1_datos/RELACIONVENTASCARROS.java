/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lab1_datos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
/**
 *
 * @author LENOVO V14-G2
 */
public class RELACIONVENTASCARROS extends javax.swing.JFrame {

    /**
     * Creates new form RELACIONVENTASCARROS
     */
    public RELACIONVENTASCARROS() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Filtrar segun lo deseado:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel3.setText("Mostrar relacion Tipos de Carros - Ventas - Monto total");

        jButton1.setText("Boton Magico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String rutaArchivoVentas = "C:/Users/LENOVO V14-G2/Documents/labo1/Ventas.csv";

    // Crear un mapa para realizar un seguimiento de las ventas por tipo de carro
    Map<String, Integer> cantidadPorTipoDeCarro = new HashMap<>();
    Map<String, Double> montoPorTipoDeCarro = new HashMap<>();

    // Leer el archivo de ventas CSV y calcular las cantidades y montos por tipo de carro
    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoVentas))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length >= 3) { // Asegurarse de que haya al menos tres campos en cada línea
                String tipoDeCarro = campos[2].trim(); // Suponiendo que el tipo de carro está en la tercera columna
                double montoVenta = Double.parseDouble(campos[4].trim()); // Suponiendo que el monto de la venta está en la quinta columna

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
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al leer el archivo de ventas CSV.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } catch (NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al procesar los montos en el archivo de ventas CSV.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Mostrar los tipos de carros, cantidades y montos en una ventana flotante
    StringBuilder mensaje = new StringBuilder("Carros Vendidos - Cantidad - Monto Total:\n");
    for (Map.Entry<String, Integer> entry : cantidadPorTipoDeCarro.entrySet()) {
        String tipoDeCarro = entry.getKey();
        int cantidad = entry.getValue();
        double montoTotal = montoPorTipoDeCarro.get(tipoDeCarro);

        // Formatear el monto total antes de agregarlo al mensaje
        mensaje.append(tipoDeCarro).append(" - ").append(cantidad).append(" - $").append(montoTotal).append("\n");
    }

    JOptionPane.showMessageDialog(this, mensaje.toString(), "Resumen de Ventas por Tipo de Carro", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RELACIONVENTASCARROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RELACIONVENTASCARROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RELACIONVENTASCARROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RELACIONVENTASCARROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RELACIONVENTASCARROS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
