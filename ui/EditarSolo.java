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

import com.fafica.projeto_pi.excecoes.SoloNaoEncontradorException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class EditarSolo extends JFrame {

	private JPanel contentPane;
	private Solo soloProvisorio;
	private Reserva reservaProvisoria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarSolo frame = new EditarSolo(null,null);
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
	public EditarSolo(Solo solo,Reserva reserva) {
		soloProvisorio = solo;
		reservaProvisoria = reserva;
		setTitle("Editar Solo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelId = new JLabel("ID:");
		labelId.setBounds(16, 25, 32, 16);
		contentPane.add(labelId);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(16, 52, 32, 16);
		contentPane.add(labelTipo);
		
		JLabel labelTamanho = new JLabel("Tamanho:");
		labelTamanho.setBounds(16, 79, 62, 16);
		contentPane.add(labelTamanho);
		
		JLabel labelRecursos = new JLabel("Recursos:");
		labelRecursos.setBounds(16, 107, 61, 16);
		contentPane.add(labelRecursos);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Fachada.getInstace().editarSolo(soloProvisorio);
					dispose();
					new MenuSolo(reservaProvisoria).setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SoloNaoEncontradorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		buttonVoltar.setBounds(349, 221, 75, 29);
		contentPane.add(buttonVoltar);
		
		JLabel labelCarregarID = new JLabel(""+soloProvisorio.getIdSolo());
		labelCarregarID.setBounds(82, 26, 32, 16);
		contentPane.add(labelCarregarID);
		
		JLabel labelCarregarTipo = new JLabel(soloProvisorio.getTipo());
		labelCarregarTipo.setBounds(82, 53, 62, 16);
		contentPane.add(labelCarregarTipo);
		
		JLabel labelCarregarTamanho = new JLabel(""+solo.getTamanho());
		labelCarregarTamanho.setBounds(82, 81, 32, 16);
		contentPane.add(labelCarregarTamanho);
		
		JLabel labelCarregarRecursos = new JLabel(soloProvisorio.getResursos());
		labelCarregarRecursos.setBounds(82, 108, 62, 16);
		contentPane.add(labelCarregarRecursos);
		
		JButton buttonEditarRescursos = new JButton("Editar");
		buttonEditarRescursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recursos = JOptionPane.showInputDialog("novo recurso");
				soloProvisorio.setResursos(recursos);
			}
		});
		buttonEditarRescursos.setBounds(170, 104, 89, 23);
		contentPane.add(buttonEditarRescursos);
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				soloProvisorio.setTamanho(tamanho);
			}
		});
		buttonEditarTamanho.setBounds(170, 76, 89, 23);
		contentPane.add(buttonEditarTamanho);
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				soloProvisorio.setTipo(tipo);
			}
		});
		buttonEditarTipo.setBounds(170, 49, 89, 23);
		contentPane.add(buttonEditarTipo);
	}
}
