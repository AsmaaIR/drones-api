package com.drone.drones.common.constant;

public enum ModelTypeEnum {

	LIGHT_WEIGHT("Lightweight"),
	Middle_WEIGHT("Middleweight"),
	CRUISER_WEIGHT("Cruiserweight"),
	HEAVY_WEIGHT("Heavyweight");

	private final String value;

	ModelTypeEnum(String v) {
		this.value = v;
	}

	public String value() {
		return this.value;
	}
}

