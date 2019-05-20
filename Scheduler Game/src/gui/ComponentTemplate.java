package gui;

public interface ComponentTemplate {

    // Set background, color, font
    void setHelpers();

    // Create and set all text, labels and other elements
    void setContent();

    // Set panel
    void setContainer();

    // Add all inner components to its parent
    void addChild();

}