using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TCC.EditarDadosForms
{
    public partial class frmEditarUsuario : Form
    {
        SqlConnection sqlCon;
        string connectionString = ConnectionString.StringConexao();
        Random random = new Random();
        MetodosUtilitarios MetodosUtilitarios = new MetodosUtilitarios();        

        public frmEditarUsuario()
        {
            InitializeComponent();
            
            this.FormBorderStyle = FormBorderStyle.FixedSingle;                              
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
            lblIndicador.BackColor = Color.FromArgb(0, 102, 204);
            lblIndicador.ForeColor = Color.White;
        }

        private void btnEditarUsuario_MouseLeave(object sender, EventArgs e)
        {
            btnEditarUsuario.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarUsuario.ForeColor = Color.FromArgb(0, 102, 204);
            lblIndicador.BackColor = Color.FromArgb(227, 227, 227);
            lblIndicador.ForeColor = Color.FromArgb(0, 102, 204);
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
            lblNumeroMensagens.ForeColor = Color.FromArgb(227, 227, 227);
        }

        private void btnMensagens_MouseLeave(object sender, EventArgs e)
        {
            btnMensagens.BackColor = Color.FromArgb(227, 227, 227);
            btnMensagens.ForeColor = Color.FromArgb(0, 102, 204);
            lblNumeroMensagens.BackColor = Color.FromArgb(227, 227, 227);
            lblNumeroMensagens.ForeColor = Color.FromArgb(0, 102, 204);
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

        private void btnSair_Click(object sender, EventArgs e)
        {
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
            Form f = new Mensagens.frmNotas();
            f.Show();
            this.Close();
        }

        private void btnEditarServico_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarServico();
            f.Show();
            this.Close();
        }

        private void btnVoltar_Click(object sender, EventArgs e)
        {
            Form f = new frmPaginaPrincipal();
            f.Show();
            this.Close();
        }

        private void btnChangeProfile_Click(object sender, EventArgs e)
        {
            Form f = new frmLogin();
            f.Show();
            this.Close();
        }



        private void dtDisplay_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 0 && e.RowIndex >= 0)
            {
                int ID = int.Parse(dtDisplay.Rows[e.RowIndex].Cells[1].Value.ToString());
                DialogResult result = MessageBox.Show("Você quer mesmo deletar este usuário?", "Confirmação", MessageBoxButtons.OKCancel);
                if (result == DialogResult.OK)
                {
                    MetodosUtilitarios.DeleteByID(ID, "Usuario");
                    ShowData();
                }

            }
        }

        //popula o DataGridView
        public void ShowData()
        {            
            sqlCon = new SqlConnection(connectionString);
            SqlDataAdapter da = new SqlDataAdapter("select id_usu,nome_usu,senha,dtNasc,endereco,numero,complemento,cpf,telefone,email from Usuario", sqlCon);
            DataTable dt = new DataTable();
            DataSet ds = new DataSet();
            
            da.Fill(dt);
            dtDisplay.DataSource = dt;
                 
                      

            sqlCon.Close();
        }



        //seleciona a linha na qual tiver o ID passado como parâmetro
        public void SelectUsuarioByID(string id)
        {
            int i;
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.UsuarioQntd();

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[1].Value.ToString().Replace(" ", "") == id.ToString().Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        //seleciona a linha na qual tiver o nome passado como parâmetro
        public void SelectUsuarioByName(string nome)
        {
            int i;
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.UsuarioQntd();

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[3].Value.ToString().Replace(" ", "") == nome.Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        private void btnPesquisar_Click_1(object sender, EventArgs e)
        {
            if (txtNome.Text != "" && txtID.Text != "")
            {
                SelectUsuarioByID(txtID.Text);
            }

            if (txtNome.Text != "" && txtID.Text == "")
            {
                SelectUsuarioByName(txtNome.Text);
            }

            if (txtNome.Text == "" && txtID.Text != "")
            {
                SelectUsuarioByID(txtID.Text);
            }
        }              


        private void dtDisplay_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            if(dtDisplay.CurrentRow != null)
            {
                using (SqlConnection sqlCon = new SqlConnection(connectionString))
                {
                    //explicação do procedimento "AddOrEditUsuario" está na consulta "TccCSharp"
                    int randomnumber = random.Next();
                    int id = MetodosUtilitarios.UltimoUsuario() + 1;
                    sqlCon.Open();
                    DataGridViewRow dgvRow = dtDisplay.CurrentRow;
                    SqlCommand cmd = new SqlCommand("AddOrEditUsuario", sqlCon);
                    cmd.CommandType = CommandType.StoredProcedure;

                    if (dgvRow.Cells["txtIDdgv"].Value == DBNull.Value)
                        cmd.Parameters.AddWithValue("@id_usu", 0);
                    else
                        cmd.Parameters.AddWithValue("@id_usu", Convert.ToInt32(dgvRow.Cells["txtIDdgv"].Value.ToString().Replace(" ","")));

                    //dgvRow.Cells["txtIDdgv"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtIDdgv"].Value.ToString()
                    
                    cmd.Parameters.AddWithValue("@nome_usu", dgvRow.Cells["txtNomedgv"].Value == DBNull.Value ? "" : dgvRow.Cells["txtNomedgv"].Value.ToString());
                    cmd.Parameters.AddWithValue("@senha", dgvRow.Cells["txtSenhadgv"].Value == DBNull.Value ? randomnumber.ToString() : dgvRow.Cells["txtSenhadgv"].Value.ToString());
                    cmd.Parameters.AddWithValue("@dtNasc", dgvRow.Cells["txtDtNasc"].Value == DBNull.Value ? "" : dgvRow.Cells["txtDtNasc"].Value.ToString());
                    cmd.Parameters.AddWithValue("@endereco", dgvRow.Cells["txtEndereco"].Value == DBNull.Value ? "" : dgvRow.Cells["txtEndereco"].Value.ToString());
                    cmd.Parameters.AddWithValue("@numero", Convert.ToInt32((dgvRow.Cells["txtNumero"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtNumero"].Value.ToString()).Replace(" ","")));
                    cmd.Parameters.AddWithValue("@complemento", dgvRow.Cells["txtComplemento"].Value == DBNull.Value ? "" : dgvRow.Cells["txtComplemento"].Value.ToString());
                    cmd.Parameters.AddWithValue("@cpf", dgvRow.Cells["txtCpf"].Value == DBNull.Value ? "" : dgvRow.Cells["txtCpf"].Value.ToString());
                    cmd.Parameters.AddWithValue("@telefone", dgvRow.Cells["txtTelefone"].Value == DBNull.Value ? "" : dgvRow.Cells["txtTelefone"].Value.ToString());
                    cmd.Parameters.AddWithValue("@email", dgvRow.Cells["txtEmail"].Value == DBNull.Value ? "" : dgvRow.Cells["txtEmail"].Value.ToString());
                    
                                        
                    //https://www.youtube.com/watch?v=cQQy_IfFddg

                    cmd.ExecuteNonQuery();
                    ShowData();
                }
            }
        }

        private void frmEditarUsuario_Load(object sender, EventArgs e)
        {
            ShowData();
        }

        
    }
}
