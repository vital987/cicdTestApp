package com.vital987.testapp;

import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Exec
{
    static String run(String cmd) throws IOException
    {
        var processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", cmd);
        var process = processBuilder.start();
        try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream())))
        {
            String line = reader.readLine();
            return line;
        }
    }

    static int returnVal(String cmd) throws IOException
    {
        var processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", cmd);
        var process = processBuilder.start();
        try
        {
            process.waitFor();
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return process.exitValue();
    }

}
