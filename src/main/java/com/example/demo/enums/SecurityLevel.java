package com.example.demo.enums;

public enum SecurityLevel  {
	
		LOW("Low Security"),
	    MEDIUM("Medium Security"),
	    HIGH("High Security");

	    private final String description;

	    // Construtor do enum para associar uma descrição a cada nível de segurança
	    SecurityLevel(String description) {
	        this.description = description;
	    }

	    // Método getter para obter a descrição
	    public String getDescription() {
	        return description;
	    }
	}