package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProcurarReserva extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarReserva frame = new ProcurarReserva();
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
	public ProcurarReserva() {
		setTitle("Listar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(137, 32, 291, 28);
		contentPane.add(campoNome);
		
		JLabel lblNomeDaReserva = new JLabel("Nome da Reserva:");
		lblNomeDaReserva.setBounds(22, 38, 117, 16);
		contentPane.add(lblNomeDaReserva);
		
		JButton button = new JButton("Buscar");
		button.setBounds(137, 66, 85, 29);
		contentPane.add(button);
	}

}
