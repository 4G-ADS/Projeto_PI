package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddPlanta extends JFrame {

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
					AddPlanta frame = new AddPlanta(null);
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
	public AddPlanta(Reserva reserva) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Nome:");
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		JLabel label_1 = new JLabel("Esp\u00E9cie:");
		
		campoEspecie = new JTextField();
		campoEspecie.setColumns(10);
		
		JLabel label_2 = new JLabel("Tamanho:");
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pequeno Porte", "Medio Porte", "Grande Porte"}));
		comboBox.setToolTipText("");
		
		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String nome = campoNome.getText();
					String especie = campoEspecie.getText();
					int tamanho = Integer.parseInt(campoTamanho.getText());
					
					if(comboBox.getSelectedItem().equals("Pequeno Porte")){
						
						if(tamanho < 60 ){
							System.out.println("pequeno");
							
						PlantaPequenoPorte planataPequena = new PlantaPequenoPorte(especie, nome, tamanho);
						System.out.println(planataPequena.getNome());
						
						reservaProvisoria.getListaPlantaPequena().add(planataPequena);
						
						campoNome.setText("");
						campoEspecie.setText("");
						campoTamanho.setText("");
						
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
						reservaProvisoria.getListaPlantaMedia().add(planataMedia);
						
						campoNome.setText("");
						campoEspecie.setText("");
						campoTamanho.setText("");
						
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
						reservaProvisoria.getListaPlantaGrande().add(planataGrade);
						
						campoNome.setText("");
						campoEspecie.setText("");
						campoTamanho.setText("");
						
						}else{
							JOptionPane.showMessageDialog(null, "para ser um planta de pequeno\n"
															+ 	"porte tem que ser maior que 180 cm\n"
															+ 	"Lembrando tamanho em cm");
						}
					}	
			
					
					Fachada.getInstace().cadastrarReserva(reservaProvisoria);
					dispose();
					new MenuPlanta(reservaProvisoria).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CampoObritarorioInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AdministradorJaCadastradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IdadeInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CPFInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PlantaJaCadastradaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PesquisadorJaCadastradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NascenteJaCadastradaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SoloJaCadastradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(campoEspecie, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(buttonAdicionar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(105)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(campoEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(buttonAdicionar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
