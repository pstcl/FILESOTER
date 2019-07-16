package org.pstcl.ea;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ZZ_SORTED_FILE_MASTER")
public class FileSortedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sortedFileId;

	
	@ManyToOne
	private FileMaster fileMaster;
	
	@Column
	private Integer txtFileCopied;
	
	@Column
	private Integer zipFileCopied;

	public Integer getSortedFileId() {
		return sortedFileId;
	}

	public void setSortedFileId(Integer sortedFileId) {
		this.sortedFileId = sortedFileId;
	}

	public FileMaster getFileMaster() {
		return fileMaster;
	}

	public void setFileMaster(FileMaster fileMaster) {
		this.fileMaster = fileMaster;
	}

	public Integer getTxtFileCopied() {
		return txtFileCopied;
	}

	public void setTxtFileCopied(Integer txtFileCopied) {
		this.txtFileCopied = txtFileCopied;
	}

	public Integer getZipFileCopied() {
		return zipFileCopied;
	}

	public void setZipFileCopied(Integer zipFileCopied) {
		this.zipFileCopied = zipFileCopied;
	}
	
	
}
