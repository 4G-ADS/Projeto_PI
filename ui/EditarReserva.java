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

public class EditarReserva extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JLabel labelCarregarClima ;
	private JLabel labelCarregarNome;
	private JLabel labelCarregarLatitude;
	private JLabel labelCarregarLongitude;
	private JLabel labelCarregarID;
	private JLabel labelCarregarTamamho;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarReserva frame = new EditarReserva(null);
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
	public EditarReserva(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Editar Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClima = new JLabel("Clima:");
		lblClima.setBounds(47, 58, 40, 16);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setBounds(32, 132, 55, 16);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(41, 99, 46, 16);
		
		JLabel labelLongitude = new JLabel("Longitude:");
		labelLongitude.setBounds(20, 165, 67, 16);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(63, 24, 24, 16);
		
		carregarCaracteristicas();
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(198, 228, 80, 29);
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Fachada.getInstace().editarReserva(reservaProvisoria);
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
		
		
		JButton buttonEditarClima = new JButton("Editar");
		buttonEditarClima.setBounds(189, 54, 89, 29);
		buttonEditarClima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clima = JOptionPane.showInputDialog("novo clima");
				reservaProvisoria.setClima(clima);
				labelCarregarClima.setText(reservaProvisoria.getClima());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(189, 95, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				reservaProvisoria.setNome(nome);
				labelCarregarNome.setText(reservaProvisoria.getNome());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.setBounds(189, 128, 89, 29);
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				reservaProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+reservaProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.setBounds(189, 161, 89, 29);
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				reservaProvisoria.setLongitude(longitude);
				labelCarregarLongitude.setText(""+reservaProvisoria.getLongitude());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.setBounds(189, 198, 89, 29);
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				reservaProvisoria.setTamanho(tamanho);
				labelCarregarTamamho.setText(""+reservaProvisoria.getTamanho());
			}
		});
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(25, 202, 62, 16);
		contentPane.setLayout(null);
		contentPane.add(lblId);
		contentPane.add(labelCarregarID);
		contentPane.add(lblClima);
		contentPane.add(labelCarregarClima);
		contentPane.add(buttonEditarClima);
		contentPane.add(lblNome);
		contentPane.add(labelCarregarNome);
		contentPane.add(buttonEditarNome);
		contentPane.add(lblLatitude);
		contentPane.add(labelCarregarLatitude);
		contentPane.add(buttonEditarLatitude);
		contentPane.add(labelLongitude);
		contentPane.add(labelCarregarLongitude);
		contentPane.add(buttonEditarLongitade);
		contentPane.add(lblTamanho);
		contentPane.add(labelCarregarTamamho);
		contentPane.add(buttonEditarTamanho);
		contentPane.add(buttonVoltar);
	}

	public void carregarCaracteristicas(){
		
		labelCarregarClima = new JLabel(reservaProvisoria.getClima());
		labelCarregarClima.setBounds(99, 58, 73, 16);
		
		labelCarregarNome = new JLabel(reservaProvisoria.getNome());
		labelCarregarNome.setBounds(99, 99, 73, 16);
		
		labelCarregarLatitude = new JLabel(""+reservaProvisoria.getLatitude());
		labelCarregarLatitude.setBounds(99, 132, 46, 16);
		
		labelCarregarLongitude = new JLabel(""+reservaProvisoria.getLongitude());
		labelCarregarLongitude.setBounds(99, 165, 46, 16);
		
		labelCarregarID = new JLabel(""+reservaProvisoria.getTamanho());
		labelCarregarID.setBounds(99, 24, 46, 16);
		
		labelCarregarTamamho = new JLabel(""+reservaProvisoria.getTamanho());
		labelCarregarTamamho.setBounds(99, 202, 46, 16);
	}
	
}
