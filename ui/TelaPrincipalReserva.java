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

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
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
		setTitle("Menu reserva");
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
				
				try {
					dispose();
					Administrador adm = Fachada.getInstace().procurarAdministrador(reservaProvisoria.getIdAdm());
					new MenuPrincipal(adm).setVisible(true);;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AdministradorNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
					.addComponent(btnVoltar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
