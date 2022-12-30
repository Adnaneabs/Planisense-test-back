package com.test.test_planisense_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Trees")
public class Tree {
    @Id
    @Column(name = "IDBASE", nullable = false)
    private Long idBase;
    @Column(name = "TYPE EMPLACEMENT")
    private String typeEmplacement;

    @Column(name = "DOMINALITE")
    private String domanialite;
    @Column(name = "ARRONDISSEMENT")
    private String arrondissement;

    @Column(name = "COMPLEMENT ADRESSE")
    private String complementAdresse;

    @Column(name = "NUMERO")
    private Long numero;

    @Column(name = "LIEU/ADRESSE")
    private String adresse;
    @Column(name = "IDEMPLACEMENT")
    private String idEmplacement;
    @Column(name = "LIBELLE FRANCAIS")
    private String libelle;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "ESPECE")
    private String espece;
    @Column(name = "VARIETE")
    private String variete;
    @Column(name = "CIRCONFERENCE")
    private int circonference;
    @Column(name = "HAUTEUR")
    private int hauteur;
    @Column(name = "DEVELOPPEMENT")
    private String developpement;
    @Column(name = "REMARQUABLE")
    private String remarquable;

    @Column(name = "geo_point_2d")
    private String geo_point_2D;
    public Tree() {
    }

    @Override
    public String toString() {
        return "Tree{" +
                "idBase=" + idBase +
                ", typeEmplacement='" + typeEmplacement + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", idEmplacement='" + idEmplacement + '\'' +
                ", libelle='" + libelle + '\'' +
                ", genre='" + genre + '\'' +
                ", espece='" + espece + '\'' +
                ", variete='" + variete + '\'' +
                ", circonference=" + circonference +
                ", hauteur=" + hauteur +
                ", developpement='" + developpement + '\'' +
                ", remarquable='" + remarquable + '\'' +
                ", geo_point_2d='" + geo_point_2D + '\'' +
                '}';
    }
}
