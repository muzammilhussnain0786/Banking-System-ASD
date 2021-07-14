package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter.JButtonAdapter;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter.JPanelAdapter;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter.JScrollPanelAdapter;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter.JTableAdapter;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.*;

import javax.swing.*;

public class ViewsCollector implements Visitor{
    JComponent parent;

    public ViewsCollector() {
    }

    public ViewsCollector(JComponent parent) {
        this.parent = parent;
    }

    @Override
    public void visit(View view) {

    }

    @Override
    public void visit(JButtonView view) {
        parent.add(new JButtonAdapter(view));
    }

    @Override
    public void visit(JPanelView view) {
        JComponent jPanel = new JPanelAdapter(view);
        if (parent != null){
            parent.add(jPanel);
        }else{
            parent = jPanel;
        }
        view.getViews().forEach(childView -> childView.accept(new ViewsCollector(jPanel)));
    }

    @Override
    public void visit(JScrollPanelView view) {
        JScrollPanelAdapter jscrollPanel = new JScrollPanelAdapter(view);
        if (parent != null){
            parent.add(jscrollPanel);
        }else{
            parent = jscrollPanel;
        }
        view.getViews().forEach(jTableView -> jTableView.accept(new ViewsCollector(jscrollPanel.getViewport())));
    }

    @Override
    public void visit(JTableView view) {
        parent.add(new JTableAdapter(view));
    }

    public JComponent getParent() {
        return parent;
    }
}
