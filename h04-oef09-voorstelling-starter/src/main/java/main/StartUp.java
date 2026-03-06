package main;

import domein.DomeinController;
import ui.VertoonbaarApplicatie;

public class StartUp {
    public static void main(String[] args) {
        new VertoonbaarApplicatie(new DomeinController()).start();
    }
}