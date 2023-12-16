package nhom3.datn.controller.rest;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import nhom3.datn.service.UploadService;

// @CrossOrigin("*")
@RestController
public class UploadRestController {
    @Autowired
    UploadService uploadService;


    @PostMapping("/rest/upload")
    public JsonNode upload(@RequestParam("file") MultipartFile file
        // ,@PathVariable("folder") String folder
        ) {

        // String filePath = "/image/upload/";

        File savedFile = uploadService.save(file);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", savedFile.getName());
        node.put("size", savedFile.length());
        // node.put("path", filePath);
        // System.out.println("File name sent in response: " + savedFile.getName());
        return node;
    }
}


    // @PostMapping("/rest/upload/{folder}")
    // public JsonNode upload(@PathParam("file") MultipartFile file,
    // @PathVariable("folder") String folder){
    // File savedFile = uploadService.save(file, folder);
    // ObjectMapper mapper = new ObjectMapper();
    // ObjectNode node = mapper.createObjectNode();
    // node.put("name", savedFile.getName());
    // node.put("size", savedFile.length());
    // return node;
    // }