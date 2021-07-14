package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.adapter.*;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ViewsGeneratorVisitor implements Visitor{
    private Map<String, JComponent> viewsHashmap = new HashMap<>();
    JComponent parent;

    public ViewsGeneratorVisitor() {
    }

    public ViewsGeneratorVisitor(JComponent parent, Map<String, JComponent> viewsHashmap) {
        this.parent = parent;
        this.viewsHashmap = viewsHashmap;
    }

    public ViewsGeneratorVisitor(Map<String, JComponent> viewsHashmap) {
        this.viewsHashmap = viewsHashmap;
    }

    @Override
    public void visit(View view) {

    }

    @Override
    public void visit(JButtonView view) {
        JComponent button = new JButtonAdapter(view);
        parent.add(button);
        this.viewsHashmap.put(view.getId(), button);
    }

    @Override
    public void visit(JPanelView view) {
        JComponent jPanel = new JPanelAdapter(view);
        if (parent != null){
            parent.add(jPanel);
        }else{
            parent = jPanel;
        }
        this.viewsHashmap.put(view.getId(), jPanel);
        view.getViews().forEach(childView -> childView.accept(new ViewsGeneratorVisitor(jPanel, viewsHashmap)));

    }

    @Override
    public void visit(JScrollPanelView view) {
        JScrollPanelAdapter jscrollPanel = new JScrollPanelAdapter(view);
        if (parent != null){
            parent.add(jscrollPanel);
        }else{
            parent = jscrollPanel;
        }
        this.viewsHashmap.put(view.getId(), jscrollPanel);
        view.getViews().forEach(jTableView -> jTableView.accept(new ViewsGeneratorVisitor(jscrollPanel.getViewport(), viewsHashmap)));
    }

    @Override
    public void visit(JTableView view) {
        JTableAdapter table = new JTableAdapter(view);
        parent.add(table);
        this.viewsHashmap.put(view.getId(), table);
    }

    @Override
    public void visit(JTextFieldView view) {
        JTextFieldAdapter textField = new JTextFieldAdapter(view);
        parent.add(textField);
        this.viewsHashmap.put(view.getId(), textField);
    }

    @Override
    public void visit(JLabelView view) {
        JLabelAdapter label = new JLabelAdapter(view);
        parent.add(label);
        this.viewsHashmap.put(view.getId(), label);
    }

    public JComponent getParent() {
        return parent;
    }
}
