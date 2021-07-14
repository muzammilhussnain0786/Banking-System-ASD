package edu.mum.cs.cs525.project.home;

import edu.mum.cs.cs525.project.framework.uitoolkit.GuiForm;

import java.lang.reflect.InvocationTargetException;

public class Home {

    public static void run(Class<?> classGuiForm, String[] args) {
        try {
            Object uiInstance = Class.forName(classGuiForm.getName()).getDeclaredConstructor().newInstance();
            if (uiInstance instanceof GuiForm){
                ((GuiForm) uiInstance).start();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Home.run(HomeUI.class, args);
    }
}
