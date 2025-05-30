package Examen_U3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DocumentFilter.FilterBypass;


public class Ventana extends JFrame{
	private DefaultTableModel model;
	private JTable table;
	public Ventana(){
		
	
		this.setVisible(true);
		this.setBounds(0, 0, 1100, 700); //tamaño login
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Control escolar");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		this.add(this.login());

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
							router("inicio");
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
		
		ImageIcon imagen3 = new ImageIcon("fondoLog.png");
		JLabel fondoLog = new JLabel();
		fondoLog.setSize(700, 700);
		fondoLog.setLocation(430, 0);
		fondoLog.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH)));
		mipanel.add(fondoLog);
		
		return mipanel;
	}
	
	public void router(String route) {
		this.getContentPane().removeAll();
		
		if(route.equals("login")) {
			this.add(this.login());
		}
		
		if(route.equals("inicio")) {
			this.add(this.inicio());
		}
		
		if(route.equals("grupos")) {
			this.add(this.grupos());
		}
		
		if(route.equals("alumnos")) {
			this.add(this.alumnos());
		}
		
		if(route.equals("añadirAlumno")) {
			this.add(this.añadirAlumno());
		}
		if(route.equals("infoAlumno")) {
			this.add(this.infoAlumno());
		}
		if(route.equals("editAlumno")) {
			this.add(this.editAlumno());
		}
		if(route.equals("maestros")) {
			this.add(this.maestros());
		}
		if(route.equals("añadirMaestro")) {
			this.add(this.añadirMaestro());
		}
		if(route.equals("infoMaestro")) {
			this.add(this.infoMaestro());
		}
		if(route.equals("editMaestro")) {
			this.add(this.editMaestro());
		}
		
		this.repaint();
		this.revalidate();
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
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
		boton_GRUPOS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		
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
		boton_MAESTROS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
			}
		});
		
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

	public JPanel grupos() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
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
		
		JLabel lblNewLabel = new JLabel("GRUPOS");//titulo de inicio 
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 156, 28);
		panel_3.add(lblNewLabel);
		
		ImageIcon icono = new ImageIcon("grupo.png"); // Carga el icono
		JButton boton_GRUPOS_1 = new JButton("GRUPO A", icono);
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
		boton_GRUPOS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("alumnos");
			}
		});
		
		ImageIcon icono2 = new ImageIcon("grupo.png");
		JButton boton_MAESTROS_1 = new JButton("GRUPO B",icono2);
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
		boton_MAESTROS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("alumnos");
			}
		});
		
		ImageIcon icono3 = new ImageIcon("grupo.png");
		JButton boton_MATERIAS_1 = new JButton("GRUPO C",icono3);
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
		boton_MATERIAS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("alumnos");
			}
		});
		
		ImageIcon icono4 = new ImageIcon("grupo.png");
		JButton boton_HORARIOS_1 = new JButton("GRUPO D",icono4);
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
		boton_HORARIOS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("alumnos");
			}
		});
		
		return frame;
	}

	public JPanel alumnos() {
		
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);

		// Datos de ejemplo
		Object[][] data = {
			{2023078840, "Jesús Pastor", "Jiménez", "6121273088", "jesus@mail.com", "", ""},
			{2023078841, "Laura", "Martínez", "6121286451", "laura@mail.com", "", ""}
		};

		String[] columnNames = {"No. control", "Nombre", "Primer Apellido", "Teléfono", "Correo", "Consulta", "Eliminar"};

		model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5 || column == 6;
			}
		};

		table = new JTable(model);
		table.setFont(new Font("Verdana", Font.BOLD, 12));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(30);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.decode("#3a0ca3"));
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Verdana", Font.BOLD, 14));
		header.setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		class ButtonRenderer extends JButton implements TableCellRenderer {
	        public ButtonRenderer(String label) {
	            setOpaque(true);
	            setForeground(Color.BLACK);
	            setBackground(new Color(255, 205, 17));
	            setFont(new Font("Verdana", Font.BOLD, 14));
	            setHorizontalAlignment(SwingConstants.CENTER);

	            if (label.equals("Consulta")) {
	                setIcon(loadIcon("consulta.png"));
	                setBackground(Color.decode("#7209b7")); 
	            } else if (label.equals("Eliminar")) {
	                setIcon(loadIcon("eliminar.png"));
	                setBackground(new Color(205, 0, 0)); 
	            }
	            setText(null);  
	        }

	        private ImageIcon loadIcon(String path) {
	            ImageIcon icon = new ImageIcon(path);
	            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	            return new ImageIcon(img);
	        }

	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value,
	                boolean isSelected, boolean hasFocus, int row, int column) {
	            return this;
	        }
	    }

	    // Clase interna para editar botones
	    class ButtonEditor extends DefaultCellEditor {
	        protected JButton button;
	        private String label;
	        private boolean clicked;
	        private int row;
	        private JTable table;

	        public ButtonEditor(JCheckBox checkBox, String label, JTable table) {
	            super(checkBox);
	            this.label = label;
	            this.table = table;
	            button = new JButton();
	            button.setOpaque(true);
	            button.setForeground(Color.BLACK);
	            button.setBackground(new Color(255, 205, 17));
	            button.setFont(new Font("Verdana", Font.PLAIN, 14));
	            button.setHorizontalAlignment(SwingConstants.CENTER);

	            if (label.equals("Consulta")) {
	                button.setIcon(loadIcon("Imagenes/editar.png"));
	            } else if (label.equals("Eliminar")) {
	                button.setIcon(loadIcon("Imagenes/eliminar.png"));
	            }
	            button.setText(null);

	            button.addActionListener(e -> fireEditingStopped());
	        }

	        private ImageIcon loadIcon(String path) {
	            ImageIcon icon = new ImageIcon(path);
	            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	            return new ImageIcon(img);
	        }

	        @Override
	        public Component getTableCellEditorComponent(JTable table, Object value,
	                boolean isSelected, int row, int column) {
	            this.row = row;
	            clicked = true;
	            return button;
	        }

	        @Override
	        public Object getCellEditorValue() {
	            if (clicked) {
	                if (label.equals("Eliminar")) {
	                	 int confirm = JOptionPane.showConfirmDialog(
	                             null, 
	                             "¿Seguro que deseas eliminar este registro?", 
	                             "Confirmar eliminación", 
	                             JOptionPane.YES_NO_OPTION
	                         );
	                         if (confirm == JOptionPane.YES_OPTION) {
	                             JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
	                         }
	                } else if (label.equals("Consulta")) {
	                	router("infoAlumno");
	                }
	            }
	            clicked = false;
	            return label;
	        }

	        @Override
	        public boolean stopCellEditing() {
	            clicked = false;
	            return super.stopCellEditing();
	        }

	        @Override
	        protected void fireEditingStopped() {
	            super.fireEditingStopped();
	        }
	    }
		
		// Renderizar botones en la tabla
		table.getColumn("Consulta").setCellRenderer(new ButtonRenderer("Consulta"));
		table.getColumn("Consulta").setCellEditor(new ButtonEditor(new JCheckBox(), "Consulta", table));

		table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer("Eliminar"));
		table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(), "Eliminar", table));

		// Botón Añadir cliente 
		JButton boton_Añadir_alumno = new JButton("Añadir alumno");
		boton_Añadir_alumno.setForeground(new Color(255, 255, 255));
		boton_Añadir_alumno.setBackground(Color.decode("#7209b7"));
		boton_Añadir_alumno.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Añadir_alumno.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Añadir_alumno);
		boton_Añadir_alumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("añadirAlumno");
			}
		});
		
		

	    return frame;
	}

	public JPanel infoAlumno() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Jesús Pastor");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 124, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Jiménez");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 124, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Carrillo");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("jesus@gmail.com");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 161, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("6121273088");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("21/07/1996");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(680, 243, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("2023078840");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 124, 32);
		panel_4.add(lblNewLabel_2_4_1);

		

		// Botón Añadir cliente 
		JButton boton_Editar= new JButton("Editar");
		boton_Editar.setForeground(new Color(255, 255, 255));
		boton_Editar.setBackground(Color.decode("#7209b7"));
		boton_Editar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Editar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Editar);
		boton_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("editAlumno");
			}
		});
		
		JButton boton_Descarga = new JButton("Descargar");
		boton_Descarga.setForeground(Color.WHITE);
		boton_Descarga.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Descarga.setBackground(new Color(114, 9, 183));
		boton_Descarga.setBounds(628, 521, 208, 31);
		panel_2.add(boton_Descarga);
		boton_Descarga.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null, "Descarga completada con éxito.");
		    }
		});
		
		JButton boton_regresar = new JButton("Regresar");
		boton_regresar.setForeground(Color.WHITE);
		boton_regresar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_regresar.setBackground(new Color(205, 0, 0));
		boton_regresar.setBounds(410, 521, 208, 31);
		panel_2.add(boton_regresar);
		boton_regresar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas regresar?",
		            "Confirma regresar",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("alumnos"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
		
	}

	public JPanel editAlumno() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JTextField lblNewLabel_2_1 = new JTextField("Jesús Pastor");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JTextField lblNewLabel_2_1_1 = new JTextField("Jiménez");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JTextField lblNewLabel_2_1_1_1 = new JTextField("Carrillo");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JTextField lblNewLabel_2_1_2 = new JTextField("jesus@gmail.com");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JTextField lblNewLabel_2_1_1_2 = new JTextField("6121273088");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		((AbstractDocument) lblNewLabel_2_1_1_2.getDocument()).setDocumentFilter(new DocumentFilter() {
		    private static final int MAX_LENGTH = 10;

		    @Override
		    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        if (string != null && string.matches("\\d+") && fb.getDocument().getLength() + string.length() <= MAX_LENGTH) {
		            super.insertString(fb, offset, string, attr);
		        }
		    }

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        if (text != null && text.matches("\\d+") && fb.getDocument().getLength() - length + text.length() <= MAX_LENGTH) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);

		try {
		    // Formato: dd/MM/yyyy
		    MaskFormatter dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter('_');  // Caracter visible para los espacios vacíos

		    JFormattedTextField fechaNacimiento = new JFormattedTextField(dateMask);
		    fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		    fechaNacimiento.setBounds(680, 243, 200, 32);
		    fechaNacimiento.setText("21/07/1996");  // Valor por defecto (puedes dejarlo vacío si prefieres)
		    panel_4.add(fechaNacimiento);

		} catch (java.text.ParseException e) {
		    e.printStackTrace(); // Manejo de error si hay problema con la máscara
		}
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JTextField lblNewLabel_2_4_1 = new JTextField("2023078840");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 140, 32);
		panel_4.add(lblNewLabel_2_4_1);

		// Botón Añadir cliente 
		JButton boton_Confirmar = new JButton("Confirmar");
		boton_Confirmar.setForeground(new Color(255, 255, 255));
		boton_Confirmar.setBackground(Color.decode("#7209b7"));
		boton_Confirmar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Confirmar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Confirmar);
		boton_Confirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas confirmar?",
		            "Confirma la información",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("infoAlumno"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setForeground(Color.WHITE);
		boton_cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_cancelar.setBackground(new Color(205, 0, 0));
		boton_cancelar.setBounds(628, 521, 208, 31);
		panel_2.add(boton_cancelar);
		boton_cancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas cancelar?",
		            "Confirmar cancelación",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("infoAlumno"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
		
		
	}
	
	public JPanel añadirAlumno() {
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
		boton_INICIO.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_INICIO.setForeground(Color.decode("#FBFBFB"));
		
		JButton boton_GRUPOS = new JButton("GRUPOS");//boton de clientes
		boton_GRUPOS.setBounds(354, 11, 136, 60);
		panel_1.add(boton_GRUPOS);
		boton_GRUPOS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("ALUMNOS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JTextField lblNewLabel_2_1 = new JTextField("");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JTextField lblNewLabel_2_1_1 = new JTextField("");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JTextField lblNewLabel_2_1_1_1 = new JTextField("");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JTextField lblNewLabel_2_1_2 = new JTextField("");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JTextField lblNewLabel_2_1_1_2 = new JTextField("");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		((AbstractDocument) lblNewLabel_2_1_1_2.getDocument()).setDocumentFilter(new DocumentFilter() {
		    private static final int MAX_LENGTH = 10;

		    @Override
		    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        if (string != null && string.matches("\\d+") && fb.getDocument().getLength() + string.length() <= MAX_LENGTH) {
		            super.insertString(fb, offset, string, attr);
		        }
		    }

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        if (text != null && text.matches("\\d+") && fb.getDocument().getLength() - length + text.length() <= MAX_LENGTH) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);

		try {
		    // Formato: dd/MM/yyyy
		    MaskFormatter dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter('_');  // Caracter visible para los espacios vacíos

		    JFormattedTextField fechaNacimiento = new JFormattedTextField(dateMask);
		    fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		    fechaNacimiento.setBounds(680, 243, 200, 32);
		    fechaNacimiento.setText("");  // Valor por defecto (puedes dejarlo vacío si prefieres)
		    panel_4.add(fechaNacimiento);

		} catch (java.text.ParseException e) {
		    e.printStackTrace(); // Manejo de error si hay problema con la máscara
		}
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JTextField lblNewLabel_2_4_1 = new JTextField("");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 140, 32);
		panel_4.add(lblNewLabel_2_4_1);

		// Botón Añadir cliente 
		JButton boton_Confirmar = new JButton("Confirmar");
		boton_Confirmar.setForeground(new Color(255, 255, 255));
		boton_Confirmar.setBackground(Color.decode("#7209b7"));
		boton_Confirmar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Confirmar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Confirmar);
		boton_Confirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas confirmar?",
		            "Confirma la información",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("alumnos"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setForeground(Color.WHITE);
		boton_cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_cancelar.setBackground(new Color(205, 0, 0));
		boton_cancelar.setBounds(628, 521, 208, 31);
		panel_2.add(boton_cancelar);
		boton_cancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas cancelar?",
		            "Confirmar cancelación",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("alumnos"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
	}

	public JPanel maestros() {
		
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
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
		boton_MAESTROS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("MAESTROS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);

		// Datos de ejemplo
		Object[][] data = {
			{2020078651, "Jesús", "López", "6121846218", "jesuslop@mail.com", "", ""},
			{2021078145, "Luisa", "Martínez", "6121235151", "luisa@mail.com", "", ""}
		};

		String[] columnNames = {"No. control", "Nombre", "Primer Apellido", "Teléfono", "Correo", "Consulta", "Eliminar"};

		model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5 || column == 6;
			}
		};

		table = new JTable(model);
		table.setFont(new Font("Verdana", Font.BOLD, 12));
		table.setBackground(new Color(204, 204, 204));
		table.setRowHeight(30);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.decode("#3a0ca3"));
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Verdana", Font.BOLD, 14));
		header.setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		class ButtonRenderer extends JButton implements TableCellRenderer {
	        public ButtonRenderer(String label) {
	            setOpaque(true);
	            setForeground(Color.BLACK);
	            setBackground(new Color(255, 205, 17));
	            setFont(new Font("Verdana", Font.BOLD, 14));
	            setHorizontalAlignment(SwingConstants.CENTER);

	            if (label.equals("Consulta")) {
	                setIcon(loadIcon("consulta.png"));
	                setBackground(Color.decode("#7209b7")); 
	            } else if (label.equals("Eliminar")) {
	                setIcon(loadIcon("eliminar.png"));
	                setBackground(new Color(205, 0, 0)); 
	            }
	            setText(null);  
	        }

	        private ImageIcon loadIcon(String path) {
	            ImageIcon icon = new ImageIcon(path);
	            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	            return new ImageIcon(img);
	        }

	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value,
	                boolean isSelected, boolean hasFocus, int row, int column) {
	            return this;
	        }
	    }

	    // Clase interna para editar botones
	    class ButtonEditor extends DefaultCellEditor {
	        protected JButton button;
	        private String label;
	        private boolean clicked;
	        private int row;
	        private JTable table;

	        public ButtonEditor(JCheckBox checkBox, String label, JTable table) {
	            super(checkBox);
	            this.label = label;
	            this.table = table;
	            button = new JButton();
	            button.setOpaque(true);
	            button.setForeground(Color.BLACK);
	            button.setBackground(new Color(255, 205, 17));
	            button.setFont(new Font("Verdana", Font.PLAIN, 14));
	            button.setHorizontalAlignment(SwingConstants.CENTER);

	            if (label.equals("Consulta")) {
	                button.setIcon(loadIcon("consulta.png"));
	            } else if (label.equals("Eliminar")) {
	                button.setIcon(loadIcon("eliminar.png"));
	            }
	            button.setText(null);

	            button.addActionListener(e -> fireEditingStopped());
	        }

	        private ImageIcon loadIcon(String path) {
	            ImageIcon icon = new ImageIcon(path);
	            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	            return new ImageIcon(img);
	        }

	        @Override
	        public Component getTableCellEditorComponent(JTable table, Object value,
	                boolean isSelected, int row, int column) {
	            this.row = row;
	            clicked = true;
	            return button;
	        }

	        @Override
	        public Object getCellEditorValue() {
	            if (clicked) {
	                if (label.equals("Eliminar")) {
	                	 int confirm = JOptionPane.showConfirmDialog(
	                             null, 
	                             "¿Seguro que deseas eliminar este registro?", 
	                             "Confirmar eliminación", 
	                             JOptionPane.YES_NO_OPTION
	                         );
	                         if (confirm == JOptionPane.YES_OPTION) {
	                             JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
	                         }
	                } else if (label.equals("Consulta")) {
	                	router("infoMaestro");
	                }
	            }
	            clicked = false;
	            return label;
	        }

	        @Override
	        public boolean stopCellEditing() {
	            clicked = false;
	            return super.stopCellEditing();
	        }

	        @Override
	        protected void fireEditingStopped() {
	            super.fireEditingStopped();
	        }
	    }
		
		// Renderizar botones en la tabla
		table.getColumn("Consulta").setCellRenderer(new ButtonRenderer("Consulta"));
		table.getColumn("Consulta").setCellEditor(new ButtonEditor(new JCheckBox(), "Consulta", table));

		table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer("Eliminar"));
		table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JCheckBox(), "Eliminar", table));

		// Botón Añadir maestro 
		JButton boton_Añadir_maestro = new JButton("Añadir Maestro");
		boton_Añadir_maestro.setForeground(new Color(255, 255, 255));
		boton_Añadir_maestro.setBackground(Color.decode("#7209b7"));
		boton_Añadir_maestro.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Añadir_maestro.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Añadir_maestro);
		boton_Añadir_maestro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("añadirMaestro");
			}
		});
		
		

	    return frame;
	}
	
	public JPanel infoMaestro() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
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
		boton_MAESTROS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("MAESTROS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Jesús");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 124, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("López");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 124, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel labelGrado = new JLabel("Grado de estudios:");
		labelGrado.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado.setBounds(433, 273, 250, 32);
		panel_4.add(labelGrado);
		
		JLabel labelGrado_1 = new JLabel("Licenciatura");
		labelGrado_1.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado_1.setBounds(433, 300, 200, 32);
		panel_4.add(labelGrado_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("jesusLop@gmail.com");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 250, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("6121273088");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("15/11/1990");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(680, 243, 124, 32);
		panel_4.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("2023078840");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 124, 32);
		panel_4.add(lblNewLabel_2_4_1);

		

		// Botón Añadir cliente 
		JButton boton_Editar= new JButton("Editar");
		boton_Editar.setForeground(new Color(255, 255, 255));
		boton_Editar.setBackground(Color.decode("#7209b7"));
		boton_Editar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Editar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Editar);
		boton_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("editMaestro");
			}
		});
		
		JButton boton_Descarga = new JButton("Descargar");
		boton_Descarga.setForeground(Color.WHITE);
		boton_Descarga.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Descarga.setBackground(new Color(114, 9, 183));
		boton_Descarga.setBounds(628, 521, 208, 31);
		panel_2.add(boton_Descarga);
		boton_Descarga.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null, "Descarga completada con éxito.");
		    }
		});
		
		JButton boton_regresar = new JButton("Regresar");
		boton_regresar.setForeground(Color.WHITE);
		boton_regresar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_regresar.setBackground(new Color(205, 0, 0));
		boton_regresar.setBounds(410, 521, 208, 31);
		panel_2.add(boton_regresar);
		boton_regresar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas regresar?",
		            "Confirma regresar",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("maestros"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
		
	}

	public JPanel editMaestro() {
		
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
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
		boton_MAESTROS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("MAESTROS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JTextField lblNewLabel_2_1 = new JTextField("Jesús");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JTextField lblNewLabel_2_1_1 = new JTextField("López");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JTextField lblNewLabel_2_1_1_1 = new JTextField("");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel labelGrado = new JLabel("Grado de estudios:");
		labelGrado.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado.setBounds(433, 273, 250, 32);
		panel_4.add(labelGrado);
		
		JTextField labelGrado_1 = new JTextField("Licenciatura");
		labelGrado_1.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado_1.setBounds(433, 300, 200, 32);
		panel_4.add(labelGrado_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JTextField lblNewLabel_2_1_2 = new JTextField("jesusLop@gmail.com");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JTextField lblNewLabel_2_1_1_2 = new JTextField("6121273088");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		((AbstractDocument) lblNewLabel_2_1_1_2.getDocument()).setDocumentFilter(new DocumentFilter() {
		    private static final int MAX_LENGTH = 10;

		    @Override
		    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        if (string != null && string.matches("\\d+") && fb.getDocument().getLength() + string.length() <= MAX_LENGTH) {
		            super.insertString(fb, offset, string, attr);
		        }
		    }

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        if (text != null && text.matches("\\d+") && fb.getDocument().getLength() - length + text.length() <= MAX_LENGTH) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);

		try {
		    // Formato: dd/MM/yyyy
		    MaskFormatter dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter('_');  // Caracter visible para los espacios vacíos

		    JFormattedTextField fechaNacimiento = new JFormattedTextField(dateMask);
		    fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		    fechaNacimiento.setBounds(680, 243, 200, 32);
		    fechaNacimiento.setText("15/11/1990");  // Valor por defecto (puedes dejarlo vacío si prefieres)
		    panel_4.add(fechaNacimiento);

		} catch (java.text.ParseException e) {
		    e.printStackTrace(); // Manejo de error si hay problema con la máscara
		}
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JTextField lblNewLabel_2_4_1 = new JTextField("2023078840");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 140, 32);
		panel_4.add(lblNewLabel_2_4_1);

		// Botón Añadir cliente 
		JButton boton_Confirmar = new JButton("Confirmar");
		boton_Confirmar.setForeground(new Color(255, 255, 255));
		boton_Confirmar.setBackground(Color.decode("#7209b7"));
		boton_Confirmar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Confirmar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Confirmar);
		boton_Confirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas confirmar?",
		            "Confirma la información",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("infoMaestro"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setForeground(Color.WHITE);
		boton_cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_cancelar.setBackground(new Color(205, 0, 0));
		boton_cancelar.setBounds(628, 521, 208, 31);
		panel_2.add(boton_cancelar);
		boton_cancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas cancelar?",
		            "Confirmar cancelación",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("infoMaestro"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
		
		
	}

	public JPanel añadirMaestro() {
		JPanel frame = new JPanel();
		frame.setBackground(Color.white);
		frame.setOpaque(true); //se necesita para poder ver el color
		frame.setSize(1100,700);
		frame.setLocation(0, 0);
		frame.setLayout(null);//permite poner los elementos donde quieras
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1100, 700);
		frame.add(panel);
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
		boton_INICIO.setBackground(Color.decode("#3a0ca3"));
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
		boton_MAESTROS.setBackground(Color.decode("#7209b7"));
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
		
		JButton boton_CERRAR_SESION = new JButton("<html>CERRAR<br>SESION</html>");//boton de cerrar sesion 
		boton_CERRAR_SESION.setBounds(938, 11, 136, 60);
		panel_1.add(boton_CERRAR_SESION);
		boton_CERRAR_SESION.setBackground(Color.decode("#3a0ca3"));
		boton_CERRAR_SESION.setFont(new Font("Verdana", Font.BOLD, 16));
		boton_CERRAR_SESION.setForeground(Color.decode("#FBFBFB"));
		boton_CERRAR_SESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("login");
			}
		});
		boton_GRUPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("grupos");
			}
		});
		boton_MAESTROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				router("maestros");
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
				router("inicio");
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 1064, 564);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#7209b7"));
		panel_3.setBounds(0, 0, 1064, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("MAESTROS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 11, 193, 28);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 1064, 450);
		panel_2.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(154, 68, 194, 192);
		ImageIcon perfil =new ImageIcon("perfil.png");
		lblNewLabel_1_1 .setIcon(new ImageIcon(perfil.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(433, 97, 124, 32);
		panel_4.add(lblNewLabel_2);
		
		JTextField lblNewLabel_2_1 = new JTextField("");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(433, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Primer apellido:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(433, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2);
		
		JTextField lblNewLabel_2_1_1 = new JTextField("");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(433, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Segundo apellido:");
		lblNewLabel_2_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(433, 216, 161, 32);
		panel_4.add(lblNewLabel_2_2_1);
		
		JTextField lblNewLabel_2_1_1_1 = new JTextField("");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(433, 243, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel labelGrado = new JLabel("Grado de estudios:");
		labelGrado.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado.setBounds(433, 273, 250, 32);
		panel_4.add(labelGrado);
		
		JTextField labelGrado_1 = new JTextField("");
		labelGrado_1.setFont(new Font("Verdana", Font.BOLD, 14));
		labelGrado_1.setBounds(433, 300, 200, 32);
		panel_4.add(labelGrado_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(680, 97, 124, 32);
		panel_4.add(lblNewLabel_2_3);
		
		JTextField lblNewLabel_2_1_2 = new JTextField("");
		lblNewLabel_2_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(680, 122, 200, 32);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Telefono:");
		lblNewLabel_2_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(680, 159, 161, 32);
		panel_4.add(lblNewLabel_2_2_2);
		
		JTextField lblNewLabel_2_1_1_2 = new JTextField("");
		lblNewLabel_2_1_1_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(680, 186, 200, 32);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		((AbstractDocument) lblNewLabel_2_1_1_2.getDocument()).setDocumentFilter(new DocumentFilter() {
		    private static final int MAX_LENGTH = 10;

		    @Override
		    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		        if (string != null && string.matches("\\d+") && fb.getDocument().getLength() + string.length() <= MAX_LENGTH) {
		            super.insertString(fb, offset, string, attr);
		        }
		    }

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        if (text != null && text.matches("\\d+") && fb.getDocument().getLength() - length + text.length() <= MAX_LENGTH) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(680, 216, 188, 32);
		panel_4.add(lblNewLabel_2_2_1_1);

		try {
		    // Formato: dd/MM/yyyy
		    MaskFormatter dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter('_');  // Caracter visible para los espacios vacíos

		    JFormattedTextField fechaNacimiento = new JFormattedTextField(dateMask);
		    fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		    fechaNacimiento.setBounds(680, 243, 200, 32);
		    fechaNacimiento.setText("");  // Valor por defecto (puedes dejarlo vacío si prefieres)
		    panel_4.add(fechaNacimiento);

		} catch (java.text.ParseException e) {
		    e.printStackTrace(); // Manejo de error si hay problema con la máscara
		}
		
		JLabel lblNewLabel_2_4 = new JLabel("No. control:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(192, 256, 124, 32);
		panel_4.add(lblNewLabel_2_4);
		
		JTextField lblNewLabel_2_4_1 = new JTextField("");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(192, 285, 140, 32);
		panel_4.add(lblNewLabel_2_4_1);

		// Botón Añadir cliente 
		JButton boton_Confirmar = new JButton("Confirmar");
		boton_Confirmar.setForeground(new Color(255, 255, 255));
		boton_Confirmar.setBackground(Color.decode("#7209b7"));
		boton_Confirmar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_Confirmar.setBounds(846, 521, 208, 31);
		panel_2.add(boton_Confirmar);
		boton_Confirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas confirmar?",
		            "Confirma la información",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("maestros"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setForeground(Color.WHITE);
		boton_cancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		boton_cancelar.setBackground(new Color(205, 0, 0));
		boton_cancelar.setBounds(628, 521, 208, 31);
		panel_2.add(boton_cancelar);
		boton_cancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(
		            null,
		            "¿Estás seguro de que deseas cancelar?",
		            "Confirmar cancelación",
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.WARNING_MESSAGE
		        );

		        if (respuesta == JOptionPane.YES_OPTION) {
		            router("maestros"); // Solo se ejecuta si el usuario da clic en "Sí"
		        }
		    }
		});
		
		return frame;
	}
	
}