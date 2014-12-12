package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuPlantaPequena extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String[][] listaPlantaTabela = new String [100][2];
	private String colunas []= {"ID", "Plantas"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlantaPequena frame = new MenuPlantaPequena(null);
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
	public MenuPlantaPequena(Reserva reserva) {
		setTitle("Menu Planta Pequena");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPlanta = new JLabel("Planta Pequeno Porte");
		lblPlanta.setBounds(104, 19, 240, 27);
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
				
		JButton button = new JButton("Voltar");
		button.setBounds(326, 229, 73, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(37, 69, 63, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddPlantaPequena(reservaProvisoria).setVisible(true);
				
			}
		});
		
		JButton button_2 = new JButton("Perfil");
		button_2.setBounds(37, 119, 63, 29);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				perfil();
			}
		});
		
		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(25, 167, 87, 29);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirPlanta();
				dispose();
				new MenuPlantaPequena(reservaProvisoria).setVisible(true);;
			}
		});

		
		preenceherTabelaPlantasPequenoPorte();
		
		table = new JTable(listaPlantaTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 69, 288, 161);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(lblPlanta);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(scrollPane);
	}
	
	public void perfil(){

		try {
			int idPlanta = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
			ArrayList<PlantaPequenoPorte> listaPlantaPequena = Fachada.getInstace().listarPlantaPequena();
			
			for (PlantaPequenoPorte plantaPequenoPorte : listaPlantaPequena) {
				if(idPlanta == plantaPequenoPorte.getIdPlantaPequenaPorte()){
					JOptionPane.showMessageDialog(null, "ID: " + plantaPequenoPorte.getIdPlantaPequenaPorte() + "\n" +
														 "Nome: " + plantaPequenoPorte.getNome() + "\n" +
														 "Especie: " + plantaPequenoPorte.getEspecie() + "\n" +
														 "Tamanho: " + plantaPequenoPorte.getTamanho());
					break;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void preenceherTabelaPlantasPequenoPorte(){
		try {
			listaPlantaTabela = new String [100][2];
			ArrayList<PlantaPequenoPorte> listaPlantaPequena = Fachada.getInstace().listarPlantaPequena(reservaProvisoria.getIdReserva());
			int contador = 0;
			for (int i = 0; i < listaPlantaTabela.length; i++) {
			
			
			if(listaPlantaPequena.size() > i){
				
				if(listaPlantaPequena.get(i).getReserva().getIdReserva() == reservaProvisoria.getIdReserva()){
		
				String id = String.valueOf(listaPlantaPequena.get(i).getIdPlantaPequenaPorte());
				String nome  = listaPlantaPequena.get(i).getNome();
				
				listaPlantaTabela[contador][0] = id;
				listaPlantaTabela[contador][1] = nome;
				contador++;
				
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	

	
	public void excluirPlanta(){
	
		try {
			
			int idPlanta = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
	
				Fachada.getInstace().removerPlantaPequenoPorte(idPlanta);
				preenceherTabelaPlantasPequenoPorte();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlantaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
