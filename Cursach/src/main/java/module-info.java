module com.example.cursach {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
//    opens Voucher to javafx.fxml;
//    opens  com.example.cursach.Voucher.Voucher to javafx.fxml;
//
//    exports Voucher ;
//    exports com.example.cursach.Voucher.Voucher;
    opens com.example.cursach.Voucher to javafx.fxml;
    exports com.example.cursach.Voucher;
    opens com.example.cursach to javafx.fxml;
    exports com.example.cursach;
    exports com.example.cursach.Controllers;
    opens com.example.cursach.Controllers to javafx.fxml;
}