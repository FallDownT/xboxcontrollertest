package us.kevinchapman;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ReadOnlyCheckBox extends JCheckBox {
    public ReadOnlyCheckBox (String text) {
        super(text,false);
        super.setFocusable(false);
    }

    protected void processKeyEvent(KeyEvent e) {
        // Do nothing
    }

    protected void processMouseEvent(MouseEvent e) {
        // Do nothing
    }
}