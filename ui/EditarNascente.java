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
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTipo.setBounds(419, 85, 67, 29);
		
		JLabel labelLatitude = new JLabel("Latitude:");
		labelLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLatitude.setBounds(419, 165, 89, 26);
		
		JLabel labelNome = new JLabel("Nome da Fonte:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(419, 125, 150, 29);
		
		JLabel labelLongitude = new JLabel("Longitude:");
		labelLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLongitude.setBounds(419, 208, 100, 29);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(419, 45, 34, 29);
		
		carregarCaracteristicas();
		
		
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(984, 651, 80, 29);
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
		buttonEditarTipo.setBounds(961, 88, 89, 29);
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				nascenteProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(nascenteProvisoria.getTipo());
			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(961, 129, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("novo nome");
				nascenteProvisoria.setNomeFonte(nome);
				labelCarregarNome.setText(nascenteProvisoria.getNomeFonte());
			}
		});
		
		JButton buttonEditarLatitude = new JButton("Editar");
		buttonEditarLatitude.setBounds(961, 162, 89, 29);
		buttonEditarLatitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int lalitude = Integer.parseInt(JOptionPane.showInputDialog("nova latitude"));
				nascenteProvisoria.setLatitude(lalitude);
				labelCarregarLatitude.setText(""+nascenteProvisoria.getLatitude());
			}
		});
		
		JButton buttonEditarLongitade = new JButton("Editar");
		buttonEditarLongitade.setBounds(961, 195, 89, 29);
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
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarTipo = new JLabel(nascenteProvisoria.getTipo());
		labelCarregarTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarTipo.setBounds(579, 82, 372, 32);
		
		labelCarregarNome = new JLabel(nascenteProvisoria.getNomeFonte());
		labelCarregarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarNome.setBounds(584, 125, 363, 26);
		
		labelCarregarLatitude = new JLabel(""+nascenteProvisoria.getLatitude());
		labelCarregarLatitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarLatitude.setBounds(584, 162, 363, 28);
		
		labelCarregarLongitude = new JLabel(""+nascenteProvisoria.getLongitude());
		labelCarregarLongitude.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarLongitude.setBounds(584, 201, 363, 33);
		
		labelCarregarID = new JLabel(""+nascenteProvisoria.getIdAgua());
		labelCarregarID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarID.setBounds(584, 55, 363, 19);
	}
}
