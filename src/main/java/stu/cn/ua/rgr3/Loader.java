package stu.cn.ua.rgr3;

import process.Actor;
import process.QueueForTransactions;
import rnd.RandomGenerators;

public class Loader extends Actor {
    @Override
    protected void rule() {
        // TODO: Implement rule for Loader
    }

    public void setQueue(QueueForTransactions<Dumper> queueToLoader) {
    }

    public void setRnd(RandomGenerators random) {

    }
}