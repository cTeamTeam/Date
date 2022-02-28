package com.date.jum5.user.review.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.date.jum5.user.review.vo.ReviewVo;

@Component("fileUtils")
public class FileUtils {

	private static final String FILE_PATH = "C:/Users/ehdrm/git/date2/date/date/src/main/webapp/resources/metchImages/";
	
	public List<Map<String , Object>> parselnsertFileInfo(ReviewVo vo, MultipartHttpServletRequest request) throws Exception {
		
		Iterator<String> iterator = request.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String , Object>> list = new ArrayList<Map<String , Object>>();
		
		Map<String , Object> listMap = null;
		
		int seq = vo.getSeq();
		
		File file = new File(FILE_PATH);
			if(file.exists() == false) {
				file.mkdirs();
			}
			
		while(iterator.hasNext())	{
			multipartFile = request.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				file = new File(FILE_PATH + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("SEQ", seq);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
			}	
		}
//		if(files != null && fileNames != null){ 
//			for(int i = 0; i<fileNames.length; i++) {
//					listMap = new HashMap<String,Object>();
//                    listMap.put("IS_NEW", "N");
//					listMap.put("FILE_NO", files[i]); 
//					list.add(listMap); 
//			}
//		}
		return list;
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}

}