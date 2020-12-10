using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace TCC
{
    class ClasseConexão
    {
        public class Conexao
        {

            static SqlConnection con = new SqlConnection();

            public Conexao()
            {
                con.ConnectionString = "Initial Catalog = Tcc; Integrated Security = true; Data Source = " + Environment.MachineName;
            }

            public SqlConnection Conectar()
            {
                if (con.State == System.Data.ConnectionState.Closed)
                    con.Open();
                return con;
            }

            public void Desconectar()
            {
                if (con.State == System.Data.ConnectionState.Open)
                    con.Close();
            }

        }
    }
}
