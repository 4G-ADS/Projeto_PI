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
	private Reserva reservaProvisoria;
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
		reservaProvisoria = reserva;
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnPesquisadores = new JButton("Pesquisadores");
		btnPesquisadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPesquisador(reservaProvisoria).setVisible(true);;
			}
		});
		
		JButton btnNascentes = new JButton("Nascentes");
		btnNascentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuNascente(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnPlantas = new JButton("Plantas");
		btnPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPlanta(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnSolos = new JButton("Solos");
		btnSolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuSolo(reservaProvisoria).setVisible(true);
				}
		});
		
		JButton btnInstituicao = new JButton("Instituicao");
		btnInstituicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelNomeReserva)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelClima)
							.addGap(18)
							.addComponent(labelLatitude)
							.addGap(18)
							.addComponent(labelLongitude)
							.addGap(18)
							.addComponent(labelTamanho)
							.addGap(192))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnInstituicao, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
							.addComponent(btnVoltar)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPesquisadores, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(302))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNascentes, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(302))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPlantas, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(302))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSolos, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(302, Short.MAX_VALUE))))
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
					.addGap(18)
					.addComponent(btnPesquisadores)
					.addGap(18)
					.addComponent(btnNascentes)
					.addGap(18)
					.addComponent(btnPlantas)
					.addGap(18)
					.addComponent(btnSolos)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInstituicao)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}


}
