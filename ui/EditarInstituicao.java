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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 35, 50, 28);
		contentPane.add(textField);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(54, 41, 18, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(31, 87, 41, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 81, 345, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 121, 148, 28);
		contentPane.add(textField_2);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(78, 167, 104, 29);
		contentPane.add(btnAlterar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(282, 121, 141, 28);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("Tipo:");
		label_3.setBounds(40, 127, 32, 16);
		contentPane.add(label_3);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(248, 127, 44, 16);
		contentPane.add(lblCnpj);
	}

}
