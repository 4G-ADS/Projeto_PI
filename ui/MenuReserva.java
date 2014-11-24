package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuReserva extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuReserva frame = new MenuReserva();
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
	public MenuReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblReserva.setBounds(177, 6, 96, 27);
		contentPane.add(lblReserva);
		
		JButton button = new JButton("Criar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(6, 41, 75, 29);
		contentPane.add(button);
		
		JScrollPane scrollReserva = new JScrollPane();
		scrollReserva.setBounds(82, 45, 346, 67);
		contentPane.add(scrollReserva);
		
		table = new JTable();
		scrollReserva.setViewportView(table);
		
		JButton btnCarregarReserva = new JButton("Carregar Reserva");
		btnCarregarReserva.setBounds(82, 123, 149, 29);
		contentPane.add(btnCarregarReserva);
	}
}
