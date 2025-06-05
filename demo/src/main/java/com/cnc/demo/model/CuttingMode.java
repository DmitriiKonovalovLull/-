package com.cnc.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cutting_modes")
public class CuttingMode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cutting_speed", nullable = false)
    private double cuttingSpeed;

    @Column(name = "feed", nullable = false)
    private double feed;

    @Column(name = "depth", nullable = false)
    private double depth;

    @Column(name = "spindle_speed")
    private Double spindleSpeed;

    @ManyToMany
    @JoinTable(
            name = "cutting_mode_materials",
            joinColumns = @JoinColumn(name = "cutting_mode_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Material> materials = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cutting_mode_tools",
            joinColumns = @JoinColumn(name = "cutting_mode_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Tool> tools = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cutting_mode_diameters",
            joinColumns = @JoinColumn(name = "cutting_mode_id"),
            inverseJoinColumns = @JoinColumn(name = "set_diametr_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<SetDiametr> setDiameters = new HashSet<>();

    // Удобный метод для добавления диаметра
    public void addDiameter(SetDiametr diametr) {
        this.setDiameters.add(diametr);
    }

    // Удобный метод для добавления материала
    public void addMaterial(Material material) {
        this.materials.add(material);
    }

    // Удобный метод для добавления инструмента
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    public void setDiameter(Double diameter) {
    }
}
