package ananasovitch.org.act;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BoundaryServiceTest {

    private final BoundaryService boundaryService = new BoundaryService();

    static Stream<Arguments> provideData() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, 1),
                arguments(new int[]{10, 20, 30, 40, 50}, 10),
                arguments(new int[]{100, 200, 300, 400, 500}, 100)
                // Добавьте еще тестовых данных здесь
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testFindMin(int[] marks, int expectedMin) {
        int min = boundaryService.findMin(marks);
        assertEquals(expectedMin, min, "Минимальное значение неверно");
    }

    @ParameterizedTest
    @MethodSource("provideAdditionalData")
    public void testFindMinAdditional(int[] marks, int expectedMin) {
        int min = boundaryService.findMin(marks);
        assertEquals(expectedMin, min, "Минимальное значение неверно");
    }
    static Stream<Arguments> provideAdditionalData() {
        return Stream.of(
                arguments(new int[]{100, 5, 300, 20, 500}, 5),
                arguments(new int[]{-10, -20, -3, -40, -5}, -40),
                arguments(new int[]{10, 20, 30, 40, 5}, 5)

        );
    }
}