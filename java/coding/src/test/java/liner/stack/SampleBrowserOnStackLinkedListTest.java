package liner.stack;

import org.junit.Test;

/**
 * Created on 2020-05-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SampleBrowserOnStackLinkedListTest {
    SampleBrowserOnStackLinkedList browser = new SampleBrowserOnStackLinkedList("https://time.geekbang.org/");

    @Test
    public void test(){
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("open https://time.geekbang.org/dashboard/course");
        browser.open("https://time.geekbang.org/dashboard/course");
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("forward");
        browser.forward();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("back");
        browser.back();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("open https://time.geekbang.org/dashboard/course");
        browser.open("https://time.geekbang.org/dashboard/course");
        System.out.println("open https://time.geekbang.org/column/article/41222");
        browser.open("https://time.geekbang.org/column/article/41222");
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("forward");
        browser.forward();
        System.out.println("forward");
        browser.forward();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("open https://time.geekbang.org/column/article/131867");
        browser.open("https://time.geekbang.org/column/article/131867");
        System.out.println("open https://time.geekbang.org/column/article/161575");
        browser.open("https://time.geekbang.org/column/article/161575");
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("back");
        browser.back();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("back");
        browser.back();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("back");
        browser.back();
        System.out.println("back");
        browser.back();
        System.out.println("back");
        browser.back();
        System.out.println(browser.toString());
        System.out.println("===============================================\r\n");
        System.out.println("forward");
        browser.forward();
        System.out.println("forward");
        browser.forward();
        System.out.println("forward");
        browser.forward();
        System.out.println("forward");
        browser.forward();
        System.out.println("forward");
        browser.forward();
        System.out.println(browser.toString());
    }
}
