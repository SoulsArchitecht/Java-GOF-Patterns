package gof_patterns.Pattern2_Bridge;

public class BridgePC {
    public static void main(String[] args) {
        PC pc1 = new Notebook(new Acer());
        pc1.runPC();

        PC pc2 = new Desktop(new Asus());
        pc2.runPC();

        PC pc3 = new MonoBlock(new Samsung());
        pc3.runPC();
    }
}

abstract class PC {
    Vendor vendor;

    public PC(Vendor vendor) {
        this.vendor = vendor;
    }

    abstract void runPC();
}

interface Vendor {
    void runPC(String string);
}

class Notebook extends PC {

    public Notebook(Vendor vendor) {
        super(vendor);
    }

    @Override
    void runPC() {
        vendor.runPC("start notebook");
    }
}

class Desktop extends PC {

    public Desktop(Vendor vendor) {
        super(vendor);
    }

    @Override
    void runPC() {
        vendor.runPC("start desktop");
    }
}

class MonoBlock extends PC {

    public MonoBlock(Vendor vendor) {
        super(vendor);
    }

    @Override
    void runPC() {
        vendor.runPC("start monoBlock");
    }
}

class Samsung implements Vendor {

    @Override
    public void runPC(String string) {
        System.out.println(string + " " + "Samsung");
    }
}

class Asus implements Vendor {

    @Override
    public void runPC(String string) {
        System.out.println(string + " " + "Asus");
    }

}

class Acer implements Vendor {

    @Override
    public void runPC(String string) {
        System.out.println(string + " " + "Acer");
    }
}
