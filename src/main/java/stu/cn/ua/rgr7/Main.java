/*
 * Created by JFormDesigner on Wed Feb 26 07:39:29 EET 2025
 */

package stu.cn.ua.rgr7;

import com.formdev.flatlaf.FlatDarculaLaf;
import net.miginfocom.swing.MigLayout;
import process.Dispatcher;
import process.IModelFactory;
import rnd.Negexp;
import rnd.Norm;
import widgets.ChooseData;
import widgets.ChooseRandom;
import widgets.Diagram;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import widgets.experiments.*;
import widgets.stat.*;
import widgets.trans.*;

/**
 * @author cerobreath
 */
public class Main extends JFrame {

    public Main() {
        initComponents();
        loadHtmlTask();
        statisticsManager.setFactory((d) -> new Model(d, this));
        experimentManager.setFactory((d) -> new Model(d, this));
        transProcessManager.setFactory((d) -> new Model(d, this));
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

    public JButton getDiagramStartbutton() {
        return diagramStartbutton;
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

    public ChooseData getChooseDataDumper() {
        return chooseDataDumper;
    }

    public ChooseData getChooseDataBunkerCapacity() {
        return chooseDataBunkerCapacity;
    }

    public ChooseData getChooseDataPortionOreDumpTruck() {
        return chooseDataPortionOreDumpTruck;
    }

    public ChooseData getChooseDataSimulationTime() {
        return chooseDataSimulationTime;
    }

    public Diagram getDiagramQueueDumpTrucksToExcavator() {
        return diagramQueueDumpTrucksToExcavator;
    }

    public Diagram getDiagramQueueToLoader() {
        return diagramQueueToLoader;
    }

    public Diagram getDiagramOrePileSize() {
        return diagramOrePileSize;
    }

    private void chooseDataOrePileSizeCaretUpdate(CaretEvent e) {
        if (testPanel.isShowing()) {
            try {
                String value = chooseDataOrePileSize.getText();
                diagramOrePileSize.setVerticalMaxText(value);
                System.out.println("Updated Ore Pile Size diagram with: " + value);
            } catch (Exception ex) {
                System.err.println("Error updating Ore Pile Size diagram: " + ex.getMessage());
            }
        }
    }

    private void chooseDataSimulationTimeCaretUpdate(CaretEvent e) {
        if (testPanel.isShowing()) {
            try {
                String simulationTime = chooseDataSimulationTime.getText();
                diagramQueueDumpTrucksToExcavator.setHorizontalMaxText(simulationTime);
                diagramQueueToLoader.setHorizontalMaxText(simulationTime);
                diagramOrePileSize.setHorizontalMaxText(simulationTime);
                diagramCrusherCondition.setHorizontalMaxText(simulationTime);
                System.out.println("Updated all diagrams' simulation time to: " + simulationTime);
            } catch (Exception ex) {
                System.err.println("Error updating simulation time for diagrams: " + ex.getMessage());
            }
        }
    }

    private void chooseDataPortionOreDumpTruckCaretUpdate(CaretEvent e) {
        if (testPanel.isShowing()) {
            try {
                String portionSize = chooseDataPortionOreDumpTruck.getText();
                diagramCrusherCondition.setVerticalMaxText(portionSize);
                System.out.println("Updated Crusher Condition diagram with: " + portionSize);
            } catch (Exception ex) {
                System.err.println("Error updating Crusher Condition diagram: " + ex.getMessage());
            }
        }
    }

    private void chooseDataDumperCaretUpdate(CaretEvent e) {
        if (testPanel.isShowing()) {
            try {
                String dumperCount = chooseDataDumper.getText();
                diagramQueueDumpTrucksToExcavator.setVerticalMaxText(dumperCount);
                System.out.println("Updated Queue of dump trucks diagram with: " + dumperCount);
            } catch (Exception ex) {
                System.err.println("Error updating Queue of dump trucks diagram: " + ex.getMessage());
            }
        }
    }

    private void tabbedPaneStateChanged(ChangeEvent e) {
        try {
            if (tabbedPane.getSelectedComponent() == testPanel) {
                chooseDataSimulationTime.setInt(500);
                String simulationTime = chooseDataSimulationTime.getText();
                diagramQueueDumpTrucksToExcavator.setHorizontalMaxText(simulationTime);
                diagramQueueToLoader.setHorizontalMaxText(simulationTime);
                diagramOrePileSize.setHorizontalMaxText(simulationTime);
                diagramCrusherCondition.setHorizontalMaxText(simulationTime);

                diagramQueueDumpTrucksToExcavator.setVerticalMaxText(chooseDataDumper.getText());
                diagramOrePileSize.setVerticalMaxText(chooseDataOrePileSize.getText());
                diagramCrusherCondition.setVerticalMaxText(chooseDataPortionOreDumpTruck.getText());
                diagramQueueToLoader.setVerticalMaxText(chooseDataBunkerCapacity.getText());

                System.out.println("Switched to Test tab: Simulation time set to 500");
            } else if (tabbedPane.getSelectedComponent() == statPanel || tabbedPane.getSelectedComponent() == regresPanel) {
                chooseDataSimulationTime.setInt(10000);
                System.out.println("Switched to Stat or Regres tab: Simulation time set to 10000");
            }
        } catch (Exception ex) {
            System.err.println("Error updating simulation time on tab change: " + ex.getMessage());
        }
    }

    public ChooseData getChooseDataOrePileSize() {
        return chooseDataOrePileSize;
    }

    public Diagram getDiagramCrusherCondition() {
        return diagramCrusherCondition;
    }

    public JCheckBox getConsoleLoggerCheckBox() {
        return consoleLoggerCheckBox;
    }

    private void startTest(ActionEvent e) {
        getDiagramQueueDumpTrucksToExcavator().clear();
        getDiagramQueueToLoader().clear();
        getDiagramOrePileSize().clear();
        getDiagramCrusherCondition().clear();

        Dispatcher dispatcher = new Dispatcher();
        IModelFactory factory = (d) -> new Model(d, this);
        Model model = (Model) factory.createModel(dispatcher);

        getDiagramStartbutton().setEnabled(false);
        dispatcher.addDispatcherFinishListener(() -> getDiagramStartbutton().setEnabled(true));

        model.initForTest();
        dispatcher.start();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane = new JSplitPane();
        leftSettingModelPanel = new JPanel();
        Title = new JLabel();
        chooseRandomExcavator = new ChooseRandom();
        chooseRandomCrusher = new ChooseRandom();
        chooseRandomLoader = new ChooseRandom();
        chooseDataDumper = new ChooseData();
        chooseDataBunkerCapacity = new ChooseData();
        chooseDataPortionOreDumpTruck = new ChooseData();
        chooseDataOrePileSize = new ChooseData();
        chooseDataSimulationTime = new ChooseData();
        tabbedPane = new JTabbedPane();
        taskScrollPanel = new JScrollPane();
        textHtmTask = new JTextPane();
        testPanel = new JPanel();
        diagramQueueDumpTrucksToExcavator = new Diagram();
        diagramQueueToLoader = new Diagram();
        diagramOrePileSize = new Diagram();
        diagramCrusherCondition = new Diagram();
        diagramInteractionPanel = new JPanel();
        consoleLoggerCheckBox = new JCheckBox();
        diagramStartbutton = new JButton();
        statPanel = new JPanel();
        statisticsManager = new StatisticsManager();
        regresPanel = new JPanel();
        experimentManager = new ExperimentManager();
        transientPanel = new JPanel();
        transProcessManager = new TransProcessManager();
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

                //---- chooseDataDumper ----
                chooseDataDumper.setBackground(new Color(0x3c3f41));
                chooseDataDumper.setTitle("Number of dumpers");
                chooseDataDumper.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Number of dumpers", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataDumper.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataDumper.setMinimumSize(new Dimension(50, 55));
                chooseDataDumper.addCaretListener(e -> chooseDataDumperCaretUpdate(e));
                chooseDataDumper.setInt(8);
                leftSettingModelPanel.add(chooseDataDumper, "cell 0 4,aligny center,growy 0");

                //---- chooseDataBunkerCapacity ----
                chooseDataBunkerCapacity.setBackground(new Color(0x3c3f41));
                chooseDataBunkerCapacity.setTitle("Bunker capacity");
                chooseDataBunkerCapacity.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Bunker capacity", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataBunkerCapacity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataBunkerCapacity.setMinimumSize(new Dimension(50, 55));
                chooseDataBunkerCapacity.setInt(50);
                leftSettingModelPanel.add(chooseDataBunkerCapacity, "cell 0 5,aligny center,growy 0");

                //---- chooseDataPortionOreDumpTruck ----
                chooseDataPortionOreDumpTruck.setBackground(new Color(0x3c3f41));
                chooseDataPortionOreDumpTruck.setTitle("Portion of ore in a dump truck");
                chooseDataPortionOreDumpTruck.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Portion of ore in a dump truck", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataPortionOreDumpTruck.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataPortionOreDumpTruck.setMinimumSize(new Dimension(50, 55));
                chooseDataPortionOreDumpTruck.addCaretListener(e -> chooseDataPortionOreDumpTruckCaretUpdate(e));
                chooseDataPortionOreDumpTruck.setInt(6);
                leftSettingModelPanel.add(chooseDataPortionOreDumpTruck, "cell 0 6,aligny center,growy 0");

                //---- chooseDataOrePileSize ----
                chooseDataOrePileSize.setBackground(new Color(0x3c3f41));
                chooseDataOrePileSize.setTitle("Ore pile size");
                chooseDataOrePileSize.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ore pile size", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataOrePileSize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataOrePileSize.setMinimumSize(new Dimension(50, 55));
                chooseDataOrePileSize.addCaretListener(e -> chooseDataOrePileSizeCaretUpdate(e));
                chooseDataOrePileSize.setInt(3);
                leftSettingModelPanel.add(chooseDataOrePileSize, "cell 0 7,aligny center,growy 0");

                //---- chooseDataSimulationTime ----
                chooseDataSimulationTime.setBackground(new Color(0x3c3f41));
                chooseDataSimulationTime.setTitle("Simulation time");
                chooseDataSimulationTime.setBorder(new CompoundBorder(
                    new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Simulation time", TitledBorder.CENTER, TitledBorder.BELOW_TOP,
                        new Font("Dialog", Font.PLAIN, 14)),
                    new BevelBorder(BevelBorder.LOWERED)));
                chooseDataSimulationTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                chooseDataSimulationTime.setMinimumSize(new Dimension(50, 55));
                chooseDataSimulationTime.addCaretListener(e -> chooseDataSimulationTimeCaretUpdate(e));
                chooseDataSimulationTime.setInt(500);
                leftSettingModelPanel.add(chooseDataSimulationTime, "cell 0 8,aligny center,growy 0");
            }
            splitPane.setLeftComponent(leftSettingModelPanel);

            //======== tabbedPane ========
            {
                tabbedPane.addChangeListener(e -> tabbedPaneStateChanged(e));

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
                        "[]" +
                        "[]" +
                        "[]"));

                    //---- diagramQueueDumpTrucksToExcavator ----
                    diagramQueueDumpTrucksToExcavator.setTitleText("Queue of dump trucks to the excavator");
                    diagramQueueDumpTrucksToExcavator.setPanelBackground(new Color(0x575959));
                    diagramQueueDumpTrucksToExcavator.setGridColor(new Color(0x999999));
                    diagramQueueDumpTrucksToExcavator.setPainterColor(new Color(0xcc0000));
                    diagramQueueDumpTrucksToExcavator.setGridByX(10);
                    testPanel.add(diagramQueueDumpTrucksToExcavator, "cell 0 0,grow");

                    //---- diagramQueueToLoader ----
                    diagramQueueToLoader.setTitleText("Queue to the loader");
                    diagramQueueToLoader.setPanelBackground(new Color(0x575959));
                    diagramQueueToLoader.setGridColor(new Color(0x999999));
                    diagramQueueToLoader.setPainterColor(new Color(0xcc0000));
                    diagramQueueToLoader.setGridByX(10);
                    testPanel.add(diagramQueueToLoader, "cell 0 1,grow");

                    //---- diagramOrePileSize ----
                    diagramOrePileSize.setTitleText("Ore pile size");
                    diagramOrePileSize.setPanelBackground(new Color(0x575959));
                    diagramOrePileSize.setGridColor(new Color(0x999999));
                    diagramOrePileSize.setPainterColor(new Color(0xcc0000));
                    diagramOrePileSize.setGridByX(10);
                    testPanel.add(diagramOrePileSize, "cell 0 2,grow");

                    //---- diagramCrusherCondition ----
                    diagramCrusherCondition.setTitleText("Crusher condition");
                    diagramCrusherCondition.setPanelBackground(new Color(0x575959));
                    diagramCrusherCondition.setGridColor(new Color(0x999999));
                    diagramCrusherCondition.setPainterColor(new Color(0xcc0000));
                    diagramCrusherCondition.setGridByX(10);
                    testPanel.add(diagramCrusherCondition, "cell 0 3,grow");

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
                        diagramStartbutton.addActionListener(e -> startTest(e));
                        diagramInteractionPanel.add(diagramStartbutton, BorderLayout.EAST);
                    }
                    testPanel.add(diagramInteractionPanel, "cell 0 4");
                }
                tabbedPane.addTab("Test", testPanel);

                //======== statPanel ========
                {
                    statPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[646,grow,fill]",
                        // rows
                        "[grow]rel"));

                    //---- statisticsManager ----
                    statisticsManager.setBorder(LineBorder.createBlackLineBorder());
                    statPanel.add(statisticsManager, "cell 0 0,grow");
                }
                tabbedPane.addTab("Stat", statPanel);

                //======== regresPanel ========
                {
                    regresPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[646,grow,fill]",
                        // rows
                        "[grow]rel"));

                    //---- experimentManager ----
                    experimentManager.getChooseDataRepeat().setTitle("Number of dump trucks");
                    regresPanel.add(experimentManager, "cell 0 0,grow");
                }
                tabbedPane.addTab("Regres", regresPanel);

                //======== transientPanel ========
                {
                    transientPanel.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[646,grow,fill]",
                        // rows
                        "[grow]rel"));
                    transientPanel.add(transProcessManager, "cell 0 0,grow");
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
        setSize(960, 865);
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
    private ChooseData chooseDataDumper;
    private ChooseData chooseDataBunkerCapacity;
    private ChooseData chooseDataPortionOreDumpTruck;
    private ChooseData chooseDataOrePileSize;
    private ChooseData chooseDataSimulationTime;
    private JTabbedPane tabbedPane;
    private JScrollPane taskScrollPanel;
    private JTextPane textHtmTask;
    private JPanel testPanel;
    private Diagram diagramQueueDumpTrucksToExcavator;
    private Diagram diagramQueueToLoader;
    private Diagram diagramOrePileSize;
    private Diagram diagramCrusherCondition;
    private JPanel diagramInteractionPanel;
    private JCheckBox consoleLoggerCheckBox;
    private JButton diagramStartbutton;
    private JPanel statPanel;
    private StatisticsManager statisticsManager;
    private JPanel regresPanel;
    private ExperimentManager experimentManager;
    private JPanel transientPanel;
    private TransProcessManager transProcessManager;
    private JPanel infoPanel;
    private JPanel photoPanel;
    private JTextArea textInfoAuthor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}