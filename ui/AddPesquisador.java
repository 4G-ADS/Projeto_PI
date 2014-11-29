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
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField campoCFP;
	private JTextField campoIdade;
	private JTextField campoProfissao;
	private JTextField campoNome;
	private Reserva reservaProvisoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPesquisador frame = new AddPesquisador(null);
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
	public AddPesquisador(Reserva reserva) {
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("CPF:");
		
		JLabel label_3 = new JLabel("Nome:");
		
		JLabel label_1 = new JLabel("Idade:");
		
		JLabel label_2 = new JLabel("Profiss\u00E3o:");
		
		campoCFP = new JTextField();
		campoCFP.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setColumns(10);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		JButton buttonAdd = new JButton("Adicionar");
		buttonAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
;
				
				try {
					
					String nome = campoNome.getText();
					String profissao = campoProfissao.getText();
					int idade = Integer.parseInt(campoIdade.getText());
					String cpf = campoCFP.getText();
					
					if(!nome.equals("") && !profissao.equals("") && !cpf.equals("") && idade != 0){
					Pesquisador pesquisador = new Pesquisador(nome, cpf, idade, profissao);
					
					reservaProvisoria.getPesquisadores().add(pesquisador);
					Fachada.getInstace().cadastrarReserva(reservaProvisoria);
					dispose();
					 new MenuPesquisador(reservaProvisoria);
					}else{
						JOptionPane.showMessageDialog(null, "preencha todos os campos");
					}
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(campoCFP, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(campoIdade, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(57)
								.addComponent(campoProfissao, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(295)
							.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(campoCFP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(campoIdade, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(campoProfissao, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(87)
					.addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
