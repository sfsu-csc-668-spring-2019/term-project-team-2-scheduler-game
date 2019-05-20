package gui;

public interface TemplateFrame {

    // Set background, color, font
    void setHelpers();

    // Create form fields and labels
    void setForm();

    // Create form buttons with hover
    void setButtons();

    // Set frame settings
    void setFrame();

    // Add all inner components to its parent
    void addChildren();

}