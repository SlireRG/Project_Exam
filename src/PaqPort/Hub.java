package PaqPort;
public class Hub {

    //Attributes
    private int idHub;
    private final Container[][] storage = new Container[10][12];

    //Constructor
    public Hub(int idHub) {
        this.idHub = idHub;
    }

    //Setters&Getters
    public int getIdHub() {
        return idHub;
    }
    public Container[][] getStorage() {
        return this.storage;
    }

    //Tests
    public boolean isP1Full() {
        for (int j = 0; j < 10; j++) {
            if (storage[j][0] == null) {
                return false;
            }
        }
        return true;
    }
    public boolean isP2Full() {
        for (int j = 0; j < 10; j++) {
            if (storage[j][1] == null) {
                return false;
            }
        }
        return true;
    }
    public boolean isP3Full() {
        for (int i = 2; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if (storage[j][i] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    //Methods
    public void placeInP1(Container toStore){
        for (int j = 0; j < 10; j++) {
            if (storage[j][0] == null) {
                storage[j][0] = toStore;
                break;
            }
        }
    }
    public void placeInP2(Container toStore){
        for (int j = 0; j < 10; j++) {
            if (storage[j][1] == null) {
                storage[j][1] = toStore;
                break;
            }
        }
    }
    public void placeInP3(Container toStore){
        boolean stop = false;
        for (int i = 2; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if (storage[j][i] == null) {
                    storage[j][i] = toStore;
                    stop = true;
                    break;
                }
            }
            if(stop){break;}
        }
    }

    @Override
    public String toString() {
        StringBuilder Map = new StringBuilder("\nHub" + (idHub + 1) + ":");
        int cellWidth = 12;

        for (int i = 0; i < 10; i++) {
            Map.append("\n");
            for (int j = 0; j < 12; j++) {
                String cellContent;
                if (storage[i][j] == null) {
                    cellContent = "N";
                } else {
                    cellContent = Integer.toString(storage[i][j].getIdContainer());
                }

                int paddingSize = cellWidth - cellContent.length();
                int paddingLeft = paddingSize / 2;
                int paddingRight = paddingSize - paddingLeft;

                String formattedCell = String.format("|%" + (cellContent.length() + paddingLeft) + "s%" + paddingRight + "s", cellContent, "");
                Map.append(formattedCell);
                if (j == 11) {
                    Map.append("|");
                }
            }
        }
        Map.append("\n");
        return Map.toString();
    }
}
