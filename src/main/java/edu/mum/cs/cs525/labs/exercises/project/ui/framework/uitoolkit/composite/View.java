
package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite;


import com.google.gson.annotations.SerializedName;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor.Visitor;

@SuppressWarnings("unused")
public abstract class View {

    @SerializedName("height")
    private Long mHeight;
    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("width")
    private Long mWidth;
    @SerializedName("x")
    private Long mX;
    @SerializedName("y")
    private Long mY;


    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

    public Long getX() {
        return mX;
    }

    public void setX(Long x) {
        mX = x;
    }

    public Long getY() {
        return mY;
    }

    public void setY(Long y) {
        mY = y;
    }

    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
