module ro.mpp2025.proiectiss {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.tx;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.desktop;
    requires spring.jcl;

    opens ro.mpp2025.proiectiss to javafx.fxml;
    exports ro.mpp2025.proiectiss;
    opens ro.mpp2025.proiectiss.Misc to javafx.fxml;
    exports ro.mpp2025.proiectiss.Controller;
    opens ro.mpp2025.proiectiss.Controller to javafx.fxml;
}