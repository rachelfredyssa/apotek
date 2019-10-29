package Project_UAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Input_Pasien <MysqlDataSource,MysqlDataSource1> extends JFrame {
	DefaultTableModel tbl = new DefaultTableModel();
	int a = 0;

	private JFrame frame;
	private JTextField textField_ID;
	private JTextField textField_Nama;
	private JTextField textField_Tgl;
	private JTextField textField_Almt;
	private JTextField textField_Penyakit;
	private JTable tableP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
				try {
					Input_Pasien window = new Input_Pasien();
				} catch (Exception e) {
					e.printStackTrace();
				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Input_Pasien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Input Data Pasien");
		frame.setBounds(355, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInputDataPasien = DefaultComponentFactory.getInstance().createTitle("INPUT DATA PASIEN");
		lblInputDataPasien.setBounds(218, 11, 205, 24);
		lblInputDataPasien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(lblInputDataPasien);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ID Pasien");
		lblNewJgoodiesTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle.setBounds(124, 46, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JLabel lblNamaPasien = DefaultComponentFactory.getInstance().createTitle("Nama Pasien");
		lblNamaPasien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNamaPasien.setBounds(124, 81, 91, 24);
		frame.getContentPane().add(lblNamaPasien);
		
		JLabel lblTempatTanggalLahir = DefaultComponentFactory.getInstance().createTitle("Tanggal Lahir Pasien");
		lblTempatTanggalLahir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTempatTanggalLahir.setBounds(124, 116, 140, 24);
		frame.getContentPane().add(lblTempatTanggalLahir);
		
		JLabel lblAlamat = DefaultComponentFactory.getInstance().createTitle("Alamat");
		lblAlamat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAlamat.setBounds(124, 151, 91, 24);
		frame.getContentPane().add(lblAlamat);
		
		JLabel lblPenyakit = DefaultComponentFactory.getInstance().createTitle("Penyakit");
		lblPenyakit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPenyakit.setBounds(124, 186, 91, 24);
		frame.getContentPane().add(lblPenyakit);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(264, 49, 176, 20);
		frame.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_Nama = new JTextField();
		textField_Nama.setBounds(264, 84, 246, 20);
		frame.getContentPane().add(textField_Nama);
		textField_Nama.setColumns(10);
		
		textField_Tgl = new JTextField();
		textField_Tgl.setBounds(264, 119, 159, 20);
		frame.getContentPane().add(textField_Tgl);
		textField_Tgl.setColumns(10);
		
		textField_Almt = new JTextField();
		textField_Almt.setBounds(264, 154, 246, 20);
		frame.getContentPane().add(textField_Almt);
		textField_Almt.setColumns(10);
		
		textField_Penyakit = new JTextField();
		textField_Penyakit.setBounds(264, 189, 246, 20);
		frame.getContentPane().add(textField_Penyakit);
		textField_Penyakit.setColumns(10);
		
		JScrollPane tableP = new JScrollPane();
		tableP.setBounds(10, 310, 615, 145);
		frame.getContentPane().add(tableP);
		
		JTable table = new JTable();
		tableP.setViewportView(table);
		tbl.addColumn("ID Pasien");
		tbl.addColumn("Nama Pasien");
		tbl.addColumn("Tanggal Lahir Pasien");
		tbl.addColumn("Alamat");
		tbl.addColumn("Penyakit");
		
		table.setModel(tbl);
	
		try {
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			server.setServerName("localhost");
			server.setUser("root");
			server.setPassword("");
			server.setPortNumber(3306);
			server.setDatabaseName("project_18111100");
			java.sql.Connection koneksi=server.getConnection();
			ResultSet Input_Pasien=koneksi.prepareStatement("select * from pasien").executeQuery();
			while(Input_Pasien.next()) {
				tbl.addRow(new Object[] {Input_Pasien.getString(1),Input_Pasien.getString(2),Input_Pasien.getString(3),Input_Pasien.getString(4),Input_Pasien.getString(5)});
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
					String tg = textField_Tgl.getText();
					String al = textField_Almt.getText();
					String py = textField_Penyakit.getText();
					
					Object [] vr = {id,nm,tg,al,py};
					tbl.addRow(vr);
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					koneksi.prepareStatement("insert into pasien values('"+
							textField_ID.getText()+"','"+
							textField_Nama.getText()+"','"+
							textField_Tgl.getText()+"','"+
							textField_Almt.getText()+"','"+
							textField_Penyakit.getText()+"')" ).execute();
					JOptionPane.showMessageDialog(null,"Data Tersimpan !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
	
					}
			}
		});
		btnSimpan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSimpan.setBounds(124, 260, 89, 23);
		frame.getContentPane().add(btnSimpan);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_ID.setText("");
				textField_Nama.setText("");
				textField_Tgl.setText("");
				textField_Almt.setText("");
				textField_Penyakit.setText("");
			}
		});
		btnReset.setBounds(223, 260, 89, 23);
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
					koneksi.prepareStatement("DELETE FROM pasien "+" WHERE Id_Pasien = '"+
					table.getValueAt(table.getSelectedRow(),0)+"'").execute();
					JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnHapus.setBounds(421, 260, 89, 23);
		frame.getContentPane().add(btnHapus);
		
		JButton btnCari = new JButton("Cari");
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
					String sql = "SELECT * FROM pasien WHERE Id_Pasien = '"+ search +"'";
					ResultSet res = stmt.executeQuery (sql);
					if(res.next()) {
						textField_ID.setText(res.getString(1));
						textField_Nama.setText(res.getString(2));
						textField_Tgl.setText(res.getString(3));
						textField_Almt.setText(res.getString(4));
						textField_Penyakit.setText(res.getString(5));
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
		btnCari.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCari.setBounds(450, 48, 60, 23);
		frame.getContentPane().add(btnCari);
		
		JButton btnUpdate = new JButton("Update");
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
					String sql = "UPDATE pasien SET "
					+ "Nama_Pasien='"+textField_Nama.getText()+"',"
					+ "Tanggal_Lahir_Pasien='"+textField_Tgl.getText()+"',"
					+ "Alamat='"+textField_Almt.getText()+"',"
					+ "Penyakit='"+textField_Penyakit.getText()+"'"
					+ "WHERE "
					+ "Id_Pasien='"+textField_ID.getText()+"'"					;
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(322, 260, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblYyyymmdd = new JLabel("yyyy/mm/dd");
		lblYyyymmdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblYyyymmdd.setBounds(430, 116, 80, 24);
		frame.getContentPane().add(lblYyyymmdd);
		frame.setVisible(true);
		}
	
}
