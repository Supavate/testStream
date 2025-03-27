package com.example.teststream;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestStreamApplicationTests {
    @Autowired
    private KafkaController controller;

    @BeforeAll
    public void m1() {
        System.out.println("Ex b4 all test");
    }

    @BeforeEach
    public void m2() {
        System.out.println("Ex b4 each test");
    }

    @AfterAll
    public void m3() {
        System.out.println("Ex After all test");
    }

    @AfterEach
    public void m4() {
        System.out.println("Ex After each test");
    }

    @Test
    public void controllerTest() {
        System.out.println("controller test 1");
        assertNotNull(controller, "Controller is null");
    }

    @Test
    public void bmiTest() {
        System.out.println("bmi test 1");
        assertEquals(controller.bmiCal(40, 1), controller.bmiCal(160, 2));
    }
}
