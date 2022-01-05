package com.deeplify.table.domain.resumedetail;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.contenttype.ContentIntroduce;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ResumeDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rd_id")
    private Long rd_id;


    @OneToOne(mappedBy = "resumeDetail",fetch = FetchType.EAGER)
    private ContentIntroduce contentIntroduce;

    private String rd_title;
    private String rd_content;

    @Builder
    public ResumeDetail(ContentIntroduce contentIntroduce, String title, String content) {
        this.contentIntroduce = contentIntroduce;
        this.rd_title = title;
        this.rd_content = content;
    }

    public void update(String title, String content) {
        this.rd_title = title;
        this.rd_content = content;
    }


}
