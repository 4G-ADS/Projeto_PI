package com.fafica.projeto_pi.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuPlantaGrande extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String[][] listaPlantaTabela = new String[100][2];
	private String colunas[] = { "ID", "Plantas" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlantaGrande frame = new MenuPlantaGrande(null);
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
	public MenuPlantaGrande(Reserva reserva) {
		setTitle("Menu Planta Grande");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPlanta = new JLabel("Planta Grande Porte");
		lblPlanta.setBounds(114, 16, 223, 27);
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));

		JButton button = new JButton("Voltar");
		button.setBounds(340, 228, 73, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});

		JButton button_1 = new JButton("Add");
		button_1.setBounds(50, 55, 63, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddPlantaGrande(reservaProvisoria).setVisible(true);

			}
		});

		JButton button_2 = new JButton("Perfil");
		button_2.setBounds(50, 84, 63, 29);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				perfil();
			}
		});

		JButton button_3 = new JButton("Excluir");
		button_3.setBounds(38, 114, 75, 29);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirPlanta();
				dispose();
				new MenuPlantaGrande(reservaProvisoria).setVisible(true);
				;
			}
		});

		preenceherTabelaPlantasGrandePorte();

		table = new JTable(listaPlantaTabela, colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 55, 288, 161);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(scrollPane);
		contentPane.add(lblPlanta);
	}

	public void preenceherTabelaPlantasGrandePorte() {
		try {
			listaPlantaTabela = new String[100][2];
			ArrayList<PlantaGrandePorte> listaPlantaGrande = Fachada
					.getInstace().listarPlantaGrande(reservaProvisoria.getIdReserva());
			int contador = 0;
			for (int i = 0; i < listaPlantaTabela.length; i++) {
				if (listaPlantaGrande.size() > i) {
					if (listaPlantaGrande.get(i).getReserva().getIdReserva() == reservaProvisoria
							.getIdReserva()) {
						String id = String.valueOf(listaPlantaGrande.get(i)
								.getIdPantaGrandePorte());
						String nome = listaPlantaGrande.get(i).getNome();

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

	public void excluirPlanta() {

		try {
			int idPlanta = Integer.parseInt(table.getValueAt(
					table.getSelectedRow(), 0).toString());

			Fachada.getInstace().removerPlantaGrandePorte(idPlanta);
			preenceherTabelaPlantasGrandePorte();

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
	
	public void perfil(){

		try {
			int idPlanta = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
			ArrayList<PlantaGrandePorte> listaPlantaGrande = Fachada.getInstace().listarPlantaGrande();
			
			for (PlantaGrandePorte plantaGrandePorte : listaPlantaGrande) {
				if(idPlanta == plantaGrandePorte.getIdPantaGrandePorte()){
					JOptionPane.showMessageDialog(null, "ID: " + plantaGrandePorte.getIdPantaGrandePorte() + "\n" +
														 "Nome: " + plantaGrandePorte.getNome() + "\n" +
														 "Especie: " + plantaGrandePorte.getEspecie() + "\n" +
														 "Tamanho: " + plantaGrandePorte.getTamanho());
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
	
}
