package ru.sbt.bit.ood.patterns.cw2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompositeHandler implements EventHandler {
    private Collection<EventHandler> handlers = new ArrayList<>();
    @Override
    public void execute(HomeEvent event) {
        for (EventHandler handler: handlers
             ) {
            handler.execute(event);
        }
    }
    public void addEH(EventHandler handler){
        handlers.add(handler);
    }

    public void removeEH(EventHandler handler){
        handlers.remove(handler);
    }
}
