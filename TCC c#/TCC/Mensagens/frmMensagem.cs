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

namespace TCC.Mensagens
{
    public partial class frmMensagem : Form
    {
        //
        //
        //
        // A aba Mensagem é uma aba que tem interação com a aplicação em Java. A aplicação em Java
        // envia mensagens para a aplicação em C# e aqui as alterações pedidas na mensagem são
        // feitas
        //
        //
        //

        SqlConnection sqlCon;
        string connectionString = ConnectionString.StringConexao();
        string output = "";
        Random random = new Random();
        MetodosUtilitarios MetodosUtilitarios = new MetodosUtilitarios();
        int Row;
        int i;

        public frmMensagem()
        {
            InitializeComponent();
            ShowData();
            dtDisplay.Rows[0].Selected = false;            
            lblNumeroMensagens.Text = MetodosUtilitarios.MsgQntd().ToString();
            lblUsuario.Text = frmLogin.SetLoginName;
            lblNumeroMensagens.Text = MetodosUtilitarios.MsgQntd().ToString();
        }
               

        //pintar ao redor dos painels

        private void lblRedorDireito_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedorDireito.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void lblRedor_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedor.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnSair_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnSair.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnChangeProfile_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnChangeProfile.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void btnVoltar_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, btnVoltar.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
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
            lblNumeroMensagens.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.ForeColor = Color.White;
            lblIndicador.BackColor = Color.FromArgb(0, 102, 204);
            lblIndicador.ForeColor = Color.White;           
        }

        private void btnMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblIndicador.BackColor = Color.FromArgb(227, 227, 227);
            lblIndicador.ForeColor = Color.FromArgb(0, 102, 204);

        }

        private void lblNumeroMensagens_MouseEnter(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(0, 102, 204);
            btnMensagens.ForeColor = Color.White;
            lblNumeroMensagens.BackColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.ForeColor = Color.FromArgb(227, 227, 227);
        }

        private void lblNumeroMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMensagens.ForeColor = Color.FromArgb(0, 102, 204);
        }

        //navegação entre os formulários

        private void btnEditarUsuario_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarUsuario();
            f.Show();
            this.Close();
        }

        private void btnEditarServico_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarServico();
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

        private void btnNotas_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
            f.Show();
            this.Close();
        }

        private void btnVoltar_Click(object sender, EventArgs e)
        {
            Form f = new frmPaginaPrincipal();
            f.Show();
            this.Close();
        }

        //popula DataGridView
        public void ShowData()
        {
            sqlCon = new SqlConnection(connectionString);
            SqlDataAdapter da = new SqlDataAdapter("select id, qual_tabela, titulo from msg", sqlCon);
            DataTable dt = new DataTable();
            DataSet ds = new DataSet();

            da.Fill(dt);
            dtDisplay.DataSource = dt;



            sqlCon.Close();
        }

        public void SetTextBoxesByTitulo(string titulo)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "select qual_tabela, titulo, mensagem from msg where titulo='"+titulo+"'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                txtTabela.Text = dr["qual_tabela"].ToString();
                txtTitulo.Text = dr["titulo"].ToString();
                txtMensagem.Text = dr["mensagem"].ToString();
            }
        }

        public int CountMsg()
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

        private void dtDisplay_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            dtDisplay.Rows[e.RowIndex].Selected = true;
            string titulo = dtDisplay.Rows[e.RowIndex].Cells[2].Value.ToString();
            Row = dtDisplay.CurrentCell.RowIndex;
            i = dtDisplay.CurrentCell.RowIndex;
            SetTextBoxesByTitulo(titulo);
            btnNext.Enabled = true;
            btnPrev.Enabled = true;
        }

        private void btnNext_Click(object sender, EventArgs e)
        {
            if (i < CountMsg() -1)
            {
                i++;
                dtDisplay.Rows[Row].Selected = false;
                Row++;
                dtDisplay.Rows[Row].Selected = true;
                string titulo = dtDisplay.Rows[Row].Cells[2].Value.ToString();
                SetTextBoxesByTitulo(titulo);
            }

            


        }

        private void btnPrev_Click(object sender, EventArgs e)
        {
            
            if (i >= 1)
            {
                i--;
                dtDisplay.Rows[Row].Selected = false;
                Row--;
                dtDisplay.Rows[Row].Selected = true;
                string titulo = dtDisplay.Rows[Row].Cells[2].Value.ToString();
                SetTextBoxesByTitulo(titulo);
            }        
        }
                
        private void btnDeletar_Click(object sender, EventArgs e)
        {
            DeleteByTitulo(txtTitulo.Text);
            txtTabela.Text = "";
            txtTitulo.Text = "";
            txtMensagem.Text = "";
            ShowData();
        }

        public void DeleteByTitulo(string titulo)
        {
            sqlCon = new SqlConnection(connectionString);
            sqlCon.Open();
            string query = "delete from msg where titulo='"+titulo+"'";
            SqlCommand cmd = new SqlCommand(query, sqlCon);
            cmd.ExecuteNonQuery();
        }
                
    } 
}
