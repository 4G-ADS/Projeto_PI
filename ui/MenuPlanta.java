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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuPlanta extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlanta frame = new MenuPlanta(null);
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
	public MenuPlanta(Reserva reserva) {
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanta = new JLabel("Planta");
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblPlanta.setBounds(10, 11, 75, 27);
		contentPane.add(lblPlanta);
		
		JButton button = new JButton("Voltar");
		button.setBounds(342, 227, 73, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(20, 52, 63, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Perfil");
		button_2.setBounds(20, 134, 63, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(20, 175, 63, 23);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 52, 288, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button_4 = new JButton("Editar");
		button_4.setBounds(20, 93, 61, 23);
		contentPane.add(button_4);
	}

}
