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
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaPrincipalReserva extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private ArrayList<Solo> listaSolo = new ArrayList<>();
	private JLabel planoDeFundo;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel labelNomeReserva = new JLabel(reserva.getNome());
		labelNomeReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNomeReserva.setBounds(11, 59, 296, 36);
		
		JLabel labelClima = new JLabel(reserva.getClima());
		labelClima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelClima.setBounds(317, 59, 296, 36);
		
		JLabel labelLatitude = new JLabel(String.valueOf(reserva.getLatitude()));
		labelLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLatitude.setBounds(623, 59, 133, 36);
		
		JLabel labelLongitude = new JLabel(String.valueOf(reserva.getLongitude()));
		labelLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLongitude.setBounds(766, 59, 133, 36);
		
		JLabel labelTamanho = new JLabel(String.valueOf(reserva.getTamanho()));
		labelTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTamanho.setBounds(931, 59, 133, 36);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(983, 651, 81, 29);
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
		btnPesquisadores.setBounds(10, 145, 133, 29);
		btnPesquisadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPesquisador(reservaProvisoria).setVisible(true);;
			}
		});
		
		JButton btnNascentes = new JButton("Nascentes");
		btnNascentes.setBounds(10, 185, 133, 29);
		btnNascentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuNascente(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnPlantas = new JButton("Plantas");
		btnPlantas.setBounds(10, 265, 133, 29);
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
		btnSolos.setBounds(10, 225, 133, 29);
		btnSolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuSolo(reservaProvisoria).setVisible(true);
				}
		});
		
		JButton buttonMenuInstituicao = new JButton("Instituicao");
		buttonMenuInstituicao.setBounds(10, 305, 133, 29);
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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(11, 11, 70, 37);
		contentPane.add(lblNome);
		
		JLabel lblClima = new JLabel("Clima");
		lblClima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClima.setBounds(317, 11, 70, 37);
		contentPane.add(lblClima);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTamanho.setBounds(623, 11, 102, 37);
		contentPane.add(lblTamanho);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLatitude.setBounds(766, 11, 92, 37);
		contentPane.add(lblLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLongitude.setBounds(931, 11, 102, 37);
		contentPane.add(lblLongitude);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
