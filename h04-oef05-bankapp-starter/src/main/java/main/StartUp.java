package main;

import cui.BankApplicatie;
import domein.DomeinController;

public class StartUp {
    public static void main(String[] args) {
        new BankApplicatie(new DomeinController()).start();
    }
}