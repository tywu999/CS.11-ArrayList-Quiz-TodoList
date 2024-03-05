import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

    private TodoList bobsList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        bobsList = new TodoList("Bob Wick");
        bobsList.addTask("Math homework", 10);
        bobsList.addTask("Physics homework", 8);
        bobsList.addTask("Do the dishes", 5);
        bobsList.addTask("Walk the dog", 6);
        bobsList.addTask("Computer Science", 11);
        bobsList.addTask("Witchcraft and Wizardry", 7);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        bobsList = null;

    }

    @org.junit.jupiter.api.Test
    void bestSubject() {

        assertEquals("Computer Science", bobsList.mostUrgent());
        bobsList.updateTaskUrgency("Do the dishes", 2);
        assertEquals("Computer Science", bobsList.mostUrgent());
        bobsList.updateTaskUrgency("Computer Science", 6);
        assertEquals("Math homework", bobsList.mostUrgent());

    }

    @org.junit.jupiter.api.Test
    void averageGrade() {

        assertEquals(7.8, ((int) (bobsList.averageUrgency()*10))/10.0);
        bobsList.updateTaskUrgency("Math homework", 4);
        assertEquals(6.8, bobsList.averageUrgency());
        bobsList.updateTaskUrgency("Walk the dog", 10);
        assertEquals(7.5, ((int) (bobsList.averageUrgency()*10))/10.0);

    }

    @org.junit.jupiter.api.Test
    void reportCard() {

        String expectedTodoList = "Report card for Bob Wick\nMath homework\t10\nPhysics homework\t10\nDo the dishes\t5\nWalk the dog\t6\nComputer Science\t11\nWitchcraft and Wizardry\t7";
        String actualTodoList = bobsList.toString();
        assertEquals(expectedTodoList, actualTodoList);
    }
}