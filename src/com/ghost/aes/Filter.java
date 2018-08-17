package com.ghost.aes;

import java.io.*;

public class Filter extends FilterOutputStream {

	public Filter(OutputStream outputstream) {
		super(outputstream);
	}

	public static String a(byte abyte0[]) {
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(
				(int) ((double) abyte0.length * 1.3700000000000001D));
		Filter d1 = new Filter(bytearrayoutputstream);
		String result;
		try {
			d1.write(abyte0);
			d1.close();
			result = bytearrayoutputstream.toString("UTF-8");
		} catch (IOException e) {
			return null;
		}
		return result;
	}

	public void close() throws IOException {
		if (b % 3 != 1) {
			if (b % 3 == 2) {
				int j = c;
				out.write(a[j << 2 & 0x3f]);
				out.write(61);
			}
		} else {
			int i = c;
			out.write(a[i << 4 & 0x3f]);
			out.write(61);
			out.write(61);
		}

		super.close();
		return;
	}

	public void write(int i) throws IOException {
		int j;
		j = i;
		if (i < 0)
			j = i + 256;
		if (b % 3 != 0) {
			if (b % 3 == 1) {
				i = c;
				c = j & 0xf;
				out.write(a[(i << 4) + (j >> 4) & 0x3f]);
			} else if (b % 3 == 2) {
				i = c;
				out.write(a[(i << 2) + (j >> 6) & 0x3f]);
				out.write(a[j & 0x3f]);
				c = 0;
			}
		} else {
			c = j & 3;
			out.write(a[j >> 2]);
		}

		b = b + 1;
		if (b % 57 == 0)
			out.write(10);
	}

	public void write(byte abyte0[], int i, int j) throws IOException {
		for (int k = 0; k < j; k++)
			write(abyte0[i + k]);
	}

	private static final char a[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };
	private int b;
	private int c;

}
