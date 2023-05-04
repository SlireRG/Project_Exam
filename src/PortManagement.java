import PaqPort.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Remi GUERIN

add a method that accepts as argument a weight in tons and a HUb number :
a) mark as checked in customs all the containers that have a weight less or equal to the one passed as argument inside that hub
b) return as a String information about all containers with weight less or equal to the last one as argument within that hub (only the container id, the sender company, the weight and the customs check status will be shown).
public class PortManagement extends JFrame {

    private JPanel mainPanel;
    private JLabel IDNumberLabel;
    private JTextField textFieldID;
    private JLabel countryLabel;
    private JTextField textFieldWeight;
    private JTextArea DescriptionTextArea;
    private JLabel sendingLabel;
    private JTextField sendingtextfield;
    private JTextField receivingtextfield;
    private JLabel receivingLabel;
    private JLabel priorityLabel;
    private JLabel customLabel;
    private JCheckBox checkBox1;
    private JLabel Descriptionlabel;
    private JLabel weightLabel;
    private JButton showContainerDescriptionButton;
    private JButton pileButton;
    private JButton unpileButton;
    private JLabel operationslabel;
    private JRadioButton a2RadioButton;
    private JRadioButton a1RadioButton;
    private JRadioButton a3RadioButton;
    private JButton ShowPort;
    private JTextField countryTextField;
    private JButton ClearBtn;
    private JTextArea textArea1;
    private JButton weightButton;
    private JButton hubButton;

    public PortManagement(Port port){

        setContentPane(mainPanel);
        setTitle("Port Management: Valencia");
        setSize(1000,500);
        setVisible(true);

        weightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int priority;
                if(a1RadioButton.isSelected()){priority=1;} else if (a2RadioButton.isSelected()) {priority=2;} else {priority=3;}
                Container Current = new Container(
                        Integer.valueOf(textFieldID.getText()),
                        Integer.valueOf(textFieldWeight.getText()),
                        countryTextField.getText(),
                        checkBox1.isSelected(),
                        priority,
                        DescriptionTextArea.getText(),
                        sendingtextfield.getText(),
                        receivingtextfield.getText()
                );
                port.stackContainer(Current);
            }
        });

        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.valueOf(textFieldID.getText());
                port.removeContainer(id);
            }
        });

        ClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldID.setText("");
                textFieldWeight.setText("");
                DescriptionTextArea.setText("");
                sendingtextfield.setText("");
                receivingtextfield.setText("");
                countryTextField.setText("");
                textArea1.setText("");
                checkBox1.setSelected(false);
            }
        });

        showContainerDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(port.displayContainerData(Integer.valueOf(textFieldID.getText())));
            }
        });

        ShowPort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(port.toString());
            }
        });
    }

    public static void main(String[] args) {
        Port Valencia = new Port();
        PortManagement ValenciaFrame = new PortManagement(Valencia);
    }
}
