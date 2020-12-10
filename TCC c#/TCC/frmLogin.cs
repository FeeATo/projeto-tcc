using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TCC.EditarDadosForms;

namespace TCC
{
    public partial class frmLogin : Form
    {
        string connectionString = "Password=etesp; Persist Security Info=True; User ID=sa; Initial Catalog=TccCSharp; Data Source=" + Environment.MachineName + "\\SQLExpress";
        SqlConnection sqlVerifica;

        public static string SetLoginName;

        public frmLogin()
        {
            InitializeComponent();
            this.txtLogin.AutoSize = false;
            this.txtLogin.Size = new System.Drawing.Size(272, 36);

            txtLogin.SelectionStart = 20;
            
        }
                     

        private void btnLogar_Click(object sender, EventArgs e)
        {
            string output = "";
            string ID = "";
            SqlConnection sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();

            string query = "select senha from ADM where login_adm='"+txtLogin.Text+"'";
            string selectID = "select id_adm from ADM where login_adm='" + txtLogin.Text + "'";

            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlCommand selectedID = new SqlCommand(selectID, sqlCon);

            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr["senha"].ToString();
            }

            if(txtSenha.Text == output.Replace(" ",""))
            {
                SetLoginName = txtLogin.Text;
                this.Hide();
                frmPaginaPrincipal form = new frmPaginaPrincipal();
                form.ShowDialog();
                
            }
            if(txtSenha.Text.Equals(output.Replace(" ", "")) == false)
            {
                label1.Text = output;
                lblMensagem.Text = "Senha incorreta!";
                lblMensagem.ForeColor = Color.LightCoral;
            }
            if(verificaExistencia() == 0)
            {
                lblMensagem.Text = "Login não existente!";
                lblMensagem.ForeColor = Color.LightBlue;
            }


        }

        public int verificaExistencia()
        {
            string output = "";
            sqlVerifica = new SqlConnection(connectionString);
            sqlVerifica.Open();
            string query = "select count(login_adm) from ADM where login_adm='" + txtLogin.Text + "'";
            SqlCommand cmd = new SqlCommand(query, sqlVerifica);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }
            if(output == "")
            {
                output = "0";
            }
            return Convert.ToInt32(output);
            
        }

        private void btnFechar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnMinimize_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
        }

        private void btnFechar_MouseEnter(object sender, EventArgs e)
        {
            btnFechar.BackgroundImage = ((System.Drawing.Image)(Properties.Resources.fechariconhover));
        }

        private void btnFechar_MouseLeave(object sender, EventArgs e)
        {
            btnFechar.BackgroundImage = ((System.Drawing.Image)(Properties.Resources.fecharicon1));
        }

        private void btnMinimize_MouseEnter(object sender, EventArgs e)
        {
            btnMinimize.BackgroundImage = ((System.Drawing.Image)(Properties.Resources.minimizeiconhover));
        }

        private void btnMinimize_MouseLeave(object sender, EventArgs e)
        {
            btnMinimize.BackgroundImage = ((System.Drawing.Image)(Properties.Resources.minimizeicon1));
        }

        
    }
}
