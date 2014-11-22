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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(67, 37, 358, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 68, 134, 28);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("CPF:");
		label.setBounds(36, 74, 27, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(22, 43, 41, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Profissão:");
		label_2.setBounds(6, 108, 67, 16);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 102, 222, 28);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Idade:");
		label_3.setBounds(203, 74, 41, 16);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(251, 68, 60, 28);
		contentPane.add(textField_3);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(65, 155, 86, 29);
		contentPane.add(btnAlterar);
	}

}
