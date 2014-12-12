package com.fafica.projeto_pi.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;

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
		setBounds(100, 100, 340, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(76, 58, 32, 16);
		
		JLabel labelLatitude = new JLabel("Latitude:");
		labelLatitude.setBounds(53, 132, 55, 16);
		
		JLabel labelNome = new JLabel("Nome da Fonte:");
		labelNome.setBounds(9, 99, 99, 16);
		
		JLabel labelLongitude = new JLabel("Longitude:");
		labelLongitude.setBounds(41, 165, 67, 16);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(84, 24, 24, 16);
		
		carregarCaracteristicas();
		
		
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(239, 205, 80, 29);
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
		buttonEditarTipo.setBounds(229, 57, 89, 29);
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				nascenteProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(nascenteProvisoria.getTipo());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(229, 98, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				nascenteProvisoria.setNomeFonte(nome);
				labelCarregarNome.setText(nascenteProvisoria.getNomeFonte());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.setBounds(229, 131, 89, 29);
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				nascenteProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+nascenteProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.setBounds(229, 164, 89, 29);
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				nascenteProvisoria.setLongitude(longitude);
				labelCarregarLongitude.setText(""+nascenteProvisoria.getLongitude());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblId);
		contentPane.add(labelCarregarID);
		contentPane.add(labelTipo);
		contentPane.add(labelCarregarTipo);
		contentPane.add(buttonEditarTipo);
		contentPane.add(labelNome);
		contentPane.add(labelCarregarNome);
		contentPane.add(buttonEditarNome);
		contentPane.add(labelLatitude);
		contentPane.add(labelCarregarLatitude);
		contentPane.add(buttonEditarLatitude);
		contentPane.add(labelLongitude);
		contentPane.add(labelCarregarLongitude);
		contentPane.add(buttonEditarLongitade);
		contentPane.add(buttonVoltar);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarTipo = new JLabel(nascenteProvisoria.getTipo());
		labelCarregarTipo.setBounds(120, 57, 80, 16);
		
		labelCarregarNome = new JLabel(nascenteProvisoria.getNomeFonte());
		labelCarregarNome.setBounds(120, 98, 80, 16);
		
		labelCarregarLatitude = new JLabel(""+nascenteProvisoria.getLatitude());
		labelCarregarLatitude.setBounds(120, 131, 46, 16);
		
		labelCarregarLongitude = new JLabel(""+nascenteProvisoria.getLongitude());
		labelCarregarLongitude.setBounds(120, 164, 46, 16);
		
		labelCarregarID = new JLabel(""+nascenteProvisoria.getIdAgua());
		labelCarregarID.setBounds(110, 24, 46, 16);
	}
}
