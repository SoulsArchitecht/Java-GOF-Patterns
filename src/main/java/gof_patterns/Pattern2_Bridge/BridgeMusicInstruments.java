package gof_patterns.Pattern2_Bridge;


public class BridgeMusicInstruments {
    public static void main(String[] args) {
        MusicInstrument musicInstrument = new Guitar(new Fender());
        musicInstrument.playInstrument();

        MusicInstrument musicInstrument1 = new Piano(new Yamaha());
        musicInstrument1.playInstrument();

        MusicInstrument musicInstrument2 = new ContraBass(new Fender());
        musicInstrument2.playInstrument();
    }

}

abstract class MusicInstrument {
    TypeOfMusicInstrument typeOfMusicInstrument;

    public MusicInstrument(TypeOfMusicInstrument typeOfMusicInstrument) {
        this.typeOfMusicInstrument = typeOfMusicInstrument;
    }

    abstract void playInstrument();
}

interface TypeOfMusicInstrument {
    void playOnMusicInstrument(String string);
}

class Guitar extends MusicInstrument {

    public Guitar (TypeOfMusicInstrument typeOfMusicInstrument) {
        super(typeOfMusicInstrument);
    }

    @Override
    void playInstrument() {
        typeOfMusicInstrument.playOnMusicInstrument("playing guitar");
    }
}

class Piano extends  MusicInstrument {

    public Piano (TypeOfMusicInstrument typeOfMusicInstrument) {
        super(typeOfMusicInstrument);
    }

    @Override
    void playInstrument() {
        typeOfMusicInstrument.playOnMusicInstrument("playing piano");
    }

}

class ContraBass extends MusicInstrument {
    public ContraBass (TypeOfMusicInstrument typeOfMusicInstrument) {
        super(typeOfMusicInstrument);
    }

    @Override
    void playInstrument() {
        typeOfMusicInstrument.playOnMusicInstrument("playing contraBass");
    }
}

class Yamaha implements TypeOfMusicInstrument {

    @Override
    public void playOnMusicInstrument(String string) {
        System.out.println(string + " Yamaha");
    }
}

class Fender implements TypeOfMusicInstrument {

    @Override
    public void playOnMusicInstrument(String string) {
        System.out.println(string + " Fender");
    }
}

