package edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.JPanelView;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.composite.View;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.uitoolkit.visitor.ViewsCollector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class GuiForm extends JFrame {

    Long id = new Random().nextLong();
    String json = "";

    JPanelView viewComposite;

    JPanel jPanel;

    Map<String, View> viewsHashmap = new HashMap<>();


    public GuiForm() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setVisible(false);

        this.addWindowListener(new SystemWindowEvent());

        try {
            json = loadJsonFile();
        } catch (IOException | URISyntaxException exception) {
            exception.printStackTrace();
            exitApplication();
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(View.class, new JsonParser());
        Gson gson = gsonBuilder.create();
        viewComposite = gson.fromJson(json, JPanelView.class);

        inflateViews();
    }

    public abstract String loadJsonFile() throws IOException, URISyntaxException;

    public abstract void createView();

    public void inflateViews(){
        ViewsCollector viewsCollector = new ViewsCollector();
        viewComposite.accept(viewsCollector);

        jPanel = (JPanel) viewsCollector.getParent();

        setTitle(viewComposite.getTitle());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(viewComposite.getWidth().intValue(),viewComposite.getHeight().intValue());
        setVisible(false);
        getContentPane().add(BorderLayout.CENTER, jPanel);
        jPanel.setBounds(0,0,viewComposite.getWidth().intValue(),viewComposite.getHeight().intValue());
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        onSetSize(width, height);
    }

    protected abstract void onSetSize(int width, int height);

    protected void exitApplication(){
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }


    private class SystemWindowEvent extends java.awt.event.WindowAdapter {
        public void windowClosing(WindowEvent event)
        {
            Object object = event.getSource();
            if (object instanceof GuiForm && ((GuiForm) object).id.equals(id)){
                exitApplication();
            }

        }
    }

}
