module stu.cn.ua.chstusystemmodelling {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens stu.cn.ua.chstusystemmodelling to javafx.fxml;
    exports stu.cn.ua.chstusystemmodelling;
}