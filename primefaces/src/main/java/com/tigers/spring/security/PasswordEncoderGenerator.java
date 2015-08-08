package com.tigers.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * 
 * @author Pantera
 *
 */
public class PasswordEncoderGenerator {


	/**
	 * 
	 * @param  password -> password ah encriptar
	 * @return password encode in BCrypt de Spring provider
	 */
	public static String encodePassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return  passwordEncoder.encode(password);
	}
	
	/**
	 * 
	 * @param rawpassword     -> password ah evaluar
	 * @param encodedPassword -> password encriptada
	 * @return true|false 
	 */
	public static boolean evalPassword(String rawpassword,String encodedPassword){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawpassword,encodedPassword);
	}
	
	
	public static void main(String[] args) {
		int i = 0;
		//$2a$10$iLRdgu/NIm/1UOZZvPeBn.XOdH.kcKOS1.C2kFiWkEdVbPsfEADZu
		while (i < 10) {
			String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
	
			System.out.println(hashedPassword);
			System.out.println(PasswordEncoderGenerator.evalPassword(password,hashedPassword));
			
			i++;
		}
		
		
	}
}
