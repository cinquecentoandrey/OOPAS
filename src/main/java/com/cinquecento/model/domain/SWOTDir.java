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
@Table(name = "swot_dir")
public class SWOTDir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Название направления SWOT (например, "Сила", "Слабость")

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swot_id")
    private SWOT swot;  // Ссылка на объект SWOT

    @OneToMany(mappedBy = "swotDir", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Param> params;

}
