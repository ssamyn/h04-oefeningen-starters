package main;

import domein.DomeinController;
import ui.VertoonbaarApplicatie;

public class StartUp {
    public static void main(String[] args) {
        try {
            new VertoonbaarApplicatie(new DomeinController()).start();
        } catch (Exception e) {
            System.out.println("Het programma kon niet gestart worden, corrupte data in de databank...");
        }
    }
}