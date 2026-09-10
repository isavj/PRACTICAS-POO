/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
 

/**
 *
 * @author admin
 */
public class practica4 extends JFrame
{
    // Lado izquierdo
    JLabel lblNombre, lblDireccion, lblSexo, lblTelefono, lblNumero, lblFotografia;
    JTextField txtNombre, txtDireccion, txtNumero;
    JComboBox<String> cmbSexo;
    JCheckBox chkMovil, chkCasa;
 
    // Lado derecho
    JLabel lblFoto;
 
    // Selector de archivos embebido
    JFileChooser fileChooser;
 
    // Botones
    JButton btnNuevo, btnGuardar;
 
    public practica4(){
        setTitle("Práctica 4");
        setSize(560, 650);
        setLayout(null);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
        setVisible(true);
    }
 
    public void componentes(){
 
        // --- Nombre ---
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 20);
 
        txtNombre = new JTextField();
        txtNombre.setBounds(20, 40, 160, 25);
 
        // --- Dirección ---
        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 75, 100, 20);
 
        txtDireccion = new JTextField();
        txtDireccion.setBounds(20, 95, 160, 25);
 
        // --- Sexo ---
        lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(20, 130, 100, 20);
 
        cmbSexo = new JComboBox<>(new String[]{"Femenino", "Masculino"});
        cmbSexo.setBounds(20, 150, 160, 25);
 
        // --- Teléfono (checkboxes Movil / Casa) ---
        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 185, 100, 20);
 
        chkMovil = new JCheckBox("Movil");
        chkMovil.setBounds(20, 205, 80, 25);
 
        chkCasa = new JCheckBox("Casa");
        chkCasa.setBounds(100, 205, 80, 25);
 
        // --- Número ---
        lblNumero = new JLabel("Número:");
        lblNumero.setBounds(20, 240, 100, 20);
 
        txtNumero = new JTextField();
        txtNumero.setBounds(20, 260, 160, 25);
 
        // --- Fotografía (label descriptivo) ---
        lblFotografia = new JLabel("Fotografía:");
        lblFotografia.setBounds(20, 295, 100, 20);
 
        // --- Foto (JLabel con borde, placeholder de imagen) ---
        lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(JLabel.CENTER);
        lblFoto.setVerticalAlignment(JLabel.CENTER);
        lblFoto.setBorder(new LineBorder(Color.GRAY));
        lblFoto.setBounds(220, 20, 260, 260);
 
        // --- JFileChooser embebido (no como dialogo, se agrega directo al frame) ---
        fileChooser = new JFileChooser();
        fileChooser.setControlButtonsAreShown(true);
        fileChooser.setBounds(20, 330, 460, 220);
 
        // --- Botones ---
        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(160, 570, 100, 30);
 
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(280, 570, 100, 30);
 
        // Agrega los componentes a la ventana
        add(lblNombre);
        add(txtNombre);
        add(lblDireccion);
        add(txtDireccion);
        add(lblSexo);
        add(cmbSexo);
        add(lblTelefono);
        add(chkMovil);
        add(chkCasa);
        add(lblNumero);
        add(txtNumero);
        add(lblFotografia);
        add(lblFoto);
        add(fileChooser);
        add(btnNuevo);
        add(btnGuardar);
    }
 
    
}
