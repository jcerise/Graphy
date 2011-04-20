
package reporter;

/**
 *
 * @author Jeremy Cerise
 * @version 4/20/11
 *
 * A LogItem is just that, an item logged by the developer to be output into the
 * ReporterConsole. It consists of a tag, a message, and a type.
 */
public class LogItem {

    private String tag;
    private String message;
    private int type;

    public LogItem(String tag, String message, int type){
        this.tag = tag;
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getTag() {
        return tag;
    }

    public int getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setType(int type) {
        this.type = type;
    }
}
