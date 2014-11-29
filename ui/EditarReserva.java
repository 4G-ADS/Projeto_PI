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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClima = new JLabel("Clima:");
		
		JLabel lblLatitude = new JLabel("Latitude:");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel labelLongitude = new JLabel("Longitude:");
		
		JLabel lblId = new JLabel("ID:");
		
		carregarCaracteristicas();
		
		JButton buttonVoltar = new JButton("Voltar");
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
		buttonEditarClima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String clima = JOptionPane.showInputDialog("novo clima");
				reservaProvisoria.setClima(clima);
				labelCarregarClima.setText(reservaProvisoria.getClima());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				reservaProvisoria.setNome(nome);
				labelCarregarNome.setText(reservaProvisoria.getNome());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				reservaProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+reservaProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int longitude = Integer.parseInt(JOptionPane.showInputDialog("nova longitude"));
				reservaProvisoria.setLongitude(longitude);
				labelCarregarLongitude.setText(""+reservaProvisoria.getLongitude());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				reservaProvisoria.setTamanho(tamanho);
				labelCarregarTamamho.setText(""+reservaProvisoria.getTamanho());
			}
		});
		
		JLabel lblTamanho = new JLabel("Tamanho:");
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
					.addComponent(lblClima, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(labelCarregarClima, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(buttonEditarClima, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(labelCarregarNome, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(buttonEditarNome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblLatitude, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(labelCarregarLatitude, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(buttonEditarLatitude, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(labelLongitude, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(labelCarregarLongitude, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(buttonEditarLongitade, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTamanho, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(labelCarregarTamamho, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(buttonEditarTamanho, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(lblClima, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarClima))
						.addComponent(buttonEditarClima))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarNome))
						.addComponent(buttonEditarNome))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblLatitude, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
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
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTamanho, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarTamamho))
						.addComponent(buttonEditarTamanho))
					.addGap(25)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void carregarCaracteristicas(){
		
		labelCarregarClima = new JLabel(reservaProvisoria.getClima());
		
		labelCarregarNome = new JLabel(reservaProvisoria.getNome());
		
		labelCarregarLatitude = new JLabel(""+reservaProvisoria.getLatitude());
		
		labelCarregarLongitude = new JLabel(""+reservaProvisoria.getLongitude());
		
		labelCarregarID = new JLabel(""+reservaProvisoria.getTamanho());
		
		labelCarregarTamamho = new JLabel(""+reservaProvisoria.getTamanho());
	}
	
}
