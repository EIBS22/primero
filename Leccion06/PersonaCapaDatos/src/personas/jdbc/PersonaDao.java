package personas.jdbc;

import java.sql.SQLException;
import java.util.List;
import personas.dto.PersonaDTO;

/**
 * Esta interfaz contiene los métodos abstractos con las
 * operaciones básicas sobre la tabla de Persona
 * CRUD(Create, Read, Update Delete)
 * Se debe crear una clase concreta para implementar el
 * código asociado a cada método
 * @author Erika
 */

public interface PersonaDao {
    public int insert(PersonaDTO persona) throws SQLException;
    
    public int update(PersonaDTO persona) throws SQLException;
    
    public int delete(PersonaDTO persona) throws SQLException;
    
    public List<PersonaDTO> select() throws SQLException;
}