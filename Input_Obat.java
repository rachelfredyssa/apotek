package Project_UAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Input_Obat <MysqlDataSource,MysqlDataSource1> extends JFrame {
	DefaultTableModel tbl = new DefaultTableModel();
	int a = 0;

	private JFrame frame;
	private JTextField textField_ID;
	private JTextField textField_Nama;
	private JTextField textField_Jenis;
	private JTextField textField_Stok;
	private JTextField textField_Tgl;
	private JTextField textField_Harga;
	private JTable tableO;

	
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
				try {
					Input_Obat window = new Input_Obat();
				} catch (Exception e) {
					e.printStackTrace();
				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Input_Obat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Input Data Obat");
		frame.setBounds(355, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInputDataObat = DefaultComponentFactory.getInstance().createTitle("INPUT DATA OBAT");
		lblInputDataObat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblInputDataObat.setBounds(222, 11, 205, 24);
		frame.getContentPane().add(lblInputDataObat);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ID Obat");
		lblNewJgoodiesTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle.setBounds(123, 46, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Nama Obat");
		lblNewJgoodiesTitle_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_1.setBounds(123, 81, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_1);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("Jenis Obat");
		lblNewJgoodiesTitle_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_2.setBounds(123, 116, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_2);
		
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("Stok Obat");
		lblNewJgoodiesTitle_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_3.setBounds(123, 151, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_3);
		
		JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("Tanggal Kadaluwarsa");
		lblNewJgoodiesTitle_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_4.setBounds(123, 186, 141, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_4);
		
		JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory.getInstance().createTitle("Harga");
		lblNewJgoodiesTitle_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_5.setBounds(123, 221, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_5);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(269, 49, 170, 20);
		frame.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_Nama = new JTextField();
		textField_Nama.setBounds(269, 84, 240, 20);
		frame.getContentPane().add(textField_Nama);
		textField_Nama.setColumns(10);
		
		textField_Jenis = new JTextField();
		textField_Jenis.setBounds(269, 119, 240, 20);
		frame.getContentPane().add(textField_Jenis);
		textField_Jenis.setColumns(10);
		
		textField_Stok = new JTextField();
		textField_Stok.setBounds(269, 154, 240, 20);
		frame.getContentPane().add(textField_Stok);
		textField_Stok.setColumns(10);
		
		textField_Tgl = new JTextField();
		textField_Tgl.setBounds(269, 189, 150, 20);
		frame.getContentPane().add(textField_Tgl);
		textField_Tgl.setColumns(10);
		
		textField_Harga = new JTextField();
		textField_Harga.setBounds(269, 224, 240, 20);
		frame.getContentPane().add(textField_Harga);
		textField_Harga.setColumns(10);
		
		JScrollPane tableO = new JScrollPane();
		tableO.setBounds(10, 310, 615, 145);
		frame.getContentPane().add(tableO);
		
		JTable table = new JTable();
		tableO.setViewportView(table);
		tbl.addColumn("ID Obat");
		tbl.addColumn("Nama Obat");
		tbl.addColumn("Jenis Obat");
		tbl.addColumn("Stok Obat");
		tbl.addColumn("Tgl Kadaluwarsa");
		tbl.addColumn("Harga");
		
		table.setModel(tbl);
		
		try {
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			server.setServerName("localhost");
			server.setUser("root");
			server.setPassword("");
			server.setPortNumber(3306);
			server.setDatabaseName("project_18111100");
			java.sql.Connection koneksi=server.getConnection();
			ResultSet Input_Obat=koneksi.prepareStatement("select * from obat").executeQuery();
			while(Input_Obat.next()) {
				tbl.addRow(new Object[] {Input_Obat.getString(1),Input_Obat.getString(2),Input_Obat.getString(3),Input_Obat.getString(4),Input_Obat.getString(5),Input_Obat.getString(6)});
			}

			}	
			catch (Exception e1) {
				System.out.println(e1);
			}
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField_ID.getText();
					String nm = textField_Nama.getText();
					String jn = textField_Jenis.getText();
					String st = textField_Stok.getText();
					String tg = textField_Tgl.getText();
					String hg = textField_Harga.getText();
					
					Object [] vr = {id,nm,jn,st,tg,hg};
					tbl.addRow(vr);
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					koneksi.prepareStatement("insert into obat values('"+
							textField_ID.getText()+"','"+
							textField_Nama.getText()+"','"+
							textField_Jenis.getText()+"','"+
							textField_Stok.getText()+"','"+
							textField_Tgl.getText()+"','"+
							textField_Harga.getText()+"')" ).execute();
					JOptionPane.showMessageDialog(null,"Data Tersimpan !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnSimpan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSimpan.setBounds(123, 260, 89, 23);
		frame.getContentPane().add(btnSimpan);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_ID.setText("");
				textField_Nama.setText("");
				textField_Jenis.setText("");
				textField_Stok.setText("");
				textField_Tgl.setText("");
				textField_Harga.setText("");
			}
		});
		btnReset.setBounds(222, 260, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					koneksi.prepareStatement("DELETE FROM obat "+" WHERE Id_Obat = '"+
					table.getValueAt(table.getSelectedRow(),0)+"'").execute();
					JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnHapus.setBounds(420, 260, 89, 23);
		frame.getContentPane().add(btnHapus);
		
		JButton btnCari = new JButton("Cari");
		btnCari.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String search = textField_ID.getText();
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					java.sql.Statement stmt = koneksi.createStatement();
					String sql = "SELECT * FROM obat WHERE Id_Obat = '"+ search +"'";
					ResultSet res = stmt.executeQuery (sql);
					if(res.next()) {
						textField_ID.setText(res.getString(1));
						textField_Nama.setText(res.getString(2));
						textField_Jenis.setText(res.getString(3));
						textField_Stok.setText(res.getString(4));
						textField_Tgl.setText(res.getString(5));
						textField_Harga.setText(res.getString(6));
					}
					else {
					JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus !");
					}
				}
				catch (Exception e1) {
					System.out.println(e1);
					}
				}
			});
		btnCari.setBounds(449, 48, 60, 23);
		frame.getContentPane().add(btnCari);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					java.sql.Statement stmt = koneksi.createStatement();
					String sql = "UPDATE obat SET "
					+ "Nama_Obat='"+textField_Nama.getText()+"',"
					+ "Jenis_Obat='"+textField_Jenis.getText()+"',"
					+ "Stok_Obat='"+textField_Stok.getText()+"',"
					+ "Tanggal_Kadaluwarsa='"+textField_Tgl.getText()+"',"
					+ "Harga='"+textField_Harga.getText()+"'"
					+ "WHERE "
					+ "Id_Obat='"+textField_ID.getText()+"'"					;
					int i = stmt.executeUpdate(sql);
					if(i ==1) {
					JOptionPane.showMessageDialog(null,"Data Berhasil Diupdate !");
					}
				}
				catch (Exception e1) {
					System.out.println(e1);
					}
				}
		});
		btnUpdate.setBounds(321, 260, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblYyyymmdd = new JLabel("yyyy/mm/dd");
		lblYyyymmdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblYyyymmdd.setBounds(429, 186, 80, 24);
		frame.getContentPane().add(lblYyyymmdd);
		frame.setVisible(true);
		}	
	}
