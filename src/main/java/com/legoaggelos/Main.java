package com.legoaggelos;

import com.legoaggelos.gui.LaunchPage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path eulaFile = Paths.get(System.getProperty("user.dir")).resolve("eula.txt");
        try{if(!Files.exists(eulaFile)){
            Files.createFile(eulaFile);
        }else{
            Files.deleteIfExists(eulaFile);
            Files.createFile(eulaFile);
        }
        Files.writeString(eulaFile, "eula=true");
        new LaunchPage(List.of("File created successfully."));
        } catch(Exception e){
            System.out.println("Oops, something went wrong.");
            new LaunchPage(List.of("Something went wrong.","Run in console for error message."));
            e.printStackTrace();
        }
    }
}