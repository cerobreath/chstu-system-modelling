/*
 * Created by JFormDesigner on Wed Feb 26 07:39:29 EET 2025
 */

package stu.cn.ua.rgr;

import javax.swing.border.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import net.miginfocom.swing.MigLayout;
import stat.Histo;
import widgets.*;
import widgets.ChooseData;

import javax.swing.*;
import java.awt.*;

/**
 * @author cerobreath
 */
public class Main extends JFrame {
    private Histo histo;

    public Main() {
        initComponents();
        histo = new Histo();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane = new JSplitPane();
        leftSettingModelPanel = new JPanel();
        Title = new JLabel();
        chooseRandomExcavator = new ChooseRandom();
        chooseRandomCrusher = new ChooseRandom();
        chooseRandomLoader = new ChooseRandom();
        chooseDataDumpTrucks = new ChooseData();
        chooseDataTransportTime = new ChooseData();
        chooseDataUnloadTimeBunker = new ChooseData();
        chooseDataUnloadTimeSite = new ChooseData();
        tabbedPane = new JTabbedPane();
        taskScrollPanel = new JScrollPane();
        textHtmTask = new JTextPane();
        testPanel = new JPanel();
        statPanel = new JPanel();
        regresPanel = new JPanel();
        transientPanel = new JPanel();
        infoPanel = new JPanel();

        //======== this ========
        setTitle("Computational-graphical work. Denys Lysenok, KI-221");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== splitPane ========
        {

            //======== leftSettingModelPanel ========
            {
                leftSettingModelPanel.setLayout(new MigLayout(
                    "hidemode 3,aligny center",
                    // columns
                    "[262,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- Title ----
                Title.setText("Parameters of the system under study ");
                Title.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                leftSettingModelPanel.add(Title, "cell 0 0,alignx center,growx 0");

                //---- chooseRandomExcavator ----
                chooseRandomExcavator.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Excavator productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomExcavator, "cell 0 1,aligny center,growy 0");

                //---- chooseRandomCrusher ----
                chooseRandomCrusher.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Stone crusher productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomCrusher, "cell 0 2,aligny center,growy 0");

                //---- chooseRandomLoader ----
                chooseRandomLoader.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Forklift productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomLoader, "cell 0 3,aligny center,growy 0");

                //---- chooseDataDumpTrucks ----
                chooseDataDumpTrucks.setBackground(new Color(0x3c3f41));
                chooseDataDumpTrucks.setTitle("Number of dumpers");
                chooseDataDumpTrucks.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Number of dumpers", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataDumpTrucks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataDumpTrucks.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataDumpTrucks, "cell 0 4,aligny center,growy 0");

                //---- chooseDataTransportTime ----
                chooseDataTransportTime.setBackground(new Color(0x3c3f41));
                chooseDataTransportTime.setTitle("Ore transport time by dumper truck");
                chooseDataTransportTime.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore transport time by dumper truck", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataTransportTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataTransportTime.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataTransportTime, "cell 0 5,aligny center,growy 0");

                //---- chooseDataUnloadTimeBunker ----
                chooseDataUnloadTimeBunker.setBackground(new Color(0x3c3f41));
                chooseDataUnloadTimeBunker.setTitle("Ore unloading time in the hopper");
                chooseDataUnloadTimeBunker.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore unloading time in the hopper", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataUnloadTimeBunker.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataUnloadTimeBunker.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataUnloadTimeBunker, "cell 0 6,aligny center,growy 0");

                //---- chooseDataUnloadTimeSite ----
                chooseDataUnloadTimeSite.setBackground(new Color(0x3c3f41));
                chooseDataUnloadTimeSite.setTitle("Ore unloading time at the site");
                chooseDataUnloadTimeSite.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore unloading time at the site", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataUnloadTimeSite.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataUnloadTimeSite.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataUnloadTimeSite, "cell 0 7,aligny center,growy 0");
            }
            splitPane.setLeftComponent(leftSettingModelPanel);

            //======== tabbedPane ========
            {

                //======== taskScrollPanel ========
                {
                    taskScrollPanel.setViewportView(textHtmTask);
                }
                tabbedPane.addTab("Task", taskScrollPanel);

                //======== testPanel ========
                {
                    testPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));
                }
                tabbedPane.addTab("Test", testPanel);

                //======== statPanel ========
                {
                    statPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));
                }
                tabbedPane.addTab("Stat", statPanel);

                //======== regresPanel ========
                {
                    regresPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));
                }
                tabbedPane.addTab("Regres", regresPanel);

                //======== transientPanel ========
                {
                    transientPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));
                }
                tabbedPane.addTab("Transient", transientPanel);

                //======== infoPanel ========
                {
                    infoPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[fill]" +
                        "[fill]",
                        // rows
                        "[]" +
                        "[]" +
                        "[]"));
                }
                tabbedPane.addTab("Info", infoPanel);
            }
            splitPane.setRightComponent(tabbedPane);
        }
        contentPane.add(splitPane, BorderLayout.CENTER);
        setSize(900, 550);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane;
    private JPanel leftSettingModelPanel;
    private JLabel Title;
    private ChooseRandom chooseRandomExcavator;
    private ChooseRandom chooseRandomCrusher;
    private ChooseRandom chooseRandomLoader;
    private ChooseData chooseDataDumpTrucks;
    private ChooseData chooseDataTransportTime;
    private ChooseData chooseDataUnloadTimeBunker;
    private ChooseData chooseDataUnloadTimeSite;
    private JTabbedPane tabbedPane;
    private JScrollPane taskScrollPanel;
    private JTextPane textHtmTask;
    private JPanel testPanel;
    private JPanel statPanel;
    private JPanel regresPanel;
    private JPanel transientPanel;
    private JPanel infoPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
