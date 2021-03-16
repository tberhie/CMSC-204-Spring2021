
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
	
    BasicDoubleLinkedList<String> linkedString;
    BasicDoubleLinkedList<Double> linkedDouble;
    BasicDoubleLinkedList<Sal> linkedSalary;
    StringComparator comparator;
    DoubleComparator comparatorD;
    StuComparator comparatorSal;

    public Sal a=new Sal("Mack", "DIRECTOR", 12000);
    public Sal b=new Sal("Epha", "VICE", 10000);
    public Sal c=new Sal("Henok", "SECRETARY", 8000);
    public Sal d=new Sal("John", "STAFF", 5600);
    public Sal e=new Sal("Rob", "CASHIER", 2900);
    public Sal f=new Sal("Bob", "SECURITY", 2000);

    public ArrayList<Sal> fill = new ArrayList<Sal>();

    @Before
    public void setUp() throws Exception {
    	
        linkedString = new BasicDoubleLinkedList<String>();
        linkedString.addToEnd("Hello");
        linkedString.addToEnd("World");
        comparator = new StringComparator();

        linkedDouble = new BasicDoubleLinkedList<Double>();
        linkedDouble.addToEnd(11.0);
        linkedDouble.addToEnd(12.0);
        comparatorD = new DoubleComparator();

        linkedSalary = new BasicDoubleLinkedList<Sal>();
        linkedSalary.addToEnd(b);
        linkedSalary.addToEnd(c);
        comparatorSal = new StuComparator();
    }

    @After
    public void tearDown() throws Exception {
        linkedString = null;
        linkedDouble = null;
        linkedSalary = null;
        comparatorD = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(2,linkedString.getSize());
        assertEquals(2,linkedDouble.getSize());
        assertEquals(2, linkedSalary.getSize());
    }

    @Test
    public void testAddToEnd() {
        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("End");
        assertEquals("End", linkedString.getLast());

        assertEquals(c, linkedSalary.getLast());
        linkedSalary.addToEnd(d);
        assertEquals(d, linkedSalary.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("Begin");
        assertEquals("Begin", linkedString.getFirst());

        assertEquals(b, linkedSalary.getFirst());
        linkedSalary.addToFront(a);
        assertEquals(a, linkedSalary.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("New");
        assertEquals("New", linkedString.getFirst());

        assertEquals(b, linkedSalary.getFirst());
        linkedSalary.addToFront(a);
        assertEquals(a, linkedSalary.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("New");
        assertEquals("New", linkedString.getLast());

        assertEquals(c, linkedSalary.getLast());
        linkedSalary.addToEnd(d);
        assertEquals(d, linkedSalary.getLast());
    }

    @Test
    public void testToArrayList()
    {
        ArrayList<Sal> list;
        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        list = linkedSalary.toArrayList();
        assertEquals(a,list.get(0));
        assertEquals(b,list.get(1));
        assertEquals(c,list.get(2));
        assertEquals(d,list.get(3));
    }

    @Test
    public void testIteratorSuccessfulNext() {
        linkedString.addToFront("Begin");
        linkedString.addToEnd("End");
        ListIterator<String> iterator = linkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Begin", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals("End", iterator.next());

        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        ListIterator<Sal> iteratorCar = linkedSalary.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        ListIterator<Sal> iteratorCar = linkedSalary.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {
        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        ListIterator<Sal> iteratorCar = linkedSalary.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());

        try{
            //no more elements in list
            iteratorCar.next();
            assertTrue("Did not throw a NoSuchElementException",false);
        }
        catch (NoSuchElementException e)
        {
            assertTrue("Successfully threw a NoSuchElementException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        ListIterator<Sal> iteratorCar = linkedSalary.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(d, iteratorCar.next());
        assertEquals(true, iteratorCar.hasPrevious());
        assertEquals(d, iteratorCar.previous());
        assertEquals(c, iteratorCar.previous());
        assertEquals(b, iteratorCar.previous());
        assertEquals(a, iteratorCar.previous());

        try{
            //no more elements in list
            iteratorCar.previous();
            assertTrue("Did not throw a NoSuchElementException",false);
        }
        catch (NoSuchElementException e)
        {
            assertTrue("Successfully threw a NoSuchElementException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        linkedSalary.addToFront(a);
        linkedSalary.addToEnd(d);
        ListIterator<Sal> iteratorCar = linkedSalary.iterator();
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(a, iteratorCar.next());
        assertEquals(b, iteratorCar.next());
        assertEquals(c, iteratorCar.next());
        assertEquals(true, iteratorCar.hasNext());
        assertEquals(d, iteratorCar.next());

        try{
            //remove is not supported for the iterator
            iteratorCar.remove();
            assertTrue("Did not throw a UnsupportedOperationException",false);
        }
        catch (UnsupportedOperationException e)
        {
            assertTrue("Successfully threw a UnsupportedOperationException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }

    }

    @Test
    public void testRemove() {
        // remove the first
        assertEquals(b, linkedSalary.getFirst());
        assertEquals(c, linkedSalary.getLast());
        linkedSalary.addToFront(a);
        assertEquals(a, linkedSalary.getFirst());
        linkedSalary.remove(a, comparatorSal);
        assertEquals(b, linkedSalary.getFirst());
        //remove from the end of the list
        linkedSalary.addToEnd(d);
        assertEquals(d, linkedSalary.getLast());
        linkedSalary.remove(d, comparatorSal);
        assertEquals(c, linkedSalary.getLast());
        //remove from middle of list
        linkedSalary.addToFront(a);
        assertEquals(a, linkedSalary.getFirst());
        assertEquals(c, linkedSalary.getLast());
        linkedSalary.remove(b, comparatorSal);
        assertEquals(a, linkedSalary.getFirst());
        assertEquals(c, linkedSalary.getLast());

    }

    @Test
    public void testRetrieveFirstElement() {
        assertEquals(b, linkedSalary.getFirst());
        linkedSalary.addToFront(a);
        assertEquals(a, linkedSalary.getFirst());
        assertEquals(a, linkedSalary.retrieveFirstElement());
        assertEquals(b, linkedSalary.getFirst());
        assertEquals(b, linkedSalary.retrieveFirstElement());
        assertEquals(c, linkedSalary.getFirst());

        assertEquals("Hello", linkedString.getFirst());
        linkedString.addToFront("New");
        assertEquals("New", linkedString.getFirst());
        assertEquals("New", linkedString.retrieveFirstElement());
        assertEquals("Hello",linkedString.getFirst());
        assertEquals("Hello", linkedString.retrieveFirstElement());
        assertEquals("World",linkedString.getFirst());

    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals(c, linkedSalary.getLast());
        linkedSalary.addToEnd(d);
        assertEquals(d, linkedSalary.getLast());
        assertEquals(d, linkedSalary.retrieveLastElement());
        assertEquals(c, linkedSalary.getLast());

        assertEquals("World", linkedString.getLast());
        linkedString.addToEnd("New");
        assertEquals("New", linkedString.getLast());
        assertEquals("New", linkedString.retrieveLastElement());
        assertEquals("World",linkedString.getLast());
    }

    private class StringComparator implements Comparator<String>
    {

        @Override
        public int compare(String arg0, String arg1) {
            // TODO Auto-generated method stub
            return arg0.compareTo(arg1);
        }

    }

    private class DoubleComparator implements Comparator<Double>
    {

        @Override
        public int compare(Double arg0, Double arg1) {
            // TODO Auto-generated method stub
            return arg0.compareTo(arg1);
        }

    }

    private class StuComparator implements Comparator<Sal>
    {

        @Override
        public int compare(Sal arg0, Sal arg1) {
            // Just put cars in alphabetic order by make
            return arg0.toString().compareTo(arg1.toString());
        }

    }

    private class Sal {
        String name;
        String position;
        int salary;

        public Sal(String name, String major, int yearGrad){
            this.name = name;
            this.position = major;
            this.salary = yearGrad;
        }

        public String getName(){
            return name;
        }
        public String getMajor(){
            return position;
        }
        public int getYearGrad(){
            return salary;
        }

        public String toString() {
            return (getName()+" "+ getMajor()+" "+ getYearGrad());
        }
    }
}