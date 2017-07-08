package com.cs545.zara.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Insufficient Balance :")
public class BalanceIsInsufficientException extends RuntimeException{

private static final long serialVersionUID = -694354952032299587L;
	
	private String username;

	public BalanceIsInsufficientException(String username) {
		this.username = username;
	}
	
	public String username() {
		return username;
	}
}
