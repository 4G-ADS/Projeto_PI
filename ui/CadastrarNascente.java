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

import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CadastrarNascente extends JFrame {

	private JPanel contentPane;
	private JTextField campoTipo;
	private JTextField campoLatitude;
	private JTextField campoLongitude;
	private JTextField campoNomeFonte;
	private Reserva reservaProvisoria;
	private ArrayList<NascenteAgua> listaNascentes = new ArrayList<NascenteAgua>();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		JLabel lblLatitude = new JLabel("Latitude:");
		
		JLabel lblLongitude = new JLabel("Longitude:");
		
		JLabel lblNomeDaFonte = new JLabel("Nome da Fonte:");
		
		campoTipo = new JTextField();
		campoTipo.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setColumns(10);
		
		campoLongitude = new JTextField();
		campoLongitude.setColumns(10);
		
		campoNomeFonte = new JTextField();
		campoNomeFonte.setColumns(10);
		
		JButton btnCadastrar = new JButton("Finalizar cadastro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeFonte = campoNomeFonte.getText();
				String tipo = campoTipo.getText();
				double latitude = Double.parseDouble(campoLatitude.getText());
				double longitude = Double.parseDouble(campoLatitude.getText());
				
				if(!nomeFonte.equals("") && !tipo.equals("") && latitude != 0 && longitude != 0){
				if(listaNascentes.size() == 0){
					
					NascenteAgua nascente = new NascenteAgua(latitude, longitude, nomeFonte, tipo);
					listaNascentes.add(nascente);
				}
				
				reservaProvisoria.setNascenteAgua(listaNascentes);
				dispose();
				new CadastrarPlanta(reservaProvisoria).setVisible(true);
			
			}else{
				JOptionPane.showMessageDialog(null, "Preencher todos os campos");
			}
			}
		});
		
		JButton btnNovo = new JButton("Cadastrar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeFonte = campoNomeFonte.getText();
				String tipo = campoTipo.getText();
				double latitude = Double.parseDouble(campoLatitude.getText());
				double longitude = Double.parseDouble(campoLatitude.getText());
				if(!nomeFonte.equals("") && !tipo.equals("") && latitude != 0 && longitude != 0){
				NascenteAgua nascente = new NascenteAgua(latitude, longitude, nomeFonte, tipo);
				listaNascentes.add(nascente);
				
				campoNomeFonte.setText("");
				campoTipo.setText("");
				campoLatitude.setText("");
				campoLongitude.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Preencher todos os campos");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTipo)
					.addContainerGap(390, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNomeDaFonte)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoNomeFonte, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblLatitude)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(campoTipo, Alignment.LEADING)
								.addComponent(campoLatitude, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblLongitude)
							.addGap(18)
							.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(campoTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLatitude)
						.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLongitude)
						.addComponent(campoLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDaFonte)
						.addComponent(campoNomeFonte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnNovo))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
