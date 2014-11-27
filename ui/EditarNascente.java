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

public class EditarNascente extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private NascenteAgua nascenteProvisoria;
	
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
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Tipo:");
		label.setBounds(10, 56, 24, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Latitude:");
		label_1.setBounds(10, 118, 43, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nome da Fonte:");
		label_2.setBounds(10, 91, 80, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Longitude:");
		label_3.setBounds(10, 145, 55, 16);
		contentPane.add(label_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
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
		btnVoltar.setBounds(344, 221, 80, 29);
		contentPane.add(btnVoltar);
		
		JLabel labelCarregarTipo = new JLabel(nascenteProvisoria.getTipo());
		labelCarregarTipo.setBounds(110, 57, 62, 14);
		contentPane.add(labelCarregarTipo);
		
		JLabel labelCarregarNome = new JLabel(nascenteProvisoria.getNomeFonte());
		labelCarregarNome.setBounds(110, 92, 62, 14);
		contentPane.add(labelCarregarNome);
		
		JLabel labelCarregarLatitude = new JLabel(""+nascenteProvisoria.getLatitude());
		labelCarregarLatitude.setBounds(110, 119, 46, 14);
		contentPane.add(labelCarregarLatitude);
		
		JLabel labelLongitude = new JLabel(""+nascenteProvisoria.getLongitude());
		labelLongitude.setBounds(110, 146, 46, 14);
		contentPane.add(labelLongitude);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 23, 24, 16);
		contentPane.add(lblId);
		
		JLabel labelCarregarID = new JLabel(""+nascenteProvisoria.getIdAgua());
		labelCarregarID.setBounds(110, 24, 46, 14);
		contentPane.add(labelCarregarID);
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				nascenteProvisoria.setTipo(tipo);
			}
		});
		buttonEditarTipo.setBounds(189, 53, 89, 23);
		contentPane.add(buttonEditarTipo);
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				nascenteProvisoria.setNomeFonte(nome);
			}
		});
		buttonEditarNome.setBounds(189, 88, 89, 23);
		contentPane.add(buttonEditarNome);
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				nascenteProvisoria.setLatitude(lalitude);
			}
		});
		buttonEditarLatitude.setBounds(189, 115, 89, 23);
		contentPane.add(buttonEditarLatitude);
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				nascenteProvisoria.setLongitude(longitude);
			}
		});
		buttonEditarLongitade.setBounds(189, 142, 89, 23);
		contentPane.add(buttonEditarLongitade);
	}

}
