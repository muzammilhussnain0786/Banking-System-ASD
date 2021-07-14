
package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite;


import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor.Visitor;

@SuppressWarnings("unused")
public class JButtonView extends View{

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

}
