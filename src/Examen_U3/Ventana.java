package Examen_U3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Ventana extends JFrame{

	public Ventana(){
	
		this.setVisible(true);
		this.setBounds(0, 0, 1100, 700); //tamaño login
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Control escolar");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		this.add(this.inicio());

		this.repaint();
		this.revalidate();
	
	}
	

	public JPanel login() {
		Border border = BorderFactory.createLineBorder(Color.decode("#7209b7"), 2);
	
		JPanel mipanel = new JPanel();
		mipanel.setBackground(Color.white);
		mipanel.setOpaque(true); //se necesita para poder ver el color
		mipanel.setSize(1100,700);
		mipanel.setLocation(0, 0);
		mipanel.setLayout(null);//permite poner los elementos donde quieras
		
		ImageIcon imagen1_1 = new ImageIcon("iconoschool.png");
		JLabel iconoschool = new JLabel();
		iconoschool.setSize(200, 200);
		iconoschool.setLocation(100, 0);
		iconoschool.setIcon(new ImageIcon(imagen1_1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		mipanel.add(iconoschool);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(200, 100);
		etiqueta1.setLocation(105, 140);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(new Font ("Verdana", Font.BOLD, 30));
		mipanel.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Ingrese su correo:");
		etiqueta2.setSize(200, 30);
		etiqueta2.setLocation(40, 230);
		etiqueta2.setFont(new Font ("Verdana", Font.BOLD, 16));
		mipanel.add(etiqueta2);		
		
		ImageIcon imagen1 = new ImageIcon("loginIcon.png");
		JLabel iconoLog = new JLabel();
		iconoLog.setSize(30, 30);
		iconoLog.setLocation(40, 260);
		iconoLog.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		iconoLog.setOpaque(true);
		iconoLog.setBackground(Color.decode("#61a5c2"));
		iconoLog.setBorder(border);
		mipanel.add(iconoLog);
		
		JTextField email = new JTextField();
		email.setSize(300, 30);
		email.setLocation(73, 260);
		email.setOpaque(true);
		email.setBackground(Color.decode("#a9d6e5"));
		email.setFont(new Font ("Verdana", Font.BOLD, 16));
		email.setBorder(border);
		mipanel.add(email);
		
		JLabel etiqueta3 = new JLabel("Contraseña:");
		etiqueta3.setSize(200, 30);
		etiqueta3.setLocation(40, 310);
		etiqueta3.setFont(new Font ("Verdana", Font.BOLD, 16));
		mipanel.add(etiqueta3);
		
		ImageIcon imagen2 = new ImageIcon("passIcon.png");
		JLabel iconoPass = new JLabel();
		iconoPass.setSize(30, 30);
		iconoPass.setLocation(40, 340);
		iconoPass.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		iconoPass.setOpaque(true);
		iconoPass.setBackground(Color.decode("#61a5c2"));
		iconoPass.setBorder(border);
		mipanel.add(iconoPass);
		
		JPasswordField  contra = new JPasswordField ();
		contra.setSize(300, 30);
		contra.setLocation(73, 340);
		contra.setOpaque(true);
		contra.setBackground(Color.decode("#a9d6e5"));
		contra.setFont(new Font ("Verdana", Font.BOLD, 16));
		contra.setBorder(border);
		mipanel.add(contra);
		
		JButton acceder = new JButton("ACCEDER");

		acceder.setSize(200, 40);
		acceder.setLocation(105, 420);
		acceder.setBackground(Color.decode("#3a0ca3"));
		acceder.setHorizontalAlignment(JButton.CENTER);
		acceder.setFont(new Font("Verdana", Font.BOLD, 20));
		acceder.setForeground(Color.decode("#FBFBFB"));

		acceder.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        acceder.setBackground(Color.decode("#7209b7"));
		        acceder.repaint();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        acceder.setBackground(Color.decode("#3a0ca3"));
		        acceder.repaint();
		    }
		   
		});
		
		
		acceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean bandera1=false, bandera2=false;
				
				if(email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					email.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bandera1=true;
				}
				
				if(new String(contra.getPassword()).equals("")) {
					contra.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					contra.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bandera2=true;
				
				}
				if(bandera1&&bandera2) {
					if(email.getText().equals("jjimenez_23@uabcs.mx")) {
						if(new String(contra.getPassword()).equals("contraseña")) {
							JOptionPane.showMessageDialog(null, "Beinvenido de nuevo","hello",JOptionPane.WARNING_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "Contraseña o correo invalido","error",JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña o correo invalido","error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		mipanel.add(acceder);
		
		JButton regresarRegistro = new JButton("REGISTRARSE");

		regresarRegistro.setSize(200, 40);
		regresarRegistro.setLocation(105, 500);
		regresarRegistro.setBackground(Color.decode("#DDA853"));
		regresarRegistro.setHorizontalAlignment(JButton.CENTER);
		regresarRegistro.setFont(new Font("Verdana", Font.BOLD, 20));
		regresarRegistro.setForeground(Color.decode("#FBFBFB"));

		regresarRegistro.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	regresarRegistro.setBackground(Color.decode("#16404d"));
		    	regresarRegistro.repaint();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	regresarRegistro.setBackground(Color.decode("#DDA853"));
		    	regresarRegistro.repaint();
		    }
		   
		});
		
		regresarRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//router("register");				
			}
		});
		
		mipanel.add(regresarRegistro);
		
		ImageIcon imagen3 = new ImageIcon("fondoLog.png");
		JLabel fondoLog = new JLabel();
		fondoLog.setSize(700, 700);
		fondoLog.setLocation(430, 0);
		fondoLog.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH)));
		mipanel.add(fondoLog);
		
		return mipanel;
	}
	
	public JPanel inicio() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frame.getRootPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1084, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(30, -10, 100, 100);
		ImageIcon portada1 =new ImageIcon("iconoschool.png");
		lblNewLabel_1 .setIcon(new ImageIcon(portada1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_1);
		
		
		JButton boton_INICIO= new JButton("INICIO");//boton de inicio
		boton_INICIO.setBounds(208, 11, 136, 60);
		panel_1.add(boton_INICIO);
		boton_INICIO.setBackground(Color.decode("#7209b7"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#3a0ca3"));
		boton_GRUPOS.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_GRUPOS.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_MAESTROS = new JButton("MAESTROS");//boton de tarifas
		boton_MAESTROS.setBounds(500, 11, 136, 60);
		panel_1.add(boton_MAESTROS);
		boton_MAESTROS.setBackground(Color.decode("#3a0ca3"));
		boton_MAESTROS.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_MAESTROS.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_MATERIAS = new JButton("MATERIAS");//boton de instructores
		boton_MATERIAS.setBounds(646, 11, 136, 60);
		panel_1.add(boton_MATERIAS);
		boton_MATERIAS.setBackground(Color.decode("#3a0ca3"));
		boton_MATERIAS.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_MATERIAS.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_HORARIOS = new JButton("HORARIOS");//boton de clases 
		boton_HORARIOS.setBounds(792, 11, 136, 60);
		panel_1.add(boton_HORARIOS);
		boton_HORARIOS.setBackground(Color.decode("#3a0ca3"));
		boton_HORARIOS.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_HORARIOS.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>\"");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_MATERIAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_HORARIOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_INICIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1074, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIO");//titulo de inicio 
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 118, 28);
		panel_3.add(lblNewLabel);
		
		ImageIcon icono = new ImageIcon("grupo.png"); // Carga el icono
		JButton boton_GRUPOS_1 = new JButton("GRUPOS", icono);
		Image imagenOriginal = icono.getImage();
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
		boton_GRUPOS_1.setIcon(iconoRedimensionado);
		boton_GRUPOS_1.setHorizontalTextPosition(SwingConstants.CENTER);
		boton_GRUPOS_1.setVerticalTextPosition(SwingConstants.BOTTOM);  
		boton_GRUPOS_1.setForeground(Color.white);
		boton_GRUPOS_1.setFont(new Font("Verdana", Font.BOLD, 22));
		boton_GRUPOS_1.setBackground(Color.decode("#7209b7"));
		boton_GRUPOS_1.setBounds(75, 150, 190, 270);
		panel_2.add(boton_GRUPOS_1);
		
		ImageIcon icono2 = new ImageIcon("maestro.png");
		JButton boton_MAESTROS_1 = new JButton("MAESTROS",icono2);
		Image imagenOriginal2 = icono2.getImage();
		Image imagenRedimensionada2 = imagenOriginal2.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenRedimensionada2);
		boton_MAESTROS_1.setIcon(iconoRedimensionado2);
		boton_MAESTROS_1.setHorizontalTextPosition(SwingConstants.CENTER);
		boton_MAESTROS_1.setVerticalTextPosition(SwingConstants.BOTTOM);  
		boton_MAESTROS_1.setForeground(Color.white);
		boton_MAESTROS_1.setFont(new Font("Verdana", Font.BOLD, 22));
		boton_MAESTROS_1.setBackground(Color.decode("#7209b7"));
		boton_MAESTROS_1.setBounds(315, 150, 190, 270);
		panel_2.add(boton_MAESTROS_1);
		
		ImageIcon icono3 = new ImageIcon("materia.png");
		JButton boton_MATERIAS_1 = new JButton("MATERIAS",icono3);
		Image imagenOriginal3 = icono3.getImage();
		Image imagenRedimensionada3 = imagenOriginal3.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenRedimensionada3);
		boton_MATERIAS_1.setIcon(iconoRedimensionado3);
		boton_MATERIAS_1.setHorizontalTextPosition(SwingConstants.CENTER);
		boton_MATERIAS_1.setVerticalTextPosition(SwingConstants.BOTTOM);  
		boton_MATERIAS_1.setForeground(Color.white);
		boton_MATERIAS_1.setFont(new Font("Verdana", Font.BOLD, 22));
		boton_MATERIAS_1.setBackground(Color.decode("#7209b7"));
		boton_MATERIAS_1.setBounds(555, 150, 190, 270);
		panel_2.add(boton_MATERIAS_1);
		
		ImageIcon icono4 = new ImageIcon("horario.png");
		JButton boton_HORARIOS_1 = new JButton("HORARIOS",icono4);
		Image imagenOriginal4 = icono4.getImage();
		Image imagenRedimensionada4 = imagenOriginal4.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenRedimensionada4);
		boton_HORARIOS_1.setIcon(iconoRedimensionado4);
		boton_HORARIOS_1.setHorizontalTextPosition(SwingConstants.CENTER);
		boton_HORARIOS_1.setVerticalTextPosition(SwingConstants.BOTTOM);  
		boton_HORARIOS_1.setForeground(Color.white);
		boton_HORARIOS_1.setFont(new Font("Verdana", Font.BOLD, 22));
		boton_HORARIOS_1.setBackground(Color.decode("#7209b7"));
		boton_HORARIOS_1.setBounds(795, 150, 190, 270);
		panel_2.add(boton_HORARIOS_1);
		
		
		
		
		return frame;
	}

	
}