package com.skadoosh.datalogger;

import java.io.PrintWriter;
import java.io.StringWriter;

import imgui.ImGui;
import imgui.flag.ImGuiTreeNodeFlags;

public class ExceptionWindow extends Window
{
    private final Exception exception;

    public ExceptionWindow(Exception e)
    {
        exception = e;
    }

    @Override
    protected void Display()
    {
        ImGui.text("An exception has occured.");
        ImGui.text(exception.getMessage());

        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        System.out.println(exceptionAsString);
        
        if (ImGui.collapsingHeader("Stack Trace", ImGuiTreeNodeFlags.DefaultOpen))
        {
            ImGui.text(exceptionAsString);
        }
    }

    @Override
    protected String getName()
    {
        return exception.getClass().getName();
    }

}
