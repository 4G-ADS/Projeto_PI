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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class EditarSolo extends JFrame {

	private JPanel contentPane;
	private Solo soloProvisorio;
	private Reserva reservaProvisoria;
	private JLabel labelCarregarID;
	private JLabel labelCarregarTipo;
	private JLabel labelCarregarTamanho;
	private JLabel labelCarregarRecursos;
	
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
		setBounds(100, 100, 295, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelId = new JLabel("ID:");
		labelId.setBounds(52, 26, 18, 16);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(38, 53, 32, 16);
		
		JLabel labelTamanho = new JLabel("Tamanho:");
		labelTamanho.setBounds(8, 86, 62, 16);
		
		JLabel labelRecursos = new JLabel("Recursos:");
		labelRecursos.setBounds(9, 120, 61, 16);
		
		carregarCaracteristicas();
		
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(202, 160, 75, 29);
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
		
		
		JButton buttonEditarRescursos = new JButton("Editar");
		buttonEditarRescursos.setBounds(192, 119, 89, 29);
		buttonEditarRescursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recursos = JOptionPane.showInputDialog("novo recurso");
				soloProvisorio.setResursos(recursos);
				labelCarregarRecursos.setText(soloProvisorio.getResursos());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.setBounds(192, 85, 89, 29);
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				soloProvisorio.setTamanho(tamanho);
				labelCarregarTamanho.setText(""+soloProvisorio.getTamanho());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(192, 52, 89, 29);
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				soloProvisorio.setTipo(tipo);
				labelCarregarTipo.setText(soloProvisorio.getTipo());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(labelId);
		contentPane.add(labelCarregarID);
		contentPane.add(labelTipo);
		contentPane.add(labelCarregarTipo);
		contentPane.add(buttonEditarTipo);
		contentPane.add(labelTamanho);
		contentPane.add(labelCarregarTamanho);
		contentPane.add(buttonEditarTamanho);
		contentPane.add(labelRecursos);
		contentPane.add(labelCarregarRecursos);
		contentPane.add(buttonEditarRescursos);
		contentPane.add(buttonVoltar);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarID = new JLabel(""+soloProvisorio.getIdSolo());
		labelCarregarID.setBounds(82, 26, 32, 16);
		
		labelCarregarTipo = new JLabel(soloProvisorio.getTipo());
		labelCarregarTipo.setBounds(82, 53, 79, 16);
		
		labelCarregarTamanho = new JLabel(""+soloProvisorio.getTamanho());
		labelCarregarTamanho.setBounds(82, 87, 32, 16);
		
		labelCarregarRecursos = new JLabel(soloProvisorio.getResursos());
		labelCarregarRecursos.setBounds(82, 120, 79, 16);
	}
}
