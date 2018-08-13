package com.sdrc.sdrchub.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sdrc.sdrchub.domain.AttachmentDetails;
import com.sdrc.sdrchub.domain.EntryDetails;
import com.sdrc.sdrchub.domain.TypeDetails;
import com.sdrc.sdrchub.models.FileModel;
import com.sdrc.sdrchub.models.UserModel;
import com.sdrc.sdrchub.repository.AttachmentDetailsRepository;
import com.sdrc.sdrchub.repository.SaveEntryDataRepository;
import com.sdrc.sdrchub.repository.TypeDetailsRepository;
import com.sdrc.sdrchub.repository.UserRepository;



@Service	
public class DataEntryServiceImpl implements DataEntryService {

	@Autowired
	SaveEntryDataRepository saveEntryDataRepository;
	
	@Autowired
	TypeDetailsRepository typeDetailsRepository;
	
	@Autowired
	UserRepository UserRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	AttachmentDetailsRepository attachmentDetailsRepository;
	
	@Override
	public String saveData(EntryDetails entryData) throws Exception {
		// TODO Auto-generated method stub
		EntryDetails currentSubmission=null;
		if(entryData.getCreatedDate() == null)
			entryData.setCreatedDate(new Timestamp(new Date().getTime()));
		entryData.setUpdatedDate(new Timestamp(new Date().getTime()));
		entryData.setLive(true);
		
		EntryDetails entryDetailsData = new EntryDetails();
		Field[] fields = entryData.getClass().getDeclaredFields();
	
		for (Field field : fields) {
			if(field.getName() != "documents"){
				field.setAccessible(true);
				Field entryDetailsField = entryDetailsData.getClass().getDeclaredField(field.getName());
				entryDetailsField.setAccessible(true);
				entryDetailsField.set(entryDetailsData, field.get(entryData));
			}
	    }
		
		currentSubmission = saveEntryDataRepository.save(entryDetailsData);
//		uploadFiles(entryData, currentSubmission.getId());

		
		return currentSubmission.getId().toString();
	}
	
	
	@Override
	public String uploadFiles(EntryDetails entryData, Integer referenceId) throws Exception {
		
		
		UserModel user = (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		AttachmentDetails attachment =null;
		FileModel fileModel = entryData.getDocuments();
		List<AttachmentDetails> duplicateAttachment = attachmentDetailsRepository.findByReferenceEntryIdAndDocumentName(referenceId, fileModel.getFileName());
		if (!fileModel.getIsAttached()) {
			if (fileModel.getIsDeleted()) {
				AttachmentDetails attached = attachmentDetailsRepository.findById(fileModel.getAttachmentId());
				if (attached != null) {
					attached.setDeleted(fileModel.getIsDeleted());
					attachmentDetailsRepository.save(attached);

				}
			} else {

				if (duplicateAttachment.isEmpty()) {
					attachment = new AttachmentDetails();
					attachment = new AttachmentDetails();
					attachment.setAttached(true);
					attachment.setDeleted(false);
					attachment.setDocumentName(fileModel.getFileName());
					attachment.setFilePath(getFilePath(fileModel, user,
							entryData));
//					attachment.setHashCode(fileModel.getBase64().hashCode());
					attachment.setReferenceEntryId(referenceId);
					attachmentDetailsRepository.save(attachment);
				}
			}
		}else{
			if(fileModel.getIsDeleted()){
				attachment = attachmentDetailsRepository.findById(fileModel.getAttachmentId());
				if(attachment!=null){
					attachment.setDeleted(fileModel.getIsDeleted());
					attachmentDetailsRepository.save(attachment);
				}
			}
		}
		
		return "success";
	}



	
	
	private String getFilePath(FileModel fileModel, UserModel user, EntryDetails entryData) throws IOException {

		

		if (fileModel.getBase64() != null) {

			String userPath = null;

//			User userDomain = UserRepository.findByUserName(user.getUsername());

			userPath = messageSource.getMessage("dataentry.user.filepath", null, null) + entryData.getModuleName() + "/" + entryData.getPlatformName()
					+ user.getUsername() +"/";

			File file = new File(userPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			byte[] decodedBytes = Base64.decodeBase64(fileModel.getBase64());

			String finalPath = userPath + FilenameUtils.removeExtension(fileModel.getFileName()) + "_"
					+ new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new java.util.Date()) + "."
					+ (FilenameUtils.getExtension(fileModel.getFileName()));

			file = new File(finalPath);
			FileUtils.writeByteArrayToFile(file, decodedBytes);

			return finalPath;

		} else
			return null;

	}
	@Override
	public List<TypeDetails> getModulesAndPlatforms() throws Exception {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 2);
//		return typeDetailsRepository.findByTypeLevelId(list);
		return typeDetailsRepository.getTypeLevelId(list);
	}
}
