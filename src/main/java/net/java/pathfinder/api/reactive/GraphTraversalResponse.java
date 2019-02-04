package net.java.pathfinder.api.reactive;

import java.io.Serializable;
import net.java.pathfinder.api.TransitPath;

public class GraphTraversalResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long id;
    private final String exceptionMessage;
    private final boolean completed;
    private final TransitPath transitPath;
    
    public GraphTraversalResponse(TransitPath transitPath, GraphTraversalRequest req, Throwable e, boolean completed) {
        this.id = req.getId();
        this.transitPath = transitPath;
        this.completed = completed;
        if (e != null) {
            this.exceptionMessage = e.getMessage() + "(caused by " + e.getClass() + ")";
        } else {
            this.exceptionMessage = null;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public Object getId() {
        return id;
    }

    public TransitPath getTransitPath() {
        return transitPath;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
    
}