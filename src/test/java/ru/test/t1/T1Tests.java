package ru.test.t1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.test.t1.controller.ControllerT1;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class T1Tests {

	@Autowired
	ControllerT1 controller;

	@Test
	void testCountCharacter() {
		List<Map.Entry<Character, Integer>> result = controller.countCharacter("||\"\"| ");
		assertEquals(3, result.size());
		assertEquals("|".charAt(0), result.get(0).getKey());
		assertEquals(3, result.get(0).getValue());
		assertEquals("\"".charAt(0), result.get(1).getKey());
		assertEquals(2, result.get(1).getValue());
		assertEquals(" ".charAt(0), result.get(2).getKey());
		assertEquals(1, result.get(2).getValue());
	}
}
