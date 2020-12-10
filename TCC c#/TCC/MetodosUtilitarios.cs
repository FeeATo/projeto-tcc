using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TCC
{
    class MetodosUtilitarios
    {

        string connectionString = ConnectionString.StringConexao();
        SqlConnection sqlCon;
        string output;

        //
        //
        //QUANTIDADES
        //
        //

        public int UsuarioQntd()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(*) from usuario";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }

        public int PrestServQntd()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(*) from PrestServ";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }

        public int AdmQntd()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(*) from ADM";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }
                
        public int ServicoQntd()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(*) from Servico";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }

        //pega quantidade de msgs para aparecer a quantidade na aba
        public int MsgQntd()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(id) from msg";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }

            return int.Parse(output);
        }

        //
        //
        //Selects
        //
        //

        // - Últimos dados

        public int UltimoUsuario()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select top 1 id_usu from Usuario order by id_usu desc";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }

        public int UltimoPrestServ()
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select top 1 id_prestserv from PrestServ order by id_prestserv desc";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            sqlCon.Close();
            return int.Parse(output);
        }

        // - Selections

        public string SelectAdmPasswordByLoginName(string loginName)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select senha from ADM where login_adm='" + loginName + "'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr["senha"].ToString();
            }
            sqlCon.Close();
            return output;
        }

        public string GetNameByLoginName(string loginName)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select nome from ADM where login_adm='" + loginName + "'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr["nome"].ToString();
            }
            sqlCon.Close();
            output = output.Replace(" ", "");
            return output;
        }

        //
        //Deletar
        //

        //deleta os dados de acordo com o ID e a tabela

        public string DeleteByID(int id, string table)
        {
            string propriedade = "";
            string msg = "";

            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            if (table == "PrestServ")
            {
                propriedade = "id_prestserv";
                msg = "Prestador de serviço";
            }
            if (table == "Usuario")
            {
                propriedade = "id_usu";
                msg = "Usuário";
            }
            if(table == "ADM")
            {
                propriedade = "id_adm";
                msg = "ADM";
            }
            if(table == "Servico")
            {
                propriedade = "id_servico";
            }
            string query = "delete from " + table + " where " + propriedade + "='" + id.ToString() + "'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            int delete = cmd.ExecuteNonQuery();
            sqlCon.Close();
            if (delete > 0)
            {
                return msg + "deletado com sucesso!";
            }
            else
                return "error";
        }
                
        //Verificar se ja tem ADM

        public string VerificLoginExistenceByLogin(string login)
        {
            sqlCon = new SqlConnection(connectionString);
            string query = "select count(login_adm) from ADM where login_adm = '"+login+"'";
            sqlCon.Open();
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }

            sqlCon.Close();
            return output;
        }

        
    }
}
