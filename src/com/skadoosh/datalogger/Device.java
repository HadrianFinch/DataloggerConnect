package com.skadoosh.datalogger;

import java.io.IOException;
import java.io.OutputStream;

import com.fazecast.jSerialComm.SerialPort;
import com.google.gson.Gson;

public class Device
{
    private static final char DATA_START_CHAR = '<';
    private static final char DATA_END_CHAR = '>';

    private final SerialPort port;

    private boolean compatible = false;

    private String inputBuffer = new String();

    // private InputStream inputStream = null;
    private OutputStream outputStream = null;

    private boolean portOpen = false;

    private boolean inputStartRecived = false;
    private boolean inputBufferReady = false;

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
            outputStream.write("<datalogger_compatibility_check>".getBytes());
        }
        catch (IOException e)
        {
            compatible = false;
        }

        if (!pre)
        {
            ClosePort();
        }
    }

    public void ProcessInput(String data)
    {
        ////////// Command format //////////
        /*
         * TYPE:UUID:VALUE
         * 
         * TYPE: - INFO - DATA - DEBUG
         * 
         * UUID: - the uuid of the item
         * 
         * VALUE: - The value of the information being sent, this is dependent on the TYPE and UUID
         */


        // 0 = TYPE, 1 = UUID, 2 = VALUE
        String[] parts = data.split(":");

        switch (parts[0])
        {
            case "INFO":
            {

            }
                break;

            case "DATA":
            {

            }
                break;

            case "DEBUG":
            {
                // TODO: make actually do something
            }
            break;
        }
    }

    public void ReadSerialPort()
    {
        if (!portOpen)
        {
            return;
        }

        while ((port.bytesAvailable() > 0) && !inputBufferReady)
        {
            byte[] readBuffer = new byte[1];
            /* int numRead = */port.readBytes(readBuffer, readBuffer.length);

            char character = ((char)readBuffer[0]);
            if (!inputStartRecived && (character == DATA_START_CHAR))
            {
                inputStartRecived = true;
            }

            if (inputStartRecived && (character == DATA_END_CHAR))
            {
                inputStartRecived = false;
                inputBufferReady = true;

                // This happens because the loop check if the buffer is ready
                // break;
            }

            if (inputStartRecived)
            {
                inputBuffer += character;
            }
        }

        if (inputBufferReady)
        {
            // Process input
            ProcessInput(inputBuffer);

            // clear buffer
            inputBuffer = "";

            // reset varible to continue processing
            inputBufferReady = false;
        }
    }
}
