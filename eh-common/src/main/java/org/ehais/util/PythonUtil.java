package org.ehais.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonUtil {

	public static String python(String pythonFile, String url) throws Exception {
		StringBuffer sb = new StringBuffer();
//		Process pr = Runtime.getRuntime().exec("cmd /c python " + pythonFile + " " +url);
		ProcessBuilder pb = new ProcessBuilder("python", pythonFile, url);
		pb.redirectErrorStream(true);
		Process pr = pb.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		pr.waitFor();
		return sb.toString();
	}
}
