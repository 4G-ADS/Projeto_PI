package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarReserva extends JFrame {

	private JPanel contentPane;
	private JLabel labelTipo;
	private JLabel labelLatitude;
	private JLabel labelLongitude;
	private JLabel labelCarregarTipo;
	private JLabel labelCarregarLatitude;
	private JLabel labelCarregarLongitude;
	private JLabel labelId;
	private JLabel labelCarregarId;
	private JButton buttonEditarTipo;
	private JButton buttonEditarLatitude;
	private JButton buttonEditarLongitude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarReserva frame = new EditarReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditarReserva() {
		setTitle("Editar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVoltar.setBounds(320, 221, 104, 29);
		contentPane.add(buttonVoltar);
		
		labelId = new JLabel("ID:");
		labelId.setBounds(10, 28, 24, 16);
		contentPane.add(labelId);
		
		labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(10, 61, 24, 16);
		contentPane.add(labelTipo);
		
		labelLatitude = new JLabel("Latitude:");
		labelLatitude.setBounds(10, 101, 43, 16);
		contentPane.add(labelLatitude);
		
		labelLongitude = new JLabel("Longitude:");
		labelLongitude.setBounds(10, 150, 55, 16);
		contentPane.add(labelLongitude);
		
		labelCarregarId = new JLabel("");
		labelCarregarId.setBounds(33, 29, 46, 14);
		contentPane.add(labelCarregarId);
		
		labelCarregarTipo = new JLabel("");
		labelCarregarTipo.setBounds(44, 63, 46, 14);
		contentPane.add(labelCarregarTipo);
		
		labelCarregarLatitude = new JLabel("");
		labelCarregarLatitude.setBounds(75, 103, 46, 14);
		contentPane.add(labelCarregarLatitude);
		
		labelCarregarLongitude = new JLabel("");
		labelCarregarLongitude.setBounds(75, 152, 46, 14);
		contentPane.add(labelCarregarLongitude);
		
		buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(189, 58, 89, 23);
		contentPane.add(buttonEditarTipo);
		
		buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.setBounds(189, 98, 89, 23);
		contentPane.add(buttonEditarLatitude);
		
		buttonEditarLongitude = new JButton("Editar");
		buttonEditarLongitude.setBounds(189, 147, 89, 23);
		contentPane.add(buttonEditarLongitude);
	}

}
