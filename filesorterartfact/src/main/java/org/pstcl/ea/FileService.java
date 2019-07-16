package org.pstcl.ea;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Component
public class FileService implements InitializingBean {

	@Autowired
	FileMasterEntityRepository entityRepository;

	@Autowired
	FileSortedEntityRepository fileSortedEntityRepository;

	public void cleanFiles()
	{



		Iterable<FileMaster> fileMasters=entityRepository.findAll();


		for (FileMaster fileMaster : fileMasters) {

			FileSortedEntity fileSortedEntity=new FileSortedEntity();
			fileSortedEntity.setFileMaster(fileMaster);
			if(fileMaster.getTxtfileName()!=null)
			{
				fileSortedEntity.setTxtFileCopied(copyTextFile(fileMaster));
			}
			if(fileMaster.getZipfileName()!=null)
			{
				fileSortedEntity.setZipFileCopied(copyZipFile(fileMaster));
			}
			fileSortedEntityRepository.save(fileSortedEntity);
		}
	}


	private Integer copyTextFile(FileMaster fileMaster) {
		Integer sttus=-100;
		File txtFile = new File(fileMaster.getTxtfileName());
		String txtFileName=fileMaster.getTxtfileName().replace("CMRI", "EA2/CMRI");

		File newTxtFile = new File(txtFileName);

		if (!newTxtFile.getParentFile().exists()) {

			newTxtFile.getParentFile().mkdirs();

		}
		if(txtFile.exists())
		{
			try {
				sttus=FileCopyUtils.copy(txtFile,newTxtFile);

				System.out.println(newTxtFile.getAbsolutePath()+" copied");
			} catch (IOException e) {
				e.printStackTrace();
				sttus=-200;
			}

		}
		else
		{
			System.out.println(fileMaster.getTxtfileName()+" text file doesn't exist");
			sttus=-500;
		}
		return sttus;
	}

	private Integer copyZipFile(FileMaster fileMaster) {
		Integer sttus=-100;

		File zipFile = new File(fileMaster.getZipfileName());
		String zipFileName=fileMaster.getZipfileName().replace("CMRI", "EA2/CMRI");
		File newZipFile = new File(zipFileName);
		if (!newZipFile.getParentFile().exists()) {
			newZipFile.getParentFile().mkdirs();
		}
		if(zipFile.exists())
		{
			try {
				sttus=FileCopyUtils.copy(zipFile,newZipFile);
			} catch (IOException e) {
				e.printStackTrace();
				sttus=-200;
			}


		}
		return sttus;
	}


	public void afterPropertiesSet() throws Exception {
		cleanFiles();
	}

}
