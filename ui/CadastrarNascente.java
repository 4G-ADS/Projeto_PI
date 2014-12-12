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

import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarNascente extends JFrame {

	private JPanel contentPane;
	private JTextField campoTipo;
	private JTextField campoLatitude;
	private JTextField campoLongitude;
	private JTextField campoNomeFonte;
	private Reserva reservaProvisoria;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarNascente frame = new CadastrarNascente(null);
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
	public CadastrarNascente(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Cadastrar Nascente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipo.setBounds(7, 15, 51, 33);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLatitude.setBounds(10, 59, 81, 27);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLongitude.setBounds(7, 95, 96, 27);
		
		JLabel lblNomeDaFonte = new JLabel("Nome \r\nda Fonte:");
		lblNomeDaFonte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomeDaFonte.setBounds(8, 137, 144, 24);
		
		campoTipo = new JTextField();
		campoTipo.setBounds(199, 20, 386, 30);
		campoTipo.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setBounds(198, 56, 386, 30);
		campoLatitude.setColumns(10);
		
		campoLongitude = new JTextField();
		campoLongitude.setBounds(199, 97, 385, 31);
		campoLongitude.setColumns(10);
		
		campoNomeFonte = new JTextField();
		campoNomeFonte.setBounds(198, 139, 386, 33);
		campoNomeFonte.setColumns(10);
		
		JButton btnCadastrar = new JButton("Proximo");
		btnCadastrar.setBounds(993, 657, 71, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					String nomeFonte = campoNomeFonte.getText();
					String tipo = campoTipo.getText();
					double latitude = Double.parseDouble(campoLatitude.getText());
					double longitude = Double.parseDouble(campoLatitude.getText());
						
					NascenteAgua nascente = new NascenteAgua(latitude, longitude, nomeFonte, tipo);
					nascente.setReserva(reservaProvisoria);
					Fachada.getInstace().cadastrarNascente(nascente);
					
					dispose();
					new CadastrarPlanta(reservaProvisoria).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(Exception e2){
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

	

			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblTipo);
		contentPane.add(lblLatitude);
		contentPane.add(campoLatitude);
		contentPane.add(lblLongitude);
		contentPane.add(campoLongitude);
		contentPane.add(campoTipo);
		contentPane.add(lblNomeDaFonte);
		contentPane.add(campoNomeFonte);
		contentPane.add(btnCadastrar);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

}
