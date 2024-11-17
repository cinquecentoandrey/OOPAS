package com.cinquecento.model.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "analyze_obj")
public class AnalyzeObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Название анализируемого объекта, например, "Фабрика"

    @OneToOne
    @JoinColumn(name = "swot_id")
    private SWOT swot;  // Ссылка на SWOT-анализ, связанный с этим объектом

    @OneToMany(mappedBy = "analyzeObj", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrmValue> prmValues;

}
