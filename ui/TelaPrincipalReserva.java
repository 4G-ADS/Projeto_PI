package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
		setTitle("Menu Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelNomeReserva = new JLabel(reserva.getNome());
		labelNomeReserva.setBounds(41, 17, 73, 16);
		
		JLabel labelClima = new JLabel(reserva.getClima());
		labelClima.setBounds(126, 17, 73, 16);
		
		JLabel labelLatitude = new JLabel(String.valueOf(reserva.getLatitude()));
		labelLatitude.setBounds(217, 17, 20, 16);
		
		JLabel labelLongitude = new JLabel(String.valueOf(reserva.getLongitude()));
		labelLongitude.setBounds(255, 17, 20, 16);
		
		JLabel labelTamanho = new JLabel(String.valueOf(reserva.getTamanho()));
		labelTamanho.setBounds(293, 17, 20, 16);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(248, 133, 81, 29);
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
		btnPesquisadores.setBounds(11, 45, 133, 29);
		btnPesquisadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPesquisador(reservaProvisoria).setVisible(true);;
			}
		});
		
		JButton btnNascentes = new JButton("Nascentes");
		btnNascentes.setBounds(11, 92, 133, 29);
		btnNascentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuNascente(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnPlantas = new JButton("Plantas");
		btnPlantas.setBounds(225, 45, 127, 29);
		btnPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("1-> pequeno porte\n 2-> medio porte \n 3-> grande porte"));
				
				if(opcao == 1){
					new MenuPlantaPequena(reservaProvisoria).setVisible(true);
					dispose();
				}else if(opcao == 2){
					new MenuPlantaMedia(reservaProvisoria).setVisible(true);
					dispose();
				}else if(opcao == 3){
					new MenuPlantaGrande(reservaProvisoria).setVisible(true);
					dispose();
				}
			}
		});
		
		JButton btnSolos = new JButton("Solos");
		btnSolos.setBounds(227, 86, 123, 29);
		btnSolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuSolo(reservaProvisoria).setVisible(true);
				}
		});
		
		JButton buttonMenuInstituicao = new JButton("Instituicao");
		buttonMenuInstituicao.setBounds(21, 133, 112, 29);
		buttonMenuInstituicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuInstituicao(reservaProvisoria).setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(labelNomeReserva);
		contentPane.add(labelClima);
		contentPane.add(labelLatitude);
		contentPane.add(labelLongitude);
		contentPane.add(labelTamanho);
		contentPane.add(btnPesquisadores);
		contentPane.add(btnNascentes);
		contentPane.add(btnPlantas);
		contentPane.add(buttonMenuInstituicao);
		contentPane.add(btnSolos);
		contentPane.add(btnVoltar);
	}
}
