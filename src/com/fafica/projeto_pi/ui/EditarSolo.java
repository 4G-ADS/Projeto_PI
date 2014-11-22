package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditarSolo extends JFrame {

	private JPanel contentPane;
	private JTextField campoTipo;
	private JTextField campoTamanho;
	private JTextField campoRecursos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarSolo frame = new EditarSolo();
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
	public EditarSolo() {
		setTitle("Editar Solo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Tipo:");
		label.setBounds(45, 73, 32, 16);
		contentPane.add(label);
		
		campoTipo = new JTextField();
		campoTipo.setColumns(10);
		campoTipo.setBounds(83, 67, 187, 28);
		contentPane.add(campoTipo);
		
		JLabel label_1 = new JLabel("Tamanho:");
		label_1.setBounds(282, 73, 62, 16);
		contentPane.add(label_1);
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		campoTamanho.setBounds(356, 67, 75, 28);
		contentPane.add(campoTamanho);
		
		campoRecursos = new JTextField();
		campoRecursos.setColumns(10);
		campoRecursos.setBounds(83, 101, 348, 28);
		contentPane.add(campoRecursos);
		
		JLabel label_2 = new JLabel("Recursos:");
		label_2.setBounds(16, 107, 61, 16);
		contentPane.add(label_2);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(83, 141, 75, 29);
		contentPane.add(btnAlterar);
	}

}
