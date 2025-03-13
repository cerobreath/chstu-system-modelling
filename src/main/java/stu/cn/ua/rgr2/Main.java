/*
 * Created by JFormDesigner on Wed Feb 26 07:39:29 EET 2025
 */

package stu.cn.ua.rgr2;

import com.formdev.flatlaf.FlatDarculaLaf;
import net.miginfocom.swing.MigLayout;
import rnd.Negexp;
import rnd.Norm;
import widgets.*;
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

    public ChooseRandom getChooseRandomExcavator() {
        return chooseRandomExcavator;
    }

    public ChooseRandom getChooseRandomCrusher() {
        return chooseRandomCrusher;
    }

    public ChooseRandom getChooseRandomLoader() {
        return chooseRandomLoader;
    }

    public ChooseData getChooseDataDumpTrucks() {
        return chooseDataDumpTrucks;
    }

    public ChooseData getChooseDataBunkerCapacity() {
        return chooseDataBunkerCapacity;
    }

    public ChooseData getChooseDataOreBatchSize() {
        return chooseDataOreBatchSize;
    }

    public ChooseData getChooseDataSimulationTime() {
        return chooseDataSimulationTime;
    }

    public Diagram getDiagramExcavatorLoad() {
        return diagramExcavatorLoad;
    }

    public Diagram getDiagramCrusherQueue() {
        return diagramCrusherQueue;
    }

    public Diagram getDiagramTransportTime() {
        return diagramTransportTime;
    }

    public JCheckBox getConsoleLoggerCheckBox() {
        return consoleLoggerCheckBox;
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
        chooseDataBunkerCapacity = new ChooseData();
        chooseDataOreBatchSize = new ChooseData();
        chooseDataSimulationTime = new ChooseData();
        tabbedPane = new JTabbedPane();
        taskScrollPanel = new JScrollPane();
        textHtmTask = new JTextPane();
        testPanel = new JPanel();
        diagramExcavatorLoad = new Diagram();
        diagramCrusherQueue = new Diagram();
        diagramTransportTime = new Diagram();
        diagramInteractionPanel = new JPanel();
        consoleLoggerCheckBox = new JCheckBox();
        diagramStartbutton = new JButton();
        statPanel = new JPanel();
        regresPanel = new JPanel();
        transientPanel = new JPanel();
        infoPanel = new JPanel();
        photoPanel = new JPanel();
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

                //---- chooseRandomExcavator ----
                chooseRandomExcavator.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Excavator productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                chooseRandomExcavator.setRandom(new Negexp(50));
                leftSettingModelPanel.add(chooseRandomExcavator, "cell 0 1,aligny center,growy 0");

                //---- chooseRandomCrusher ----
                chooseRandomCrusher.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Stone crusher productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                chooseRandomCrusher.setRandom(new Norm(45, 8));
                leftSettingModelPanel.add(chooseRandomCrusher, "cell 0 2,aligny center,growy 0");

                //---- chooseRandomLoader ----
                chooseRandomLoader.setBorder(new CompoundBorder(
                    new EtchedBorder(),
                    new TitledBorder(LineBorder.createBlackLineBorder(), "Loader productivity", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("Segoe UI", Font.PLAIN, 14), Color.lightGray)));
                chooseRandomLoader.setRandom(new Norm(30, 5));
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
                chooseDataDumpTrucks.setInt(5);
                leftSettingModelPanel.add(chooseDataDumpTrucks, "cell 0 4,aligny center,growy 0");

                //---- chooseDataBunkerCapacity ----
                chooseDataBunkerCapacity.setBackground(new Color(0x3c3f41));
                chooseDataBunkerCapacity.setTitle("Bunker capacity");
                chooseDataBunkerCapacity.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Bunker capacity", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataBunkerCapacity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataBunkerCapacity.setMinimumSize(new Dimension(50, 55));
                chooseDataBunkerCapacity.setInt(100);
                leftSettingModelPanel.add(chooseDataBunkerCapacity, "cell 0 5,aligny center,growy 0");

                //---- chooseDataOreBatchSize ----
                chooseDataOreBatchSize.setBackground(new Color(0x3c3f41));
                chooseDataOreBatchSize.setTitle("Maximum ore lot size");
                chooseDataOreBatchSize.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Maximum ore lot size", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataOreBatchSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataOreBatchSize.setMinimumSize(new Dimension(50, 55));
                chooseDataOreBatchSize.setInt(60);
                leftSettingModelPanel.add(chooseDataOreBatchSize, "cell 0 6,aligny center,growy 0");

                //---- chooseDataSimulationTime ----
                chooseDataSimulationTime.setBackground(new Color(0x3c3f41));
                chooseDataSimulationTime.setTitle("Simulation time");
                chooseDataSimulationTime.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Simulation time", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataSimulationTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataSimulationTime.setMinimumSize(new Dimension(50, 55));
                chooseDataSimulationTime.setInt(50);
                leftSettingModelPanel.add(chooseDataSimulationTime, "cell 0 7,aligny center,growy 0");
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
                        "[646,grow,fill]",
                        // rows
                        "[grow]" +
                        "[grow]rel" +
                        "[grow]" +
                        "[]"));

                    //---- diagramExcavatorLoad ----
                    diagramExcavatorLoad.setTitleText("Excavator loading");
                    diagramExcavatorLoad.setPanelBackground(new Color(0xe0e0ff));
                    diagramExcavatorLoad.setAlignmentX(1.5F);
                    testPanel.add(diagramExcavatorLoad, "cell 0 0,grow");

                    //---- diagramCrusherQueue ----
                    diagramCrusherQueue.setTitleText("Queue in front of a stone crusher");
                    diagramCrusherQueue.setPanelBackground(new Color(0xe0e0ff));
                    testPanel.add(diagramCrusherQueue, "cell 0 1,grow");

                    //---- diagramTransportTime ----
                    diagramTransportTime.setTitleText("Ore transportation time");
                    diagramTransportTime.setPanelBackground(new Color(0xe0e0ff));
                    testPanel.add(diagramTransportTime, "cell 0 2,grow");

                    //======== diagramInteractionPanel ========
                    {
                        diagramInteractionPanel.setLayout(new BorderLayout());

                        //---- consoleLoggerCheckBox ----
                        consoleLoggerCheckBox.setText("Console logger");
                        consoleLoggerCheckBox.setPreferredSize(new Dimension(200, 20));
                        consoleLoggerCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        diagramInteractionPanel.add(consoleLoggerCheckBox, BorderLayout.WEST);

                        //---- diagramStartbutton ----
                        diagramStartbutton.setText("Start");
                        diagramStartbutton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        diagramInteractionPanel.add(diagramStartbutton, BorderLayout.EAST);
                    }
                    testPanel.add(diagramInteractionPanel, "cell 0 3");
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
                        "[649,grow,fill]",
                        // rows
                        "[319,grow]" +
                        "[108]"));

                    //======== photoPanel ========
                    {
                        photoPanel = createPhotoPanel();
                        photoPanel.setPreferredSize(new Dimension(1500, 1500));
                        photoPanel.setMinimumSize(new Dimension(1500, 1500));
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

                    //---- textInfoAuthor ----
                    photoPanel.setPreferredSize(new Dimension(1500, 1500));
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
        setSize(900, 690);
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
    private ChooseRandom chooseRandomExcavator;
    private ChooseRandom chooseRandomCrusher;
    private ChooseRandom chooseRandomLoader;
    private ChooseData chooseDataDumpTrucks;
    private ChooseData chooseDataBunkerCapacity;
    private ChooseData chooseDataOreBatchSize;
    private ChooseData chooseDataSimulationTime;
    private JTabbedPane tabbedPane;
    private JScrollPane taskScrollPanel;
    private JTextPane textHtmTask;
    private JPanel testPanel;
    private Diagram diagramExcavatorLoad;
    private Diagram diagramCrusherQueue;
    private Diagram diagramTransportTime;
    private JPanel diagramInteractionPanel;
    private JCheckBox consoleLoggerCheckBox;
    private JButton diagramStartbutton;
    private JPanel statPanel;
    private JPanel regresPanel;
    private JPanel transientPanel;
    private JPanel infoPanel;
    private JPanel photoPanel;
    private JTextArea textInfoAuthor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
