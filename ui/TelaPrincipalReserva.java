package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

public class TelaPrincipalReserva extends JFrame {

	private JPanel contentPane;
	private ArrayList<Solo> listaSolo = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalReserva frame = new TelaPrincipalReserva(null);
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
	public TelaPrincipalReserva(Reserva reserva) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelNomeReserva = new JLabel(reserva.getNome());
		
		JLabel labelClima = new JLabel(reserva.getClima());
		
		JLabel labelLatitude = new JLabel(String.valueOf(reserva.getLatitude()));
		
		JLabel labelLongitude = new JLabel(String.valueOf(reserva.getLongitude()));
		
		JLabel labelTamanho = new JLabel(String.valueOf(reserva.getTamanho()));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNomeReserva)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelClima)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelLatitude)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelLongitude)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelTamanho)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNomeReserva)
						.addComponent(labelClima)
						.addComponent(labelLatitude)
						.addComponent(labelLongitude)
						.addComponent(labelTamanho))
					.addContainerGap(226, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


}
