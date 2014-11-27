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

public class MenuPlanta extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private JRadioButton rdbtnPequeno;
	private JRadioButton rdbtnMedio;
	private JRadioButton rdbtnGrande;
	private String[][] listaPlantaTabela = new String [100][2] ;
	private String colunas []= {"ID", "Plantas"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlanta frame = new MenuPlanta(null);
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
	public MenuPlanta(Reserva reserva) {
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPlanta = new JLabel("Planta");
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
				
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("Perfil");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button_3 = new JButton("Excluir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirPlanta();
			}
		});
		
		rdbtnPequeno = new JRadioButton("Pequeno Porte");
		rdbtnPequeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnMedio.setSelected(false);
				rdbtnGrande.setSelected(false);
				preenceherTabelaPlantasPequenoPorte();
				
			}
		});
		
		
		rdbtnMedio = new JRadioButton("Medio Porte");
		rdbtnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPequeno.setSelected(false);
				rdbtnGrande.setSelected(false);
					preenceherTabelaPlantasMedioPorte();
					
				
			}
		});
		
		rdbtnGrande = new JRadioButton("Grande Porte");
		rdbtnGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnPequeno.setSelected(false);
				rdbtnMedio.setSelected(false);
				preenceherTabelaPlantasGrandePorte();
			}
		});
		
		
		table = new JTable(listaPlantaTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(337)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlanta, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnPequeno)
							.addGap(8)
							.addComponent(rdbtnMedio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnGrande))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlanta, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnPequeno)
						.addComponent(rdbtnGrande)
						.addComponent(rdbtnMedio))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_1)
							.addGap(21)
							.addComponent(button_2)
							.addGap(19)
							.addComponent(button_3)))
					.addGap(14)
					.addComponent(button))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void preenceherTabelaPlantasPequenoPorte(){
		try {
			ArrayList<PlantaPequenoPorte> listaPlantaPequena = Fachada.getInstace().listarPlantaPequena();
			
			for (int i = 0; i < listaPlantaTabela.length; i++) {
			
			
			if(listaPlantaPequena.size() > i){
				System.out.println(reservaProvisoria.getIdReserva());
				
				if(listaPlantaPequena.get(i).getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaPlantaPequena.get(i).getIdPlantaPequenaPorte());
				String nome  = listaPlantaPequena.get(i).getNome();
				
				listaPlantaTabela[i][0] = id;
				listaPlantaTabela[i][1] = nome;
				}
			}
		}
			table.updateUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public void preenceherTabelaPlantasMedioPorte(){
		try {
			ArrayList<PlantaMedioPorte> listaPlantaMedia= Fachada.getInstace().listarPlantaMedia();
			
			for (int i = 0; i < listaPlantaTabela.length; i++) {
			
			
			if(listaPlantaMedia.size() > i){
				if(listaPlantaMedia.get(i).getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaPlantaMedia.get(i).getIdPlantaMedioPorte());
				String nome  = listaPlantaMedia.get(i).getNome();
				
				listaPlantaTabela[i][0] = id;
				listaPlantaTabela[i][1] = nome;
				}
			}
		}
			table.updateUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public void preenceherTabelaPlantasGrandePorte(){
		try {
			ArrayList<PlantaGrandePorte> listaPlantaGrande = Fachada.getInstace().listarPlantaGrande();
			
			for (int i = 0; i < listaPlantaTabela.length; i++) {
			
			if(listaPlantaGrande.size() > i){
				if(listaPlantaGrande.get(i).getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaPlantaGrande.get(i).getIdPantaGrandePorte());
				String nome  = listaPlantaGrande.get(i).getNome();
				
				listaPlantaTabela[i][0] = id;
				listaPlantaTabela[i][1] = nome;	
			}
		}
	}	
			table.updateUI();
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
			if(rdbtnPequeno.isSelected() == true && idPlanta != 0){
				
				Fachada.getInstace().removerPlantaPequenoPorte(idPlanta);
				preenceherTabelaPlantasPequenoPorte();
				table.updateUI();
			}else if(rdbtnMedio.isSelected() == true && idPlanta != 0){
				Fachada.getInstace().removerPlantaMedioPorte(idPlanta);
				preenceherTabelaPlantasMedioPorte();
				table.updateUI();
			}else if(rdbtnGrande.isSelected() == true && idPlanta != 0){
				Fachada.getInstace().removerPlantaGrandePorte(idPlanta);
				preenceherTabelaPlantasGrandePorte();
				table.updateUI();
			}else{
				JOptionPane.showMessageDialog(null, "selecione uma planta e seu porte");
			}
			
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
