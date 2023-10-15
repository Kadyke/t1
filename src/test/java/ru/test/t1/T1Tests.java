package ru.test.t1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.test.t1.controller.ControllerT1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

	@Test
	void testStressOver800kCharacters() throws IOException {
		String string800k = Files.readString(Path.of("./src/test/resources/file.txt"));
		List<Map.Entry<Character, Integer>> result = controller.countCharacter(string800k);
		System.out.println(result);
		assertEquals(16, result.size());
		assertEquals("А".charAt(0), result.get(0).getKey());
		assertEquals(196560, result.get(0).getValue());
		assertEquals(" ".charAt(0), result.get(1).getKey());
		assertEquals(131039, result.get(1).getValue());
		assertEquals("т".charAt(0), result.get(2).getKey());
		assertEquals(98280, result.get(2).getValue());
		assertEquals("а".charAt(0), result.get(3).getKey());
		assertEquals(98280, result.get(3).getValue());
		assertEquals("с".charAt(0), result.get(4).getKey());
		assertEquals(32760, result.get(4).getValue());
		assertEquals("!".charAt(0), result.get(5).getKey());
		assertEquals(32760, result.get(5).getValue());
		assertEquals("у".charAt(0), result.get(6).getKey());
		assertEquals(32760, result.get(6).getValue());
		assertEquals("х".charAt(0), result.get(7).getKey());
		assertEquals(32760, result.get(7).getValue());
		assertEquals("ь".charAt(0), result.get(8).getKey());
		assertEquals(32760, result.get(8).getValue());
		assertEquals("в".charAt(0), result.get(9).getKey());
		assertEquals(32760, result.get(9).getValue());
		assertEquals("ж".charAt(0), result.get(10).getKey());
		assertEquals(32760, result.get(10).getValue());
		assertEquals("и".charAt(0), result.get(11).getKey());
		assertEquals(32760, result.get(11).getValue());
		assertEquals("й".charAt(0), result.get(12).getKey());
		assertEquals(32760, result.get(12).getValue());
		assertEquals("л".charAt(0), result.get(13).getKey());
		assertEquals(32760, result.get(13).getValue());
		assertEquals("о".charAt(0), result.get(14).getKey());
		assertEquals(32760, result.get(14).getValue());
		assertEquals("п".charAt(0), result.get(15).getKey());
		assertEquals(32760, result.get(15).getValue());
	}

	@Test
	void testNullCharacter() {
		List<Map.Entry<Character, Integer>> result = controller.countCharacter(null);
		assertTrue(result.isEmpty());
	}
}
