package edu.mum.cs.cs525.project.framework.accounts;

public interface IRule {

    String getRuleType();
    void execute();
    boolean isMatch();
}
