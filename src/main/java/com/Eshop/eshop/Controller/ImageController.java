package com.Eshop.eshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class ImageController {
//    ImageService imageService;
//
//    public ImageController(ImageService imageService) {
//        this.imageService = imageService;
//    }
//
//    @PostMapping("/image")
//    private ResponseEntity<?> addImage(@RequestParam("image") MultipartFile file) throws IOException {
//        byte [] imageData =imageService.addImage(file);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//             }
//
//    @GetMapping("/image/{imageName}")
//    private ResponseEntity<?> getImageByName(@PathVariable String imageName) {
//        byte [] imageData =imageService.getImageByImageName(imageName);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//
//    }
}
