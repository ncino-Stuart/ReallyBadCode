package com.testing.myapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
class MainTest {


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        System.out.println("hello world");
        assertEquals("hello world" + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void main_ReadAndDisplayData_OutputsCorrectly() {
        Main.main(new String[0]);
        assertEquals(
"""
email : thisemail@fake.com
name : Joe Shmoe
phone : 555-555-5555
address : 1234 Fake St
city : Faketown
state : CA
zip : 90210
country : USA
dob : 01/01/1900
age : 95
""", outputStreamCaptor.toString()
        );
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}