package us.kevinchapman;

import ch.aplu.xboxcontroller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ulab
 * Date: 4/11/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class xboxControllerTest {

    public JFrame theFrame;
    public JPanel titlePanel;
    public JPanel thePanel;
    public JPanel checkboxPanel;

    public JLabel guiTitle;

    public JLabel controllerActionTitle;
    public JLabel rightStickDirTitle;
    public JLabel leftStickDirTitle;
    public JLabel rightStickMagTitle;
    public JLabel leftStickMagTitle;
    public JLabel rightTriggerTitle;
    public JLabel leftTriggerTitle;

    public JLabel controllerActionLabel;
    public JLabel rightStickDirLabel;
    public JLabel leftStickDirLabel;
    public JLabel rightStickMagLabel;
    public JLabel leftStickMagLabel;
    public JLabel rightTriggerLabel;
    public JLabel leftTriggerLabel;

    public ReadOnlyCheckBox buttonACB;
    public ReadOnlyCheckBox buttonBCB;
    public ReadOnlyCheckBox buttonXCB;
    public ReadOnlyCheckBox buttonYCB;
    public ReadOnlyCheckBox buttonLBCB;
    public ReadOnlyCheckBox buttonRBCB;
    public ReadOnlyCheckBox buttonLTCB;
    public ReadOnlyCheckBox buttonRTCB;
    public ReadOnlyCheckBox buttonStartCB;
    public ReadOnlyCheckBox buttonBackCB;
    public ReadOnlyCheckBox buttonDPadCB;

    public JLabel dPadDirLabel;

    boolean connected;

    public static void main(String args[]){
        setLookAndFeel();
        xboxControllerTest x = new xboxControllerTest();
    }

    public xboxControllerTest(){
        theFrame = new JFrame();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
        theFrame.setMinimumSize(new Dimension(400, 300));
        theFrame.setLayout(new BorderLayout());
        theFrame.setTitle("Xbox 360 Controller Test");
        createLabel();
        theFrame.pack();
        test();
    }

    public void createLabel(){
        titlePanel      = new JPanel(new BorderLayout());
        thePanel        = new JPanel(new GridLayout(6, 2));
        checkboxPanel   = new JPanel(new GridLayout(3, 4));

        guiTitle        = new JLabel("Xbox Controller Testing Platform", JLabel.CENTER);
        guiTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

        rightStickDirTitle      = new JLabel("Right Stick Direction:   ", JLabel.RIGHT);
        leftStickDirTitle       = new JLabel("Left Stick Direction:   ", JLabel.RIGHT);
        rightStickMagTitle      = new JLabel("Right Stick Magnitude:   ", JLabel.RIGHT);
        leftStickMagTitle       = new JLabel("Left Stick Magnitude:   ", JLabel.RIGHT);
        rightTriggerTitle       = new JLabel("Right Trigger:   ", JLabel.RIGHT);
        leftTriggerTitle        = new JLabel("Left Trigger:   ", JLabel.RIGHT);
        controllerActionTitle   = new JLabel("Other Button Actions:   ", JLabel.RIGHT);

        leftStickMagLabel       = new JLabel("", JLabel.LEFT);
        leftStickDirLabel       = new JLabel("", JLabel.LEFT);
        rightStickMagLabel      = new JLabel("", JLabel.LEFT);
        rightStickDirLabel      = new JLabel("", JLabel.LEFT);
        leftTriggerLabel        = new JLabel("", JLabel.LEFT);
        rightTriggerLabel       = new JLabel("", JLabel.LEFT);
        controllerActionLabel   = new JLabel("", JLabel.LEFT);

        buttonACB       = new ReadOnlyCheckBox("A");
        buttonBCB       = new ReadOnlyCheckBox("B");
        buttonXCB       = new ReadOnlyCheckBox("X");
        buttonYCB       = new ReadOnlyCheckBox("Y");
        buttonLBCB      = new ReadOnlyCheckBox("LB");
        buttonRBCB      = new ReadOnlyCheckBox("RB");
        buttonLTCB      = new ReadOnlyCheckBox("LT");
        buttonRTCB      = new ReadOnlyCheckBox("RT");
        buttonStartCB   = new ReadOnlyCheckBox("START");
        buttonBackCB    = new ReadOnlyCheckBox("BACK");
        buttonDPadCB    = new ReadOnlyCheckBox("D-Pad");
        dPadDirLabel    = new JLabel("D-Pad Direction: ", JLabel.LEFT);

        titlePanel.add(guiTitle, BorderLayout.CENTER);

        thePanel.add(leftStickDirTitle);
        thePanel.add(leftStickDirLabel);

        thePanel.add(leftStickMagTitle);
        thePanel.add(leftStickMagLabel);

        thePanel.add(rightStickDirTitle);
        thePanel.add(rightStickDirLabel);

        thePanel.add(rightStickMagTitle);
        thePanel.add(rightStickMagLabel);

        thePanel.add(leftTriggerTitle);
        thePanel.add(leftTriggerLabel);

        thePanel.add(rightTriggerTitle);
        thePanel.add(rightTriggerLabel);

        checkboxPanel.add(buttonACB);
        checkboxPanel.add(buttonBCB);
        checkboxPanel.add(buttonXCB);
        checkboxPanel.add(buttonYCB);
        checkboxPanel.add(buttonLBCB);
        checkboxPanel.add(buttonRBCB);
        checkboxPanel.add(buttonLTCB);
        checkboxPanel.add(buttonRTCB);
        checkboxPanel.add(buttonStartCB);
        checkboxPanel.add(buttonBackCB);
        checkboxPanel.add(buttonDPadCB);
        checkboxPanel.add(dPadDirLabel);

        thePanel.setVisible(true);
        theFrame.add(titlePanel, BorderLayout.NORTH);
        theFrame.add(thePanel, BorderLayout.CENTER);
        theFrame.add(checkboxPanel, BorderLayout.SOUTH);
        theFrame.pack();

    }

    public void test(){
        XboxController controller = new XboxController("C:\\Users\\ulab\\IdeaProjects\\xboxcontrollertest\\src\\xboxcontroller.dll", 1, 50, 50);

        if (!controller.isConnected()){
            System.out.println("*Connect a controller*");
            connected = false;
            while (!connected){
                if (controller.isConnected()){
                    System.out.println("*Controller Connected*");
                    connected = true;
                }
            }
        }
        else{
            System.out.println("*Controller Connected*");
        }

        controller.addXboxControllerListener(new XboxControllerAdapter(){
            public void isConnected(boolean b){
                connected = b;
            }

            public void leftTrigger(double value){
                leftTriggerLabel.setText(Double.toString(value));
            }

            public void rightTrigger(double value){
                rightTriggerLabel.setText(Double.toString(value));
            }

            public void leftThumbDirection(double direction){
                leftStickDirLabel.setText(Double.toString(direction));
            }

            public void rightThumbDirection(double direction){
                rightStickDirLabel.setText(Double.toString(direction));
            }

            public void leftThumbMagnitude(double magnitude){
                leftStickMagLabel.setText(Double.toString(magnitude));
            }

            public void rightThumbMagnitude(double magnitude){
                rightStickMagLabel.setText(Double.toString(magnitude));
            }

            public void buttonA(boolean pressed){
                if (pressed){
                    System.out.println("A Button has been pressed");
//                    controllerActionLabel.setText("A Button has been pressed");
                    buttonACB.setSelected(true);
                } else {
                    buttonACB.setSelected(false);
                }
            }

            public void buttonB(boolean pressed){
                if (pressed){
                    System.out.println("B Button has been pressed");
//                    controllerActionLabel.setText("B Button has been pressed");
                    buttonBCB.setSelected(true);
                } else {
                    buttonBCB.setSelected(false);
                }
            }

            public void buttonX(boolean pressed){
                if (pressed){
                    System.out.println("X Button has been pressed");
//                    controllerActionLabel.setText("X Button has been pressed");
                    buttonXCB.setSelected(true);
                } else {
                    buttonXCB.setSelected(false);
                }
            }

            public void buttonY(boolean pressed){
                if (pressed){
                    System.out.println("Y Button has been pressed");
//                    controllerActionLabel.setText("Y Button has been pressed");
                    buttonYCB.setSelected(true);
                } else {
                    buttonYCB.setSelected(false);
                }
            }

            public void back(boolean pressed){
                if (pressed){
                    System.out.println("BACK Button has been pressed");
//                    controllerActionLabel.setText("BACK Button has been pressed");
                    buttonBackCB.setSelected(true);
                } else {
                    buttonBackCB.setSelected(false);
                }
            }

            public void start(boolean pressed){
                if (pressed){
                    System.out.println("START Button has been pressed");
//                    controllerActionLabel.setText("START Button has been pressed");
                    buttonStartCB.setSelected(true);
                    guiTitle.setText("Hi Kevin!");
                } else {
                    buttonStartCB.setSelected(false);
                    guiTitle.setText("Xbox Controller Testing Platform");
                }
            }

            public void leftShoulder(boolean pressed){
                if (pressed){
                    System.out.println("LEFT SHOULDER Button has been pressed");
//                    controllerActionLabel.setText("LEFT SHOULDER Button has been pressed");
                    buttonLBCB.setSelected(true);
                } else {
                    buttonLBCB.setSelected(false);
                }
            }

            public void rightShoulder(boolean pressed){
                if (pressed){
                    System.out.println("RIGHT SHOULDER Button has been pressed");
//                    controllerActionLabel.setText("RIGHT SHOULDER Button has been pressed");
                    buttonRBCB.setSelected(true);
                } else {
                    buttonRBCB.setSelected(false);
                }
            }

            public void leftThumb(boolean pressed){
                if (pressed){
                    System.out.println("LEFT THUMB Button has been pressed");
//                    controllerActionLabel.setText("LEFT THUMB Button has been pressed");
                    buttonLTCB.setSelected(true);
                } else {
                    buttonLTCB.setSelected(false);
                }
            }

            public void rightThumb(boolean pressed){
                if (pressed){
                    System.out.println("RIGHT THUMB Button has been pressed");
//                    controllerActionLabel.setText("RIGHT THUMB Button has been pressed");
                    buttonRTCB.setSelected(true);
                } else {
                    buttonRTCB.setSelected(false);
                }
            }

            public void dpad(int direction, boolean pressed){
                if (pressed){
                    System.out.println("D-PAD direction " + direction + " has been pressed");
//                    controllerActionLabel.setText("D-PAD direction " + direction + " has been pressed");
                    buttonDPadCB.setSelected(true);
                    dPadDirLabel.setText("D-Pad Direction: " + direction);
                } else {
                    buttonDPadCB.setSelected(false);
                    dPadDirLabel.setText("D-Pad Direction: ");
                }
            }
        });



    }

    public static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            System.out.println("LAF: " + UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.out.println("Error setting native LAF:" + e.toString());
        }

    }
}
