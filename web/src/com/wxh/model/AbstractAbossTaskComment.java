package com.wxh.model;

import java.sql.Timestamp;

/**
 * AbstractAbossTaskComment entity provides the base persistence definition of the AbossTaskComment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAbossTaskComment implements java.io.Serializable {

    // Fields    

    private Long      recId;
    private Long      taskId;
    private Long      comUId;
    private String    fileId;
    private String    commentDesc;
    private Timestamp gmtCreate;
    private Timestamp modCreate;

    // Constructors

    /** default constructor */
    public AbstractAbossTaskComment() {
    }

    /** minimal constructor */
    public AbstractAbossTaskComment(String fileId, Timestamp gmtCreate) {
        this.fileId = fileId;
        this.gmtCreate = gmtCreate;
    }

    /** full constructor */
    public AbstractAbossTaskComment(Long taskId, Long comUId, String fileId, String commentDesc,
                                    Timestamp gmtCreate, Timestamp modCreate) {
        this.taskId = taskId;
        this.comUId = comUId;
        this.fileId = fileId;
        this.commentDesc = commentDesc;
        this.gmtCreate = gmtCreate;
        this.modCreate = modCreate;
    }

    // Property accessors

    public Long getRecId() {
        return this.recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getComUId() {
        return this.comUId;
    }

    public void setComUId(Long comUId) {
        this.comUId = comUId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getCommentDesc() {
        return this.commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Timestamp getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getModCreate() {
        return this.modCreate;
    }

    public void setModCreate(Timestamp modCreate) {
        this.modCreate = modCreate;
    }

}