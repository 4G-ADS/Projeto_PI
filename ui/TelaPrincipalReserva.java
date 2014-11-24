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
		
		JButton btnVoltar = new JButton("Voltar");
		
		JButton btnPesquisadores = new JButton("Pesquisadores");
		btnPesquisadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPesquisador().setVisible(true);;
			}
		});
		
		JButton btnNascentes = new JButton("Nascentes");
		btnNascentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuNascente().setVisible(true);
			}
		});
		
		JButton btnPlantas = new JButton("Plantas");
		btnPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPlanta();
			}
		});
		
		JButton btnSolos = new JButton("Solos");
		btnSolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuSolo().setVisible(true);
				}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(labelNomeReserva)
					.addGap(18)
					.addComponent(labelClima)
					.addGap(26)
					.addComponent(labelLatitude)
					.addGap(18)
					.addComponent(labelLongitude)
					.addGap(18)
					.addComponent(labelTamanho)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(353, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPesquisadores)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNascentes, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPlantas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSolos, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(313, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnPesquisadores)
					.addGap(18)
					.addComponent(btnNascentes)
					.addGap(18)
					.addComponent(btnPlantas)
					.addGap(18)
					.addComponent(btnSolos)
					.addGap(17)
					.addComponent(btnVoltar))
		);
		contentPane.setLayout(gl_contentPane);
	}


}
