package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditarNascente extends JFrame {

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
					EditarNascente frame = new EditarNascente();
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
	public EditarNascente() {
		setTitle("Editar Nascente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Tipo:");
		label.setBounds(88, 77, 32, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Latitude:");
		label_1.setBounds(65, 123, 55, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nome da Fonte:");
		label_2.setBounds(21, 169, 99, 16);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 163, 295, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 117, 120, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 71, 134, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(325, 117, 96, 28);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("Longitude:");
		label_3.setBounds(252, 123, 67, 16);
		contentPane.add(label_3);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(129, 204, 80, 29);
		contentPane.add(btnEditar);
	}

}
