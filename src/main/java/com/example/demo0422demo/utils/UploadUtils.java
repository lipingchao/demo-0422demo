package com.example.demo0422demo.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * The type Upload utils.
 *
 * @author AUSUA
 */
@Component
public class UploadUtils {
    /**
     * 固定长传路径至resources/upload文件夹
     *
     * @param file the file
     * @return string
     */
    public static String upload(MultipartFile file) {
        try {
            if (file.getSize() > 0) {
                String path = getFileUrl();
                String newFileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                newFileName = newFileName.replaceAll("%20", " ");
                String pathName = path + "/upload/" + newFileName;
                System.out.println(pathName);
                File file2 = new File(pathName);
                System.out.println(path);
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                    file2.createNewFile();
                }
                file.transferTo(file2);
                path=path+"/upload";
                String s = fileNameCl(newFileName, path);
                System.out.println(s);
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 根据路径进行上传
     *
     * @param file          the file
     * @param specifiedPath the specified path
     * @return string
     */
    public static String ToFileUrlUpload(MultipartFile file, String specifiedPath) {
        try {
            String extName = file.getOriginalFilename();
            if (extName.lastIndexOf(".") <= 0) {
                throw new RuntimeException("不支持该文件类型");
            }
            extName = extName.substring(extName.lastIndexOf("."));
            String fileName = getUUID();
            fileName = getUUID() + extName;
            File file2 = new File(specifiedPath);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file.transferTo(new File(specifiedPath + File.separator + fileName));
            String s = fileNameCl(fileName, specifiedPath);
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String fileNameCl(String fileName, String url) {
        String s = url.replaceAll("\\\\", "/");
        s = s.replaceAll("//", "/");
        String substring = s.substring(2);
        String[] split = substring.split("/");
        if (split.length <= 2) {
            return "/" + split[1] + "/" + fileName;
        }
        return "/" + split[1] + "/" + split[split.length - 1] + "/" + fileName;
    }

    private static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid.toLowerCase();
    }

    private static String getFileUrl() {
        String path = null;
        try {
            String firstPath = ResourceUtils.getURL("classpath:").getPath();
            String c = "\\target\\classes";
            path = firstPath.substring(0, firstPath.length() - c.length());
            path = path + "src/main/resources/static";
            path = path.replaceAll("%20", " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 给拦截器提供短路径
     *
     * @return string
     */
    public static String DuanUrl(){
        String s = fileNameCl(null, getFileUrl());
        s=s.split("/")[1];
        s="/"+s+"/**";
        return s;
    }

    /**
     * 给拦截器提供长路径
     *
     * @return string
     */
    public static String LongUrl(){
        String fileUrl = getFileUrl();
        fileUrl=fileUrl.substring("/".length());
        fileUrl=fileUrl+"/upload";
        return fileUrl;
    }


}