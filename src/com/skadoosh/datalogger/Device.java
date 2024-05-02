package com.skadoosh.datalogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;

public class Device
{
    private final SerialPort port;

    private boolean compatible = false;

    // private InputStream inputStream = null;
    private OutputStream outputStream = null;

    private boolean portOpen = false;

    public Device(SerialPort port)
    {
        this.port = port;
        OpenPort();
    }

    public void OpenPort()
    {
        if (!portOpen)
        {
            port.openPort();
            // inputStream = port.getInputStream();
            outputStream = port.getOutputStream();

            portOpen = true;
        }
    }

    public void ClosePort()
    {
        if (portOpen)
        {
            try
            {
                // inputStream.close();
                outputStream.close();

                portOpen = false;

                port.closePort();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public SerialPort getPort()
    {
        return port;
    }

    public String getName()
    {
        return port.getPortDescription();
    }

    public void CheckCompatibiliy()
    {
        boolean pre = portOpen;

        OpenPort();

        try
        {
            outputStream.write("datalogger_compatibility_check".getBytes());

            // byte[] bytes = inputStream.readAllBytes();
            // System.out.println(new String(bytes));
        }
        catch (IOException e)
        {
            compatible = false;
            e.printStackTrace();
        }

        if (!pre)
        {
            ClosePort();
        }
    }

    public void ProcessInput()
    {
        if (portOpen && (port.bytesAvailable() > 0))
        {
            byte[] readBuffer = new byte[port.bytesAvailable()];
            int numRead = port.readBytes(readBuffer, readBuffer.length);
            System.out.println("Read " + numRead + " bytes. " + new String(readBuffer));
        }
    }
}
