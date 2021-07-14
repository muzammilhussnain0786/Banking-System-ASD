package edu.mum.cs.cs525.project.framework.controller.command;

import edu.mum.cs.cs525.project.framework.controller.response.Response;

public abstract class AbstractCommand {
    public abstract Response execute();
}
