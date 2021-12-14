package com.xt.dp.observer.v9;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class Test {
    public static void main(String[] args) {
        Button b = new Button();
        b.add(new MyActionListener());
        b.add(new MyActionListener2());
        b.buttonPressed();
    }
}

class Button {
    private List<ActionListener> actionListeners = new ArrayList<>();
    public void add(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }
    public void buttonPressed () {
        ActionEvent actionEvent = new ActionEvent(System.currentTimeMillis(), this);
        for (int i = 0; i < actionListeners.size(); i++) {
            actionListeners.get(i).actionPerformed(actionEvent);
        }
    }
}

interface ActionListener {
    void actionPerformed(ActionEvent e);
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed!");
    }
}

class MyActionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 2!");
    }
}

class ActionEvent {
    private long when;
    private Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }
    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }

}
