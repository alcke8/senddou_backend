package com.deeplify.table.domain.contenttype;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.resumecontent.ResumeContent;
import com.deeplify.table.domain.resumedetail.ResumeDetail;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ContentIntroduce extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ci_id")
    private Long ci_id;

    @JoinColumn(name = "rd_id")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private ResumeDetail resumeDetail;


    @OneToOne(fetch = FetchType.EAGER,mappedBy = "contentIntroduce")
    private ResumeContent resumeContent;

    private String ci_title;

    private String contentType;

    @Builder
    public ContentIntroduce(String title, ResumeContent resumeContent, String contentType) {
        this.ci_title = title;
        this.resumeContent = resumeContent;
        this.contentType = contentType;
    }

    public void update(String title) {

        this.ci_title = title;
    }
}
