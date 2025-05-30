package Examen_U3;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanas window = new ventanas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
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
		
		
	}
}
