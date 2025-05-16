package stu.cn.ua.rgr6;

import process.Dispatcher;
import process.MultiActor;
import process.QueueForTransactions;
import process.Store;
import stat.DiscretHisto;
import stat.Histo;
import stat.IHisto;
import widgets.experiments.IExperimentable;
import widgets.stat.IStatisticsable;

import java.util.HashMap;
import java.util.Map;

public class Model implements IStatisticsable, IExperimentable {
    private Dispatcher dispatcher;
    private Main gui;

    private Excavator excavator;
    private Loader loader;
    private Dumper dumper;
    private MultiActor multiDumper;
    private Crusher crusher;

    private Store oreHeap;
    private Store bunker;

    private QueueForTransactions<Dumper> queueToExcavator;
    private QueueForTransactions<Dumper> queueToLoader;

    DiscretHisto histoQueueToExcavator = new DiscretHisto();
    DiscretHisto histoQueueToLoader = new DiscretHisto();
    Histo histoOreHeap = new Histo();
    Histo histoBunker = new Histo();
    Histo histoExcavatorWait = new Histo();
    Histo histoLoaderWait = new Histo();
    Histo histoCrusherWait = new Histo();
    Histo histoDumperWait = new Histo();
    Histo histoDumperServiceTime = new Histo();

    public Model(Dispatcher d, Main g) {
        if (d == null || g == null) {
            System.out.println("Не визначено диспетчера або GUI для Model");
            System.out.println("Подальша робота неможлива");
            System.exit(0);
        }
        dispatcher = d;
        gui = g;
        componentsToStartList();
    }

    private void componentsToStartList() {
        dispatcher.addStartingActor(getExcavator());
        dispatcher.addStartingActor(getLoader());
        dispatcher.addStartingActor(getMultiDumper());
        dispatcher.addStartingActor(getCrusher());
    }

    public void initForTest() {
        getOreHeap().setPainter(gui.getDiagramOrePileSize().getPainter());
        getQueueToExcavator().setPainter(gui.getDiagramQueueDumpTrucksToExcavator().getPainter());
        getQueueToLoader().setPainter(gui.getDiagramQueueToLoader().getPainter());
        getBunker().setPainter(gui.getDiagramCrusherCondition().getPainter());

        if (gui.getConsoleLoggerCheckBox().isSelected()) {
            dispatcher.setProtocolFileName("Console");
        } else {
            dispatcher.setProtocolFileName("");
        }
    }

    public Excavator getExcavator() {
        if (excavator == null) {
            excavator = new Excavator();
            excavator.setNameForProtocol("Excavator");
            excavator.setHistoForActorWaitingTime(histoExcavatorWait);
            excavator.setOreHeap(getOreHeap());
            excavator.setQueue(getQueueToExcavator());
            excavator.setOreHeapMaxSize(gui.getChooseDataOrePileSize().getDouble());
            excavator.setRnd(gui.getChooseRandomExcavator().getRandom());
            excavator.setFinishTime(gui.getChooseDataSimulationTime().getDouble());
        }
        return excavator;
    }

    public Loader getLoader() {
        if (loader == null) {
            loader = new Loader();
            loader.setNameForProtocol("Loader");
            loader.setHistoForActorWaitingTime(histoLoaderWait);
            loader.setOreHeap(getOreHeap());
            loader.setQueue(getQueueToLoader());
            loader.setRnd(gui.getChooseRandomLoader().getRandom());
            loader.setFinishTime(gui.getChooseDataSimulationTime().getDouble());
        }
        return loader;
    }

    public Dumper getDumper() {
        if (dumper == null) {
            dumper = new Dumper();
            dumper.setNameForProtocol("Dumper");
            dumper.setHistoForActorWaitingTime(histoDumperWait);
            dumper.setHistoForServiceTime(histoDumperServiceTime);
            dumper.setQueueToExcavator(getQueueToExcavator());
            dumper.setQueueToLoader(getQueueToLoader());
            dumper.setBunker(getBunker());
            dumper.setBodySize(gui.getChooseDataPortionOreDumpTruck().getInt());
            dumper.setRnd(gui.getChooseRandomLoader().getRandom());
            dumper.setFinishTime(gui.getChooseDataSimulationTime().getDouble());
        }
        return dumper;
    }

    public MultiActor getMultiDumper() {
        if (multiDumper == null) {
            multiDumper = new MultiActor();
            multiDumper.setNameForProtocol("MultiActor для самоскидів");
            multiDumper.setOriginal(getDumper());
            multiDumper.setNumberOfClones(gui.getChooseDataDumper().getInt());
        }
        return multiDumper;
    }

    public Crusher getCrusher() {
        if (crusher == null) {
            crusher = new Crusher();
            crusher.setNameForProtocol("Crusher");
            crusher.setHistoForActorWaitingTime(histoCrusherWait);
            crusher.setBunker(getBunker());
            crusher.setRnd(gui.getChooseRandomCrusher().getRandom());
            crusher.setFinishTime(gui.getChooseDataSimulationTime().getDouble());
        }
        return crusher;
    }

    public Store getOreHeap() {
        if (oreHeap == null) {
            oreHeap = new Store();
            oreHeap.setNameForProtocol("Ore Heap");
            oreHeap.setDispatcher(dispatcher);
            oreHeap.setHisto(histoOreHeap);
        }
        return oreHeap;
    }

    public Store getBunker() {
        if (bunker == null) {
            bunker = new Store();
            bunker.setNameForProtocol("Bunker");
            bunker.setDispatcher(dispatcher);
            bunker.setHisto(histoBunker);
        }
        return bunker;
    }

    public QueueForTransactions<Dumper> getQueueToExcavator() {
        if (queueToExcavator == null) {
            queueToExcavator = new QueueForTransactions<>("Queue to Excavator", dispatcher, histoQueueToExcavator);
            queueToExcavator.setNameForProtocol("Queue to Excavator");
        }
        return queueToExcavator;
    }

    public QueueForTransactions<Dumper> getQueueToLoader() {
        if (queueToLoader == null) {
            queueToLoader = new QueueForTransactions<>("Queue to Loader", dispatcher, histoQueueToLoader);
            queueToLoader.setNameForProtocol("Queue to Loader");
        }
        return queueToLoader;
    }

    @Override
    public void initForStatistics() {
        // Порожній, оскільки ініціалізація не потрібна
    }

    @Override
    public Map<String, IHisto> getStatistics() {
        Map<String, IHisto> map = new HashMap<>();
        map.put("Черга до екскаватора", histoQueueToExcavator);
        map.put("Черга до завантажувача", histoQueueToLoader);
        map.put("Розмір купи руди", histoOreHeap);
        map.put("Розмір бункера", histoBunker);
        map.put("Час очікування екскаватора", histoExcavatorWait);
        map.put("Час очікування завантажувача", histoLoaderWait);
        map.put("Час очікування дробарки", histoCrusherWait);
        map.put("Час очікування самоскидів", histoDumperWait);
        map.put("Час обслуговування самоскидів", histoDumperServiceTime);
        return map;
    }

    @Override
    public void initForExperiment(double factor) {
        multiDumper.setNumberOfClones((int) factor);
    }

    @Override
    public Map<String, Double> getResultOfExperiment() {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("Середня довжина черги до екскаватора", histoQueueToExcavator.getAverage());
        resultMap.put("Середня довжина черги до завантажувача", histoQueueToLoader.getAverage());
        resultMap.put("Середній час обслуговування самоскидів", histoDumperServiceTime.getAverage());
        return resultMap;
    }
}