package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {

        UserInterface userInterface = new UserInterface();
        userInterface.display();

    }
}
