package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Divisas.Ventanas;
import Implementacion.Implement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.DecimalFormat;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;

public class VentanaDinero extends JFrame implements ActionListener {

	private JPanel panelprincipal;
	JButton btnGo;
	JComboBox<String> comboBox1;
	private JTextField entrada;
	Implement operaciones;
	JTextArea txtrCargandoResultado;
	ImageIcon imagen;
	JLabel limagen;
	JMenuItem tipodistancia; 
	/**
	 * @wbp.nonvisual location=325,7
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaDinero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Componentes();
		Image();
		setBounds(100, 100, 450, 300);
		setTitle("Ventana operaciones");
		setLocationRelativeTo(null); //para que aparezca centrado la ventana
		setResizable(false); //tamaño fijo
		
	}




	private void Componentes() {
		JMenuBar menuBarra = new JMenuBar();
		setJMenuBar(menuBarra);
		
		JMenu tipo = new JMenu("Conversor Moneda");
		menuBarra.add(tipo);
		
		tipodistancia = new JMenuItem("Conversor Distancia");
		tipodistancia.addActionListener(this);
		tipo.add(tipodistancia);
		
		panelprincipal = new JPanel();
		panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelprincipal);
		panelprincipal.setLayout(null);
		
		setTitle("Ventana operaciones");
		setLocationRelativeTo(null); //para que aparezca centrado la ventana
		setResizable(false); //tamaño fijo
		
		JLabel label = new JLabel("Conversor");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Courier 10 Pitch", Font.ITALIC, 18));
		label.setBounds(90, 0, 259, 45);
		panelprincipal.add(label);
		
		btnGo = new JButton("Convertir");
		btnGo.setBounds(162, 129, 117, 25);
		btnGo.addActionListener(this);
		panelprincipal.add(btnGo);
		
		comboBox1 = new JComboBox<String>();
		comboBox1.setBounds(12, 67, 165, 24);
		comboBox1.addItem("pesos COP a dolar");
		comboBox1.addItem("pesos COP a euros"); 
		comboBox1.addItem("Pesos COP a Yen");
		comboBox1.addItem("Pesos COP a Won");
		comboBox1.addItem("Pesos COP a GBP");
		comboBox1.addItem("dolar a pesos COP");
		comboBox1.addItem("euros a pesos COP");
		comboBox1.addItem("Yen a pesos COP");
		comboBox1.addItem("Won a pesos COP");
		comboBox1.addItem("GBP a pesos COP");
		
		panelprincipal.add(comboBox1);
		
		entrada = new JTextField();
		entrada.setBounds(257, 67, 165, 24);
		panelprincipal.add(entrada);
		entrada.setColumns(10);
		
		txtrCargandoResultado = new JTextArea();
		txtrCargandoResultado.setFont(new Font("DialogInput", Font.BOLD, 13));
		txtrCargandoResultado.setEditable(false);
		txtrCargandoResultado.setText("||||||||| Cargando resultado");
		txtrCargandoResultado.setBounds(12, 180, 426, 50);
		panelprincipal.add(txtrCargandoResultado);
		
		JTextArea marcaAgua = new JTextArea();
		marcaAgua.setEditable(false);
		marcaAgua.setText("© Juan D.");
		marcaAgua.setBounds(380, 227, 100, 15);
		panelprincipal.add(marcaAgua);
		
		
	}
	
	
	public void Image() {
		try {
			imagen = new ImageIcon(getClass().getResource("/img/imagen.png"));
			limagen = new JLabel(imagen);
			limagen.setSize(70, 69);
			limagen.setLocation(337, 0);
			Image imagenRedimensionada = imagen.getImage().getScaledInstance(limagen.getWidth(), limagen.getHeight(), 
					Image.SCALE_SMOOTH); // redimensionamos la imagen
	        imagen.setImage(imagenRedimensionada);
			panelprincipal.add(limagen);
			
			
			
		}catch(Exception e) {
			System.out.println("imagen no encontrada");
			e.printStackTrace();
		}
	}
	

	public void asignaOperaciones(Implement operaciones) { //para llamar a las operaciones
		this.operaciones = operaciones;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		tipoDeConversion(e); // verificamos si quiere calcular distancia o divisas
		
		if (btnGo==e.getSource()) {// si el boton es oprimido
			comprobaciones();
			String unidades = comboBox1.getSelectedItem().toString(); //seleccionamos el texto que es lo que quiere convertir
			double cantidad = Double.parseDouble(entrada.getText()); //cuanto quiere convertir
			String tipo = "dinero";
			
			try {
				double resultado = operaciones.convertir(unidades,cantidad,tipo); //realizamos la conversion
				DecimalFormat decimales = new DecimalFormat("#.########");// le damos formato
				resultado = Double.parseDouble(decimales.format(resultado).replace(",", ".")); //aplicamos formato
				String primero =Implement.Primer(unidades); //extraemos nombre de la moneda de entrada
				String ultimo = Implement.Ultimo(unidades);// nombre de la moneda de salida
				txtrCargandoResultado.setText(String.valueOf(cantidad)+ " "+  primero+  
						" equivale a "+ String.valueOf(resultado)+ " "+ ultimo);  // le mostramos los resultados
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "No podemos hacer ese cambio, intente de nuevo");
					
					
				}
			
			
		}
		
		
	}




	private void tipoDeConversion(ActionEvent e) {
		if(tipodistancia==e.getSource()) {
			try {
				dispose();
				Ventanas ventanadistancia = new Ventanas("distancia");
				

			} catch (Exception e1) {
				 
				e1.printStackTrace();
			}
		}
		
	}




	private void comprobaciones() {
		String textoingresado = entrada.getText();
		if (textoingresado.isEmpty()) { // verificamos que no mande un null
			JOptionPane.showMessageDialog(null,"Ingresa un valor para realizar la equivalencia");
		}
		else if(!textoingresado.matches("\\d+(\\.\\d+)?")){ //expresion regular que comprueba si solo hay numeros positivos
			JOptionPane.showMessageDialog(null, "Ingrese un número positivo válido");
			 entrada.setText("");
		     entrada.requestFocus();
			
		}
		
		
		
	}
}
