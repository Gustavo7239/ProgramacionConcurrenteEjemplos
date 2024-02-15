package urlEjercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import netscape.javascript.JSObject;

public class Url {
	public static void main(String[] args) {
		try {
			URI uri = new URI("https://reqres.in/api/users/2");
			URL url = uri.toURL();
			System.out.println(url.toString());
			
			InputStream is = url.openStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			String linea="";
			while((linea += br.readLine())!=null) {
				System.out.println(linea);
			}
			
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
