package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		buttonCadastrar = new JButton("Adicionar");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		

					try {
						double latitude = Double.parseDouble(campoLatitude.getText());
						double longitude = Double.parseDouble(campoLongitude.getText());
						String nomeFonte = campoNome.getText();
						String tipo = campoTipo.getText();
						NascenteAgua agua = new NascenteAgua(latitude, longitude, nomeFonte, tipo);
						reservaProvisoria.getNascenteAgua().add(agua);
						
						Fachada.getInstace().cadastrarReserva(reservaProvisoria);
						dispose();
						new MenuNascente(reservaProvisoria);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CampoObritarorioInvalidoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (AdministradorJaCadastradoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IdadeInvalidoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CPFInvalidoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PlantaJaCadastradaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PesquisadorJaCadastradoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NascenteJaCadastradaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SoloJaCadastradoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}});
		
		labelTipo = new JLabel("Tipo:");
		
		labelNome = new JLabel("Nome da Fonte:");
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		labelLatitude = new JLabel("Latitude:");
		
		campoTipo = new JTextField();
		campoTipo.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setColumns(10);
		
		labelLongitude = new JLabel("Longitude:");
		
		campoLongitude = new JTextField();
		campoLongitude.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(campoTipo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelLatitude, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(campoLatitude, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(labelLongitude, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(297, Short.MAX_VALUE)
					.addComponent(buttonCadastrar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelTipo))
						.addComponent(campoTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelLatitude))
						.addComponent(campoLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelLongitude))
						.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelNome))
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(buttonCadastrar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
