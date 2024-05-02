package com.skadoosh.datalogger;

import imgui.ImColor;
import imgui.ImGui;
import imgui.ImGuiStyle;
import imgui.ImVec4;
import imgui.flag.ImGuiCol;

public final class Style
{
    private Style()
    {

    }

    public static void ImportantButton()
    {
        int i = 4;
        ImGui.pushStyleColor(ImGuiCol.Button, ImColor.hsl(i / 7.0f, 0.6f, 0.6f));
        ImGui.pushStyleColor(ImGuiCol.ButtonHovered, ImColor.hsl(i / 7.0f, 0.7f, 0.7f));
        ImGui.pushStyleColor(ImGuiCol.ButtonActive, ImColor.hsl(i / 7.0f, 0.8f, 0.8f));
    }

    public static void ClearButtonStyle()
    {

        ImGui.popStyleColor(3);
    }

    public static void ApplyTheme()
    {
        ImGuiStyle style = ImGui.getStyle();
        style.setWindowPadding(8, 8);

        // Styles
        style.setWindowRounding(10);
        style.setChildRounding(10);
        style.setFrameRounding(10);
        style.setPopupRounding(10);
        style.setScrollbarRounding(10);
        style.setGrabRounding(10);
        style.setTabRounding(10);

        // Colors
        style.setColor(ImGuiCol.Text, 1.00f, 1.00f, 1.00f, 1.00f);
        style.setColor(ImGuiCol.TextDisabled, 0.50f, 0.50f, 0.50f, 1.00f);
        style.setColor(ImGuiCol.WindowBg, 0.10f, 0.10f, 0.10f, 1.00f);
        style.setColor(ImGuiCol.ChildBg, 0.00f, 0.00f, 0.00f, 0.00f);
        style.setColor(ImGuiCol.PopupBg, 0.19f, 0.19f, 0.19f, 0.92f);
        style.setColor(ImGuiCol.Border, 1f, 1f, 1f, 1f);
        style.setColor(ImGuiCol.BorderShadow, 0.00f, 0.00f, 0.00f, 0.24f);
        style.setColor(ImGuiCol.FrameBg, 0.05f, 0.05f, 0.05f, 0.54f);
        style.setColor(ImGuiCol.FrameBgHovered, 0.19f, 0.19f, 0.19f, 0.54f);
        style.setColor(ImGuiCol.FrameBgActive, 0.20f, 0.22f, 0.23f, 1.00f);
        style.setColor(ImGuiCol.TitleBg, 0.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.TitleBgActive, 0.06f, 0.06f, 0.06f, 1.00f);
        style.setColor(ImGuiCol.TitleBgCollapsed, 0.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.MenuBarBg, 0.14f, 0.14f, 0.14f, 1.00f);
        style.setColor(ImGuiCol.ScrollbarBg, 0.05f, 0.05f, 0.05f, 0.54f);
        style.setColor(ImGuiCol.ScrollbarGrab, 0.34f, 0.34f, 0.34f, 0.54f);
        style.setColor(ImGuiCol.ScrollbarGrabHovered, 0.40f, 0.40f, 0.40f, 0.54f);
        style.setColor(ImGuiCol.ScrollbarGrabActive, 0.56f, 0.56f, 0.56f, 0.54f);
        style.setColor(ImGuiCol.CheckMark, 0.33f, 0.67f, 0.86f, 1.00f);
        style.setColor(ImGuiCol.SliderGrab, 0.34f, 0.34f, 0.34f, 0.54f);
        style.setColor(ImGuiCol.SliderGrabActive, 0.56f, 0.56f, 0.56f, 0.54f);
        style.setColor(ImGuiCol.Button, 0.05f, 0.05f, 0.05f, 0.54f);
        style.setColor(ImGuiCol.ButtonHovered, 0.19f, 0.19f, 0.19f, 0.54f);
        style.setColor(ImGuiCol.ButtonActive, 0.20f, 0.22f, 0.23f, 1.00f);
        style.setColor(ImGuiCol.Header, 0.00f, 0.00f, 0.00f, 0.52f);
        style.setColor(ImGuiCol.HeaderHovered, 0.00f, 0.00f, 0.00f, 0.36f);
        style.setColor(ImGuiCol.HeaderActive, 0.20f, 0.22f, 0.23f, 0.33f);
        style.setColor(ImGuiCol.Separator, 0.28f, 0.28f, 0.28f, 0.29f);
        style.setColor(ImGuiCol.SeparatorHovered, 0.44f, 0.44f, 0.44f, 0.29f);
        style.setColor(ImGuiCol.SeparatorActive, 0.40f, 0.44f, 0.47f, 1.00f);
        style.setColor(ImGuiCol.ResizeGrip, 0.28f, 0.28f, 0.28f, 0.29f);
        style.setColor(ImGuiCol.ResizeGripHovered, 0.44f, 0.44f, 0.44f, 0.29f);
        style.setColor(ImGuiCol.ResizeGripActive, 0.40f, 0.44f, 0.47f, 1.00f);
        style.setColor(ImGuiCol.Tab, 0.00f, 0.00f, 0.00f, 0.52f);
        style.setColor(ImGuiCol.TabHovered, 0.14f, 0.14f, 0.14f, 1.00f);
        style.setColor(ImGuiCol.TabActive, 0.20f, 0.20f, 0.20f, 0.36f);
        style.setColor(ImGuiCol.TabUnfocused, 0.00f, 0.00f, 0.00f, 0.52f);
        style.setColor(ImGuiCol.TabUnfocusedActive, 0.14f, 0.14f, 0.14f, 1.00f);
        style.setColor(ImGuiCol.DockingPreview, 0.33f, 0.67f, 0.86f, 1.00f);
        style.setColor(ImGuiCol.DockingEmptyBg, .09f, 0.09f, 0.09f, 1.00f);
        style.setColor(ImGuiCol.PlotLines, 1.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.PlotLinesHovered, 1.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.PlotHistogram, 1.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.PlotHistogramHovered, 1.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.TableHeaderBg, 0.00f, 0.00f, 0.00f, 0.52f);
        style.setColor(ImGuiCol.TableBorderStrong, 0.00f, 0.00f, 0.00f, 0.52f);
        style.setColor(ImGuiCol.TableBorderLight, 0.28f, 0.28f, 0.28f, 0.29f);
        style.setColor(ImGuiCol.TableRowBg, 0.00f, 0.00f, 0.00f, 0.00f);
        style.setColor(ImGuiCol.TableRowBgAlt, 1.00f, 1.00f, 1.00f, 0.06f);
        style.setColor(ImGuiCol.TextSelectedBg, 0.20f, 0.22f, 0.23f, 1.00f);
        style.setColor(ImGuiCol.DragDropTarget, 0.33f, 0.67f, 0.86f, 1.00f);
        style.setColor(ImGuiCol.NavHighlight, 1.00f, 0.00f, 0.00f, 1.00f);
        style.setColor(ImGuiCol.NavWindowingHighlight, 1.00f, 0.00f, 0.00f, 0.70f);
        style.setColor(ImGuiCol.NavWindowingDimBg, 1.00f, 0.00f, 0.00f, 0.20f);
        style.setColor(ImGuiCol.ModalWindowDimBg, 1.00f, 0.00f, 0.00f, 0.35f);
    }
}
