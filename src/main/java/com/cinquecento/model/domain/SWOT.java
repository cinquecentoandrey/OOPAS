package com.cinquecento.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "swot")
public class SWOT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Название SWOT-анализа

    @OneToMany(mappedBy = "swot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SWOTDir> swotDirs;  // Направления SWOT

    @OneToOne(mappedBy = "swot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AnalyzeObj analyzeObj;
}
