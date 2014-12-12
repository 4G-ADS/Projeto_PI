package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarReserva extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoTamanho;
	private JTextField campoLatitude;
	private JTextField campoLongitude;
	private JTextField campoClima;
	private Administrador admProvisorio;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarReserva frame = new CadastrarReserva(null);
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
	public CadastrarReserva(Administrador adm) {
		admProvisorio = adm;
		setTitle("Cadastrar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(10, 17, 84, 29);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTamanho.setBounds(10, 94, 97, 26);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLatitude.setBounds(10, 138, 97, 26);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLongitude.setBounds(10, 175, 97, 28);
		
		campoNome = new JTextField();
		campoNome.setBounds(117, 15, 348, 28);
		campoNome.setColumns(10);
		
		campoTamanho = new JTextField();
		campoTamanho.setBounds(117, 97, 134, 28);
		campoTamanho.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setBounds(117, 136, 134, 28);
		campoLatitude.setColumns(10);
		
		campoLongitude = new JTextField();
		campoLongitude.setBounds(117, 175, 128, 28);
		campoLongitude.setColumns(10);
		
		campoClima = new JTextField();
		campoClima.setBounds(117, 55, 134, 28);
		campoClima.setColumns(10);
		
		JButton btnCadastrar = new JButton("Proximo");
		btnCadastrar.setBounds(960, 651, 104, 29);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					

					try {
						String clima = campoClima.getText();
						String nome = campoNome.getText();
						int tamanho = Integer.parseInt(campoTamanho.getText());
						double latitude = Double.parseDouble(campoLatitude.getText());
						double longitude = Double.parseDouble(campoLongitude.getText());
						
						
						
						Reserva reserva = new Reserva (admProvisorio.getId(),clima, nome, tamanho, latitude, longitude);
						Fachada.getInstace().cadastrarReserva(reserva);
						
						dispose();
						new CadastrarPesquisador(reserva).setVisible(true);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CampoObritarorioInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (AdministradorJaCadastradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IdadeInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CPFInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PlantaJaCadastradaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PesquisadorJaCadastradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NascenteJaCadastradaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SoloJaCadastradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	

			}
		});
		
		
		
		JLabel lblClima = new JLabel("Clima:");
		lblClima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClima.setBounds(10, 57, 74, 25);
		contentPane.setLayout(null);
		contentPane.add(lblLatitude);
		contentPane.add(lblTamanho);
		contentPane.add(lblClima);
		contentPane.add(lblNome);
		contentPane.add(campoClima);
		contentPane.add(btnCadastrar);
		contentPane.add(campoTamanho);
		contentPane.add(campoLatitude);
		contentPane.add(lblLongitude);
		contentPane.add(campoLongitude);
		contentPane.add(campoNome);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
