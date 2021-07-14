
package edu.mum.cs.cs525.project.framework.uitoolkit.composite;

import com.google.gson.annotations.SerializedName;
import edu.mum.cs.cs525.project.framework.uitoolkit.visitor.Visitor;

import java.util.List;

public class JPanelView extends View{

    @SerializedName("children")
    private List<View> children;

    public List<View> getViews() {
        return children;
    }

    public void setViews(List<View> mViews) {
        this.children = mViews;
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
