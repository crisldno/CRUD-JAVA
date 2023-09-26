package com.Interfaces;

import com.Modelo.Estudiante;
import java.util.List;

public interface InterfaceCrudEstudiante {

    public List ListarEstudiantes();

    public Estudiante selectEstudiante(int id);

    public boolean create(Estudiante estudiante);

    public boolean update(Estudiante estudiante);

    public boolean delete(int id);

}
