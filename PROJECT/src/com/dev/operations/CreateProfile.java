package com.dev.operations;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;

public class CreateProfile {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	User user=new User();
	Services ser=new ServicesImpl();
	System.out.println("Enter the userid");
	user.setId(Integer.parseInt(sc.nextLine()));
	System.out.println("Enter the username");
	user.setUsername(sc.nextLine());
	System.out.println("Enter the email");
	user.setEmail(sc.nextLine());
	System.out.println("Enter the password");
	user.setPassword(sc.nextLine());
	boolean b=ser.createProfile(user);
	if(b) {
		System.out.println("Done");
	}
	else {
		System.out.println("Not Done");
	}
}
}
