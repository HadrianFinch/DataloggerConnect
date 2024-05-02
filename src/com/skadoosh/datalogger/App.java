package com.skadoosh.datalogger;

import imgui.*;
import imgui.app.*;
import imgui.extension.implot.ImPlot;
import imgui.extension.implot.flag.ImPlotAxisFlags;
import imgui.flag.ImGuiCol;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiConfigFlags;
import imgui.flag.ImGuiStyleVar;
import imgui.flag.ImGuiWindowFlags;
import imgui.internal.flag.ImGuiAxis;
import imgui.type.ImBoolean;

public class App extends Application
{
    private Core core = new Core();

    private void SetupDockspace()
    {
        int windowFlags = ImGuiWindowFlags.NoDocking | ImGuiWindowFlags.MenuBar;

        ImGui.setNextWindowPos(0.0f, 0.0f, ImGuiCond.Always);
        ImGui.setNextWindowSize(ImGui.getMainViewport().getSizeX(), ImGui.getMainViewport().getSizeY());
        ImGui.pushStyleVar(ImGuiStyleVar.WindowRounding, 0.0f);
        ImGui.pushStyleVar(ImGuiStyleVar.WindowBorderSize, 0.0f);
        ImGui.pushStyleVar(ImGuiStyleVar.WindowPadding, 0.0f, 0.0f);

        windowFlags |= ImGuiWindowFlags.NoTitleBar | ImGuiWindowFlags.NoResize | ImGuiWindowFlags.NoMove | ImGuiWindowFlags.NoBringToFrontOnFocus | ImGuiWindowFlags.NoCollapse;

        ImGui.begin("dockspace demo", new ImBoolean(true), windowFlags);
        ImGui.popStyleVar(3);

        ImGui.dockSpace(ImGui.getID("Docksapce"));

        ImGui.end();
    }

    @Override
    protected void configure(Configuration config)
    {
        config.setTitle("Datalogger Connect v1.0.0");
    }

    @Override
    public void process()
    {
        // ImGui.pushStyleVar(ImGuiStyleVar.WindowBorderSize, 0);
        // if (ImGui.beginMainMenuBar())
        // {
        // if (ImGui.beginMenu("File"))
        // {
        // if (ImGui.menuItem("Create"))
        // {
        // }
        // if (ImGui.menuItem("Open", "Ctrl+O"))
        // {
        // }
        // if (ImGui.menuItem("Save", "Ctrl+S"))
        // {
        // }
        // if (ImGui.menuItem("Save as.."))
        // {
        // }
        // ImGui.endMenu();
        // }

        // if (ImGui.beginMenu("Window"))
        // {
        // for (Window window : Window.windows)
        // {
        // if (ImGui.menuItem(window.getName()))
        // {
        // window.OpenWindow();
        // }
        // }
        // ImGui.endMenu();
        // }
        // ImGui.endMainMenuBar();
        // }
        // ImGui.popStyleVar();

        SetupDockspace();

        // ImGui.begin("Position v Time");
        // {
        //     // if (ImPlot.beginPlot("##Rolling", new ImVec2(-1,150))) {
        //     //     ImPlot.setupAxes(nullptr, nullptr, flags, flags);
        //     //     ImPlot.setupAxisLimits(ImAxis_X1,0,history, ImGuiCond_Always);
        //     //     ImPlot.setupAxisLimits(ImAxis_Y1,0,1);
        //     //     ImPlot.plotLine("Mouse X", rdata1.data[0].x, rdata1.data[0].y, rdata1.data.size(), 0, 0, 2 * 64);
        //     //     // ImPlot.PlotLine("Mouse Y", &rdata2.data[0].x, &rdata2.data[0].y, rdata2.data.size(), 0, 0, 2 * sizeof(float));
        //     //     ImPlot.endPlot();
        //     // }

        //     values[0] += ImGui.getIO().getDeltaTime();
        //     values[9] = 30f;

        //     float average = 0.0f;
        //     for (int n = 0; n < (values.length); n++)
        //         average += values[n];
        //     average /= (float)(values.length);

        //     // ImGui.plotLines("Lines", values, values.length, 1, "Average: " + average, 2.0f, 20.0f);

        //     if (ImPlot.beginPlot("My Plot")) {
        //         // ImPlot.plotBars("My Bar Plot", bar_data, 11);
        //         ImPlot.plotLine("My Line Plot", new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, values, 100, 90);
        //         ImPlot.endPlot();
        //     }

        //     // ImGui.plotLines("Test Line", new float[]{22, 12, 3, 55, 56, 45, 34, 23, 32, 31, 11, 10}, 70);
        //     ImGui.end();
        // }

        // ImGui.begin("Devices");
        // {
            
        //     ImGui.end();
        // }

        core.Process();

        // Editor.Windows.Window.DrawWindows();

        ImGui.showDemoWindow();
    }

    public static void main(String[] args)
    {
        // ProjectExplorer projectExplorer = new ProjectExplorer();
        // Inspector inspector = new Inspector();
        // SceneView sceneView = new SceneView();1
        // try
        // {
        // sceneView.LoadScene(((GameConfig)AGE.Resources.LaodResource(GameConfig.class,
        // "config/game")).startingScene);
        // }
        // catch (IOException e)
        // {
        // EditorConsole.Log("Failed to load initial scene!");
        // }

        launch(new App());
    }

    @Override
    protected void preRun()
    {
        ImGuiIO io = ImGui.getIO();
        io.setConfigFlags(ImGuiConfigFlags.ViewportsEnable);
        io.setConfigFlags(ImGuiConfigFlags.DockingEnable);
        io.setConfigDockingWithShift(false);

        ImPlot.createContext();
    }

    @Override
    protected void init(Configuration config)
    {
        super.init(config);
        Style.ApplyTheme();
        core.Init();
    }

    @Override
    protected void initImGui(Configuration config)
    {
        super.initImGui(config);

        ImGuiIO io = ImGui.getIO();

        io.getFonts().build();
        io.setFontDefault(io.getFonts().addFontFromFileTTF("AndaleMono.ttf", 14f));
    }
}
