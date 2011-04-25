
package reporter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

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
public class ReporterConsole extends JFrame {

  private ReporterConsole console;
  private InfoPanel info;
  private JScrollPane scroll;
  private JButton clearButton;
  JViewport viewPort = new JViewport();

  public ReporterConsole() {
    setTitle("Reporter");
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setMinimumSize(new Dimension(250, 150));
  }

  public void initialize() {
    console = new ReporterConsole();
    console.setLayout(new BorderLayout());
    info = new InfoPanel();
    scroll = new JScrollPane(info);

    //Set the viewport for the scrollpane so the bars can update correctly
    viewPort.setView(info);
    scroll.setViewport(viewPort);
    console.add(scroll);

    clearButton = new JButton("Clear Output Window");
    clearButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            info.clearLog();
        }
    });

    console.add(clearButton,  BorderLayout.SOUTH);
    console.pack();
    console.setSize(new Dimension(500, 500));
    console.setVisible(true);
    }

  /**
   * Outputs a debug message to the screen
   * @param tag The tag for this item
   * @param message The message for this item
   */
  public void d(String tag, String message) {
    StackTraceElement[] callStack = new Throwable().getStackTrace();
    message += " - [" + callStack[1] + "]";
    LogItem item = new LogItem(tag, message, 1);
    info.appendToLogItems(item);
    viewPort.setView(info);
  }

  /**
   * Outputs an information message to the screen
   * @param tag The tag for this item
   * @param message The message for this item
   */
  public void i(String tag, String message) {
    StackTraceElement[] callStack = new Throwable().getStackTrace();
    message += " - [" + callStack[1] + "]";
    LogItem item = new LogItem(tag, message, 2);
    info.appendToLogItems(item);
    viewPort.setView(info);
  }

  /**
   * Outputs an error message to the screen
   * @param tag The tag for this item
   * @param message The message for this item
   */
  public void e(String tag, String message) {
    StackTraceElement[] callStack = new Throwable().getStackTrace();
    message += " - [" + callStack[1] + "]";
    LogItem item = new LogItem(tag, message, 3);
    info.appendToLogItems(item);
    viewPort.setView(info);
  }

  /**
   * Outputs a warning message to the screen
   * @param tag The tag for this item
   * @param message The message for this item
   */
  public void w(String tag, String message) {
    StackTraceElement[] callStack = new Throwable().getStackTrace();
    message += " - [" + callStack[1] + "]";
    LogItem item = new LogItem(tag, message, 4);
    info.appendToLogItems(item);
    viewPort.setView(info);
  }

  /**
   * Outputs a system message to the screen
   * @param tag
   * @param message
   */
  private void s(String tag, String message) {
    StackTraceElement[] callStack = new Throwable().getStackTrace();
    message += " - [" + callStack[1] + "]";
    LogItem item = new LogItem(tag, message, 5);
    info.appendToLogItems(item);
    viewPort.setView(info);
  }
}
