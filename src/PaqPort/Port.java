package PaqPort;

public class Port {

    //Attributes
    private final Hub Hubs[] = new Hub[3];

    //Constructors
    public Port() {
        System.out.println("New Port Created");
        for (int i = 0; i < 3; i++) {
            Hubs[i] = new Hub(i);
        }
    }

    //Methods
    public String displayContainerData(int id) {
        boolean containerFound = false;
        for (int i = 0; i < 3; i++) {
            Container[][] storage = Hubs[i].getStorage();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 12; k++) {
                    if (storage[j][k] != null && storage[j][k].getIdContainer() == id) {
                        containerFound = true;
                        return ("The Container " + id + " is in port.\n" + storage[j][k].displayData());
                    }
                }
            }
        }
        if (!containerFound) {
            return "The Container " + id + " is not in this port.\n";
        }
        return "Impossible";
    }
    public void stackContainer(Container toStore) {
        switch (toStore.getPriorityLevel()) {
            case 1:
                boolean allP1Full = true;
                for (int i = 0; i < 3; i++) {
                    if (!Hubs[i].isP1Full()) {
                        allP1Full = false;
                        break;
                    }
                }
                if (allP1Full) {
                    System.out.println("The 3Hubs are full of containers on Priority 1.\nContainer not stored!");
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    if (Hubs[i].isP1Full() == false) {
                        Hubs[i].placeInP1(toStore);
                        break;
                    }
                }
                break;
            case 2:
                boolean allP2Full = true;
                for (int i = 0; i < 3; i++) {
                    if (!Hubs[i].isP2Full()) {
                        allP2Full = false;
                        break;
                    }
                }
                if (allP2Full) {
                    System.out.println("The 3Hubs are full of containers on Priority 2.\nContainer not stored!");
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    if (Hubs[i].isP2Full() == false) {
                        Hubs[i].placeInP2(toStore);
                        break;
                    }
                }
                break;
            case 3:
                boolean allP3Full = true;
                for (int i = 0; i < 3; i++) {
                    if (!Hubs[i].isP3Full()) {
                        allP3Full = false;
                        break;
                    }
                }
                if (allP3Full) {
                    System.out.println("The 3Hubs are full of containers on Priority 3.\nContainer not stored!");
                    return;
                }
                for (int i = 0; i < 3; i++) {
                    if (Hubs[i].isP3Full() == false) {
                        Hubs[i].placeInP3(toStore);
                        break;
                    }
                }
                break;
            default:
                System.out.println("Error Priority");
        }
    }
    public void removeContainer(int id) {

        boolean containerFound = false;
        for (int i = 0; i < 3; i++) {
            Container[][] storage = Hubs[i].getStorage();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 12; k++) {
                    if (storage[j][k] != null && storage[j][k].getIdContainer() == id) {
                        containerFound = true;
                        storage[j][k] = null;
                        break;
                    }
                }
                if (containerFound) {
                    break;
                }
            }
            if (containerFound) {
                break;
            }
        }
        if (!containerFound) {
            System.out.println("The Container " + id + " is not in this port.\n");
        } else {
            System.out.println("The Container " + id + " has been removed from the port.\n");
        }

    }
    public String toString() {
        StringBuilder Map = new StringBuilder("Port of Valencia: \n");
        for (int i = 0; i < 3; i++) {
            Map.append("\n" + Hubs[i].toString());
        }
        return Map.toString();
    }
}
