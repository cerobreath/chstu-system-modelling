package stu.cn.ua.rgr4;

import process.Actor;
import process.DispatcherFinishException;
import process.QueueForTransactions;
import process.Store;
import rnd.Randomable;
import java.util.function.BooleanSupplier;

public class Loader extends Actor {
    private Store oreHeap;
    private QueueForTransactions<Dumper> queue;
    private double finishTime;
    private Randomable rnd;

    @Override
    protected void rule() throws DispatcherFinishException {
        BooleanSupplier isDumper = () -> queue.size() > 0;
        BooleanSupplier heapSize = () -> oreHeap.getSize() > 0;
        while (getDispatcher().getCurrentTime() <= finishTime) {
            waitForCondition(isDumper, "має бути самоскид");
            Dumper dumper = queue.removeFirst();
            while (!dumper.isFull()) {
                waitForCondition(heapSize, "має бути руда в купі");
                getDispatcher().printToProtocol(
                        getNameForProtocol() + " бере порцію руди");
                oreHeap.remove(1);
                holdForTime(rnd.next());
                dumper.addPortion();
                getDispatcher().printToProtocol(
                        getNameForProtocol() + " додає порцію руди до самоскида " +
                                dumper.getNameForProtocol());
            }
        }
    }

    public void setOreHeap(Store oreHeap) {
        this.oreHeap = oreHeap;
    }

    public void setQueue(QueueForTransactions<Dumper> queue) {
        this.queue = queue;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public void setRnd(Randomable rnd) {
        this.rnd = rnd;
    }
}