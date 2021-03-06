import java.awt.Dimension;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import java.lang.InterruptedException;

public class MyPanelDibujo extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	// UN panel es un area gr�fica
	private Image fondo,
				  face;
	
	private int xV,
				yV,
				xS,
				yS;
	
	private String nombre;
	
	private boolean mover; 
	
	private Color colorGlobo;
	private BolitaGrafica[] bolita;
	
	
	
	public MyPanelDibujo(){
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(1000, 800));
		this.fondo = new ImageIcon("pocoyo.jpg").getImage();
		this.face = new ImageIcon("pocoyo2.png").getImage();
		this.xV = this.yV=0;
		this.xS = 115;
		this.yS = 520;
		this.bolita = new BolitaGrafica[10];
		for (int i = 0; i < this.bolita.length;i++){
			this.bolita[i] = new BolitaGrafica();
		}
		this.colorGlobo = Color.RED;
		this.nombre = "Pocoyo";
		Thread hilo = new Thread(this);
		hilo.start();
		
		
	}

	//Llama funciones
	public void paintComponent(Graphics g ){
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
		this.pintaNave(g);
		this.pintaTexto(g);
		this.pintaAsteroides(g);
	}
	
	//Pinta Circulos
	public void pintaAsteroides(Graphics g){
		for (int i = 0; i < this.bolita.length;i++){
			this.bolita[i].pinta(g);
		}
	}
	
	//Pinta nave
	public void pintaNave(Graphics g){
		g.setColor(Color.ORANGE);//Nave
		g.fillOval(this.xV+50, this.yV+ 450, 200, 100);
		
		g.setColor(Color.CYAN); //Ventana
		g.fillArc(this.xV+50, this.yV+ 450, 200, 100, 0, 100);
		
		g.drawImage(this.face, this.xV+160, this.yV+457, 40, 40, this);
		
		
		g.setColor(Color.WHITE);//Hilo
		g.drawLine(this.xV+ 100, this.yV+ 457, this.xV+ 100, this.yV+ 400);
		
		g.setColor(colorGlobo);//Globo
		g.fillOval(this.xV+ 50, this.yV+ 300, 100, 100);
	}
	
	//Pinta nombre
	public void pintaTexto(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("Vamos " + this.nombre + "!" , this.xS, this.yS );
	}
	
	//Setters
	public void setNombre (String nombre){
		this.nombre = nombre;
		// Repintarse 
	}
	
	public void setYV(int yV){
		this.yV = yV;
		repaint();
	}
	
	public void setXV(int xV){
		this.xV = xV;
		repaint();
	}
	
	public void setColorGlobo(Color colorGlobo){ // color del panel 
		this.colorGlobo = colorGlobo;
		repaint();
	}
	
	
	//Getters
	public int getXV(){
		return this.xV;
	}
	
	public int getYV(){
		return this.yV;
	}
	
	
	//Hilo 
	@Override
	public void run() {
		while(this.xV <= 750){
			try {
				if (mover){
					this.xV+=2;
					this.yV--;	
					this.repaint();
					}	
			Thread.sleep(50);
			}catch (InterruptedException ex){
					System.out.println("No puede despertar!!!!");
				}
			}	
		}
		

	
	// mOuse listener
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.mover = true;	
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		
		
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		
		
	}


	//Mouse Motion listener
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		//System.out.println(e.getX()+" "+e.getY()); //movimiento de los 
		this.xS = e.getX();
		this.yS = e.getY();
		repaint();
	}


	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}