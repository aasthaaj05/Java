interface TrafficLightState {
    void handle();
}

class RedLight implements TrafficLightState {
    public void handle() {
        System.out.println("Red Light - Stop!");
    }
}

class YellowLight implements TrafficLightState {
    public void handle() {
        System.out.println("Yellow Light - Slow Down!");
    }
}

class GreenLight implements TrafficLightState {
    public void handle() {
        System.out.println("Green Light - Go!");
    }
}

class TrafficLight {
    private TrafficLightState state;

    void setState(TrafficLightState state) {
        this.state = state;
    }

    void change() {
        state.handle();
    }
}

public class StateP{
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.setState(new RedLight());
        trafficLight.change();

        trafficLight.setState(new YellowLight());
        trafficLight.change();

        trafficLight.setState(new GreenLight());
        trafficLight.change();
    }
}
