package com.Modelo;

import com.Configuracion.Conexion;
import com.Interfaces.InterfaceCrudEstudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstudianteDao implements InterfaceCrudEstudiante {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List ListarEstudiantes() {
        List<Estudiante> estudiantesList = new ArrayList<>();

        try {
            con = cn.getConexion();
            String selectAllEstudiantes = "SELECT * FROM estudiantes";
            ps = con.prepareStatement(selectAllEstudiantes);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setFechaCreacion(rs.getString("FechaCreacion"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
                estudiantesList.add(estudiante);

            }

        } catch (SQLException e) {
            System.err.println("Fallo la conexion" + e);
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);

        }
        return estudiantesList;

    }

    @Override
    public Estudiante selectEstudiante(int id) {
        Estudiante estudiante = new Estudiante();
        try {
            con = cn.getConexion();
            String consultaEstudiantePorIdSql = "SELECT * FROM estudiantes WHERE id=?";
            ps = con.prepareStatement(consultaEstudiantePorIdSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
                estudiante.setFechaCreacion(rs.getString("FechaCreacion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return estudiante;

    }

    @Override
    public boolean create(Estudiante estudiante) {
        try {
            con = cn.getConexion();
            String consultaGuardarEstudianteSql = "INSERT INTO estudiante ( nombres, apellido, celular, documento, fechaCreacion";
            ps = con.prepareStatement(consultaGuardarEstudianteSql);
            ps.setString(2, estudiante.getNombres());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getCelular());
            ps.setString(5, estudiante.getDocumento());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDao.class.getName());
            return Boolean.FALSE;

        }

    }

    @Override
    public boolean update(Estudiante estudiante) {
        try {
            con = cn.getConexion();
            String consultaActualizarEstudianteSql = "UPDATE estudiamte SET nombres=?, apellidos=?, celular=?, documento=?";
            ps = con.prepareStatement(consultaActualizarEstudianteSql);
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getCelular());
            ps.setString(4, estudiante.getDocumento());
            ps.setInt(5, estudiante.getId());
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }

    }

    @Override
    public boolean delete(int id) {
        
        try{
            con = cn.getConexion();
            String consultaEliminarEstudianteSql = "DELETE FROM estudiantes WHERE id=?";
            ps.setInt(1, id);
            ps = con.prepareStatement(consultaEliminarEstudianteSql);
            ps.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
            
            }
        }
    }
