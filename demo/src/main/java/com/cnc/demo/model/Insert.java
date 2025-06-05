package com.cnc.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "inserts")
public class Insert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String name;

    private String manufacturer;

    private String coating;

    // Поле material — здесь, судя по всему, это строка с описанием материала,
    // а связь с таблицей material через Set<Material> — отдельное поле.
    private String material;

    @Column(name = "cutting_edge_strenght")
    private BigDecimal cuttingEdgeStrength;

    @Column(name = "recommended_feed_min")
    private BigDecimal recommendedFeedMin;

    @Column(name = "recommended_feed_max")
    private BigDecimal recommendedFeedMax;

    @Column(name = "recommended_vc_min")
    private BigDecimal recommendedVcMin;

    @Column(name = "recommended_vc_max")
    private BigDecimal recommendedVcMax;

    @ManyToMany
    @JoinTable(
            name = "insert_tool",
            joinColumns = @JoinColumn(name = "insert_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_id")
    )
    private Set<Tool> tools;

    @ManyToMany
    @JoinTable(
            name = "insert_material",
            joinColumns = @JoinColumn(name = "insert_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private Set<Material> materials;
}
