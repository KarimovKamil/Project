package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Specialization;

import java.util.List;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
public interface SpecializationDao {

    int saveSpecialization(Specialization specialization);

    void deleteSpecialization(int id);

    void updateSpecialization(Specialization specialization, int id);

    Specialization getSpecializationById(int id);

    List<Specialization> getAll();
}
