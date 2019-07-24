package org.pstcl.ea;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "file_master_eap_old")
public class FileMaster {



	@Column
	@CreationTimestamp
	private Date createDateTime;

	@Column
	private Integer dailyRecordCount;

	@Column
	private Integer dailyRecordNoEnd;

	@Column
	private Integer dailyRecordNoStart;

	@Column(name="METER_ID")
	private String meter;
	

	@Column
	private Integer fileActionStatus;



	@Column
	private Integer fileType;




	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	@Column
	private Integer processingStatus;

	
	public Integer getTamperLogCount() {
		return tamperLogCount;
	}

	public void setTamperLogCount(Integer tamperLogCount) {
		this.tamperLogCount = tamperLogCount;
	}

	public Integer getTamperLogNoEnd() {
		return tamperLogNoEnd;
	}

	public void setTamperLogNoEnd(Integer tamperLogNoEnd) {
		this.tamperLogNoEnd = tamperLogNoEnd;
	}

	public Integer getTamperLogNoStart() {
		return tamperLogNoStart;
	}

	public void setTamperLogNoStart(Integer tamperLogNoStart) {
		this.tamperLogNoStart = tamperLogNoStart;
	}

	@Column
	private Integer tamperLogCount;

	@Column
	private Integer tamperLogNoEnd;

	@Column
	private Integer tamperLogNoStart;
	
	@Column
	private Integer surveyRecordCount;

	@Column
	private Integer surveyRecordNoEnd;

	@Column
	private Integer surveyRecordNoStart;


	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date transactionDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txnId;

	@Column
	private String txtfileName;

	@Column
	@UpdateTimestamp
	private Date updateDateTime;

	@Column
	private String userfileName;

	@Column
	private String zipfileName;




	public Date getCreateDateTime() {
		return createDateTime;
	}

	public Integer getDailyRecordCount() {
		return dailyRecordCount;
	}

	public Integer getDailyRecordNoEnd() {
		return dailyRecordNoEnd;
	}

	public Integer getDailyRecordNoStart() {
		return dailyRecordNoStart;
	}

	public Integer getFileActionStatus() {
		return fileActionStatus;
	}


	public Integer getFileType() {
		return fileType;
	}



	public Integer getProcessingStatus() {
		return processingStatus;
	}

	public Integer getSurveyRecordCount() {
		return surveyRecordCount;
	}

	public Integer getSurveyRecordNoEnd() {
		return surveyRecordNoEnd;
	}




	public Integer getSurveyRecordNoStart() {
		return surveyRecordNoStart;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public Integer getTxnId() {
		return txnId;
	}

	public String getTxtfileName() {
		return txtfileName;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}




	public String getUserfileName() {
		return userfileName;
	}

	public String getZipfileName() {
		return zipfileName;
	}


	

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setDailyRecordCount(Integer dailyRecordCount) {
		this.dailyRecordCount = dailyRecordCount;
	}



	public void setDailyRecordNoEnd(Integer dailyRecordNoEnd) {
		this.dailyRecordNoEnd = dailyRecordNoEnd;
	}

	public void setDailyRecordNoStart(Integer dailyRecordNoStart) {
		this.dailyRecordNoStart = dailyRecordNoStart;
	}

	public void setFileActionStatus(Integer fileActionStatus) {
		this.fileActionStatus = fileActionStatus;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public void setProcessingStatus(Integer processingStatus) {
		this.processingStatus = processingStatus;
	}



	public void setSurveyRecordCount(Integer surveyRecordCount) {
		this.surveyRecordCount = surveyRecordCount;
	}

	public void setSurveyRecordNoEnd(Integer surveyRecordNoEnd) {
		this.surveyRecordNoEnd = surveyRecordNoEnd;
	}

	public void setSurveyRecordNoStart(Integer surveyRecordNoStart) {
		this.surveyRecordNoStart = surveyRecordNoStart;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public void setTxtfileName(String txtfileName) {
		this.txtfileName = txtfileName;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public void setUserfileName(String userfileName) {
		this.userfileName = userfileName;
	}

	public void setZipfileName(String zipfileName) {
		this.zipfileName = zipfileName;
	}



}
