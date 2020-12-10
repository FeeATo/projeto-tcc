using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Web.UI.WebControls;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;


namespace TCC
{
    public partial class frmPaginaPrincipal : Form
    {
        SqlConnection sqlCon;
        string connectionString = "Password=etesp; Persist Security Info=True; User ID=sa; Initial Catalog=TccCSharp; Data Source=" + Environment.MachineName + "\\SQLExpress";
        string output = "";


        public frmPaginaPrincipal()
        {
            InitializeComponent();

            //Fala "bem vindo fulano"
            MetodosUtilitarios callName = new MetodosUtilitarios();
            lblNome.Text = "Bem-vindo " + callName.GetNameByLoginName(frmLogin.SetLoginName.ToString()) + "!";
            //lblNome.Text = callName.GetNameByLoginName(frmLogin.SetLoginName.ToString());

            this.lblHora.Text = DateTime.Now.ToString();

            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select count(id) from msg";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                output = dr[0].ToString();
            }

            lblNumeroMsg.Text = output;

        }

        

        private void btnSair_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnSair.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnChangeProfile_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnChangeProfile.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void lblRedor_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedor.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void lblRedorDireito_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedorDireito.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnSair_Click(object sender, EventArgs e)
        {
            DialogResult sair = MessageBox.Show("Deseja mesmo sair? 💔😓", "Confirmação ", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
            if (sair == DialogResult.OK)
            {
                this.Close();
            }
            
        }

        private void btnChangeProfile_Click(object sender, EventArgs e)
        {
            DialogResult change = MessageBox.Show("Deseja mesmo trocar de perfil?", "Confirmação", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
            if (change == DialogResult.OK)
            {
                this.Hide();
                frmLogin login = new frmLogin();
                login.ShowDialog();

            }
        }

        //navegação dos botoes

        private void btnEditarUsuario_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarUsuario();
            f.Show();
            this.Close();
        }

        private void btnEditarPrestador_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarPrestador();
            f.Show();
            this.Close();
        }

        private void btnEditarAdm_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarAdm();
            f.Show();
            this.Close();
        }

        private void btnEditarServico_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarServico();
            f.Show();
            this.Close();
        }

        private void btnNotas_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmNotas();
            f.Show();
            this.Close();
        }

        private void btnMensagens_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
            f.Show();
            this.Close();
        }

        private void lblNumeroMsg_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
            f.Show();
            this.Close();
        }

        //hover e leave

        private void btnEditarUsuario_MouseEnter(object sender, EventArgs e)
        {
            btnEditarUsuario.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarUsuario.ForeColor = Color.White;
        }

        private void btnEditarUsuario_MouseLeave(object sender, EventArgs e)
        {
            btnEditarUsuario.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarUsuario.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnEditarServico_MouseEnter(object sender, EventArgs e)
        {
            btnEditarServico.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarServico.ForeColor = Color.White;
        }

        private void btnEditarServico_MouseLeave(object sender, EventArgs e)
        {
            btnEditarServico.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarServico.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnEditarAdm_MouseEnter(object sender, EventArgs e)
        {
            btnEditarAdm.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarAdm.ForeColor = Color.White;
        }

        private void btnEditarAdm_MouseLeave(object sender, EventArgs e)
        {
            btnEditarAdm.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarAdm.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnEditarPrestador_MouseEnter(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarPrestador.ForeColor = Color.White;
        }

        private void btnEditarPrestador_MouseLeave(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarPrestador.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnNotas_MouseEnter(object sender, EventArgs e)
        {
            btnNotas.BackColor = Color.FromArgb(0, 102, 204);
            btnNotas.ForeColor = Color.White;
        }

        private void btnNotas_MouseLeave(object sender, EventArgs e)
        {
            btnNotas.BackColor = Color.FromArgb(227, 227, 227);
            btnNotas.ForeColor = Color.FromArgb(0, 102, 204);
        }

        private void btnMensagens_MouseEnter(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(0, 102, 204);
            btnMensagens.ForeColor = Color.White;
            lblNumeroMsg.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMsg.ForeColor = Color.FromArgb(227, 227, 227);
        }

        private void btnMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMsg.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMsg.ForeColor = Color.FromArgb(0, 102, 204);
            
        }

        private void lblNumeroMsg_MouseEnter(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(0, 102, 204);
            btnMensagens.ForeColor = Color.White;
            lblNumeroMsg.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMsg.ForeColor = Color.FromArgb(227, 227, 227);
        }
    

        private void lblNumeroMensagem_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMsg.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMsg.ForeColor = Color.FromArgb(0, 102, 204);
        }

        
    }
}
