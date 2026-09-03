/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 *
 * @author admin
 */
public class Practica3 extends JFrame
{
  // Izquierda
    JLabel lblNombre, lblEdad, lblCorreo, lblUsuario, lblContrasenia;
    JTextField txtNombre, txtEdad, txtCorreo, txtUsuario;
    JPasswordField pwdContrasenia;
 
    // Lado derecho
    JLabel lblInformacion;
    JTextArea txtArea;
    JScrollPane scrollArea;
 
    // Botones
    JButton btnNuevo, btnAgregar;
 
    public Practica3(){
        setTitle("Práctica 1");
        setSize(650, 480);
        setLayout(null);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
        setVisible(true);
    }
 
    public void componentes(){
 
        // NOMBRE
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 30, 100, 25);
 
        txtNombre = new JTextField();
        txtNombre.setBounds(140, 30, 180, 25);
 
        //EDAD
        lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 75, 100, 25);
 
        txtEdad = new JTextField();
        txtEdad.setBounds(140, 75, 180, 25);
 
        // CORREO
        lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, 120, 100, 25);
 
        txtCorreo = new JTextField();
        txtCorreo.setBounds(140, 120, 180, 25);
 
        // USUARIO
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 165, 100, 25);
 
        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 165, 180, 25);
 
        // CONTRASENIA
        lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setBounds(20, 210, 100, 25);
 
        pwdContrasenia = new JPasswordField();
        pwdContrasenia.setBounds(140, 210, 180, 25);
 
        //INFORMACION
        lblInformacion = new JLabel("Información");
        lblInformacion.setBounds(350, 30, 120, 30);
        lblInformacion.setBorder(new LineBorder(Color.GRAY));
        lblInformacion.setHorizontalAlignment(JLabel.CENTER);
 
        // JScrollPane,JScrollBar
        txtArea = new JTextArea();
        scrollArea = new JScrollPane(txtArea);
        scrollArea.setBounds(350, 75, 260, 200);
 
        //BOTONES
        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(230, 300, 100, 30);
 
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(350, 300, 100, 30);
 
        // AGREGAR LOS COMPONENTES DE LA VENTANA
        add(lblNombre);
        add(txtNombre);
        add(lblEdad);
        add(txtEdad);
        add(lblCorreo);
        add(txtCorreo);
        add(lblUsuario);
        add(txtUsuario);
        add(lblContrasenia);
        add(pwdContrasenia);
        add(lblInformacion);
        add(scrollArea);
        add(btnNuevo);
        add(btnAgregar);
    }
   
   
}
