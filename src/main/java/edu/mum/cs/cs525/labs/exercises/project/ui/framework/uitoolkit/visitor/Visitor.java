package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.*;

public interface Visitor {

    void visit(View view);
    void visit(JButtonView view);
    void visit(JPanelView view);
    void visit(JScrollPanelView view);
    void visit(JTableView view);
    void visit(JTextFieldView view);
    void visit(JLabelView view);

}
