package activities;

public class Activity1 {

    public static void main(String[] args) {
        Car CarName = new Car();
        CarName.make = 2014;
        CarName.color = "Black";
        CarName.transmission = "Manual";
        CarName.displayCharacterstics();
        CarName.accelerate();
        CarName.brake();
    }

}