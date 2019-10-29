package com.spring.mvcboard.commons.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;

public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	//파일 업로드 처리
	public static String uploadFile(MultipartFile file, HttpServletRequest request) throws Exception{
		
		String originalFileName = file.getOriginalFilename();	//파일명
		byte[] fileData = file.getBytes();	//파일 데이터
		
		// 1. 파일명 중복 처리
		String uuidFileName = getUuidFileName(originalFileName);
		
		// 2. 파일 업로드 경로 설정
		String rootPath = getRootPath(originalFileName, request);	//기본경로 추출(이미지 or 일반파일)
		String dataPath = getDatePath(rootPath);	//날짜 경로 추출, 날짜 폴더 생성
		
		// 3. 서버에 파일 저장
		File target = new File(rootPath + dataPath, uuidFileName);	//파일 객체 생성
		FileCopyUtils.copy(fileData, target);	//파일 객체에 파일 데이터 복사
		
		// 4. 이미지 파일인 경우 썸네일이미지 생성
		if (MediaUtils.getMediaType(originalFileName) != null){
			uuidFileName = makeThumnail(rootPath, dataPath, uuidFileName);
		}
		
		//5. 파일 저장 경로 치환
		return replaceSavedFilePath(dataPath, uuidFileName);
	}
	
	
	//기본 경로 추출
	public static String getRootPath(String fileName, HttpServletRequest request) throws Exception{
		
		String rootPath = "/resources/upload";
		MediaType mediaType = MediaUtils.getMediaType(fileName);	//파일타입 확인
		
		if(mediaType != null){
			//이미지 파일 경로
			return request.getSession().getServletContext().getRealPath(rootPath + "/images");
		}
		
		return request.getSession().getServletContext().getRealPath(rootPath + "/files"); // 일반파일 경로
	}
	
	//날짜 폴더명 추출
	private static String getDatePath(String uploadPath){
		
		Calendar calendar = Calendar.getInstance();
		
		String yearPath = File.separator + calendar.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
	    String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));
	    
	    makeDateDir(uploadPath, yearPath, monthPath, datePath);
	    
	    return datePath;
	}
	
	//날짜별 폴더 생성
	private static void makeDateDir(String uploadPath, String...paths){
		
		//날짜별 폴더가 이미 존재하여 메서드 종료
		if(new File(uploadPath + paths[paths.length -1]).exists()){
			return;
		}
		
		for(String path : paths){
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()){
				dirPath.mkdir();
			}
		}
	}
	
	//파일명 중복방지 처리
	private static String getUuidFileName(String originalFileName){
		return UUID.randomUUID().toString() + "_" + originalFileName;
	}
	
	//파일 저장 경로 치환
	private static String replaceSavedFilePath(String datePath, String fileName){
		String savedFilePath = datePath + File.separator + fileName;
		return savedFilePath.replace(File.separatorChar, '/');
	}
	
	//썸네일 이미지 생성
	private static String makeThumnail(String uploadRootPath, String datePath, String fileName) throws Exception{
		
		//원본이미지를 메모리상에 로딩
		BufferedImage originalImg = ImageIO.read(new File(uploadRootPath + datePath, fileName));		
		//원본 이미지를 축소
		BufferedImage thumnailImg = Scalr.resize(originalImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);		
		//썸네일 파일명
		String thumnailImgName = "s_" + fileName;
		//썸네일 업로드 경로
		String fullPath = uploadRootPath + datePath + File.separator + thumnailImgName;
		//썸네일 파일 객체생성
		File newFile = new File(fullPath);
		//썸네일 파일 확장자 추출
		String formatName = MediaUtils.getFormatName(fileName);
		//썸네일 파일 저장
		ImageIO.write(thumnailImg, formatName, newFile);
		
		return thumnailImgName;
		
		
	}

}
