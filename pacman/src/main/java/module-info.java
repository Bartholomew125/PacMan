module com.example {
    requires transitive javafx.controls;
    requires javafx.graphics;
    exports com.example;
    exports com.example.model.states;
    exports com.example.model;
    exports com.example.controller.searching;
}
