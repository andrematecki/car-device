package br.com.fiap.am.sqlhelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class SqlHelper {

    public Connection conexao;

    // ----------- ORACLE ---------------
    String url = "jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL";
    //String url = "jdbc:oracle:thin:@187.109.40.145:1521:ORCL";
    String login = "OPS$RM";
    String senha = "";


    /* ---------- SQL Server --------------
    private String string = "jdbc:sqlserver://localhost;databaseName=Sql_Server_Dao;user=sa;password=dba";
    */


    public Object executeScalar(String comando){
    	return executeScalar(comando, null);
    }

    public Object executeScalar(String comando, Parametro[] parametros){
    	 Object retorno = null;
         try
         {
             abrirConexao();
             PreparedStatement p = this.buildCommand(comando, parametros);
             ResultSet rs = p.executeQuery();
             if(rs.next()){
            	 retorno = rs.getObject(1);
             }
         }
         catch(SQLException e)
         {

         }
         finally
         {
             fecharConexao();
         }

         return retorno;
    }


    public <T> ArrayList<T> executeCollection(String cmd, Class<?> clazz){
    	return executeCollection(cmd, null, clazz);
    }

    public <T> ArrayList<T> executeCollection(String cmd, Parametro[] parametros, Class<?> clazz){
    	ArrayList<HashMap<String, Object>> result = executeComand(cmd, parametros);
    	ArrayList<T> list = null;

		try {
			if(result.size() > 0){
				list = new ArrayList<T>();

				for(HashMap<String, Object> item : result){
					T obj = (T)clazz.newInstance();
			        ((IDao)obj).bind(item);
			        list.add(obj);
				}
	    	}
		} catch (InstantiationException | IllegalAccessException e) {

		}
		return list;

    }


    public <T> T executeObject(String cmd, Class<?> clazz){
    	return executeObject(cmd, null, clazz);
    }

    public <T> T executeObject(String cmd, Parametro[] parametros, Class<?> clazz)
    {
    	ArrayList<HashMap<String, Object>> result = executeComand(cmd, parametros);
    	T obj = null;
		try {
			if(result.size() > 0){
				obj = (T)clazz.newInstance();
		        ((IDao)obj).bind(result.get(0));
	    	}
		} catch (InstantiationException | IllegalAccessException e) {

		}
		return obj;
    }


    public int executeUpdate(String comando)
    {
        return this.executeUpdate(comando, null);
    }

    public int executeUpdate(String comando, Parametro[] parametros)
    {
        int retorno = 0;
        try
        {
            abrirConexao();
            PreparedStatement p = this.buildCommand(comando, parametros);
            retorno = p.executeUpdate();
        }
        catch(SQLException e)
        {

        }
        finally
        {
            fecharConexao();
        }

        return retorno;
    }


    private ArrayList<HashMap<String, Object>> executeComand(String cmd, Parametro[] parametros){
    	ArrayList<HashMap<String, Object>> result = new ArrayList<>();
    	abrirConexao();
    	PreparedStatement ps = buildCommand(cmd, parametros);
    	try {
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();


			while(rs.next()){

				HashMap<String, Object> row = new HashMap<>();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					String nome = rsmd.getColumnName(i);
					Object obj = rs.getObject(i);
					row.put(nome, obj);
				}
				result.add(row);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally{
    		fecharConexao();
    	}

    	return result;
    }

    private PreparedStatement buildCommand(String cmd)
    {
        return this.buildCommand(cmd, null);
    }

    private PreparedStatement buildCommand(String cmd, Parametro[] parametros)
    {
        PreparedStatement ps = null;

        try
        {
            ps = conexao.prepareStatement(cmd);

            if(parametros != null)
                for(Parametro parametro : parametros)
                    ps.setObject(parametro.getIndexParametro(), parametro.getParametro());

        }
        catch(SQLException e)
        {

        }

        return ps;
    }

    private void abrirConexao()
    {
        try
        {
            /* ------------- SQL Server ---------------
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexao = DriverManager.getConnection(string);
            */

            // ------------- OARACLE ----------------
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(url, login, senha);

        }
        catch(ClassNotFoundException | SQLException e)
        {

        }
    }

    private void fecharConexao()
    {
        try
        {
            if(!conexao.isClosed())
                conexao.close();
        }
        catch(SQLException e)
        {

        }
    }
}
