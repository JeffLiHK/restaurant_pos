package pkpd.restaurant.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {
    public static String saveImage(MultipartFile multipartFile,String path) throws IOException {
        //
        File filePath = new File(path);
        //，
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        String rootFileName = multipartFile.getOriginalFilename();
        String suffix =  rootFileName.substring(rootFileName.lastIndexOf(".")+1);
        String fileName = UUID.randomUUID() +"."+suffix;
        //
        File file = new File(path+File.separator+fileName);
        multipartFile.transferTo(file);
        return fileName;
    }
}
