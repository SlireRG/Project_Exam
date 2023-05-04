package PaqPort;
import java.util.Random;

public class Container {

    //Attributes
    private int idContainer;
    private int weight;
    private String countryOfOrigin;
    private boolean inspected;
    private int priorityLevel;
    private String content;
    private String sendingCompany;
    private String receivingCompany;

    //Constructors
    public Container(int idContainer, int weight, String countryOfOrigin, boolean inspected, int priorityLevel, String content, String sendingCompany, String receivingCompany) {
        this.idContainer = idContainer;
        this.weight = weight;
        this.countryOfOrigin = countryOfOrigin;
        this.inspected = inspected;
        this.priorityLevel = priorityLevel;
        this.content = content;
        this.sendingCompany = sendingCompany;
        this.receivingCompany = receivingCompany;
    }

    //Setters and Getters
    public int getIdContainer() {
        return idContainer;
    }
    public int getPriorityLevel() {
        return priorityLevel;
    }

    //Methods
    public String displayData(){
        String display = new String("Container " + idContainer + "\nData: " + " Weight: " + weight + " " + " Origin: " + countryOfOrigin  + " " + " Inspected: " + inspected + " " + " Priority: " + priorityLevel + " " + " Sending Company: " + sendingCompany + " " + " Destination Company: " + receivingCompany + " " + " Content: " + content + " ");
        return display;
    }

    //Testing
    public static Container[] generateContainers(int number){
        Random random = new Random();
        Container[] Rand = new Container[number];
        for(int i=0; i<number; i++){
            Rand[i] = new Container(((i+1) + random.nextInt((i+1)*10 - i+1)),(50 + random.nextInt(10000 - 50)), "", random.nextBoolean(), (1 + random.nextInt(4 - 1)),"","","");
        }
        return Rand;
    }
}
