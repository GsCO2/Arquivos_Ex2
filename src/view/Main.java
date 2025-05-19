package view;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import controller.*;
public class Main {

	public static void main(String[] args) throws IOException {
		int opc = 0; 
		ISteamController isc = new SteamController();
		String path;
		String nome = "SteamCharts.csv";
		int ano;
		String mes;
		int media;
		while(opc != 4) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Primeiro Caso \n 2 - Segundo caso \n 4 - FIM"));
			switch(opc) {
			case 1:
				path = "C:\\TEMP";
				ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano"));
				mes = (JOptionPane.showInputDialog("Digite um mes(em extenso)"));
				media = Integer.parseInt(JOptionPane.showInputDialog("Digite uma média"));
				try {
					isc.primeiroCaso(path, nome, ano, mes, media);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				path = (JOptionPane.showInputDialog("Digite o diretorio(exemplo: C:\\TEMP)"));
				File dir = new File(path);
				if (!dir.exists() || !dir.isDirectory()) {
				    throw new IOException("Diretório inválido");
				}
				ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano"));
				mes = (JOptionPane.showInputDialog("Digite um mes(em extenso)"));
				try {
					isc.segundoCaso(path, nome, ano, mes);
				} catch (IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ARQUIVO CSV GERADO!");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "FIM");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida");
				break;
			}
		}
	}

} 
