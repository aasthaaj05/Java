class HotelBooking {
    public void bookHotel() {
        System.out.println("Hotel booked.");
    }
}

class FlightBooking {
    public void bookFlight() {
        System.out.println("Flight booked.");
    }
}

class CarRental {
    public void rentCar() {
        System.out.println("Car rented.");
    }
}

class TravelBookingFacade {
    private HotelBooking hotelBooking;
    private FlightBooking flightBooking;
    private CarRental carRental;

    public TravelBookingFacade() {
        this.hotelBooking = new HotelBooking();
        this.flightBooking = new FlightBooking();
        this.carRental = new CarRental();
    }

    public void bookTravel() {
        hotelBooking.bookHotel();
        flightBooking.bookFlight();
        carRental.rentCar();
    }
}

public class Facade {
    public static void main(String[] args) {
        TravelBookingFacade facade = new TravelBookingFacade();
        facade.bookTravel();
    }
}