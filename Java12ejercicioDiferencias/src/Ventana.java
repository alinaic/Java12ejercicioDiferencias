import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

	// private es que el elemento solo lo puedo usar desde dentro de la clase
	// public es que lo puedo usar desde cualquier sitio

	private Image original = null;
	private Image diferencia = null;

	// null que este obj no esta inicializado
	// un constructor es un metodo que se ejecuta
	// cuando se crea un objeto de la clase

	public Ventana() {

		// vamos a cargar las imagenes:

		try {
			original = ImageIO.read(new File("original.jpg"));
			diferencia = ImageIO.read(new File("diferencia.jpg"));
		} catch (IOException e) {
			System.out.println("no pude cargar la imagen");
			System.exit(-1);// forzar a que la aplicacion termine
		}
		// esto es un constructor que se ejecutara cuando se haga
		// un new Ventana();
		// este es un sitio odeal para preparar al objeto

		this.setSize(800, 400);
		this.setVisible(true);
		// en este caso this, seris lo mismo que
		// poner miVentana desde el principal
		this.setLocation(100, 100);
		this.setTitle("Haz click en la diferencia de la derecha");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// agrego un escuchador del raton para saber
		// donde va haciendo click el usuario

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			// suelte la techa

			@Override
			public void mousePressed(MouseEvent e) {
			}

			// la pulse

			@Override
			public void mouseExited(MouseEvent e) {
			}

			// cuando sale el raton

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			// cuando el raton ha entrado en la ventana

			@Override
			public void mouseClicked(MouseEvent e) {
				// pulsar o soltar

				int x = e.getX();
				int y = e.getY();
				System.out.println("click en: x: " + x + " y: " + y);
				if (x >= 444 && x <= 486 && y >= 31 && y <= 89) {

					JOptionPane.showMessageDialog(null,
							"Felicidades adivinastes la diferencia");
				} else {
					JOptionPane.showMessageDialog(null,
							"Fallastes, intentalo de nuevo");
				}
			}

		});

		// this hace referencia al objeto
		// que se creó usando el new Ventana
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// g.setColor(Color.blue);
		// g.fillRect(50, 50, 100, 200);

		g.drawImage(original, 0, 30, 400, 400, null);
		g.drawImage(diferencia, 400, 30, 400, 400, null);

	}

}
