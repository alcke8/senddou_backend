package com.deeplify.table.domain.resumecontent;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.contenttype.ContentIntroduce;
import com.deeplify.table.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ResumeContent extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rc_id")
    private Long rc_id;

    @JoinColumn(name = "ci_id")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private ContentIntroduce contentIntroduce;

    @JsonIgnore
    @JoinColumn(name = "us_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String rc_company;
    private String rc_title;

    @Builder
    public ResumeContent(String company, User user, String title) {
        this.rc_company = company;
        this.user = user;
        this.rc_title = title;
    }

    public void update(String title,String company){
        this.rc_title = title;
        this.rc_company = company;
    }

    ////////
    public void setUser(User user){
        this.user = user;
        user.getResumeContents().add(this);
    }
}