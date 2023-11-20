import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StatsScreen implements ActionListener {
    User u;

    static JFrame frame = new JFrame("Statistics");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();

    JLabel lblTitle = new JLabel("Select a format");
    //JTable tblStats =new JTable();
    JButton btnIncDiff = new JButton("Increasing Difficulty");
    JButton btnRand = new JButton("Random");
    JButton btnTim = new JButton("Timed");
    JButton btnBack = new JButton("Back");


    public StatsScreen(User u) {
        this.u = u;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        
        panel.setSize(700, 500);
        panel.setLayout(layout);
        //panel.add(tblStats);
        panel.add(lblTitle);
        panel.add(btnRand);
        panel.add(btnTim);
        panel.add(btnIncDiff);
        panel.add(btnBack);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitle, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnIncDiff, 200, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, btnIncDiff, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnRand, 200, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, btnRand, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnTim, 200, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, btnTim, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, panel);

        //layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tblStats, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        //layout.putConstraint(SpringLayout.VERTICAL_CENTER, tblStats, 0, SpringLayout.VERTICAL_CENTER, panel);

        /*SpringLayout.Constraints tableConstraints = layout.getConstraints(tblStats);
        tableConstraints.setX(Spring.constant(10));
        tableConstraints.setY(Spring.constant(10));*/
        frame.add(panel);

        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnIncDiff.addActionListener(this);
        btnIncDiff.setActionCommand("incDiff");
        btnRand.addActionListener(this);
        btnRand.setActionCommand("rand");
        btnTim.addActionListener(this);
        btnTim.setActionCommand("timer");
        btnBack.addActionListener(this);
        btnBack.setActionCommand("back");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "incDiff":
                setupDataTable("incDiffResults.txt", false);
                break;
            case "rand":
                setupDataTable("randResults.txt",false);
                break;
            case "timer":
                setupDataTable("timerResults.txt",true);
                break;
            case "back":
                new MenuScreen(u);
                frame.dispose();
                break;
            default:
                break;
        }
    }

    public void setupDataTable(String pathname, boolean timed){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathname));
            String line;
            
            Map<String, List<Integer>> resultsByUserID = new HashMap<>();

            while ((line = reader.readLine()) != null) {
               
                String[] parts = line.split("[ ]");
                
                if (parts.length >= 3) {
                    String userID = parts[0] + " " + parts[2];
                    
                    int result = Integer.parseInt( parts[3]);
                    //String time;
                    //if(timed){
                      //  time = parts[4];
                    //}
                    List<Integer> userResults = resultsByUserID.get(userID);
                    if (userResults == null) {
                        userResults = new ArrayList<>();
                        resultsByUserID.put(userID, userResults);
                    }
                    userResults.add(result);
                }
            }
            String[][] data = new String[ resultsByUserID.entrySet().size()][];
            int counter = 0;
            for (Map.Entry<String, List<Integer>> entry : resultsByUserID.entrySet()) {
                String userID = entry.getKey();
                List<Integer> userResults = entry.getValue();
                System.out.println(userID);
                System.out.println(userResults);
                int[] results = new int[userResults.size()];
                for (int i = 0; i < results.length; i++) {
                    results[i] = userResults.get(i);
                }
                double mean = userStatistics.mean(results);
                double median = userStatistics.median(results);
                double standardDeviation = userStatistics.standardDeviation(results);
                String[] dataEntry = {userID, ""+mean,""+median,""+standardDeviation };
                data[counter]=dataEntry;
                counter++;
            }
            String[] columnNames = {"User ID/Name", "Mean", "Median", "Standard Deviation"};
            JTable tblStats = new JTable(data,columnNames);
            panel.add(tblStats);
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tblStats, 50, SpringLayout.HORIZONTAL_CENTER, panel);
            layout.putConstraint(SpringLayout.VERTICAL_CENTER, tblStats, 50, SpringLayout.VERTICAL_CENTER, panel);
            tblStats.repaint();
            tblStats.setVisible(true);
            tblStats.setFillsViewportHeight(true);
            JScrollPane sp = new JScrollPane(tblStats);
            panel.add(sp);
            //tblStats.setSize(100, 100);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
