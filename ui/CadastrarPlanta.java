package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextPane;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class CadastrarPlanta extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEspecie;
	private JTextField campoTamanho;
	private JComboBox comboBox;
	private Reserva reservaProvisoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPlanta frame = new CadastrarPlanta(null);
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
	public CadastrarPlanta(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Cadastrar Planta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(32, 38, 41, 16);
		
		JLabel lblEspcie = new JLabel("Espécie:");
		lblEspcie.setBounds(22, 85, 51, 16);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(220, 85, 62, 16);
		
		campoNome = new JTextField();
		campoNome.setBounds(78, 32, 136, 28);
		campoNome.setColumns(10);
		
		campoEspecie = new JTextField();
		campoEspecie.setBounds(80, 79, 134, 28);
		campoEspecie.setColumns(10);
		
		campoTamanho = new JTextField();
		campoTamanho.setBounds(287, 79, 121, 28);
		campoTamanho.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(251, 34, 155, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pequeno Porte", "Medio Porte", "Grande Porte"}));
		
		JButton btnProximo = new JButton("Proximo");
		btnProximo.setBounds(307, 190, 97, 29);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nome = campoNome.getText();
				String especie = campoEspecie.getText();
				int tamanho = Integer.parseInt(campoTamanho.getText());
				if(!nome.equals("") && !especie.equals("") && tamanho != 0){
				if(comboBox.getSelectedItem().equals("Pequeno Porte")){
					
					if(tamanho < 60 ){
						System.out.println("pequeno");
						
					PlantaPequenoPorte planataPequena = new PlantaPequenoPorte(especie, nome, tamanho);
					System.out.println(planataPequena.getNome());
					planataPequena.setReserva(reservaProvisoria);
					
						Fachada.getInstace().CadastrarPlantaPequena(planataPequena);

						dispose();
						new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
					
					}else{
						JOptionPane.showMessageDialog(null, "para ser um planta de pequeno\n"
														+ 	"porte tem que ter menos de 60 cm\n"
														+ 	"Lembrando tamanho em cm");
					}
					
					
				}else if(comboBox.getSelectedItem().equals("Medio Porte")){
					
					if(tamanho > 60 && tamanho < 180 ){
						System.out.println("medio");
					PlantaMedioPorte planataMedia = new PlantaMedioPorte(especie, nome, tamanho);
					System.out.println(planataMedia.getNome());
					planataMedia.setReserva(reservaProvisoria);
					Fachada.getInstace().cadastrarPlantaMedia(planataMedia);
					
					dispose();
					new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
					
					}else{
						JOptionPane.showMessageDialog(null, "para ser um planta de medio\n"
														+ 	"porte tem que ter mais de 60 cm\n"
														+ 	"e menor que 180 cm \n"
														+ 	"Lembrando tamanho em cm");
					}
					
					
				}else if(comboBox.getSelectedItem().equals("Grande Porte")){
					
					if(tamanho > 180 ){
						System.out.println("grande");
					PlantaGrandePorte planataGrade = new PlantaGrandePorte(especie, nome, tamanho);
					System.out.println(planataGrade.getNome());
					planataGrade.setReserva(reservaProvisoria);
					Fachada.getInstace().CadastrarPlantaGrande(planataGrade);
					
					dispose();
					new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
					
					}else{
						JOptionPane.showMessageDialog(null, "para ser um planta de pequeno\n"
														+ 	"porte tem que ser maior que 180 cm\n"
														+ 	"Lembrando tamanho em cm");
					}
				}
				}else{
					JOptionPane.showMessageDialog(null, "Preencher todos os campos");
				}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(Exception e2){
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(campoNome);
		contentPane.add(lblEspcie);
		contentPane.add(campoEspecie);
		contentPane.add(lblTamanho);
		contentPane.add(campoTamanho);
		contentPane.add(comboBox);
		contentPane.add(btnProximo);
	}
}
