package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Peso;

public class PesoDAO {
   
    public boolean save(Peso p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO PESO (\"peso\",\"fornecedor\",\"nf\",\"motorista\",\"cavalo\",\"carreta\",\"obs\",\"produto\",\"campo\",\"variedade\",\"lote\",\"hora\",\"operador\",\"ini_fim\",\"liquido\",\"tara\",\"qtdnota\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getPeso());
            stmt.setString(2, p.getFornecedor());
            stmt.setString(3, p.getNf());
            stmt.setString(4, p.getMotorista());
            stmt.setString(5, p.getCavalo());
            stmt.setString(6, p.getCarreta());
            stmt.setString(7, p.getObs());
            stmt.setString(8, p.getProduto());
            stmt.setString(9, p.getCampo());
            stmt.setString(10, p.getVariedade());
            stmt.setString(11, p.getLote());
            stmt.setString(12, p.getHora());
            stmt.setString(13, p.getOperador());
            stmt.setString(14, p.getIni_fim());
            stmt.setString(15, p.getLiquido());
            stmt.setString(16, p.getTara());
            stmt.setString(17, p.getQtdNF());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
