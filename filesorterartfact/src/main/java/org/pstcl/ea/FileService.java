package org.pstcl.ea;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Component
public class FileService implements InitializingBean {

	@Autowired
	FileMasterEntityRepository entityRepository;

	@Autowired
	FileMasterEntityRepository2 fileMaster2Repo;


	@Autowired
	FileMasterEntityRepository3 dupfileMaster3Repo;
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
		String txtFileName=fileMaster.getTxtfileName().replace("SLDC_ENERGY_ACC", "SLDC_ENERGY_ACC2");

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
		String zipFileName=fileMaster.getZipfileName().replace("SLDC_ENERGY_ACC", "SLDC_ENERGY_ACC2");
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
		//cleanFiles();
		copyFilesToNewDb1();
	}

	public void copyFilesToNewDb1()
	{
		Iterable<FileMaster> fileMasters=entityRepository.findAll();
		for (FileMaster fileMaster : fileMasters) 
		{
			FileMaster2 fileMaster2=new FileMaster2(fileMaster);
			try {

				fileMaster2Repo.save(fileMaster2);
			}
			catch(DuplicateKeyException duplicateKeyException)
			{
				duplicateKeyException.printStackTrace();
				handleduplicates(fileMaster);
			}

			
		}
	}
	
	private void handleduplicates(FileMaster fileMaster)
	{
		FileMaster2 fileMaster2=new FileMaster2(fileMaster);
		List<FileMaster> duplicateList=entityRepository.findAllByTransactionDateAndMeter(fileMaster.getTransactionDate(),fileMaster.getMeter());
		if(duplicateList.size()>1)
		{
			for (FileMaster duplicate : duplicateList) {
				dupfileMaster3Repo.save(new FileMaster3(duplicate));
				if(fileMaster.getTxnId()<duplicate.getTxnId())
				{
					fileMaster2=new FileMaster2(duplicate);
				}
			}
			fileMaster2Repo.save(fileMaster2);
			
		}

	}
	
	
	public void copyFilesToNewDb()
	{
		Iterable<FileMaster> fileMasters=entityRepository.findAll();
		for (FileMaster fileMaster : fileMasters) 
		{
			FileMaster2 fileMaster2=new FileMaster2(fileMaster);
			List<FileMaster> duplicateList=entityRepository.findAllByTransactionDateAndMeter(fileMaster.getTransactionDate(),fileMaster.getMeter());
			if(duplicateList.size()==1)
			{
				fileMaster2=new FileMaster2(duplicateList.get(0));
			}
			else
			{
				for (FileMaster duplicate : duplicateList) {
					dupfileMaster3Repo.save(new FileMaster3(duplicate));
					if(fileMaster2.getTxnId()<duplicate.getTxnId())
					{
						fileMaster2=new FileMaster2(duplicate);
					}
				}

			}
			try {

				fileMaster2Repo.save(fileMaster2);
			}
			catch(DuplicateKeyException duplicateKeyException)
			{
				duplicateKeyException.printStackTrace();				
			}

		}
	}
}
