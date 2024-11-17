package com.cinquecento.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prm_value")
public class PrmValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TxtVal_C;
    private double Zc;        // Наблюдаемое значение для текущего горизонта
    private double Pc;        // Неопределенность для текущего горизонта
    private double Vc;        // Значимость для текущего горизонта

    private String TxtVal_F;
    private double Zf;        // Наблюдаемое значение для будущего горизонта
    private double Pf;        // Неопределенность для будущего горизонта
    private double Vf;        // Значимость для будущего горизонта

    private String TxtVal_P;
    private double Zp;        // Наблюдаемое значение для перспективы
    private double Pp;        // Неопределенность для перспективы
    private double Vp;        // Значимость для перспективы

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "param_id")
    private Param param;     // Ссылка на параметр

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analyze_obj_id")
    private AnalyzeObj analyzeObj;
}

