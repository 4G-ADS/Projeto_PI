package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddNascente extends JFrame {

	private JPanel contentPane;
	private JButton buttonCadastrar;
	private JLabel labelTipo;
	private JLabel labelNome;
	private JTextField campoNome;
	private JLabel labelLatitude;
	private JTextField campoTipo;
	private JTextField campoLatitude;
	private JLabel labelLongitude;
	private JTextField campoLongitude;
	private Reserva reservaProvisoria;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNascente frame = new AddNascente(null);
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
	public AddNascente(Reserva reserva) {
		setTitle("Adicionar Nascente");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		buttonCadastrar = new JButton("Adicionar");
		buttonCadastrar.setBounds(947, 651, 117, 29);
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		

						try {
							
							double latitude = Double.parseDouble(campoLatitude.getText());
							double longitude = Double.parseDouble(campoLongitude.getText());
							String nomeFonte = campoNome.getText();
							String tipo = campoTipo.getText();
					
							NascenteAgua agua = new NascenteAgua(latitude, longitude, nomeFonte, tipo);
							agua.setReserva(reservaProvisoria);
							Fachada.getInstace().cadastrarNascente(agua);
							
							dispose();
							new MenuNascente(reservaProvisoria).setVisible(true);;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch(Exception e2){
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}


					
						
			}});
		
		labelTipo = new JLabel("Tipo:");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTipo.setBounds(10, 11, 60, 22);
		
		labelNome = new JLabel("Nome \r\nda Fonte:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(10, 134, 143, 22);
		
		campoNome = new JTextField();
		campoNome.setBounds(200, 135, 277, 28);
		campoNome.setColumns(10);
		
		labelLatitude = new JLabel("Latitude:");
		labelLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLatitude.setBounds(10, 47, 87, 27);
		
		campoTipo = new JTextField();
		campoTipo.setBounds(200, 12, 120, 28);
		campoTipo.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setBounds(200, 50, 120, 28);
		campoLatitude.setColumns(10);
		
		labelLongitude = new JLabel("Longitude:");
		labelLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLongitude.setBounds(10, 85, 107, 31);
		
		campoLongitude = new JTextField();
		campoLongitude.setBounds(200, 89, 120, 28);
		campoLongitude.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(labelTipo);
		contentPane.add(campoTipo);
		contentPane.add(labelLatitude);
		contentPane.add(campoLatitude);
		contentPane.add(labelLongitude);
		contentPane.add(campoLongitude);
		contentPane.add(labelNome);
		contentPane.add(campoNome);
		contentPane.add(buttonCadastrar);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

}
