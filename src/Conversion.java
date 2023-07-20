import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Conversion {
	
	private String baseCurrency;
	private String currencyToConvert;
	private double amount;
	private String apiKey = "8f4f184c3c2f0c82c48086cd212dcc54ddbbb847";
	private StringBuilder informationString;
	
	public Conversion(String baseCurrency, String currencyToConvert, double amount) {
		this.baseCurrency = baseCurrency;
		this.currencyToConvert = currencyToConvert;
		this.amount = amount;
		
	}
	
	public boolean connect() {
		try {
			URL url = new URL("https://api.getgeoapi.com/v2/currency/convert?api_key=" + this.apiKey + "&from=" + this.baseCurrency + "&to=" + this.currencyToConvert + "&amount=" + this.amount + "&format=json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			
			int responseCode = con.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("Ocurrio un error: " + responseCode);
			}else {
				this.informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()) {
					this.informationString.append(scanner.nextLine());
				}
				
				scanner.close();
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String getConversion() {
		JSONObject jsonObject = new JSONObject(informationString.toString());
		String rate = jsonObject.getJSONObject("rates").getJSONObject(this.currencyToConvert).getString("rate_for_amount");
		return rate;
	}
}
