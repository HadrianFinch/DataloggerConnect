package com.skadoosh.datalogger;

import com.fazecast.jSerialComm.SerialPort;

public class UnidentifiedDevice
{
    private final SerialPort port;

    public SerialPort getPort()
    {
        return port;
    }

    public UnidentifiedDevice(SerialPort port)
    {
        this.port = port;
    }

    public String getName()
    {
        return port.getPortDescription();
    }
}
