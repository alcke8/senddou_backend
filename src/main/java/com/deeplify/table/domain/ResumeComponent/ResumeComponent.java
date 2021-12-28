package com.deeplify.table.domain.ResumeComponent;

import com.deeplify.table.domain.BaseTimeEntity;
import com.deeplify.table.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class ResumeComponent extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rp_id")
    private Long rp_id;

    @OneToOne(mappedBy = "resumeComponent")
    private Resume resume;

    private int rp_x;
    private int rp_y;
    private int rp_w;
    private int rp_h;

    @Builder
    public ResumeComponent(Resume resume, int x, int y, int w, int h) {
        this.resume = resume;
        this.rp_x = x;
        this.rp_y = y;
        this.rp_w = w;
        this.rp_h = h;
    }

    public void update(int x, int y, int w, int h) {
        this.rp_x = x;
        this.rp_y = y;
        this.rp_w = w;
        this.rp_h = h;

    }
}
