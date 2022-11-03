package com.drone.drones.common.constant;

public enum ModelTypeEnum {

    LIGHTWEIGHT("Lightweight"),
    MIDDLEWEIGHT("Middleweight"),
    CRUISERWEIGHT("Cruiserweight"),
    HEAVYWEIGHT("Heavyweight");

    private final String value;

    ModelTypeEnum(String v) {
        this.value = v;
    }

    public String value() {
        return this.value;
    }

    public static ModelTypeEnum fromValue(String value) {
        for (ModelTypeEnum c : ModelTypeEnum.values()) {
            if (c.value.startsWith(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
