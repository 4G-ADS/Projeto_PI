package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CadastrarReserva extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoTamanho;
	private JTextField campoLatitude;
	private JTextField campoLongitude;
	private JTextField campoClima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarReserva frame = new CadastrarReserva();
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
	public CadastrarReserva() {
		setTitle("Cadastrar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		
		JLabel lblLatitude = new JLabel("Latitude:");
		
		JLabel lblLongitude = new JLabel("Longitude:");
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		
		campoLatitude = new JTextField();
		campoLatitude.setColumns(10);
		
		campoLongitude = new JTextField();
		campoLongitude.setColumns(10);
		
		campoClima = new JTextField();
		campoClima.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					
					String clima = campoClima.getText();
					String nome = campoNome.getText();
					int tamanho = Integer.parseInt(campoTamanho.getText());
					double latitude = Double.parseDouble(campoLatitude.getText());
					double longitude = Double.parseDouble(campoLongitude.getText());
					Reserva reserva = new Reserva (clima, nome, tamanho, latitude, longitude);
					
					Fachada.getInstace().cadastrarReserva(reserva);
					dispose();
					
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLatitude)
						.addComponent(lblTamanho)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblClima)
							.addComponent(lblNome)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(campoClima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar)
						.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(campoLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLongitude)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoClima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClima))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTamanho)
						.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLatitude)
						.addComponent(campoLatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLongitude)
						.addComponent(campoLongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrar)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
