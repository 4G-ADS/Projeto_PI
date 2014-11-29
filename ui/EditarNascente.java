package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class EditarNascente extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private NascenteAgua nascenteProvisoria;
	private JLabel labelCarregarTipo;
	private JLabel labelCarregarNome;
	private JLabel labelCarregarLatitude;
	private JLabel labelCarregarLongitude;
	private JLabel labelCarregarID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarNascente frame = new EditarNascente(null,null);
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
	public EditarNascente(NascenteAgua nascete,Reserva reserva) {
		nascenteProvisoria = nascete;
		reservaProvisoria = reserva;
		setTitle("Editar Nascente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelTipo = new JLabel("Tipo:");
		
		JLabel labelLatitude = new JLabel("Latitude:");
		
		JLabel labelNome = new JLabel("Nome da Fonte:");
		
		JLabel labelLongitude = new JLabel("Longitude:");
		
		JLabel lblId = new JLabel("ID:");
		
		carregarCaracteristicas();
		
		
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Fachada.getInstace().editarNascente(nascenteProvisoria);
					dispose();
					new MenuNascente(reservaProvisoria).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NascenteNaoEncontradaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				nascenteProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(nascenteProvisoria.getTipo());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				nascenteProvisoria.setNomeFonte(nome);
				labelCarregarNome.setText(nascenteProvisoria.getNomeFonte());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				nascenteProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+nascenteProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				nascenteProvisoria.setLongitude(longitude);
				labelCarregarLongitude.setText(""+nascenteProvisoria.getLongitude());
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(labelCarregarID, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(labelTipo)
					.addGap(76)
					.addComponent(labelCarregarTipo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(buttonEditarTipo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(labelCarregarNome, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(buttonEditarNome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(labelLatitude)
					.addGap(57)
					.addComponent(labelCarregarLatitude, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(buttonEditarLatitude, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(labelLongitude, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(labelCarregarLongitude, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(buttonEditarLongitade, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(339)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(labelCarregarID)))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarTipo))
						.addComponent(buttonEditarTipo))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarNome))
						.addComponent(buttonEditarNome))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelLatitude, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarLatitude))
						.addComponent(buttonEditarLatitude))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelLongitude, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarLongitude))
						.addComponent(buttonEditarLongitade))
					.addGap(56)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarTipo = new JLabel(nascenteProvisoria.getTipo());
		
		labelCarregarNome = new JLabel(nascenteProvisoria.getNomeFonte());
		
		labelCarregarLatitude = new JLabel(""+nascenteProvisoria.getLatitude());
		
		labelCarregarLongitude = new JLabel(""+nascenteProvisoria.getLongitude());
		
		labelCarregarID = new JLabel(""+nascenteProvisoria.getIdAgua());
	}
}
