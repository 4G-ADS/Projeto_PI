package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MenuPlanta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlanta frame = new MenuPlanta();
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
	public MenuPlanta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanta = new JLabel("Planta");
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblPlanta.setBounds(187, 6, 75, 27);
		contentPane.add(lblPlanta);
		
		JButton button = new JButton("Criar");
		button.setBounds(6, 59, 75, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBounds(87, 59, 80, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Listar");
		button_2.setBounds(173, 59, 79, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(258, 59, 87, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Procurar");
		button_4.setBounds(351, 59, 96, 29);
		contentPane.add(button_4);
	}

}
