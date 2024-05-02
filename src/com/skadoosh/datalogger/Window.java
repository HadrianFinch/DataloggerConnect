package com.skadoosh.datalogger;

import imgui.ImGui;
import imgui.type.ImBoolean;

public abstract class Window
{
    private final ImBoolean open;

    public Window()
    {
        open = new ImBoolean(true);
    }

    
    public static void DisplayWindow(Window window)
    {
        if (window.open.get() && ImGui.begin(window.getName(), window.open))
        {
            window.Display();
            ImGui.end();
        }
    }
    
    public void Open()
    {
        open.set(true);
    }
    
    public void Close()
    {
        open.set(false);
    }

    protected abstract String getName();
    protected abstract void Display();
}
