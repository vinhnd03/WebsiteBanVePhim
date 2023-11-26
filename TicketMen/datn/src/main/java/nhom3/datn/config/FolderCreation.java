package nhom3.datn.config;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// @Component
// public class FolderCreation implements ApplicationRunner {

//     @Override
//     public void run(ApplicationArguments args) throws Exception {
//         // Thư mục bạn muốn kiểm tra/tạo
//         String folderPath = "/123";

//         // Kiểm tra xem thư mục đã tồn tại chưa
//         File folder = new File(folderPath);
//         if (!folder.exists()) {
//             // Nếu thư mục chưa tồn tại, tạo mới
//             folder.mkdir();
//             System.out.println("Đã tạo thư mục: " + folderPath);
//         } else {
//             System.out.println("Thư mục đã tồn tại: " + folderPath);
//         }
//     }
// }