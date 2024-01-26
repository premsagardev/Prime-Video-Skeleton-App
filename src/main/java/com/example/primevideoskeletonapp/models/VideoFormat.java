package com.example.primevideoskeletonapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VideoFormat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatId; // Primary Key

    private String resolution; // e.g., 360p, 720p

    private String videoUrl; // AWS S3 URL or a reference to the transcoded video file

    @ManyToOne
    @JoinColumn(name = "video_videoId")
    private Video video;
}
