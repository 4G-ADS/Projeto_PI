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

public class MenuNascente extends JFrame {

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
					MenuNascente frame = new MenuNascente(null);
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
	public MenuNascente(Reserva reserva) {
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNascente = new JLabel("Nascente");
		lblNascente.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblNascente.setBounds(10, 11, 103, 27);
		contentPane.add(lblNascente);
		
		JButton button = new JButton("Voltar");
		button.setBounds(342, 224, 73, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(20, 49, 63, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Perfil");
		button_2.setBounds(20, 131, 63, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(20, 172, 63, 23);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 49, 288, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button_4 = new JButton("Editar");
		button_4.setBounds(20, 90, 61, 23);
		contentPane.add(button_4);
	}

}
