package edu.mum.cs.cs525.project.framework.uitoolkit;

import com.google.gson.*;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.*;
import edu.mum.cs.cs525.project.framework.uitoolkit.composite.*;

import java.lang.reflect.Type;

public class JsonParser implements JsonDeserializer<View> {


    @Override
    public View deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        View view = null;
        if (jsonElement.getAsJsonObject().has("type")){

            String elementType = jsonElement.getAsJsonObject().get("type").getAsString();

            switch (elementType) {
                case "JPanel" -> view = new Gson().fromJson(jsonElement, JPanelView.class);
                case "JButton" -> view = new Gson().fromJson(jsonElement, JButtonView.class);
                case "JScrollPanel" -> view = new Gson().fromJson(jsonElement, JScrollPanelView.class);
                case "JTable" -> view = new Gson().fromJson(jsonElement, JTableView.class);
                case "JLabel" -> view = new Gson().fromJson(jsonElement, JLabelView.class);
                case "JTextField" -> view = new Gson().fromJson(jsonElement, JTextFieldView.class);
                case "JRadioButton" -> view = new Gson().fromJson(jsonElement, JRadioButtonView.class);
            }

        }
        return view;
    }
}
