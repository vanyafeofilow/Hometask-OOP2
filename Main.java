public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false; // Кот создается голодным
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            fullness = true;
        }
    }

    public boolean isFull() {
        return fullness;
    }
}

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        } else {
            System.out.println("Not enough food in the plate");
        }
    }

    public void addFood(int amount) {
        food += amount;
    }

    public int getFood() {
        return food;
    }
}
public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 5), new Cat("Murzik", 7)};
        Plate plate = new Plate(15);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println("Cat " + cat.getName() + " is full: " + cat.isFull());
        }

        plate.info();
        plate.addFood(10); // Добавляем еду в тарелку
        plate.info();
    }
}
