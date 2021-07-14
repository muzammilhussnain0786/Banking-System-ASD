
package edu.mum.cs.cs525.project.framework.uitoolkit.composite;


import com.google.gson.annotations.SerializedName;
import edu.mum.cs.cs525.project.framework.uitoolkit.visitor.Visitor;

import java.util.List;

@SuppressWarnings("unused")
public class JTableView extends View{

    @SerializedName("columns")
    private List<String> columns;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
