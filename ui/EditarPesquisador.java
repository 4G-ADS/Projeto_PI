package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EditarPesquisador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPesquisador frame = new EditarPesquisador();
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
	public EditarPesquisador() {
		setTitle("Editar Pesquisador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("CPF:");
		label.setBounds(22, 43, 27, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(22, 70, 32, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Profissão:");
		label_2.setBounds(22, 124, 49, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Idade:");
		label_3.setBounds(22, 97, 32, 16);
		contentPane.add(label_3);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(339, 221, 86, 29);
		contentPane.add(btnAlterar);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(22, 18, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel labelCarregarId = new JLabel("");
		labelCarregarId.setBounds(47, 18, 46, 14);
		contentPane.add(labelCarregarId);
		
		JLabel labelCarregarNome = new JLabel("");
		labelCarregarNome.setBounds(64, 72, 46, 14);
		contentPane.add(labelCarregarNome);
		
		JLabel labelCarregarCPF = new JLabel("");
		labelCarregarCPF.setBounds(57, 43, 46, 14);
		contentPane.add(labelCarregarCPF);
		
		JLabel labelCarregarIdade = new JLabel("");
		labelCarregarIdade.setBounds(64, 98, 46, 14);
		contentPane.add(labelCarregarIdade);
		
		JLabel labelCarregarProfissao = new JLabel("");
		labelCarregarProfissao.setBounds(81, 125, 46, 14);
		contentPane.add(labelCarregarProfissao);
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(165, 63, 89, 23);
		contentPane.add(buttonEditarNome);
		
		JButton buttonEditarIdade = new JButton("Editar");
		buttonEditarIdade.setBounds(165, 94, 89, 23);
		contentPane.add(buttonEditarIdade);
		
		JButton buttonProfissao = new JButton("Editar");
		buttonProfissao.setBounds(165, 121, 89, 23);
		contentPane.add(buttonProfissao);
	}

}
