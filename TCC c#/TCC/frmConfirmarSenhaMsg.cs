using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TCC
{
    public partial class frmConfirmarSenhaMsg : Form
    {
        MetodosUtilitarios metodos = new MetodosUtilitarios();

        public static string Confirmacao;

        public frmConfirmarSenhaMsg()
        {
            InitializeComponent();
        }

        private void btnConfirmar_Click(object sender, EventArgs e)
        {
            if (txtSenha.Text == metodos.SelectAdmPasswordByLoginName(frmLogin.SetLoginName).Replace(" ",""))
            {
                Confirmacao = "ok";
                Form f = new EditarDadosForms.frmEditarAdm();
                f.ShowDialog();
                this.Close();
                
            }
            //SelectAdmPasswordByName(frmLogin.SetLoginName);
        }


    }
}
