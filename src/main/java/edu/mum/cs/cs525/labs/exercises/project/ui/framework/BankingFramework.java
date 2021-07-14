package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.GuiForm;

import java.lang.reflect.InvocationTargetException;

public class BankingFramework {


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
}
