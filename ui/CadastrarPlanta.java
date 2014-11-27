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
import java.util.ArrayList;

import javax.swing.JTextPane;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.JSpinner;

public class CadastrarPlanta extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEspecie;
	private JTextField campoTamanho;
	private JComboBox comboBox;
	private Reserva reservaProvisoria;
	private ArrayList<PlantaPequenoPorte> listaPlantaPequena = new ArrayList<PlantaPequenoPorte>();
	private ArrayList<PlantaMedioPorte> listaPlantaMedia = new ArrayList<PlantaMedioPorte>();
	private ArrayList<PlantaGrandePorte> listaPlantaGrande = new ArrayList<PlantaGrandePorte>();
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
		setTitle("Cadastrar Planta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblEspcie = new JLabel("Espécie:");
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		campoEspecie = new JTextField();
		campoEspecie.setColumns(10);
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pequeno Porte", "Medio Porte", "Grande Porte"}));
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = campoNome.getText();
				String especie = campoEspecie.getText();
				int tamanho = Integer.parseInt(campoTamanho.getText());
				
				if(comboBox.getSelectedItem().equals("Pequeno Porte")){
					
					if(tamanho < 60 ){
						System.out.println("pequeno");
						
					PlantaPequenoPorte planataPequena = new PlantaPequenoPorte(especie, nome, tamanho);
					System.out.println(planataPequena.getNome());
					
					listaPlantaPequena.add(planataPequena);
					
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
					listaPlantaMedia.add(planataMedia);
					
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
					listaPlantaGrande.add(planataGrade);
					
					campoNome.setText("");
					campoEspecie.setText("");
					campoTamanho.setText("");
					
					}else{
						JOptionPane.showMessageDialog(null, "para ser um planta de pequeno\n"
														+ 	"porte tem que ser maior que 180 cm\n"
														+ 	"Lembrando tamanho em cm");
					}
				}	
		}
		});
		
		JButton btnCadastrar = new JButton("Finalizar cadastro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok");
				for (PlantaPequenoPorte plantaPequenoPorte : listaPlantaPequena) {
					System.out.println(plantaPequenoPorte.getNome());
					System.out.println("entro");
				}
				reservaProvisoria.setListaPlantaPequena(listaPlantaPequena);
				
				reservaProvisoria.setListaPlantaMedia(listaPlantaMedia);
				reservaProvisoria.setListaPlantaGrande(listaPlantaGrande);
				
				dispose();
				new TelaPrincipalReserva(reservaProvisoria);
			}
		});
		
		JTextPane txtpnObsObrigatorio = new JTextPane();
		txtpnObsObrigatorio.setText("OBS: \u00E9 obrigatorio ter pelo menos uma planta de cada porte para poder finalizar o cadastro");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addGap(26)
							.addComponent(campoNome))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEspcie)
							.addGap(18)
							.addComponent(campoEspecie))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTamanho)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addGap(105)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnObsObrigatorio, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspcie)
						.addComponent(campoEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoTamanho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTamanho))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(btnCadastrar))
						.addComponent(txtpnObsObrigatorio, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
