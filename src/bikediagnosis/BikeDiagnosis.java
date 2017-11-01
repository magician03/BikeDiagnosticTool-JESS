package bikediagnosis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import jess.JessException;
import jess.Rete;


public class BikeDiagnosis extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeDiagnosis frame = new BikeDiagnosis();
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
	public BikeDiagnosis() {
		setBackground(Color.WHITE);
		setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		setResizable(false);
		setTitle("Bike Diagnostic Tool");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 297);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOpenTheProject = new JButton("Start Bike Diagnosis");
		btnOpenTheProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Rete r = new Rete();
						try {
							r.batch(System.getProperty("user.dir") + "/bike-jess.clp");
						} catch (JessException ex) {
							ex.printStackTrace();
						}
					}
				}).start();
				
				
			}
		});
		btnOpenTheProject.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		btnOpenTheProject.setBounds(10, 139, 367, 50);
		contentPane.add(btnOpenTheProject);
		
		JButton btnAbout = new JButton("Creators");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "<Group members names here>\n"
                                        + "IIT2015060" + "  IIT2015051   \n" + "IIT2015035" + "  IIT2015062   \n"
                                        + "IIT2015056" + "  IIT2015029   \n" + "IIT2015055" + "  IIT2015041   \n"
                                        + "IIT2015033" + "  IIT2015030   \n" + "RIT2015031" + "  RIT2015041   \n"
                                        + "IIT2015031";
;
				JOptionPane.showMessageDialog(null, msg,"JESS Project by",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbout.setBounds(153, 234, 89, 23);
		contentPane.add(btnAbout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(120, 0, 128, 128);
		contentPane.add(lblNewLabel);
	}
}
