package stu.cn.ua.rgr4;

import process.Actor;
import process.DispatcherFinishException;
import process.QueueForTransactions;
import process.Store;
import rnd.Randomable;
import java.util.function.BooleanSupplier;

public class Excavator extends Actor {
    private Store oreHeap;
    private QueueForTransactions<Dumper> queue;
    private double oreHeapMaxSize;
    private double finishTime;
    private Randomable rnd;

    @Override
    protected void rule() throws DispatcherFinishException {
        BooleanSupplier heapHalfSize = () -> oreHeap.getSize() <= oreHeapMaxSize / 2;
        while (getDispatcher().getCurrentTime() <= finishTime) {
            holdForTime(rnd.next());
            getDispatcher().printToProtocol(
                    "  " + getNameForProtocol() + " додає порцію руди.");
            oreHeap.add(1);
            if (oreHeap.getSize() >= oreHeapMaxSize) {
                waitForCondition(heapHalfSize, "поки купа зменшиться вдвічі");
            }
        }
    }

    public void setOreHeap(Store oreHeap) {
        this.oreHeap = oreHeap;
    }

    public void setQueue(QueueForTransactions<Dumper> queue) {
        this.queue = queue;
    }

    public void setOreHeapMaxSize(double oreHeapMaxSize) {
        this.oreHeapMaxSize = oreHeapMaxSize;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public void setRnd(Randomable rnd) {
        this.rnd = rnd;
    }
}