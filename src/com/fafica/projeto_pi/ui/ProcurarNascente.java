package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProcurarNascente extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarNascente frame = new ProcurarNascente();
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
	public ProcurarNascente() {
		setTitle("Listar Nascente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaNascente = new JLabel("Nome da Nascente:");
		lblNomeDaNascente.setBounds(22, 38, 131, 16);
		contentPane.add(lblNomeDaNascente);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(153, 32, 291, 28);
		contentPane.add(campoNome);
		
		JButton button = new JButton("Buscar");
		button.setBounds(153, 66, 85, 29);
		contentPane.add(button);
	}

}
