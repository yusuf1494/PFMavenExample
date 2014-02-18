/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yusuf.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;    
import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
/**
 *
 * @author YUSUF
 */
public class test {
    @Test
    public void helloWorld(){
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        String result = i.next()+" "+i.next();
        assertEquals("Hello World", result);
    }
    
    @Test
    public void withArguments(){
        Comparable c  = mock(Comparable.class); //arange
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1, c.compareTo("Test")); //assert
    }
    
    @Test
    public void withUnspecifiedArguments(){
        Comparable c = mock(Comparable.class);
        when(c.compareTo(5)).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
    }
    
    @Test(expected = IOException.class)
    public void outputSteramWriterIOException()throws IOException{
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        doThrow(new IOException()).when(mock).close();
        osw.close();
    }
    
    @Test
    public void outputStreamWriterClose()throws IOException{
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
        verify(mock).close();
    }
    
    @Test
    public void outputStreamWriterBufferAndForwards()throws IOException{
        OutputStream mock = mock(OutputStream.class);
    }
}
