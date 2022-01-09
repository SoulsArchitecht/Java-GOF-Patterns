package gof_patterns.Pattern1_Adapter;

public class JackToXLRAdapter {
    public static void main(String[] args) {
        JackConnection jackConnection = new JackConnection();
        XLR xlrConnection = new InputAdapter(jackConnection);
        Music music = new Music();
        music.payingGuitar(xlrConnection);
    }
}

interface Jack {
    void getConnection();
}

interface  XLR {
    void getConnection();
}

class JackConnection implements Jack {
    @Override
    public void getConnection() {
        System.out.println("Guitar was connected to the amplifier by the Jack cable");
    }
}

class XLRConnection implements XLR {

    @Override
    public void getConnection() {
        System.out.println("Guitar was connected to the amplifier by the XLR cable");
    }
}

class Music {
    void payingGuitar(XLR xlr) {
        xlr.getConnection();
    }
}

class InputAdapter implements XLR {
    Jack jack;

    public InputAdapter(Jack jack) {
        this.jack = jack;
    }

    @Override
    public void getConnection() {
        jack.getConnection();
    }
}
