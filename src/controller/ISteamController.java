package controller;

import java.io.IOException;

public interface ISteamController {
	
	public void primeiroCaso(String path, String name, int ano, String mes, double media) throws IOException;
	public void segundoCaso(String path, String name, int ano, String mes) throws IOException;
	public void createFile(String path, String name, String media) throws IOException;
}
