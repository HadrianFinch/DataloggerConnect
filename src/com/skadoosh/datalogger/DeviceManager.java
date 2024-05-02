package com.skadoosh.datalogger;

import java.util.ArrayList;

import com.fazecast.jSerialComm.SerialPort;

public class DeviceManager
{
    private ArrayList<Device> devices = new ArrayList<>();
    public ArrayList<Device> getConnectedDevices()
    {
        return devices;
    }

    private ArrayList<UnidentifiedDevice> availableDevices = new ArrayList<>();

    public ArrayList<UnidentifiedDevice> getAvailableDevices()
    {
        return availableDevices;
    }

    public void CheckForDevices()
    {
        availableDevices.clear();

        SerialPort[] ports = SerialPort.getCommPorts();
        for (SerialPort port : ports)
        {
            if (port.getSystemPortName().contains("tty"))
            {
                continue;
            }

            boolean cont = false;
            for (Device d : devices)
            {
                if (d.getPort().getSystemPortPath().equals(port.getSystemPortPath()))
                {
                    cont = true;
                    break;
                }
            }
            if (cont)
            {
                continue;
            }

            availableDevices.add(new UnidentifiedDevice(port));
        }
    }

    public Device ConnectDevice(UnidentifiedDevice unidentifiedDevice)
    {
        Device device = new Device(unidentifiedDevice.getPort());
        // device.OpenPort();
        
        devices.add(device);
        
        availableDevices.remove(unidentifiedDevice);
        
        // update devices afterwords
        CheckForDevices();

        return device;
    }

    public void ProcessDeviceinputs()
    {
        for (Device device : devices)
        {
            device.ProcessInput();
        }
    }
}
