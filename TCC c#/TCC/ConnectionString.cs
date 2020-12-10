using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TCC
{
    class ConnectionString
    {
        public static string StringConexao()
        {
            return "Password=etesp; Persist Security Info=True; User ID=sa; Initial Catalog=TccCSharp; Data Source=" + Environment.MachineName + "\\SQLExpress";
        }
    }
}
