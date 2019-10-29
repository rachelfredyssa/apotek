package Project_UAS;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.*;

public class Menu_Awal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Awal frame = new Menu_Awal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_Awal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Aplikasi Penjualan Obat");
		setBounds(330, 100, 700, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About ABT = new About();
			}
		});
		mnFile.add(mntmAbout);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnInput = new JMenu("Input");
		menuBar.add(mnInput);
		
		JMenuItem mntmPasien = new JMenuItem("Pasien");
		mntmPasien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input_Pasien IP = new Input_Pasien();
//				IP.setVisible(true);
			}
		});
		mnInput.add(mntmPasien);
		
		JMenuItem mntmObat = new JMenuItem("Obat");
		mntmObat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input_Obat IO = new Input_Obat();
//				IO.setVisible(true);
			}
		});
		mnInput.add(mntmObat);
		
		JMenu mnTransaksi = new JMenu("Transaksi");
		menuBar.add(mnTransaksi);
		
		JMenuItem mntmTransaksi = new JMenuItem("Detail Transaksi");
		mntmTransaksi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaksi Tr = new Transaksi();
			}
		});
		mnTransaksi.add(mntmTransaksi);
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			});
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/APOTEK_1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 684, 389);
		getContentPane().add(lblNewLabel);
		
		
			
	}
}
