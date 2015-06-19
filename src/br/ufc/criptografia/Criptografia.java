package br.ufc.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	
	
	public String criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		byte msgDigest[] = algoritmo.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
		
		for(byte b: msgDigest){
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		String senhahex = hexString.toString();
		
		return senhahex;
	}
	
	
	public boolean compararSenhas(String senhaLogin, String senhaBanco) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		byte msgDigestSenhaLogin[] = algoritmo.digest(senhaLogin.getBytes("UTF-8"));
		
		StringBuilder hexStringSenhaLogin = new StringBuilder();
		
		for(byte b: msgDigestSenhaLogin){
			hexStringSenhaLogin.append(String.format("%02X", 0xFF & b));
		}
		
		String senhaLoginHex = hexStringSenhaLogin.toString();
		
		if(senhaLoginHex.equals(senhaBanco)) 
			return true;
		
		return false;
	}
	
}