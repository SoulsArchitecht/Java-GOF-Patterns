package gof_patterns.Pattern1_Adapter;

    /**Adapter (Переходник)
     Совмещает некоторые интерфейсы, которые по идее не совместимы
     Код на вход ожидает один интерфейс, а нам нужно поместить другой.
    */
public class TestAdapter {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        Radio radio = new Radio();
        EuroSocket euroSocket = new SocketAdapter(americanSocket);
        radio.listenMusic(euroSocket);
    }
}

//интерфейс евророзетка
interface EuroSocket {
    void getPower();
}

//интерфейс американская розетка
interface AmericanSocket {
    void getPower();
}

//переходник между розетками
// 1) имплементируем куда втыкать
// 2) объявляем поле что втыкать
// 3) создаем конструктор с полем что втыкать
// 4) переопределяем метод интерфейса куда втыкать с полем что втыкать
class SocketAdapter implements EuroSocket {
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}

class SimpleAmericanSocket implements AmericanSocket {

    @Override
    public void getPower() {
        System.out.println("get 110 volt");
    }
}

class Radio {
    public void listenMusic(EuroSocket euroSocket) {
        euroSocket.getPower();
    }
}


