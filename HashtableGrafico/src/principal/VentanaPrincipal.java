package principal;

import java.awt.Container;
import java.awt.event.*;
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
	
	//hash table
	Hashtable<String,PersonaVo> tablaPersonas;
	
	
	public VentanaPrincipal () {
		initiailize();
		setSize(350,245);
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
		
		//Configuracion  Registro
		btnRegistrar = new JButton ("Registrar");
		btnRegistrar.setBounds(10,145,99,23);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		//configuracion boton para consultar Lista
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
			mensaje+="Fecha: "+ persona.getNlugar()+"\n";
			mensaje+="FechaNacimiento: "+persona.getFechaNacimiento()+"\n";
			//se imprime msj
			JOptionPane.showMessageDialog(null, mensaje);
		}else {
			JOptionPane.showMessageDialog(null,"Persona ya existe ","Adveretencia",JOptionPane.WARNING_MESSAGE);
		}
	}

	//ingresar personas
	private void registrarPersona(Hashtable<String, PersonaVo> tablaPersonas) {
		PersonaVo miPersona=new PersonaVo();
		miPersona.setNit(campoNit.getText());
		miPersona.setNombre(campoNombre.getText());
		miPersona.setNlugar(Integer.parseInt(campoNlugar.getText()));
		miPersona.setFechaNacimiento(CampoFechaNacimiento.getText());
		//valida no repetir personas
		if (tablaPersonas.containsKey(miPersona.getNit())==false) {
			tablaPersonas.put(miPersona.getNit(), miPersona);
			System.out.print("Registro realizado");
			limpiarCampos();
		}else {
			JOptionPane.showMessageDialog(null,"Persona no encontrada "," ERROR ",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	private void limpiarCampos() {
		CampoFechaNacimiento.setText("");
		campoNit.setText("");
		campoNlugar.setText("");
		campoNombre.setText("");
		
	}
}
