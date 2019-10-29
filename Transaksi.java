package Project_UAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaksi <MysqlDataSource,MysqlDataSource1> extends JFrame {
	DefaultTableModel tbl = new DefaultTableModel();
	int a = 0;

	private JFrame frame;
	private JTextField textField_ID_T;
	private JTextField textField_ID_P;
	private JTextField textField_ID_O;
	private JTextField textField_Tgl;
	private JTextField textField_Jmlh;
	private JButton btnSimpan;
	private JTable tableT;
	private JButton btnReset;
	private JButton btnHapus;
	private JButton btnCari;
	private JButton btnNewButton;
	private JLabel lblYyyymmdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
				try {
					Transaksi window = new Transaksi();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Transaksi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Transaksi");
		frame.setBounds(355, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTransaksi = DefaultComponentFactory.getInstance().createTitle("TRANSAKSI");
		lblTransaksi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTransaksi.setBounds(258, 11, 205, 24);
		frame.getContentPane().add(lblTransaksi);
		
		JLabel lblIdTransaksi = DefaultComponentFactory.getInstance().createTitle("ID Transaksi");
		lblIdTransaksi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblIdTransaksi.setBounds(119, 46, 91, 24);
		frame.getContentPane().add(lblIdTransaksi);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ID Pasien");
		lblNewJgoodiesTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle.setBounds(119, 81, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("ID Obat");
		lblNewJgoodiesTitle_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_1.setBounds(119, 116, 91, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_1);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("Tanggal Transaksi");
		lblNewJgoodiesTitle_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_2.setBounds(119, 151, 130, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_2);
		
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("Jumlah Transaksi");
		lblNewJgoodiesTitle_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewJgoodiesTitle_3.setBounds(119, 186, 130, 24);
		frame.getContentPane().add(lblNewJgoodiesTitle_3);
		
		textField_ID_T = new JTextField();
		textField_ID_T.setBounds(254, 49, 181, 20);
		frame.getContentPane().add(textField_ID_T);
		textField_ID_T.setColumns(10);
		
		textField_ID_P = new JTextField();
		textField_ID_P.setBounds(254, 84, 251, 20);
		frame.getContentPane().add(textField_ID_P);
		textField_ID_P.setColumns(10);
		
		textField_ID_O = new JTextField();
		textField_ID_O.setBounds(254, 119, 251, 20);
		frame.getContentPane().add(textField_ID_O);
		textField_ID_O.setColumns(10);
		
		textField_Tgl = new JTextField();
		textField_Tgl.setBounds(254, 154, 161, 20);
		frame.getContentPane().add(textField_Tgl);
		textField_Tgl.setColumns(10);
		
		textField_Jmlh = new JTextField();
		textField_Jmlh.setBounds(254, 189, 251, 20);
		frame.getContentPane().add(textField_Jmlh);
		textField_Jmlh.setColumns(10);
		
		JScrollPane tableT = new JScrollPane();
		tableT.setBounds(10, 310, 615, 145);
		frame.getContentPane().add(tableT);
		
		JTable table = new JTable();
		tableT.setViewportView(table);
		tbl.addColumn("ID Transaksi");
		tbl.addColumn("ID Pasien");
		tbl.addColumn("ID Obat");
		tbl.addColumn("Tanggal Transaksi");
		tbl.addColumn("Jumlah Transaksi");
		
		table.setModel(tbl);
		
		try {
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			server.setServerName("localhost");
			server.setUser("root");
			server.setPassword("");
			server.setPortNumber(3306);
			server.setDatabaseName("project_18111100");
			java.sql.Connection koneksi=server.getConnection();
			ResultSet Transaksi=koneksi.prepareStatement("select * from transaksi").executeQuery();
			while(Transaksi.next()) {
				tbl.addRow(new Object[] {Transaksi.getString(1),Transaksi.getString(2),Transaksi.getString(3),Transaksi.getString(4),Transaksi.getString(5)});
			}

			}	
			catch (Exception e1) {
				System.out.println(e1);
			}
				
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idt = textField_ID_T.getText();
					String idp = textField_ID_P.getText();
					String ido = textField_ID_O.getText();
					String tg = textField_Tgl.getText();
					String jl = textField_Jmlh.getText();
					
					Object [] vr = {idt,idp,ido,tg,jl};
					tbl.addRow(vr);
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					koneksi.prepareStatement("insert into transaksi values('"+
							textField_ID_T.getText()+"','"+
							textField_ID_P.getText()+"','"+
							textField_ID_O.getText()+"','"+
							textField_Tgl.getText()+"','"+
							textField_Jmlh.getText()+"')" ).execute();
					JOptionPane.showMessageDialog(null,"Data Tersimpan !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnSimpan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSimpan.setBounds(119, 260, 89, 23);
		frame.getContentPane().add(btnSimpan);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_ID_T.setText("");
				textField_ID_P.setText("");
				textField_ID_O.setText("");
				textField_Tgl.setText("");
				textField_Jmlh.setText("");
			}
		});
		btnReset.setBounds(218, 260, 89, 23);
		frame.getContentPane().add(btnReset);
		
		btnHapus = new JButton("Hapus");
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
					koneksi.prepareStatement("DELETE FROM transaksi "+" WHERE Id_Transaksi = '"+
					table.getValueAt(table.getSelectedRow(),0)+"'").execute();
					JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus !");
					}	
					catch (Exception e1) {
						System.out.println(e1);
					}
			}
		});
		btnHapus.setBounds(416, 260, 89, 23);
		frame.getContentPane().add(btnHapus);
		
		btnCari = new JButton("Cari");
		btnCari.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String search = textField_ID_T.getText();
					com.mysql.jdbc.jdbc2.optional.MysqlDataSource server= new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
					server.setServerName("localhost");
					server.setUser("root");
					server.setPassword("");
					server.setPortNumber(3306);
					server.setDatabaseName("project_18111100");
					java.sql.Connection koneksi=server.getConnection();
					java.sql.Statement stmt = koneksi.createStatement();
					String sql = "SELECT * FROM transaksi WHERE Id_Transaksi = '"+ search +"'";
					ResultSet res = stmt.executeQuery (sql);
					if(res.next()) {
						textField_ID_T.setText(res.getString(1));
						textField_ID_P.setText(res.getString(2));
						textField_ID_O.setText(res.getString(3));
						textField_Tgl.setText(res.getString(4));
						textField_Jmlh.setText(res.getString(5));
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
		btnCari.setBounds(445, 48, 60, 23);
		frame.getContentPane().add(btnCari);
		
		btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
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
					String sql = "UPDATE transaksi SET "
					+ "Id_Pasien='"+textField_ID_P.getText()+"',"
					+ "Id_Obat='"+textField_ID_O.getText()+"',"
					+ "Tanggal_Transaksi='"+textField_Tgl.getText()+"',"
					+ "Jumlah_Transaksi='"+textField_Jmlh.getText()+"'"
					+ "WHERE "
					+ "Id_Transaksi='"+textField_ID_T.getText()+"'"					;
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
		btnNewButton.setBounds(317, 260, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblYyyymmdd = new JLabel("yyyy/mm/dd");
		lblYyyymmdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblYyyymmdd.setBounds(425, 151, 80, 24);
		frame.getContentPane().add(lblYyyymmdd);
		frame.setVisible(true);
	}
}
