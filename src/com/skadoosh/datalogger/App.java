package com.skadoosh.datalogger;

import java.util.ArrayList;

import imgui.*;
import imgui.app.*;
import imgui.extension.implot.ImPlot;
import imgui.flag.ImGuiCond;
import imgui.flag.ImGuiConfigFlags;
import imgui.flag.ImGuiStyleVar;
import imgui.flag.ImGuiWindowFlags;
import imgui.type.ImBoolean;

public class App extends Application
{
    private Core core = new Core();
    private ArrayList<ExceptionWindow> exceptionWindows = new ArrayList<>();

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
        SetupDockspace();
        core.Process();
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
