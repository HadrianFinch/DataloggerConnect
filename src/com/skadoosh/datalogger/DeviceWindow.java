package com.skadoosh.datalogger;

import imgui.ImGui;
import imgui.flag.ImGuiTreeNodeFlags;

public class DeviceWindow extends Window
{
    private final Device device;

    public Device getDevice()
    {
        return device;
    }

    public DeviceWindow(Device device)
    {
        this.device = device;
    }

    @Override
    protected String getName()
    {
        return device.getName();
    }

    @Override
    protected void Display()
    {
        ImGui.text(device.getPort().getSystemPortPath());

        if (ImGui.collapsingHeader("Compatibility", ImGuiTreeNodeFlags.DefaultOpen))
        {

        }
    }

}