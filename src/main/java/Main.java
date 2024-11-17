import java.util.ArrayList;
import java.util.List;

abstract class Car {
    private String model;
    private int year;
    private String transmission;
    private String color;
    private String manufacturer;
    private String fuelType;

    public Car(String model, int year, String transmission, String color, String manufacturer, String fuelType) {
        this.model = model;
        this.year = year;
        this.transmission = transmission;
        this.color = color;
        this.manufacturer = manufacturer;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getColor() {
        return color;
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }

    public String getFullInfo() {
        return String.format("Model: %s, Year: %d, Transmission: %s, Color: %s, Manufacturer: %s, Fuel Type: %s",
                model, year, transmission, color, manufacturer, fuelType);
    }
}

class Suzuki extends Car {
    public Suzuki(String model, int year, String transmission, String color, String fuelType) {
        super(model, year, transmission, color, "Suzuki", fuelType);
    }
}

class Toyota extends Car {
    public Toyota(String model, int year, String transmission, String color, String fuelType) {
        super(model, year, transmission, color, "Toyota", fuelType);
    }
}

class Ford extends Car {
    public Ford(String model, int year, String transmission, String color, String fuelType) {
        super(model, year, transmission, color, "Ford", fuelType);
    }
}

class BMW extends Car {
    public BMW(String model, int year, String transmission, String color, String fuelType) {
        super(model, year, transmission, color, "BMW", fuelType);
    }
}

class Honda extends Car {
    public Honda(String model, int year, String transmission, String color, String fuelType) {
        super(model, year, transmission, color, "Honda", fuelType);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Suzuki("SX4", 2007, "Automatic", "Green", "Petrol"));
        cars.add(new Toyota("Camry", 2015, "Automatic", "Red", "Petrol"));
        cars.add(new Ford("Focus", 2005, "Manual", "Blue", "Diesel"));
        cars.add(new BMW("X5", 2012, "Automatic", "Black", "Petrol"));
        cars.add(new Honda("Civic", 2003, "Manual", "White", "Petrol"));
        cars.add(new Suzuki("Vitara", 2020, "Automatic", "Green", "Diesel"));
        cars.add(new Toyota("Corolla", 2018, "Automatic", "Silver", "Petrol"));
        cars.add(new Ford("Mondeo", 2010, "Manual", "Blue", "Diesel"));
        cars.add(new BMW("3 Series", 2019, "Automatic", "Black", "Petrol"));
        cars.add(new Honda("Accord", 2006, "Manual", "Red", "Petrol"));

        printRecentCars(cars);
        changeGreenToRed(cars);
        printCarsByTransmission(cars, "Automatic");
    }

    public static void printRecentCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.getYear() > 2006) {
                System.out.println(car.getFullInfo());
            } else {
                System.out.println("Устаревший авто: " + car.getModel());
            }
        }
    }

    public static void changeGreenToRed(List<Car> cars) {
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase("Green")) {
                car.changeColor("Red");
            }
        }
    }

    public static void printCarsByTransmission(List<Car> cars, String transmission) {
        for (Car car : cars) {
            if (car.getTransmission().equalsIgnoreCase(transmission)) {
                System.out.println(car.getFullInfo());
            }
        }
    }
}

