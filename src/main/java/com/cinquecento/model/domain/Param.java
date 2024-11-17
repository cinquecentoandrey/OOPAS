package com.cinquecento.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "param")
public class Param {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private double Kc;         // Коэффициент для текущего горизонта
    private double Kf;         // Коэффициент для будущего горизонта
    private double Kp;         // Коэффициент для перспективы

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swot_dir_id")
    private SWOTDir swotDir;

    @OneToMany(mappedBy = "param", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrmValue> prmValues;  // Связь с таблицей PrmValue
}
