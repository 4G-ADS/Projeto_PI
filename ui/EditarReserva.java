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
	private JTextField campoNome;
	private JTextField campoTamanho;
	private JTextField campoLatitude;
	private JTextField campoLongitude;
	private JLabel lblLongitude;

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
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(20, 88, 41, 16);
		contentPane.add(label);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(74, 82, 353, 28);
		contentPane.add(campoNome);
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		campoTamanho.setBounds(74, 116, 134, 28);
		contentPane.add(campoTamanho);
		
		JLabel label_1 = new JLabel("Tamanho:");
		label_1.setBounds(6, 122, 62, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Latitude:");
		label_2.setBounds(6, 168, 55, 16);
		contentPane.add(label_2);
		
		campoLatitude = new JTextField();
		campoLatitude.setColumns(10);
		campoLatitude.setBounds(74, 162, 134, 28);
		contentPane.add(campoLatitude);
		
		campoLongitude = new JTextField();
		campoLongitude.setColumns(10);
		campoLongitude.setBounds(293, 162, 134, 28);
		contentPane.add(campoLongitude);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setBounds(74, 202, 104, 29);
		contentPane.add(btnAlterar);
		
		lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(220, 168, 72, 16);
		contentPane.add(lblLongitude);
	}

}
