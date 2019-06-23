package com.dev.operations;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;

public class UpdateProfile {
public static void main(String[] args) {
	User user=new User();
	Services ser =new ServicesImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter username");
	user.setUsername(sc.nextLine());
	System.out.println("Enter userid");
	user.setId(Integer.parseInt(sc.nextLine()));
	System.out.println("Enter password");
	user.setPassword(sc.nextLine());
	boolean b=ser.updateProfile(user);
	if(b) {
		System.out.println("Done");
	}
	else {
		System.out.println("Error");
	}
	
	
	
}
}
