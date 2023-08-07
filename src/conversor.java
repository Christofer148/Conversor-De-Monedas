import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mx.combo.SComboBox;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.MatteBorder;
import javax.swing.DropMode;
import javax.swing.JSeparator;

public class conversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtToConvert;
	private JTextField txtConverted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversor frame = new conversor();
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
	public conversor() {
		setTitle("Currency Converter");
		setIconImage(Toolkit.getDefaultToolkit().getImage(conversor.class.getResource("/com/image/exchange.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 198, 95));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Currency Converter ");
		lblTitle.setForeground(new Color(111, 80, 0));
		lblTitle.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 22));
		lblTitle.setBounds(256, 51, 208, 29);
		contentPane.add(lblTitle);
		
		txtToConvert = new JTextField();
		txtToConvert.setBorder(null);
		txtToConvert.setBackground(new Color(250, 198, 95));
		txtToConvert.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtToConvert.setForeground(new Color(111, 80, 0));
		txtToConvert.setBounds(60, 175, 200, 30);
		contentPane.add(txtToConvert);
		txtToConvert.setColumns(10);
		
		JComboBox<String> cmboxBaseCurrency = new JComboBox<String>();
		cmboxBaseCurrency.setForeground(new Color(68, 92, 100));
		cmboxBaseCurrency.addItem("MXN");
		cmboxBaseCurrency.addItem("EUR");
		cmboxBaseCurrency.addItem("USD");
		
		cmboxBaseCurrency.addItem("AUD"); //Australian Dollar
		cmboxBaseCurrency.addItem("BOB"); //Bolivian Boliviano
		cmboxBaseCurrency.addItem("VES"); //Venezuelan bolívar
		cmboxBaseCurrency.addItem("BRL"); //Brazilian real
		cmboxBaseCurrency.addItem("JPY"); //Japanese yen
		cmboxBaseCurrency.addItem("HKD"); //Hong Kong dollar
		cmboxBaseCurrency.addItem("KRW"); //South Korean won
		cmboxBaseCurrency.addItem("CHF"); //Swiss franc
		cmboxBaseCurrency.addItem("RUB"); //Russian ruble
		cmboxBaseCurrency.addItem("SGD"); //Singapore dollar
		cmboxBaseCurrency.addItem("AED"); //United Arab Emirates dirham
		cmboxBaseCurrency.addItem("CLP"); //Chilean peso
		cmboxBaseCurrency.addItem("COP"); //Colombian peso
		cmboxBaseCurrency.addItem("CRC"); //Costa Rican colón
		cmboxBaseCurrency.addItem("CUP"); //Cuban peso
		cmboxBaseCurrency.addItem("NZD"); //New Zealand dollar
		cmboxBaseCurrency.addItem("NZD"); //New Zealand dollar
		cmboxBaseCurrency.addItem("DOP"); //Dominican peso
		cmboxBaseCurrency.addItem("GTQ"); //Guatemalan quetzal
		cmboxBaseCurrency.addItem("HNL"); //Honduran lempira
		cmboxBaseCurrency.addItem("JMD"); //Jamaican dollar
		cmboxBaseCurrency.addItem("ARS"); //Argentine peso
		cmboxBaseCurrency.addItem("UYU"); //Uruguayan peso
		cmboxBaseCurrency.addItem("TWD"); //New Taiwan dollar
		
		cmboxBaseCurrency.setBounds(60, 215, 200, 30);
		contentPane.add(cmboxBaseCurrency);
		
		
		txtConverted = new JTextField();
		txtConverted.setBorder(null);
		txtConverted.setBackground(new Color(250, 198, 95));
		txtConverted.setForeground(new Color(111, 80, 0));
		txtConverted.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtConverted.setBounds(450, 175, 200, 30);
		contentPane.add(txtConverted);
		txtConverted.setColumns(10);
		
		JComboBox<String> cmboxConverted = new JComboBox<String>();
		cmboxConverted.addItem("MXN");
		cmboxConverted.addItem("EUR");
		cmboxConverted.addItem("USD");
		
		cmboxConverted.addItem("AUD"); //Australian Dollar
		cmboxConverted.addItem("BOB"); //Bolivian Boliviano
		cmboxConverted.addItem("VES"); //Venezuelan bolívar
		cmboxConverted.addItem("BRL"); //Brazilian real
		cmboxConverted.addItem("JPY"); //Japanese yen
		cmboxConverted.addItem("HKD"); //Hong Kong dollar
		cmboxConverted.addItem("KRW"); //South Korean won
		cmboxConverted.addItem("CHF"); //Swiss franc
		cmboxConverted.addItem("RUB"); //Russian ruble
		cmboxConverted.addItem("SGD"); //Singapore dollar
		cmboxConverted.addItem("AED"); //United Arab Emirates dirham
		cmboxConverted.addItem("CLP"); //Chilean peso
		cmboxConverted.addItem("COP"); //Colombian peso
		cmboxConverted.addItem("CRC"); //Costa Rican colón
		cmboxConverted.addItem("CUP"); //Cuban peso
		cmboxConverted.addItem("NZD"); //New Zealand dollar
		cmboxConverted.addItem("NZD"); //New Zealand dollar
		cmboxConverted.addItem("DOP"); //Dominican peso
		cmboxConverted.addItem("GTQ"); //Guatemalan quetzal
		cmboxConverted.addItem("HNL"); //Honduran lempira
		cmboxConverted.addItem("JMD"); //Jamaican dollar
		cmboxConverted.addItem("ARS"); //Argentine peso
		cmboxConverted.addItem("UYU"); //Uruguayan peso
		cmboxConverted.addItem("TWD"); //New Taiwan dollar
		cmboxConverted.setBounds(450, 215, 200, 30);
		contentPane.add(cmboxConverted);
		
		JLabel lblTitle_1 = new JLabel("=");
		lblTitle_1.setForeground(new Color(131, 95, 1));
		lblTitle_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
		lblTitle_1.setBounds(348, 171, 18, 29);
		contentPane.add(lblTitle_1);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String baseCurrency = cmboxBaseCurrency.getSelectedItem().toString();
				String currencyToConvert = cmboxConverted.getSelectedItem().toString();
				double amount = Double.parseDouble(txtToConvert.getText());
				Conversion conv = new Conversion(baseCurrency, currencyToConvert, amount);
				
				if(conv.connect()) {
					txtConverted.setText(conv.getConversion());
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				panel.setBackground(new Color(229, 166, 3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(241, 175, 3));
			}
		});
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(241, 175, 3));
		panel.setBounds(298, 315, 126, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convert");
		lblNewLabel.setForeground(new Color(111, 80, 0));
		lblNewLabel.setBounds(38, 0, 50, 46);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String auxText = txtConverted.getText();
				txtConverted.setText(txtToConvert.getText());
				txtToConvert.setText(auxText);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				panel_1.setBackground(new Color(229, 166, 3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(241, 175, 3));
			}
		});
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel_1.setBackground(new Color(241, 175, 3));
		panel_1.setBounds(315, 218, 90, 23);
		contentPane.add(panel_1);
		
		JLabel lblRevert = new JLabel("Revert");
		lblRevert.setForeground(new Color(111, 80, 0));
		lblRevert.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblRevert.setBounds(24, 0, 42, 23);
		panel_1.add(lblRevert);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(111, 80, 0));
		separator.setForeground(new Color(111, 80, 0));
		separator.setBounds(60, 205, 200, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(111, 80, 0));
		separator_1.setBounds(450, 205, 200, 2);
		contentPane.add(separator_1);
	}
}
