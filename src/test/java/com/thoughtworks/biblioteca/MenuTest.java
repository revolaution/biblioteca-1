package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        menu = new Menu(printStream, bufferedReader);
        menu.showMenu();
    }

    @Test
    public void shouldShowMenuOnStart(){
        verify(printStream).println(contains("Main Menu"));
    }

    @Test
    public void shouldShowListBooksOption(){
        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldAskForUserInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.getUserSelection();
        verify(bufferedReader).readLine();
    }
}