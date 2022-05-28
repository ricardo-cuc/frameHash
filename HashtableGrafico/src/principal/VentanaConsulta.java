package principal;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.*;

public class VentanaConsulta extends JDialog {

	private JScrollPane scrollArea;
	private JTextArea textArea;
	
	public VentanaConsulta(VentanaPrincipal ventanaPrincipal, boolean modal, Hashtable<String, PersonaVo> tablaPersonas) {
		super(ventanaPrincipal,modal);
		initialize();
		setLocationRelativeTo(null);
		//para que en el momento que se de clic en mostrar se 
		//visualice la informacion
		mostrarListaPersonas(tablaPersonas);
	}
	
	private void initialize() {
		setSize(300,208);
		getContentPane().setLayout(null);
		
		textArea=new JTextArea();
		textArea.setBounds(10,50,264,102);
		
		scrollArea = new JScrollPane();
		scrollArea.setBounds(10,50,264,102);
		
		scrollArea = new JScrollPane();
		scrollArea.setBounds(10,50,264,102);
		scrollArea.setViewportView(textArea);
		getContentPane().add(scrollArea);
		
		JLabel lblConsultaDePersona = new JLabel("CONSULTA DE SILLAS");
		lblConsultaDePersona.setBounds(10,11,153,23);
		getContentPane().add(lblConsultaDePersona);
	}
	private void mostrarListaPersonas(Hashtable<String, PersonaVo> tablaPersonas) {
		String mensaje="";
		// nos permite mostrar personas
		//ya que se trabaja con datos numericos
		Enumeration<PersonaVo> elemento=tablaPersonas.elements();
		while(elemento.hasMoreElements()) {
			PersonaVo personaVo = elemento.nextElement();
			mensaje+="Nit: "+personaVo.getNit()+"    Nombre"+personaVo.getNombre()+"\n";
			mensaje+="Edad: "+personaVo.getNlugar()+"    Fecha Nacimiento"+personaVo.getFechaNacimiento()+"\n\n";
		}
		//llamamos el mapeo de los datos que realizamos
		textArea.setText(mensaje);
		
	}

}
