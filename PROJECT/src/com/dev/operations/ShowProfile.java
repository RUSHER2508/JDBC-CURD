package com.dev.operations;

import com.dev.beans.User;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;

public class ShowProfile {
	public static void main(String[] args) {
		
	
User user=new User();
Services ser=new ServicesImpl();
ser.showProfile();
	}
}
