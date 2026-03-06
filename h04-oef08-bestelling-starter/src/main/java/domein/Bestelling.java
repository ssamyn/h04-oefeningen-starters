package domein;

public class Bestelling {
    public static final int MAX_ARTIKELEN = 8;
    public static final int MAX_PRINTERS = 4;
    public static final int MAX_SCANNERS = 3;
    public static final int MAX_LAPTOPS = 2;
    private int printers, laptops, scanners;

    public Bestelling(int printers, int laptops, int scanners) {
        int aantalArtikels = printers + laptops + scanners;
        // TODO controle op aantal artikels - BestellingException

        setPrinters(printers);
        setLaptops(laptops);
        setScanners(scanners);
    }

    public int getPrinters() {
        return printers;
    }

    public int getLaptops() {
        return laptops;
    }

    public int getScanners() {
        return scanners;
    }

    private void setPrinters(int printers) {
        // TODO controle op aantal printers - IllegalArgumentException
        this.printers = printers;
    }

    private void setLaptops(int laptops) {
        // TODO controle op aantal laptops - IllegalArgumentException
        this.laptops = laptops;
    }

    private void setScanners(int scanners) {
        // TODO controle op aantal scanners - IllegalArgumentException
        this.scanners = scanners;
    }

    @Override
    public String toString() {
        return String.format("Bestelling voor %d printer%s, %d laptop%s en %d scanner%s.",
                printers, printers == 1 ? "" : "s",
                laptops, laptops == 1 ? "" : "s",
                scanners, scanners == 1 ? "" : "s");
    }
}