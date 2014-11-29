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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelId = new JLabel("ID:");
		
		JLabel labelTipo = new JLabel("Tipo:");
		
		JLabel labelTamanho = new JLabel("Tamanho:");
		
		JLabel labelRecursos = new JLabel("Recursos:");
		
		carregarCaracteristicas();
		
		
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
		
		
		JButton buttonEditarRescursos = new JButton("Editar");
		buttonEditarRescursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recursos = JOptionPane.showInputDialog("novo recurso");
				soloProvisorio.setResursos(recursos);
				labelCarregarRecursos.setText(soloProvisorio.getResursos());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				soloProvisorio.setTamanho(tamanho);
				labelCarregarTamanho.setText(""+soloProvisorio.getTamanho());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				soloProvisorio.setTipo(tipo);
				labelCarregarTipo.setText(soloProvisorio.getTipo());
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelId, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(labelCarregarID, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(labelCarregarTipo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(buttonEditarTipo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelTamanho, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(labelCarregarTamanho, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(buttonEditarTamanho, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelRecursos, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(labelCarregarRecursos, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(buttonEditarRescursos, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(344)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(labelCarregarID, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarTipo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonEditarTipo))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelTamanho, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(labelCarregarTamanho, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonEditarTamanho))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(labelRecursos, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelCarregarRecursos, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(buttonEditarRescursos))
					.addGap(94)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarID = new JLabel(""+soloProvisorio.getIdSolo());
		
		labelCarregarTipo = new JLabel(soloProvisorio.getTipo());
		
		labelCarregarTamanho = new JLabel(""+soloProvisorio.getTamanho());
		
		labelCarregarRecursos = new JLabel(soloProvisorio.getResursos());
	}
}
