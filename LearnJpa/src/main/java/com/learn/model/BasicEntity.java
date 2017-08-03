package com.learn.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by mshalabi on 03.08.17.
 */
@MappedSuperclass
public class BasicEntity {

    @JsonView(View.Detailed.class)
    @CreatedDate
    protected Date creationDate;

    @JsonView(View.Detailed.class)
    @LastModifiedDate
    protected Date modifiedDate;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
