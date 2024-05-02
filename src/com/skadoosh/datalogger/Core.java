package com.skadoosh.datalogger;

import java.util.ArrayList;

import imgui.ImGui;
import imgui.ImVec2;
import imgui.flag.ImGuiStyleVar;
import imgui.flag.ImGuiTreeNodeFlags;
import imgui.flag.ImGuiWindowFlags;

public class Core
{
    private final DeviceManager deviceManager = new DeviceManager();

    private final ArrayList<DeviceWindow> deviceWindows = new ArrayList<>();

    private final Window devicesWindow = new Window()
    {
        @Override
        protected String getName()
        {
            return "Devices";
        }

        @Override
        protected void Display()
        {
            // ImGui.setNextItemOpen(true);
            if (ImGui.collapsingHeader("Connected Devices", ImGuiTreeNodeFlags.DefaultOpen))
            {
                ArrayList<Device> devices = deviceManager.getConnectedDevices();
                for (Device device : devices)
                {
                    ImGui.pushID(device.getName());
                    ImGui.pushItemWidth(ImGui.getWindowContentRegionMaxX());
                    if (ImGui.button(device.getName()))
                    {
                        for (DeviceWindow dWindow : deviceWindows)
                        {
                            if (dWindow.getDevice() == device)
                            {
                                dWindow.Open();
                                break;
                            }
                        }
                    }
                    ImGui.popItemWidth();
                    ImGui.popID();
                    // ImGui.text(device.getName());
                }
            }

            // ImGui.setNextItemOpen(true);
            if (ImGui.collapsingHeader("Available Devices", ImGuiTreeNodeFlags.DefaultOpen))
            {
                ArrayList<UnidentifiedDevice> toConnect = new ArrayList<>();
                ArrayList<UnidentifiedDevice> uDevices = deviceManager.getAvailableDevices();

                for (UnidentifiedDevice uDevice : uDevices)
                {
                    ImGui.text(uDevice.getName());

                    ImGui.sameLine(ImGui.getWindowContentRegionMax().x - 70);
                    Style.ImportantButton();

                    ImGui.pushID(uDevice.getName());
                    if (ImGui.button("Connect"))
                    {
                        Style.ClearButtonStyle();
                        System.out.println("Clicked! AAJ@H!");
                        toConnect.add(uDevice);
                    }
                    else
                    {
                        Style.ClearButtonStyle();
                    }
                    ImGui.popID();
                }


                for (int i = 0; i < toConnect.size(); i++)
                {
                    Device d = deviceManager.ConnectDevice(toConnect.get(i));
                    d.CheckCompatibiliy();

                    DeviceWindow w = new DeviceWindow(d);

                    deviceWindows.add(w);

                    toConnect.remove(i);
                    i--;
                }
            }

        }
    };

    public void Init()
    {
        deviceManager.CheckForDevices();
    }

    public void Process()
    {
        deviceManager.ProcessDeviceinputs();


        Window.DisplayWindow(devicesWindow);
        

        for (DeviceWindow deviceWindow : deviceWindows)
        {
            Window.DisplayWindow(deviceWindow);
        }
    }
}
