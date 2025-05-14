package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController implements ISteamController {

	public SteamController() {
		super();
	}

	@Override
	public void primeiroCaso(String path, String name, int ano, String mes, double media) throws IOException {
		File arq = new File(path, name);
		if(arq.exists() && arq.isFile()) {
			FileInputStream flow = new FileInputStream(arq);
			InputStreamReader read = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(read);
			String linha;
			linha = buffer.readLine();
			while((linha = buffer.readLine()) != null) {
				String[] v = linha.split(",");
				int anoString = Integer.parseInt(v[1]);
				String mesString = v[2];
				double mediaString = Double.parseDouble(v[3]);
				if(anoString == ano && mesString.equalsIgnoreCase(mes) && mediaString >= media) {
					System.out.println(v[0] +  " | " + v[3]);
				}
			}
			buffer.close();
			read.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
		
		
	}

	@Override
	public void segundoCaso(String path, String name, int ano, String mes) throws IOException {
		File arq = new File(path, name);
		if(arq.exists() && arq.isFile()) {
			FileInputStream flow = new FileInputStream(arq);
			InputStreamReader read = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(read);
			String linha;
			linha = buffer.readLine();
			while((linha = buffer.readLine()) != null) {
				String[] v = linha.split(",");
				int anoString = Integer.parseInt(v[1]);
				String mesString = v[2];
				if(anoString == ano && mesString.toLowerCase().contains(mes)) {
					createFile(path, v[0], v[3]);
				}
			}
			buffer.close();
			read.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
	public void createFile(String path, String name, String media) throws IOException {
		File dir = new File(path);
		File arq = new File(path, "nome.csv");
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(name);
			print.write(";");
			print.write(media);
			print.write("\n");
			print.flush();
			print.close();
			fileWriter.close();
			
		}  else {
			throw new IOException("Diretório Inválido");
		}
	}

}
