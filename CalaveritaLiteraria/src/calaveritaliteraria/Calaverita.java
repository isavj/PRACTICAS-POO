package calaveritaliteraria;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Calaverita extends JFrame {

    private static final String TEXTO_CALAVERITA
            = "Estudiando de noche en la computadora,\n"
            + "estaba Josan Joan sin descansar,\n"
            + "creando clases, métodos y estructuras,\n"
            + "pues Programación Orientada a Objetos tenía que pasar.\n"
            + "La Calaca flaca por la puerta se asomó\n"
            + "y vio que con la profesora Maritza estaba batallando:\n"
            + "—¡Ay, Josan, ese compilador ya tronó\n"
            + "y un error de sintaxis te está llevando!\n"
            + "—¡Espera, Parca, no me lleves al panteón!—\n"
            + "gritó el futuro ingeniero con horror,\n"
            + "—deja instanciar mi último objeto en el sistema\n"
            + "antes de que la maestra me ponga un cero peor.\n"
            + "Pero la Muerte, que de código no entendía,\n"
            + "a Josan en su lista negra capturó,\n"
            + "y aunque la maestra Maritza punto extra pedía,\n"
            + "con todo y sus programas al camposanto se lo llevó.";

    private EtiquetaContorno lblTitulo;
    private JTextArea txtCalaverita;
    private JScrollPane scrollCalaverita;
    private JButton btnCentral;
    private JButton btnSalir;
    private JButton btnPdf;
    private JLabel lblFondo;

    public Calaverita() {
        setTitle("Calaverita Literaria");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentes();
        setVisible(true);
    }

    private void componentes() {
        lblTitulo = new EtiquetaContorno("Calaverita Literaria");
        lblTitulo.setFont(new Font("Gill Sans MT Ext Condensed Bold", Font.PLAIN, 40));
        lblTitulo.setForeground(new Color(255, 140, 0));
        lblTitulo.setColorContorno(Color.BLACK);
        lblTitulo.setGrosor(4f);
        lblTitulo.setBounds(0, 10, getWidth(), 50);
        add(lblTitulo);

        // Botón  de calaverita , centrado en la ventana
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("Button.png"));
        int anchoBoton = 100;
        int altoBoton = iconoOriginal.getIconHeight() * anchoBoton / iconoOriginal.getIconWidth();
        Image imgBoton = iconoOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);

        btnCentral = new JButton(new ImageIcon(imgBoton));
        btnCentral.setContentAreaFilled(false);
        btnCentral.setBorderPainted(false);
        btnCentral.setFocusPainted(false);
        btnCentral.setCursor(new Cursor(Cursor.HAND_CURSOR));
        int x = (getWidth() - anchoBoton) / 2;
        int y = (getHeight() - altoBoton) / 2 - 15;
        btnCentral.setBounds(x, y, anchoBoton, altoBoton);
        btnCentral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCentral.setVisible(false);
                scrollCalaverita.setVisible(true);
                btnPdf.setVisible(true);
                btnSalir.setVisible(true);
            }
        });
        add(btnCentral);

        // Botones : PDF a la izquierda, Salir a la derecha
        btnPdf = crearBotonNaranja("PDF");
        btnPdf.setBounds(140, 322, 100, 30);
        btnPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarPdf();
            }
        });
        add(btnPdf);

        btnSalir = crearBotonNaranja("Salir");
        btnSalir.setBounds(260, 322, 100, 30);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(btnSalir);

        // Área de texto con fondo negro semitransparente
        txtCalaverita = new JTextArea() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        txtCalaverita.setText(TEXTO_CALAVERITA);
        txtCalaverita.setEditable(false);
        txtCalaverita.setLineWrap(true);
        txtCalaverita.setWrapStyleWord(true);
        txtCalaverita.setFont(new Font("Serif", Font.BOLD, 13));
        txtCalaverita.setForeground(Color.WHITE);
        txtCalaverita.setOpaque(false);
        txtCalaverita.setBackground(new Color(0, 0, 0, 170));
        txtCalaverita.setMargin(new Insets(8, 12, 8, 12));
        txtCalaverita.setCaretPosition(0);

        // Scroll 
        scrollCalaverita = new JScrollPane(txtCalaverita);
        scrollCalaverita.setOpaque(false);
        scrollCalaverita.getViewport().setOpaque(false);
        scrollCalaverita.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        scrollCalaverita.setBorder(null);
        scrollCalaverita.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollCalaverita.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCalaverita.setBounds(20, 65, 440, 250);
        scrollCalaverita.setVisible(false);
        add(scrollCalaverita);

        // Fondo de calaveritas con flores de cempasuchil 
        ImageIcon icono = new ImageIcon(getClass().getResource("Calaverita.jpg"));
        Image imagen = icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        lblFondo = new JLabel(new ImageIcon(imagen));
        lblFondo.setBounds(0, 0, getWidth(), getHeight());
        add(lblFondo);
    }

    // Crea un botón naranja con borde negro, oculto al inicio
    private JButton crearBotonNaranja(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Serif", Font.BOLD, 13));
        boton.setForeground(Color.BLACK);
        boton.setBackground(new Color(255, 140, 0));
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setVisible(false);
        return boton;
    }

    // Genera el PDF con la calaverita
    private void generarPdf() {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Guardar calaverita como PDF");
        selector.setSelectedFile(new File("Calaverita.pdf"));

        if (selector.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;   // el usuario canceló
        }

        File archivo = selector.getSelectedFile();
        if (!archivo.getName().toLowerCase().endsWith(".pdf")) {
            archivo = new File(archivo.getAbsolutePath() + ".pdf");
        }

        // Fuentes del PDF (se usa el nombre completo porque Font también existe en java.awt)
        com.lowagie.text.Font fuenteTitulo
                = FontFactory.getFont(FontFactory.TIMES_BOLD, 24, com.lowagie.text.Font.NORMAL, new Color(255, 140, 0));
        com.lowagie.text.Font fuenteTexto
                = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13);

        try (FileOutputStream salida = new FileOutputStream(archivo)) {
            Document documento = new Document(PageSize.LETTER, 60, 60, 60, 60);
            PdfWriter.getInstance(documento, salida);
            documento.open();

            Paragraph titulo = new Paragraph("Calaverita Literaria", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(25);
            documento.add(titulo);

            Paragraph cuerpo = new Paragraph(TEXTO_CALAVERITA, fuenteTexto);
            cuerpo.setAlignment(Element.ALIGN_LEFT);
            cuerpo.setLeading(20);   // separación entre líneas
            documento.add(cuerpo);

            documento.close();

            JOptionPane.showMessageDialog(this, "PDF guardado en:\n" + archivo.getAbsolutePath());
        } catch (DocumentException | IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo crear el PDF:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Etiqueta que genera el texto con contorno
    private static class EtiquetaContorno extends JLabel {

        private Color colorContorno = Color.BLACK;
        private float grosor = 3f;

        public EtiquetaContorno(String texto) {
            super(texto);
        }

        public void setColorContorno(Color color) {
            this.colorContorno = color;
            repaint();
        }

        public void setGrosor(float grosor) {
            this.grosor = grosor;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            String texto = getText();
            FontMetrics fm = g2.getFontMetrics(getFont());

            int x = (getWidth() - fm.stringWidth(texto)) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            FontRenderContext frc = g2.getFontRenderContext();
            GlyphVector gv = getFont().createGlyphVector(frc, texto);
            Shape forma = gv.getOutline(x, y);

            g2.setStroke(new BasicStroke(grosor, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(colorContorno);
            g2.draw(forma);

            g2.setColor(getForeground());
            g2.fill(forma);

            g2.dispose();
        }
    }

}