package com.educandoweb.courser.entities.enums;

public enum OrderStatus {
	WATTING_PAYMENT(1),
	PAD(2), 
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	// codigo do tipo enumerado

	private int code;

	// construtor do tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	// metodo publico para acessar o codigo de cima

	public int getCode() {
		return code;
	}

	// metodo estatico para converter um valor numerico em tipo enumerado
	public static OrderStatus valueOf(int code) { // static pois nao precisa instanciar , vai funcionar sempre
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");

	}

}
