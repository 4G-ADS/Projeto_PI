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
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel labelId = new JLabel("ID:");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelId.setBounds(366, 43, 37, 31);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTipo.setBounds(366, 85, 47, 35);
		
		JLabel labelTamanho = new JLabel("Tamanho:");
		labelTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTamanho.setBounds(366, 125, 99, 32);
		
		JLabel labelRecursos = new JLabel("Recursos:");
		labelRecursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelRecursos.setBounds(367, 168, 89, 29);
		
		carregarCaracteristicas();
		
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(989, 651, 75, 29);
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
		buttonEditarRescursos.setBounds(975, 172, 89, 29);
		buttonEditarRescursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recursos = JOptionPane.showInputDialog("novo recurso");
				soloProvisorio.setResursos(recursos);
				labelCarregarRecursos.setText(soloProvisorio.getResursos());
			}
		});
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.setBounds(975, 131, 89, 29);
		buttonEditarTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tamanho = Double.parseDouble(JOptionPane.showInputDialog("novo tamanho"));
				soloProvisorio.setTamanho(tamanho);
				labelCarregarTamanho.setText(""+soloProvisorio.getTamanho());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(975, 92, 89, 29);
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
		
		JLabel planoDeFuno = new JLabel("New label");
		planoDeFuno.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFuno.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFuno);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarID = new JLabel(""+soloProvisorio.getIdSolo());
		labelCarregarID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarID.setBounds(494, 50, 455, 25);
		
		labelCarregarTipo = new JLabel(soloProvisorio.getTipo());
		labelCarregarTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarTipo.setBounds(494, 85, 455, 25);
		
		labelCarregarTamanho = new JLabel(""+soloProvisorio.getTamanho());
		labelCarregarTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarTamanho.setBounds(494, 127, 455, 28);
		
		labelCarregarRecursos = new JLabel(soloProvisorio.getResursos());
		labelCarregarRecursos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarRecursos.setBounds(494, 174, 455, 23);
	}
}
