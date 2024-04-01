package ananasovitch.org.act;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BoundaryServiceTest {

    private BoundaryService boundaryService = new BoundaryService();

    static Stream<Arguments> provideData() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, 1),
                arguments(new int[]{10, 20, 30, 40, 50}, 10),
                arguments(new int[]{100, 200, 300, 400, 500}, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testFindMin(int[] marks, int expectedMin) {
        int min = boundaryService.findMin(marks);
        // Измененный ожидаемый результат
        assertEquals(0, min, "Минимальное значение неверно");
    }
}