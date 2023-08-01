package DEV120_3_2_Tekiev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Fifteen {

    private JFrame frame;
    private JFrame frame2;
    private JFrame frame3;
    private ArrayList<ArrayList<JButton>> jButtons;
    private JPanel panel;
    public Fifteen() {
        frame = new JFrame();
    }
    public void init() {
        frame.setTitle("Fifteen");
        frame.setSize(500, 500);
        frame.add(getButtonsGroup(), BorderLayout.CENTER);
        frame.add(getReset(), BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public Container getButtonsGroup() {
        panel = new JPanel();
        GridLayout layout = new GridLayout(4, 4);
        panel.setLayout(layout);
        jButtons = new ArrayList<>() {{
            add(new ArrayList<JButton>() {{
                add(new JButton("3"));
                add(new JButton("7"));
                add(new JButton("10"));
                add(new JButton("15"));
            }});
            add(new ArrayList<JButton>() {{
                add(new JButton("14"));
                add(new JButton("1"));
                add(new JButton("6"));
                add(new JButton("12"));
            }});
            add(new ArrayList<JButton>() {{
                add(new JButton("9"));
                add(new JButton("4"));
                add(new JButton("2"));
                add(new JButton("13"));
            }});
            add(new ArrayList<JButton>() {{
                add(new JButton("5"));
                add(new JButton("11"));
                add(new JButton("8"));
                add(new JButton(""));
            }});
        }};
        Collections.shuffle(jButtons);
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(jButtons.get(i));
            for (JButton jButton : jButtons.get(i)) {
                jButton.setFont(new Font("FifteenButton", Font.PLAIN, 45));
                jButton.addActionListener(new Listener());
                panel.add(jButton);
            }
        }
        return panel;
    }
    private Container getReset() {
        JPanel panelResult = new JPanel();
        GridLayout layout = new GridLayout();
        panelResult.setLayout(layout);
        JButton result = new JButton("RESET");
        result.setFont(new Font("FifteenFontResult", Font.PLAIN, 40));
        result.addActionListener(new Listener());
        panelResult.add(result);
        return panelResult;
    }
    private void toConfirmation() {
        frame2 = new JFrame();
        frame2.setTitle("Fifteen");
        frame2.setSize(400, 90);
        frame2.add(getConfirmation());
        frame2.setVisible(true);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void toWin() {
        frame3 = new JFrame();
        frame3.setTitle("Fifteen");
        frame3.setSize(330, 100);
        JTextArea area = new JTextArea();
        area.setText("Вы выиграли!");
        area.setEditable(false);
        area.setFont(new Font("ConfirmationFontTextField", Font.PLAIN, 45));
        frame3.add(area);
        frame3.setVisible(true);
        frame3.setLocationRelativeTo(null);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    private Container getConfirmation() {

        JPanel panelConfirmation = new JPanel();
        JTextArea area = new JTextArea();
        area.setText("Вы уверены что хотите перемешь \nрасположение кнопок?");
        area.setEditable(false);
        area.setFont(new Font("ConfirmationFontTextField", Font.PLAIN, 15));
        JButton yes = new JButton("Да");
        yes.setFont(new Font("FifteenFontResult", Font.PLAIN, 20));
        yes.addActionListener(new Listener());
        JButton no = new JButton("Нет");
        no.setFont(new Font("FifteenFontResult", Font.PLAIN, 20));
        no.addActionListener(new Listener());
        panelConfirmation.add(area);
        panelConfirmation.add(yes);
        panelConfirmation.add(no);
        return panelConfirmation;
    }
    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            String s = e.getActionCommand();
            String[] str = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
            String[] strTest = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
            ArrayList<String> stringsTest = new ArrayList<>();
            Collections.addAll(stringsTest,strTest);
            ArrayList<String> strings = new ArrayList<>();
            for (String value : str) {
                if (s.equals(value)) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if ((jButtons.get(i)).get(j).getText().equals(s)) {
                                if (i != 0 && j != 0) {
                                    if (jButtons.get(i).get(j - 1).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i).get(j - 1).setText(s);
                                        return;
                                    }
                                    if (jButtons.get(i - 1).get(j).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i - 1).get(j).setText(s);
                                        return;
                                    }
                                }
                                if (i != 3 && j != 3) {
                                    if (jButtons.get(i).get(j + 1).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i).get(j + 1).setText(s);
                                        return;
                                    }
                                    if (jButtons.get(i + 1).get(j).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i + 1).get(j).setText(s);
                                        return;
                                    }
                                }
                                if (i != 0 && j != 3) {
                                    if (jButtons.get(i).get(j + 1).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i).get(j + 1).setText(s);
                                        return;
                                    }
                                    if (jButtons.get(i - 1).get(j).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i - 1).get(j).setText(s);
                                        return;
                                    }
                                }
                                if (i != 3 && j != 0) {
                                    if (jButtons.get(i + 1).get(j).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i + 1).get(j).setText(s);
                                        return;
                                    }
                                    if (jButtons.get(i).get(j - 1).getText().isEmpty()) {
                                        jButtons.get(i).get(j).setText("");
                                        jButtons.get(i).get(j - 1).setText(s);
                                        return;
                                    }
                                }
                                return;
                            }
                            strings.add(jButtons.get(i).get(j).getText());
                            if (strings.equals(stringsTest)) {
                                toWin();
                                return;
                            }
                        }
                    }
                }
            }
            if (s.equals("RESET")) {
                toConfirmation();
            }
            if (s.equals("Да")) {
                frame.remove(panel);
                frame.add(getButtonsGroup(), BorderLayout.CENTER);
                frame.setVisible(true);
                frame2.dispose();
            }
            if (s.equals("Нет")) {
                frame2.dispose();
            }
        }
    }
}
