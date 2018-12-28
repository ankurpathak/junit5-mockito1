package com.github.ankurpathak;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unchecked")
public class MockitoThrowTest {

    @Mock
    private List<String> list;

    @Test
    public void testMockitoThrowMultipleFirstStyle1(){
        when(list.size()).thenThrow(RuntimeException.class).thenThrow(NumberFormatException.class);
        assertThrows(RuntimeException.class, list::size);
        assertThrows(NumberFormatException.class, list::size);
    }

    @Test
    public void testMockitoThrowMultipleSecondStyle1(){
        doThrow(RuntimeException.class).doThrow(NumberFormatException.class).when(list).size();
        assertThrows(RuntimeException.class, list::size);
        assertThrows(NumberFormatException.class, list::size);
    }

    @Test
    public void testMockitoThrowMultipleSecondStyle2(){
        doThrow(RuntimeException.class, NumberFormatException.class).when(list).size();
        assertThrows(RuntimeException.class, list::size);
        assertThrows(NumberFormatException.class, list::size);
    }



    @Test
    public void testMockitoThrowMultipleFirstStyle2(){
        when(list.size()).thenThrow(RuntimeException.class, NumberFormatException.class);
        assertThrows(RuntimeException.class, list::size);
        assertThrows(NumberFormatException.class, list::size);
        assertTrue(true);
    }

    @Test
    public void testMockitoArrayDefault(){
        Demo  demo = mock(Demo.class);
        assertNull(demo.getObjectArray());
    }
}
