public class Main {
    public static void main(String[] args) {
        ГорячийНапитокТемпература кофе = new ГорячийНапитокТемпература("Кофе", 250, 80);
        ГорячийНапитокТемпература чай = new ГорячийНапитокТемпература("Чай", 200, 70);
        ГорячийНапитокТемпература шоколад = new ГорячийНапитокТемпература("Горячий шоколад", 300, 75);

        ГорячихНапитковАвтомат автомат = new ГорячихНапитковАвтомат();
        автомат.addProduct(кофе);
        автомат.addProduct(чай);
        автомат.addProduct(шоколад);

        System.out.println(автомат.getProduct("Кофе", 250, 80)); // должен вернуть объект кофе
        System.out.println(автомат.getProduct("Чай", 200, 70)); // должен вернуть объект чай
        System.out.println(автомат.getProduct("Горячий шоколад", 300, 75)); // должен вернуть объект шоколад
    }
}

public interface ТорговыйАвтомат {
    ГорячийНапитокТемпература getProduct(String name, int volume, int temperature);
}

public class ГорячийНапиток {
    private String name;
    private int volume;

    public ГорячийНапиток(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "ГорячийНапиток{name='" + name + "', volume=" + volume + '}';
    }
}

public class ГорячийНапитокТемпература extends ГорячийНапиток {
    private int temperature;

    public ГорячийНапитокТемпература(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "ГорячийНапитокТемпература{name='" + getName() + "', volume=" + getVolume() + ", temperature=" + temperature + '}';
    }
}

import java.util.ArrayList;
import java.util.List;

public class ГорячихНапитковАвтомат implements ТорговыйАвтомат {
    private List<ГорячийНапитокТемпература> products;

    public ГорячихНапитковАвтомат() {
        products = new ArrayList<>();
    }

    public void addProduct(ГорячийНапитокТемпература product) {
        products.add(product);
    }

    @Override
    public ГорячийНапитокТемпература getProduct(String name, int volume, int temperature) {
        for (ГорячийНапитокТемпература product : products) {
            if (product.getName().equals(name) && product.getVolume() == volume && product.getTemperature() == temperature) {
                return product;
            }
        }
        return null;
    }
}
