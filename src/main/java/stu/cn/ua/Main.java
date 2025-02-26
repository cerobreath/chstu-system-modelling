/*
 * Created by JFormDesigner on Wed Feb 26 07:39:29 EET 2025
 */

package stu.cn.ua;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;
import widgets.*;

/**
 * @author cerobreath
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        diagram = new Diagram();
        scrollPane = new JScrollPane();
        textArea = new JTextArea();
        chooseData = new ChooseData();
        button = new JButton();
        PearsonTesting = new JDialog();
        chooseRandom = new ChooseRandom();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setIconImage(null);
        setTitle("Laboratory work \u21161. Denys Lysenok, KI-221");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[224,fill]" +
                    "[289,fill]",
                    // rows
                    "[331]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[45]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[0]"));

                //---- diagram ----
                diagram.setTitleText("Histogram");
                diagram.setMinimumSize(new Dimension(347, 300));
                contentPanel.add(diagram, "cell 0 0,align center center,grow 0 0");

                //======== scrollPane ========
                {
                    scrollPane.setMinimumSize(new Dimension(18, 302));
                    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, Color.black));

                    //---- textArea ----
                    textArea.setMinimumSize(new Dimension(62, 100));
                    textArea.setEditable(false);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    scrollPane.setViewportView(textArea);
                }
                contentPanel.add(scrollPane, "cell 1 0,aligny top,grow 100 0");

                //---- chooseData ----
                chooseData.setBackground(new Color(0x2e3440));
                chooseData.setTitle("Sample size");
                chooseData.setMinimumSize(new Dimension(100, 50));
                contentPanel.add(chooseData, "cell 0 2 1 3");

                //---- button ----
                button.setText("Start");
                button.setFont(button.getFont().deriveFont(button.getFont().getSize() + 1f));
                button.setMinimumSize(new Dimension(20, 26));
                contentPanel.add(button, "cell 0 2 1 3,align center center,grow 0 0");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(630, 425);
        setLocationRelativeTo(getOwner());

        //======== PearsonTesting ========
        {
            PearsonTesting.setTitle("Testing according to Pearson's criterion");
            var PearsonTestingContentPane = PearsonTesting.getContentPane();
            PearsonTestingContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[316,fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));
            PearsonTestingContentPane.add(chooseRandom, "cell 0 0");

            //---- textArea1 ----
            textArea1.setMinimumSize(new Dimension(62, 100));
            textArea1.setEditable(false);
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
            textArea1.setPreferredSize(new Dimension(20, 20));
            PearsonTestingContentPane.add(textArea1, "cell 0 1");

            //---- button1 ----
            button1.setText("Test");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 1f));
            button1.setMinimumSize(new Dimension(20, 26));
            PearsonTestingContentPane.add(button1, "cell 0 2");
            PearsonTesting.pack();
            PearsonTesting.setLocationRelativeTo(PearsonTesting.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private Diagram diagram;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private ChooseData chooseData;
    private JButton button;
    private JDialog PearsonTesting;
    private ChooseRandom chooseRandom;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
