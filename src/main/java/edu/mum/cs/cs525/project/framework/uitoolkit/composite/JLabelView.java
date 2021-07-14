
package edu.mum.cs.cs525.project.framework.uitoolkit.composite;


import edu.mum.cs.cs525.project.framework.uitoolkit.visitor.Visitor;

@SuppressWarnings("unused")
public class JLabelView extends View{

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

}
