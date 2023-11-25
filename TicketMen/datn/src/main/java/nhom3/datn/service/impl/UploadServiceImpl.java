package nhom3.datn.service.impl;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nhom3.datn.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    ServletContext app;

    
    @Override
    public File save(MultipartFile file) {

        File dir = new File(app.getRealPath("/images/upload/"));
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Mã hóa tên tập tin và giữ lại phần extension
        String originalFileName = file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(originalFileName);
        String name = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + "." + fileExtension;
        // String filePath = uploadPath + name + "." + fileExtension;

        try {
            // File savedFile = new File(app.getRealPath(name));
            System.out.println("dir:" + dir);
            File savedFile = new File(dir, name);
            // System.out.println("File saved to: " + savedFile.getAbsolutePath());
            file.transferTo(savedFile);
            return savedFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// @Override
    // public File save(MultipartFile file, String folder) {
    // File dir = new File(app.getRealPath("/image/" + folder));
    // if(!dir.exists()){
    // dir.mkdirs();
    // }
    // // String s = System.currentTimeMillis() + file.getOriginalFilename();
    // // String name = Integer.toHexString(s.hashCode()) +
    // s.substring(s.lastIndexOf("."));
    // String name = file.getOriginalFilename();
    // try{
    // File savedFile = new File(dir, name);
    // file.transferTo(savedFile);
    // // System.out.println(savedFile.getAbsolutePath());
    // return savedFile;
    // } catch (Exception e){
    // throw new RuntimeException(e);
    // }
    // }
