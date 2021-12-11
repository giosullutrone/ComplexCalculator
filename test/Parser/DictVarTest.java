package Parser;

import AlertMessage.OperationException;
import Complex.Complex;
import static org.junit.Assert.*;
import org.junit.Test;

public class DictVarTest {
    /**
     * Test of put method, of class DictVar.
     */
    @Test
    public void testPut() {
        DictVar instance;
        
        // Case: [a-z]
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        assertEquals(instance.get("a"), new Complex(10, 10));
        
        // Case: [aa-zz] -> OperationException
        instance = new DictVar();
        try {
            instance.put("aa", new Complex(10, 10));
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of get method, of class DictVar.
     */
    @Test
    public void testGet() {
        DictVar instance;
        
        // Case: [a-z]
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        assertEquals(instance.get("a"), new Complex(10, 10));
        
        // Case: [a-z] without insert -> OperationException
        instance = new DictVar();
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: [aa-zz] -> OperationException
        instance = new DictVar();
        try {
            instance.get("aa");
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of add method, of class DictVar.
     */
    @Test
    public void testAdd() {
        DictVar instance;
        
        // Case: [a-z] with insert before add
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        instance.add("a", new Complex(10, 10));
        assertEquals(instance.get("a"), new Complex(20, 20));
        
        // Case: [a-z] without insert -> OperationException
        instance = new DictVar();
        try {
            instance.add("a", new Complex(10, 10));
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: [aa-zz] -> OperationException
        instance = new DictVar();
        try {
            instance.add("aa", new Complex(10, 10));
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of sub method, of class DictVar.
     */
    @Test
    public void testSub() {
        DictVar instance;
        
        // Case: [a-z] with insert before add
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        instance.sub("a", new Complex(10, 10));
        assertEquals(instance.get("a"), new Complex(0, 0));
        
        // Case: [a-z] without insert -> OperationException
        instance = new DictVar();
        try {
            instance.sub("a", new Complex(10, 10));
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: [aa-zz] -> OperationException
        instance = new DictVar();
        try {
            instance.sub("aa", new Complex(10, 10));
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of delete method, of class DictVar.
     */
    @Test
    public void testDelete() {
        DictVar instance;
        
        // Case: [a-z] with insert before delete
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        instance.delete("a");
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: [a-z] without insert before delete
        instance = new DictVar();
        instance.delete("a");
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: [aa-zz]
        instance = new DictVar();
        try {
            instance.delete("aa");
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of deleteAll method, of class DictVar.
     */
    @Test
    public void testDeleteAll() {
        DictVar instance;
        
        // Case: with insert before deleteAll
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        instance.deleteAll();
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
        
        // Case: without insert before deleteAll
        instance = new DictVar();
        instance.deleteAll();
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
    }

    /**
     * Test of save and restore method, of class DictVar.
     */
    @Test
    public void testSaveRestore() {
        DictVar instance;
        
        // Case: with insert before deleteAll
        instance = new DictVar();
        instance.put("a", new Complex(10, 10));
        instance.save();
        instance.delete("a");
        try {
            instance.get("a");
            assertTrue(false);
        } catch(OperationException e) {}
        instance.restore();
        assertEquals(instance.get("a"), new Complex(10, 10));
    }
}