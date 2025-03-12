/*
 * Created by JFormDesigner on Wed Feb 26 07:39:29 EET 2025
 */

package stu.cn.ua.rgr2;

import com.formdev.flatlaf.FlatDarculaLaf;
import net.miginfocom.swing.MigLayout;
import rnd.Negexp;
import rnd.Norm;
import widgets.ChooseData;
import widgets.ChooseRandom;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @author cerobreath
 */
public class Main extends JFrame {

    public Main() {
        initComponents();
        loadHtmlTask();
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
        chooseRandomTransportTime = new ChooseRandom();
        chooseRandomUnloadTimeBunker = new ChooseRandom();
        chooseRandomUnloadTimeSite = new ChooseRandom();
        chooseDataDumpTrucks = new ChooseData();
        chooseDataExcavator = new ChooseData();
        chooseDataCrusher = new ChooseData();
        chooseDataLoader = new ChooseData();
        tabbedPane = new JTabbedPane();
        taskScrollPanel = new JScrollPane();
        textHtmTask = new JTextPane();
        testPanel = new JPanel();
        statPanel = new JPanel();
        regresPanel = new JPanel();
        transientPanel = new JPanel();
        infoPanel = new JPanel();
        photoPanel = createPhotoPanel();
        textInfoAuthor = new JTextArea();

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

                //---- chooseRandomTransportTime ----
                chooseRandomTransportTime.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Ore transport time by dumper truck", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomTransportTime, "cell 0 1,aligny center,growy 0");
                chooseRandomTransportTime.setRandom(new Negexp(15));

                //---- chooseRandomUnloadTimeBunker ----
                chooseRandomUnloadTimeBunker.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Ore unloading time in the hopper", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomUnloadTimeBunker, "cell 0 2,aligny center,growy 0");
                chooseRandomUnloadTimeBunker.setRandom(new Norm(5, 1));

                //---- chooseRandomUnloadTimeSite ----
                chooseRandomUnloadTimeSite.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Ore unloading time at the site", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                leftSettingModelPanel.add(chooseRandomUnloadTimeSite, "cell 0 3,aligny center,growy 0");
                chooseRandomUnloadTimeSite.setRandom(new Norm(7, 1));

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
                chooseDataDumpTrucks.setInt(5);

                //---- chooseDataExcavator ----
                chooseDataExcavator.setBackground(new Color(0x3c3f41));
                chooseDataExcavator.setTitle("Excavator productivity ");
                chooseDataExcavator.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore transport time by dumper truck", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataExcavator.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataExcavator.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataExcavator, "cell 0 5,aligny center,growy 0");
                chooseDataExcavator.setInt(50);

                //---- chooseDataCrusher ----
                chooseDataCrusher.setBackground(new Color(0x3c3f41));
                chooseDataCrusher.setTitle("Stone crusher productivity");
                chooseDataCrusher.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore unloading time in the hopper", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataCrusher.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataCrusher.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataCrusher, "cell 0 6,aligny center,growy 0");
                chooseDataCrusher.setInt(45);

                //---- chooseDataLoader ----
                chooseDataLoader.setBackground(new Color(0x3c3f41));
                chooseDataLoader.setTitle("Forklift productivity");
                chooseDataLoader.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore unloading time at the site", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataLoader.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataLoader.setMinimumSize(new Dimension(50, 55));
                leftSettingModelPanel.add(chooseDataLoader, "cell 0 7,aligny center,growy 0");
                chooseDataLoader.setInt(30);
            }
            splitPane.setLeftComponent(leftSettingModelPanel);

            //======== tabbedPane ========
            {

                //======== taskScrollPanel ========
                {

                    //---- textHtmTask ----
                    textHtmTask.setEditable(false);
                    textHtmTask.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
                    infoPanel.setMinimumSize(new Dimension(887, 135));
                    infoPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[649,fill]",
                        // rows
                        "[319]" +
                        "[108]"));

                    //======== photoPanel ========
                    {
                        photoPanel.setLayout(null);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < photoPanel.getComponentCount(); i++) {
                                Rectangle bounds = photoPanel.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = photoPanel.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            photoPanel.setMinimumSize(preferredSize);
                            photoPanel.setPreferredSize(preferredSize);
                        }
                    }
                    infoPanel.add(photoPanel, "cell 0 0");
                    photoPanel.setPreferredSize(new Dimension(1500, 1500));

                    //---- textInfoAuthor ----
                    textInfoAuthor.setText("Author of the project:\nLysenok Denys Vitaliiovych,\n3rd year student majoring in Computer Engineering\nEmail: cerobreath@gmail.com\nGitHub: cerobreath");
                    textInfoAuthor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    textInfoAuthor.setEditable(false);
                    infoPanel.add(textInfoAuthor, "cell 0 1");
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

    private void loadHtmlTask() {
        String str = "/tz.htm";
        URL url = getClass().getResource(str);
        if (url != null) {
            try {
                textHtmTask.setPage(url);
            } catch (IOException e) {
                System.err.println("Problems with file " + str);
            }
        } else {
            System.err.println("File not found: " + str);
        }
    }

    private JPanel createPhotoPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                BufferedImage img;
                URL url = getClass().getResource("/cerobreath.jpg");
                if (url != null) {
                    try {
                        img = ImageIO.read(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                    double k = (double) img.getHeight() / img.getWidth();
                    int width = getWidth();
                    int height = getHeight();
                    if ((double) height / width > k)
                        height = (int) (width * k);
                    else
                        width = (int) (height / k);
                    Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    g2d.drawImage(scaledImg, 0, 0, null);
                } else {
                    System.err.println("Image not found");
                }
            }
        };
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane;
    private JPanel leftSettingModelPanel;
    private JLabel Title;
    private ChooseRandom chooseRandomTransportTime;
    private ChooseRandom chooseRandomUnloadTimeBunker;
    private ChooseRandom chooseRandomUnloadTimeSite;
    private ChooseData chooseDataDumpTrucks;
    private ChooseData chooseDataExcavator;
    private ChooseData chooseDataCrusher;
    private ChooseData chooseDataLoader;
    private JTabbedPane tabbedPane;
    private JScrollPane taskScrollPanel;
    private JTextPane textHtmTask;
    private JPanel testPanel;
    private JPanel statPanel;
    private JPanel regresPanel;
    private JPanel transientPanel;
    private JPanel infoPanel;
    private JPanel photoPanel;
    private JTextArea textInfoAuthor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
