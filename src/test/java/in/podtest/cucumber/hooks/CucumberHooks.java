package in.podtest.cucumber.hooks;

import io.cucumber.java.*;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Global Before Hook Running!");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Global After Hook Running!");
    }

    @Before
    public static void before() {
        System.out.println("Scenario Before Hook Running!");
    }

    @After
    public static void after() {
        System.out.println("Scenario After Hook Running!");
    }

    @BeforeStep
    public static void beforeStep() {
        System.out.println("Step Before Hook Running");
    }

    @AfterStep
    public static void afterStep() {
        System.out.println("Step After Hook Running");
    }






}
