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
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblClima = new JLabel("Clima:");
		lblClima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClima.setBounds(327, 111, 67, 23);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLatitude.setBounds(327, 181, 89, 30);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(327, 145, 67, 30);
		
		JLabel labelLongitude = new JLabel("Longitude:");
		labelLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLongitude.setBounds(327, 215, 112, 28);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(327, 70, 40, 30);
		
		carregarCaracteristicas();
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(984, 633, 80, 29);
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
		buttonEditarClima.setBounds(975, 105, 89, 29);
		buttonEditarClima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clima = JOptionPane.showInputDialog("novo clima");
				reservaProvisoria.setClima(clima);
				labelCarregarClima.setText(reservaProvisoria.getClima());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(975, 143, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				reservaProvisoria.setNome(nome);
				labelCarregarNome.setText(reservaProvisoria.getNome());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.setBounds(975, 179, 89, 29);
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				reservaProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+reservaProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.setBounds(975, 212, 89, 29);
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				reservaProvisoria.setLongitude(longitude);
				labelCarregarLongitude.setText(""+reservaProvisoria.getLongitude());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.setBounds(975, 249, 89, 29);
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				reservaProvisoria.setTamanho(tamanho);
				labelCarregarTamamho.setText(""+reservaProvisoria.getTamanho());
			}
		});
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTamanho.setBounds(327, 255, 97, 23);
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
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

	public void carregarCaracteristicas(){
		
		labelCarregarClima = new JLabel(reservaProvisoria.getClima());
		labelCarregarClima.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarClima.setBounds(437, 97, 506, 26);
		
		labelCarregarNome = new JLabel(reservaProvisoria.getNome());
		labelCarregarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarNome.setBounds(437, 134, 506, 27);
		
		labelCarregarLatitude = new JLabel(""+reservaProvisoria.getLatitude());
		labelCarregarLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarLatitude.setBounds(437, 172, 506, 25);
		
		labelCarregarLongitude = new JLabel(""+reservaProvisoria.getLongitude());
		labelCarregarLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarLongitude.setBounds(437, 211, 506, 22);
		
		labelCarregarID = new JLabel(""+reservaProvisoria.getTamanho());
		labelCarregarID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarID.setBounds(437, 70, 506, 23);
		
		labelCarregarTamamho = new JLabel(""+reservaProvisoria.getTamanho());
		labelCarregarTamamho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarTamamho.setBounds(437, 247, 506, 24);
	}
	
}
