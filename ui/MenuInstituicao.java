package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.fafica.projeto_pi.modelos.Reserva;

public class MenuInstituicao extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInstituicao frame = new MenuInstituicao();
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
	public MenuInstituicao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstituio = new JLabel("Instituição");
		lblInstituio.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblInstituio.setBounds(166, 18, 118, 27);
		contentPane.add(lblInstituio);
		
		JButton button = new JButton("Criar");
		button.setBounds(6, 71, 75, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBounds(87, 71, 80, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Listar");
		button_2.setBounds(173, 71, 79, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(258, 71, 87, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Procurar");
		button_4.setBounds(351, 71, 96, 29);
		contentPane.add(button_4);
	}

}
