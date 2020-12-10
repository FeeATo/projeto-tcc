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

namespace TCC.EditarDadosForms
{
    public partial class frmEditarPrestador : Form
    {        
        
        string connectionString = ConnectionString.StringConexao();
        Random random = new Random();
        MetodosUtilitarios MetodosUtilitarios = new MetodosUtilitarios();        
        int i;

        public frmEditarPrestador()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.FixedSingle;

            lblUsuario.Text = frmLogin.SetLoginName;
            lblNumeroMensagens.Text = MetodosUtilitarios.MsgQntd().ToString();

        }        

        //navegação entre os formulários

        private void btnEditarUsuario_Click(object sender, EventArgs e)
        {
            Form f = new EditarDadosForms.frmEditarUsuario();
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

        private void btnMensagens_Click(object sender, EventArgs e)
        {
            Form f = new Mensagens.frmMensagem();
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
        
        //pintar ao redor dos painels

        private void lblRedor_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedor.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
        }

        private void lblRedorDireito_Paint(object sender, PaintEventArgs e)
        {
            ControlPaint.DrawBorder(e.Graphics, lblRedorDireito.DisplayRectangle, Color.FromArgb(191, 191, 191), ButtonBorderStyle.Solid);
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

        //houver e leave

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
        //
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
        //
        private void btnEditarPrestador_MouseEnter(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(0, 102, 204);
            btnEditarPrestador.ForeColor = Color.White;
            lblIndicador.BackColor = Color.FromArgb(0, 102, 204);
            lblIndicador.ForeColor = Color.White;
        }

        private void btnEditarPrestador_MouseLeave(object sender, EventArgs e)
        {
            btnEditarPrestador.BackColor = Color.FromArgb(227, 227, 227);
            btnEditarPrestador.ForeColor = Color.FromArgb(0, 102, 204);
            lblIndicador.BackColor = Color.FromArgb(227, 227, 227);
            lblIndicador.ForeColor = Color.FromArgb(0, 102, 204);
        }
        //
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
        //
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
        //
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
        //
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

        //popula o DataGridView
        public void ShowData()
        {
            using (SqlConnection sqlCon = new SqlConnection(connectionString))
            {
                sqlCon.Open();
                SqlDataAdapter da = new SqlDataAdapter("select id_prestserv, id_plano, nome_prestserv, senha, dtNasc, tipo_serv, endereco, numero, complemento, cpf, telefone, email, prestImg from PrestServ", sqlCon);
                DataTable dt = new DataTable();
                DataSet ds = new DataSet();

                da.Fill(ds, "PrestServ");

                DataGridViewImageColumn photoColumn = new DataGridViewImageColumn();

                dtDisplay.DataSource = ds.Tables["PrestServ"];
                photoColumn.DataPropertyName = "prestImg";
                photoColumn.Width = 65;

                photoColumn.HeaderText = "Imagem";
                photoColumn.ReadOnly = true;
                photoColumn.ImageLayout = DataGridViewImageCellLayout.Zoom;
                if (i == 0)
                {
                    dtDisplay.Columns.Insert(2, photoColumn);
                    i++;
                }

                dtDisplay.Columns[dtDisplay.Columns.Count - 1].Visible = false;

                sqlCon.Close();
            }
        }
                
        //seleciona a linha na qual tiver o nome passado como parâmetro
        public void SelectPrestServByName(string nome)
        {
            int i;
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.PrestServQntd();

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[4].Value.ToString().Replace(" ", "") == nome.Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        //seleciona a linha na qual tiver o ID passado como parâmetro
        public void SelectPrestServByID(string id)
        {
            int i;
            MetodosUtilitarios count = new MetodosUtilitarios();
            int qtnd = count.PrestServQntd();

            for (i = 0; i < qtnd; i++)
            {
                dtDisplay.Rows[i].Selected = false;

                if (dtDisplay.Rows[i].Cells[1].Value.ToString().Replace(" ", "") == id.ToString().Replace(" ", ""))
                {

                    dtDisplay.Rows[i].Selected = true;
                }
            }
        }

        //deleta a linha de acordo com qual linha foi clicada
        private void dtDisplay_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 0 && e.RowIndex >= 0)
            {
                int ID = int.Parse(dtDisplay.Rows[e.RowIndex].Cells[1].Value.ToString());
                DialogResult result = MessageBox.Show("Você quer mesmo deletar este usuário?", "Confirmação", MessageBoxButtons.OKCancel);
                if (result == DialogResult.OK)
                {
                    MetodosUtilitarios.DeleteByID(ID, "PrestServ");
                    ShowData();
                }

            }
        }

        //Altera ou adiciona valor valores no DataGridView
        private void dtDisplay_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            if (dtDisplay.CurrentRow != null)
            {
                using (SqlConnection sqlConn = new SqlConnection(connectionString))
                {
                    //explicação do procedimento "AddOrEditPrestServ" está na consulta "TccCSharp"

                    int randomnumber = random.Next();
                    int id = MetodosUtilitarios.UltimoPrestServ() + 1;
                    sqlConn.Open();
                    DataGridViewRow dgvRow = dtDisplay.CurrentRow;
                    SqlCommand cmd = new SqlCommand("AddOrEditPrestServ", sqlConn);
                    cmd.CommandType = CommandType.StoredProcedure;

                    if (dgvRow.Cells["txtIDprestadordgv"].Value == DBNull.Value)
                        cmd.Parameters.AddWithValue("@id_prestServ", 0);
                    else
                        cmd.Parameters.AddWithValue("@id_prestServ", Convert.ToInt32(dgvRow.Cells["txtIDprestadordgv"].Value.ToString().Replace(" ", "")));

                    //dgvRow.Cells["txtIDdgv"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtIDdgv"].Value.ToString()

                    cmd.Parameters.AddWithValue("@id_plano", Convert.ToInt32((dgvRow.Cells["txtPlano"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtPlano"].Value.ToString()).Replace(" ", "")));
                    cmd.Parameters.AddWithValue("@nome_prestServ", dgvRow.Cells["txtNomedgv"].Value == DBNull.Value ? "" : dgvRow.Cells["txtNomedgv"].Value.ToString());
                    cmd.Parameters.AddWithValue("@senha", dgvRow.Cells["txtSenhadgv"].Value == DBNull.Value ? randomnumber.ToString() : dgvRow.Cells["txtSenhadgv"].Value.ToString());
                    cmd.Parameters.AddWithValue("@dtNasc", dgvRow.Cells["txtDtNasc"].Value == DBNull.Value ? "" : dgvRow.Cells["txtDtNasc"].Value.ToString());
                    cmd.Parameters.AddWithValue("@endereco", dgvRow.Cells["txtEndereco"].Value == DBNull.Value ? "" : dgvRow.Cells["txtEndereco"].Value.ToString());
                    cmd.Parameters.AddWithValue("@numero", Convert.ToInt32((dgvRow.Cells["txtNumero"].Value == DBNull.Value ? "0" : dgvRow.Cells["txtNumero"].Value.ToString()).Replace(" ", "")));
                    cmd.Parameters.AddWithValue("@complemento", dgvRow.Cells["txtComplemento"].Value == DBNull.Value ? "" : dgvRow.Cells["txtComplemento"].Value.ToString());
                    cmd.Parameters.AddWithValue("@cpf", dgvRow.Cells["txtCpf"].Value == DBNull.Value ? "" : dgvRow.Cells["txtCpf"].Value.ToString());
                    cmd.Parameters.AddWithValue("@telefone", dgvRow.Cells["txtTelefone"].Value == DBNull.Value ? "" : dgvRow.Cells["txtTelefone"].Value.ToString());
                    cmd.Parameters.AddWithValue("@email", dgvRow.Cells["txtEmail"].Value == DBNull.Value ? "" : dgvRow.Cells["txtEmail"].Value.ToString());
                    cmd.Parameters.AddWithValue("@tipo_serv", dgvRow.Cells["txtTipoServ"].Value == DBNull.Value ? "" : dgvRow.Cells["txtTipoServ"].Value.ToString());


                    //https://www.youtube.com/watch?v=cQQy_IfFddg                                      

                    cmd.ExecuteNonQuery();                    
                    ShowData();
                }
            }
                       
            
        }

        private void btnPesquisar_Click(object sender, EventArgs e)
        {
            if (txtNome.Text != "" && txtID.Text != "")
            {
                SelectPrestServByID(txtID.Text);
            }

            if (txtNome.Text != "" && txtID.Text == "")
            {
                SelectPrestServByName(txtNome.Text);
            }

            if (txtNome.Text == "" && txtID.Text != "")
            {
                SelectPrestServByID(txtID.Text);
            }
        }

        private void frmEditarPrestador_Load(object sender, EventArgs e)
        {
            ShowData();
        }

    }
}
