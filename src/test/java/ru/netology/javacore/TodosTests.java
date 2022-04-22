package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTests {

    // ваши тесты для класса Todos
    Todos todos = new Todos();
    final List<String> taskList = new ArrayList<>();
    final String task = "Готовка";

    public static int i = 1;

    @BeforeAll
    public static void started() {
        System.out.println("Test start");
    }

    @BeforeEach
    public void startMsg() {
        System.out.println("Test " + i + " start");
    }

    @AfterEach
    public void endMsg() {
        System.out.println("Test " + i + " end");
        i++;
    }

    @AfterAll
    public static void ended() {
        System.out.println("Test end");
    }

    @Test
    public void testAddTask() {
        //given
        taskList.add(task);

        //when
        todos.addTask(task);

        //then
        assertEquals(taskList.toString(), todos.listTasks.toString());
    }

    @Test
    public void testRemoveTask() {
        //when
        todos.addTask(task);
        todos.removeTask(task);

        //then
        assertTrue(todos.listTasks.isEmpty()); //проверка на то, что лист с заданиями пустой после удаления
    }

    @Test
    public void testGetAllTasks() {
        //given
        String expected = "Готовка Работа Учеба Хобби";

        //when
        todos.addTask(task);
        todos.addTask("Работа");
        todos.addTask("Хобби");
        todos.addTask("Учеба");

        //then
        assertEquals(todos.getAllTasks(), expected);

    }
}