package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class MenuNascente extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String colunas []= {"ID", "Nascentes"};
	private String[][] listaNascentesTabela = new String[100][2];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuNascente frame = new MenuNascente(null);
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
	public MenuNascente(Reserva reserva) {
		setTitle("Menu Nascente");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNascente = new JLabel("Nascente");
		lblNascente.setBounds(10, 29, 103, 27);
		lblNascente.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconAdd.png"));
		button_1.setBounds(459, 38, 63, 44);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddNascente(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconEditar.png"));
		button_2.setBounds(459, 148, 63, 44);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int idNascente = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				NascenteAgua nascente = null;

				try {
					nascente = Fachada.getInstace().procurarNascente(idNascente);
					dispose();
					new EditarNascente(nascente,reservaProvisoria).setVisible(true);
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
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconRemover.png"));
		button_3.setBounds(459, 93, 63, 44);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				excluirNascentes();
				dispose();
				new MenuNascente(reservaProvisoria).setVisible(true);;
			}
		});
		
		carregarTabela();
		
		table = new JTable(listaNascentesTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(539, 33, 525, 575);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(lblNascente);
		contentPane.add(button_2);
		contentPane.add(button_3);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		button.setBounds(991, 657, 73, 23);
		contentPane.add(button);
		contentPane.add(scrollPane);
		contentPane.add(button_1);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setBounds(0, 0, 1078, 691);
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		contentPane.add(planoDeFundo);
	}

	public void carregarTabela(){
		try {
			listaNascentesTabela = new String[100][2];
			ArrayList<NascenteAgua> listaNascentes = Fachada.getInstace().listarNascente(reservaProvisoria.getIdReserva());
			int contador =0;
			for (int i = 0; i < listaNascentesTabela.length; i++) {
				if(i < listaNascentes.size()){
					if(listaNascentes.get(i).getReserva().getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaNascentes.get(i).getIdAgua());
				String nome = listaNascentes.get(i).getNomeFonte();
				listaNascentesTabela[contador][0] = id;
				listaNascentesTabela[contador][1] = nome;
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
	
	
	public void excluirNascentes(){
		
		try {
			int idNascente = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
			Fachada.getInstace().removerNascente(idNascente);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NascenteNaoEncontradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
