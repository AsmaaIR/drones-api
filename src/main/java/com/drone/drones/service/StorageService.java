package com.drone.drones.service;

import java.io.IOException;

public interface StorageService {

    String saveImage(String image, String... directory) throws IOException;
}
