package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayLeftRotationTest {
	@Test
	public void main() throws Exception {
		InputStream inStream = new ByteArrayInputStream("5 4\n1 2 3 4 5\n".getBytes(StandardCharsets.UTF_8));
		final StringBuilder builder = new StringBuilder();
		OutputStream outStream = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				builder.append((char) b);
			}
		};
		System.setOut(new PrintStream(outStream));
		System.setIn(inStream);
		ArrayLeftRotation.main(null);
		assertTrue(builder.toString().equals("5 1 2 3 4"));
	}

	@Test
	public void solution1() throws Exception {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] rotatedArray = { 5, 1, 2, 3, 4 };
		assert (Arrays.equals(ArrayLeftRotation.solution1(5, 4, array), rotatedArray));
	}

	@Test
	public void solution2() throws Exception {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] rotatedArray = { 5, 1, 2, 3, 4 };
		assert (Arrays.equals(ArrayLeftRotation.solution2(5, 4, array), rotatedArray));
	}
}