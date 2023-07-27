package zyforu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import zyforu.array.GenericArray;
import zyforu.linkedlist.LRUWithLinkedList;
import zyforu.linkedlist.SingleLinkedList;
import zyforu.linkedlist.gk.LRUBaseLinkedList;
import zyforu.stack.BrowserWithStack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void testJava() {
        ArrayList<String> strings = new ArrayList<>();
        Object object = strings;
        ArrayList<Integer> integers = (ArrayList<Integer>) object;
        integers.add(1);
        System.out.println(strings.get(0));

    }

    @Test
    public void testGenericArray() {
        GenericArray<Integer> array = new GenericArray<>();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        System.out.println(array);
        array.addLast(4);
        array.set(1,5);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        System.out.println(array);
        array.del(3);
        System.out.println(array);

    }

    @Test
    public void testSingelLinkedList() {
        SingleLinkedList link = new SingleLinkedList();
        System.out.println("hello");
        int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        //int data[] = {1,2,5,2,1};
        //int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertToTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }

    @Test
    public void testLRU() {
        LRUWithLinkedList<Integer> list = new LRUWithLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.offer(sc.nextInt());
            list.printAll();
        }
    }

    @Test
    public void testBrowser() {
        BrowserWithStack browser = new BrowserWithStack();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.show();

        browser.backPage();
        browser.show();

        browser.backPage();
        browser.show();

        browser.forward();
        browser.show();

        browser.open("http://www.qq.com");
        browser.show();

        browser.forward();
        browser.show();

        browser.backPage();
        browser.forward();
        browser.backPage();
        browser.backPage();
        browser.backPage();
        browser.backPage();
        browser.show();
    }

}

