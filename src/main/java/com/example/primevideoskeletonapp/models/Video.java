package com.example.primevideoskeletonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long videoId;

    private String title;

    private String url;

    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "uploadedBy_userId")
    private User uploadedBy;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<VideoFormat> formats;

}
