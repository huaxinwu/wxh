package com.wxh.model;

import java.sql.Timestamp;

/**
 * AbossTaskComment entity. @author MyEclipse Persistence Tools
 */
public class AbossTaskComment extends AbstractAbossTaskComment implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public AbossTaskComment() {
    }

    /** minimal constructor */
    public AbossTaskComment(String fileId, Timestamp gmtCreate) {
        super(fileId, gmtCreate);
    }

    /** full constructor */
    public AbossTaskComment(Long taskId, Long comUId, String fileId, String commentDesc,
                            Timestamp gmtCreate, Timestamp modCreate) {
        super(taskId, comUId, fileId, commentDesc, gmtCreate, modCreate);
    }

}
