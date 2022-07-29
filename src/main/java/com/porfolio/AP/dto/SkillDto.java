package com.porfolio.AP.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SkillDto {
    @NotBlank
    private String skill;
    @NotNull
    @Min(0) @Max(100)
    private float nivel;

    @NotBlank
    private String img;

    //constructores

    public SkillDto() {
    }

    public SkillDto(String skill, float nivel, String img) {
        this.skill = skill;
        this.nivel = nivel;
        this.img = img;
    }

    //getter&setter

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public float getNivel() {
        return nivel;
    }

    public void setNivel(float nivel) {
        this.nivel = nivel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
