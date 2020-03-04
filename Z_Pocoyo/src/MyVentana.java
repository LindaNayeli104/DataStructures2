import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;


public class MyVentana extends JFrame {
	
	//constructor
	public MyVentana(){
		super("My primer ventana en java");//titulo
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // terminar el programa
		
		MyPanelDibujo pd = new MyPanelDibujo();
		this.add(pd); // agregar ventana
		this.add(new MyPanelControles(pd), BorderLayout.WEST); // los contedores (los paneles center, north, west, south)
		//ajustar 
		this.pack(); //pregutunta el tamaño y se ajusta al tamaño de cada uno 
		this.setVisible(true); //Mostrar la ventana
		
	}
	
	/*
	public void paint(Graphics g){
		super.paint(g); //mandar a llamar al padre(JFrame)
		 
	}*/

	public static void main(String[] args) {
		//AWT es para interactuar nativa con el sistema operativo 
		//Swin es más independiente el comportamiento
		// Ventanas son frames of JFrame
		MyVentana v = new MyVentana();

	}

}