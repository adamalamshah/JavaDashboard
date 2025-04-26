package DashboardPemLan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Dashboard_245150201111018 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTable tableClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard_245150201111018 frame = new Dashboard_245150201111018();
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
	public Dashboard_245150201111018() {
		setPreferredSize(new Dimension(1280, 720));
		setMinimumSize(new Dimension(1280, 720));
		setTitle("Dashboard");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
				@SuppressWarnings("rawtypes")
				Vector<Vector> tableData = model.getDataVector();
				try {
					FileOutputStream file = new FileOutputStream("file.bin");
					ObjectOutputStream output = new ObjectOutputStream(file);
					output.writeObject(tableData);
					output.close();
					file.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileInputStream file = new FileInputStream("file.bin");
					ObjectInputStream input = new ObjectInputStream(file);
					@SuppressWarnings({ "rawtypes", "unchecked" })
					Vector<Vector> tableData = (Vector<Vector>) input.readObject();
					input.close();
					file.close();
					
					DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
		            for (int i = 0; i < tableData.size(); i++) {
		                @SuppressWarnings("rawtypes")
						Vector row = tableData.get(i);
		                model.addRow(new Object[]{row.get(0), row.get(1), row.get(2), row.get(3)});
		            }
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 247, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("List of Clients");
		lblTitle.setIconTextGap(10);
		lblTitle.setIcon(new ImageIcon(Dashboard_245150201111018.class.getResource("/DashboardPemLan/iconGroup.png")));
		lblTitle.setFont(new Font("Product Sans", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 2), "New Client", TitledBorder.LEADING, TitledBorder.TOP, new Font("Product Sans", Font.BOLD, 26), null));
		panel.setBackground(new Color(140, 170, 240));
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Product Sans", Font.BOLD, 22));
		lblName.setBounds(24, 70, 350, 20);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblName.setLabelFor(textFieldName);
		textFieldName.setBounds(24, 95, 350, 30);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Product Sans", Font.BOLD, 22));
		lblEmail.setBounds(24, 160, 350, 20);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(24, 185, 350, 30);
		panel.add(textFieldEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Product Sans", Font.BOLD, 22));
		lblPhone.setBounds(24, 250, 350, 20);
		panel.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblPhone.setLabelFor(textFieldPhone);
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(24, 275, 350, 30);
		panel.add(textFieldPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Product Sans", Font.BOLD, 22));
		lblAddress.setBounds(24, 340, 350, 20);
		panel.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Product Sans", Font.PLAIN, 20));
		lblAddress.setLabelFor(textFieldAddress);
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(24, 365, 350, 30);
		panel.add(textFieldAddress);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(Dashboard_245150201111018.class.getResource("/DashboardPemLan/iconAdd.png")));
		btnAdd.setIconTextGap(10);
		btnAdd.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String email = textFieldEmail.getText();
				String phone = textFieldPhone.getText();
				String address = textFieldAddress.getText();
				
				if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
					model.addRow(new Object[] {name, email, phone, address});
					textFieldName.setText("");
					textFieldEmail.setText("");
					textFieldPhone.setText("");
					textFieldAddress.setText("");
				}
			}
		});
		btnAdd.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnAdd.setBounds(24, 450, 160, 40);
		panel.add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setIconTextGap(10);
		btnClear.setIcon(new ImageIcon(Dashboard_245150201111018.class.getResource("/DashboardPemLan/iconClear.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldEmail.setText("");
				textFieldPhone.setText("");
				textFieldAddress.setText("");
			}
		});
		btnClear.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnClear.setBounds(214, 450, 160, 40);
		panel.add(btnClear);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(Dashboard_245150201111018.class.getResource("/DashboardPemLan/iconTrashCan.png")));
		btnDelete.setIconTextGap(10);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableClients.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null, "No row is selected! Please select one row", "Select row", JOptionPane.ERROR_MESSAGE);
				}
				else {
					DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
					model.removeRow(row);
				}
			}
		});
		btnDelete.setFont(new Font("Product Sans", Font.BOLD, 18));
		
		JScrollPane scrollPaneClients = new JScrollPane();
		
		tableClients = new JTable();
		tableClients.setBackground(new Color(255, 255, 255));
		scrollPaneClients.setViewportView(tableClients);
		tableClients.setFont(new Font("Product Sans", Font.PLAIN, 20));
		tableClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Phone", "Address"
			}
		));
		tableClients.setRowHeight(30);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 3));
		separator.setForeground(new Color(48, 48, 48));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneClients, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
					.addGap(26))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1241, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
							.addGap(5))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(scrollPaneClients))
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
