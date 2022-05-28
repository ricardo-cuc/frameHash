package principal;

import ConfiguracionHash.*;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener {
	private JTextField campoNit;
	private JTextField campoNlugar;
	private JTextField campoNombre;
	private JTextField CampoFechaNacimiento;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnConsultarLista;
	private JButton btnCargaLista;
	
	//hash table
	Hashtable<String,PersonaVo> tablaPersonas;
	
	
	public VentanaPrincipal () {
		initiailize();
		setSize(350,275);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		tablaPersonas=new Hashtable<String, PersonaVo>();
	}
	
	//inicia contenido de frame

private void initiailize()	{
		getContentPane().setLayout(null);
		
		JLabel lblRegistroDePersona=new JLabel("Aplicacion Teatro");
		lblRegistroDePersona.setBounds(10,11,153,23);
		getContentPane().add(lblRegistroDePersona);
		
		JLabel lblNit = new JLabel("Nit");
		lblNit.setBounds(10,45,79,14);
		getContentPane().add(lblNit);
		
		JLabel lblEdad=new JLabel ("Silla");
		lblEdad.setBounds(198,45,50,14);
		getContentPane().add(lblEdad);	

		//Campo para el nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10,74,86,14);
		getContentPane().add(lblNombre);
		

		//Campo FechaNacimientoes
		JLabel lblFechaNacimiento = new JLabel("F. de Na.");
		lblFechaNacimiento.setBounds(10,105,86,14);
		getContentPane().add(lblFechaNacimiento);
		
		
		campoNit = new JTextField();
		campoNit.setColumns(10);
		campoNit.setBounds(85,42,86,20);
		getContentPane().add(campoNit);

		
		campoNlugar = new JTextField();
		campoNlugar.setColumns(10);
		campoNlugar.setBounds(232,42,86,20);
		getContentPane().add(campoNlugar);
		
		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(85,71,233,20);
		getContentPane().add(campoNombre);
		
		//Evento para campo FechaNacimiento
		CampoFechaNacimiento = new JTextField();
		CampoFechaNacimiento.setColumns(10);
		CampoFechaNacimiento.setBounds(85,104,233,20);
		getContentPane().add(CampoFechaNacimiento);
		

		
		//Boton Cargar Elementos
		btnCargaLista = new JButton("Cargar Csv");
		btnCargaLista.setBounds(71,200,188,23);
		btnCargaLista.addActionListener(this);
		getContentPane().add(btnCargaLista);
		
		//Boton Eliminar
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(219,145,99,23);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		//Boton Buscar
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(115,145,99,23);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		//Boton  Registro
		btnRegistrar = new JButton ("Registrar");
		btnRegistrar.setBounds(10,145,99,23);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		//Boton consultar Lista
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setBounds(71,173,188,23);
		btnConsultarLista.addActionListener(this);
		getContentPane().add(btnConsultarLista);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//registra persona
		if(e.getSource()==btnRegistrar) {
			registrarPersona(tablaPersonas);
		}
		if(e.getSource()==btnBuscar) {
			consultarPersona(tablaPersonas);
		}
		if(e.getSource()==btnConsultarLista) {
			//
			VentanaConsulta ventanaConsulta = new VentanaConsulta(this,true,tablaPersonas);
			ventanaConsulta.setVisible(true);
		}
		if(e.getSource()==btnEliminar) {
			eliminarPersona(tablaPersonas);
		}
		//cargar los archivos desde csv
		if(e.getSource()==btnCargaLista) {
			try {
				cargarPersona(tablaPersonas);
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
	}

	private void eliminarPersona(Hashtable<String, PersonaVo> tablaPersonas2) {
		String Nit=JOptionPane.showInputDialog("Ingrese el Nit de la persona que eliminara ");
		if(tablaPersonas.containsKey(Nit)) {
			tablaPersonas.remove(Nit);
			JOptionPane.showMessageDialog(null,"Registro Eliminado");
		}else {
			JOptionPane.showMessageDialog(null,"Persona no encontrada "," ERROR ",JOptionPane.ERROR_MESSAGE);		
		}
	}

	private void consultarPersona(Hashtable<String, PersonaVo> tablaPersonas2) {
		String mensaje="Datos de la Persona";
		//aca se realiza el metodo que realiza la consulta
		String Nit=JOptionPane.showInputDialog("Ingrese el Nit de la persona");
		
		if(tablaPersonas.containsKey(Nit)==true) {
			
			PersonaVo persona=tablaPersonas.get(Nit);
			//mapeo de informacion que se mostrara en un mensaje
			mensaje+="Nit: "+ persona.getNit()+"\n";
			mensaje+="Nombre: "+ persona.getNombre()+"\n";
			mensaje+="Lugar: "+ persona.getNlugar()+"\n";
			mensaje+="FechaNacimiento: "+persona.getFechaNacimiento()+"\n";
			//se imprime msj
			JOptionPane.showMessageDialog(null, mensaje);
		}else {
			JOptionPane.showMessageDialog(null,"No existe","Adveretencia",JOptionPane.WARNING_MESSAGE);
		}
	}

	//ingresar personas
	private void registrarPersona(Hashtable<String, PersonaVo> tablaPersonas) {
		PersonaVo miPersona=new PersonaVo(Integer.parseInt(campoNlugar.getText()),campoNit.getText(), campoNombre.getText(), CampoFechaNacimiento.getText());
		//valida no repetir personas
		
		if (tablaPersonas.containsKey(miPersona.getNit())==false) {
			tablaPersonas.put(miPersona.getNit(), miPersona);
			System.out.print("Registro realizado");
			limpiarCampos();
		}else {
			JOptionPane.showMessageDialog(null,"Persona no encontrada "," ERROR ",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void cargarPersona(Hashtable<String, PersonaVo> tablaPersonas) throws HeadlessException, IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ricardo\\eclipse-workspace\\HashtableGrafico\\src\\principal\\ListaC.csv"));
			String line;
			int id=1;
			while ((line = br.readLine()) != null) { 
			    // use comma as separator 
			    String[] cols = line.split(";"); 
				PersonaVo pers = new PersonaVo(id++,cols[0], cols[1], cols[2]);
				if (tablaPersonas.containsKey(pers.getNit())==false) {
					tablaPersonas.put(pers.getNit(), pers);
					System.out.print("Registro realizado");
					limpiarCampos();
				}else {
					JOptionPane.showMessageDialog(null,"Persona no encontrada "," ERROR ",JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("Elemento Agregado "+id); 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void limpiarCampos() {
		CampoFechaNacimiento.setText("");
		campoNit.setText("");
		campoNlugar.setText("");
		campoNombre.setText("");
		
	}
}
