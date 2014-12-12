package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.SoloNaoEncontradorException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuSolo extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String[][] listaSoloTabela = new String[100][2];
	private String colunas []= {"ID", "Solos"};	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSolo frame = new MenuSolo(null);
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
	public MenuSolo(Reserva reserva) {
		setTitle("Menu Solo");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSolo = new JLabel("Solo");
		lblSolo.setBounds(193, 11, 48, 27);
		lblSolo.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
		JButton button = new JButton("Voltar");
		button.setBounds(334, 211, 73, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(20, 49, 87, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddSolo(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("Perfil");
		button_2.setBounds(20, 89, 87, 29);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idSolo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				Solo solo = null;
				try {
					solo = Fachada.getInstace().procurarSolo(idSolo);
					dispose();
					new EditarSolo(solo,reservaProvisoria).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SoloNaoEncontradorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(20, 129, 87, 29);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				excluirSolo();
				dispose();
				new MenuSolo(reservaProvisoria).setVisible(true);
			}
		});
		
			
		carregarTabela();
	
		table = new JTable(listaSoloTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 50, 288, 161);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(lblSolo);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(scrollPane);
		contentPane.add(button);
	}

	public void carregarTabela(){
		try {
			listaSoloTabela = new String[100][2];
			ArrayList<Solo> listaSolos = Fachada.getInstace().listarSolo(reservaProvisoria.getIdReserva());
			int contador =0;
			
			for (int i = 0; i < listaSoloTabela.length; i++) {
				if(i < listaSolos.size()){
					if(listaSolos.get(i).getReserva().getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaSolos.get(i).getIdSolo());
				String nome = listaSolos.get(i).getTipo();
				listaSoloTabela[contador][0] = id;
				listaSoloTabela[contador][1] = nome;
				contador++;
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ReservaNaoEncontradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}
	
	public void excluirSolo(){
		
		try {
			int idSolo = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			Fachada.getInstace().removerSolo(idSolo);
			carregarTabela();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SoloNaoEncontradorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
