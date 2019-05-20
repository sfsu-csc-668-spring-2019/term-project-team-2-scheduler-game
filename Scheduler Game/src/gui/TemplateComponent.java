package gui;

public interface TemplateComponent {

    // Set background, color, font
    void setHelpers();

    // Create and set all text, labels and other elements
    void setContent();

    // Set panel layout, dimensions, borders, position
    void setContainer();

    // Add all inner components to its parent
    void addChild();

}