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
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarPlanta extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEspecie;
	private JTextField campoTamanho;
	private JComboBox comboBox;
	private Reserva reservaProvisoria;
	private JLabel planoDeFundo;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(32, 38, 62, 26);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie");
		lblEspcie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEspcie.setBounds(32, 117, 80, 26);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTamanho.setBounds(32, 75, 92, 31);
		
		campoNome = new JTextField();
		campoNome.setBounds(134, 41, 300, 28);
		campoNome.setColumns(10);
		
		campoEspecie = new JTextField();
		campoEspecie.setBounds(134, 120, 300, 28);
		campoEspecie.setColumns(10);
		
		campoTamanho = new JTextField();
		campoTamanho.setBounds(134, 76, 300, 28);
		campoTamanho.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(487, 42, 155, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pequeno Porte", "Medio Porte", "Grande Porte"}));
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(967, 651, 97, 29);
		btnFinalizar.addActionListener(new ActionListener() {
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
		contentPane.add(btnFinalizar);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
