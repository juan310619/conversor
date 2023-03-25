package Gui2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Divisas.Ventanas;
import Implementacion.Implement;

public class VentanaDistancia extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField Cantidad;
	JComboBox<String> seleccionar;
	JButton btnConvertir;
	Implement operaciones;
	JTextArea resultado;
	ImageIcon imagenD;
	JLabel limagenD;
	JMenuItem tipodinero; 

	
	public VentanaDistancia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ComponentesD();
		ImageD();
		setBounds(100, 100, 450, 300);
		setTitle("Ventana operaciones");
		setLocationRelativeTo(null); //para que aparezca centrado la ventana
		setResizable(false); //tamaño fijo
		
		
	}

	private void ComponentesD() {
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu tipos = new JMenu("Conversor distancia");
		menuBar.add(tipos);
		
		tipodinero = new JMenuItem("Conversor dinero");
		tipodinero.addActionListener(this);
		tipos.add(tipodinero);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		setTitle("Ventana operaciones");
		setLocationRelativeTo(null); //para que aparezca centrado la ventana
		setResizable(false); //tamaño fijo
		
		JLabel Titulo = new JLabel("Conversor");
		Titulo.setVerticalAlignment(SwingConstants.BOTTOM);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Courier 10 Pitch", Font.ITALIC, 18));
		Titulo.setBounds(90, 0, 259, 45);
		panel.add(Titulo);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(162, 129, 117, 25);
		btnConvertir.addActionListener(this);
		//btnConvertir.addActionListener(this);
		panel.add(btnConvertir);
		
		seleccionar = new JComboBox<String>();
		seleccionar.setBounds(12, 67, 165, 24);
		seleccionar.addItem("metros a centimetros");
		seleccionar.addItem("metros a kilometros"); 
		seleccionar.addItem("metros a milimetros");
		seleccionar.addItem("metros a pie");
		seleccionar.addItem("centimetros a metros");
		seleccionar.addItem("kilometros a metros");
		seleccionar.addItem("milimetros a metros");
		seleccionar.addItem("pie a metros");
		
		panel.add(seleccionar);
		
		Cantidad = new JTextField();
		Cantidad.setBounds(257, 67, 165, 24);
		panel.add(Cantidad);
		Cantidad.setColumns(10);
		
		resultado = new JTextArea();
		resultado.setLineWrap(true); // ajuste de línea activado
		resultado.setWrapStyleWord(false); // no se rompen las palabras
		JScrollPane scrollPane = new JScrollPane(resultado); // agrega el JTextArea a un JScrollPane
		resultado.setFont(new Font("DialogInput", Font.BOLD, 13));
		resultado.setEditable(false);
		resultado.setText("||||||||| Cargando resultado");
		resultado.setBounds(12, 180, 426, 50);
		panel.add(resultado);
		JTextArea marcaAgua = new JTextArea();
		marcaAgua.setEditable(false);
		marcaAgua.setText("© Juan D.");
		marcaAgua.setBounds(380, 227, 100, 15);
		panel.add(marcaAgua);
		
	}
	
	private void ImageD() {
		try {
			imagenD = new ImageIcon(getClass().getResource("/img/distancia.png"));
			limagenD = new JLabel(imagenD);
			limagenD.setSize(70, 65);
			limagenD.setLocation(337, 0);
			Image imagenredimensionada = imagenD.getImage().getScaledInstance(limagenD.getWidth(), 
					limagenD.getHeight(), Image.SCALE_SMOOTH);// redimensionamos la imagen
	        imagenD.setImage(imagenredimensionada);
			panel.add(limagenD);
			
		}catch(Exception e) {
			System.out.println("imagen no encontrada");
			e.printStackTrace();
		}
		
	}
	
	public void asignaOperaciones(Implement operaciones) {
		this.operaciones = operaciones;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		tipoDeConversion(e);// verificamos si quiere calcular distancia o divisas
		
		if (btnConvertir==e.getSource()) {// si el boton es oprimido
			comprobaciones();
			String unidades = seleccionar.getSelectedItem().toString();//seleccionamos el texto que es lo que quiere convertir
			double cantidad = Double.parseDouble(Cantidad.getText());//cuanto quiere convertir
			String tipo = "distancia"; 
			try {
				double result = operaciones.convertir(unidades,cantidad,tipo); //realizamos la conversion
				DecimalFormat decimales = new DecimalFormat("#.########");// le damos formato
				result= Double.parseDouble(decimales.format(result).replace(",", "."));//aplicamos formato
				String primero =Implement.Primer(unidades);//extraemos nombre de la moneda de entrada
				String ultimo = Implement.Ultimo(unidades);// nombre de la moneda de salida
				resultado.setText(String.valueOf(cantidad)+ " "+  primero+ 
						" equivale a "+ String.valueOf(result)+ " "+ ultimo);// le mostramos los resultados
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "No podemos hacer ese cambio, intente de nuevo");
					
					
				}
		}
		
	}
	


	private void tipoDeConversion(ActionEvent e) {
		if(tipodinero ==e.getSource()) {
			
			try {
				dispose();
				Ventanas ventanadinero = new Ventanas("dinero");
				

			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
		
	}


	private void comprobaciones() {
		String textoingresado = Cantidad.getText();
		if (textoingresado.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Ingresa un valor para realizar la equivalencia");
		}
		
	}

}

