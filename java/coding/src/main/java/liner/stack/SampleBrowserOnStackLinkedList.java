package liner.stack;

/**
 * Created on 2020-05-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SampleBrowserOnStackLinkedList {
    /**
     * the current page
     */
    private String currentPage;
    /**
     * to store history sit
     */
    private StackBasedLinkedList<String> backStack;
    /**
     *
     */
    private StackBasedLinkedList<String> forwardStack;

    /**
     * the default construct
     */
    public SampleBrowserOnStackLinkedList(String currentPage) {
        this.currentPage = currentPage;
        backStack = new StackBasedLinkedList<>();
        forwardStack = new StackBasedLinkedList<>();
        backStack.push(currentPage);
    }

    /**
     * Gets the current page
     *
     * @return
     */
    public String getCurrentPage() {
        return currentPage;
    }

    /**
     * Opens a new page
     *
     * @param webSite
     */
    public void open(String webSite) {
        this.currentPage = webSite;
        backStack.push(webSite);
        forwardStack.clear();
    }

    /**
     * Goes back
     */
    public void back() {
        if (backStack.getSize() > 1) {
            forwardStack.push(backStack.pop());
        }
        this.currentPage = backStack.peek();
    }

    /**
     * Forwards
     */
    public void forward() {
        if (forwardStack.getSize() > 0) {
            this.currentPage = forwardStack.pop();
            backStack.push(this.currentPage);
        }
    }

    @Override
    public String toString() {
        return "currentPage：[" + currentPage + "]\r\n" +
                "back：" + backStack.toString() + "\r\n" +
                "forward：" + forwardStack.toString();
    }
}
