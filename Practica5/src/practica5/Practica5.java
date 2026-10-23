/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author admin
 */
public class Practica5 extends JFrame {
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JButton btnBuscar, btnNuevo;
    private JTable tabla;
    private DefaultTableModel modelo;
    
    public Practica5() {
        setTitle("Practica5");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        elementos();
}

public void elementos(){
        
        
        // Texto de la parte superior 
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        lblMatricula = new JLabel("Matricula");
        txtMatricula = new JTextField(12);
        btnBuscar = new JButton("Buscar");
        btnNuevo = new JButton("Nuevo");
        
        panelSuperior.add(lblMatricula);
        panelSuperior.add(txtMatricula);
        panelSuperior.add(Box.createHorizontalStrut(60));
        panelSuperior.add(btnBuscar);
        panelSuperior.add(btnNuevo);
        
        // Tabla Scroll
        String[] columnas = {"Matricula", "Nombre", "Edad", "Telefono", "Correo"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        
        // Eventos
        btnBuscar.addActionListener(e -> buscar());
        btnNuevo.addActionListener(e -> nuevo());
    }
    
    private void buscar() {
        String matricula = txtMatricula.getText().trim();
        JOptionPane.showMessageDialog(this, "Buscando: " + matricula);
    }
    
    private void nuevo() {
        
        modelo.addRow(new Object[]{"", "", "", "", ""});
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new Practica5().setVisible(true);
        });
    }
}