package stu.cn.ua.rgr4;

import process.Actor;
import process.DispatcherFinishException;
import process.Store;
import rnd.Randomable;
import java.util.function.BooleanSupplier;

public class Crusher extends Actor {
    private Store bunker;
    private double finishTime;
    private Randomable rnd;

    @Override
    protected void rule() throws DispatcherFinishException {
        BooleanSupplier bunkerHasOre = () -> bunker.getSize() > 0;
        while (getDispatcher().getCurrentTime() <= finishTime) {
            waitForCondition(bunkerHasOre, "має бути руда в бункері");
            getDispatcher().printToProtocol(
                    getNameForProtocol() + " бере порцію руди");
            bunker.remove(1);
            holdForTime(rnd.next());
            getDispatcher().printToProtocol(
                    getNameForProtocol() + " завершив обробку порції");
        }
    }

    public void setBunker(Store bunker) {
        this.bunker = bunker;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }

    public void setRnd(Randomable rnd) {
        this.rnd = rnd;
    }
}