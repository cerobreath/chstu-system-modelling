package stu.cn.ua.rgr5;

import process.Actor;
import process.DispatcherFinishException;
import process.QueueForTransactions;
import process.Store;
import rnd.Randomable;
import stat.Histo;

import java.util.function.BooleanSupplier;

public class Dumper extends Actor {
    private QueueForTransactions<Dumper> queueToExcavator;
    private QueueForTransactions<Dumper> queueToLoader;
    private Store bunker;
    private double finishTime;
    private int bodySize;
    private Randomable rnd;
    private int bodyLoad;
    private Histo histoServiceTime;
    private double serviceStartTime;

    @Override
    protected void rule() throws DispatcherFinishException {
        BooleanSupplier isBodyFull = () -> isFull();
        while (getDispatcher().getCurrentTime() <= finishTime) {
            serviceStartTime = getDispatcher().getCurrentTime();
            holdForTime(rnd.next());
            queueToExcavator.addLast(this);
            queueToLoader.addLast(this);
            waitForCondition(isBodyFull, "кузов має бути повним");
            getDispatcher().printToProtocol(
                    getNameForProtocol() + " їде до бункера");
            holdForTime(rnd.next());
            getDispatcher().printToProtocol(
                    getNameForProtocol() + " розвантажується");
            bunker.add(bodyLoad);
            double serviceTime = getDispatcher().getCurrentTime() - serviceStartTime;
            histoServiceTime.add(serviceTime);
            bodyLoad = 0;
        }
    }

    public void addPortion() {
        bodyLoad++;
        getDispatcher().printToProtocol(
                getNameForProtocol() + "- у кузові стало " + bodyLoad);
    }

    public boolean isFull() {
        return bodyLoad >= bodySize;
    }

    public void setQueueToExcavator(QueueForTransactions<Dumper> queueToExcavator) {
        this.queueToExcavator = queueToExcavator;
    }

    public void setQueueToLoader(QueueForTransactions<Dumper> queueToLoader) {
        this.queueToLoader = queueToLoader;
    }

    public void setBunker(Store bunker) {
        this.bunker = bunker;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }

    public void setRnd(Randomable rnd) {
        this.rnd = rnd;
    }

    public void setHistoForServiceTime(Histo histo) {
        this.histoServiceTime = histo;
    }
}