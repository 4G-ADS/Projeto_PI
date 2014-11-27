package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EditarInstituicao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarInstituicao frame = new EditarInstituicao();
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
	public EditarInstituicao() {
		setTitle("Editar Instituição");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(31, 22, 18, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(17, 49, 32, 16);
		contentPane.add(label_1);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(319, 221, 104, 29);
		contentPane.add(buttonVoltar);
		
		JLabel label_3 = new JLabel("Tipo:");
		label_3.setBounds(25, 76, 24, 16);
		contentPane.add(label_3);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(17, 103, 32, 16);
		contentPane.add(lblCnpj);
		
		JLabel labelCarregarId = new JLabel("");
		labelCarregarId.setBounds(59, 23, 46, 14);
		contentPane.add(labelCarregarId);
		
		JLabel labelCarregarNome = new JLabel("");
		labelCarregarNome.setBounds(59, 50, 46, 14);
		contentPane.add(labelCarregarNome);
		
		JLabel labelCarregarTipo = new JLabel("");
		labelCarregarTipo.setBounds(59, 77, 46, 14);
		contentPane.add(labelCarregarTipo);
		
		JLabel labelCarregarCNPJ = new JLabel("");
		labelCarregarCNPJ.setBounds(59, 104, 46, 14);
		contentPane.add(labelCarregarCNPJ);
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(150, 46, 89, 23);
		contentPane.add(buttonEditarNome);
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(150, 73, 89, 23);
		contentPane.add(buttonEditarTipo);
	}
}
