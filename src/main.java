import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Room> rooms = new ArrayList<>();
        CentralUnit centralUnit = new CentralUnit(rooms);

        //Instansiera objekt av klassen Room
        Room pool = new Room("POOL");
        //Här skapas en ny instans av Motiondetector och lägger till den i Pool.
        pool.addMotionDetector(new MotionDetector("Poolområdet", true, true));
        centralUnit.addRoom(pool);

        Room garage = new Room("GARAGE");
        garage.addDoorDetector(new DoorDetector("Garaget", true, true));
        garage.addWindowSensor(new WindowSensor("Garaget", true, true));
        garage.addSprinklerSystem(new SprinklerSystem("Garaget", true, true));
        garage.addSmokeDetector(new SmokeDetector("Garaget", true, true));
        centralUnit.addRoom(garage);

        Room hall = new Room("HALL");
        hall.addDoorDetector(new DoorDetector("Hallen", true, true));
        hall.addWindowSensor(new WindowSensor("Hallen",true, true));
        hall.addMotionDetector(new MotionDetector("Hallen", true, true));
        hall.addSprinklerSystem(new SprinklerSystem("Hallen", true, true));
        hall.addSmokeDetector(new SmokeDetector("Hallen", true, true));
        centralUnit.addRoom(hall);

        Room livingroom = new Room("VARDAGSRUM");
        livingroom.addDoorDetector(new DoorDetector("Vardagsrummet", true, true));
        livingroom.addWindowSensor(new WindowSensor("Vardagsrummet", true, true));
        livingroom.addWindowSensor(new WindowSensor("Vardagsrummet", true, true));
        livingroom.addMotionDetector(new MotionDetector("Vardagsrummet", true, true));
        livingroom.addSprinklerSystem(new SprinklerSystem("Vardagsrummet", true, true));
        livingroom.addSmokeDetector(new SmokeDetector("Vardagsrummet", true, true));
        centralUnit.addRoom(livingroom);

        Room kitchen = new Room("KÖK");
        kitchen.addWindowSensor(new WindowSensor("Köks fönstret", true, true));
        kitchen.addSprinklerSystem(new SprinklerSystem("Köket", true, true));
        kitchen.addSmokeDetector(new SmokeDetector("Köket",true, true));
        centralUnit.addRoom(kitchen);

        Room bedroom1 = new Room("SOVRUM 1");
        bedroom1.addDoorDetector(new DoorDetector("Sovrum 1, dörr", true, true));
        bedroom1.addWindowSensor(new WindowSensor("Sovrum 1, fönster 1", true, true));
        bedroom1.addWindowSensor(new WindowSensor("Sovrum 1, fönster 2", true, true));
        bedroom1.addSprinklerSystem(new SprinklerSystem("Sovrum 1", true, true));
        bedroom1.addSmokeDetector(new SmokeDetector("Sovrum 1", true, true));
        centralUnit.addRoom(bedroom1);

        Room bedroom2 = new Room("SOVRUM 2");
        bedroom2.addDoorDetector(new DoorDetector("Sovrum 2, dörr", true, true));
        bedroom2.addWindowSensor(new WindowSensor("Sovrum 2, fönster", true, true));
        bedroom2.addSprinklerSystem(new SprinklerSystem("Sovrum 2", true, true));
        bedroom2.addSmokeDetector(new SmokeDetector("Sovrum 2", true, true));
        centralUnit.addRoom(bedroom2);


        Room bedroom3 = new Room("SOVRUM 3");
        bedroom3.addDoorDetector(new DoorDetector("Sovrum 3, dörr", true, true));
        bedroom3.addWindowSensor(new WindowSensor("Sovrum 3", true, true));
        bedroom3.addSprinklerSystem(new SprinklerSystem("Sovrum 3", true, true));
        bedroom3.addSmokeDetector(new SmokeDetector("Sovrum 3", true, true));
        centralUnit.addRoom(bedroom3);

        Room bedroom4 = new Room("SOVRUM 4");
        bedroom4.addDoorDetector(new DoorDetector("Sovrum 4, dörr", true, true));
        bedroom4.addWindowSensor(new WindowSensor("Sovrum 4, fönster 1", true, true));
        bedroom4.addWindowSensor(new WindowSensor("Sovrum 4, fönster 2", true, true));
        bedroom4.addSprinklerSystem(new SprinklerSystem("Sovrum 4", true, true));
        bedroom4.addSmokeDetector(new SmokeDetector("Sovrum 4", true, true));
        centralUnit.addRoom(bedroom4);

        Room bedroom5 = new Room("SOVRUM 5");
        bedroom5.addDoorDetector(new DoorDetector("Sovrum 5, dörr", true, true));
        bedroom5.addWindowSensor(new WindowSensor("Sovrum 5", true, true));
        bedroom5.addSprinklerSystem(new SprinklerSystem("Sovrum 5", true, true));
        bedroom5.addSmokeDetector(new SmokeDetector("Sovrum 5", true, true));
        centralUnit.addRoom(bedroom5);

//MENY
        while (true) { //Oändlig loop, den kommer köras så länge man går ut ur loopen.
            System.out.println("----------------------------------");
            System.out.println("#VÄLKOMMEN TILL LARMSYSTEMET#");
            System.out.println("Väl ett av alternativen");
            System.out.println("1: Aktivera larmsystemet");
            System.out.println("2: Avaktivera larmsystemet");
            System.out.println("3: Simulera händelse");
            System.out.println("4: Visa inkopplade enheter");
            System.out.println("5: Återställ larmsystemet");
            System.out.println("6: Avsluta programmet");
            System.out.println("----------------------------------");
            int val = scanner.nextInt(); // Väntar på användarens inmatning.
            System.out.println("----------------------------------");

            switch (val) {
                case 1:
                    centralUnit.activateSystem();
                    break;
                case 2:
                    centralUnit.deactivateSystem();
                    break;
                case 3:
                    centralUnit.simulateEvent();
                    break;
                case 4:
                    centralUnit.showConnectedDevices();
                    break;
                case 5:
                    centralUnit.resetSystem();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen");
                    scanner.close();
            }
        }
    }
}


