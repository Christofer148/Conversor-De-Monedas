import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

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

public class conversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtToConvert;
	private JTextField txtConverted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://pokeapi.co/api/v2/pokemon/pikachu");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			
			int responseCode = con.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("Ocurrio un error: " + responseCode);
			}else {
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}
				
				scanner.close();
				
				JSONObject jsonObject = new JSONObject(informationString.toString());
				
				JSONArray jsonArray = jsonObject.getJSONArray("abilities");
				
				JSONObject jsonObject1 = jsonArray.getJSONObject(0);
				
				JSONObject jsonObject2 =  jsonObject1.getJSONObject("ability");
				
				System.out.println(jsonObject2.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Currency Converter by Christofer Alcaraz");
		lblTitle.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 22));
		lblTitle.setBounds(137, 51, 425, 29);
		contentPane.add(lblTitle);
		
		txtToConvert = new JTextField();
		txtToConvert.setBounds(61, 175, 199, 29);
		contentPane.add(txtToConvert);
		txtToConvert.setColumns(10);
		
		JComboBox cmboxBaseCurrency = new JComboBox();
		cmboxBaseCurrency.addItem("MXN");
		cmboxBaseCurrency.addItem("EUR");
		cmboxBaseCurrency.addItem("USD");
		cmboxBaseCurrency.setBounds(61, 215, 199, 29);
		contentPane.add(cmboxBaseCurrency);
		
		txtConverted = new JTextField();
		txtConverted.setBounds(449, 175, 199, 29);
		contentPane.add(txtConverted);
		txtConverted.setColumns(10);
		
		JComboBox cmboxConverted = new JComboBox();
		cmboxConverted.addItem("MXN");
		cmboxConverted.addItem("EUR");
		cmboxConverted.addItem("USD");
		cmboxConverted.setBounds(449, 216, 199, 26);
		contentPane.add(cmboxConverted);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addMouseListener(new MouseAdapter() {
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
		});
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 14));
		btnNewButton.setBounds(298, 317, 126, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblTitle_1 = new JLabel("=");
		lblTitle_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
		lblTitle_1.setBounds(348, 171, 24, 29);
		contentPane.add(lblTitle_1);
		
		JButton btnRevert = new JButton("Revert");
		btnRevert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String auxText = txtConverted.getText();
				txtConverted.setText(txtToConvert.getText());
				txtToConvert.setText(auxText);
			}
		});
		btnRevert.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		btnRevert.setBounds(315, 218, 89, 23);
		contentPane.add(btnRevert);
	}
}
