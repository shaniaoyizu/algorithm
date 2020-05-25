package liner.stack;

/**
 * Created on 2020-05-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SampleBrowserOnStackArray {
    /**
     * 当前页面
     */
    private String currentPage;
    /**
     * to store the history site
     */
    private StackBasedArray<String> backStack;
    /**
     *
     */
    private StackBasedArray<String> forwardStack;

    /**
     * the default constructor
     *
     * @param currentPage
     */
    public SampleBrowserOnStackArray(String currentPage) {
        this.currentPage = currentPage;
        backStack = new StackBasedArray<>();
        forwardStack = new StackBasedArray<>();
        backStack.push(currentPage);
    }

    /**
     * Gets the current page site
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

    /**
     * @return
     */
    public String toString() {
        return "currentPage：[" + currentPage + "]\r\n" +
                "back：" + backStack.toString() + "\r\n" +
                "forward：" + forwardStack.toString();
    }
}
