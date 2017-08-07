package com.github.conradoqg.studydsa.hackerrank.challenges;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class JavaVisitorPatternTest {

	@Test
	public void main() {		
		InputStream inStream = new ByteArrayInputStream("5\n4 7 2 5 12\n0 1 0 0 1\n1 2\n1 3\n3 4\n3 5\n".getBytes(StandardCharsets.UTF_8));
		final StringBuilder builder = new StringBuilder();
		OutputStream outStream = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				builder.append((char) b);
			}
		};
		System.setOut(new PrintStream(outStream));
		System.setIn(inStream);
		JavaVisitorPattern.main(null);
		assertTrue(builder.toString().equals("24"+System.lineSeparator()+"40"+System.lineSeparator()+"15"+System.lineSeparator()));
	}

}
