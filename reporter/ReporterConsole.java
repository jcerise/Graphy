/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporter;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Jeremy Cerise
 * @version 4/20/11
 *
 * ReporterConsole is a simple debug output system that allows a developer to
 * quickly output debug, warning, or error information using tags and colors.
 * Each type of message has a color associated with it in the console to make it
 * easy to pick out just the information you need.
 */

//TODO comments!
public class ReporterConsole extends JFrame {

    private ReporterConsole console;
    private InfoPanel info;
    private JScrollPane scroll;

    public ReporterConsole() {
        setTitle("Reporter");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(250, 150));
    }

    public void initialize() {
        console = new ReporterConsole();
        info = new InfoPanel();
        scroll = new JScrollPane(info);
        console.add(scroll);
        console.setVisible(true);
    }

    public void d(String tag, String message) {
        StackTraceElement[] callStack = new Throwable().getStackTrace();
        message += " - [" + callStack[1]+"]";
        LogItem item = new LogItem(tag, message, 1);
        info.appendToLogItems(item);
        info.repaint();
    }

    public void i(String tag, String message){
        StackTraceElement[] callStack = new Throwable().getStackTrace();
        message += " - [" + callStack[1]+"]";
        LogItem item = new LogItem(tag, message, 2);
        info.appendToLogItems(item);
        info.repaint();
    }

    public void e(String tag, String message){
        StackTraceElement[] callStack = new Throwable().getStackTrace();
        message += " - [" + callStack[1]+"]";
        LogItem item = new LogItem(tag, message, 3);
        info.appendToLogItems(item);
        info.repaint();
    }

    public void w(String tag, String message){
        StackTraceElement[] callStack = new Throwable().getStackTrace();
        message += " - [" + callStack[1]+"]";
        LogItem item = new LogItem(tag, message, 4);
        info.appendToLogItems(item);
        info.repaint();
    }
}
